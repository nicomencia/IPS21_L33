package pgh.business.enfermeroSustituto;

import java.util.ArrayList;
import java.util.List;


public class ListaEnfermerosSustitutos {
	
	List<EnfermeroSustituto> medicos = new ArrayList<EnfermeroSustituto>();
	List<EnfermeroSustitutoDTO> result ;
	
	public ListaEnfermerosSustitutos() {
		
		result = new FindAllEnfermerosSustitutos().execute();
	
	}
	
	public List<EnfermeroSustituto> getMedicos(){
		return medicos;
	}

	
	public void creaListaMedicos() {
		
		for(EnfermeroSustitutoDTO m : result) {
			EnfermeroSustituto medico = new EnfermeroSustituto(m);
			medicos.add(medico);
		}
	}
	
	
	public void listarMedicos() {

		for(EnfermeroSustitutoDTO m : result) {
			System.out.println(m.nombre);
			System.out.println(m.apellidos);
		}
		
	}
	

	
}
