package pgh.business.medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pgh.jdbc.Database;

public class FindMedicoById {
	private static String SQL = "select idMedico, nombre, apellidos, email from Medico where idMedico = ?";
	
	Database db = new Database();
	
		public MedicoDTO execute(int id) {
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			MedicoDTO medico = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				rs.next();
				
				medico = new MedicoDTO();
				medico.idMedico = rs.getInt("idMedico");
				medico.nombre=rs.getString("nombre");;
				medico.apellidos=rs.getString("apellidos");;
				medico.email=rs.getString("email");
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			
			return medico;
		}
}
