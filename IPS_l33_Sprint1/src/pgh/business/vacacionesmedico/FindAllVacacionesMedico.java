package pgh.business.vacacionesmedico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllVacacionesMedico {

	private static String SQL = "select idVacaciones_Medico, idMedico, dia_Inicio, dia_Fin from Vacaciones_Medico";
	
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
					vacacionesMedico.idVacacionesMedico = rs.getString("idVacaciones_Medico");
					vacacionesMedico.idMedico = rs.getString("idMedico");
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
	
}
