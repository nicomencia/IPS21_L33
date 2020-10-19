package pgh.business.causahistorial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.business.medicocita.MedicoCitaDTO;
import pgh.jdbc.Database;

public class FindAllCausaHistorial {
private static String SQL = "SELECT idcausa, idhistorial FROM CAUSA_HISTORIAL";
	
	Database db = new Database();
	
		public List<MedicoCitaDTO> execute() {
			List<MedicoCitaDTO> medicoCitas;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				medicoCitas = new ArrayList<>();
				while(rs.next()) {
					MedicoCitaDTO medicoCita = new MedicoCitaDTO();
					medicoCita.idCita=rs.getInt("idcita");
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
