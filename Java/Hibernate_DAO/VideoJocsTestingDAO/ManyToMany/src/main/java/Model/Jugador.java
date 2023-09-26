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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Jugador")
public class Jugador implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="JUG_ID")
    private int jugId;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="APELLIDOS")
    private String apellidos;
    
    @Column(name="SALDO")
    private Integer saldo;
    
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="VideoJugador", joinColumns= {@JoinColumn(name="IdJugador")},inverseJoinColumns= {@JoinColumn(name="IdVideo")})
    private Set<VideoJoc> videojocs;

	public Jugador() {
		super();
		videojocs = new HashSet<VideoJoc>();
	}

	public Jugador(String nombre, String apellidos, Integer saldo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.saldo = saldo;
		videojocs = new HashSet<VideoJoc>();
	}

	public int getJugId() {
		return jugId;
	}

	public void setJugId(int jugId) {
		this.jugId = jugId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	public Set<VideoJoc> getVideojoc() {
		return videojocs;
	}

	public void setVideojoc(Set<VideoJoc> videojoc) {
		this.videojocs = videojoc;
	}

	@Override
	public String toString() {
		return "Jugador [jugId=" + jugId + ", nombre=" + nombre + ", apellidos=" + apellidos + ", saldo=" + saldo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + jugId;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		
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
		Jugador other = (Jugador) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (jugId != other.jugId)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		if (videojocs == null) {
			if (other.videojocs != null)
				return false;
		} else if (!videojocs.equals(other.videojocs))
			return false;
		return true;
	}
    
	
    
    
    
}
