package pgh.business.vacacionesSolicitadasEnfermero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.jdbc.Database;

public class RemoveVacacionesSolicitadasEnfermero {
	
private static String SQL = "DELETE FROM VACACIONES_ENFERMERO_SOLICITADAS  WHERE IDENFERMERO=?";
	
	Database db = new Database();
	
	public void borrarSustituto (int idEnfermero) {
		
		Connection c = null;
		PreparedStatement pst = null;
		

		try {
			c = db.getConnection();
			
			pst = c.prepareStatement(SQL);
		
			
			pst.setInt(1, idEnfermero);
	
			int retorno =pst.executeUpdate();
		
			System.out.println("Vacacaciones denegadas borradas");
		
			c.close();
			pst.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
