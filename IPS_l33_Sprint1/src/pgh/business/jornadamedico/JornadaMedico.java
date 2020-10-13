package pgh.business.jornadamedico;

import java.util.Date;

public class JornadaMedico {
	
	private JornadaMedicoDTO jm;
	
	public JornadaMedico(JornadaMedicoDTO jmedico){
		
		this.jm= jmedico;
	
	}
	
    public String getIdJornadaMedico() {
		
		return jm.idJornadaMedico;
		
	}
	
	public String getIdMedico() {
		
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

	

}
