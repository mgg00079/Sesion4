package org.sesion4.practica1;

import java.util.List;

public interface DaoUsuarioInterface {
	public void creaTabla();
	public void insertarUsuario(DtoUsuario usuarios);
	public List<DtoUsuario> leerUsuarios();
}