package pgh.business.cita;

import java.util.ArrayList;
import java.util.List;


public class ListaCitas {

		List<CitaDTO> result;
		
		List<Cita> citas = new ArrayList<Cita>();
		
		
		public ListaCitas () {
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
		
		public void ListarCitas() {
			
			for(CitaDTO c : result) {
				System.out.println(c.idCita);
			}
		}
		
		
		
	
	
}
