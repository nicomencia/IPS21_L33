package pgh.business.cita;

import java.util.Date;
import java.util.List;

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
	
	public String getHoraInicio() {
		return c.horaInicio;
	}
	
	public String getHoraFinal() {
		return c.horaFin;
	}
	
	public String getUbicacion() {
		return c.ubicacion;
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
	
	
	
	
	


}
