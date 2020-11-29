package pgh.business.enfermeroCitaPropuesta;

import java.util.ArrayList;
import java.util.List;

public class ListaEnfermeroCitaPropuesta {

	List<EnfermeroCitaPropuesta> medicos = new ArrayList<EnfermeroCitaPropuesta>();
	List<EnfermeroCitaPropuestaDTO> result ;
	
	public ListaEnfermeroCitaPropuesta() {
		
		result = new FindAllEnfermeroCitaPropuesta().execute();
	
	}
	
	public List<EnfermeroCitaPropuesta> getEnfermeroCitas(){
		return medicos;
	}

	
	public void creaListaEnfermeroCitas() {
		
		for(EnfermeroCitaPropuestaDTO m : result) {
			EnfermeroCitaPropuesta medicoCita = new EnfermeroCitaPropuesta(m);
			medicos.add(medicoCita);
		}
	}
	
	
	public void listarMedicoCitas() {

		for(EnfermeroCitaPropuestaDTO m : result) {
			System.out.println(m.idCitaPropuesta);
			System.out.println(m.idEnfermero);
		}
		
	}
}
