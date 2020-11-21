package pgh.business.enfermeroCita;

import java.util.ArrayList;
import java.util.List;

public class ListaEnfermeroCita {
	
	List<EnfermeroCita> medicos = new ArrayList<EnfermeroCita>();
	List<EnfermeroCitaDTO> result ;
	
	public ListaEnfermeroCita() {
		
		result = new FindAllEnfermeroCita().execute();
	
	}
	
	public List<EnfermeroCita> getEnfermeroCitas(){
		return medicos;
	}

	
	public void creaListaEnfermeroCitas() {
		
		for(EnfermeroCitaDTO m : result) {
			EnfermeroCita medicoCita = new EnfermeroCita(m);
			medicos.add(medicoCita);
		}
	}
	
	
	public void listarMedicoCitas() {

		for(EnfermeroCitaDTO m : result) {
			System.out.println(m.idCita);
			System.out.println(m.idEnfermero);
		}
		
	}
	
	
	
}
