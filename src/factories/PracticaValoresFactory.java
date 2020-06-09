package factories;

import java.util.Map;

import Interfaces.PracticaValores;
import entities.PracticaValoresRange;
import entities.PracticaValoresText;
import enums.PracticaValoresTipo;

public class PracticaValoresFactory {

	public static PracticaValores createPracticaValores(PracticaValoresTipo tipo, Map<String, String> valoresPosibles) {
		if(PracticaValoresTipo.RANGE.equals(tipo)) {
			return new PracticaValoresRange(valoresPosibles);
		} else {
			return new PracticaValoresText(valoresPosibles);
		}
	}
	
}
