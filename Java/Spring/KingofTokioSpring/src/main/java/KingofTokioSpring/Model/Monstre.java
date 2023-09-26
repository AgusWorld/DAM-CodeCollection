package KingofTokioSpring.Model;

import java.io.Serializable;   

import javax.persistence.*;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name="Monstre")

@Transactional
public class Monstre implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_monstre",updatable = false)
	private int idMonstre;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_partida", nullable = true)
	@JsonBackReference
	private Partida idPartida;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_jugador")
	@JsonBackReference
	private Jugador idJugador;

	@Column(name = "nom", length = 50)
	private String Nom;
	
	@Column(name = "vides", nullable = false)
	private int Vides;
	
	@Column(name = "victories", nullable = false)
	private int victories;
	
	@Column(name = "energia", nullable = false)
	private int Energia;
	
	@Column(name = "estatokio",columnDefinition = "boolean default false")
	private boolean estatokio;
	
	@Column(name = "eliminat")
	private boolean eliminat;
	
	//hacer que sea bidireccional
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "monstre_de_poder", updatable = true)
	@JsonManagedReference
	private Monstre monstre_de_poder;
	
	@OneToOne(mappedBy = "monstre_de_poder",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	//@JoinColumn(name = "id_poder_associat", nullable = true)
	@JsonBackReference
	private Monstre idMonstreAssociat;
	
	
	public Monstre getIdMonstreAssociat() {
		return idMonstreAssociat;
	}



	public void setIdMonstreAssociat(Monstre idMonstreAssociat) {
		this.idMonstreAssociat = idMonstreAssociat;
	}





	

	@Override
	public String toString() {
		return "Monstre [idMonstre=" + idMonstre + ", idPartida=" + idPartida + ", idJugador=" + idJugador + ", Nom="
				+ Nom + ", Vides=" + Vides + ", Victories=" + victories + ", Energia=" + Energia + ", EstaATokio="
				+ estatokio + ", Eliminat=" + eliminat + ", monstre_de_poder=" + monstre_de_poder
				+ ", idMonstreAssociat=" + idMonstreAssociat + "]";
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
		victories = victories;
		Energia = energia;
		estatokio = estaATokio;
		eliminat = eliminat;
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
		victories = victories;
		Energia = energia;
		estatokio = estaATokio;
		eliminat = eliminat;
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
		return victories;
	}

	public void setVictories(int victories) {
		victories = victories;
	}

	public int getEnergia() {
		return Energia;
	}

	public void setEnergia(int energia) {
		Energia = energia;
	}

	public boolean isEstaATokio() {
		return estatokio;
	}

	public void setEstaATokio(boolean estaATokio) {
		estatokio = estaATokio;
	}

	public boolean isEliminat() {
		return eliminat;
	}

	public void setEliminat(boolean Eliminat) {
		eliminat = Eliminat;
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



	

}
