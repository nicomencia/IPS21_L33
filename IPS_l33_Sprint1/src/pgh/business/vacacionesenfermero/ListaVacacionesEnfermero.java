package pgh.business.vacacionesenfermero;

import java.util.List;

public class ListaVacacionesEnfermero {

	public void listarVacacionesEnfermeros() {
		
		List<VacacionesEnfermeroDTO> vacacionesEnfermero = new FindAllVacacionesEnfermero().execute();
		
		for(VacacionesEnfermeroDTO ve : vacacionesEnfermero) {
			System.out.println(ve.idVacacionesEnfermero);
			System.out.println(ve.idEnfermero);
			System.out.println(ve.diaInicio);
			System.out.println(ve.diaFin);
		}
		
	}
	
}
