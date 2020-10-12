package pgh.business.jornadaenfermero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllJornadasEnfermero {

	private static String SQL = "select idJornada_Enfermero, idEnfermero, dia_Inicio, dia_Fin, hora_Inicio, hora_Fin from Jornada_Enfermero";
	
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
					jornadaEnfermero.idJornadaEnfermero = rs.getString("idJornada_Enfermero");
					jornadaEnfermero.idEnfermero = rs.getString("idEnfermero");
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
	
}
