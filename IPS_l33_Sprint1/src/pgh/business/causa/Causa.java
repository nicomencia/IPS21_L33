package pgh.business.causa;

public class Causa {

	CausaDTO c;
	
	public Causa(CausaDTO c) {
		this.c = c;
	}
	
	public int getIdCausa() {
		return c.idCausa;
	}
	
	public int getIdCita() {
		return c.idCita;
	}
	
	public int getIdPaciente() {
		return c.idPaciente;
	}
	
	public String getDescripcion() {
		return c.descripcion;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getDescripcion());
		return sb.toString();
	}
	
}
