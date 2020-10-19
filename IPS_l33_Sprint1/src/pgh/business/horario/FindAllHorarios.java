package pgh.business.horario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllHorarios {

	private static String SQL = "select idHorario, hora_Inicio, hora_Fin from Horario";
	
	Database db = new Database();
	
		public List<HorarioDTO> execute() {
			List<HorarioDTO> horarios;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				horarios = new ArrayList<>();
				while(rs.next()) {
					HorarioDTO horario = new HorarioDTO();
					horario.idHorario = rs.getInt("idHorario");
					horario.horaInicio=rs.getString("hora_Inicio");
					horario.horaFin=rs.getString("hora_Fin");
					horarios.add(horario);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			
			return horarios;
		}
	
}
