package pgh.business.antecedentescitapaciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import pgh.business.cita.Cita;
import pgh.business.medicocita.MedicoCitaDTO;

import pgh.jdbc.Database;

public class FindAllAntecedentesCitaPaciente {

	private static String SQL = "select idAntecedentesClinico, idCita, idPaciente from ANTECEDENTESCLINICOS_CITAS_PACIENTE";
	

	

	Database db = new Database();
	
		public List<AntecedentesCitaPacienteDTO> execute() {
			List<AntecedentesCitaPacienteDTO> antecedentes;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				antecedentes = new ArrayList<>();
				while(rs.next()) {
					AntecedentesCitaPacienteDTO antecedente = new AntecedentesCitaPacienteDTO();
					antecedente.idAntecedente = rs.getInt("idAntecedentesClinico");
					antecedente.idCita = rs.getInt("idcita");
					antecedente.idPaciente = rs.getInt("idPaciente");
					antecedentes.add(antecedente);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return antecedentes;
		}


	
}
