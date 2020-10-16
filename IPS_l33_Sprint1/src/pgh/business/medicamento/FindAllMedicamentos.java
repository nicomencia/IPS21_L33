package pgh.business.medicamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.jdbc.Database;

public class FindAllMedicamentos {

	private static String SQL = "select idMedicamento, idPrescripcion, nombre, cantidad, intervalo, duracion, anotacion from Medicamento";
	
	Database db = new Database();
	
		public List<MedicamentoDTO> execute() {
			List<MedicamentoDTO> medicamentos;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				medicamentos = new ArrayList<>();
				while(rs.next()) {
					MedicamentoDTO medicamento = new MedicamentoDTO();
					medicamento.idMedicamento = rs.getInt("idMedicamento");
					medicamento.idPrescripcion = rs.getInt("idPrescripcion");
					medicamento.nombre = rs.getString("nombre");
					medicamento.cantidad = rs.getInt("cantidad");
					medicamento.intervalo = rs.getString("intervalo");
					medicamento.duracion = rs.getString("duracion");
					medicamento.anotacion = rs.getString("anotacion");
					medicamentos.add(medicamento);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			finally {
				db.close(rs, pst, c);
			}
			return medicamentos;
		}
	
}
