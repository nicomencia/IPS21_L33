package pgh.business.cita;


	

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;


	import pgh.jdbc.Database;

	public class AsignarHorarioCita {
		
	private static String SQL = "Update Cita set idhorario = ? where idcita = ?";
		
		Database db = new Database();
		
		public void updateCita(int idcita, int idhorario) {
			
			Connection c = null;
			PreparedStatement pst = null;
			StringBuilder query=new StringBuilder();
			query.append(SQL);
			
			try {
				
				c = db.getConnection();
			    pst = c.prepareStatement(query.toString());
				pst.setInt(1, idcita);
				pst.setInt(2, idhorario);
				
				
			    pst.executeUpdate();	
			    
			    pst.close();
			    c.close();
			    
			    System.out.print("cita creada con exito");
			  

				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
}
