package org.practica1.sesion4;

import java.util.ArrayList;
import java.util.List;

public class DaoUsuarioTest implements DaoUsuarioInterface {
	
	@Override
	public void creaTabla() {

		
	}

	@Override
	public void insertarUsuario(DtoUsuario usuarios) {

		
	}

	@Override
	public List<DtoUsuario> leerUsuarios() {

		List<DtoUsuario> lista = new ArrayList<DtoUsuario>();
		lista.add(new DtoUsuario("Manuel", "Casquel", "manuelcasquel@gmail.com", "123456", "676220945", "23700", true));
		lista.add(new DtoUsuario("Marta", "Gonzalez", "martagonzalez@gmail.com", "123456", "123456789", "23700", false));
		return lista;
	}
}
