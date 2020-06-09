package entities;

import java.util.HashMap;
import java.util.Map;

import Interfaces.PracticaValores;

public class PracticaValoresText implements PracticaValores {

	Map<String, String> posiblesValores;
	
	PracticaValoresText() {
		posiblesValores = new HashMap();
	}
	
	@Override
	public boolean isResultadoValido(String resultado) {
		return posiblesValores.values()
				.stream()
				.filter(posibleValor -> posibleValor.equals(resultado))
				.findFirst()
				.isPresent();
	}
	
}
