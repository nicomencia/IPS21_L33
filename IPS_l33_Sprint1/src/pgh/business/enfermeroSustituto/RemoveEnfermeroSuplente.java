package pgh.business.enfermeroSustituto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import pgh.jdbc.Database;

public class RemoveEnfermeroSuplente {
	
	private static String SQL = "DELETE FROM ENFERMEROSUSTITUTO WHERE IDENFERMEROSUSTITUTO=?";
	
	Database db = new Database();
	
	public void borrarSustituto (int idMedico) {
		
		Connection c = null;
		PreparedStatement pst = null;
		

		try {
			c = db.getConnection();
			
			pst = c.prepareStatement(SQL);
		
			
			pst.setInt(1, idMedico);
	
			int retorno =pst.executeUpdate();
		
			System.out.println("Enfermero sustituto borrado");
		
			c.close();
			pst.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
