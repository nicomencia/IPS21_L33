package pgh.business.causahistorial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllCausaHistorial {

	private static String SQL = "select idCausa, idHistorial from Causa_Historial";
	
	Database db = new Database();
	
		public List<CausaHistorialDTO> execute() {
			List<CausaHistorialDTO> CausasHistoriales;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				CausasHistoriales = new ArrayList<>();
				while(rs.next()) {
					CausaHistorialDTO causaHistorial = new CausaHistorialDTO();
					causaHistorial.idCausa = rs.getString("idCausa");
					causaHistorial.idHistorial = rs.getString("idHistorial");
					CausasHistoriales.add(causaHistorial);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return CausasHistoriales;
		}
	
}
