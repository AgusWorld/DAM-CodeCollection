package DAO;

import java.io.Serializable;
import java.util.List;

import Model.Jugador;

public interface IJugadorDAO extends IGenericDAO<Jugador, Integer>, Serializable {
	List<Jugador> ObtenerJugadoresConPasta();
}
