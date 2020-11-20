package pgh.business.vacuna;

import java.util.ArrayList;
import java.util.List;

public class ListaVacunas {
	
	List<VacunaDTO> result ;
	List<Vacuna> prescripciones = new ArrayList<Vacuna>();

	public ListaVacunas() {
		
		result = new FindAllVacunas().execute();
		
	}
		
		
	public List<Vacuna> getPrescripciones(){
		
			return prescripciones;
	}

		
	public void creaListaPrescripciones() {
			
			for(VacunaDTO p : result) {
				Vacuna prescripcion = new Vacuna(p);
				prescripciones.add(prescripcion);
			}
	}
		
	
		
	
	
	
}
