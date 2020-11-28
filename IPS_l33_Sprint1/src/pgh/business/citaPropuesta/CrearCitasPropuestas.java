package pgh.business.citaPropuesta;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import pgh.jdbc.Database;

public class CrearCitasPropuestas {
	

private static String SQL = "Insert into CitaPropuesta (idcitapropuesta, idpaciente, idhorario, idubicacion, fecha, urgente, infocontacto, nombrepaciente, medicoasignado, pendienteaprobacion, idmedicoproponer) values (?,?,?,?,?,?,?,?,?,?,?) ";
	
	Database db = new Database();
	
	public void crearCita(CitaPropuesta cita) {
		
		Connection c = null;

		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
			java.sql.Date sqlDate = new java.sql.Date(cita.getDate().getTime());
			
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, cita.getIdCitaPropuesta());
			pst.setInt(2, cita.getIdPaciente());
			pst.setInt(3, cita.getIdHorario());
			pst.setInt(4, cita.getIdUbicacion());
			pst.setDate(5, sqlDate);
			pst.setBoolean(6, cita.getUrgente());
			pst.setString(7, cita.infoContacto());
			pst.setString(8, cita.getNombrePaciente());
			pst.setBoolean(9, cita.getMedicoAsignado());
			pst.setBoolean(10, cita.getPendienteAprobacion());
			pst.setInt(11, cita.getIdMedicoProponer());
			
			
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
