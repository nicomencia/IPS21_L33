package pgh.business.prescripcion;

import java.util.ArrayList;
import java.util.List;

public class ListaPrescripciones {
	
	List<PrescripcionDTO> result ;
	List<Prescripcion> prescripciones = new ArrayList<Prescripcion>();

	public ListaPrescripciones() {
		
		result = new FindAllPrescripciones().execute();
		
	}
		
		
	public List<Prescripcion> getPrescripciones(){
		
			return prescripciones;
	}

		
	public void creaListaPrescripciones() {
			
			for(PrescripcionDTO p : result) {
				Prescripcion prescripcion = new Prescripcion(p);
				prescripciones.add(prescripcion);
			}
	}
		
	public void listarPrescripciones() {
		
		for (PrescripcionDTO p : result) {
			System.out.println(p.idPrescripcion);
			System.out.println(p.instruccion);
			System.out.println(p.horaAsignacion);
			System.out.println(p.diaAsignacion);
		}
		
	}
	
		
	
	
	
}
