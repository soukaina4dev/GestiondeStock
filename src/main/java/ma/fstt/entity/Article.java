package ma.fstt.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="article")
@Setter
@Getter
@ToString

public class Article{


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(columnDefinition = "SERIAL")
	private Long id;
	private String libelle;
	private double Pu;
	private Long id_ctg;
/*
	@ManyToOne()
    @JoinColumn(name = "id_ctg", nullable = false)
    private Categorie categorie;
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPu() {
		return Pu;
	}
	public void setPu(double pu) {
		Pu = pu;
	}
	public Long getId_ctg() {
		return id_ctg;
	}
	public void setId_ctg(Long id_ctg) {
		this.id_ctg = id_ctg;
	}



}
