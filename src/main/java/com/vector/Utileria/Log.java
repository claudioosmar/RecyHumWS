/**
 * 
 */
package com.vector.Utileria;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *   Vector México
 *   Clase: Log.java
 *   Descripción:  Se utiliza para Logueo y Trazabilidad
 *   
 * 
 *   Control de Cambios:
 *  10/10/2018 Claudio Osmar Osorio Zuñiga - Creacion
 *   
 */
public class Log {
	
	@Autowired
	private JdbcTemplate con;
	/**
	 * Obtiene el Nombre de la Clase.
	 */
	private String clase = Thread.currentThread().getStackTrace()[2].getClassName();
	
	/**
	 * Inicializador del Loger.
	 */
	private Logger LOGGER = Logger.getLogger(clase);
	private static final String black="\033[30m"; 
	private static final String red="\033[31m"; 
	private static final String green="\u001B[32m"; 
	private static final String yellow="\033[33m"; 
	private static final String blue="\033[34m"; 
	private static final String purple="\033[35m"; 
	private static final String cyan="\033[36m"; 
	private static final String white="\033[37m";
	private static final String reset="\u001B[0m";
	

	/**
	 * Clase: info
	 * Descripcion:Metodo para mandar Info´s.
	 * Metodo sin valores de retorno.
	 *
	 * @param info Tipo de Dato resivido String
	 */
	public void info(String info) {
		String metodo = Thread.currentThread().getStackTrace()[2].getMethodName();
		LOGGER.log(Level.INFO,green+"--INFO-- CLASE[" + clase + "] METHODO[" + metodo + "] Descripcion: " + info+reset);
	}
	

	/**
	 * Clase: warn
	 * Descripcion:Metodo para mandar Warning´s.
	 * Metodo sin valores de retorno.
	 *
	 * @param warn Tipo de Dato resivido String
	 */
	public void warn(String warn) {
		String metodo = Thread.currentThread().getStackTrace()[2].getMethodName();

		LOGGER.log(Level.WARNING,yellow+ "--WARN-- CLASE[" + clase + "] METHODO[" + metodo + "] Descripcion: " + warn+reset);

	}
	
	
	/**
	 * Clase: debug
	 * Descripcion: Metodo para mandar Debug´s.
	 * Metodo sin valores de retorno.
	 *
	 * @param debug Tipo de Dato resivido String
	 */
	public void debug(String debug) {
		String metodo = Thread.currentThread().getStackTrace()[2].getMethodName();

		LOGGER.log(Levels.DEBUG,blue+ "--DEBUG-- CLASE[" + clase + "] METHODO[" + metodo + "] Descripcion: " + debug+reset);
	}
	
	
	/**
	 * Clase: error
	 * Descripcion: Metodo para mandar Errores.
	 * Metodo sin valores de retorno.
	 *
	 * @param error Tipo de Dato resivido String
	 */
	public void error(String error) {
		String metodo = Thread.currentThread().getStackTrace()[2].getMethodName();

		LOGGER.log(Level.INFO, red+"--ERROR-- CLASE[" + clase + "] METHODO[" + metodo + "] Descripcion: " + error+reset);

	}
	

	/**
	 * Clase: fatal
	 * Descripcion:  Metodo para mandar Fatal´s.
	 * Metodo sin valores de retorno.
	 *
	 * @param fatal Tipo de Dato resivido String
	 */
	public void fatal(String fatal) {
		String metodo = Thread.currentThread().getStackTrace()[2].getMethodName();
		LOGGER.log(Level.SEVERE, purple+"--FATAL-- CLASE[" + clase + "] METHODO[" + metodo + "] Descripcion: " + fatal+reset);
		
	}
	
}

class Levels extends Level {
	/** Serial version UID de la clase */
	private static final long serialVersionUID = -718855949198972373L;
	/** Creando un nuevo Level */
	public static final Level DEBUG = new Levels("debug", Level.INFO.intValue());
	/** Creando un nuevo Level */
	public static final Level ERROR = new Levels("error", Level.SEVERE.intValue() - 1);
	/** Inicializando los nuevos Level´s */
	public Levels(String name, int value) {
		super(name, value);

	}

}
