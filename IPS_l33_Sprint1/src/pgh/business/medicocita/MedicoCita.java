package pgh.business.medicocita;

public class MedicoCita {
	
	
	private MedicoCitaDTO mc;
	
	public MedicoCita (MedicoCitaDTO medicoCita) {
		
		this.mc = medicoCita;
		
	}
	
	public String getIdCita() {
		
		return mc.idCita;
		
	}
	
    public String getIdMedico() {
		
		return mc.idMedico;
		
	}

}
