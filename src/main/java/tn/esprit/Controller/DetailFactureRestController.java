package tn.esprit.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.DetailFacture;
import tn.esprit.entities.Facture;
import tn.esprit.service.DetailFactureService;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class DetailFactureRestController {
	
	@Autowired
	DetailFactureService dfr;
	
	
	
	
	// URL: http://localhost:8089/SpringMVC/servlet/getdetailfacturebyfacture/30
			@GetMapping("getdetailfacturebyfacture/{idfacture}")
		public List<DetailFacture> getDetailFactureByFacture(@PathVariable("idfacture") Long idfacture){
			List<DetailFacture> listdetail=dfr.getDetailFactureByFacture(idfacture);
			return listdetail;
			
		}
			// URL: http://localhost:8089/SpringMVC/servlet/detailfacture/getdetailfacturebyid/5
			@GetMapping("getdetailfacturebyid/{iddetailfacture}")
			@ResponseBody
			public DetailFacture retrieveDetailFacture(@PathVariable("iddetailfacture") Long iddetailfacture){
				return dfr.retrieveDetailFactures(iddetailfacture);
				
			}
	
	
	// URL: http://localhost:8089/SpringMVC/servlet/detailfacture/adddetailfacture
	@PostMapping("/adddetailfacture")
	@ResponseBody
	public DetailFacture addDetailFacture(@RequestBody DetailFacture df){
		DetailFacture detailfacture =dfr.addDetailFacture(df);
		return  detailfacture;
		
	}
	
	// URL: http://localhost:8089/SpringMVC/servlet/detailfacture/getalldetailfacture
	@GetMapping("/getalldetailfacture")
	public List<DetailFacture> getDetailFacture(){
		List <DetailFacture> listdetailfacture = dfr.retrieveAllDetailFacture();
		return listdetailfacture;
		
	} 
	
	
	// URL: http://localhost:8089/SpringMVC/servlet/detailfacture/modifydetailfacture
	@PutMapping("/modifydetailfacture")
	@ResponseBody
	public DetailFacture modifyFacture(@RequestBody DetailFacture df){
		return dfr.updateDetailFacture(df);
	}
	
	// URL: http://localhost:8089/SpringMVC/servlet/detailfacture/removefacture
	@DeleteMapping("/removefacture/{iddetailfacture}")
	@ResponseBody
	public void removeDetailFacture(@PathVariable("iddetailfacture") Long iddetailfacture) {
		dfr.deleteDetailFacture(iddetailfacture);
		}


}
