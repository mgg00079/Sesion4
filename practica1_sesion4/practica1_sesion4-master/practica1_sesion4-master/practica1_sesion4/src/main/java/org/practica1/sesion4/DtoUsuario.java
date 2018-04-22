package org.practica1.sesion4;

import java.io.Serializable;

public class DtoUsuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellidos;
	private String email;
	private String contraseña;
	private String telefono;
	private String cp;
	private Boolean admin;
	
	public DtoUsuario(  String nombre, String apellidos, String email,
			String contraseña, String telefono, String cp, Boolean admin) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contraseña = contraseña;
		this.telefono = telefono;
		this.cp = cp;
		this.admin = false;
	}

	public DtoUsuario() {
		
		this.nombre = "";
		this.apellidos = "";
		this.email = "";
		this.contraseña = "";
		this.telefono = "";
		this.cp = "";
		this.admin = false;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}	
}

