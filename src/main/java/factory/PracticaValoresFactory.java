package main.java.factory;

import java.util.Map;

import main.java.Interface.PracticaValores;
import main.java.entity.PracticaValoresRange;
import main.java.entity.PracticaValoresText;
import main.java.enumeration.PracticaValoresTipo;

public class PracticaValoresFactory {

	public static PracticaValores createPracticaValores(PracticaValoresTipo tipo, Map<String, String> valoresPosibles) {
		if(PracticaValoresTipo.RANGE.equals(tipo)) {
			return new PracticaValoresRange(valoresPosibles);
		} else {
			return new PracticaValoresText(valoresPosibles);
		}
	}
	
}
