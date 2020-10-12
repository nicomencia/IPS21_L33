package pgh.business.paciente;

import java.util.List;

public class ListaPacientes {

	
	
	public void listarPacientes() {
	
		List<PacienteDTO> result = new FindAllPacientes().execute();
		
		for(PacienteDTO p : result) {
			System.out.println(p.dni);
			System.out.println(p.nombre);
			System.out.println(p.apellidos);
			System.out.println(p.email);
			System.out.println(p.telefono);
		}
	}
	
}
