package enums;

import java.util.stream.Stream;

public enum PracticaValoresTipo {

	WORD("palabra"),
	RANGE("rango");

    private String practicaValoresTipo;

    PracticaValoresTipo(String practicaValoresTipo) {
        this.practicaValoresTipo = practicaValoresTipo;
    }

    public String getPracticaValoresTipo() {
        return practicaValoresTipo;
    }
	
    PracticaValoresTipo getFromString(String value) throws Exception {
        return Stream.of(PracticaValoresTipo.values())
                .filter(practicaValoresTipo -> practicaValoresTipo.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new Exception("Tipo de valores de practica invalido"));
    }
	
}
