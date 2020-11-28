package pgh.business.jornadaenfermero;

import java.util.ArrayList;
import java.util.List;

import pgh.business.jornadamedico.FindAllJornadasMedico;



public class ListaJornadasEnfermero {

	List<JornadaEnfermeroDTO> result;
	List<JornadaEnfermeroDTO> result2;
	
	List<JornadaEnfermero> jornadas = new ArrayList<JornadaEnfermero>();
	List<JornadaEnfermero> jornadas2 = new ArrayList<JornadaEnfermero>();
	
	
	public ListaJornadasEnfermero (int idEnfermero) {
		result = new FindAllJornadasEnfermero().execute();
		result2 = new FindAllJornadasEnfermero().FindIdMedico(idEnfermero);
		
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
	
	public List<JornadaEnfermero> getJornadasEnfermerosFiltro(){
		return jornadas2;
	}

	
	public void creaJornadaEnfermerosFiltro() {
		
		for(JornadaEnfermeroDTO c : result2) {
			JornadaEnfermero jornada = new JornadaEnfermero(c);
			jornadas2.add(jornada);
		}
	}
	
	
	
}
