package pgh.business.causahistorial;

import java.util.List;

public class ListaCausaHistorial {

	public void listarCausasHistoriales() {
		
		List<CausaHistorialDTO> causasHistoriales = new FindAllCausaHistorial().execute();
		
		for(CausaHistorialDTO ch : causasHistoriales) {
			System.out.println(ch.idCausa);
			System.out.println(ch.idHistorial);
		}
		
	}
	
}
