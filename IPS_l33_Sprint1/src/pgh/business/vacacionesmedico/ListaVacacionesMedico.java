package pgh.business.vacacionesmedico;

import java.util.List;

public class ListaVacacionesMedico {

	public void listarVacacionesMedicos() {
		
		List<VacacionesMedicoDTO> vacacionesMedico = new FindAllVacacionesMedico().execute();
		
		for(VacacionesMedicoDTO vm : vacacionesMedico) {
			System.out.println(vm.idVacacionesMedico);
			System.out.println(vm.idMedico);
			System.out.println(vm.diaInicio);
			System.out.println(vm.diaFin);
		}
		
	}
	
}
