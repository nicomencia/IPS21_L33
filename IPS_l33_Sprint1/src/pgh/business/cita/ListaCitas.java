package pgh.business.cita;

import java.util.ArrayList;
import java.util.List;


public class ListaCitas {
	
	List<Cita> citas = new ArrayList<Cita>();
	List<CitaDTO> result ;

	public ListaCitas() {
		
		result = new FindAllCitas().execute();
	}
	
	public List<Cita> getCitas(){
		return citas;
	}

		
	public void creaCitas() {
		
		for(CitaDTO c : result) {
			Cita cita = new Cita(c);
			citas.add(cita);
		}
	}
		
	
	public void creaListaCitas() {
		
		for(CitaDTO c : result) {
			Cita Cita = new Cita(c);
			citas.add(Cita);
		}
	}
	
	
	public void listarCitas() {
		
		for(CitaDTO c : result) {
			System.out.println(c.idCita);

		}
		
		
		
	}
	
}
