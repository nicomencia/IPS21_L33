package pgh.business.enfermeroCita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.business.cita.CitaDTO;
import pgh.jdbc.Database;

public class FindAllEnfermeroCita {
	
private static String SQL = "SELECT idenfermero, idcita FROM ENFERMERO_CITAS";
private static String SQL2 = "SELECT idmenfermero, idcita FROM ENFERMERO_CITAS where idenfermero = ?";
	
	Database db = new Database();
	
		public List<EnfermeroCitaDTO> execute() {
			List<EnfermeroCitaDTO> medicoCitas = new ArrayList<EnfermeroCitaDTO>();
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				medicoCitas = new ArrayList<>();
				while(rs.next()) {
					EnfermeroCitaDTO medicoCita = new EnfermeroCitaDTO();
					medicoCita.idCita=rs.getInt("idcita");
					medicoCita.idEnfermero = rs.getInt("idmedico");
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
		
		
		public List<EnfermeroCitaDTO> FindEnfermeroCita( int idenfermero) {
			
			
			List<EnfermeroCitaDTO> medicoCitas= new ArrayList<EnfermeroCitaDTO>();
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL2);
							
				pst.setInt(1, idenfermero);
				
				rs = pst.executeQuery();

				while(rs.next()) {
					EnfermeroCitaDTO medicoCita = new EnfermeroCitaDTO();
					medicoCita.idCita=rs.getInt("idcita");
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
