package pgh.business.horario;

import java.util.List;

public class ListaHorario {

	List<HorarioDTO> horarios = new FindAllHorario().execute();
	
	public List<HorarioDTO> getHorarios()
	{
		return horarios;
	}
}
