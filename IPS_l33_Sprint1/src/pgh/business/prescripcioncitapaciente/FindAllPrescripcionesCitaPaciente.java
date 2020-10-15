package pgh.business.prescripcioncitapaciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllPrescripcionesCitaPaciente {

	private static String SQL = "select idPrescripcion, id_paciente, idcita from PrescripcionCitasPaciente";
	
	Database db = new Database();
	
		public List<PrescripcionCitaPacienteDTO> execute() {
			List<PrescripcionCitaPacienteDTO> prescripcionesCitaPaciente;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				prescripcionesCitaPaciente = new ArrayList<>();
				while(rs.next()) {
					PrescripcionCitaPacienteDTO prescripcion = new PrescripcionCitaPacienteDTO();
					prescripcion.idPrescripcion = rs.getInt("idPrescripcion");
					prescripcion.idPaciente = rs.getInt("id_paciente");
					prescripcion.idcita = rs.getInt("idcita");
					prescripcionesCitaPaciente.add(prescripcion);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return prescripcionesCitaPaciente;
		}
	
}
