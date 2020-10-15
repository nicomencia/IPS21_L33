package pgh.business.prescripcioncitapaciente;


public class PrescripcionCitaPaciente {
	
	 private PrescripcionCitaPacienteDTO p;
	  
	 public PrescripcionCitaPaciente(PrescripcionCitaPacienteDTO pd) {
		 
		 this.p = pd;
	    	
	 }
	
	public int getIdPrescripcion() {
			
		return p.idPrescripcion;
			
	}
		
	public int getIdPaciente() {
			
		return p.idPaciente;
			
	}
		
	public int getIdCita() {
		
		return p.idcita;
			
	}
		
	

}
