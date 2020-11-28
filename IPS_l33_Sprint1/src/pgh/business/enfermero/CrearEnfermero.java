package pgh.business.enfermero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.business.cita.Cita;
import pgh.jdbc.Database;

public class CrearEnfermero {
	
	
private static String SQL = "Insert into Enfermero (idEnfermero, nombre, apellidos, especialidad, idEquipo_Medico, diasdisponibles) values (?,?,?,?,?,?) ";

	
	Database db = new Database();
	
	public void crearMedico(Enfermero medico) {
		
		Connection c = null;

		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
			
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, medico.getIdEnfermero());
			pst.setString(2, medico.getNombreEnfermero());
			pst.setString(3, medico.getApellidosEnfermo());
			pst.setString(4, medico.getEspecialidad());
			pst.setInt(5, medico.getIdEquipoMedico());
			pst.setInt(6, medico.getDiasDisponibles());
			
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("Enfermero pasado a titular con exito");
		  

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
