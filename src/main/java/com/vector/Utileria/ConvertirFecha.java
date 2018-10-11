/**
 * ConvertirFecha.java -- 08/10/2018
 */
package com.vector.Utileria;

/**
 * @author Claudio WebServiceSGRH--com.vector.Utileria--ConvertirFecha
 */
public class ConvertirFecha {

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
