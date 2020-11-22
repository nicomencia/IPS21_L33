package pgh.business.vacuna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pgh.jdbc.Database;

public class EditarVacuna {
	
	private static String SQL = "UPDATE VACUNA SET ISPUESTA = ? WHERE IDVACUNA = ? ";
	Database db = new Database();
		
			
		public void modificarEstados (boolean ispuesta, int idVacuna) {
						
				Connection c = null;
				PreparedStatement pst = null;
				
		
				try {
					c = db.getConnection();
					
					pst = c.prepareStatement(SQL);
					
					
					pst.setBoolean(1, ispuesta);
					
					pst.setInt(2, idVacuna);
					
					
					int retorno =pst.executeUpdate();
					
				
				
					c.close();
					pst.close();
					
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				
			}

}
