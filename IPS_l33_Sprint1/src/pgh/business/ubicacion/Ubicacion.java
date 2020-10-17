package pgh.business.ubicacion;

public class Ubicacion {

	UbicacionDTO u; 
	

	public Ubicacion (UbicacionDTO ubicacion) {
		u = ubicacion;
	}
	
	public int getIdUbicacion() {
		return u.idUbicacion;
	}
	
	public String getNombreUbicacion() {
		return u.nombre;
	}
	
	public String toString() {
		
		return u.nombre;
	}
	
}
