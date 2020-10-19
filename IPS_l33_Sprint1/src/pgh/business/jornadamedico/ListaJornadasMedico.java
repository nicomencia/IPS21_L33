package pgh.business.jornadamedico;

import java.util.List;


public class ListaJornadasMedico {

	public void listarJornadasMedicos() {
		
		List<JornadaMedicoDTO> jornadasMedico = new FindAllJornadasMedico().execute();
		
		for(JornadaMedicoDTO jm : jornadasMedico) {
			System.out.println(jm.idJornadaMedico);
			System.out.println(jm.idMedico);
			System.out.println(jm.dias);
			System.out.println(jm.diaInicio);
			System.out.println(jm.diaFin);
			System.out.println(jm.horaInicio);
			System.out.println(jm.horaFin);
		}
		
	}
	
}
