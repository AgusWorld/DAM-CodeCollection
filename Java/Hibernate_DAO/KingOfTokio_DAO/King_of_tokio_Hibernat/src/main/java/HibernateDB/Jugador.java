package HibernateDB;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="Jugador")
public class Jugador implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Jugador",updatable =false ,nullable = false)
	private int Id_Jugador;
	
	
	@Column(name="Nom" ,nullable = false,columnDefinition = "VARCHAR(20)")//limitar hacer char de 30
	private String Nom;
	
	
	@Column(name="Cognom" ,nullable = false ,columnDefinition = "VARCHAR(20)")//limitar hacer char de 30
	private String Cognom;
	
	@OneToMany(mappedBy = "idJugador" ,cascade = CascadeType.ALL)
	private Set<Monstre> Monstre;
	
	
	public Jugador() {
		super();
		//inicializar hashset
		this.Monstre=new HashSet<Monstre>();
	}

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
