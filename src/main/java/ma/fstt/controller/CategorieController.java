package ma.fstt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.fstt.entity.Article;
import ma.fstt.entity.Categorie;

import ma.fstt.repository.ArticleRepository;
import ma.fstt.repository.CategorieRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CategorieController {
	@Autowired
	CategorieRepository catRep;
	@Autowired
	ArticleRepository repArticle;
	@GetMapping("/Categories")
	public ResponseEntity<List<Categorie>> getAllArticles() {
		try {
			List<Categorie> list = catRep.findAll();
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/Categories")
	public ResponseEntity<Categorie> save(@RequestBody Categorie a){
		try {
			return new ResponseEntity<>(catRep.save(a),HttpStatus.CREATED);
			
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/Categories")
	public ResponseEntity<Categorie> updateCategorie(@RequestBody Categorie a) {
		try {
			return new ResponseEntity<>(catRep.save(a), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/Categories/{id}")
	public ResponseEntity<HttpStatus> deleteCategorie(@PathVariable Long id) {
		try {
			Optional<Categorie> a = catRep.findById(id);
			if (a.isPresent()) {
				catRep.delete(a.get());
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/Categories/{id}")
	public Optional<Categorie> getOneCategorie(@PathVariable Long id) {
		Optional<Categorie> a = catRep.findById(id);
		return a;
	}
	@GetMapping("/Categories/{id}/articles")
	public  ResponseEntity<List<Article>> recherchArtByIdCat(@PathVariable Long id){

		List<Article> list = repArticle.findAll();
		List<Article> l = new ArrayList<Article>();
		for (Article article : list) {
			if(article.getId_ctg()==id) {
				l.add(article);
			}
		}
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
}
