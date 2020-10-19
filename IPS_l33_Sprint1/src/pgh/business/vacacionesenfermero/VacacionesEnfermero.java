package pgh.business.vacacionesenfermero;

import java.util.Date;

public class VacacionesEnfermero {

	VacacionesEnfermeroDTO ve;
	
	public VacacionesEnfermero(VacacionesEnfermeroDTO ve) {
		this.ve = ve;
	}
	
	public int getIdVacacionesEnfermero() {
		return ve.idVacacionesEnfermero;
	}
	
	public int getIdEnfermero() {
		return ve.idEnfermero;
	}
	
	public Date getFechaInicio() {
		return ve.diaInicio;
	}
	
	public Date getFechaFin() {
		return ve.diaFin;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getIdVacacionesEnfermero() + " " + getFechaInicio() + "   " + getFechaFin());
		return sb.toString();
	}
	
}
