package pgh.business.registro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.jdbc.Database;

public class CrearRegistro {

private static String SQL = "Insert into REGISTRO (idRegistro,fecha,descripcion) values (?,?,?) ";
	
	Database db = new Database();
	
	public void crearRegistro(Registro registro) {
		
		Connection c = null;
		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, registro.getIdRegistro());
			pst.setDate(2, registro.getFecha());
			pst.setString(3, registro.getDescripcion());
				
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("Registro creado con exito");
		  
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
