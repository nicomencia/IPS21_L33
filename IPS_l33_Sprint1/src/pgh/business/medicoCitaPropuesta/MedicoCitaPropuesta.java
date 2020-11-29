package pgh.business.medicoCitaPropuesta;

public class MedicoCitaPropuesta {

	private MedicoCitaPropuestaDTO mc;
	
	public MedicoCitaPropuesta (MedicoCitaPropuestaDTO medicoCita) {
		
		this.mc = medicoCita;
		
	}
	
	public int getIdCitaPropuesta() {
		
		return mc.idCitaPropuesta;
		
	}
	
    public int getIdMedico() {
		
		return mc.idMedico;
		
	}
    
}
