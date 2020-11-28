package pgh.business.citaPropuesta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pgh.business.horario.FindAllHorario;
import pgh.business.horario.HorarioDTO;
import pgh.business.medico.FindAllMedicos;
import pgh.business.medico.MedicoDTO;
import pgh.business.ubicacion.FindAllUbicaciones;
import pgh.business.ubicacion.UbicacionDTO;

public class CitaPropuesta {
	
	private CitaPropuestaDTO c;
	private FindAllUbicaciones fU = new FindAllUbicaciones();
	private FindAllHorario fH = new FindAllHorario();
	private FindAllMedicos fM = new FindAllMedicos();
	private List<UbicacionDTO> ubicaciones = new ArrayList<UbicacionDTO>();
	private List<HorarioDTO> horarios = new ArrayList<HorarioDTO>();
	private List<MedicoDTO> medicos = new ArrayList<MedicoDTO>();
	
	public CitaPropuesta(CitaPropuestaDTO cita) {
		this.horarios = fH.execute();
		this.c=cita;
		this.ubicaciones = fU.execute();
		this.medicos = fM.execute();
	}
	
	public int getIdCitaPropuesta() {
		return c.idCitaPropuesta;
	}
	
	public int getIdPaciente() {
		return c.idPaciente;
	}
	
	public Date getDate() {
		return c.fecha;
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
		
		StringBuilder sb = new StringBuilder();
		sb.append("Cita propuesta por " + getNombreMedico() + " del dia: " + getDate() + "--Empieza a las: " + getHorario() + "--Con el paciente: " + getNombrePaciente() + "--Ubicacion: " +  getNombreUbicacion());
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
	
	public String getHorarioTarde()
	{
		for(int i=0;i<horarios.size();i++)
		{
			if(horarios.get(i).idHorario == c.idHorario)
			{
				return horarios.get(i).horaFin;
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
	
	public boolean getPendienteAprobacion() {
		return c.pendienteAprobacion;
	}
	
	public int getIdMedicoProponer() {
		return c.idMedicoProponer;
	}

	public String getNombreMedico() {
		
		for(int i=0;i<medicos.size();i++)
		{
			if(medicos.get(i).idMedico == c.idMedicoProponer)
			{
				return medicos.get(i).nombre + " " + medicos.get(i).apellidos;
			}
		}
		return "";
		
	}
}
