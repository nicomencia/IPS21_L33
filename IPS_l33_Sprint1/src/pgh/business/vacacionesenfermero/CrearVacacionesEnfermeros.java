package pgh.business.vacacionesenfermero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pgh.business.cita.Cita;
import pgh.jdbc.Database;

public class CrearVacacionesEnfermeros {
		
	private static String SQL = "Insert into Vacaciones_Enfermero (idVacaciones_Enfermero, idEnfermero, dia_Inicio, dia_Fin) values (?,?,?,?) ";
		
	Database db = new Database();
		
	public void crearVacacionesEnfermero(VacacionesEnfermero ve) {
			
		Connection c = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
			
		try {
				
			c = db.getConnection();
				
			java.sql.Date sqlDateInicio = new java.sql.Date(ve.getFechaInicio().getTime());
			java.sql.Date sqlDateFin = new java.sql.Date(ve.getFechaFin().getTime());
				
				
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, ve.getIdVacacionesEnfermero());
			pst.setInt(2, ve.getIdEnfermero());
			pst.setDate(3, sqlDateInicio);
			pst.setDate(4, sqlDateFin);				
				
		    pst.executeUpdate();	
			    
		    pst.close();
		    c.close();
			    
			   System.out.print("ve creada con exito");
			  

				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
	}
		
}
