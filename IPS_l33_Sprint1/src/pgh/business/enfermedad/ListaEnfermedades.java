package pgh.business.enfermedad;

import java.util.List;

public class ListaEnfermedades {

	public void listarDiagnosticos() {
		List<EnfermedadDTO> enfermedades = new FindAllEnfermedades().execute();
		
		for(EnfermedadDTO d : enfermedades) {
			System.out.println(d.id_emfermedad);
			System.out.println(d.id_paciente);
			System.out.println(d.nombre);
		}
	}
}
