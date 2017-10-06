package ar.com.magm.ti.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
@Entity
@Proxy(lazy = false)
@Access(value = AccessType.FIELD)
@Table(name = "artista")
public class Artista implements Serializable {

	private static final long serialVersionUID = -3235990393994226233L;

	@Id
	@GeneratedValue
	private int id;
	private String nombre;
	private String genero;
	
	//private ArrayList<Concierto> conciertos;
	//private ArrayList<Album> albums;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}


	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public boolean equals(Object obj) {
		Artista p = (Artista) obj;
		return getId() == p.getId();
	}

	@Override
	public String toString() {
		return String.format("Artista: Artista=%s, genero=%s", getNombre(), getGenero());
	}
}
