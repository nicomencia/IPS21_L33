package pgh.business.antecedentescitapaciente;

import java.util.ArrayList;
import java.util.List;

public class ListaAntecedentesCitaPaciente {
	
	List<AntecedentesCitaPacienteDTO> result ;
	List<AntecedentesCitaPaciente> prescripciones = new ArrayList<AntecedentesCitaPaciente>();

	public ListaAntecedentesCitaPaciente() {
		
		result = new FindAllAntecedentesCitaPaciente().execute();
		
	}
		
		
	public List<AntecedentesCitaPaciente> getPrescripciones(){
		
			return prescripciones;
	}

		
	public void creaListaPrescripciones() {
			
			for(AntecedentesCitaPacienteDTO p : result) {
				AntecedentesCitaPaciente prescripcion = new AntecedentesCitaPaciente(p);
				prescripciones.add(prescripcion);
			}
	}
		
	public void listarPrescripciones() {
		
		for (AntecedentesCitaPacienteDTO p : result) {
			System.out.println(p.idAntecedente);
		
		}
		
	}
	
		
	
	
	
}
