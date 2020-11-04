package pgh.business.jornadamedico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.business.cita.CitaDTO;
import pgh.jdbc.Database;

public class FindAllJornadasMedico {

	private static String SQL = "select idJornada_Medico, idMedico, dias, dia_Inicio, dia_Fin, hora_Inicio, hora_Fin from Jornada_Medico";
	private static String SQL2 = "select idJornada_Medico, idMedico, dias, dia_Inicio, dia_Fin, hora_Inicio, hora_Fin from Jornada_Medico where idMedico = ?";
	Database db = new Database();
	
		public List<JornadaMedicoDTO> execute() {
			List<JornadaMedicoDTO> jornadasMedico;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				jornadasMedico = new ArrayList<>();
				while(rs.next()) {
					JornadaMedicoDTO jornadaMedico = new JornadaMedicoDTO();
					jornadaMedico.idJornadaMedico = rs.getInt("idJornada_Medico");
					jornadaMedico.idMedico = rs.getInt("idMedico");
					jornadaMedico.dias = rs.getString("dias");
					jornadaMedico.diaInicio = rs.getDate("dia_Inicio");
					jornadaMedico.diaFin = rs.getDate("dia_Fin");
					jornadaMedico.horaInicio = rs.getString("hora_Inicio");
					jornadaMedico.horaFin = rs.getString("hora_Fin");
					jornadasMedico.add(jornadaMedico);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return jornadasMedico;
		}
		
		
public List<JornadaMedicoDTO> FindIdMedico( int idMedico) {
			
			
			List<JornadaMedicoDTO> jornadasMedico = new ArrayList<JornadaMedicoDTO>();
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL2);
							
				pst.setInt(1, idMedico);
				
				rs = pst.executeQuery();

				while(rs.next()) {
					JornadaMedicoDTO jornadaMedico = new JornadaMedicoDTO();
					jornadaMedico.idJornadaMedico = rs.getInt("idJornada_Medico");
					jornadaMedico.idMedico = rs.getInt("idMedico");
					jornadaMedico.dias = rs.getString("dias");
					jornadaMedico.diaInicio = rs.getDate("dia_Inicio");
					jornadaMedico.diaFin = rs.getDate("dia_Fin");
					jornadaMedico.horaInicio = rs.getString("hora_Inicio");
					jornadaMedico.horaFin = rs.getString("hora_Fin");
					jornadasMedico.add(jornadaMedico);
				}
				
			
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			
			return jornadasMedico;
		}
	
}
