package enums;

import java.util.stream.Stream;

public enum PrefijoCodigo {

	PETICION("PET"),
	PRACTICA("PRA"),
	SUCURSAL("SUC"),
	USUARIO("USU");

    private String prefijoCodigo;

    PrefijoCodigo(String prefijoCodigo) {
        this.prefijoCodigo = prefijoCodigo;
    }

    public String getPrefijoCodigo() {
        return prefijoCodigo;
    }
	
    PrefijoCodigo getFromString(String value) throws Exception {
        return Stream.of(PrefijoCodigo.values())
                .filter(prefijoCodigo -> prefijoCodigo.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new Exception("Prefijo invalido"));
    }
	
}
