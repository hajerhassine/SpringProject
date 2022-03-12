package tn.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Rayon;
import tn.esprit.repository.RayonRepository;
@Service
public class RayonServiceImpl implements RayonService{
	
	@Autowired
	RayonRepository Rayonrepository;
	

	@Override
	public List<Rayon> retrieveAllRayon() {
		List <Rayon> rayons = (List<Rayon>) Rayonrepository.findAll();
		return rayons;
		
	}

	@Override
	public Rayon addRayon(Rayon rayon) {
		return Rayonrepository.save(rayon);
	}

	@Override
	public void deleteRayon(Long id) {
		Rayonrepository.deleteById(id);
	}

	@Override
	public Rayon updateRayon(Rayon rayon) {
		if (Rayonrepository.existsById(rayon.getIdrayon())){
			Rayon r = Rayonrepository.findById(rayon.getIdrayon()).get();
			r.setCoderayon(rayon.getCoderayon());
			r.setLibelle(rayon.getLibelle());
		
		
			Rayonrepository.save(r);
		}
		
		return rayon;
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		
		Rayon r =Rayonrepository.findById(id).get();
		return r;
	}

	@Override
	public List<Rayon> findAll() {
		return (List<Rayon>) Rayonrepository.findAll();
	}
	
	@Override
	public List affichequantiteproduitbyproduct_category_byrayon() {

		return Rayonrepository.affichequantiteproduitbyproduct_category_byrayon();
	}

	@Override
	public List affichequantiterayonbyproductcategory() {
		return Rayonrepository.affichequantiterayonbyproductcategory();
	}

	@Override
	public void assignProduittoRayon(Long idproduit, Long idrayon) {
		Rayonrepository.assignProduittoRayon(idproduit, idrayon);
		
	}

}
