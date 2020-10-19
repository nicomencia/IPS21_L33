package pgh.business.enfermero;

public class Enfermero {

	EnfermeroDTO e;
	
	public Enfermero(EnfermeroDTO en) {
		this.e = en;
	}
	
	public int getIdEnfermero() {
		return e.idEnfermero;
	}
	
	public String getNombre() {
		return e.nombre;
	}
	
	public String getApellidos() {
		return e.apellidos;
	}
	
	public String toString() {
		return e.nombre + " " + e.apellidos;
	}
	
}
