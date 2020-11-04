package pgh.business.jornadamedico;

import java.util.ArrayList;
import java.util.List;



public class ListaJornadasMedico {

    List<JornadaMedicoDTO> result;
    List<JornadaMedicoDTO> result2;
	
	List<JornadaMedico> jornadas = new ArrayList<JornadaMedico>();
	List<JornadaMedico> jornadas2 = new ArrayList<JornadaMedico>();
	
	
	public ListaJornadasMedico (int idMedico) {
		result = new FindAllJornadasMedico().execute();
		result2 = new FindAllJornadasMedico().FindIdMedico(idMedico);
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
	
	public List<JornadaMedico> getJornadasMedicosFiltro(){
		return jornadas2;
	}

	
	public void creaJornadaMedicoFiltro() {
		
		for(JornadaMedicoDTO c : result2) {
			JornadaMedico jornada = new JornadaMedico(c);
			jornadas2.add(jornada);
		}
	}
	
}
