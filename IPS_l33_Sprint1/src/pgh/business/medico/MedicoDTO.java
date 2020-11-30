package pgh.business.medico;

public class MedicoDTO {
	
	public int idMedico;
	public String nombre;
	public String apellidos;
	public String email;
	public String especialidad;
	public int idEquipoMedico;
	public int diasDisponibles;
	
	public String toString() {
		return nombre + " " + apellidos + " " + especialidad;
	}
}
