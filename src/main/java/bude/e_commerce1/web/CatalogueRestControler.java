package bude.e_commerce1.web;

import bude.e_commerce1.dao.CathegoryRepositori;
import bude.e_commerce1.dao.ProductRepository;
import bude.e_commerce1.entities.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin("*")
@RestController
public class CatalogueRestControler {
    // ici on vas ajouter des methodes
 private ProductRepository productRepository;

    public CatalogueRestControler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // requette por recuperer une photo
@GetMapping(path = "/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public  byte[] getphoto( @PathVariable("id")  Long id) throws Exception {
    Product p =productRepository.findById(id).get();
     return Files.readAllBytes(Paths.get(System.getProperty ("user.home")+"/photoecom1/u1/"+p.getPhotoName()));

     //@PathVariable("id")  permet dindiquer que le chemin est li chercher
    //roduces = MediaType.IMAGE_JPEG_VALUE specifie quon veux retouner une image
    // il n'y occun moyen de securiser les fichier du dossier statique
       }
       //method de changement de photo
    @PostMapping( path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws IOException {
        Product p=productRepository.findById((id)).get();
//        p.setPhotoName(file.getOriginalFilename());permet denregistrerune protoavec son non d'origine ce qui nest pas une bonnne pratique
        p.setPhotoName(id+".png");
        Files.write(Paths.get(System.getProperty("user.home")+"/photoecom1/u1/"+p.getPhotoName()),file.getBytes());
        productRepository.save(p);//mettre a jour le produits dans la bd



    }
}
