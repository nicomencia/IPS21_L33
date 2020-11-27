package pgh.business.vacacionesmedico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.business.vacacionesSolicitadas.VacacionesSolicitadasMedicoDTO;
import pgh.jdbc.Database;

public class FindAllVacacionesMedico {

	private static String SQL = "select idVacaciones_Medico, idMedico, dia_Inicio, dia_Fin from Vacaciones_Medico";
	private static String SQL2 = "select idVacaciones_Medico, idMedico, dia_Inicio, dia_Fin from Vacaciones_Medico where idmedico = ?";
	
	Database db = new Database();
	
		public List<VacacionesMedicoDTO> execute() {
			List<VacacionesMedicoDTO> vacacionesMedicos;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				vacacionesMedicos = new ArrayList<>();
				while(rs.next()) {
					VacacionesMedicoDTO vacacionesMedico = new VacacionesMedicoDTO();
					vacacionesMedico.idVacacionesMedico = rs.getInt("idVacaciones_Medico");
					vacacionesMedico.idMedico = rs.getInt("idMedico");
					vacacionesMedico.diaInicio = rs.getDate("dia_Inicio");
					vacacionesMedico.diaFin = rs.getDate("dia_Fin");
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
		
		
		public List<VacacionesMedicoDTO> FindIdMedico( int idMedico) {
			
			
			List<VacacionesMedicoDTO> vacaciones = new ArrayList<VacacionesMedicoDTO>();
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL2);
							
				pst.setInt(1, idMedico);
				
				rs = pst.executeQuery();

				while(rs.next()) {
					VacacionesMedicoDTO v = new VacacionesMedicoDTO();
					v.idVacacionesMedico = rs.getInt("idVacaciones_Medico");
					v.idMedico = rs.getInt("idMedico");
					v.diaInicio = rs.getDate("dia_Inicio");
					v.diaFin = rs.getDate("dia_Fin");
					
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
