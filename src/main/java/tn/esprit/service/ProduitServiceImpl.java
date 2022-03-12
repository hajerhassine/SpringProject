package tn.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Facture;
import tn.esprit.entities.Produit;
import tn.esprit.entities.Rayon;
import tn.esprit.repository.FournisseurRepository;
import tn.esprit.repository.ProduitRepository;
import tn.esprit.repository.RayonRepository;
//import tn.esprit.repository.Stockrepository;
//import tn.esprit.repository.RayonRepository;

@Service
public class ProduitServiceImpl implements ProduitService{
	@Autowired
	ProduitRepository produitrepository ; 
	@Autowired
	RayonRepository  rayonRepository;
	
	@Autowired
	FournisseurRepository  fournisseurRepository;


	@Override
	public List<Produit> retrieveAllProducts() {
		List<Produit> products = (List<Produit>) produitrepository.findAll();
		return products;
	}
	
	
	@Override
	public List<Produit> getProduitByRayon(Long idrayon) {

		Rayon rayon= rayonRepository.findById(idrayon).get();
		return produitrepository.getProduitByRayon(rayon);
	}

	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit retrieveProduit(Long id) {
		Produit p = produitrepository.findById(id).get();
		return p;
	}

	

	@Override
	public void assignFournisseurToProduit(Long idfournisseur, Long idproduit) {
		// TODO Auto-generated method stub
	
	}


	@Override
	public List<Produit> TrieProduitASC() {
		return produitrepository.TrieProduitsASC();
	}


	@Override
	public List<Produit> TrieProduitDESC() {
		return produitrepository.TrieProduitsDESC();
	}


	//@Override
	//public List<Produit> retrieveProduitsByLibelle(String libelleproduit) {
	//	return produitrepository.ProduitsByLibelle(libelleproduit);
	//}
	






}
