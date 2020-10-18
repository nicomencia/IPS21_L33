package pgh.business.causa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllCausas {

	private static String SQL = "select idCausa, idcita, idpaciente, descripcion from Causa";
	
	Database db = new Database();
	
		public List<CausaDTO> execute() {
			List<CausaDTO> causas;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				causas = new ArrayList<>();
				while(rs.next()) {
					CausaDTO causa = new CausaDTO();
					causa.idCausa = rs.getInt("idCausa");
					causa.idCita = rs.getInt("idcita");
					causa.idPaciente = rs.getInt("idpaciente");
					causa.descripcion = rs.getString("descripcion");
					causas.add(causa);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return causas;
		}
	
}
