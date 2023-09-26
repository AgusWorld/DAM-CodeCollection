package KingofTokioSpring.Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import KingofTokioSpring.Model.Jugador;
import KingofTokioSpring.Model.Monstre;
import KingofTokioSpring.Services.JugadorServices;
import KingofTokioSpring.Services.MonstreServices;
import KingofTokioSpring.Services.PartidaServices;

@Controller
public class MainController {

	@Autowired
	MonstreServices monstreservice;

	@Autowired
	PartidaServices partidaservice;

	@Autowired
	JugadorServices jugadorservice;

	public List<Jugador> jugadores = new ArrayList<Jugador>();

	@GetMapping(path = "/") // Map ONLY GET Requests
	public @ResponseBody String welcome() {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		return "Estoy vivito y coleando!!!";
	}

	@GetMapping(path = "/allMonstres")
	public @ResponseBody List<Monstre> allMonstres() {
		return monstreservice.findAll();
	}

	@GetMapping(path = "/allJugadors")
	public @ResponseBody List<Jugador> allJugadors() {
		return jugadorservice.findAll();
	}

	@GetMapping(path = "/Jugador/id")
	public @ResponseBody Jugador MonstreJugador(@RequestParam int id) {
		return jugadorservice.findById(id);
	}

	@GetMapping(path = "/HiHaMonstreTokio")
	public @ResponseBody String getTokio() {
		if (monstreservice.findByEstaATokioEqualsTrue() != null) {
			return "Hi ha un monstre a Tokio";
		} else {
			return "No hi ha un monstre a Tokio";
		}

		// return monstreservice.findByEstaATokioEqualsTrue();
	}

	@GetMapping(path = "/ListMostresVius")
	public @ResponseBody List<Monstre> getMonstreViu() {
		return monstreservice.findByEliminatFalse();
	}

	@GetMapping(path = "/GetMonstreTokio")
	public @ResponseBody List<Monstre> getMonstreTokio() {
		return monstreservice.findByEstaATokioEqualsTrue();
	}

	@GetMapping(path = "/Roll")
	public @ResponseBody List<Integer> getRoll() {

		List<Integer> LDaus = new ArrayList<Integer>();
		Random rd = new Random();

		for (int i = 0; i < 6; i++) {
			int nrandom = rd.nextInt(6) + 1;
			LDaus.add(nrandom);
			// System.out.println("Dau numero " + nrandom);
		}
		return LDaus;
	}

	@GetMapping(path = "AssignarTorn")
	public @ResponseBody String AssignarTorn() {
		jugadorservice.findAll();
		jugadores.addAll(jugadorservice.findAll());
		Collections.shuffle(jugadores);

		return "Torn del jugador" + jugadores.get(0);

	}

	@GetMapping(path = "MonstreMaxPuntsVictoria")
	public @ResponseBody List<Monstre> MonstreMaxPunts() {

		return monstreservice.findbyVictories();

	}

	@GetMapping(path = "ListMonstreViuContrincant")
	public @ResponseBody Monstre MonstreContrincant(@RequestParam int id) {

		return monstreservice.findById(id);
	}

	@GetMapping(path = "CountMonstreViu")
	public @ResponseBody int CountMonstreViu() {

		List<Monstre> m = new ArrayList<Monstre>();
		m.addAll(monstreservice.findByEliminatFalse());

		return m.size() - 4;
	}

	// HECHA bien
	@GetMapping(path = "/ListMostresViusContrincants")
	public @ResponseBody List<Monstre> getMonstreViuContrincant(@RequestParam int id) {
		List<Monstre> m = new ArrayList<Monstre>();
		m.addAll(monstreservice.findByEliminatFalse());
		List<Monstre> m1 = new ArrayList<Monstre>();
		for (Monstre monstre : m) {
			if (monstre.getIdMonstre() != id && !monstre.isEliminat() && monstre.getVides() > 0)
				m1.add(monstre);
		}
		return m1;
	}

	@GetMapping(path = "/ListMonstrePoderLliures")
	public @ResponseBody List<Monstre> ListMonstrePoderLliures() {

		List<Monstre> entities = monstreservice.findByEliminatFalse();;
		ArrayList<Integer> idsAssociats = new ArrayList<Integer>();

		// Añado a una array los IDs de monsturo associado de los monstruos con jugador
		for (Monstre monstre : entities) {
			if (monstre.getIdJugador() != null && monstre.getMonstre_de_poder() != null) {
				idsAssociats.add(monstre.getMonstre_de_poder().getIdMonstre());
			}
		}

		List<Monstre> lliures = new ArrayList<Monstre>();

		for (Monstre monstre : entities) {
			if (monstre.getIdJugador() == null // Si no tiene jugador asociado
					&& monstre.getMonstre_de_poder() == null // Si no tiene monsturo de poder associado
					&& !idsAssociats.contains(monstre.getIdMonstre())) {// Si su id no esta en la array de ya asociados
				lliures.add(monstre);
			}
		}

		return lliures;
	}
	
	
	@GetMapping(path = "/ActualitzarMonstresVius")
	public @ResponseBody String ActualitzarMonstresVius() {
		List<Monstre> m = new ArrayList<Monstre>();
		m.addAll(monstreservice.findAll());
		String resultat="";
		boolean mod=false;
		for (Monstre monstre : m) {
			if((monstre.isEliminat() || monstre.getVides()<=0) 
					&& monstre.getIdJugador()!=null) {
				mod=true;
				monstre.setIdJugador(null);
				monstre.setVides(0);
				monstre.setEliminat(true);
				monstreservice.editar(monstre);
				resultat+=monstre.getNom()+" s'ha actualitzat i ara te vides -> 0  eliminat -> true idJugador -> null";
			}
		}
		if(mod)
			return resultat;
		else
			return "No s'ha modificat cap monstre";
	}
	
	

//	@GetMapping(path="SolveRoll")
//	public @ResponseBody List<Monstre> SolveRoll()
//	{List<Integer> LDaus = Roll();
//	int cont1 = 0;
//	int cont2 = 0;
//	int cont3 = 0;
//	for (int Dau : LDaus) {
//		switch (Dau) {
//		case 1:
//			cont1++;
//			break;
//		case 2:
//			cont2++;
//			break;
//		case 3:
//			cont3++;
//			break;
//		case 4:
//			SumarPuntsEnergia(j);
//
//			break;
//		case 5:
//			EliminarVida(j);
//			break;
//		case 6:
//			SumarVida(j, 1);
//			break;
//
//		default:
//			break;
//		}
//		if (cont1 == 3) {
//			SumarVictories(j, 1);
//		}
//		if (cont2 == 3) {
//			SumarVictories(j, 2);
//		}
//		if (cont3 == 3) {
//			SumarVictories(j, 3);
//		}
//
//	}
//		return null;
//		
//	}
//	@GetMapping(path="/Monstre/id_jugador")
//	public @ResponseBody List<Monstre> getMonstreId_jugador(@RequestParam int idJugador){
//		return monstreservice.findByid_jugador(idJugador);
//	}

}
