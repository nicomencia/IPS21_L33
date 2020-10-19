package pgh.business.historial;

public class Historial {
	HistorialDTO h;
	
	public Historial(HistorialDTO h)
	{
		this.h = h;
	}
	
	public int getIdHistorial() {
		return h.idHistorial;
	}
	
	public int getIdPaciente()
	{
		return h.idPaciente;
	}
	
	public String toString()
	{
		return "El historial número: " + h.idHistorial;
	}
}
