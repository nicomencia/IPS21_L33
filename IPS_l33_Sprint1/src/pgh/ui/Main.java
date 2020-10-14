package pgh.ui;

import pgh.business.causa.ListaCausas;
import pgh.business.causahistorial.ListaCausaHistorial;
import pgh.business.cita.ListaCitas;
import pgh.business.diagnostico.ListaDiagnosticos;
import pgh.business.enfermero.ListaEnfermeros;
import pgh.business.historial.ListaHistorial;
import pgh.business.jornadaenfermero.ListaJornadasEnfermero;
import pgh.business.jornadamedico.ListaJornadasMedico;
import pgh.business.medicamento.ListaMedicamentos;
import pgh.business.medico.ListaMedicos;
import pgh.business.medicocita.ListaMedicoCita;
import pgh.business.paciente.ListaPacientes;
import pgh.business.prescripcion.ListaPrescripciones;
import pgh.business.vacacionesenfermero.ListaVacacionesEnfermero;
import pgh.business.vacacionesmedico.ListaVacacionesMedico;

public class Main {

	public static void main(String[] args){
		
	//	ListaMedicoCita lm = new ListaMedicoCita();
//		
	//	lm.listarMedicos();
		
		
	//	ListaCitas lp = new ListaCitas();
	//	lp.listarCitas();
		
//		ListaCausas l = new ListaCausas();
//		l.listarCausas();
		
//		ListaCausaHistorial l = new ListaCausaHistorial();
//		l.listarCausasHistoriales();
		
//		ListaCitas l = new ListaCitas();
//		l.listarCitas();
		
//		ListaDiagnosticos l = new ListaDiagnosticos();
//		l.listarDiagnosticos();
		
//		ListaEnfermeros l = new ListaEnfermeros();
//		l.listarEnfermeros();
		
//		ListaHistorial l = new ListaHistorial();
//		l.listarHistoriales();
		
//		ListaJornadasEnfermero l = new ListaJornadasEnfermero();
//		l.listarJornadasEnfermeros();
		
//		ListaJornadasMedico l = new ListaJornadasMedico();
//		l.listarJornadasMedicos();
		
//		ListaMedicamentos l = new ListaMedicamentos();
//		l.listarMedicamentos();
		
		ListaPacientes l = new ListaPacientes();
		l.listarPacientes();
		
//		ListaPrescripciones l = new ListaPrescripciones();
//		l.listarPrescripciones();
		
//		ListaVacacionesEnfermero l = new ListaVacacionesEnfermero();
//		l.listarVacacionesEnfermeros();
		
//		ListaVacacionesMedico l = new ListaVacacionesMedico();
//		l.listarVacacionesMedicos();
	}

}
