package pgh.business.causa;

import java.util.List;

public class ListaCausas {

	public void listarCausas() {
		
		List<CausaDTO> causas = new FindAllCausas().execute();
		
		for(CausaDTO c : causas) {
			System.out.println(c.idCausa);
			System.out.println(c.descripcion);
		}
		
	}
	
}
