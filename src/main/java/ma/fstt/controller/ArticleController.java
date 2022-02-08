package ma.fstt.controller;

import ma.fstt.entity.Article;
import ma.fstt.repository.ArticleRepository;

import java.util.List;

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
import java.util.Optional;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ArticleController {
	@Autowired
	ArticleRepository repArticle;
	

	@GetMapping("/Articles")
	public ResponseEntity<List<Article>> getAllArticles() {
		try {
			List<Article> list = repArticle.findAll();
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/Articles/{id}")
	public ResponseEntity<Article> getArticle(@PathVariable Long id) {
		Optional<Article> a = repArticle.findById(id);
		
		if (a.isPresent()) {
			return new ResponseEntity<>(a.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/Articles")
	public ResponseEntity<Article> save(@RequestBody Article a){
		try {
			return new ResponseEntity<>(repArticle.save(a),HttpStatus.CREATED);
			
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/Articles")
	public ResponseEntity<Article> updateArticle(@RequestBody Article a) {
		try {
			return new ResponseEntity<>(repArticle.save(a), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/Articles/{id}")
	public ResponseEntity<HttpStatus> deleteArticle(@PathVariable Long id) {
		try {
			Optional<Article> a = repArticle.findById(id);
			if (a.isPresent()) {
				repArticle.delete(a.get());
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
