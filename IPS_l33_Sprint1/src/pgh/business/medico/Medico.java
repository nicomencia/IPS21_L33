package pgh.business.medico;

import java.util.ArrayList;
import java.util.List;

public class Medico {
	
	MedicoDTO m ;
	ListaMedicos lm;
	List<Medico> medicos = new ArrayList<Medico>();

	
	public Medico (MedicoDTO medico) {
		m=medico;
	}
	
	public String getIdMedico() {
		return m.idMedico;
	}
	
	public String getNombreMedico() {
		return m.nombre;
	}
	
	public String getApellidosMedico() {
		return m.apellidos;
	}
	
	public String getEmailMedico() {
		return m.email;
	}
	
	public String toString() {
		
		StringBuilder s = new StringBuilder();
	    s.append(m.nombre +" " + m.apellidos);
	   
	   return s.toString();
		
		
	}

}
