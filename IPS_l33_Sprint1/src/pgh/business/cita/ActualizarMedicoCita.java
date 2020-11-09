package pgh.business.cita;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import pgh.jdbc.Database;

public class ActualizarMedicoCita {
	

private static String SQL = "Update Cita Set medicoasignado = TRUE where idcita = ?";

	
	Database db = new Database();
	
	public void actualizar(Cita cita) {
		
		Connection c = null;

		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
			java.sql.Date sqlDate = new java.sql.Date(cita.getDate().getTime());
			
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, cita.getIdCita());
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.println("Médico añadido a la cita con exito");
		  

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
