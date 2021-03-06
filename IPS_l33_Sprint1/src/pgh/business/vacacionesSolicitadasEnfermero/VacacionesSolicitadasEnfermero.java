package pgh.business.vacacionesSolicitadasEnfermero;

import java.util.Date;

public class VacacionesSolicitadasEnfermero {
	
	private VacacionesSolicitadasEnfermeroDTO vacaciones;

	public VacacionesSolicitadasEnfermero(VacacionesSolicitadasEnfermeroDTO vacaciones) {
		this.vacaciones = vacaciones;
	}
	
	public int getIdVacacionesSolicitadas() {
		return vacaciones.idVacacionesMedicoSolicitadas;
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
	
	public String getMotivo() {
		return vacaciones.motivo;
	}
	
	public String getNombreMedico() {
		return vacaciones.nombreMedico;
	}
	
	public boolean getAprobadas() {
		return vacaciones.aprobadas;
	}
	
	public boolean getCanceladas() {
		return vacaciones.canceladas;
	}
	
	public boolean getEsperando() {
		return vacaciones.esperando;
	}
	
	
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		if(getAprobadas()) {
			sb.append("Vacaciones solicitadas por el medico : " + getNombreMedico() + " / Motivo (opcional) : " + getMotivo() + " / Fecha de inicio: " + getFechaInicio().toString() + " / Fecha fin: " + getFechaFin().toString() + "Estado de la solicitud : aprobadas");
		}
		if(getCanceladas()) {
			sb.append("Vacaciones solicitadas por el medico : " + getNombreMedico() + " / Motivo (opcional) : " + getMotivo() + " / Fecha de inicio: " + getFechaInicio().toString() + " / Fecha fin: " + getFechaFin().toString() + "Estado de la solicitud : canceladas");
		}
		if(getEsperando()) {
			sb.append("Vacaciones solicitadas por el medico : " + getNombreMedico() + " / Motivo (opcional) : " + getMotivo() + " / Fecha de inicio: " + getFechaInicio().toString() + " / Fecha fin: " + getFechaFin().toString() + "Estado de la solicitud : esperando");
		}
		
		return sb.toString();
				
	}
	
	public String fechaVacaciones() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Fecha de inicio: " + getFechaInicio().toString() + " / Fecha fin: " + getFechaFin().toString());
		
		
		return sb.toString();
				
	}
	
	

}
