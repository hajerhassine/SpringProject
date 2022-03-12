package tn.esprit.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Facture;


@Repository
public interface FactureRepository extends CrudRepository<Facture,Long>{
	
	@Query(value="select datefacture from facture", nativeQuery=true)
	List<Date> getDateFacture();
	


}
