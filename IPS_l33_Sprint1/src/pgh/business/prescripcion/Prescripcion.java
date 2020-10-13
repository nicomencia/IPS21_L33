package pgh.business.prescripcion;

import java.util.Date;

public class Prescripcion {
	
	 private PrescripcionDTO p;
	  
	 public Prescripcion(PrescripcionDTO pd) {
		 
		 this.p = pd;
	    	
	 }
	
	
	public String getIdPrescripcion() {
			
		return p.idPrescripcion;
			
	}
		
	public String getDni() {
			
		return p.dni;
			
	}
		
	public String getInstruccion() {
			
		return p.instruccion;
		
		}
		
	public String getHoraAsignacion() {
			
		return p.horaAsignacion;
		
	}
		
	public String getDiaAsignacion() {
		
		return p.diaAsignacion;
			
	}


}
