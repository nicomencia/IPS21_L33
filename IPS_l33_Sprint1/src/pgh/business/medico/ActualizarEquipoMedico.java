package pgh.business.medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.jdbc.Database;

public class ActualizarEquipoMedico {

	private static String SQL = "Update Medico Set idequipo_medico = ? where idmedico = ?";

	
	Database db = new Database();
	
	public void actualizar(Medico m, int idEquipo) {
		
		Connection c = null;

		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, idEquipo);
			pst.setInt(2, m.getIdMedico());
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.println("Medico añadido al equipo con exito");
		  

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
