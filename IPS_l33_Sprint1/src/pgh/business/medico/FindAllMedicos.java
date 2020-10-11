package pgh.business.medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllMedicos {
	
	private static String SQL = "select idMedico, nombre, apellidos, email from Medico";
		
	Database db = new Database();
	
		public List<MedicoDTO> execute() {
			List<MedicoDTO> medicos;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				medicos = new ArrayList<>();
				while(rs.next()) {
					MedicoDTO medico = new MedicoDTO();
					medico.idMedico = rs.getString("idMedico");
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
