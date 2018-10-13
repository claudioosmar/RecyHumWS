package com.vector.Utileria;

/**

*

 */



import java.util.logging.Level;

import java.util.logging.Logger;



// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: Log.java
 *   Descripción:  contiene el LOG para la consola
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public class Log {

	/**  Obtiene el Nombre de la Clase. */

	private String clase = Thread.currentThread().getStackTrace()[2].getClassName();

	/**  Inicializador del Loger. */

	private Logger LOGGER = Logger.getLogger(clase);

	/**
	 * Metodo para mandar Info´s.
	 *
	 * @param info            Descripcion de lo que sucede
	 * @return void
	 */

	public void info(String info) {

		String metodo = Thread.currentThread().getStackTrace()[2].getMethodName();

		LOGGER.log(Level.INFO, "CLASE[" + clase + "] METHODO[" + metodo + "] Descripcion: " + info);

	}

	/**
	 * Metodo para mandar Warning´s.
	 *
	 * @param warn            Descripcion de lo que sucede
	 * @return void
	 */

	public void warn(String warn) {

		String metodo = Thread.currentThread().getStackTrace()[2].getMethodName();

		LOGGER.log(Level.WARNING, "CLASE[" + clase + "] METHODO[" + metodo + "] Descripcion: " + warn);

	}

	/**
	 * Metodo para mandar Debug´s.
	 *
	 * @param debug            Descripcion de lo que sucede
	 * @return void
	 */

	public void debug(String debug) {

		String metodo = Thread.currentThread().getStackTrace()[2].getMethodName();

		LOGGER.log(Levels.DEBUG, "CLASE[" + clase + "] METHODO[" + metodo + "] Descripcion: " + debug);

	}

	/**
	 * Metodo para mandar Errores.
	 *
	 * @param error            Descripcion de lo que sucede
	 * @return void
	 */

	public void error(String error) {

		String metodo = Thread.currentThread().getStackTrace()[2].getMethodName();

		LOGGER.log(Level.INFO, "CLASE[" + clase + "] METHODO[" + metodo + "] Descripcion: " + error);

	}

	/**
	 * Metodo para mandar Fatal´s.
	 *
	 * @param fatal            Descripcion de lo que sucede
	 * @return void
	 */

	public void fatal(String fatal) {

		String metodo = Thread.currentThread().getStackTrace()[2].getMethodName();

		LOGGER.log(Level.SEVERE, "CLASE[" + clase + "] METHODO[" + metodo + "] Descripcion: " + fatal);

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