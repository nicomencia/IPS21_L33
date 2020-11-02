package pgh.business.vacacionesmedico;

import java.util.ArrayList;
import java.util.List;

public class ListaVacacionesMedico {

	List<VacacionesMedico> vacaciones = new ArrayList<VacacionesMedico>();
	List<VacacionesMedicoDTO> result;

	public ListaVacacionesMedico() {

		result = new FindAllVacacionesMedico().execute();
	}

	public List<VacacionesMedico> getVacacionesSolicitadas() {
		return vacaciones;
	}

	public void creaVacaciones() {

		for (VacacionesMedicoDTO c : result) {
			VacacionesMedico v = new VacacionesMedico(c);
			vacaciones.add(v);
		}
	}

}
