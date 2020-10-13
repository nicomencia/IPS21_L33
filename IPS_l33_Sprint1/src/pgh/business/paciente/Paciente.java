package pgh.business.paciente;


public class Paciente {
	
	PacienteDTO p;
	
	
	public Paciente(PacienteDTO paciente) {
		
		p=paciente;
	
	}
	
	public String getIdPaciente() {
		return p.idPaciente;
	}
	
	
	public String getNombre() {
		return p.nombre;
	}
	
	public String getDni() {
		return p.dni;
	}
	
	public String getApellidos() {
		return p.apellidos;
	}
	
	public String getTelefono() {
		return p.telefono;
	}
	
	public String getEmail() {
		return p.email;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(getNombre() + " " + getApellidos());
		return sb.toString();
		
	}
	
	

}
