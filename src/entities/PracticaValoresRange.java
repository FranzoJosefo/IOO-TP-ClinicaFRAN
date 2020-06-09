package entities;

import java.time.temporal.ValueRange;
import java.util.HashMap;
import java.util.Map;

import Interfaces.PracticaValores;

public class PracticaValoresRange implements PracticaValores {

	Map<String, ValueRange> posiblesValores;
	
	PracticaValoresRange() {
		posiblesValores = new HashMap();
	}
	
	@Override
	public boolean isResultadoValido(String resultado) {
		return posiblesValores.values()
				.stream()
				.filter(posibleRango -> posibleRango.isValidIntValue(Integer.valueOf(resultado)))
				.findFirst()
				.isPresent();
	}
	
}
