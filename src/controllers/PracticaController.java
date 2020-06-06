package controllers;

import java.util.ArrayList;
import java.util.List;

import Interfaces.PracticaValores;
import entidades.Practica;
import enums.PrefijoCodigo;
import utils.CodigoGenerator;

public enum PracticaController {

	INSTANCE;
	
	private int practicasCreadas = 0;
	private List<Practica> practicas = new ArrayList();
	
	public void createPractica(String codigo, String nombre, String grupo, int horasEsperaResultado, PracticaValores valoresNormales, PracticaValores valoresCriticos, PracticaValores valoresReservados) {
		Practica newPractica = new Practica(generateCodigoPractica(), nombre, grupo, horasEsperaResultado, valoresNormales, valoresCriticos, valoresReservados);
		practicas.add(newPractica);
	}
	
	public Practica getPractica(String codigoPractica) throws Exception {
		return practicas.stream()
		.filter(p -> p.getCodigo().equals(codigoPractica))
		.findFirst()
		.orElseThrow(() -> new Exception("No se ha encontrado la práctica"));
	}
	
	private String generateCodigoPractica() {
		practicasCreadas++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.PRACTICA, practicasCreadas);
	}
	
}
