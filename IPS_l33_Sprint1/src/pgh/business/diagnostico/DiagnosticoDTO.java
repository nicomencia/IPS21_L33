package pgh.business.diagnostico;

public class DiagnosticoDTO {

	public String idDiagnostico;
	public int idCita;
	public String descripcion;
	public int idPaciente;
	public boolean obligatorio = false;
	public boolean seguimiento = false;
	
	@Override
	public String toString()
	{
		String a =  descripcion;
		if(obligatorio==true)
		{
			a+= " De Declaracion Obligatoria";
		}
		if(seguimiento==true)
		{
			a+= " Se va a realizar un seguimiento";
		}
		return a;
	}
	
 
}
