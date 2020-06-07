package enums;

import java.util.stream.Stream;

public enum UsuarioTipo {

	ADMINISTRADOR("adm"),
	RECEPCIONISTA("rec"),
	LABORATORISTA("lab");

    private String usuarioTipo;

    UsuarioTipo(String tipoUsuario) {
        this.usuarioTipo = tipoUsuario;
    }

    public String getUsuarioTipo() {
        return usuarioTipo;
    }
	
    UsuarioTipo getFromString(String value) throws Exception {
        return Stream.of(UsuarioTipo.values())
                .filter(usuarioTipo -> usuarioTipo.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new Exception("Tipo usuario invalido"));
    }
	
}
