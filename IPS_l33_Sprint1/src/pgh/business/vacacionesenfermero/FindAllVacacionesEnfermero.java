package pgh.business.vacacionesenfermero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllVacacionesEnfermero {

	private static String SQL = "select idVacaciones_Enfermero, idEnfermero, dia_Inicio, dia_Fin from Vacaciones_Enfermero";
	
	Database db = new Database();
	
		public List<VacacionesEnfermeroDTO> execute() {
			List<VacacionesEnfermeroDTO> vacacionesEnfermeros;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				vacacionesEnfermeros = new ArrayList<>();
				while(rs.next()) {
					VacacionesEnfermeroDTO vacacionesEnfermero = new VacacionesEnfermeroDTO();
					vacacionesEnfermero.idVacacionesEnfermero = rs.getInt("idVacaciones_Enfermero");
					vacacionesEnfermero.idEnfermero = rs.getInt("idEnfermero");
					vacacionesEnfermero.diaInicio = rs.getDate("dia_Inicio");
					vacacionesEnfermero.diaFin = rs.getDate("dia_Fin");
					vacacionesEnfermeros.add(vacacionesEnfermero);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return vacacionesEnfermeros;
		}
	
}
