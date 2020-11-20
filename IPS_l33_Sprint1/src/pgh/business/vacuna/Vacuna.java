package pgh.business.vacuna;

import java.util.Date;

public class Vacuna {
	
	 private VacunaDTO p;
	  
	 public Vacuna(VacunaDTO pd) {
		 
		 this.p = pd;
	    	
	 }
	
	public int getIdVacuna() {
			
		return p.idVacuna;
			
	}
	
	public int getIdPaciente() {
		
		return p.idPaciente;
			
	}
	
		
		
	public String getNombreVacuna() {
			
		return p.nombreVacuna;
		
		}
		
	public String getObservacion() {
			
		return p.observacion;
		
	}
	
	public String getHoraAsignacion() {
		
		return p.horaAsignacion;
		
	}
		
	public Date getDiaAsignacion() {
		
		return p.diaAsignacion;
			
	}
	
	public Date getDiaVacunacion() {
		
		return p.diaAsignacion;
			
	}
	

	public boolean isPuesta() {
		return p.isPuesta;
	}
	

	public String toString() {
		
		StringBuilder sb = new StringBuilder();


		if(isPuesta()) {
			sb.append("Vacuna : " + getNombreVacuna() + " puesta el dia : " + getDiaAsignacion() + " a la hora : " + getHoraAsignacion() + " previamente programada el dia : " + getDiaAsignacion() + " Observacion (opcional) : " + getObservacion());
		}
		else {
			sb.append("Vacuna : " + getNombreVacuna() + " programada para el dia : " + getDiaAsignacion() + " Observacion (opcional) : " + getObservacion());
		}
		

		
		return sb.toString();
		
	}


}
