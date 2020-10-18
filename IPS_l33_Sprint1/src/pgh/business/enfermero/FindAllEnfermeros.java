package pgh.business.enfermero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllEnfermeros {

	private static String SQL = "select idEnfermero, nombre, apellidos from Enfermero";
	
	Database db = new Database();
	
		public List<EnfermeroDTO> execute() {
			List<EnfermeroDTO> enfermeros;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				enfermeros = new ArrayList<>();
				while(rs.next()) {
					EnfermeroDTO enfermero = new EnfermeroDTO();
					enfermero.idEnfermero = rs.getInt("idEnfermero");
					enfermero.nombre=rs.getString("nombre");
					enfermero.apellidos=rs.getString("apellidos");
					enfermeros.add(enfermero);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return enfermeros;
		}
	
}
