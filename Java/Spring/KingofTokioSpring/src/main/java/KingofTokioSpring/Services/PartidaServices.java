package KingofTokioSpring.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KingofTokioSpring.Model.Partida;
import KingofTokioSpring.Repositoris.PartidaRepository;

@Service
public class PartidaServices {
	@Autowired
	PartidaRepository repository;
	public Partida findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public List<Partida> findAll() {
		return repository.findAll();
	}

	public void delete(Integer id) {

		repository.deleteById(id);
	}

	public Partida insertar(Partida j) {
		return repository.save(j);
	}

	public Partida editar(Partida j) {
		return repository.save(j);
	}
}
