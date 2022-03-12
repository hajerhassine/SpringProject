package tn.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.entities.Stock;
@Repository
public interface Stockrepository extends CrudRepository<Stock,Long> {

	
	
	
}
