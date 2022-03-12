package tn.esprit.Controller;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tn.esprit.entities.DetailFacture;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.esprit.entities.Facture;
import tn.esprit.entities.GeneratePdfReport;
import tn.esprit.entities.GeneratePdfReportFacture;
import tn.esprit.entities.Rayon;
import tn.esprit.service.DetailFactureService;
import tn.esprit.service.FactureService;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class FactureRestController {
	@Autowired
	FactureService factureservice;
	@Autowired
	DetailFactureService detailfactureservice;
	//http://localhost:8089/SpringMVC/servlet/addfacture/
	@PostMapping("/addfacture/{id-client}")
	@ResponseBody
	public Long addFacture(@RequestBody Facture facture, @PathVariable("id-client") Long client)
	{
          return factureservice.addfacture(facture,client);
	}
	
	//http://localhost:8089/SpringMVC/servlet/add-detailFacture/
	
	@PostMapping("/add-detailFacture/{id-produit}/{id-facture}")
	@ResponseBody
	public void adddetailFacture(@RequestBody DetailFacture facture, @PathVariable("id-produit") Long idproduit, @PathVariable("id-facture") Long idfacture)
	{
		detailfactureservice.adddetailfacture(facture, idproduit, idfacture);
	}

	
	// URL: http://localhost:8081/SpringMVC/servlet/getallfacture
		@GetMapping("/getallfacture")
		public List<Facture> getFacture(){
			List <Facture> listfacture = factureservice.retrieveAllFactures();
			return listfacture;
			
		}
		
		
		
		
		// URL: http://localhost:8089/SpringMVC/servlet/getalldatefacture
			@GetMapping("/getalldatefacture")
			public List<Date> getDateFacture(){
				List <Date> datefacture = factureservice.getDateFacture();
				return datefacture;
				
			}
		
		
	
	// URL: http://localhost:8089/SpringMVC/servlet/getfacture/1
	@GetMapping("getfacture/{idfacture}")
	public Facture retrieveFacture(@PathVariable("idfacture") Long idfacture){
	return factureservice.retrieveFacture(idfacture);
		
	}
	

	

	// URL: http://localhost:8089/SpringMVC/servlet/getfacturebyclient/1
//		@GetMapping("getfacturebyclient/{idclient}")
//		@ResponseBody
//	public List<Facture> getFactureByClient(@PathVariable("idclient") Long idclient){
//		List<Facture> listfac=factureservice.getFactureByClient(idclient);
//		return listfac;
//		
//	}
		
	
	
	// URL: http://localhost:8089/SpringMVC/servlet/cancelfacture
		@PutMapping("/cancelfacture/{idfacture}")
		
	public void cancelFacture(@PathVariable("idfacture") Long idfacture){
		factureservice.cancelFacture(idfacture);
		
	}
	
		
		
		//http://localhost:8089/SpringMVC/servlet/addfacture
	//	@PostMapping("/addfacture")
		//@ResponseBody
		//public Facture addFacture(@RequestBody Facture f){
		//	Facture facture =factureservice.addFacture(f);
			//return  facture;
			
		//}
		
		
		@RequestMapping(value = "/pdfreportfacture", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> citiesReport() {

	        List<Facture> cities = (List<Facture>) factureservice.findAll();

	        ByteArrayInputStream bis = GeneratePdfReportFacture.citiesReport(cities);

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
		
		//@ApiOperation(value = "Ajouter une Facture")
	   // @PostMapping("/addFacture/{idClient}")
	  //  public Facture addFacture(@RequestBody Facture f,@PathVariable(value="idClient")Long idClient){
	   //     Facture facture= factureservice.addFacture(f,idClient);
	   //     return facture;
	  //  }
		
		
		
}

