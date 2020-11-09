package pgh.business.enfermero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.business.medico.Medico;
import pgh.jdbc.Database;

public class ActualizarEquipoEnfermero {

	private static String SQL = "Update Enfermero Set idequipo_medico = ? where idenfermero = ?";

	
	Database db = new Database();
	
	public void actualizar(Enfermero enf, int idEquipo) {
		
		Connection c = null;

		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, idEquipo);
			pst.setInt(2, enf.getIdEnfermero());
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.println("Enfermero añadido al equipo con exito");
		  

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
