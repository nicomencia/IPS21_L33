package pgh.business.vacacionesenfermero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.business.cita.Cita;
import pgh.jdbc.Database;

public class CrearVacacionesEnfermero {
	
private static String SQL = "Insert into Vacaciones_Enfermero (idVacaciones_Enfermero, idEnfermero, dia_Inicio, dia_Fin) values (?,?,?,?) ";

	
	Database db = new Database();
	
	public void crearVacaciones(VacacionesEnfermero vacaciones) {
		
		Connection c = null;

		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
			java.sql.Date fechaInicio = new java.sql.Date(vacaciones.getFechaInicio().getTime());
			java.sql.Date fechaFin = new java.sql.Date(vacaciones.getFechaFin().getTime());
			
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, vacaciones.getIdVacaciones());
			pst.setInt(2, vacaciones.getIdMedico());
			pst.setDate(3, fechaInicio);
			pst.setDate(4, fechaFin);
	
		
			
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("vacaciones creada con exito");
		  

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
