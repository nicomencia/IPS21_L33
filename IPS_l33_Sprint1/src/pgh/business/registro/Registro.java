package pgh.business.registro;

import java.sql.Date;

public class Registro {

private RegistroDTO reg;
	
	public Registro(RegistroDTO registro) {
		
		this.reg = registro;
		
	}
	
	public int getIdRegistro() {
		
		return reg.idRegistro;
		
	}
	
    public Date getFecha() {
		
		return reg.fecha;
		
	}
    
    public String getDescripcion() {
    	
    	return reg.descripcion;
    }
    
}
