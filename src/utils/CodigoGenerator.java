package utils;

import enums.PrefijoCodigo;

public class CodigoGenerator {
	
	public static String generateCodigo(PrefijoCodigo prefijo, int numero) {
		return String.format("%s%s", prefijo, numero);
	}
	
}
