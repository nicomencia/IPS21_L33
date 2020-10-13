package pgh.business.cita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pgh.jdbc.Database;

public class crearCitas {
	
	private static String SQL = "Insert into Cita (idcita, dni, idmedico, fecha, horaInicio, horaFin, ubicacion, asistencia) values (?,?,?,?,?,?,?,?) ";
	
	Database db = new Database();
	
	public void crearCita() {
		
		List<CitaDTO> citas;
		
		Connection c = null;
		ResultSet rs = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		try {
			PreparedStatement pst = c.prepareStatement(query.toString());
//			pst.setString(1, cita.getIdCita());
//			pst.setString(2, cita.getDNI());
//			pst.setString(3, cita.getFecha());
//			pst.setString(4, cita.getHora());
//			pst.setString(5, cita.getUbicacion());
//			pst.setString(6, cita.getAsistencia());
//			pst.setString(7, cita.getIdCita());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
