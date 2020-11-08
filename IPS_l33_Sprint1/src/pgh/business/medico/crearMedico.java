package pgh.business.medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.business.cita.Cita;
import pgh.jdbc.Database;

public class crearMedico {
	
	
private static String SQL = "Insert into Medico (idMedico, nombre, apellidos, email) values (?,?,?,?) ";

	
	Database db = new Database();
	
	public void crearMedico(Medico medico) {
		
		Connection c = null;

		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
			
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, medico.getIdMedico());
			pst.setString(2, medico.getNombreMedico());
			pst.setString(3, medico.getApellidosMedico());
			pst.setString(4, medico.getEmailMedico());
			
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("Medico pasado a titular con exito");
		  

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
