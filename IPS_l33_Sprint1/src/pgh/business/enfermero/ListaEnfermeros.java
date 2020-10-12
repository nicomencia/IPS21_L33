package pgh.business.enfermero;

import java.util.List;

public class ListaEnfermeros {

	public void listarEnfermeros() {
		
		List<EnfermeroDTO> result = new FindAllEnfermeros().execute();
		
		for(EnfermeroDTO e : result) {
			System.out.println(e.idEnfermero);
			System.out.println(e.nombre);
			System.out.println(e.apellidos);
		}
	}
	
}
