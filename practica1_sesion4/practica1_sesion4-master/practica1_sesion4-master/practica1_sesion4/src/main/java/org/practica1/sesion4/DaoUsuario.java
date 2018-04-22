package org.practica1.sesion4;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DaoUsuario implements DaoUsuarioInterface {
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		   this.dataSource = dataSource;
		   this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void creaTabla(){
		this.jdbcTemplate.execute("CREATE TABLE Usuarios(Id int not null AUTO_INCREMENT,"
				+ "Nombre varchar(20), Apellidos varchar(20), Email varchar(20), Contraseña varchar(20),"
				+ "Telefono varchar(12), Codigo Postal varchar(5), Admin boolean, PRIMARY KEY(Id))");
	}
	public void insertarUsuario(DtoUsuario usuarios){
		//Sentencia SQL
		String sql = "INSERT INTO Usuarios VALUES(?,?,?,?,?,?,?)";
		
		//Indicamos los parametros (tipo de objeto generico), para la consulta
		//Cuidado con el orden de parámetros, ya que la base de datos puede interpretar mal
		Object[] parametros ={usuarios.getNombre(),usuarios.getApellidos(),usuarios.getEmail(),
				usuarios.getContraseña(),usuarios.getTelefono(),usuarios.getCp(),
				usuarios.getAdmin()};

		this.jdbcTemplate.update(sql,parametros);
	}
	
	public List<DtoUsuario> leerUsuarios(){
		String sql = "SELECT * FROM Usuarios";
		UsuarioMapper mapper = new UsuarioMapper();
		List<DtoUsuario> lista = this.jdbcTemplate.query(sql, mapper);
		return lista;
	}
}
