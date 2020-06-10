package main.java.util;

import main.java.enumeration.PrefijoCodigo;

public class CodigoGenerator {
	
	public static String generateCodigo(PrefijoCodigo prefijo, int numero) {
		return String.format("%s%s", prefijo, numero);
	}
	
}
