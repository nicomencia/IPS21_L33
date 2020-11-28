package pgh.business.vacacionesSolicitadasEnfermero;

import java.util.ArrayList;
import java.util.List;

public class ListaVacacionesSolicitadasEnfermero {

	List<VacacionesSolicitadasEnfermero> vacaciones = new ArrayList<VacacionesSolicitadasEnfermero>();
	List<VacacionesSolicitadasEnfermeroDTO> result;

	public ListaVacacionesSolicitadasEnfermero() {

		result = new FindAllVacacionesSolicitadasEnfermero().execute();
	}

	public List<VacacionesSolicitadasEnfermero> getVacacionesSolicitadas() {
		return vacaciones;
	}

	public void creaVacaciones() {

		for (VacacionesSolicitadasEnfermeroDTO c : result) {
			VacacionesSolicitadasEnfermero v = new VacacionesSolicitadasEnfermero(c);
			vacaciones.add(v);
		}
	}

}
