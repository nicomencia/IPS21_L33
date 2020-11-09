package pgh.business.medicoSustituto;

import java.util.ArrayList;
import java.util.List;


public class ListaMedicosSustitutos {
	
	List<MedicoSustituto> medicos = new ArrayList<MedicoSustituto>();
	List<MedicoSustitutoDTO> result ;
	
	public ListaMedicosSustitutos() {
		
		result = new FindAllMedicosSustitutos().execute();
	
	}
	
	public List<MedicoSustituto> getMedicos(){
		return medicos;
	}

	
	public void creaListaMedicos() {
		
		for(MedicoSustitutoDTO m : result) {
			MedicoSustituto medico = new MedicoSustituto(m);
			medicos.add(medico);
		}
	}
	
	
	public void listarMedicos() {

		for(MedicoSustitutoDTO m : result) {
			System.out.println(m.nombre);
			System.out.println(m.apellidos);
		}
		
	}
	

	
}
