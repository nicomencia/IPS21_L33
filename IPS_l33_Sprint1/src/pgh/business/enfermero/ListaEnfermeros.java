package pgh.business.enfermero;

import java.util.ArrayList;
import java.util.List;

public class ListaEnfermeros {

	List<EnfermeroDTO> result;
	List<Enfermero> enfermeros = new ArrayList<Enfermero>();

	
	public ListaEnfermeros() {
		result = new FindAllEnfermeros().execute();
	}
	
	public void listarEnfermeros() {
				
		for(EnfermeroDTO e : result) {
			System.out.println(e.idEnfermero);
			System.out.println(e.nombre);
			System.out.println(e.apellidos);
		}
	}
	
	public List<Enfermero> getEnfermeros(){
		return enfermeros;
	}
	
	public void creaListaEnfermeros() {
		for (EnfermeroDTO e : result) {
			Enfermero enfermero = new Enfermero(e);
			enfermeros.add(enfermero);
		}
	}
	
}
