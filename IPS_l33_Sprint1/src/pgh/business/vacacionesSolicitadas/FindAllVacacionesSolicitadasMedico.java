package pgh.business.vacacionesSolicitadas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllVacacionesSolicitadasMedico {

	private static String SQL = "select idVacaciones_Solicitadas_Medico, idMedico, dia_Inicio, dia_Fin, motivo, nombreMedico, aprobadas, canceladas, esperando from Vacaciones_Medico_solicitadas";
	
	Database db = new Database();
	
		public List<VacacionesSolicitadasMedicoDTO> execute() {
			List<VacacionesSolicitadasMedicoDTO> vacacionesMedicos;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				vacacionesMedicos = new ArrayList<>();
				while(rs.next()) {
					VacacionesSolicitadasMedicoDTO vacacionesMedico = new VacacionesSolicitadasMedicoDTO();
					vacacionesMedico.idVacacionesMedicoSolicitadas = rs.getInt("idVacaciones_Solicitadas_Medico");
					vacacionesMedico.idMedico = rs.getInt("idMedico");
					vacacionesMedico.diaInicio = rs.getDate("dia_Inicio");
					vacacionesMedico.diaFin = rs.getDate("dia_Fin");
					vacacionesMedico.motivo = rs.getString("motivo");
					vacacionesMedico.nombreMedico = rs.getString("nombreMedico");
					vacacionesMedico.aprobadas= rs.getBoolean("aprobadas");
					vacacionesMedico.canceladas= rs.getBoolean("canceladas");
					vacacionesMedico.esperando= rs.getBoolean("esperando");
					vacacionesMedicos.add(vacacionesMedico);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return vacacionesMedicos;
		}
	
}
