package tn.esprit.repository;

import tn.esprit.entities.Client;

import tn.esprit.entities.DetailFacture;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
public interface DetailFactureRepository extends CrudRepository<DetailFacture,Long> {
	@Query(value="select * from detail_facture d where d.facture_idfacture=?1" ,nativeQuery=true)
	 List<DetailFacture> getDetailFactureByFacture(@Param("idfacture") long idfacture);

}
