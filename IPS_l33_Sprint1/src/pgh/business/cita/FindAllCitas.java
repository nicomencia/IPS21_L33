package pgh.business.cita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllCitas {
	

	
	private static String SQL2 = "select idcita, fecha, asistencia, nombrepaciente from CITA where idpaciente = ? AND idcita in (select idcita from MEDICO_CITAS where idmedico=?)";
	
	private static String SQL5 = "Select idcita, idpaciente, idhorario, idubicacion, fecha, asistencia, urgente, infocontacto, nombrepaciente from Cita a, ENFERMERO_CITAS b where a.idcita = b.idcita and b.idenfermero = ?";
	
	private static String SQL = "select idcita, idpaciente, idhorario, idubicacion, fecha, asistencia, urgente, infocontacto, nombrepaciente, medicoasignado from Cita";
	
	private static String SQL4 = "select idcita, idpaciente, idhorario, idubicacion, fecha, asistencia, urgente, infocontacto, nombrepaciente, medicoasignado from Cita where idcita=?";

	private static String SQL3 = "Select idcita, idpaciente, idhorario, idubicacion, fecha, asistencia, urgente, infocontacto, nombrepaciente from Cita a, MEDICO_CITAS b where a.idcita = b.idcita and b.idmedico = ?";


	
	Database db = new Database();
	
		public List<CitaDTO> execute() {
			
			List<CitaDTO> citas;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				citas = new ArrayList<>();
				while(rs.next()) {
					CitaDTO cita = new CitaDTO();
					cita.idCita = rs.getInt("idcita");
					cita.idPaciente  = rs.getInt("idpaciente");
					cita.idHorario  = rs.getInt("idhorario");
					cita.idUbicacion  = rs.getInt("idubicacion");
					cita.fecha=rs.getDate("fecha");
					cita.asistencia=rs.getBoolean("asistencia");
					cita.urgente=rs.getBoolean("urgente");
					cita.infocontacto=rs.getString("infocontacto");
					cita.nombrePaciente=rs.getString("nombrepaciente");
					cita.medicoAsignado=rs.getBoolean("medicoasignado");

					citas.add(cita);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return citas;
		}
		
		public List<CitaDTO> FindIdCita( int idMedico, int idPaciente) {
			
			
			List<CitaDTO> citas = new ArrayList<CitaDTO>();
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL2);
							
				pst.setInt(1, idPaciente);
				pst.setInt(2, idMedico);
				
				rs = pst.executeQuery();

				while(rs.next()) {
					CitaDTO cita = new CitaDTO();
					cita.idCita=rs.getInt("idcita");	
					cita.fecha=rs.getDate("fecha");
					cita.asistencia=rs.getBoolean("asistencia");
					cita.nombrePaciente=rs.getString("nombrepaciente");
					citas.add(cita);
				}
				
			
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			
			return citas;
		}
		
		public List<CitaDTO> FindCitaIdEnfermero( int idEnfermero) {
			
			
			List<CitaDTO> citas = new ArrayList<CitaDTO>();
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL5);
							
				pst.setInt(1, idEnfermero);
				
				rs = pst.executeQuery();

				while(rs.next()) {
					CitaDTO cita = new CitaDTO();
					cita.idCita = rs.getInt("idcita");
					cita.idPaciente  = rs.getInt("idpaciente");
					cita.idHorario  = rs.getInt("idhorario");
					cita.idUbicacion  = rs.getInt("idubicacion");
					cita.fecha=rs.getDate("fecha");
					cita.asistencia=rs.getBoolean("asistencia");
					cita.urgente=rs.getBoolean("urgente");
					cita.infocontacto=rs.getString("infocontacto");
					cita.nombrePaciente=rs.getString("nombrepaciente");
					citas.add(cita);
				}
				
			
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			
			return citas;
		}
		
		
		
		public List<CitaDTO> FindCitaIdMedico( int idMedico) {
			
			
			List<CitaDTO> citas = new ArrayList<CitaDTO>();
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL3);
							
				pst.setInt(1, idMedico);
				
				rs = pst.executeQuery();

				while(rs.next()) {
					CitaDTO cita = new CitaDTO();
					cita.idCita = rs.getInt("idcita");
					cita.idPaciente  = rs.getInt("idpaciente");
					cita.idHorario  = rs.getInt("idhorario");
					cita.idUbicacion  = rs.getInt("idubicacion");
					cita.fecha=rs.getDate("fecha");
					cita.asistencia=rs.getBoolean("asistencia");
					cita.urgente=rs.getBoolean("urgente");
					cita.infocontacto=rs.getString("infocontacto");
					cita.nombrePaciente=rs.getString("nombrepaciente");
					citas.add(cita);
				}
				
			
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			
			return citas;
		}
		
		public CitaDTO FindCitaById(int idCita) {
			
			
			CitaDTO cita = new CitaDTO();
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL4);
							
				pst.setInt(1, idCita);
				
				rs = pst.executeQuery();

				if(rs.next()) {
					cita.idCita = rs.getInt("idcita");
					cita.idPaciente  = rs.getInt("idpaciente");
					cita.idHorario  = rs.getInt("idhorario");
					cita.idUbicacion  = rs.getInt("idubicacion");
					cita.fecha=rs.getDate("fecha");
					cita.asistencia=rs.getBoolean("asistencia");
					cita.urgente=rs.getBoolean("urgente");
					cita.infocontacto=rs.getString("infocontacto");
					cita.nombrePaciente=rs.getString("nombrepaciente");
					cita.medicoAsignado=rs.getBoolean("medicoasignado");
				}
				
			
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			
			return cita;
		}
	
}
