package tn.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Produit;
import tn.esprit.entities.Rayon;

@Repository
public interface ProduitRepository extends CrudRepository<Produit,Long> {
	@Query(value="select * from produit p where p.rayon_idrayon=?1", nativeQuery=true)
	List<Produit> getProduitByRayon(Rayon rayon);
	
	@Query(value="select prixunitaire FROM produit p ORDER BY p.prixunitaire ASC", nativeQuery=true)

    List<Produit> TrieProduitsASC();
	

	@Query(value="select prixunitaire FROM produit p ORDER BY p.prixunitaire DESC", nativeQuery=true)

    List<Produit> TrieProduitsDESC();
	
	//@Query(value="select libelleproduit FROM produit lib WHERE lib.libelleproduit LIKE %:libelle%")

    //List<Produit> ProduitsByLibelle(@Param("libelleproduit") String libelleproduit);

}
