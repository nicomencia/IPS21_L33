package pgh.business.horario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pgh.business.cita.Cita;
import pgh.jdbc.Database;

public class ActualizarHorario {

	//private static String SQL = ;
	
	Database db = new Database();
	
	public void actualizarHorario(Horario horario) {
		
		Connection c = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		String horaInicio = horario.getHoraInicio().toString();
		String horaFin = horario.getHoraFin().toString();
		String SQL = "Update Horario set hora_Inicio = '" + horaInicio + "', hora_Fin = '" + horaFin + "' where idHorario = " + horario.getIdHorario();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();			
			
		    pst = c.prepareStatement(query.toString());
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("horario modificado con exito");
		  

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
