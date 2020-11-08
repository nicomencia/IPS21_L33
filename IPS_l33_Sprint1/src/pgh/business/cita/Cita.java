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
	
	
	public String toString() {
		
		StringBuilder sb =new StringBuilder();
		sb.append("Cita del dia: " + getDate() + " con el paciente: " + getNombrePaciente() + " ubicacion: " +  getIdUbicacion() + " Contacto " + infoContacto());
		return sb.toString();
	}

	public int getIdUbicacion() {
		return c.idUbicacion;
	}
	
	public String getNombrePaciente() {
		
		return c.nombrePaciente;
		
	}
	
	
	
	
	

}
