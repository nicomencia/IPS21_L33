package pgh.business;

public class MedicoDisplayDTO {
	private String id;
	private String descr;
	private String abierta;
	public MedicoDisplayDTO() {}
	public MedicoDisplayDTO(String rowId, String rowDescripcion, String rowEstado) {
		this.id=rowId;
		this.descr=rowDescripcion;
		this.abierta=rowEstado;
	}
	public String getId() { return this.id; }
	public String getDescr() { return this.descr; }
	public String getEstado() { return this.abierta; }
	public void setId(String value) { this.id=value; }
	public void setDescr(String value) { this.descr=value; }
	public void setAbierta(String value) { this.abierta=value; }
	//NOTA: se pueden generar getters y setters de forma automatica usando lombok:  
	//https://www.sitepoint.com/declutter-pojos-with-lombok-tutorial/
	//http://www.baeldung.com/intro-to-project-lombok
}
