package pgh.business.antecedentesClinicos;

import java.util.ArrayList;
import java.util.List;

import pgh.business.prescripcion.FindAllPrescripciones;
import pgh.business.prescripcion.Prescripcion;
import pgh.business.prescripcion.PrescripcionDTO;

public class ListaAntecedentes {
	
	List<AntecedentesDTO> result ;
	List<Antecedentes> antecedentes = new ArrayList<Antecedentes>();

	public ListaAntecedentes() {
		
		result = new FindAllAntecedentes().execute();
		
	}
		
		
	public List<Antecedentes> getAntecedentes(){
		
			return antecedentes;
	}

		
	public void creaListaAntecedentes() {
			
			for(AntecedentesDTO p : result) {
				Antecedentes antecedente = new Antecedentes(p);
				antecedentes.add(antecedente);
			}
	}
		
	public void listarAntecedentes() {
		
		for (AntecedentesDTO p : result) {
			System.out.println(p.idAntecedenteClinico);
			System.out.println(p.descripcion);
			System.out.println(p.horaAsignacion);
			System.out.println(p.diaAsignacion);
		}
		
	}
	

}
