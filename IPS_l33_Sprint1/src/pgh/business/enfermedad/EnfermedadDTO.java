package pgh.business.enfermedad;

import java.util.Date;

public class EnfermedadDTO {
	public int id_emfermedad;
	public String nombre;
	public Date fecha_inicio;
	public int id_paciente;
	public boolean declaracion = false;
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "nombre" + "Se lleva siguiente desde: " + fecha_inicio;
	}
}
