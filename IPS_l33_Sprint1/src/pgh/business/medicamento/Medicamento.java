package pgh.business.medicamento;

import java.util.Date;

public class Medicamento {
	
	private MedicamentoDTO m;
	
	public Medicamento(MedicamentoDTO md) {
		
		this.m = md;
	}
	
	  public int getIdMedicamento() {
			
			return m.idMedicamento;
			
		}
		
		public int getIdPrescripcion() {
			
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

		public String getNombre() {
			return m.nombre;
		}

		public String getAnotacion() {
			return m.anotacion;
		}

		@Override
		public String toString() {
			return "Nombre: " + m.nombre + " Cantidad: "+ m.cantidad + " Duracion: " + m.duracion + " Intervalo: " + m.intervalo + " Anotacion: " + m.anotacion;
		}
		
		


}
