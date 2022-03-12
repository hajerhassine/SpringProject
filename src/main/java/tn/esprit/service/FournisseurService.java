package tn.esprit.service;

import java.util.List;

import tn.esprit.entities.Fournisseur;

public interface FournisseurService {
	
	
	List<Fournisseur> retrieveAllFournisseur();
	Fournisseur addFournisseur(Fournisseur f);
	void deleteFournisseur(Long id);
	Fournisseur updateFournisseur(Fournisseur fournisseur);
	Fournisseur retrieveFournisseur(Long id);
	void fournisseurpdf (long idfournisseur) ;

}
