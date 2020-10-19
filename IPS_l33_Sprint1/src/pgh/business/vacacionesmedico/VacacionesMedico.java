package pgh.business.vacacionesmedico;

import java.util.Date;

public class VacacionesMedico {

	VacacionesMedicoDTO vm;
	
	public VacacionesMedico(VacacionesMedicoDTO vm) {
		this.vm = vm;
	}
	
	public int getIdVacacionesMedico() {
		return vm.idVacacionesMedico;
	}
	
	public int getIdMedico() {
		return vm.idMedico;
	}
	
	public Date getFechaInicio() {
		return vm.diaInicio;
	}
	
	public Date getFechaFin() {
		return vm.diaFin;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getIdVacacionesMedico() + "    " + getFechaInicio() + "    " + getFechaFin());
		return sb.toString();
	}
	
}
