package KingofTokioSpring.Model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="Partida")
@Transactional
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

public class Partida implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPartida",updatable = false)
	private int id_Partida;
	
	@Column(name="torn",nullable = false)
	private int torn_N;
	
	@Column(name="NJugadors",nullable = false)
	private int N_Jugadors;
	
	@OneToMany(mappedBy = "idPartida" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	
	 Set<Monstre> monstre=new HashSet<>();
	@JsonManagedReference
	public Set<Monstre> getMonstre() {
		return monstre;
	}

	
	public Partida() {
		super();
	}


	public Partida(int torn_N, int n_Jugadors) {
		super();
		this.torn_N = torn_N;
		N_Jugadors = n_Jugadors;
	}


	public void setMonstre(Set<Monstre> monstre) {
		this.monstre = monstre;
	}


	public int getId_Partida() {
		return id_Partida;
	}
	
	
	public void setId_Partida(int id_Partida) {
		this.id_Partida = id_Partida;
	}

	public int getTorn_N() {
		return torn_N;
	}

	public void setTorn_N(int torn_N) {
		this.torn_N = torn_N;
	}

	public int getN_Jugadors() {
		return N_Jugadors;
	}

	public void setN_Jugadors(int n_Jugadors) {
		N_Jugadors = n_Jugadors;
	}


	@Override
	public String toString() {
		return "Partida [id_Partida=" + id_Partida + ", torn_N=" + torn_N + ", N_Jugadors=" + N_Jugadors + "]";
	}
	
	
	
}

