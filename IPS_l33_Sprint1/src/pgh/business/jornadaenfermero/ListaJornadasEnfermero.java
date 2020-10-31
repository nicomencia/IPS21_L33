package pgh.business.jornadaenfermero;

import java.util.ArrayList;
import java.util.List;



public class ListaJornadasEnfermero {

	List<JornadaEnfermeroDTO> result;
	
	List<JornadaEnfermero> jornadas = new ArrayList<JornadaEnfermero>();
	
	
	public ListaJornadasEnfermero () {
		result = new FindAllJornadasEnfermero().execute();
		
	}
	
	public List<JornadaEnfermero> getJornadasEnfermeros(){
		return jornadas;
	}

	
	public void creaJornadaEnfermeros() {
		
		for(JornadaEnfermeroDTO c : result) {
			JornadaEnfermero jornada = new JornadaEnfermero(c);
			jornadas.add(jornada);
		}
	}
	
	
	
}
