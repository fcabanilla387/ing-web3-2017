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
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -3235990393994226233L;

	@Id
	@GeneratedValue
	private int id;
	private String usuario;
	private String contraseña;
	private String mail;
	private String pais;
	private boolean premiun;
	//private ArrayList<Artista> seguidos ;
	//private ArrayList<Cancion> playlist;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public boolean isPremiun() {
		return premiun;
	}

	public void setPremiun(boolean premiun) {
		this.premiun = premiun;
	}


	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public boolean equals(Object obj) {
		Usuario p = (Usuario) obj;
		return getId() == p.getId();
	}

	@Override
	public String toString() {
		return String.format("Usuario: usuario=%s, pais=%s", getUsuario(), getPais());
	}
}
