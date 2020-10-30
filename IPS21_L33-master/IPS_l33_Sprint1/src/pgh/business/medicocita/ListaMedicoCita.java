package pgh.business.medicocita;

import java.util.ArrayList;
import java.util.List;

public class ListaMedicoCita {
	
	List<MedicoCita> medicos = new ArrayList<MedicoCita>();
	List<MedicoCitaDTO> result ;
	
	public ListaMedicoCita() {
		
		result = new FindAllMedicoCita().execute();
	
	}
	
	public List<MedicoCita> getMedicoCitas(){
		return medicos;
	}

	
	public void creaListaMedicoCitas() {
		
		for(MedicoCitaDTO m : result) {
			MedicoCita medicoCita = new MedicoCita(m);
			medicos.add(medicoCita);
		}
	}
	
	
	public void listarMedicoCitas() {

		for(MedicoCitaDTO m : result) {
			System.out.println(m.idCita);
			System.out.println(m.idMedico);
		}
		
	}
	
	
	
}
