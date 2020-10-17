package pgh.business.cita;

import java.util.Date;

public class Cita {
	
	private CitaDTO c;
	
	public Cita(CitaDTO cita) {
		
		this.c=cita;
		
	}
	
	public int getIdCita() {
		return c.idCita;
	}
	
	public int getIdPaciente() {
		return c.idPaciente;
	}
	
	public Date getDate() {
		return c.fecha;
	}
	
	public boolean getAsistencia() {
		return c.asistencia;
	}

	public boolean getUrgente() {
		return c.urgente;
	}

	public String infoContacto() {
		return c.infocontacto;
	}

	public int getIdHorario() {
		return c.idHorario;
	}
	
	public int getIdUbicacion() {
		return c.idUbicacion;
	}

}
