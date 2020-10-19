package pgh.business.jornadaenfermero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pgh.business.jornadamedico.JornadaMedico;
import pgh.jdbc.Database;

public class CrearJornadaEnfermero {
	
private static String SQL = "Insert into Jornada_Enfermero (idJornada_Enfermero, idEnfermero, dias, dia_Inicio, dia_Fin, hora_Inicio, hora_Fin) values (?,?,?,?,?,?,?) ";
	
	Database db = new Database();
	
	public void crearJornadaEnfermero(JornadaEnfermero jornadaEnfermero) {
		
		Connection c = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
			java.sql.Date diaInicio = new java.sql.Date(jornadaEnfermero.getDiaInicio().getTime());
			java.sql.Date diaFin = new java.sql.Date(jornadaEnfermero.getDiaFin().getTime());
			
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, jornadaEnfermero.getIdJornadaEnfermero());
			pst.setInt(2, jornadaEnfermero.getIdEnfermero());
			pst.setString(3, jornadaEnfermero.getDias());
			pst.setDate(4, diaInicio);
			pst.setDate(5, diaFin);
			pst.setString(6, jornadaEnfermero.getIdHoraInicio());
			pst.setString(7, jornadaEnfermero.getIdHoraFin());

			
			
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
