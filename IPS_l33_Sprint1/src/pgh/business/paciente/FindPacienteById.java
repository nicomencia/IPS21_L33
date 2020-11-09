package pgh.business.paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pgh.jdbc.Database;

public class FindPacienteById {

	private static String SQL = "select idpaciente, dni, nombre, apellidos, email, telefono from Paciente where idpaciente = ?";
	
	Database db = new Database();
	
		public PacienteDTO execute(int id) {
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			PacienteDTO paciente = new PacienteDTO();
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				rs.next(); 
					
				paciente.idPaciente = rs.getInt("idpaciente");
				paciente.dni = rs.getString("dni");
				paciente.nombre=rs.getString("nombre");;
				paciente.apellidos=rs.getString("apellidos");;
				paciente.email=rs.getString("email");
				paciente.telefono=rs.getString("telefono");
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return paciente;
		}
}
