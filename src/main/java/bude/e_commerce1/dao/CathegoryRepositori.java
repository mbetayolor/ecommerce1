package bude.e_commerce1.dao;

import bude.e_commerce1.entities.Cathegory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource //c'est le web service generique(sadapte au donner) de spring
@CrossOrigin("*")
//la plus des api sont deja cree mais il vas souvent arriveer den coder d'autre
public interface CathegoryRepositori extends JpaRepository<Cathegory, Long> {
}
