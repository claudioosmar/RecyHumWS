/**
 * ConvertirFecha.java -- 08/10/2018
 */
package com.vector.Utileria;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: ConvertirFecha.java
 *   Descripción:  convierte la fecha en un formato en especifico
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public class ConvertirFecha {

	/**
	 * Clase: converter 
	 * Descripcion:.
	 *
	 * @param fecha Tipo de Dato resivido String
	 * @return Retorna string
	 */
	public String converter(String fecha) {
//		System.out.println("fecha de conversion "+fecha);
		String auxiliar[]= fecha.split(" ");
		
		String auxiliarDos =auxiliar[0].toString();
//		System.out.println("-----dos----->"+auxiliarDos);
		String AuxiliarTres[]=auxiliarDos.split("-");
//		System.out.println("tres-----> "+" "+AuxiliarTres[0]+" "+AuxiliarTres[1]+" "+AuxiliarTres[2]);
		String auxiliarF=AuxiliarTres[2]+"/"+AuxiliarTres[1]+"/"+AuxiliarTres[0];
		
		return auxiliarF;
	}
}
