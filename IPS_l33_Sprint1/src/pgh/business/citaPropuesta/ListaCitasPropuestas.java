package pgh.business.citaPropuesta;

import java.util.ArrayList;
import java.util.List;


public class ListaCitasPropuestas {
	
	List<CitaPropuesta> citas = new ArrayList<CitaPropuesta>();
	List<CitaPropuestaDTO> result ;

	public ListaCitasPropuestas() {
		
		result = new FindAllCitasPropuestas().execute();
	}
	
	public List<CitaPropuesta> getCitasPropuestas(){
		return citas;
	}

		
	public void creaCitasPropuestas() {
		
		for(CitaPropuestaDTO c : result) {
			CitaPropuesta cita = new CitaPropuesta(c);
			citas.add(cita);
		}
	}
		
	
	public void creaListaCitasPropuesta() {
		
		for(CitaPropuestaDTO c : result) {
			CitaPropuesta Cita = new CitaPropuesta(c);
			citas.add(Cita);
		}
	}
	
	
	public void listarCitasPropuesta() {
		
		for(CitaPropuestaDTO c : result) {
			System.out.println(c.idCitaPropuesta);

		}
		
		
		
	}
	
}
