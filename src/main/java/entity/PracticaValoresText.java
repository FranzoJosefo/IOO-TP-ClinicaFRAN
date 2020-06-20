package main.java.entity;

import java.util.HashMap;
import java.util.Map;

import main.java.Interface.IPracticaValores;

public class PracticaValoresText implements IPracticaValores {

	Map<String, String> valoresPosibles = new HashMap<String, String>();
	
	public PracticaValoresText(Map<String, String> valoresPosibles) {
		this.valoresPosibles = valoresPosibles;
	}
	
	@Override
	public boolean isResultadoValido(String resultado) {
		return valoresPosibles.values()
				.stream()
				.filter(posibleValor -> posibleValor.equals(resultado))
				.findFirst()
				.isPresent();
	}

	@Override
	public Map<String, String> toDto() {
		return valoresPosibles;
	}
	
}
