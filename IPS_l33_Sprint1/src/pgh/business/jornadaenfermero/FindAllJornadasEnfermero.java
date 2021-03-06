package pgh.business.jornadaenfermero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.business.jornadamedico.JornadaMedicoDTO;
import pgh.jdbc.Database;

public class FindAllJornadasEnfermero {

	private static String SQL = "select idJornada_Enfermero, idEnfermero, dias, dia_Inicio, dia_Fin, hora_Inicio, hora_Fin from Jornada_Enfermero";
	private static String SQL2 = "select idJornada_Enfermero, idEnfermero, dias, dia_Inicio, dia_Fin, hora_Inicio, hora_Fin from Jornada_Enfermero where idEnfermero = ?";
	
	Database db = new Database();
	
		public List<JornadaEnfermeroDTO> execute() {
			List<JornadaEnfermeroDTO> jornadasEnfermero;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				jornadasEnfermero = new ArrayList<>();
				while(rs.next()) {
					JornadaEnfermeroDTO jornadaEnfermero = new JornadaEnfermeroDTO();
					jornadaEnfermero.idJornadaEnfermero = rs.getInt("idJornada_Enfermero");
					jornadaEnfermero.idEnfermero = rs.getInt("idEnfermero");
					jornadaEnfermero.dias = rs.getString("dias");
					jornadaEnfermero.diaInicio = rs.getDate("dia_Inicio");
					jornadaEnfermero.diaFin = rs.getDate("dia_Fin");
					jornadaEnfermero.horaInicio = rs.getString("hora_Inicio");
					jornadaEnfermero.horaFin = rs.getString("hora_Fin");
					jornadasEnfermero.add(jornadaEnfermero);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return jornadasEnfermero;
		}
		
public List<JornadaEnfermeroDTO> FindIdMedico( int idMedico) {
			
			
			List<JornadaEnfermeroDTO> jornadasMedico = new ArrayList<JornadaEnfermeroDTO>();
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL2);
							
				pst.setInt(1, idMedico);
				
				rs = pst.executeQuery();

				while(rs.next()) {
					JornadaEnfermeroDTO jornadaMedico = new JornadaEnfermeroDTO();
					jornadaMedico.idJornadaEnfermero = rs.getInt("idJornada_Enfermero");
					jornadaMedico.idEnfermero = rs.getInt("idEnfermero");
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
