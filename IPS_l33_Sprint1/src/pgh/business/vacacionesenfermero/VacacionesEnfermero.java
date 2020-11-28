package pgh.business.vacacionesenfermero;

import java.util.Date;

public class VacacionesEnfermero {
	
	private VacacionesEnfermeroDTO vacaciones;

	public VacacionesEnfermero(VacacionesEnfermeroDTO vacaciones) {
		this.vacaciones = vacaciones;
	}
	
	public int getIdVacaciones() {
		return vacaciones.idVacacionesEnfermero;
	}
	
	public int getIdMedico() {
		return vacaciones.idEnfermero;
	}
	
	public Date getFechaInicio() {
		return vacaciones.diaInicio;
	}
	
	public Date getFechaFin() {
		return vacaciones.diaFin;
	}
	
	
	
	
	

}
