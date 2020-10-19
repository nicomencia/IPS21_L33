package pgh.business.vacacionesenfermero;

import java.util.ArrayList;
import java.util.List;

public class ListaVacacionesEnfermero {

	List<VacacionesEnfermeroDTO> result;
	List<VacacionesEnfermero> ve = new ArrayList<VacacionesEnfermero>(); 
	
	public ListaVacacionesEnfermero() {
		result = new FindAllVacacionesEnfermero().execute();
	}
	
	public void creaListaVacacionesEnfermero() {
		for (VacacionesEnfermeroDTO v : result) {
			VacacionesEnfermero vv = new VacacionesEnfermero(v);
			ve.add(vv);
		}
	}
	
	public List<VacacionesEnfermero> getVacacionesEnfermero(){
		return ve;
	}
	
	public void listarVacacionesEnfermeros() {
		
		for(VacacionesEnfermeroDTO ve : result) {
			System.out.println(ve.idVacacionesEnfermero);
			System.out.println(ve.idEnfermero);
			System.out.println(ve.diaInicio);
			System.out.println(ve.diaFin);
		}
		
	}
	
}
