package pgh.business.equipomedico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.business.medico.MedicoDTO;
import pgh.jdbc.Database;

public class FindAllEquiposMedicos {

	private static String SQL = "select idEquipo_Medico, nombre from Equipo_Medico";
	
	Database db = new Database();
	
		public List<EquipoMedicoDTO> execute() {
			List<EquipoMedicoDTO> equipos;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				equipos = new ArrayList<>();
				while(rs.next()) {
					EquipoMedicoDTO equipo = new EquipoMedicoDTO();
					equipo.idEquipoMedico = rs.getInt("idEquipo_Medico");
					equipo.nombre=rs.getString("nombre");
					equipos.add(equipo);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			
			return equipos;
		}
}
