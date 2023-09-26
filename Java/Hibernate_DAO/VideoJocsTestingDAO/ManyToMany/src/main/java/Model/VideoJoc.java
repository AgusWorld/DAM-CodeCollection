package Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Videojoc")

public class VideoJoc implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="JUG_ID")
    private int juegoId;
	
	@Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="EDAD")
    private Integer edad;
    
    @Column(name="PRECIO")
    private Integer precio;
    
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="videojocs",fetch = FetchType.EAGER)
    private Set<Jugador> jugadores;
    
    

	public VideoJoc() {
		super();
		jugadores = new HashSet<Jugador>();
	}



	public VideoJoc(String nombre, Integer edad, Integer precio) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.precio = precio;
		jugadores = new HashSet<Jugador>();
	}



	public int getJuegoId() {
		return juegoId;
	}



	public void setJuegoId(int juegoId) {
		this.juegoId = juegoId;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getEdad() {
		return edad;
	}



	public void setEdad(Integer edad) {
		this.edad = edad;
	}



	public Integer getPrecio() {
		return precio;
	}



	public void setPrecio(Integer precio) {
		this.precio = precio;
	}



	public Set<Jugador> getJugadores() {
		return jugadores;
	}



	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}



	@Override
	public String toString() {
		return "VideoJoc [juegoId=" + juegoId + ", nombre=" + nombre + ", edad=" + edad + ", precio=" + precio + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edad == null) ? 0 : edad.hashCode());
		result = prime * result + juegoId;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VideoJoc other = (VideoJoc) obj;
		if (edad == null) {
			if (other.edad != null)
				return false;
		} else if (!edad.equals(other.edad))
			return false;
		if (juegoId != other.juegoId)
			return false;
		if (jugadores == null) {
			if (other.jugadores != null)
				return false;
		} else if (!jugadores.equals(other.jugadores))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}
    
    
    
    
}
