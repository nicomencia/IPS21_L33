package pgh.business.medicamento;

import java.util.ArrayList;
import java.util.List;


public class ListaMedicamentos {
	
	List<MedicamentoDTO> result;
	
	List<Medicamento> medicamentos = new ArrayList<Medicamento>();

	
	public ListaMedicamentos() {
		result= new FindAllMedicamentos().execute();
	}
	

	
	public List<Medicamento> getMedicamentos(){
		return medicamentos;
	}

	
	public void creaListaMedicamentos() {
		
		for(MedicamentoDTO p : result) {
			Medicamento medicamento = new Medicamento(p);
			medicamentos.add(medicamento);
		}
	}
	
}
