package pgh.business.medicamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pgh.business.cita.Cita;
import pgh.jdbc.Database;

public class CrearMedicamento {
	
	private static String SQL = "Insert into Medicamento (idmedicamento, idprescripcion, nombre, cantidad, intervalo, duracion, anotacion) values (?,?,?,?,?,?,?) ";
	Database db = new Database();
	
	public void crearMedicamento(Medicamento medicamento) {
		
		Connection c = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();	
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, medicamento.getIdMedicamento());
			pst.setInt(2, medicamento.getIdPrescripcion());
			pst.setString(3,medicamento.getNombre());
			pst.setInt(4, medicamento.getCantidad());
			pst.setString(5,medicamento.getIntervalo());
			pst.setString(6, medicamento.getDuracion());
			pst.setString(7, medicamento.getAnotacion());
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("Medicacion creada con exito");
		  

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
