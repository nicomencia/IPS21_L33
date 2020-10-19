package pgh.business.medicamento;

import java.util.List;

public class ListaMedicamentos {

	public void listarMedicamentos() {
		
		List<MedicamentoDTO> medicamentos = new FindAllMedicamentos().execute();
		
		for(MedicamentoDTO m : medicamentos) {
			System.out.println(m.idMedicamento);
			System.out.println(m.idPrescripcion);
			System.out.println(m.cantidad);
			System.out.println(m.intervalo);
			System.out.println(m.duracion);
		}
		
	}
	
}
