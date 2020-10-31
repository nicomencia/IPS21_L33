package pgh.jdbc;
import java.sql.*;
import java.util.List;
import java.util.Map;

import pgh.business.MedicoDisplayDTO;
import pgh.business.MedicoEntity;
import pgh.util.UnexpectedException;

/**
 * Ejemplos de acceso a una base de datos con conexion JDBC y base de datos Sqlite
 */
public class Database {
	//informacion de conexion a la base de datos utilizada
	public static final String URL="jdbc:hsqldb:hsql://localhost";
	public static final String USER="SA";
	public static final String PASSWORD="";

	/**
	 * Creacion de tabla para los ejemplos a partir del segundo
	 */
	private void createTable() {
		//el try with resources nos va a asegurar que los objetos cn y stmt siempre se cierran haya o no excepcion
		try (Connection cn=DriverManager.getConnection(URL, USER, PASSWORD)) { //NOSONAR
			try (Statement stmt = cn.createStatement()) {
				//Codigo crear tablas si es necesario
			}
		} catch (SQLException e) {
			//Ojo, no dejar pasar las excepciones (no limitarse a dejar el codigo autoegenerado por Eclipse haciendo solo printStackTrace)
			throw new UnexpectedException(e); //Es mas habitual usar excepciones propias de la aplicacion
		}
	}
	/**
	 * Demo basico de acceso a bases de datos, parte 2:
	 * Uso de he try-with-resources Statement para manejar excepciones y cerrar de forma segura los recursos
	 * (Las mismas acciones que el anterior pero con mejor control de excepciones) y consultas con parametros
	 */
	public void demoPrintMedicos() {
		//createTable();
		int i = 1;
		//En un mismo try se pueden poner diferentes sentencias que crean objetos que gestionan recursos que hay que cerrar
		try (Connection cn=DriverManager.getConnection(URL); //NOSONAR
				Statement stmt=cn.createStatement();
				ResultSet rs=stmt.executeQuery("select nombre from medico order by idmedico desc")) {
			while (rs.next()) { //cada vez que se llama rs.next() avanza el cursor a una fila
			            System.out.print(rs.getString(1));
			        }
			} catch (SQLException e) {
				throw new UnexpectedException(e);
			}
		
	}
	/**
	 * Demo de acceso a bases de datos, parte 3: Consultas con parametros.
	 * Permite definir consultas sql donde alguno de los valores no son conocidos de moemnto (?).
	 * Estos valores se instancian en el momento de la ejecucion.
	 */
	public void demo3Parameters() {
		createTable();
		//En vez de crear un Statement y pasar el sql en executeQuery,
		//se crea un PreparedStatement con el sql, luego se le ponen los parametros y finalmente se ejecuta
		try (Connection cn=DriverManager.getConnection(URL); //NOSONAR
			PreparedStatement pstmt=cn.prepareStatement("select id,id2,text from test where id>=?")) {
			pstmt.setInt(1, 2); // pone valor 2 en el primer (y unico) parametro
			try (ResultSet rs=pstmt.executeQuery()) {
				while (rs.next()) {
					
				}
			}
		} catch (SQLException e) {
			throw new UnexpectedException(e);
		}
		//de forma similar se pueden ejecutar acciones de actualizacion sobre el PreparedStatement
	}
	public List<Object[]> executeQueryArray(String sql, String d, String d2, String d3, String d4, long idCarrera) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<MedicoDisplayDTO> executeQueryPojo(Class<MedicoDisplayDTO> class1, String sql, String d, String d2,
			String d3, String d4, String d5) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<MedicoEntity> executeQueryPojo(Class<MedicoEntity> class1, String sql, int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void createDatabase(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void loadDatabase() {
		// TODO Auto-generated method stub
		
	}
	public List<Object[]> executeQueryArray(String sql, String d, String d2, String d3, String d4, String d5) {
		// TODO Auto-generated method stub
		return null;
	}
	public void executeUpdate(String sql, String dateToIsoString, String dateToIsoString2, int id) {
		// TODO Auto-generated method stub
		
	}
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void close(ResultSet rs, PreparedStatement pst, Connection c) {
		try {
			rs.close();
			pst.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
