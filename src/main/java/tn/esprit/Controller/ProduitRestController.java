package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import tn.esprit.entities.Facture;
import tn.esprit.entities.Produit;
import tn.esprit.service.FournisseurService;
import tn.esprit.service.ProduitService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class ProduitRestController {
	@Autowired
	ProduitService produitservice;
	
	@Autowired
	FournisseurService fournisseurtservice;
	
	
	//http://localhost:8089/SpringMVC/servlet/getallproduit
			@GetMapping("/getallproduit")
			public List<Produit> getProduit(){
				List <Produit> listproduit = produitservice.retrieveAllProducts();
				return listproduit;
				
			} 
			
			
	// URL: http://localhost:8089/SpringMVC/servlet/getproduitbyrayon/1
	@GetMapping("getproduitbyrayon/{idrayon}")
	@ResponseBody
public List<Produit> getProduitByRayon(@PathVariable("idrayon") Long idrayon){
	List<Produit> listproduit=produitservice.getProduitByRayon(idrayon);
	return listproduit;
	
}

	@ApiOperation(value = "affecter un fournisseur au produit.")
	@PutMapping("/assign-fournisseur/{produit}/{fournisseur}")
    @ResponseBody
   public void assignFournisseur(@PathVariable("produit") Long idproduit,@PathVariable("fournisseur") Long fournisseurId)
   {
     //  ProduitService.assignFournisseurToProduit(idfournisseur,idproduit);
    }
	
	// URL: http://localhost:8089/SpringMVC/servlet/getproduit/1
		@GetMapping("getproduit/{idproduit}")
		public Produit retrieveProduit(@PathVariable("idproduit") Long idproduit){
		return produitservice.retrieveProduit(idproduit);
			
		}
		
		
		// http://localhost:8089/SpringMVC/servlet/retrieveproduitASC
		@GetMapping("/retrieveproduitASC")
		public List <Produit> TrieProduitASC() {
			return produitservice.TrieProduitASC();

		}

		// http://localhost:8089/SpringMVC/servlet/retrieveproduitDESC
		@GetMapping("/retrieveproduitDESC")
		public List <Produit> TrieProduitsDESC(){
			return produitservice.TrieProduitDESC();

		}
		
		// //http://localhost:8089/SpringMVC/servlet/retrieve-produitByLibelle
	 //	@GetMapping("/retrieve-produitByLibelle/{libelleproduit}")
	 //	public List <Produit> retrieveProduitByLibelle(@PathVariable("libelleproduit") String libelle) {
	 //		return produitservice.retrieveProduitsByLibelle(libelle);
		

	 	//}
}
