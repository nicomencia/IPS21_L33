package pgh.business.medicoSustituto;


public class MedicoSustituto {
	
	MedicoSustitutoDTO m ;
	
	
	public MedicoSustituto (MedicoSustitutoDTO medico) {
		m=medico;
	}
	
	public int getIdMedico() {
		return m.idMedicoSustituto;
	}
	
	public String getNombreMedico() {
		return m.nombre;
	}
	
	public String getApellidosMedico() {
		return m.apellidos;
	}
	
	public String getEmailMedico() {
		return m.email;
	}
	
	public String toString() {
		
		StringBuilder s = new StringBuilder();
	    s.append(m.nombre +" " + m.apellidos);
	   
	   return s.toString();
		
		
	}

}
