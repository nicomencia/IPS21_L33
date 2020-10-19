package pgh.business.cita;

import java.util.Date;
import java.util.List;

import pgh.business.horario.Horario;
import pgh.business.horario.ListaHorarios;
import pgh.business.paciente.FindAllPacientes;
import pgh.business.paciente.ListaPacientes;
import pgh.business.paciente.Paciente;
import pgh.business.paciente.PacienteDTO;

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
	
	public void confirmarAsistencia() {
		if (c.asistencia == false) {
			c.asistencia = true;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListaPacientes lp = new ListaPacientes();
		//ListaHorarios lh = new ListaHorarios();
		lp.creaListaPacientes();
		//lh.creaListaHorarios();
		for (Paciente p : lp.getPacientes()) {
			if (this.getIdPaciente() == p.getIdPaciente()) {
				sb.append(p.getNombre() + " " + p.getApellidos());
				break;
			}
		}
		sb.append(" " + getDate().toString());
//		for (Horario h : lh.getHorarios()) {
//			if (this.getIdHorario() == h.getIdHorario()) {
//				sb.append(" " + h.getHoraInicio() + " " + h.getHoraFin());
//			}
//		}
		sb.append(" " + getAsistencia());
		return sb.toString();
	}
	
	
	


}
