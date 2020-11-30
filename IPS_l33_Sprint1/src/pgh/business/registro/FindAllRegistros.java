package pgh.business.registro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllRegistros {

	private static String SQL = "SELECT idregistro, fecha, descripcion FROM registro";
		
		Database db = new Database();
		
			public List<RegistroDTO> execute() {
				List<RegistroDTO> registros = new ArrayList<RegistroDTO>();
				
				Connection c = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
		
				try {
					c = db.getConnection();
					
					pst = c.prepareStatement(SQL);
					
					rs = pst.executeQuery();
					registros = new ArrayList<>();
					while(rs.next()) {
						RegistroDTO registro = new RegistroDTO();
						registro.idRegistro=rs.getInt("idregistro");
						registro.fecha=rs.getTimestamp("fecha");
						registro.descripcion=rs.getString("descripcion");
						registros.add(registro);
					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				finally {
					db.close(rs, pst, c);
				}
				
				return registros;
			}
}
