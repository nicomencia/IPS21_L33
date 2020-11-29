package pgh.business.enfermeroCitaPropuesta;

public class EnfermeroCitaPropuesta {

private EnfermeroCitaPropuestaDTO ec;
	
	public EnfermeroCitaPropuesta (EnfermeroCitaPropuestaDTO medicoCita) {
		
		this.ec = medicoCita;
		
	}
	
	public int getIdCitaPropuesta() {
		
		return ec.idCitaPropuesta;
		
	}
	
    public int getIdEnfermero() {
		
		return ec.idEnfermero;
		
	}
    
}
