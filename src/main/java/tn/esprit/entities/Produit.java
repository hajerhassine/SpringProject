package tn.esprit.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Produit implements Serializable{
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idproduit ;
	private String codeproduit ;
	private String libelleproduit ;
	private float prixunitaire ;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> fournisseurs;
	//@JsonBackReference(value="user-movement")
	//@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private Rayon rayon;
	//@JsonBackReference
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private Stock stock;
	//@JsonBackReference
	@OneToOne
	private DetailProduit detail ; 
	//@JsonBackReference
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy="produit",fetch=FetchType.EAGER)

	private Set<DetailFacture> detailfacture;

public long getIdproduit() {
	return idproduit;
}

public void setIdproduit(long idproduit) {
	this.idproduit = idproduit;
}

public String getCodeproduit() {
	return codeproduit;
}

public void setCodeproduit(String codeproduit) {
	this.codeproduit = codeproduit;
}

public String getLibelleproduit() {
	return libelleproduit;
}

public void setLibelleproduit(String libelleproduit) {
	this.libelleproduit = libelleproduit;
}

public float getPrixunitaire() {
	return prixunitaire;
}

public void setPrixunitaire(float prixunitaire) {
	this.prixunitaire = prixunitaire;
}

public Set<Fournisseur> getFournisseurs() {
	return fournisseurs;
}

public void setFournisseurs(Set<Fournisseur> fournisseurs) {
	this.fournisseurs = fournisseurs;
}

public Rayon getRayon() {
	return rayon;
}

public void setRayon(Rayon rayon) {
	this.rayon = rayon;
}

public Stock getStock() {
	return stock;
}

public void setStock(Stock stock) {
	this.stock = stock;
}

public DetailProduit getDetail() {
	return detail;
}

public void setDetail(DetailProduit detail) {
	this.detail = detail;
}

public Set<DetailFacture> getDetailfacture() {
	return detailfacture;
}

public void setDetailfacture(Set<DetailFacture> detailfacture) {
	this.detailfacture = detailfacture;
}

public Produit(long idproduit, String codeproduit, String libelleproduit, float prixunitaire,
		Set<Fournisseur> fournisseurs, Rayon rayon, Stock stock, DetailProduit detail,
		Set<DetailFacture> detailfacture) {
	super();
	this.idproduit = idproduit;
	this.codeproduit = codeproduit;
	this.libelleproduit = libelleproduit;
	this.prixunitaire = prixunitaire;
	this.fournisseurs = fournisseurs;
	this.rayon = rayon;
	this.stock = stock;
	this.detail = detail;
	this.detailfacture = detailfacture;
}

public Produit() {
	super();
	
}




}
