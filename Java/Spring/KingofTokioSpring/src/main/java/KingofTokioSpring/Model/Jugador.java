package KingofTokioSpring.Model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="Jugador")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

@Transactional
public class Jugador implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Jugador",updatable =false ,nullable = false)
	private int Id_Jugador;
	
	
	@Column(name="Nom" ,nullable = false,columnDefinition = "VARCHAR(20)")//limitar hacer char de 30
	private String Nom;
	
	
	@Column(name="Cognom" ,nullable = false ,columnDefinition = "VARCHAR(20)")//limitar hacer char de 30
	private String Cognom;
	
	@OneToMany(mappedBy = "idJugador" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonManagedReference
	Set<Monstre> Monstre=new HashSet<>();
	
	
	public Jugador() {
		super();
		//inicializar hashset
		
	}
	@JsonIgnore
	public Set<Monstre> getMonstre() {
		return Monstre;
	}

	public void setMonstre(Set<Monstre> monstre) {
		Monstre = monstre;
	}

	public Jugador(String nom, String cognom) {
		super();
		Nom = nom;
		Cognom = cognom;
	}

	public int getId_Jugador() {
		return Id_Jugador;
	}

	public void setId_Jugador(int id_Jugador) {
		Id_Jugador = id_Jugador;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getCognom() {
		return Cognom;
	}

	public void setCognom(String cognom) {
		Cognom = cognom;
	}

	@Override
	public String toString() {
		return "Jugador [Id_Jugador=" + Id_Jugador + ", Nom=" + Nom + ", Cognom=" + Cognom + "]";
	}
	
	
}