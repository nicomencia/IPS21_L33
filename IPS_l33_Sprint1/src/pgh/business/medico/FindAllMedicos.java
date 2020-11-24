package pgh.business.medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllMedicos {
	
	private static String SQL = "select idMedico, nombre, apellidos, email, especialidad, idEquipo_Medico, diasdisponibles from Medico";
	private static String SQL2 = "select diasdisponibles from Medico where idMedico = ? ";
		
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
					medico.idMedico = rs.getInt("idMedico");
					medico.nombre=rs.getString("nombre");;
					medico.apellidos=rs.getString("apellidos");;
					medico.email=rs.getString("email");
					medico.especialidad=rs.getString("especialidad");
					medico.idEquipoMedico=rs.getInt("idEquipo_Medico");
					medico.diasDisponibles = rs.getInt("diasdisponibles");
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
		
		public MedicoDTO diasDisponibles(int id) {
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			MedicoDTO medico = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL2);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				rs.next();
				
				medico = new MedicoDTO();
				medico.diasDisponibles = rs.getInt("diasdisponibles");
				
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			
			return medico;
		}
	
}
