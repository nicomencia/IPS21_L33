package pgh.business.diagnostico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllDiagnosticos {
	
	private static String SQL = "select idDiagnostico, idCita, descripcion from Diagnostico";
	
	Database db = new Database();
	
		public List<DiagnosticoDTO> execute() {
			List<DiagnosticoDTO> diagnosticos;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				diagnosticos = new ArrayList<>();
				while(rs.next()) {
					DiagnosticoDTO diagnostico = new DiagnosticoDTO();
					diagnostico.idDiagnostico = rs.getString("idDiagnostico");
					diagnostico.idCita = rs.getString("idCita");
					diagnostico.descripcion = rs.getString("descripcion");
					diagnosticos.add(diagnostico);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return diagnosticos;
		}
	
}
