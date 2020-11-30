package pgh.business.enfermedad;

import java.util.Date;

public class EnfermedadDTO {
	public int id_emfermedad;
	public String nombre;
	public Date fecha_inicio;
	public Date fecha_fin;
	public int id_paciente;
	public boolean declaracion = false;
	public boolean seguimiento = false;
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(seguimiento == true)
		{
			return nombre + "  Se lleva siguiendo desde: " + fecha_inicio;
		}
		if(seguimiento == false && fecha_fin!=null)
		{
			return nombre + "  Se empezó el seguimiento desde: " + fecha_inicio + " y se termino el seguimiento: " + fecha_fin;
		}
		else
		{
			return nombre;
		}
	}
}
