package pgh.business.cita;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pgh.business.horario.FindAllHorario;
import pgh.business.horario.HorarioDTO;
import pgh.business.ubicacion.FindAllUbicaciones;
import pgh.business.ubicacion.UbicacionDTO;

public class Cita {
	
	private CitaDTO c;
	private FindAllUbicaciones fU = new FindAllUbicaciones();
	private FindAllHorario fH = new FindAllHorario();
	private List<UbicacionDTO> ubicaciones = new ArrayList<UbicacionDTO>();
	private List<HorarioDTO> horarios = new ArrayList<HorarioDTO>();
	
	public Cita(CitaDTO cita) {
		this.horarios = fH.execute();
		this.c=cita;
		this.ubicaciones = fU.execute();
		
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
		sb.append("Cita del dia: " + getDate() + "--A las: " + getHorario() + "--Con el paciente: " + getNombrePaciente() + "--Ubicacion: " +  getNombreUbicacion() + "--Contacto " + infoContacto());
		return sb.toString();
	}

	public int getIdUbicacion() {
		return c.idUbicacion;
	}
	
	public String getNombreUbicacion()
	{
		for(int i=0;i<ubicaciones.size();i++)
		{
			if(ubicaciones.get(i).idUbicacion == c.idUbicacion)
			{
				return ubicaciones.get(i).nombre;
			}
		}
		return "";
	}
	
	public String getHorario()
	{
		for(int i=0;i<horarios.size();i++)
		{
			if(horarios.get(i).idHorario == c.idHorario)
			{
				return horarios.get(i).horaInicio;
			}
		}
		return "";
	}
	
	public String getNombrePaciente() {
		return c.nombrePaciente;
	}

	public boolean getMedicoAsignado() {
		return c.medicoAsignado;
	}
	
	

}
