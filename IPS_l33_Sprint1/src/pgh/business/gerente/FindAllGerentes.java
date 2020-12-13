package pgh.business.gerente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllGerentes {
	private static String SQL = "SELECT idgerente, nombre, email FROM gerente";
	
	Database db = new Database();
	
		public List<GerenteDTO> execute() {
			List<GerenteDTO> gerentes = new ArrayList<GerenteDTO>();
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				gerentes = new ArrayList<>();
				while(rs.next()) {
					GerenteDTO gerente = new GerenteDTO();
					gerente.idgerente=rs.getInt("idgerente");
					gerente.nombre=rs.getString("nombre");
					gerente.email=rs.getString("email");
					gerentes.add(gerente);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			
			return gerentes;
		}
}
