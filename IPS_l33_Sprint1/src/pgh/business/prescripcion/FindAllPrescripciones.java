package pgh.business.prescripcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllPrescripciones {

	private static String SQL = "select idPrescripcion, dni, instruccion, hora_Asignacion, dia_Asignacion from Prescripcion";
	
	Database db = new Database();
	
		public List<PrescripcionDTO> execute() {
			List<PrescripcionDTO> prescripciones;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				prescripciones = new ArrayList<>();
				while(rs.next()) {
					PrescripcionDTO prescripcion = new PrescripcionDTO();
					prescripcion.idPrescripcion = rs.getString("idPrescripcion");
					prescripcion.dni = rs.getString("dni");
					prescripcion.instruccion = rs.getString("instruccion");
					prescripcion.horaAsignacion = rs.getString("hora_Asignacion");
					prescripcion.diaAsignacion = rs.getString("dia_Asignacion");
					prescripciones.add(prescripcion);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return prescripciones;
		}
	
}
