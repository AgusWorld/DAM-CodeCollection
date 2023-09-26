package KingofTokioSpring.Repositoris;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import KingofTokioSpring.Model.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Integer>{
	
}
