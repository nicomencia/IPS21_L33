package pgh.business.cie10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
	
	private List<Nodo> nodos;
	private List<NodoMayor> nodosMayores;
	public ReadFile()
	{
		nodos = new ArrayList<Nodo>();
		nodosMayores = new ArrayList<NodoMayor>();
	}
	
	public void leer(String file)
	{
		BufferedReader fich= null;
		String linea;

		try {
			// Se abre el fichero de texto
			fich= new BufferedReader(new FileReader(file));
			 linea="";
			while(linea != null) {
				
			linea= fich.readLine();
			if(linea!=null)
			{
			String[] linea2 = linea.split("\t");
			Nodo nodo = new Nodo();
			nodo.codigo = linea2[0];
			nodo.nombre = linea2[1];
			nodos.add(nodo);
			// La primera línea contiene el número de elementos
			
			}
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero: "+file);
		} catch (IOException e) {
			System.out.println("Error en la lectura del fichero: "+file);
		}
	}
	
	
	public void leerMenores(String file)
	{
		BufferedReader fich= null;
		String linea;

		try {
			// Se abre el fichero de texto
			fich= new BufferedReader(new FileReader(file));
			 linea="";
			while(linea != null) {
				
			linea= fich.readLine();
			if(linea!=null && !linea.equals(" ") && !linea.equals(""))
			{
			String[] linea2 = linea.split("\t");
			if(linea2.length>=2)
			{
			NodoMayor nodo = new NodoMayor(linea2[1], linea2[0]);
			nodosMayores.add(nodo);
			}
			// La primera línea contiene el número de elementos
			
			}
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero: "+file);
		} catch (IOException e) {
			System.out.println("Error en la lectura del fichero: "+file);
		}
	}
	public List<Nodo> getNodos()
	{
		return nodos;
	}
	
	public List<NodoMayor> getNodosMayores()
	{
		return nodosMayores;
	}
}
