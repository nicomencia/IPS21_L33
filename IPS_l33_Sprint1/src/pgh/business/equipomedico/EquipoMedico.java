package pgh.business.equipomedico;

public class EquipoMedico {

	EquipoMedicoDTO em; 
	
	public EquipoMedico (EquipoMedicoDTO em) {
		this.em=em;
	}

	public int getIdEquipoMedico() {
		return em.idEquipoMedico;
	}
	
	public String getNombreEquipoMedico() {
		return em.nombre;
	}
	
	public String toString() {
		return em.nombre;
	}
}
