package pgh.business.enfermedad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllEnfermedades {
	
private static String SQL = "select id_emfermedad, nombre, fecha_inicio, id_paciente from Emfermedad";
	
	Database db = new Database();
	
		public List<EnfermedadDTO> execute() {
			List<EnfermedadDTO> enfermedades;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				enfermedades = new ArrayList<>();
				while(rs.next()) {
					EnfermedadDTO enfermedad = new EnfermedadDTO();
					enfermedad.id_emfermedad = rs.getInt("id_emfermedad");
					enfermedad.nombre = rs.getString("nombre");
					enfermedad.fecha_inicio = rs.getDate("fecha_inicio");
					enfermedad.id_paciente = rs.getInt("id_paciente");
					enfermedades.add(enfermedad);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return enfermedades;
		}
}
