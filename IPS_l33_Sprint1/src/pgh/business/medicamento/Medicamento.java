package pgh.business.medicamento;

import java.util.Date;

public class Medicamento {
	
	private MedicamentoDTO m;
	
	public Medicamento(MedicamentoDTO md) {
		
		this.m = md;
	}
	
	  public String getIdMedicamento() {
			
			return m.idMedicamento;
			
		}
		
		public String getIdPrescripcion() {
			
			return m.idPrescripcion;
			
		}
		
		public int getCantidad() {
			
			return m.cantidad;
		
		}
		

		public String getIntervalo() {
		
			return m.intervalo;
		
		}
		
		public String getDuracion() {
			
			return m.duracion;
			
		}
		
		public String getObservacion() {
			
			return m.observacion;
			
		}



}
