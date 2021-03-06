package pgh.business.jornadamedico;

import java.util.Date;

public class JornadaMedico {
	
	private JornadaMedicoDTO jm;
	
	public JornadaMedico(JornadaMedicoDTO jmedico){
		
		this.jm= jmedico;
	
	}
	
    public int getIdJornadaMedico() {
		
		return jm.idJornadaMedico;
		
	}
	
	public int getIdMedico() {
		
		return jm.idMedico;
		
	}
	
	public String getDias() {
		
		return jm.dias;
	
	}
	
	public Date getDiaInicio() {
		
		return jm.diaInicio;
	
	}

	public Date getDiaFin() {
	
		return jm.diaFin;
	
	}
	
	public String getIdHoraInicio() {
		
		return jm.horaInicio;
		
	}
	
   public String getIdHoraFin() {
		
		return jm.horaFin;
		
	}

	

}
