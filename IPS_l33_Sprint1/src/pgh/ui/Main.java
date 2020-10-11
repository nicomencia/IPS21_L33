package pgh.ui;

import pgh.business.cita.ListaCitas;
import pgh.business.medico.ListaMedicos;
import pgh.business.paciente.ListaPacientes;

public class Main {

	public static void main(String[] args){
		
//		ListaMedicos lm = new ListaMedicos();
//		
//		lm.listarMedicos();
		
		ListaCitas lp = new ListaCitas();
		lp.listarCitas();
	}

}
