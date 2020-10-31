package pgh.business.enfermero;

import java.util.ArrayList;
import java.util.List;



public class ListaEnfermeros {

	List<Enfermero> enfermeros = new ArrayList<Enfermero>();
	List<EnfermeroDTO> result ;
	
	public ListaEnfermeros() {
		
		result = new FindAllEnfermeros().execute();
	
	}
	
	public List<Enfermero> getEnfermeros(){
		return enfermeros;
	}

	
	public void creaListaEnfermeros() {
		
		for(EnfermeroDTO m : result) {
			Enfermero enfermero = new Enfermero(m);
			enfermeros.add(enfermero);
		}
	}
	
	
	public void listarEnfermeros() {

		for(EnfermeroDTO m : result) {
			System.out.println(m.nombre);
			System.out.println(m.apellidos);
		}
		
	}
	
}
