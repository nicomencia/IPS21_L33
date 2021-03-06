package pgh.business.enfermedad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import pgh.business.diagnostico.DiagnosticoDTO;
import pgh.business.medico.Medico;
import pgh.jdbc.Database;

public class GuardarEnfermedad {
//private static String SQL = "Insert into Medico (idMedico, nombre, apellidos, email, especialidad, idEquipo_Medico, diasdisponibles) values (?,?,?,?,?,?,?) ";
private static String SQL = "Insert into Emfermedad (id_emfermedad, nombre, fecha_inicio, fecha_fin, id_paciente, seguimiento)  values (?,?,?,?,?,?)";
private static String SQL2 = "Update emfermedad set fecha_fin = ? , seguimiento = ? where id_emfermedad = ?";	
 
	Database db = new Database();
	
	public void crearMedico(DiagnosticoDTO diagnosticoDTO) {
		
		EnfermedadDTO e = new EnfermedadDTO();
		e.declaracion = diagnosticoDTO.obligatorio;
		e.fecha_inicio = new Date();
		e.id_emfermedad = Integer.parseInt(diagnosticoDTO.idDiagnostico);
		e.id_paciente = diagnosticoDTO.idPaciente;
		e.nombre = diagnosticoDTO.descripcion;
		e.seguimiento = diagnosticoDTO.seguimiento;
		
		Connection c = null;
		java.sql.Date sqlDate = new java.sql.Date(e.fecha_inicio.getTime());

		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		try {
			
			c = db.getConnection();
			
			
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, e.id_emfermedad);
			pst.setString(2, e.nombre);
			pst.setDate(3, sqlDate);
			pst.setDate(4, null);
			pst.setInt(5, e.id_paciente);
			pst.setBoolean(6, e.seguimiento);
			
			
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("Tratamiento guardado con exito");
		  

			
		} catch (SQLException es) {
			// TODO Auto-generated catch block
			es.printStackTrace();
		}
		
		
	}
	
public void crearMedico(int idemfermedad, Date fecha_fin) {
		
	Connection c = null;
	PreparedStatement pst = null;
	java.sql.Date sqlDate = new java.sql.Date(fecha_fin.getTime());

	try {
		c = db.getConnection();
		
		pst = c.prepareStatement(SQL2);
		
		
		pst.setDate(1, sqlDate);
		pst.setBoolean(2, false);
		pst.setInt(3, idemfermedad);
		
		
		pst.executeUpdate();
		
	
	
		c.close();
		pst.close();
		
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
		
		
	}
}
