package pgh.business.antecedentesClinicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pgh.business.prescripcion.PrescripcionDTO;
import pgh.jdbc.Database;

public class FindAllAntecedentes {
	
private static String SQL = "select idAntecedentesClinicos, descripcion, hora_Asignacion, dia_Asignacion from AntecedentesClinicos";
	
	Database db = new Database();
	
		public List<AntecedentesDTO> execute() {
			List<AntecedentesDTO> antecedentes;
			
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
	
			try {
				c = db.getConnection();
				
				pst = c.prepareStatement(SQL);
				
				rs = pst.executeQuery();
				antecedentes = new ArrayList<>();
				while(rs.next()) {
					AntecedentesDTO antecedente = new AntecedentesDTO();
					antecedente.idAntecedenteClinico = rs.getInt("idAntecedentesClinicos");
					antecedente.descripcion = rs.getString("descripcion");
					antecedente.horaAsignacion = rs.getString("hora_Asignacion");
					antecedente.diaAsignacion = rs.getDate("dia_Asignacion");
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
