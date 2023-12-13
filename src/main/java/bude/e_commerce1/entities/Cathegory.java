package bude.e_commerce1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@Entity //creation de la classe
@Data //generation des getter et setter automatique
@NoArgsConstructor//construncteur pas defaut
@AllArgsConstructor//constructeur avec parametre

// jpa est une api qui ne comporte que des anotation .por le use il faut donc une implementation de jpa(hbernate)
// spring use hibernate come imp par def de jpa
//jaxrs est une specifacation jee et jersey son implementation


public class Cathegory implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private String photo;
    private  String description;

    @OneToMany(mappedBy = "cathegory") //reletion entre produit et gathegorie (une cathegorie a plusieur produits et un produit a une seul cathegorie
    private Collection<Product> products;

}
