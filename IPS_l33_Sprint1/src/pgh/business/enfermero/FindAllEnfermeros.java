package pgh.business.enfermero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.business.medico.MedicoDTO;
import pgh.jdbc.Database;

public class FindAllEnfermeros {

	private static String SQL = "select idEnfermero, nombre, apellidos, especialidad, idEquipo_Medico from Enfermero";
	private static String SQL2 = "select diasdisponibles from Enfermero where idEnfermero = ? ";
	
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
					enfermero.especialidad=rs.getString("especialidad");
					enfermero.idEquipoMedico=rs.getInt("idEquipo_Medico");
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
		

		public EnfermeroDTO diasDisponibles(int id) {
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			EnfermeroDTO medico = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL2);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				rs.next();
				
				medico = new EnfermeroDTO();
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
