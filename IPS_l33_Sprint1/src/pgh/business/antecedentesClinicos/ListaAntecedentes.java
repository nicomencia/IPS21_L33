package pgh.business.antecedentesClinicos;

import java.util.ArrayList;
import java.util.List;

import pgh.business.prescripcion.FindAllPrescripciones;
import pgh.business.prescripcion.Prescripcion;
import pgh.business.prescripcion.PrescripcionDTO;

public class ListaAntecedentes {
	
	List<AntecedentesDTO> result ;
	List<AntecedentesDTO> result1 ;
	List<Antecedentes> antecedentes = new ArrayList<Antecedentes>();
	List<Antecedentes> antecedentes1 = new ArrayList<Antecedentes>();

	public ListaAntecedentes(int idPaciente) {
		
		
		result = new FindAllAntecedentes().execute();
		result1 = new FindAllAntecedentes().FindIdPaciente(idPaciente);
		
	}
		
		
	public List<Antecedentes> getAntecedentes(){
		
			return antecedentes;
	}
	
	public List<Antecedentes> getAntecedentesFiltrados(){
		
		return antecedentes1;
	}

		
	public void creaListaAntecedentes() {
			
			for(AntecedentesDTO p : result) {
				Antecedentes antecedente = new Antecedentes(p);
				antecedentes.add(antecedente);
			}
	}
	
	public void creaListaAntecedentesFiltrados() {
		
		for(AntecedentesDTO p : result1) {
			Antecedentes antecedente = new Antecedentes(p);
			antecedentes1.add(antecedente);
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
