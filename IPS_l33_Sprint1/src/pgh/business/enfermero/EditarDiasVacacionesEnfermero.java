package pgh.business.enfermero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.jdbc.Database;

public class EditarDiasVacacionesEnfermero {
	
private static String SQL = "Update Enfermero Set diasdisponibles = ? where idenfermero = ?";

	
	Database db = new Database();
	
	public void actualizar(int dias, int idMedico) {
		
		Connection c = null;

		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, dias);
			pst.setInt(2, idMedico);
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.println("dias actualizados");
		  

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
