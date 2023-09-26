package HibernateDB;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name="Monstre")
public class Monstre implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_monstre",updatable = false)
	private int idMonstre;

	@ManyToOne
	@JoinColumn(name = "id_partida", nullable = true)
	private Partida idPartida;

	@ManyToOne
	@JoinColumn(name = "id_jugador", nullable = true)
	private Jugador idJugador;

	@Column(name = "nom", length = 50)
	private String Nom;
	
	@Column(name = "vides", nullable = false)
	private int Vides;
	
	@Column(name = "victories", nullable = false)
	private int Victories;
	
	@Column(name = "energia", nullable = false)
	private int Energia;
	
	@Column(name = "estatokio",columnDefinition = "boolean default false")
	private boolean EstaATokio;
	
	@Column(name = "eliminat")
	private boolean Eliminat;
	
	//hacer que sea bidireccional
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "monstre_de_poder", updatable = true)
	private Monstre monstre_de_poder;
	
	
	//private Monstre PoderAssociat;
	
//	@OneToOne
//	@JoinColumn(name = "id_poder_associat", nullable = true)
//	private int idMonstreAssociat = PoderAssociat.idMonstre;
	
	@Override
	public String toString() {
		return "Monstre [idMonstre=" + idMonstre + ", idPartida=" + idPartida + ", idJugador=" + idJugador + ", Nom="
				+ Nom + ", Vides=" + Vides + ", Victories=" + Victories + ", Energia=" + Energia + ", EstaATokio="
				+ EstaATokio + ", Eliminat=" + Eliminat + ", monstre_de_poder=" + monstre_de_poder + "]";
	}

	

	public Partida getIdPartida() {
		return idPartida;
	}



	public void setIdPartida(Partida idPartida) {
		this.idPartida = idPartida;
	}



	public Jugador getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(Jugador idJugador) {
		this.idJugador = idJugador;
	}

	public Monstre getMonstre_de_poder() {
		return monstre_de_poder;
	}

	public void setMonstre_de_poder(Monstre monstre_de_poder) {
		this.monstre_de_poder = monstre_de_poder;
	}

	
	
	public Monstre(String nom) {
		super();
		Nom = nom;
	}



	public Monstre(Monstre monstre_de_poder) {
		super();
		this.monstre_de_poder = monstre_de_poder;
	}



	public Monstre() {
		super();
	}

	public Monstre(String nom, int vides, int victories, int energia, boolean estaATokio, boolean eliminat,
			Monstre monstre_de_poder) {
		super();
		Nom = nom;
		Vides = vides;
		Victories = victories;
		Energia = energia;
		EstaATokio = estaATokio;
		Eliminat = eliminat;
		this.monstre_de_poder = monstre_de_poder;
	}



	public Monstre(int idMonstre, int idPartida, int idJugador, String nom, int vides, int victories, int energia,
			boolean estaATokio, boolean eliminat, Monstre poderAssociat) {
		super();
		//this.idMonstre = idMonstre;
		//this.idPartida = idPartida;
		//this.idJugador = idJugador;
		Nom = nom;
		Vides = vides;
		Victories = victories;
		Energia = energia;
		EstaATokio = estaATokio;
		Eliminat = eliminat;
		//PoderAssociat = poderAssociat;
	}

	public int getIdMonstre() {
		return idMonstre;
	}

	public void setIdMonstre(int idMonstre) {
		this.idMonstre = idMonstre;
	}

//	public int getIdPartida() {
//		return idPartida;
//	}
//
//	public void setIdPartida(int idPartida) {
//		this.idPartida = idPartida;
//	}
//
//	public int getIdJugador() {
//		return idJugador;
//	}
//
//	public void setIdJugador(int idJugador) {
//		this.idJugador = idJugador;
//	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public int getVides() {
		return Vides;
	}

	public void setVides(int vides) {
		Vides = vides;
	}

	public int getVictories() {
		return Victories;
	}

	public void setVictories(int victories) {
		Victories = victories;
	}

	public int getEnergia() {
		return Energia;
	}

	public void setEnergia(int energia) {
		Energia = energia;
	}

	public boolean isEstaATokio() {
		return EstaATokio;
	}

	public void setEstaATokio(boolean estaATokio) {
		EstaATokio = estaATokio;
	}

	public boolean isEliminat() {
		return Eliminat;
	}

	public void setEliminat(boolean eliminat) {
		Eliminat = eliminat;
	}

//	public Monstre getPoderAssociat() {
//		return PoderAssociat;
//	}
//
//	public void setPoderAssociat(Monstre poderAssociat) {
//		PoderAssociat = poderAssociat;
//	}
//
//	public int getIdMonstreAssociat() {
//		return idMonstreAssociat;
//	}
//
//	public void setIdMonstreAssociat(int idMonstreAssociat) {
//		this.idMonstreAssociat = idMonstreAssociat;
//	}

//	@Override
//	public String toString() {
//		return "Monstre [idMonstre=" + idMonstre + ", idPartida=" + idPartida + ", idJugador=" + idJugador + ", Nom="
//				+ Nom + ", Vides=" + Vides + ", Victories=" + Victories + ", Energia=" + Energia + ", EstaATokio="
//				+ EstaATokio + ", Eliminat=" + Eliminat + ", PoderAssociat=" + PoderAssociat + ", idMonstreAssociat="
//				+ idMonstreAssociat + "]";
//	}

	

}
