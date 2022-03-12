package tn.esprit.service;

import java.util.List;


import tn.esprit.entities.DetailFacture;

public interface DetailFactureService {
	List<DetailFacture> retrieveAllDetailFacture();
	void deleteDetailFacture(Long id);
	DetailFacture retrieveDetailFactures(Long id);
	DetailFacture addDetailFacture(DetailFacture df);
	DetailFacture updateDetailFacture(DetailFacture df);
	List<DetailFacture>getDetailFactureByFacture(Long idfacture);
	void adddetailfacture(DetailFacture detailfacture,Long idproduit,Long idfacture);
}

