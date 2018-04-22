package org.practica1.sesion4;

import java.util.List;
import java.util.ArrayList;

public class DaoUsuarioTest implements UsuarioDaoInterface {
	
	public void creaTabla() {
		
	}
	
	
	public void insertarUsuario(DtoUsuario usuarios) {
		
	}
	
	public List<DtoUsuario> leerUsuarios(){
		
		List<DtoUsuario> lista = new ArrayList<DtoUsuario>();
		lista.add(new DtoUsuario("Manuel", "Casquel", "manuelcasquel@gmail.com", "123456", "676220945", "23700", true));
		lista.add(new DtoUsuario("Marta", "Gonzalez", "martagonzalez@gmail.com", "123456", "685545617", "23700", false));
		
		return lista;
	}

}
