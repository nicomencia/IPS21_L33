package pgh.business.diagnostico;

import java.util.List;

public class ListaDiagnosticos {

	public void listarDiagnosticos() {
		List<DiagnosticoDTO> diagnosticos = new FindAllDiagnosticos().execute();
		
		for(DiagnosticoDTO d : diagnosticos) {
			System.out.println(d.idDiagnostico);
			System.out.println(d.idCita);
			System.out.println(d.descripcion);
		}
	}
	
}
