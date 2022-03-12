package tn.esprit.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Rayon;
@Repository
public interface RayonRepository extends CrudRepository <Rayon,Long>{
	
	
	 @Query("SELECT count(*),p.detail.categorieproduit,r.libelle FROM Produit p JOIN Rayon r ON p.rayon=r.idrayon GROUP BY p.detail.categorieproduit, r.libelle")
		List affichequantiteproduitbyproduct_category_byrayon();
	 
	 @Query("SELECT count(*),p.detail.categorieproduit,r.libelle FROM Produit p JOIN Rayon r ON p.rayon=r.idrayon GROUP BY p.detail.categorieproduit")
	   	List affichequantiterayonbyproductcategory();
	
	 @Transactional
		@Modifying
		@Query("Update Produit p set p.rayon.idrayon = :idrayon where p.idproduit =:idproduit")
	    void assignProduittoRayon(@Param("idproduit") Long idproduit, @Param("idrayon") Long idrayon);
	

}
