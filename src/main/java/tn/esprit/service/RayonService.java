package tn.esprit.service;

import java.util.List;


import tn.esprit.entities.Rayon;

public interface RayonService {
	List<Rayon> retrieveAllRayon();
    Rayon addRayon(Rayon r);
	void deleteRayon(Long id);
	Rayon updateRayon(Rayon rayon);
	Rayon retrieveRayon(Long id);
	//pdf
	 List<Rayon> findAll();
	 
	 
	 List affichequantiteproduitbyproduct_category_byrayon();
	 List affichequantiterayonbyproductcategory();
	 void assignProduittoRayon(Long idproduit,Long idrayon);
}
