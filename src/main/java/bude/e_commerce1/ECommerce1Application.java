package bude.e_commerce1;

import bude.e_commerce1.dao.CathegoryRepositori;
import bude.e_commerce1.dao.ProductRepository;
import bude.e_commerce1.entities.Cathegory;
import bude.e_commerce1.entities.Product;
import ch.qos.logback.core.testUtil.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class ECommerce1Application implements CommandLineRunner {

  @Autowired //spring fais lingection de dependence
    private ProductRepository productRepository;
  @Autowired
  private CathegoryRepositori cathegoryRepositori;
  @Autowired
  private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(ECommerce1Application.class, args);
        System.out.println("hello world");
    }

    @Override
    public void run(String... args) throws Exception {
 repositoryRestConfiguration.exposeIdsFor(Product.class,Cathegory.class);// expose l'id des cathegorie et produit
//        System.out.print(System.getProperties());
        cathegoryRepositori.save(new Cathegory(null,"computer",null,null,null));
        cathegoryRepositori.save(new Cathegory(null,"printers",null,null,null));
        cathegoryRepositori.save(new Cathegory(null,"smart phone",null,null,null));
        cathegoryRepositori.save(new Cathegory(null,"tv",null,null,null));
        // je parcout le cathegorie et j'inserre les produits
        Random rnd= new Random();
        cathegoryRepositori.findAll().forEach( c->{

            for (int i=0;i<10;i++){
                Product p= new Product();
                p.setName(rnd.toString());
                p.setCurentprice(100+rnd.nextInt(1000000  ));
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setCathegory(c);
                p.setDescription(rnd.toString());
                // il ya deux maniere de gere les photos. soit on stoke la photo dans un dossier et son non dans la bd
                p.setPhotoName("unknonw.png"); //photoinconnue

                productRepository.save(p); //jenregistre le produit
                //sprindataRest par defaut naffiche lId des element generer en format json
            }

                }

        );
    }
}
