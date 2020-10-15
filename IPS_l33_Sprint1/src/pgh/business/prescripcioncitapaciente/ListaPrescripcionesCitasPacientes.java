package pgh.business.prescripcioncitapaciente;

import java.util.List;

public class ListaPrescripcionesCitasPacientes {

	public void listarPrescripciones() {
		List<PrescripcionCitaPacienteDTO> result = new FindAllPrescripcionesCitaPaciente().execute();
		
		for (PrescripcionCitaPacienteDTO p : result) {
			System.out.println(p.idPrescripcion);
			System.out.println(p.idPaciente);
			System.out.println(p.idcita);
	
		}
	}
	
}
