package pgh.business.equipomedico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.jdbc.Database;

public class CrearEquipoMedico {

private static String SQL = "Insert into Equipo_Medico (idEquipo_Medico, nombre) values (?,?) ";

	
	Database db = new Database();
	
	public void crearEquipoMedico(EquipoMedico em) {
		
		Connection c = null;

		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, em.getIdEquipoMedico());
			pst.setString(2, em.getNombreEquipoMedico());
			
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.println("Equipo Medico creado con exito");
		  

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
