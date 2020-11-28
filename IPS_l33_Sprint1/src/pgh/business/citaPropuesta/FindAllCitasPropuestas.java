package pgh.business.citaPropuesta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllCitasPropuestas {
	
	private static String SQL = "select idcitapropuesta, idpaciente, idhorario, idubicacion, fecha, urgente, infocontacto, nombrepaciente, medicoasignado, pendienteaprobacion, idmedicoproponer from CitaPropuesta";
	
	Database db = new Database();
	
		public List<CitaPropuestaDTO> execute() {
			
			List<CitaPropuestaDTO> citas;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				citas = new ArrayList<>();
				while(rs.next()) {
					CitaPropuestaDTO cita = new CitaPropuestaDTO();
					cita.idCitaPropuesta = rs.getInt("idcitapropuesta");
					cita.idPaciente  = rs.getInt("idpaciente");
					cita.idHorario  = rs.getInt("idhorario");
					cita.idUbicacion  = rs.getInt("idubicacion");
					cita.fecha=rs.getDate("fecha");
					cita.urgente=rs.getBoolean("urgente");
					cita.infocontacto=rs.getString("infocontacto");
					cita.nombrePaciente=rs.getString("nombrepaciente");
					cita.medicoAsignado=rs.getBoolean("medicoasignado");
					cita.pendienteAprobacion=rs.getBoolean("pendienteaprobacion");
					cita.idMedicoProponer=rs.getInt("idmedicoproponer");
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
