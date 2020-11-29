package pgh.business.enfermeroCitaPropuesta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.jdbc.Database;

public class CrearEnfermeroCitaPropuesta {

private static String SQL = "Insert into ENFERMERO_CITASPROPUESTAS (idEnfermero,idCitaPropuesta) values (?,?) ";
	
	Database db = new Database();
	
	public void crearEnfermeroCitaPropuesta(EnfermeroCitaPropuesta cita) {
		
		Connection c = null;
		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, cita.getIdEnfermero());
			pst.setInt(2, cita.getIdCitaPropuesta());
				
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("EnfermeroCitaPropuesta creada con exito");
		  

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
