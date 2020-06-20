package main.java.entity;

import java.time.temporal.ValueRange;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import main.java.Interface.IPracticaValores;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.HashMap;

public class PracticaValoresRange implements IPracticaValores {

	Map<String, ValueRange> valoresPosibles = new HashMap<String, ValueRange>();
	
	private static int MIN = 0;
	private static int MAX = 1;
	
	public PracticaValoresRange(Map<String, String> valoresPosibles) {
		this.valoresPosibles = valoresPosibles.entrySet()
									.stream()
									.map(entry -> new SimpleEntry<String, ValueRange>(entry.getKey(), getRange(entry.getValue())))
									.collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));		
	}
	
	private ValueRange getRange(String limitesToFormat) {
		List<String> limites = Arrays.asList(limitesToFormat.split("-"));
		Long limiteMinimo = Long.valueOf(limites.get(MIN));
		Long limiteMaximo = Long.valueOf(limites.get(MAX));
		return ValueRange.of(limiteMinimo, limiteMaximo);
	}
	
	@Override
	public boolean isResultadoValido(String resultado) {
		return valoresPosibles.values()
				.stream()
				.filter(posibleRango -> posibleRango.isValidValue(Long.valueOf(resultado)))
				.findFirst()
				.isPresent();
	}

	@Override
	public HashMap<String, String> toDto() {
		return (HashMap<String, String>) valoresPosibles.entrySet()
				.stream()
				.map(entry -> new SimpleEntry<String, String>(entry.getKey(), String.format("%s-%s", entry.getValue().getMinimum(), entry.getValue().getMaximum())))
				.collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
	}
	
}
