package entities;

import java.util.Map;

import Interfaces.PracticaValores;

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
