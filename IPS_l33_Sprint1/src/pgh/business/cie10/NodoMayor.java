package pgh.business.cie10;

import java.util.ArrayList;
import java.util.List;

public class NodoMayor {
	private String nombre;
	private String codigoInicio;
	private String codigoFin;
	private String codigo;
	private List<NodoMayor> nodos;
	private List<Nodo> nodosPequeños = new ArrayList<Nodo>();
	private ReadFile lee = new ReadFile();
	
	public NodoMayor(String n, String c1, String c2)
	{
		nodos = new ArrayList<NodoMayor>();
		nodosPequeños = new ArrayList<Nodo>();
		nombre = n;
		codigoInicio = c1;
		codigoFin = c2;
	}
	
	public NodoMayor()
	{
		lee.leer();
		nodosPequeños = lee.getNodos();
		nodos = new ArrayList<NodoMayor>();
		nombre  = "CIE-10-ES Diagnósticos 2018";
		NodoMayor nodo = new NodoMayor("CIERTAS ENFERMEDADES INFECCIOSAS Y PARASITARIAS (A00-B99)", "A00", "B99");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("NEOPLASIAS (C00-D49)", "C00", "D49");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DE LA SANGRE Y ÓRGANOS HEMATOPOYÉTICOS Y CIERTOS TRASTORNOS QUE AFECTAN AL MECANISMO INMUNOLÓGICO (D50-D89)", "D50", "D89");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES ENDOCRINAS, NUTRICIONALES Y METABÓLICAS (E00-E89)", "E00", "E89");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL SISTEMA NERVIOSO (G00-G99)", "G00", "G99");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("TRASTORNOS MENTALES Y DE COMPORTAMIENTO (F01-F99)", "F01", "F99");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL OJO Y SUS ANEXOS (H00-H59)", "H00", "H59");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL OÍDO Y DE LA APÓFISIS MASTOIDES (H60-H95)", "H60", "H95");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL APARATO CIRCULATORIO (I00-I99)", "I00", "I99");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL APARATO RESPIRATORIO (J00-J99)", "J00", "J99");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL APARATO DIGESTIVO (K00-K95)", "K00", "K95");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DE LA PIEL Y DEL TEJIDO SUBCUTÁNEO (L00-L99)", "L00", "L99");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL APARATO MUSCULOESQUELÉTICO Y DEL TEJIDO CONECTIVO (M00-M99)", "M00", "M99");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("ENFERMEDADES DEL APARATO GENITOURINARIO (N00-N99)", "N00", "N99");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("EMBARAZO, PARTO Y PUERPERIO (O00-O99)", "O00", "O99");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("CIERTAS AFECCIONES ORIGINADAS EN EL PERÍODO PERINATAL (P00-P96)", "P00", "P96");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("MALFORMACIONES CONGÉNITAS, DEFORMIDADES Y ANOMALÍAS CROMOSÓMICAS (Q00-Q99)", "Q00", "Q99");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("SÍNTOMAS, SIGNOS Y RESULTADOS ANORMALES DE PRUEBAS COMPLEMENTARIAS, NO CLASIFICADOS BAJO OTRO CONCEPTO (R00-R99)", "R00", "R99");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("LESIONES TRAUMÁTICAS, ENVENENAMIENTOS Y OTRAS CONSECUENCIAS DE CAUSAS EXTERNAS (S00-T88)", "S00", "T88");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("CAUSAS EXTERNAS DE MORBILIDAD (V00-Y99)", "V00", "Y99");
		añadirNodos(nodo);
		nodos.add(nodo);
		nodo = new NodoMayor("FACTORES QUE INFLUYEN EN EL ESTADO DE SALUD Y CONTACTO CON LOS SERVICIOS SANITARIOS (Z00-Z99)", "Z00", "Z99");
		añadirNodos(nodo);
		nodos.add(nodo);
		//listarNodos();
		
	}
	
	
	public void añadirNodos(NodoMayor nodo)
	{
		for(int i=0;i<nodosPequeños.size();i++)
		{
			Nodo nodoP = nodosPequeños.get(i);
			// if(nodoP.codigo.contains(nodo.codigoInicio) || nodoP.codigo.contains(nodo.codigoFin))
			if(nodosCondicion(nodoP,nodoP.codigo, nodo.codigoInicio,nodo.codigoFin))
			{
				nodo.addNodoPequeño(nodoP);
			}
		}
	}
	
	public void listarNodos()
	{
		for(int i=0;i<nodos.size();i++)
		{
			System.out.println(nodos.get(i).nombre);
		}
	}
	
	private boolean nodosCondicion(Nodo nodo1, String nodo, String codigoInicio, String codigoFin) {
		// TODO Auto-generated method stub
		String[] primero = codigoInicio.split("");
		String[] segundo = codigoFin.split("");
		String[] nodoP = nodo.split("");
		int primerNumero = Integer.parseInt(primero[1]+primero[2]);
		int segundoNumero =  Integer.parseInt(segundo[1]+segundo[2]);
		int tercerNumero = Integer.parseInt(nodoP[1]+nodoP[2]);
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

	private void addNodoPequeño(Nodo nodoP) {
		// TODO Auto-generated method stub
		nodosPequeños.add(nodoP);
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
	public List<NodoMayor> getNodos() {
		return nodos;
	}
	
	public void add(NodoMayor nodo)
	{
		nodos.add(nodo);
	}
	public void setNodos(List<NodoMayor> nodos) {
		this.nodos = nodos;
	}
}
