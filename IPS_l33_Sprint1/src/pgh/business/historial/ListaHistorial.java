package pgh.business.historial;

import java.util.ArrayList;
import java.util.List;

public class ListaHistorial {
	
	List<Historial> historiales = new ArrayList<Historial>();
	List<HistorialDTO> historialesDTO = new FindAllHistorial().execute();
	
	public void listarHistoriales() {
		
		
		
		for(HistorialDTO h : historialesDTO) {
			System.out.println(h.idHistorial);
			System.out.println(h.idPaciente);
		}
		
	}
	
	public List<Historial> getHistorial()
	{
		return historiales;
	}
	
	public void creaListaHistorial()
	{
		for(HistorialDTO h : historialesDTO) {
			Historial historial = new Historial(h);
			historiales.add(historial);
		}
	}
	
	
}
