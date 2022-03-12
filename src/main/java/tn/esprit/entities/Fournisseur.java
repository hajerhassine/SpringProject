package tn.esprit.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 

public class Fournisseur implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idfournisseur ;
	private String codefournisseur ;
	private String libellefournisseur ;
	private long  numerofournisseur ;
	public long getIdfournisseur() {
		return idfournisseur;
	}
	public void setIdfournisseur(long idfournisseur) {
		this.idfournisseur = idfournisseur;
	}
	public String getCodefournisseur() {
		return codefournisseur;
	}
	public void setCodefournisseur(String codefournisseur) {
		this.codefournisseur = codefournisseur;
	}
	public String getLibellefournisseur() {
		return libellefournisseur;
	}
	public void setLibellefournisseur(String libellefournisseur) {
		this.libellefournisseur = libellefournisseur;
	}
	public long getNumerofournisseur() {
		return numerofournisseur;
	}
	public void setNumerofournisseur(long numerofournisseur) {
		this.numerofournisseur = numerofournisseur;
	}
	public Fournisseur(long idfournisseur, String codefournisseur, String libellefournisseur, long numerofournisseur) {
		super();
		this.idfournisseur = idfournisseur;
		this.codefournisseur = codefournisseur;
		this.libellefournisseur = libellefournisseur;
		this.numerofournisseur = numerofournisseur;
	}
	@Override
	public String toString() {
		return "Fournisseur [idfournisseur=" + idfournisseur + ", codefournisseur=" + codefournisseur
				+ ", libellefournisseur=" + libellefournisseur + ", numerofournisseur=" + numerofournisseur + "]";
	}
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
}
