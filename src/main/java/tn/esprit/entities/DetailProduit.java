package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

public class DetailProduit implements Serializable {
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long iddetailproduit ;
	@Temporal(TemporalType.DATE)
	private Date date_creation ;
	@Temporal(TemporalType.DATE)
	private Date date_dermodification ;
	@Enumerated(EnumType.STRING)
	private Categorieproduit categorieproduit ;
	@JsonIgnore
	@OneToOne(mappedBy="detail")
	private Produit produit ;
	public long getIddetailproduit() {
		return iddetailproduit;
	}
	public void setIddetailproduit(long iddetailproduit) {
		this.iddetailproduit = iddetailproduit;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public Date getDate_dermodification() {
		return date_dermodification;
	}
	public void setDate_dermodification(Date date_dermodification) {
		this.date_dermodification = date_dermodification;
	}
	public Categorieproduit getCategorieproduit() {
		return categorieproduit;
	}
	public void setCategorieproduit(Categorieproduit categorieproduit) {
		this.categorieproduit = categorieproduit;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	@Override
	public String toString() {
		return "DetailProduit [iddetailproduit=" + iddetailproduit + ", date_creation=" + date_creation
				+ ", date_dermodification=" + date_dermodification + ", categorieproduit=" + categorieproduit
				+ ", produit=" + produit + "]";
	}
	public DetailProduit(long iddetailproduit, Date date_creation, Date date_dermodification,
			Categorieproduit categorieproduit, Produit produit) {
		super();
		this.iddetailproduit = iddetailproduit;
		this.date_creation = date_creation;
		this.date_dermodification = date_dermodification;
		this.categorieproduit = categorieproduit;
		this.produit = produit;
	}
	public DetailProduit() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	

}
