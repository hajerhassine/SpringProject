package tn.esprit.service;

import java.util.Date;
import java.util.List;

import tn.esprit.entities.Facture;
import tn.esprit.entities.Produit;
import tn.esprit.entities.Rayon;

public interface FactureService {
	List<Facture> retrieveAllFactures();
	void cancelFacture(Long id);
	Facture retrieveFacture(Long id);
	Facture addFacture(Facture f);
	//pdf
		 List<Facture> findAll();
	//Facture retrieveDateFacture(Date datefacture,Long id );
		 List<Date> getDateFacture();
		
		 Facture addFacture(Facture f,Long idClient);
		 public Long addfacture(Facture f,Long clientid);
}
