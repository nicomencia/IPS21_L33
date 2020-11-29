package pgh.business.registro;

import java.util.ArrayList;
import java.util.List;

public class ListaRegistros {

	List<Registro> registros = new ArrayList<Registro>();
	List<RegistroDTO> result ;
	
	public ListaRegistros() {
		
		result = new FindAllRegistros().execute();
	
	}
	
	public List<Registro> getRegistros(){
		return registros;
	}

	
	public void creaListaRegistros() {
		
		for(RegistroDTO r : result) {
			Registro registro = new Registro(r);
			registros.add(registro);
		}
	}
	
	
	public void listarRegistros() {

		for(RegistroDTO r : result) {
			System.out.println(r.idRegistro);
			System.out.println(r.fecha);
			System.out.println(r.descripcion);
		}
		
	}
	
}
