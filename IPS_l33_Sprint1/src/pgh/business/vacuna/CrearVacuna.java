package pgh.business.vacuna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pgh.business.antecedentesClinicos.Antecedentes;
import pgh.business.medicamento.Medicamento;
import pgh.jdbc.Database;

public class CrearVacuna {
	
	private static String SQL = "Insert into VACUNA (IDVACUNA, IDPACIENTE, NOMBREVACUNA, DIAASIGNADA, DIAPUESTA, HORAPUESTA, OBSERVACION, ISPUESTA) values (?,?,?,?,?,?,?,?) ";
	Database db = new Database();
		
		public void crearVacuna(Vacuna vacuna) {
			
			Connection c = null;
			ResultSet rs = null;
			PreparedStatement pst = null;
			StringBuilder query=new StringBuilder();
			query.append(SQL);
			
			try {
				
				c = db.getConnection();

				
				java.sql.Date date1 = new java.sql.Date(vacuna.getDiaAsignacion().getTime());
				java.sql.Date date2 = new java.sql.Date(vacuna.getDiaVacunacion().getTime());
			
				pst = c.prepareStatement(query.toString());
				pst.setInt(1, vacuna.getIdVacuna());
				pst.setInt(2, vacuna.getIdPaciente());
				System.out.println("tiene paciente " + vacuna.getIdPaciente());
				pst.setString(3,vacuna.getNombreVacuna());
				pst.setDate(4, date1);
				pst.setDate(5, date2);
				pst.setString(6,vacuna.getHoraAsignacion());
				pst.setString(7,vacuna.getObservacion());
				pst.setBoolean(8,vacuna.isPuesta());
				
				pst.executeUpdate();	
			    
				pst.close();
				c.close();
			    
				System.out.print("Vacuna creada con exito");
			  

				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
}
