package pgh.business.vacacionesmedico;

import java.util.Date;

public class VacacionesMedico {
	
	private VacacionesMedicoDTO vacaciones;

	public VacacionesMedico(VacacionesMedicoDTO vacaciones) {
		this.vacaciones = vacaciones;
	}
	
	public int getIdVacaciones() {
		return vacaciones.idVacacionesMedico;
	}
	
	public int getIdMedico() {
		return vacaciones.idMedico;
	}
	
	public Date getFechaInicio() {
		return vacaciones.diaInicio;
	}
	
	public Date getFechaFin() {
		return vacaciones.diaFin;
	}
	
	
	
	
	

}
