package ma.fstt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="categorie")
@Setter
@Getter
@ToString
public class Categorie  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(columnDefinition = "SERIAL")
	private Long id;
	private String designation;
	
	/* @OneToMany(mappedBy = "categorie")
	private Set<Article> articles;
	 
	 
	public Set<Article> getArticles() {
		return articles;
	}
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	
	
}
