package pgh.business.vacacionesSolicitadas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.jdbc.Database;

public class RemoveVacacionesSolicitadas {
	
private static String SQL = "DELETE FROM VACACIONES_MEDICO_SOLICITADAS  WHERE IDMEDICO=?";
	
	Database db = new Database();
	
	public void borrarSustituto (int idMedico) {
		
		Connection c = null;
		PreparedStatement pst = null;
		

		try {
			c = db.getConnection();
			
			pst = c.prepareStatement(SQL);
		
			
			pst.setInt(1, idMedico);
	
			int retorno =pst.executeUpdate();
		
			System.out.println("Vacacaciones denegadas borradas");
		
			c.close();
			pst.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
