package pgh.business.citaPropuesta;

import java.util.Date;

public class CitaPropuestaDTO {
	
	public int idCitaPropuesta;
	public int idPaciente;
	public int idUbicacion;
	public Date fecha;
	public boolean urgente;
	public String infocontacto;
	public int idHorario;
	public String nombrePaciente;
	public boolean medicoAsignado;
	public boolean pendienteAprobacion;
	public int idMedicoProponer;
}
