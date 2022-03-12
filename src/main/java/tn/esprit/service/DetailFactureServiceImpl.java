package tn.esprit.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Client;
import tn.esprit.entities.DetailFacture;
import tn.esprit.entities.Facture;
import tn.esprit.repository.ClientRepository;
import tn.esprit.repository.DetailFactureRepository;
import tn.esprit.repository.FactureRepository;
import tn.esprit.repository.ProduitRepository;

@Service
public class DetailFactureServiceImpl implements DetailFactureService{

	@Autowired
	DetailFactureRepository dfr;
	@Autowired
	ClientRepository  clientRepository;
	@Autowired
	FactureRepository  factureRepository;

	
	@Autowired
	ProduitRepository  produitRepository;

	@Override
	public List<DetailFacture>retrieveAllDetailFacture(){
		List<DetailFacture> df = (List<DetailFacture>) dfr.findAll();
		return df;
	}


	
	@Override
	public void deleteDetailFacture(Long id){
		dfr.deleteById(id);
	}

	@Override
	public DetailFacture  retrieveDetailFactures(Long id) {
		DetailFacture df = dfr.findById(id).get();
		return df;
	}
	
	@Override
	public DetailFacture addDetailFacture(DetailFacture df){
		return dfr.save(df);
	}



	@Override
	public DetailFacture updateDetailFacture(DetailFacture df) {
		if(dfr.existsById(df.getIddetailfacture())){
			DetailFacture sf=dfr.findById(df.getIddetailfacture()).get();
			//f.setActive();
			df.setIddetailfacture(df.getIddetailfacture());
			df.setQuantite(df.getQuantite());
			df.setPrixtotal(df.getPrixtotal());
			df.setPourcentageremise(df.getPourcentageremise());
			df.setMontantremise(df.getMontantremise());
			dfr.save(df);
			
			
		}
		return df;
	}



	@Override
	public List<DetailFacture> getDetailFactureByFacture(Long idfacture) {
		Facture facture =  factureRepository.findById(idfacture).get();
		return dfr.getDetailFactureByFacture(idfacture);
				}


	@Override
	public void adddetailfacture(DetailFacture detailfacture, Long idproduit, Long idfacture) {
		detailfacture.setProduit(produitRepository.findById(idproduit).get());
		detailfacture.setFacture(factureRepository.findById(idfacture).get());
		dfr.save(detailfacture);
	}
	
}
