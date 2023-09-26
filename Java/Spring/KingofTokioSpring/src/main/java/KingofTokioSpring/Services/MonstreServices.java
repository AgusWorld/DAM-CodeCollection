package KingofTokioSpring.Services;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KingofTokioSpring.Model.Monstre;
import KingofTokioSpring.Repositoris.MonstreRepository;

@Service
public class MonstreServices {
	@Autowired
	MonstreRepository repository;
	
	public Monstre findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public List<Monstre> findAll() {
		return repository.findAll();
	}

	public void delete(Integer id) {

		repository.deleteById(id);
	}

	public Monstre insertar(Monstre j) {
		return repository.save(j);
	}

	public Monstre editar(Monstre j) {
		return repository.save(j);
	}
	
	public List<Monstre> findByEstaATokioEqualsTrue()
	{
		return repository.findByestatokioTrue();
	}
	public List<Monstre> GetMonstreTokio()
	{
		return repository.findByestatokioTrue();
	}
	public List<Monstre> findByEliminatFalse()
	{
		return repository.findByEliminatFalse();
	}
	public List<Monstre> findbyVictories(){
		return repository.findTopByOrderByVictoriesDesc();
	}
	
//	public List<Monstre> findMonstrePoderLLiure(){
//		return repository.findTop4ByOrderByidMonstreAsc();
//	}
}
