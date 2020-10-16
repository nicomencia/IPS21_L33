package pgh.business.historial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllHistorial {

	private static String SQL = "select idHistorial, id_paciente from Historial";
	
	Database db = new Database();
	
		public List<HistorialDTO> execute() {
			List<HistorialDTO> historiales;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				historiales = new ArrayList<>();
				while(rs.next()) {
					HistorialDTO historial = new HistorialDTO();
					historial.idHistorial = rs.getInt("idHistorial");
					historial.idPaciente = rs.getInt("id_paciente");
					historiales.add(historial);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return historiales;
		}
	
}
