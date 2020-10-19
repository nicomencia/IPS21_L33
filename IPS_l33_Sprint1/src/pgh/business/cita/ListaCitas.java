package pgh.business.cita;

import java.util.ArrayList;
import java.util.List;

import pgh.business.horario.FindAllHorarios;
import pgh.business.horario.Horario;
import pgh.business.horario.HorarioDTO;
import pgh.business.medico.Medico;
import pgh.business.medicocita.FindAllMedicoCita;
import pgh.business.medicocita.MedicoCitaDTO;
import pgh.business.paciente.FindAllPacientes;
import pgh.business.paciente.PacienteDTO;

public class ListaCitas {
	
	List<Cita> citas = new ArrayList<Cita>();
	List<CitaDTO> result ;
	List<HorarioDTO> horarios;
	List<PacienteDTO> pacientes;
	List<MedicoCitaDTO> citasMedico;
	


	public ListaCitas() {
		
		result = new FindAllCitas().execute();
		horarios =  new FindAllHorarios().execute();
		pacientes = new FindAllPacientes().execute();
		citasMedico = new FindAllMedicoCita().execute();
	}
	
	public List<Cita> getCitas(){
		return citas;
	}

	
	public void creaListaCitas() {
		
		for(CitaDTO c : result) {
			Cita Cita = new Cita(c);
			citas.add(Cita);
		}
	}
	
	
	public void listarCitas() {
		
		for(CitaDTO c : result) {
			System.out.println(c.idCita);
		}
	}
	
	
	public void listarCitasHora() {
		for(CitaDTO c : result)
		{
			if(encontrarHorarioCita(c)!=null)
			{
				System.out.println(encontrarHorarioCita(c).horaInicio + " " + encontrarHorarioCita(c).horaFin);
			}
		}
	}
	
	
	
	public HorarioDTO encontrarHorarioCita(CitaDTO cita)
	{
		for(HorarioDTO  h : horarios)
		{
			if(cita.idHorario == h.idHorario)
			{
				return h;
			}
		}
		return null;
	}
	
	public PacienteDTO encontrarPacienteCita(CitaDTO cita)
	{
		for(PacienteDTO p : pacientes)
		{
			if(cita.idPaciente == p.idPaciente)
			{
				return p;
			}
		}
		return null;
	}
	
	public void creaListaCitasMedico(Medico m) {
		
		for(CitaDTO c : result) {
			for(MedicoCitaDTO  mc : citasMedico)
			{
			if((m.getIdMedico() == mc.idMedico) && (mc.idCita == mc.idMedico))
			{
			Cita Cita = new Cita(c);
			citas.add(Cita);
			}
		}
	} 
	
}
}
