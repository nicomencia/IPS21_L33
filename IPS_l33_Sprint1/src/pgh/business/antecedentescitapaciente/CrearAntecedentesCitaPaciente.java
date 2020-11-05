package pgh.business.antecedentescitapaciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import pgh.jdbc.Database;

public class CrearAntecedentesCitaPaciente {
	
private static String SQL = "Insert into ANTECEDENTESCLINICOS_CITAS_PACIENTE (idAntecedentesClinicos, idCita, idPaciente) values (?,?,?) ";
	
	Database db = new Database();
	
	public void crearCita(AntecedentesCitaPaciente cita) {
		
		Connection c = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, cita.getIdAntecedente());
			pst.setInt(2, cita.getIdCita());
			pst.setInt(3, cita.getIdPaciente());
			
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    

		    System.out.print("AntecedentesCitaPaciente creada con exito");

		  

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
