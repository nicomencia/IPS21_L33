package pgh.business.gerente;

import java.util.List;

public class ListaGerentes {
	
	private FindAllGerentes findGerentes;
	private List<GerenteDTO> gerentes;
	
	public ListaGerentes() {
		findGerentes = new FindAllGerentes();
		gerentes = findGerentes.execute();
	}
	
	public List<GerenteDTO> getGerentes()
	{
		return gerentes;
	}
	
	public GerenteDTO getGerente() {
		return gerentes.get(0);
	}

}
