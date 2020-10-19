package pgh.business.causa;

import java.util.ArrayList;
import java.util.List;

public class ListaCausas {

	List<CausaDTO> result;
	List<Causa> causas = new ArrayList<Causa>();
	
	public ListaCausas() {
		result = new FindAllCausas().execute();
	}
	
	public List<Causa> getCausas(){
		return causas;
	}
	
	public void creaListaCausas() {
		for (CausaDTO c : result) {
			Causa causa = new Causa(c);
			causas.add(causa);
		}
	}
	
	public void listarCausas() {
		
		for(CausaDTO c : result) {
			System.out.println(c.idCausa);
			System.out.println(c.descripcion);
		}
		
	}
	
}
