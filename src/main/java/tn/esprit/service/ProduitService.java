package tn.esprit.service;

import java.util.List;

import tn.esprit.entities.Produit;

public interface ProduitService {
	List<Produit> retrieveAllProducts();

	Produit addProduit(Produit p, Long idRayon, Long idStock);

	Produit retrieveProduit(Long id);
	List<Produit> getProduitByRayon(Long idrayon);
	void assignFournisseurToProduit(Long idfournisseur, Long idproduit);
	List<Produit> TrieProduitASC();
	List<Produit> TrieProduitDESC();
	//List<Produit> retrieveProduitsByLibelle(String name);
}
