package pgh.util;

import java.lang.reflect.InvocationTargetException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Utilidades varias con metodos generales de serializacion, conversion a csv y conversion de fechas
 */
public class Util {
	private Util() {
	    throw new IllegalStateException("Utility class");
	}

	/**
	 * Serializa una lista de objetos a formato json insertando saltos de linea entre cada elemento 
	 * para facilitar la comparacion de resultados en las pruebas utilizando jackson-databind
	 * (opcionalmente permite obtene una representacion similar a csv).
	 * @param pojoList Lista de objetos a serializar
	 * @param asArray si es true codifica los diferentes campos del objeto como un array 
	 * y elimina comillas para facilitar la comparacion, si es false devuelve el json completo
	 * @return el string que representa la lista serializada
	 */

	private static void addPojoLineToCsv(StringBuilder sb, Map<String, String> objectAsMap, String[] fields, String separator, String begin, String end, String nullAs) {
		sb.append(begin);
		for (int j=0; j<fields.length; j++) {
			String value;
			if (objectAsMap==null) //nombre del campo si no hay map
				value = fields[j];
			else //valor del campo o el especificado para null
				value = objectAsMap.get(fields[j])==null ? nullAs : objectAsMap.get(fields[j]);
			sb.append((j==0 ? "" : separator) + value);
		}
		sb.append(end + "\n");
	}

	/**
	 * Convierte un array bidimensional de strings a csv (usado para comparaciones del ui con AssertJ Swing)
	 */
	public static String arraysToCsv(String[][] arrays) {
		return arraysToCsv(arrays,null,",","","");
	}
	/**
	 * Convierte un array bidimensional de strings a csv permitiendo parametrizacion
	 * (usado para comparaciones del ui con AssertJ Swing y JBehave)
	 */
	public static String arraysToCsv(String[][] arrays, String[] fields, String separator, String begin, String end) {
		StringBuilder sb=new StringBuilder();
		if (fields!=null)
			addArrayLineToCsv(sb,fields,separator,begin,end);
		for (int i=0; i<arrays.length; i++) 
			addArrayLineToCsv(sb,arrays[i],separator,begin,end);
		return sb.toString();
	}
	private static void addArrayLineToCsv(StringBuilder sb, String[] array, String separator, String begin, String end) {
		sb.append(begin);
		for (int j=0; j<array.length; j++)
			sb.append((j==0 ? "" : separator) + array[j]);
		sb.append(end);
		sb.append("\n");
	}
	
	/** 
	 * Convierte fecha repesentada como un string iso a fecha java (para conversion de entradas de tipo fecha)
	 */
	public static Date isoStringToDate(String isoDateString) {
		try {
		return new SimpleDateFormat("yyyy-MM-dd").parse(isoDateString);
		} catch (ParseException e) {
			throw new ApplicationException("Formato ISO incorrecto para fecha: "+isoDateString);
		}
	}
	/** 
	 * Convierte fecha java a un string formato iso (para display o uso en sql) 
	 */
	public static String dateToIsoString(Date javaDate) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(javaDate);
	}
	
}
