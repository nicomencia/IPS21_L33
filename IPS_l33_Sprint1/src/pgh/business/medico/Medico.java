package pgh.business.medico;


public class Medico {
	
	MedicoDTO m ;
	
	
	public Medico (MedicoDTO medico) {
		m=medico;
	}
	
	public int getIdMedico() {
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
	
	public String getEspecialidad() {
		return m.especialidad;
	}
	
	public int getIdEquipoMedico() {
		return m.idEquipoMedico;
	}
	
	public String toString() {
		
		StringBuilder s = new StringBuilder();
	    s.append(m.nombre +" " + m.apellidos + " - " + m.especialidad);
	   
	   return s.toString();
		
		
	}

}
