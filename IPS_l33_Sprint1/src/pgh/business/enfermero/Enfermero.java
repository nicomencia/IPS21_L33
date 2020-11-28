package pgh.business.enfermero;


public class Enfermero {
	

	EnfermeroDTO m ;
	
	
	public Enfermero (EnfermeroDTO enfermero) {
		m=enfermero;
	}
	
	public int getIdEnfermero() {
		return m.idEnfermero;
	}
	
	public String getNombreEnfermero() {
		return m.nombre;
	}
	
	public String getApellidosEnfermo() {
		return m.apellidos;
	}

	public String getEspecialidad() {
		return m.especialidad;
	}
	
	public int getIdEquipoMedico() {
		return m.idEquipoMedico;
	}
	
	public int getDiasDisponibles() {
		return m.diasDisponibles;
	}
	
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		s.append(m.nombre +" " + m.apellidos + " - " + m.especialidad);
	   
	   return s.toString();
		
		
	}


}
