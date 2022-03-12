package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "Stock") 
public class Stock implements Serializable {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private long idstock ;
private int quantite ;
private int quanite_min ; 
private String libellestock ;
//@JsonManagedReference
@OneToMany(cascade=CascadeType.ALL,mappedBy="stock")
private Set <Produit> produits;

public Stock() {
	super();
}

public Stock(long idstock, int quantite, int quanite_min, String libellestock, Set<Produit> produits) {
	super();
	this.idstock = idstock;
	this.quantite = quantite;
	this.quanite_min = quanite_min;
	this.libellestock = libellestock;
	this.produits = produits;
}


@Override
	public String toString() {
		return "Stock [idstock=" + idstock + ", quantite=" + quantite + ", quanite_min=" + quanite_min
				+ ", libellestock=" + libellestock + ", produits=" + produits + "]";
	}
public long getIdstock() {
		return idstock;
	}
	public void setIdstock(long idstock) {
		this.idstock = idstock;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getQuanite_min() {
		return quanite_min;
	}
	public void setQuanite_min(int quanite_min) {
		this.quanite_min = quanite_min;
	}
	public String getLibellestock() {
		return libellestock;
	}
	public void setLibellestock(String libellestock) {
		this.libellestock = libellestock;
	}
	public Set<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}



}
