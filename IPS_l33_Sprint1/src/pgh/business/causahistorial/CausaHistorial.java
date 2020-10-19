package pgh.business.causahistorial;

public class CausaHistorial {
	private CausaHistorialDTO ch;
	
	public CausaHistorial (CausaHistorialDTO causaCita) {
		this.ch = causaCita;
	}
	
	public int getIdCausa()
	{
		return ch.idCausa;
	}
	
	public int getIdHistorial()
	{
		return ch.idHistorial;
	}
}
