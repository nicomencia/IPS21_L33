package pgh.business.historial;

import java.util.List;

public class ListaHistorial {

	public void listarHistoriales() {
		
		List<HistorialDTO> historiales = new FindAllHistorial().execute();
		
		for(HistorialDTO h : historiales) {
			System.out.println(h.idHistorial);
			System.out.println(h.dni);
		}
		
	}
	
}
