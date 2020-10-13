package pgh.business.cita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllCitas {
	
	private static String SQL = "select idcita, id_paciente, idmedico, fecha, horaInicio, horaFin, ubicacion, asistencia from Cita";
		
	Database db = new Database();
	
		public List<CitaDTO> execute() {
			
			List<CitaDTO> citas;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				citas = new ArrayList<>();
				while(rs.next()) {
					CitaDTO cita = new CitaDTO();
					cita.idCita = rs.getString("idcita");
					cita.idPaciente  = rs.getString("id_paciente");
					cita.idmedico=rs.getString("idmedico");;
					cita.fecha=rs.getDate("fecha");;
					cita.horaInicio=rs.getString("horainicio");
					cita.horaFin=rs.getString("horafin");
					cita.ubicacion=rs.getString("ubicacion");
					cita.asistencia=rs.getBoolean("asistencia");
					citas.add(cita);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return citas;
		}
	
}
