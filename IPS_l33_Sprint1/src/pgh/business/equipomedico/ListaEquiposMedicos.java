package pgh.business.equipomedico;

import java.util.ArrayList;
import java.util.List;

public class ListaEquiposMedicos {

	List<EquipoMedico> equipos = new ArrayList<EquipoMedico>();
	List<EquipoMedicoDTO> result ;
	
	public ListaEquiposMedicos() {
		
		result = new FindAllEquiposMedicos().execute();
	
	}
	
	public List<EquipoMedico> getEquiposMedicos(){
		return equipos;
	}

	
	public void creaListaEquiposMedicos() {
		
		for(EquipoMedicoDTO em : result) {
			EquipoMedico equipo = new EquipoMedico(em);
			equipos.add(equipo);
		}
	}
	
	
	public void listarEquiposMedicos() {

		for(EquipoMedicoDTO m : result) {
			System.out.println(m.nombre);
		}
		
	}
	
}
