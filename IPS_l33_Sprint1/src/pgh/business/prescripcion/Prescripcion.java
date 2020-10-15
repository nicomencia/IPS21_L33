package pgh.business.prescripcion;


public class Prescripcion {
	
	 private PrescripcionDTO p;
	  
	 public Prescripcion(PrescripcionDTO pd) {
		 
		 this.p = pd;
	    	
	 }
	
	public String getIdPrescripcion() {
			
		return p.idPrescripcion;
			
	}
		
	public String getIdPaciente() {
			
		return p.idPaciente;
			
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
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();

		sb.append( "INSTRUCCION : " + getInstruccion() + " - DIA DE ASIGNACION : " +getDiaAsignacion() + " - HORA DE ASIGNACION : " + getHoraAsignacion());
		
		return sb.toString();
		
	}


}
