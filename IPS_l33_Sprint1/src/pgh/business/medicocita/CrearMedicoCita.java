package pgh.business.medicocita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import pgh.jdbc.Database;

public class CrearMedicoCita {
	
	
private static String SQL = "Insert into MEDICO_CITAS (idMedico,idCita) values (?,?) ";
	
	Database db = new Database();
	
	public void crearMedicoCita(MedicoCita cita) {
		
		Connection c = null;
		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, cita.getIdMedico());
			pst.setInt(2, cita.getIdCita());
				
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("MedicoCita creada con exito");
		  

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


}
