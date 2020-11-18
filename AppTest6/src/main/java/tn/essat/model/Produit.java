package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Produit {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private float prix;
	@ManyToOne
	@JoinColumn(name="mag_id")
	private Magasin mag;
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(Integer id, String nom, float prix, Magasin mag) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.mag = mag;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public Magasin getMag() {
		return mag;
	}
	public void setMag(Magasin mag) {
		this.mag = mag;
	}

}
