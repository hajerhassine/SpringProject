package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Fournisseur;
@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur,Long>{
	
	


}
