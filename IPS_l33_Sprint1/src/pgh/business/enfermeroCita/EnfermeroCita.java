package pgh.business.enfermeroCita;

public class EnfermeroCita {
	
	
	private EnfermeroCitaDTO mc;
	
	public EnfermeroCita (EnfermeroCitaDTO medicoCita) {
		
		this.mc = medicoCita;
		
	}
	
	public int getIdCita() {
		
		return mc.idCita;
		
	}
	
    public int getIdEnfermero() {
		
		return mc.idEnfermero;
		
	}

}
