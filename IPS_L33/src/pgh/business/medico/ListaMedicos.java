package pgh.business.medico;

import java.util.List;

public class ListaMedicos {

	public void listarMedicos() {
	
		List<MedicoDTO> result = new FindAllMedicos().execute();
		
		for(MedicoDTO m : result) {
			System.out.println(m.idMedico);
			System.out.println(m.nombre);
		}
	}
	
}
