package ar.com.magm.ti.model;

import java.io.Serializable;
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
@Table(name = "concierto")
public class Concierto implements Serializable {

	private static final long serialVersionUID = -3235990393994226233L;

	@Id
	@GeneratedValue
	private int id;
	private String pais;
	private String lugar;
	private Date fecha;
	private String idArtista;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(String idArtista) {
		this.idArtista = idArtista;
	}

	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public boolean equals(Object obj) {
		Concierto p = (Concierto) obj;
		return getId() == p.getId();
	}

	@Override
	public String toString() {
		return String.format("Concierto: lugar=%s, pais=%s", getLugar(), getPais());
	}
}
