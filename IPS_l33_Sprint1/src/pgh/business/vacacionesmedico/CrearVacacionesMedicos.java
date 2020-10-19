package pgh.business.vacacionesmedico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pgh.business.vacacionesenfermero.VacacionesEnfermero;
import pgh.jdbc.Database;

public class CrearVacacionesMedicos {

	private static String SQL = "Insert into Vacaciones_Medico (idVacaciones_Medico, idMedico, dia_Inicio, dia_Fin) values (?,?,?,?) ";
	
	Database db = new Database();
		
	public void crearVacacionesMedico(VacacionesMedico vm) {
			
		Connection c = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
			
		try {
				
			c = db.getConnection();
				
			java.sql.Date sqlDateInicio = new java.sql.Date(vm.getFechaInicio().getTime());
			java.sql.Date sqlDateFin = new java.sql.Date(vm.getFechaFin().getTime());
				
				
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, vm.getIdVacacionesMedico());
			pst.setInt(2, vm.getIdMedico());
			pst.setDate(3, sqlDateInicio);
			pst.setDate(4, sqlDateFin);				
				
		    pst.executeUpdate();	
			    
		    pst.close();
		    c.close();
			    
			   System.out.print("vm creada con exito");
			  

				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
	}
	
}
