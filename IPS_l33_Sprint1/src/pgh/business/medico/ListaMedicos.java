package pgh.business.medico;

import java.util.ArrayList;
import java.util.List;


public class ListaMedicos {
	
	List<Medico> medicos = new ArrayList<Medico>();
	List<MedicoDTO> result ;
	
	public ListaMedicos() {
		
		result = new FindAllMedicos().execute();
	
	}
	
	public List<Medico> getMedicos(){
		return medicos;
	}

	
	public void creaListaMedicos() {
		
		for(MedicoDTO m : result) {
			Medico medico = new Medico(m);
			medicos.add(medico);
		}
		System.out.print(medicos.size());
		
	}
	
	
	public void listarMedicos() {

		for(MedicoDTO m : result) {
			System.out.println(m.nombre);
			System.out.println(m.apellidos);
		}
		
	}
	

	
}
