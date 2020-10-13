package pgh.business.prescripcion;

import java.util.List;

public class ListaPrescripciones {

	public void listarPrescripciones() {
		List<PrescripcionDTO> result = new FindAllPrescripciones().execute();
		
		for (PrescripcionDTO p : result) {
			System.out.println(p.idPrescripcion);
			System.out.println(p.idPaciente);
			System.out.println(p.instruccion);
			System.out.println(p.horaAsignacion);
			System.out.println(p.diaAsignacion);
		}
	}
	
}
