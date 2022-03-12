package tn.esprit.entities;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

@Entity
public class DetailFacture implements Serializable  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
private long iddetailfacture ;
private int quantite ;
private float prixtotal ;
private float pourcentageremise; 
private float montantremise ;
@JsonIgnore
@ManyToOne
private Facture facture;
@JsonIgnore
@ManyToOne
private Produit produit ;
public long getIddetailfacture() {
	return iddetailfacture;
}
public void setIddetailfacture(long iddetailfacture) {
	this.iddetailfacture = iddetailfacture;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public float getPrixtotal() {
	return prixtotal;
}
public void setPrixtotal(float prixtotal) {
	this.prixtotal = prixtotal;
}
public float getPourcentageremise() {
	return pourcentageremise;
}
public void setPourcentageremise(float pourcentageremise) {
	this.pourcentageremise = pourcentageremise;
}
public float getMontantremise() {
	return montantremise;
}
public void setMontantremise(float montantremise) {
	this.montantremise = montantremise;
}
public Facture getFacture() {
	return facture;
}
public void setFacture(Facture facture) {
	this.facture = facture;
}
public Produit getProduit() {
	return produit;
}
public void setProduit(Produit produit) {
	this.produit = produit;
}
public DetailFacture(long iddetailfacture, int quantite, float prixtotal, float pourcentageremise, float montantremise,
		Facture facture, Produit produit) {
	super();
	this.iddetailfacture = iddetailfacture;
	this.quantite = quantite;
	this.prixtotal = prixtotal;
	this.pourcentageremise = pourcentageremise;
	this.montantremise = montantremise;
	this.facture = facture;
	this.produit = produit;
}
public DetailFacture() {
	super();
}


}
