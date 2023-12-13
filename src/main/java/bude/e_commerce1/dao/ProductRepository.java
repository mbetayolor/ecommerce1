package bude.e_commerce1.dao;

import bude.e_commerce1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.nio.file.Paths;
import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProductRepository extends JpaRepository<Product, Long> {
    @RestResource(path = "/selctedProducts") //nom de la resource a rechercher
    public List<Product> findAllBySelectedIsTrue(); //selection tous les produits selectionner

    @RestResource(path = "/productbykey") //recherche de produit pas mot cle
////    @Query("select p from Product where  p.nane like :x")
////    public  List<Product> chercher(@Param("x") String mc);
    public List<Product> findAllByNameContains(@Param("mc") String mc); //ici on recher grace a un spring
 @RestResource(path="/promoProducts")
    public List<Product> findByPromotionIsTrue();

 @RestResource(path="/dispoProducts")
    public List<Product> findByAvailableIsTrue(); 
}

