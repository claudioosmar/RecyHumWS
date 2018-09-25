/**
 * 
 */
package com.vector.Utileria;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.stereotype.Service;

/**
 * @author vectormx
 *
 */
@Service
public class Encriptarsha1 {
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
