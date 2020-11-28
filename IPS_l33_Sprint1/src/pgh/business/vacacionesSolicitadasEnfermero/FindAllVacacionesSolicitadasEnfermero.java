package pgh.business.vacacionesSolicitadasEnfermero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.business.cita.CitaDTO;
import pgh.jdbc.Database;

public class FindAllVacacionesSolicitadasEnfermero {

	private static String SQL = "select idVacaciones_Solicitadas_Enfermero, idEnfermero, dia_Inicio, dia_Fin, motivo, nombreEnfermero, aprobadas, canceladas, esperando from Vacaciones_Enfermero_solicitadas";
	private static String SQL2 = "select idVacaciones_Solicitadas_Enfermero, idEnfermero, dia_Inicio, dia_Fin, motivo, nombreEnfermero, aprobadas, canceladas, esperando from Vacaciones_Enfermero_solicitadas where idEnfermero = ?";
	Database db = new Database();
	
		public List<VacacionesSolicitadasEnfermeroDTO> execute() {
			List<VacacionesSolicitadasEnfermeroDTO> vacacionesMedicos;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				vacacionesMedicos = new ArrayList<>();
				while(rs.next()) {
					VacacionesSolicitadasEnfermeroDTO vacacionesMedico = new VacacionesSolicitadasEnfermeroDTO();
					vacacionesMedico.idVacacionesMedicoSolicitadas = rs.getInt("idVacaciones_Solicitadas_Enfermero");
					vacacionesMedico.idMedico = rs.getInt("idEnfermero");
					vacacionesMedico.diaInicio = rs.getDate("dia_Inicio");
					vacacionesMedico.diaFin = rs.getDate("dia_Fin");
					vacacionesMedico.motivo = rs.getString("motivo");
					vacacionesMedico.nombreMedico = rs.getString("nombreEnfermero");
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
		
		
		public List<VacacionesSolicitadasEnfermeroDTO> FindIdMedico( int idMedico) {
			
			
			List<VacacionesSolicitadasEnfermeroDTO> vacaciones = new ArrayList<VacacionesSolicitadasEnfermeroDTO>();
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL2);
							
				pst.setInt(1, idMedico);
				
				rs = pst.executeQuery();

				while(rs.next()) {
					VacacionesSolicitadasEnfermeroDTO v = new VacacionesSolicitadasEnfermeroDTO();
					v.idVacacionesMedicoSolicitadas = rs.getInt("idVacaciones_Solicitadas_Enfermero");
					v.idMedico = rs.getInt("idEnfermero");
					v.diaInicio = rs.getDate("dia_Inicio");
					v.diaFin = rs.getDate("dia_Fin");
					v.motivo = rs.getString("motivo");
					v.nombreMedico = rs.getString("nombreEnfermero");
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
