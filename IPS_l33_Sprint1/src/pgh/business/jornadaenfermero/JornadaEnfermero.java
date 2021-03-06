package pgh.business.jornadaenfermero;

import java.util.Date;

public class JornadaEnfermero {
	
	private JornadaEnfermeroDTO j;
	
	public JornadaEnfermero(JornadaEnfermeroDTO jo) {
		
		this.j=jo;
		
	}
	
	public int getIdJornadaEnfermero() {
		
		return j.idJornadaEnfermero;
		
	}
	
	public int getIdEnfermero() {
		
		return j.idEnfermero;
		
	}
	
	public String getDias() {
		
		return j.dias;
	
	}
	
	public Date getDiaInicio() {
		
		return j.diaInicio;
	
	}

	public Date getDiaFin() {
	
		return j.diaFin;
	
	}
	
	public String getIdHoraInicio() {
		
		return j.horaInicio;
		
	}

	public String getIdHoraFin() {
		return j.horaFin;
	}

}
