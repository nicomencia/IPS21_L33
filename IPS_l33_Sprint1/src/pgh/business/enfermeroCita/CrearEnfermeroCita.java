package pgh.business.enfermeroCita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import pgh.jdbc.Database;

public class CrearEnfermeroCita {
	
	
private static String SQL = "Insert into ENFERMERO_CITAS (idEnfermero,idCita) values (?,?) ";
	
	Database db = new Database();
	
	public void crearEnfermeroCita(EnfermeroCita cita) {
		
		Connection c = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, cita.getIdEnfermero());
			pst.setInt(2, cita.getIdCita());
				
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("EnfermeroCita creada con exito");
		  

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
