package pgh.business.jornadamedico;

import java.util.ArrayList;
import java.util.List;



public class ListaJornadasMedico {

    List<JornadaMedicoDTO> result;
	
	List<JornadaMedico> jornadas = new ArrayList<JornadaMedico>();
	
	
	public ListaJornadasMedico () {
		result = new FindAllJornadasMedico().execute();
		
	}
	
	public List<JornadaMedico> getJornadasMedicos(){
		return jornadas;
	}

	
	public void creaJornadaMedico() {
		
		for(JornadaMedicoDTO c : result) {
			JornadaMedico jornada = new JornadaMedico(c);
			jornadas.add(jornada);
		}
	}
	
}
