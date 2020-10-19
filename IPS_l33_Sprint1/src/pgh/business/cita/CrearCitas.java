package pgh.business.cita;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





import pgh.jdbc.Database;

public class CrearCitas {
	

private static String SQL = "Insert into Cita (idcita, idpaciente, idhorario, idubicacion, fecha, asistencia, urgente, infocontacto) values (?,?,?,?,?,?,?,?) ";

	
	Database db = new Database();
	
	public void crearCita(Cita cita) {
		
		Connection c = null;

		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
			java.sql.Date sqlDate = new java.sql.Date(cita.getDate().getTime());
			
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, cita.getIdCita());
			pst.setInt(2, cita.getIdPaciente());
			pst.setInt(3, cita.getIdHorario());
			pst.setInt(4, cita.getIdUbicacion());
			pst.setDate(5, sqlDate);
			pst.setBoolean(6, cita.getAsistencia());
			pst.setBoolean(7, cita.getUrgente());
			pst.setString(8, cita.infoContacto());
			
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("cita creada con exito");
		  

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
