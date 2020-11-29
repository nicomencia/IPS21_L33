package pgh.business.cie10;

import java.util.ArrayList;
import java.util.List;

public class NodoMayor {
	private String nombre;
	private String codigoInicio;
	private String codigoFin;
	private String codigo;
	private List<NodoMayor> nodos;
	private List<NodoMayor> nodosCategoria;
	private List<Nodo> nodosPeque�os = new ArrayList<Nodo>();
	private List<Nodo> nodosPeque�osRead = new ArrayList<Nodo>();
	private ReadFile lee = new ReadFile();
	
	public NodoMayor(String n, String c1, String c2)
	{
		nodos = new ArrayList<NodoMayor>();
		nodosPeque�osRead = new ArrayList<Nodo>();
		nodosCategoria = new ArrayList<NodoMayor>();
		nombre = n;
		codigoInicio = c1;
		codigoFin = c2;
	}
	
	
	
	
	public NodoMayor()
	{
		lee.leer("src/CIE101.txt");
		nodosPeque�osRead = lee.getNodos();
		lee.leerMenores("src/Copia de cie10v3.txt");
		nodosCategoria = lee.getNodosMayores();
		nodos = new ArrayList<NodoMayor>();
		nombre  = "CIE-10-ES Diagn�sticos 2018";
		a�adirNodosALaCategoria();
		NodoMayor nodo = new NodoMayor("CIERTAS ENFERMEDADES INFECCIOSAS Y PARASITARIAS (A00-B99)", "A00", "B99");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);	
		nodo = new NodoMayor("NEOPLASIAS (C00-D49)", "C00", "D49");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DE LA SANGRE Y �RGANOS HEMATOPOY�TICOS Y CIERTOS TRASTORNOS QUE AFECTAN AL MECANISMO INMUNOL�GICO (D50-D89)", "D50", "D89");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES ENDOCRINAS, NUTRICIONALES Y METAB�LICAS (E00-E89)", "E00", "E89");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL SISTEMA NERVIOSO (G00-G99)", "G00", "G99");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("TRASTORNOS MENTALES Y DE COMPORTAMIENTO (F01-F99)", "F01", "F99");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL OJO Y SUS ANEXOS (H00-H59)", "H00", "H59");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL O�DO Y DE LA AP�FISIS MASTOIDES (H60-H95)", "H60", "H95");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL APARATO CIRCULATORIO (I00-I99)", "I00", "I99");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL APARATO RESPIRATORIO (J00-J99)", "J00", "J99");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL APARATO DIGESTIVO (K00-K95)", "K00", "K95");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DE LA PIEL Y DEL TEJIDO SUBCUT�NEO (L00-L99)", "L00", "L99");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL APARATO MUSCULOESQUEL�TICO Y DEL TEJIDO CONECTIVO (M00-M99)", "M00", "M99");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL APARATO GENITOURINARIO (N00-N99)", "N00", "N99");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("EMBARAZO, PARTO Y PUERPERIO (O00-O99)", "O00", "O99");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("CIERTAS AFECCIONES ORIGINADAS EN EL PER�ODO PERINATAL (P00-P96)", "P00", "P96");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("MALFORMACIONES CONG�NITAS, DEFORMIDADES Y ANOMAL�AS CROMOS�MICAS (Q00-Q99)", "Q00", "Q99");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("S�NTOMAS, SIGNOS Y RESULTADOS ANORMALES DE PRUEBAS COMPLEMENTARIAS, NO CLASIFICADOS BAJO OTRO CONCEPTO (R00-R99)", "R00", "R99");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("LESIONES TRAUM�TICAS, ENVENENAMIENTOS Y OTRAS CONSECUENCIAS DE CAUSAS EXTERNAS (S00-T88)", "S00", "T88");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("CAUSAS EXTERNAS DE MORBILIDAD (V00-Y99)", "V00", "Y99");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("FACTORES QUE INFLUYEN EN EL ESTADO DE SALUD Y CONTACTO CON LOS SERVICIOS SANITARIOS (Z00-Z99)", "Z00", "Z99");
		a�adirNodos(nodo);
		a�adirNodosACategoria(nodo);
		nodos.add(nodo);
		//listarNodos();
		//System.out.print("FIN");
	}
	
	public void a�adirNodosALaCategoria()
	{
		for(int i=0;i<nodosCategoria.size();i++)
		{
			a�adirNodosACategoria(nodosCategoria.get(i));
		}
	}
	
	
	public void a�adirNodos(NodoMayor nodo)
	{
		for(int i=0;i<nodosCategoria.size();i++)
		{
			NodoMayor nodoP = nodosCategoria.get(i);
			if(nodosCondicion(nodoP,nodoP.codigo, nodo.codigoInicio,nodo.codigoFin))
			{
				//nodosCategoria.remove(nodoP);
				nodo.addNodoPeque�o(nodoP);
			}
		}
	}
	
	public void listarNodos()
	{
		for(int i=0;i<nodos.size();i++)
		{
			System.out.println(nodos.get(i).nombre);
			
			for(int j=0;j<nodos.get(i).nodos.size();j++)
			{
				System.out.println("|||||||" +  nodos.get(i).nodos.get(j).codigo + nodos.get(i).nodos.get(j).nombre);
				for(int z=0;z<nodos.get(i).nodos.get(j).nodosPeque�os.size();z++)
				{
					System.out.println("|||||||-----" + nodos.get(i).nodos.get(j).nodosPeque�os.get(z).codigo +  nodos.get(i).nodos.get(j).nodosPeque�os.get(z).nombre);
				}
			}
		}
	}
	
	public List<NodoMayor> getNodos() {
		return nodos;
	}
	
	public List<NodoMayor> getNodosCategoria()
	{
		return nodosCategoria;
	}
	public List<Nodo> getNodosMenores()
	{
		return nodosPeque�os;
	}
	
	private boolean nodosCondicion(NodoMayor nodo1, String nodo, String codigoInicio, String codigoFin) {
		// TODO Auto-generated method stub
		String[] primero = codigoInicio.split("");
		String[] segundo = codigoFin.split("");
		String[] nodoP = nodo.split("");
		int primerNumero = Integer.parseInt(primero[1]+primero[2]);
		int segundoNumero =  Integer.parseInt(segundo[1]+segundo[2]);
		if(nodoP[0].equals(primero[0]) || nodoP[0].equals(segundo[0]))
		{
		for(int i = primerNumero;i<=segundoNumero;i++)
		{
			String codigo1 =	primero[0] + i;
			String codigo2 = 	segundo[0] + i;
			if(nodo.contains(codigo1) || nodo.contains(codigo2))
			{
				return true;
			}
		}
		}
		return false;
	}
	
	private boolean nodosCondicionCategoria(String codigo, String codigoInicio) {
		// TODO Auto-generated method stub
		if((codigo!=null) && (codigoInicio !=null))
		{
//		System.out.println("++");
//		System.out.println(codigo);
//		System.out.println(codigoInicio);
//		System.out.println("++");
		String[] primero = codigo.split("");
		String[] segundo = codigoInicio.split("");
		String codigoNodo = primero[0]+primero[1]+primero[2];
		String codigoNodo2 = segundo[0]+segundo[1]+segundo[2];
		if(codigoNodo.equals(codigoNodo2))
		{
				return true;
		
		}
		
		}
		return false;
	}
	
	

	
	public void addNodoCategoria(NodoMayor nodoP, Nodo nodo)
	{
		nodoP.nodosPeque�os.add(nodo);
	}
	
	public void a�adirNodosACategoria(NodoMayor nodo)
	{
		for(int i=0;i<nodosPeque�osRead.size();i++)
		{
			Nodo nodoP = nodosPeque�osRead.get(i);
			
			if(nodosCondicionCategoria(nodoP.codigo, nodo.codigo))
			{
				//System.out.println(nodoP.codigo);
				//nodosPeque�osRead.remove(i);
				nodo.addNodoCategoria(nodo,nodoP);
			}
		}
	}

	public void addNodoPeque�o(NodoMayor nodoP) {
		// TODO Auto-generated method stub
		nodos.add(nodoP);
	}

	public NodoMayor(String n, String c)
	{
		nodos = new ArrayList<NodoMayor>();
		nombre = n;
		codigo = c;
	}
	
	
	public String getCodigoInicio() {
		return codigoInicio;
	}


	public void setCodigoInicio(String codigoInicio) {
		this.codigoInicio = codigoInicio;
	}


	public String getCodigoFin() {
		return codigoFin;
	}


	public void setCodigoFin(String codigoFin) {
		this.codigoFin = codigoFin;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nomnbre) {
		this.nombre = nomnbre;
	}
	
	
	public void add(NodoMayor nodo)
	{
		nodos.add(nodo);
	}
	public void setNodos(List<NodoMayor> nodos) {
		this.nodos = nodos;
	}
	
	@Override
	public String toString()
	{
		return nombre;
	}
}
