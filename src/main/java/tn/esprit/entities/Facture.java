package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity 
@Table( name = "Facture") 
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="facture")
public class Facture implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idfacture ;
	private float montantremise;
	private float montantfacture;
	private boolean active;
	@Temporal (TemporalType.DATE)
	private Date datefacture ;
	//@JsonBackReference(value="user-movement")
	@JsonIgnore
	@ManyToOne
	private Client client ;
	//@JsonBackReference(value="facture")
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="facture", fetch=FetchType.LAZY)
	private Set<DetailFacture> detailfacture ;
	
	


	public Facture(long idfacture, float montantremise, float montantfacture, boolean active, Date datefacture,
			Client client, Set<DetailFacture> detailfacture) {
		super();
		this.idfacture = idfacture;
		this.montantremise = montantremise;
		this.montantfacture = montantfacture;
		this.active = active;
		this.datefacture = datefacture;
		this.client = client;
		this.detailfacture = detailfacture;
	}


	public Set<DetailFacture> getDetailfacture() {
		return detailfacture;
	}


	public void setDetailfacture(Set<DetailFacture> detailfacture) {
		this.detailfacture = detailfacture;
	}


	public Facture() {
		super();
		
	}
	

	public Facture(long idfacture, float montantremise, float montantfacture, boolean active, Date datefacture
			) {
		super();
		this.idfacture = idfacture;
		this.montantremise = montantremise;
		this.montantfacture = montantfacture;
		this.active = active;
		this.datefacture = datefacture;
		
	}


	public Facture(long idfacture, float montantremise, float montantfacture, boolean active, Date datefacture,
			Client client) {
		super();
		this.idfacture = idfacture;
		this.montantremise = montantremise;
		this.montantfacture = montantfacture;
		this.active = active;
		this.datefacture = datefacture;
		this.client = client;
		
	}

	public long getIdfacture() {
		return idfacture;
	}

	public void setIdfacture(long idfacture) {
		this.idfacture = idfacture;
	}

	public float getMontantremise() {
		return montantremise;
	}

	public void setMontantremise(float montantremise) {
		this.montantremise = montantremise;
	}

	public float getMontantfacture() {
		return montantfacture;
	}

	public void setMontantfacture(float montantfacture) {
		this.montantfacture = montantfacture;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDatefacture() {
		return datefacture;
	}

	public void setDatefacture(Date datefacture) {
		this.datefacture = datefacture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	
	

}
