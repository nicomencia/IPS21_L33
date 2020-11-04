package pgh.business.prescripcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import pgh.business.medicamento.Medicamento;
import pgh.jdbc.Database;

public class CrearPrescripcion {
	
	private static String SQL = "Insert into Prescripcion (idPrescripcion, instruccion, hora_Asignacion, dia_Asignacion, es_medicamento) values (?,?,?,?,?) ";
	Database db = new Database();
		
		public void crearPrescripcion(Prescripcion prescripcion) {
			
			Connection c = null;
			ResultSet rs = null;
			PreparedStatement pst = null;
			StringBuilder query=new StringBuilder();
			query.append(SQL);
			
			try {
				
				c = db.getConnection();

				
				java.sql.Date sqlDate = new java.sql.Date(prescripcion.getDiaAsignacion().getTime());
			
			  pst = c.prepareStatement(query.toString());
				pst.setInt(1, prescripcion.getIdPrescripcion());
				pst.setString(2,prescripcion.getInstruccion());
				pst.setString(3, prescripcion.getHoraAsignacion());
				pst.setDate(4,sqlDate);
	      pst.setBoolean(5,prescripcion.esMedicamento());
				
			  pst.executeUpdate();	
			    
			  pst.close();
			  c.close();
			    
			  System.out.print("Prescripcion creada con exito");
			  

				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
}
