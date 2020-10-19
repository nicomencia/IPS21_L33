package pgh.business.horario;

public class Horario {

	HorarioDTO h;
	
	public Horario(HorarioDTO h) {
		this.h = h;
	}
	
	public int getIdHorario() {
		return h.idHorario;
	}
	
	public String getHoraInicio() {
		return h.horaInicio;
	}
	
	public String getHoraFin() {
		return h.horaFin;
	}
	
	public void cambioHoraInicio(String hora) {
		h.horaInicio = hora;
	}
	
	public void cambioHoraFinal(String hora) {
		h.horaFin = hora;
	}
	
}
