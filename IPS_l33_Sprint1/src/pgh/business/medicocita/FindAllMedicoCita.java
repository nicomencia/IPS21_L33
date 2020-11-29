package pgh.business.medicocita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllMedicoCita {
	
private static String SQL = "SELECT idmedico, idcita FROM MEDICO_CITAS";
private static String SQL2 = "SELECT idmedico, idcita FROM MEDICO_CITAS where idmedico = ?";
	
	Database db = new Database();
	
		public List<MedicoCitaDTO> execute() {
			List<MedicoCitaDTO> medicoCitas = new ArrayList<MedicoCitaDTO>();
			
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
		
		
		public List<MedicoCitaDTO> FindMedicoCita( int idMedico) {
			
			
			List<MedicoCitaDTO> medicoCitas= new ArrayList<MedicoCitaDTO>();
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL2);
							
				pst.setInt(1, idMedico);
				
				rs = pst.executeQuery();

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
