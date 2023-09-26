package KingofTokioSpring.Repositoris;

import java.util.List;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import KingofTokioSpring.Model.Monstre;


public interface  MonstreRepository extends JpaRepository<Monstre, Integer>{

	List<Monstre> findByestatokioTrue();
	List<Monstre> findByEliminatFalse();
	
	List<Monstre> findTopByOrderByVictoriesDesc();
	
	//List<Monstre> findTop4ByOrderByidMonstreAsc();
	//ListMonstrePoderLliure
	//List<Monstre> findByIDGreather();
}
