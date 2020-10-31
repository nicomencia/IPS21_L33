package pgh.business.medicocita;

public class MedicoCita {
	
	
	private MedicoCitaDTO mc;
	
	public MedicoCita (MedicoCitaDTO medicoCita) {
		
		this.mc = medicoCita;
		
	}
	
	public int getIdCita() {
		
		return mc.idCita;
		
	}
	
    public int getIdMedico() {
		
		return mc.idMedico;
		
	}

}
