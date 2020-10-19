package pgh.business.jornadamedico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pgh.jdbc.Database;

public class CrearJornadaMedico {
	
private static String SQL = "Insert into Jornada_Medico (idJornada_Medico, idMedico, dias, dia_Inicio, dia_Fin, hora_Inicio, hora_Fin) values (?,?,?,?,?,?,?) ";
	
	Database db = new Database();
	
	public void crearJornadaMedico(JornadaMedico jornadaMedico) {
		
		Connection c = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
			java.sql.Date diaInicio = new java.sql.Date(jornadaMedico.getDiaInicio().getTime());
			java.sql.Date diaFin = new java.sql.Date(jornadaMedico.getDiaFin().getTime());
			
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, jornadaMedico.getIdJornadaMedico());
			pst.setInt(2, jornadaMedico.getIdMedico());
			pst.setString(3, jornadaMedico.getDias());
			pst.setDate(4, diaInicio);
			pst.setDate(5, diaFin);
			pst.setString(6, jornadaMedico.getIdHoraInicio());
			pst.setString(7, jornadaMedico.getIdHoraFin());

			
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("jornadaMedico creada con exito");
		  

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
