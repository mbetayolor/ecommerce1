package bude.e_commerce1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@Entity
@NoArgsConstructor @AllArgsConstructor @Data @ToString

public class Product implements Serializable {
    @Id   @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String description;
    private double  curentprice ; //prix actuelle
    private boolean promotion ; //indique si le produit est en promotion
    private  boolean selected; //produits selectionner
    private  boolean available ; //indiquer si le produict est disponible en stock
    private String photoName; // dans la bd on stoke le chemin vers la photo
    @ManyToOne //un produit appartient a une seul cathegorie
    private Cathegory cathegory;
    @Transient // l'attribut n'entre pas dans la bd
    private int quantity=1;



}
