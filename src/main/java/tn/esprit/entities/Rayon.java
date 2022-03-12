package tn.esprit.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
public class Rayon implements Serializable {

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idrayon ;	
	private String coderayon ;
	private String libelle ;
	
	//@JsonBackReference(value="user-movement")
	@OneToMany(cascade=CascadeType.ALL,mappedBy="rayon" ,fetch=FetchType.LAZY)
	private Set <Produit> produits;
	
	
	
	
	public long getIdrayon() {
		return idrayon;
	}
	public void setIdrayon(long idrayon) {
		this.idrayon = idrayon;
	}
	public String getCoderayon() {
		return coderayon;
	}
	public void setCoderayon(String coderayon) {
		this.coderayon = coderayon;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Set<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	@Override
	public String toString() {
		return "Rayon [idrayon=" + idrayon + ", coderayon=" + coderayon + ", libelle="
				+ libelle + ", produits=" + produits + "]";
	}
	public Rayon(long idrayon, String coderayon, String libelle, Set<Produit> produits) {
		super();
		this.idrayon = idrayon;
		this.coderayon = coderayon;
		this.libelle = libelle;
		this.produits = produits;
	}
	public Rayon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
