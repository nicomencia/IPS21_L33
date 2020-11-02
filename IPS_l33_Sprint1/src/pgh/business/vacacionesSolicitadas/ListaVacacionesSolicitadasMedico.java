package pgh.business.vacacionesSolicitadas;

import java.util.ArrayList;
import java.util.List;

public class ListaVacacionesSolicitadasMedico {

	List<VacacionesSolicitadasMedico> vacaciones = new ArrayList<VacacionesSolicitadasMedico>();
	List<VacacionesSolicitadasMedicoDTO> result;

	public ListaVacacionesSolicitadasMedico() {

		result = new FindAllVacacionesSolicitadasMedico().execute();
	}

	public List<VacacionesSolicitadasMedico> getVacacionesSolicitadas() {
		return vacaciones;
	}

	public void creaVacaciones() {

		for (VacacionesSolicitadasMedicoDTO c : result) {
			VacacionesSolicitadasMedico v = new VacacionesSolicitadasMedico(c);
			vacaciones.add(v);
		}
	}

}
