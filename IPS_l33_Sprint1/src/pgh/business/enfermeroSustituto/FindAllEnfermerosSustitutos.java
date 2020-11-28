package pgh.business.enfermeroSustituto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllEnfermerosSustitutos {
	
	private static String SQL = "select idEnfermeroSustituto, nombre, apellidos, email from EnfermeroSustituto";
		
	Database db = new Database();
	
		public List<EnfermeroSustitutoDTO> execute() {
			List<EnfermeroSustitutoDTO> medicos;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				medicos = new ArrayList<>();
				while(rs.next()) {
					EnfermeroSustitutoDTO medico = new EnfermeroSustitutoDTO();
					medico.idMedicoSustituto = rs.getInt("idEnfermeroSustituto");
					medico.nombre=rs.getString("nombre");;
					medico.apellidos=rs.getString("apellidos");;
					medico.email=rs.getString("email");
					medicos.add(medico);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			
			return medicos;
		}
	
}
