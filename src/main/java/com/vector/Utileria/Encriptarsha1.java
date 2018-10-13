/**
 * 
 */
package com.vector.Utileria;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: Encriptarsha1.java
 *   Descripción:  metodo de encriptacion
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Service
public class Encriptarsha1 {
	
	/**
	 * Clase: Encriptar 
	 * Descripcion:.
	 *
	 * @param kripto Tipo de Dato resivido String
	 * @return Retorna string
	 */
	public String Encriptar(String kripto) {
		byte[] newpassword = null;
		try {
			newpassword = MessageDigest.getInstance("SHA-1").digest(kripto.getBytes("utf-8"));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return Base64.getEncoder().encodeToString(newpassword);
	}
}
