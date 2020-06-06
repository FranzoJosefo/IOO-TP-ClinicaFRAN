package enums;

import java.util.stream.Stream;

public enum TipoUsuario {

	ADMINISTRADOR("adm"),
	RECEPCIONISTA("rec"),
	LABORATORISTA("lab");

    private String tipoUsuario;

    TipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
	
    TipoUsuario getFromString(String value) throws Exception {
        return Stream.of(TipoUsuario.values())
                .filter(tipoUsuario -> tipoUsuario.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new Exception("Tipo usuario invalido"));
    }
	
}
