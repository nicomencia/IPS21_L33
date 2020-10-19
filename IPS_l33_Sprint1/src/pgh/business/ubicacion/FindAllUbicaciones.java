package pgh.business.ubicacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllUbicaciones {

	private static String SQL = "select idUbicacion, nombre from Ubicacion";
	
	Database db = new Database();
	
		public List<UbicacionDTO> execute() {
			List<UbicacionDTO> ubicaciones;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				ubicaciones = new ArrayList<>();
				while(rs.next()) {
					UbicacionDTO ubicacion = new UbicacionDTO();
					ubicacion.idUbicacion = rs.getInt("idUbicacion");
					ubicacion.nombre=rs.getString("nombre");;
					ubicaciones.add(ubicacion);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			
			return ubicaciones;
		}
}
