package pgh.business.prescripcion;

import java.util.Date;

public class Prescripcion {
	
	 private PrescripcionDTO p;
	  
	 public Prescripcion(PrescripcionDTO pd) {
		 
		 this.p = pd;
	    	
	 }
	
	public int getIdPrescripcion() {
			
		return p.idPrescripcion;
			
	}
		
		
	public String getInstruccion() {
			
		return p.instruccion;
		
		}
		
	public String getHoraAsignacion() {
			
		return p.horaAsignacion;
		
	}
		
	public Date getDiaAsignacion() {
		
		return p.diaAsignacion;
			
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();

		sb.append( getInstruccion() + " - DIA DE ASIGNACION : " +getDiaAsignacion() + " - HORA DE ASIGNACION : " + getHoraAsignacion());
		
		return sb.toString();
		
	}


}
