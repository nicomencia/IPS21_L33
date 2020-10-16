package pgh.business.prescripcioncitapaciente;

import java.util.ArrayList;
import java.util.List;

public class ListaPrescripcionesCitaPaciente {
	
	List<PrescripcionCitaPacienteDTO> result ;
	List<PrescripcionCitaPaciente> prescripciones = new ArrayList<PrescripcionCitaPaciente>();

	public ListaPrescripcionesCitaPaciente() {
		
		result = new FindAllPrescripcionesCitaPaciente().execute();
		
	}
		
		
	public List<PrescripcionCitaPaciente> getPrescripciones(){
		
			return prescripciones;
	}

		
	public void creaListaPrescripciones() {
			
			for(PrescripcionCitaPacienteDTO p : result) {
				PrescripcionCitaPaciente prescripcion = new PrescripcionCitaPaciente(p);
				prescripciones.add(prescripcion);
			}
	}
		
	public void listarPrescripciones() {
		
		for (PrescripcionCitaPacienteDTO p : result) {
			System.out.println(p.idPrescripcion);
		
		}
		
	}
	
		
	
	
	
}
