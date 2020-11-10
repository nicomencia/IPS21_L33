package pgh.business.horario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.jdbc.Database;

public class CrearHorario {

private static String SQL = "Insert into Horario (idhorario, hora_inicio, hora_fin) values (?,?,?) ";

	
	Database db = new Database();
	
	public void crearHorario(HorarioDTO horario) {
		
		Connection c = null;

		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
			
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, horario.idHorario);
			pst.setString(2, horario.horaInicio);
			pst.setString(3, horario.horaFin);
			
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("horario creado con exito");
		  

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}
