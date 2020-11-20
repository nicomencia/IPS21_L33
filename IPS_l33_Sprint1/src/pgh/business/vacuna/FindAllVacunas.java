package pgh.business.vacuna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.business.cita.CitaDTO;
import pgh.jdbc.Database;

public class FindAllVacunas {

	private static String SQL = "select IDVACUNA, IDPACIENTE, NOMBREVACUNA, DIAASIGNADA, DIAPUESTA, HORAPUESTA, OBSERVACION, ISPUESTA  from VACUNA";
	private static String SQL2 = "select IDVACUNA, IDPACIENTE, NOMBREVACUNA, DIAASIGNADA, DIAPUESTA, HORAPUESTA, OBSERVACION, ISPUESTA from VACUNA where IDPACIENTE = ? AND ISPUESTA = true";
	private static String SQL3 = "select IDVACUNA, IDPACIENTE, NOMBREVACUNA, DIAASIGNADA, DIAPUESTA, HORAPUESTA, OBSERVACION, ISPUESTA from VACUNA where IDPACIENTE = ? AND ISPUESTA = false";
	Database db = new Database();
	
		public List<VacunaDTO> execute() {
			List<VacunaDTO> vacunas;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				vacunas = new ArrayList<>();
				while(rs.next()) {
					VacunaDTO vacuna = new VacunaDTO();
					vacuna.idVacuna = rs.getInt("IDVACUNA");
					vacuna.idPaciente = rs.getInt("IDPACIENTE");
					vacuna.nombreVacuna = rs.getString("NOMBREVACUNA");
					vacuna.diaAsignacion = rs.getDate("DIAASIGNADA");
					vacuna.diaVacunacion = rs.getDate("DIAPUESTA");
					vacuna.horaAsignacion = rs.getString("HORAPUESTA");
					vacuna.observacion = rs.getString("OBSERVACION");
					vacuna.isPuesta = rs.getBoolean("ISPUESTA");
					vacunas.add(vacuna);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return vacunas;
		}
		
		public List<VacunaDTO> FindVacunaByIdPuesta(int idpaciente) {
			
			
			List<VacunaDTO> vacunas;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL2);
							
				pst.setInt(1, idpaciente);
				
				rs = pst.executeQuery();
				
				vacunas = new ArrayList<>();

				while(rs.next()) {
					VacunaDTO vacuna = new VacunaDTO();
					vacuna.idVacuna = rs.getInt("IDVACUNA");
					vacuna.idPaciente = rs.getInt("IDPACIENTE");
					vacuna.nombreVacuna = rs.getString("NOMBREVACUNA");
					vacuna.diaAsignacion = rs.getDate("DIAASIGNADA");
					vacuna.diaVacunacion = rs.getDate("DIAPUESTA");
					vacuna.horaAsignacion = rs.getString("HORAPUESTA");
					vacuna.observacion = rs.getString("OBSERVACION");
					vacuna.isPuesta = rs.getBoolean("ISPUESTA");
					vacunas.add(vacuna);
				}
				
			
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			
			System.out.println(vacunas.size());
			return vacunas;
		}
		
public List<VacunaDTO> FindVacunaByIdNoPuesta(int idpaciente) {
			
			
			List<VacunaDTO> vacunas;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL3);
							
				pst.setInt(1, idpaciente);
				
				rs = pst.executeQuery();
				
				vacunas = new ArrayList<>();

				while(rs.next()) {
					VacunaDTO vacuna = new VacunaDTO();
					vacuna.idVacuna = rs.getInt("IDVACUNA");
					vacuna.idPaciente = rs.getInt("IDPACIENTE");
					vacuna.nombreVacuna = rs.getString("NOMBREVACUNA");
					vacuna.diaAsignacion = rs.getDate("DIAASIGNADA");
					vacuna.diaVacunacion = rs.getDate("DIAPUESTA");
					vacuna.horaAsignacion = rs.getString("HORAPUESTA");
					vacuna.observacion = rs.getString("OBSERVACION");
					vacuna.isPuesta = rs.getBoolean("ISPUESTA");
					vacunas.add(vacuna);
				}
				
			
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			
			System.out.println(vacunas.size());
			return vacunas;
		}
	
}
