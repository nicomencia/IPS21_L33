package pgh.business.vacacionesSolicitadas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.business.cita.CitaDTO;
import pgh.jdbc.Database;

public class FindAllVacacionesSolicitadasMedico {

	private static String SQL = "select idVacaciones_Solicitadas_Medico, idMedico, dia_Inicio, dia_Fin, motivo, nombreMedico, aprobadas, canceladas, esperando from Vacaciones_Medico_solicitadas";
	private static String SQL2 = "select idVacaciones_Solicitadas_Medico, idMedico, dia_Inicio, dia_Fin, motivo, nombreMedico, aprobadas, canceladas, esperando from Vacaciones_Medico_solicitadas where idmedico = ?";
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
		
		
		public List<VacacionesSolicitadasMedicoDTO> FindIdMedico( int idMedico) {
			
			
			List<VacacionesSolicitadasMedicoDTO> vacaciones = new ArrayList<VacacionesSolicitadasMedicoDTO>();
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL2);
							
				pst.setInt(1, idMedico);
				
				rs = pst.executeQuery();

				while(rs.next()) {
					VacacionesSolicitadasMedicoDTO v = new VacacionesSolicitadasMedicoDTO();
					v.idVacacionesMedicoSolicitadas = rs.getInt("idVacaciones_Solicitadas_Medico");
					v.idMedico = rs.getInt("idMedico");
					v.diaInicio = rs.getDate("dia_Inicio");
					v.diaFin = rs.getDate("dia_Fin");
					v.motivo = rs.getString("motivo");
					v.nombreMedico = rs.getString("nombreMedico");
					v.aprobadas= rs.getBoolean("aprobadas");
					v.canceladas= rs.getBoolean("canceladas");
					v.esperando= rs.getBoolean("esperando");
					
					vacaciones.add(v);
				}
				
			
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			
			return vacaciones;
		}
	
	
}
