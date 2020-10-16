package pgh.business.prescripcioncitapaciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllPrescripcionesCitaPaciente {

	private static String SQL = "select idPrescripcion, idCita, idPaciente from PRESCRIPCION_CITAS_PACIENTE";
	
	Database db = new Database();
	
		public List<PrescripcionCitaPacienteDTO> execute() {
			List<PrescripcionCitaPacienteDTO> prescripciones;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				prescripciones = new ArrayList<>();
				while(rs.next()) {
					PrescripcionCitaPacienteDTO prescripcion = new PrescripcionCitaPacienteDTO();
					prescripcion.idPrescripcion = rs.getInt("idPrescripcion");
					prescripcion.idCita = rs.getInt("idcita");
					prescripcion.idPaciente = rs.getInt("idPaciente");
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
