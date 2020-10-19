package pgh.business.causa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pgh.business.cita.Cita;
import pgh.jdbc.Database;

public class AsignarCausa {

	private static String SQL = "Insert into Causa (idCausa, idCita, idPaciente, descripcion) values (?,?,?,?)";
	
	Database db = new Database();
	
	public void asignarCausa(Causa causa) {
		
		Connection c = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
						
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, causa.getIdCausa());
			pst.setInt(2, causa.getIdCita());
			pst.setInt(3, causa.getIdPaciente());
			pst.setString(4, causa.getDescripcion());			
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("causa creada con exito");
		  

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
