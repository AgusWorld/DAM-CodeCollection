package HibernateDB;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="Partida")
public class Partida implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPartida",updatable = false)
	private int id_Partida;
	
	@Column(name="torn",nullable = false)
	private int torn_N;
	
	@Column(name="NJugadors",nullable = false)
	private int N_Jugadors;
	
	@OneToMany(mappedBy = "idPartida" ,cascade = CascadeType.ALL)
	private Set<Monstre> monstre;
	
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
