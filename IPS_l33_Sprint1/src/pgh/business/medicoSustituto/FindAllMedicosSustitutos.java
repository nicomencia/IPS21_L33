package pgh.business.medicoSustituto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllMedicosSustitutos {
	
	private static String SQL = "select idMedicoSustituto, nombre, apellidos, email from MedicoSustituto";
		
	Database db = new Database();
	
		public List<MedicoSustitutoDTO> execute() {
			List<MedicoSustitutoDTO> medicos;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				medicos = new ArrayList<>();
				while(rs.next()) {
					MedicoSustitutoDTO medico = new MedicoSustitutoDTO();
					medico.idMedicoSustituto = rs.getInt("idMedicoSustituto");
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
