package pgh.business.enfermeroCita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.jdbc.Database;

public class EditarEnfermeroCitas {
	
	private static String SQL = "UPDATE ENFERMERO_CITAS SET IDENFERMERO = ? WHERE IDCITA = ? AND IDENFERMERO = ?";
	Database db = new Database();
		
			
		public void AsignarCitaAOtroMedico (int idmedico, int idcita, int idmedico2) {
						
				Connection c = null;
				PreparedStatement pst = null;
				
		
				try {
					c = db.getConnection();
					
					pst = c.prepareStatement(SQL);
									
					pst.setInt(1, idmedico);
					pst.setInt(2, idcita);
					pst.setInt(3, idmedico2);
					
					int retorno =pst.executeUpdate();
				
					System.out.println("enfermeroCitas actualizado");
				
					c.close();
					pst.close();
					
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				
			}

}
