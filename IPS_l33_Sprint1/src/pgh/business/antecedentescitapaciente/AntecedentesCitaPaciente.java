package pgh.business.antecedentescitapaciente;


public class AntecedentesCitaPaciente {
	
	 private AntecedentesCitaPacienteDTO p;
	  
	 public AntecedentesCitaPaciente(AntecedentesCitaPacienteDTO pd) {
		 
		 this.p = pd;
	    	
	 }
	
	public int getIdAntecedente() {
			
		return p.idAntecedente;
			
	}
	
	public int getIdCita() {
		
		return p.idCita;
			
	}
	
	public int getIdPaciente() {
		
		return p.idPaciente;
			
	}
	

		
		


}
