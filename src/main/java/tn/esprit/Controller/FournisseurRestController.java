package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.entities.Fournisseur;
import tn.esprit.service.FournisseurService;

@RestController
public class FournisseurRestController {
	
	@Autowired
	FournisseurService fournisseurService;
	
	//http://localhost:8089/SpringMVC/servlet/retrieveallfournisseurs
	@GetMapping("/retrieveallfournisseurs")
	public List<Fournisseur> getFournisseurs() {
	List<Fournisseur> listFournisseurs = fournisseurService.retrieveAllFournisseur();
	return listFournisseurs;
	}

	
	//http://localhost:8089/SpringMVC/servlet/retrieveFournisseur/1
	@GetMapping("/retrieveFournisseur/{fournisseurId}")
	public Fournisseur retrieveFournisseur(@PathVariable("fournisseurId") Long fournisseurId) {
	return 	fournisseurService.retrieveFournisseur(fournisseurId);
	}
	
	
	//http://localhost:8089/SpringMVC/servlet/addFournisseurs
	@PostMapping("/addFournisseurs")
	@ResponseBody
	public Fournisseur addFournisseur(@RequestBody Fournisseur f)
	{
	Fournisseur fournisseur = fournisseurService.addFournisseur(f);
	return fournisseur;
	}
	
	
	//http://localhost:8081/SpringMVC/servlet/modifyFournisseur
	@PutMapping("/modifyFournisseur")
	@ResponseBody
	public Fournisseur modifyFournisseur(@RequestBody Fournisseur fournisseur) {
	return fournisseurService.updateFournisseur(fournisseur);
	}
	
	//http://localhost:8089/SpringMVC/servlet/removeFournisseur/4
	@DeleteMapping("/removeFournisseur/{fournisseurId}")
	@ResponseBody
	public void removeFournisseur(@PathVariable("fournisseurId") Long fournisseurId) {
	fournisseurService.deleteFournisseur(fournisseurId);
	}
	
	
	
	
	// URL : http://localhost:8089/SpringMVC/servlet/afficherPDF/{idfournisseur}
	   @GetMapping(value = "/afficherPDF/{idfournisseur}")
	   public void fournisseurpdf (@PathVariable("idfournisseur") int id) {
		   
		   fournisseurService.fournisseurpdf(id);
	   }
}
