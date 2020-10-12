package pgh.business.paciente;

import java.util.ArrayList;
import java.util.List;


public class ListaPacientes {

	List<PacienteDTO> result;
	List<Paciente> pacientes = new ArrayList<Paciente>();
	
	
	public ListaPacientes () {
		result=new FindAllPacientes().execute();
	}
	
	public List<Paciente> getPacientes(){
		return pacientes;
	}

	
	public void creaListaPacientes() {
		
		for(PacienteDTO p : result) {
			Paciente paciente = new Paciente(p);
			pacientes.add(paciente);
		}
	}
	
	
	public void listarPacientes() {
		
		for(PacienteDTO p : result) {
			System.out.println(p.dni);
			System.out.println(p.nombre);
			System.out.println(p.apellidos);
			System.out.println(p.email);
			System.out.println(p.telefono);
		}
	}
	
}
