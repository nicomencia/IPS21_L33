package pgh.business.medicoCitaPropuesta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.jdbc.Database;

public class CrearMedicoCitaPropuesta {

private static String SQL = "Insert into MEDICO_CITASPROPUESTAS (idMedico,idCitaPropuesta) values (?,?) ";
	
	Database db = new Database();
	
	public void crearMedicoCita(MedicoCitaPropuesta cita) {
		
		Connection c = null;
		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, cita.getIdMedico());
			pst.setInt(2, cita.getIdCitaPropuesta());
				
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("MedicoCitaPropuesta creada con exito");
		  
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
    
}
