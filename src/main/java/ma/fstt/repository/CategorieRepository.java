package ma.fstt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.fstt.entity.Categorie;
@Repository

public interface CategorieRepository extends JpaRepository<Categorie,Long>{

}
