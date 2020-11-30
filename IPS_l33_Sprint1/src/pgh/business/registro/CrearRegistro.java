package pgh.business.registro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import pgh.business.enfermero.Enfermero;
import pgh.business.enfermero.ListaEnfermeros;
import pgh.business.medico.ListaMedicos;
import pgh.business.medico.Medico;
import pgh.business.paciente.ListaPacientes;
import pgh.business.paciente.Paciente;
import pgh.jdbc.Database;

public class CrearRegistro {

private static String SQL = "Insert into REGISTRO (idRegistro,fecha,descripcion) values (?,?,?) ";
	
	Database db = new Database();
	
	public void crearRegistro(String descripcion) {
		
		Connection c = null;
		PreparedStatement pst = null;
		StringBuilder query=new StringBuilder();
		query.append(SQL);
		
		RegistroDTO registroDTO = new RegistroDTO();
		
		registroDTO.idRegistro = generarIdRegistro();
		registroDTO.fecha = new Timestamp(System.currentTimeMillis());
		registroDTO.descripcion = descripcion;
		
		Registro registro = new Registro(registroDTO);
		
		try {
			
			c = db.getConnection();
			
		    pst = c.prepareStatement(query.toString());
			pst.setInt(1, registro.getIdRegistro());
			pst.setTimestamp(2, registro.getFecha());
			pst.setString(3, registro.getDescripcion());
				
		    pst.executeUpdate();	
		    
		    pst.close();
		    c.close();
		    
		    System.out.print("Registro creado con exito");
		  
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	private int generarIdRegistro() {
		
		ListaRegistros lr = new ListaRegistros();
		lr.creaListaRegistros();
		
		return 99000 + lr.getRegistros().size();
	}

	public String getNombreEnfermero(int idEnfermero) {

		ListaEnfermeros le = new ListaEnfermeros();
		le.creaListaEnfermeros();
		for (Enfermero e : le.getEnfermeros()) {
			if (e.getIdEnfermero() == idEnfermero) {
				return e.getNombreEnfermero() + " " + e.getApellidosEnfermo();
			}
		}
		
		return null;
	}

	public String getNombrePaciente(int idPaciente) {
		
		ListaPacientes lp = new ListaPacientes();
		lp.creaListaPacientes();
		for (Paciente p : lp.getPacientes()) {
			if (p.getIdPaciente() == idPaciente) {
				return p.getNombre() + " " + p.getApellidos();
			}
		}
		
		return null;
	}

	public String getNombreMedico(int idMedico) {

		ListaMedicos lm = new ListaMedicos();
		lm.creaListaMedicos();
		for (Medico m : lm.getMedicos()) {
			if (m.getIdMedico() == idMedico) {
				return m.getNombreMedico() + " " + m.getApellidosMedico();
			}
		}
		return null;
	}
	
}
