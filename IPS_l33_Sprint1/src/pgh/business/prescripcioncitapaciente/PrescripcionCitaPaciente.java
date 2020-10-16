package pgh.business.prescripcioncitapaciente;


public class PrescripcionCitaPaciente {
	
	 private PrescripcionCitaPacienteDTO p;
	  
	 public PrescripcionCitaPaciente(PrescripcionCitaPacienteDTO pd) {
		 
		 this.p = pd;
	    	
	 }
	
	public int getIdPrescripcion() {
			
		return p.idPrescripcion;
			
	}
	
	public int getIdCita() {
		
		return p.idCita;
			
	}
	
	public int getIdPaciente() {
		
		return p.idPaciente;
			
	}
	

		
		


}
