package pgh.business.jornadaenfermero;

import java.util.List;

public class ListaJornadasEnfermero {

	public void listarJornadasEnfermeros() {
		
		List<JornadaEnfermeroDTO> jornadasEnfermero = new FindAllJornadasEnfermero().execute();
		
		for(JornadaEnfermeroDTO je : jornadasEnfermero) {
			System.out.println(je.idJornadaEnfermero);
			System.out.println(je.idEnfermero);
			System.out.println(je.diaInicio);
			System.out.println(je.diaFin);
			System.out.println(je.horaInicio);
			System.out.println(je.horaFin);
		}
		
	}
	
}
