package tn.esprit.Controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.GeneratePdfReport;
import tn.esprit.entities.Rayon;
import tn.esprit.service.RayonService;

@RestController
public class RayonRestController {

	@Autowired
	RayonService rayonService;
	
	//http://localhost:8081/SpringMVC/servlet/retrieveallrayons
	@GetMapping("/retrieveallrayons")
	public List<Rayon> getRayons() {
	List<Rayon> listRayons = rayonService.retrieveAllRayon();
	return listRayons;
	}
	
	//http://localhost:8081/SpringMVC/servlet/retrieveRayon/1
	@GetMapping("/retrieveRayon/{rayonId}")
	public Rayon retrieveRayon(@PathVariable("rayonId") Long rayonId) {
	return  rayonService.retrieveRayon(rayonId);
	}
	
	//http://localhost:8089/SpringMVC/servlet/addRayons
	@PostMapping("/addRayons")
	@ResponseBody
	public Rayon addRayon(@RequestBody Rayon r)
	{
	Rayon rayon = rayonService.addRayon(r);
	return rayon;
	}
	
	
	//http://localhost:8081/SpringMVC/servlet/modifyRayon 
	@PutMapping("/modifyRayon")
	@ResponseBody
	public Rayon modifyRayon(@RequestBody Rayon rayon) {
	return rayonService.updateRayon(rayon);
	}
	
	
	//http://localhost:8081/SpringMVC/servlet/removeRayon/2
	@DeleteMapping("/removeRayon/{rayonId}")
	@ResponseBody
	public void removeRayon(@PathVariable("rayonId") Long rayonId) {
	rayonService.deleteRayon(rayonId);
	}
	
	
	@RequestMapping(value = "/pdfreportrayon", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {

        List<Rayon> cities = (List<Rayon>) rayonService.findAll();

        ByteArrayInputStream bis = GeneratePdfReport.citiesReport(cities);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
	
	//http://localhost:8081/SpringMVC/servlet/assignproduittorayon/{idproduit}/{idrayon}
	 @PutMapping("/assignproduittorayon/{idproduit}/{idrayon}")
		@ResponseBody
		public void AssignproduittoRayon(@PathVariable("idproduit") Long idproduit,@PathVariable("idrayon") Long idrayon ) {
		 rayonService.assignProduittoRayon (idproduit,idrayon);
			}
	@GetMapping("/affichequantiteproduitbyproduct_category_byrayon")
	public List affichequantiteproduitbyproduct_category_byrayon() {
	List res = rayonService.affichequantiteproduitbyproduct_category_byrayon();
		return res;
	}
	
	@GetMapping("/affichequantiterayonbyproductcategory")
	public List affichequantiterayonbyproductcategory() {
		List res = rayonService.affichequantiterayonbyproductcategory();
		return res;
		}

}
