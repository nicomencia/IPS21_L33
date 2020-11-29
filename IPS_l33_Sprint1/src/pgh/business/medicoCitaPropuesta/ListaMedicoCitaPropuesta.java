package pgh.business.medicoCitaPropuesta;

import java.util.ArrayList;
import java.util.List;

public class ListaMedicoCitaPropuesta {

	List<MedicoCitaPropuesta> medicos = new ArrayList<MedicoCitaPropuesta>();
	List<MedicoCitaPropuestaDTO> result;
	
	public ListaMedicoCitaPropuesta() {
		
		result = new FindAllMedicoCitaPropuesta().execute();
	
	}
	
	public List<MedicoCitaPropuesta> getMedicoCitas(){
		return medicos;
	}

	
	public void creaListaMedicoCitas() {
		
		for(MedicoCitaPropuestaDTO m : result) {
			MedicoCitaPropuesta medicoCita = new MedicoCitaPropuesta(m);
			medicos.add(medicoCita);
		}
	}
	
	
	public void listarMedicoCitas() {

		for(MedicoCitaPropuestaDTO m : result) {
			System.out.println(m.idCitaPropuesta);
			System.out.println(m.idMedico);
		}
		
	}
	
}
