package pgh.business.medicoCitaPropuesta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllMedicoCitaPropuesta {

	private static String SQL = "SELECT idmedico, idcitapropuesta FROM MEDICO_CITASPROPUESTAS";
		
		Database db = new Database();
		
			public List<MedicoCitaPropuestaDTO> execute() {
				List<MedicoCitaPropuestaDTO> medicoCitas = new ArrayList<MedicoCitaPropuestaDTO>();
				
				Connection c = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
		
				try {
					c = db.getConnection();
					
					pst = c.prepareStatement(SQL);
					
					rs = pst.executeQuery();
					medicoCitas = new ArrayList<>();
					while(rs.next()) {
						MedicoCitaPropuestaDTO medicoCita = new MedicoCitaPropuestaDTO();
						medicoCita.idCitaPropuesta=rs.getInt("idcitapropuesta");
						medicoCita.idMedico = rs.getInt("idmedico");
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
