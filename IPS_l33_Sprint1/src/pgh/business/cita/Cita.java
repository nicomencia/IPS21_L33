package pgh.business.cita;

import java.util.Date;

public class Cita {
	
	private CitaDTO c;
	
	public Cita(CitaDTO cita) {
		
		this.c=cita;
		
	}
	
	public String getIdCita() {
		return c.idCita;
	}
	
	public String getIdPaciente() {
		return c.idPaciente;
	}
	
	public String getIdMedico() {
		return c.idmedico;
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


}
