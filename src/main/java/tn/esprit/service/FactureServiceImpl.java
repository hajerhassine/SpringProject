package tn.esprit.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Client;
import tn.esprit.entities.DetailFacture;
import tn.esprit.entities.Facture;
import tn.esprit.entities.Produit;
import tn.esprit.entities.Rayon;
import tn.esprit.repository.ClientRepository;
import tn.esprit.repository.FactureRepository;

@Service
public class FactureServiceImpl implements FactureService {

	@Autowired
	FactureRepository facturerepository ;
	@Autowired
	ClientRepository clientRepository ;

	@Autowired
	ClientServiceImpl clientService;
	@Autowired
	DetailFactureServiceImpl detailFactureService;
	
	 public FactureServiceImpl (FactureRepository factureRepository) {
	        this.facturerepository = factureRepository;
	    }
	 
	 
	 @Override
		public Long addfacture(Facture f,Long clientid) {
			f.setClient(clientRepository.findById(clientid).get());
			facturerepository.save(f);
			return f.getIdfacture();
			
		}

	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> factures = (List<Facture>) facturerepository.findAll();
		return factures;
	}

	@Override
	public void cancelFacture(Long id) {
		Facture facture = facturerepository.findById(id).get();
		facture.setActive(false);
	    facturerepository.save(facture);
		
	}

	@Override
	public Facture retrieveFacture(Long id) {
		Facture f = facturerepository.findById(id).get();
		return f;
	}
	
	@Override
	public Facture addFacture(Facture f){
		return facturerepository.save(f);
	}

	@Override
	public List<Facture> findAll() {
		return (List<Facture>) facturerepository.findAll();
	}
	


	//Facture datefacture= facturerepository.findAll(datefacture).get();
	@Override
	public List<Date> getDateFacture() {
		
		List<Date> dates= facturerepository.getDateFacture();
		
		return dates;
	}


	 
	@Override
	public Facture addFacture(Facture f, Long idClient) {
		 f.setClient(clientService.retrieveClient(idClient));
		 facturerepository.save(f);
	     DetailFacture detailFacture=new DetailFacture();
	     detailFacture.setFacture(f);
	     detailFacture.setMontantremise(f.getMontantremise());
	     detailFacture.setPrixtotal(f.getMontantfacture()-f.getMontantremise());
		  detailFactureService.addDetailFacture(detailFacture);
	     return f;
	}
	
	
	

	
	//@Override
	//public Facture retrieveDateFacture(Date datefacture, Long id) {
	//	Facture f = facturerepository.findById(id).get();
		//return f;
//	}
	

	
	
	

}
