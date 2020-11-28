package pgh.business.citaPropuesta;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import pgh.jdbc.Database;

public class ActualizarPendienteCitaPropuesta {
	
	private static String SQL = "Update CitaPropuesta Set pendienteAprobacion = FALSE where idcitapendiente = ?";

	
	Database db = new Database();
	
	public void actualizar(CitaPropuesta cita) {
		
		Connection c = null;

		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, cita.getIdCitaPropuesta());
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.println("Médico añadido a la cita con exito");
		  

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
