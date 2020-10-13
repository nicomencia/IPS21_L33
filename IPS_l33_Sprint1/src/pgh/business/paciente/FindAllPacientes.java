package pgh.business.paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllPacientes {
	
	private static String SQL = "select idpaciente, dni, nombre, apellidos, email, telefono from Paciente";
		
	Database db = new Database();
	
		public List<PacienteDTO> execute() {
			List<PacienteDTO> pacientes;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				pacientes = new ArrayList<>();
				while(rs.next()) {
					PacienteDTO paciente = new PacienteDTO();
					paciente.idPaciente = rs.getString("idpaciente");
					paciente.dni = rs.getString("dni");
					paciente.nombre=rs.getString("nombre");;
					paciente.apellidos=rs.getString("apellidos");;
					paciente.email=rs.getString("email");
					paciente.telefono=rs.getString("telefono");
					pacientes.add(paciente);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return pacientes;
		}
	
}
