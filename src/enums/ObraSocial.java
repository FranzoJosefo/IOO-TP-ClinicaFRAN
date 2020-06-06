package enums;

import java.util.stream.Stream;

public enum ObraSocial {

	osde("osde"),
	swissMedical("swissMedical"),
	osecac("osecac"),
	galeno("galeno");

    private String code;

    ObraSocial(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
	
	ObraSocial getFromString(String value) throws Exception {
        return Stream.of(ObraSocial.values())
                .filter(obraSocial -> obraSocial.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new Exception("Obra social inválida"));
    }
	
}
