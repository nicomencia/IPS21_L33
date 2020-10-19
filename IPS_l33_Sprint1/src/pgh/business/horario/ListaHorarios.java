package pgh.business.horario;

import java.util.ArrayList;
import java.util.List;


public class ListaHorarios {

	List<Horario> horarios = new ArrayList<Horario>();
	List<HorarioDTO> result ;
	
	public ListaHorarios() {
		
		result = new FindAllHorarios().execute();
	
	}
	
	public List<Horario> getHorarios(){
		return horarios;
	}

	
	public void creaListaHorarios() {
		
		for(HorarioDTO h : result) {
			Horario horario = new Horario(h);
			horarios.add(horario);
		}
	}
	
	
	public void listarHorarios() {

		for(HorarioDTO h : result) {
			System.out.print(h.idHorario);
			System.out.print(h.horaInicio);
			System.out.print(h.horaFin);
		}
		
	}
	
	public String mostrarHoras(int idHorario) {
		StringBuilder sb = new StringBuilder();
		for (Horario h : horarios) {
			if (h.getIdHorario() == idHorario) {
				sb.append(h.getHoraInicio() + " - " + h.getHoraFin());
				break;
			}
		}
		return sb.toString();
	}
	
}
