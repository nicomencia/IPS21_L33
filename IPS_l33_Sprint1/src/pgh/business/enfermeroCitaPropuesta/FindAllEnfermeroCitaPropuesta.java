package pgh.business.enfermeroCitaPropuesta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllEnfermeroCitaPropuesta {

	private static String SQL = "SELECT idenfermero, idcitaPropuesta FROM ENFERMERO_CITASPROPUESTAS";
		
		Database db = new Database();
		
			public List<EnfermeroCitaPropuestaDTO> execute() {
				List<EnfermeroCitaPropuestaDTO> medicoCitas = new ArrayList<EnfermeroCitaPropuestaDTO>();
				
				Connection c = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
		
				try {
					c = db.getConnection();
					
					pst = c.prepareStatement(SQL);
					
					rs = pst.executeQuery();
					medicoCitas = new ArrayList<>();
					while(rs.next()) {
						EnfermeroCitaPropuestaDTO medicoCita = new EnfermeroCitaPropuestaDTO();
						medicoCita.idCitaPropuesta=rs.getInt("idcitapropuesta");
						medicoCita.idEnfermero = rs.getInt("idenfermero");
						medicoCitas.add(medicoCita);
					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				finally {
					db.close(rs, pst, c);
				}
				
				return medicoCitas;
			}
			
}
