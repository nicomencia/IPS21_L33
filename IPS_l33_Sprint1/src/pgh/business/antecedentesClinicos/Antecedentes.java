package pgh.business.antecedentesClinicos;

import java.util.Date;

import pgh.business.prescripcion.PrescripcionDTO;

public class Antecedentes {

	 private AntecedentesDTO p;
	  
	 public Antecedentes(AntecedentesDTO pd) {
		 
		 this.p = pd;
	    	
	 }
	
	public int getIdAntecedentes() {
			
		return p.idAntecedenteClinico;
			
	}
		
		
	public String getDescripcion() {
			
		return p.descripcion;
		
		}
		
	public String getHoraAsignacion() {
			
		return p.horaAsignacion;
		
	}
		
	public Date getDiaAsignacion() {
		
		return p.diaAsignacion;
			
	}
	



	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Descripcion del antecedente : " + getDescripcion() + " - DIA DE ASIGNACION : " +getDiaAsignacion() + " - HORA DE ASIGNACION : " + getHoraAsignacion() );
		
		return sb.toString();
		
	}


	
	

}
