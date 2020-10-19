package pgh.business.cita;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import pgh.jdbc.Database;

public class CrearCitas {
	
	private static String SQL = "Insert into Cita (idcita, idpaciente, idhorario, fecha, horaInicio, horaFin, ubicacion, asistencia, urgente, infocontacto) values (?,?,?,?,?,?,?,?,?,?) ";
	
	Database db = new Database();
	
	public void crearCita(Cita cita) {
		
		Connection c = null;
		ResultSet rs = null;
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
			pst.setDate(4, sqlDate);
			pst.setString(5,cita.getHoraInicio());
			pst.setString(6, cita.getHoraFinal());
			pst.setString(7, cita.getUbicacion());
			pst.setBoolean(8, cita.getAsistencia());
			pst.setBoolean(9, cita.getUrgente());
			pst.setString(10, cita.infoContacto());
			
			
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
