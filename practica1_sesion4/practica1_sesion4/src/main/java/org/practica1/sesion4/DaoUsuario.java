package org.practica1.sesion4;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DaoUsuario implements UsuarioDaoInterface {
	
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource=dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	public void creaTabla() {
		
		this.jdbcTemplate.execute("CREATE TABLE Usuarios (Id int not null AUTO_INCREMENT,"
				+ "Nombre varchar(20), Apellidos varchar(20), Email varchar(20), Contraseña varchar(10),"
				+ "Telefono varchar(12), Codigo Postal varchar(6), Admin boolean, PRIMARY KEY(Id))");
		
	}
	
	public void insertarUsuario(DtoUsuario usuarios) {
		
		String sql = "INSERT INTO Usuarios VALUES(?,?,?,?,?,?,?)";
		
		Object[] parametros = {usuarios.getNombre(), usuarios.getApellidos(), usuarios.getEmail(),
				usuarios.getContraseña(), usuarios.getTelefono(), usuarios.getCp(), usuarios.getAdmin()};
		
		this.jdbcTemplate.update(sql, parametros);
		
	}
	
	public List<DtoUsuario> leerUsuarios(){
		
		String sql = "SELECT * FROM Usuarios";
		UsuarioMapper mapper = new UsuarioMapper();
		List<DtoUsuario> lista = this.jdbcTemplate.query(sql, mapper);
		return lista;
		
	}
	
}
