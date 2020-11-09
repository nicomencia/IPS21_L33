package pgh.business.cita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import pgh.jdbc.Database;

public class EditarCita {
	
	private static String SQL = "UPDATE CITA SET FECHA = ? WHERE IDCITA = ?";
	Database db = new Database();
		
			
		public void editarFecha (Date date, int idCita) {
						
				Connection c = null;
				PreparedStatement pst = null;
				
		
				try {
					c = db.getConnection();
					
					pst = c.prepareStatement(SQL);
					
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					
					
					pst.setDate(1, sqlDate);
					pst.setInt(2, idCita);
			
					int retorno =pst.executeUpdate();
				
					System.out.println("Cita actualizada");
				
					c.close();
					pst.close();
					
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				
			}

}
