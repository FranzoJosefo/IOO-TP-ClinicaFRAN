package main.java.entity;

import java.util.Map;

import main.java.Interface.PracticaValores;

public class PracticaValoresText implements PracticaValores {

	Map<String, String> valoresPosibles;
	
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
	public Map<String, String> toMap() {
		return valoresPosibles;
	}
	
}
