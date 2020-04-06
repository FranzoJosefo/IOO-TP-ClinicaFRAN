package clases;

import java.util.stream.Stream;

public enum Sexo {
	
	masculino("m"),
	femenino("f");

    private String code;

    Sexo(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
	
	Sexo getFromString(String value) throws Exception {
        return Stream.of(Sexo.values())
                .filter(sexo -> sexo.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new Exception("Sexo inválido"));
    }

}
