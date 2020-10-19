package pgh.business.cita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pgh.jdbc.Database;

public class ConfirmarAsistencia {

	private static String SQL = "Update Cita set asistencia = true where idCita = ";
	
	Database db = new Database();
	
	public void confirmarAsistencia(Cita cita) {
		
		Connection c = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		query.append(cita.getIdCita());
		
		try {
			
			c = db.getConnection();			
			
		    pst = c.prepareStatement(query.toString());
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("asistencia confirmada con exito");
		  

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
