package pgh.business.medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.business.cita.Cita;
import pgh.jdbc.Database;

public class CrearMedico {
	
	
private static String SQL = "Insert into Medico (idMedico, nombre, apellidos, email, especialidad, idEquipo_Medico) values (?,?,?,?,?,?) ";

	
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
			pst.setString(4, medico.getEspecialidad());
			pst.setInt(5, medico.getIdEquipoMedico());
			
			
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
