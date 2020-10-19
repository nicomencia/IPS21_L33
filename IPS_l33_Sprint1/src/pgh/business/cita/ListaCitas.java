package pgh.business.cita;

import java.util.ArrayList;
import java.util.List;

public class ListaCitas {

	List<CitaDTO> result;
	List<Cita> listaCitas = new ArrayList<Cita>();
	
	public ListaCitas() {
		result = new FindAllCitas().execute(); 
	}
	
	public void listarCitas() {
		
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
	
	public void creaListaCitas() {
		for (CitaDTO c : result) {
			Cita cita = new Cita(c);
			listaCitas.add(cita);
		}
	}
	
	public List<Cita> getListaCitas(){
		return this.listaCitas;
	}
	
}
