package ma.fstt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.fstt.entity.Article;

@Repository

public interface ArticleRepository extends JpaRepository<Article,Long>{

}
