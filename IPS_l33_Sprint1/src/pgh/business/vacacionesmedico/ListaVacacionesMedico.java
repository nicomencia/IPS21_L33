package pgh.business.vacacionesmedico;

import java.util.ArrayList;
import java.util.List;

public class ListaVacacionesMedico {

	List<VacacionesMedicoDTO> result;
	List<VacacionesMedico> vm = new ArrayList<VacacionesMedico>();
	
	public ListaVacacionesMedico() {
		result = new FindAllVacacionesMedico().execute();
	}
	
	public void creaListaVacacionesMedico() {
		for (VacacionesMedicoDTO v : result) {
			VacacionesMedico vv = new VacacionesMedico(v);
			vm.add(vv);
		}
	}
	
	public List<VacacionesMedico> getVacacionesMedicos(){
		return vm;
	}
	
	public void addVM(VacacionesMedico v) {
		this.vm.add(v);
	}
	
	public void listarVacacionesMedicos() {

		for(VacacionesMedicoDTO vm : result) {
			System.out.println(vm.idVacacionesMedico);
			System.out.println(vm.idMedico);
			System.out.println(vm.diaInicio);
			System.out.println(vm.diaFin);
		}
		
	}
	
}
