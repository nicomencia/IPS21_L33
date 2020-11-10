package pgh.business.ubicacion;

import java.util.ArrayList;
import java.util.List;

public class ListaUbicaciones {

	List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
	List<UbicacionDTO> result;
	
	public ListaUbicaciones() {
		result = new FindAllUbicaciones().execute();
	}
	
	public List<Ubicacion> getUbicacion(){
		return ubicaciones;
	}
	
	public void creaListaUbicaciones() {
		
		for(UbicacionDTO u : result) {
			Ubicacion ubicacion = new Ubicacion(u);
			ubicaciones.add(ubicacion);
		}
	}
	
	public void listarUbicaciones() {
		
		for(Ubicacion u : ubicaciones) {
			System.out.println(u.getNombreUbicacion());
		}
	}
	
	public UbicacionDTO getUbicacionById(int id)
	{
		for(int i=0;i<result.size();i++)
		{
			if(result.get(i).idUbicacion==id)
			{
				return result.get(i);
			}
		}
		return null;
	}
	
}
