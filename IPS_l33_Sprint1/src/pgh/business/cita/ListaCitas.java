package pgh.business.cita;

import java.util.List;

public class ListaCitas {

	public void listarCitas() {
	
		List<CitaDTO> result = new FindAllCitas().execute();
		
		for(CitaDTO c : result) {
			System.out.println(c.idCita);
			System.out.println(c.idPaciente);
			System.out.println(c.fecha);
			System.out.println(c.horaInicio);
			System.out.println(c.horaFin);
			System.out.println(c.ubicacion);
			System.out.println(c.asistencia);
		}
	}
	
}
