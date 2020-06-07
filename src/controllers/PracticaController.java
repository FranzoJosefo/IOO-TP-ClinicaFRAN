package controllers;

import java.util.ArrayList;
import java.util.List;

import entities.Practica;
import entities.PracticaValores;
import enums.PracticaValoresTipo;
import enums.PrefijoCodigo;
import utils.CodigoGenerator;

public enum PracticaController {

	INSTANCE;
	
	private int practicasCreadas = 0;
	private List<Practica> practicas = new ArrayList();
	
	public void createPractica(String codigo, 
							   String nombre, 
							   String grupo, 
							   int horasEsperaResultado, 
							   boolean habilitada, 
							   PracticaValoresTipo practicaValoresTipo, 
							   Object valorNormalMin, 
							   Object valorNormalMax, 
							   Object valorCriticoMin, 
							   Object valorCriticoMax, 
							   Object valorReservadoMin, 
							   Object valorReservadoMax) {
		
		Practica newPractica = new Practica(generateCodigoPractica(), 
											nombre, 
											grupo, 
											horasEsperaResultado, 
											habilitada, 
											new PracticaValores(valorNormalMin, valorNormalMax), 
											new PracticaValores(valorCriticoMin, valorCriticoMax), 
											new PracticaValores(valorReservadoMin, valorReservadoMax));
		practicas.add(newPractica);
	}
	
	public Practica getPractica(String codigoPractica) throws Exception {
		return practicas.stream()
		.filter(p -> p.getCodigo().equals(codigoPractica))
		.findFirst()
		.orElseThrow(() -> new Exception("No se ha encontrado la practica"));
	}
	
	public boolean isPracticaHabilitada(String codigoPractica) {
		try {
		return getPractica(codigoPractica)
				.isHabilitada();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void deletePractica(String codigoPractica) throws Exception {
		if(PeticionController.INSTANCE.hasEstudiosEnProceso(codigoPractica)) {
			throw new Exception("No es posible eliminar la practica porque tiene estudios en proceso.");
		}
		practicas.removeIf(p -> p.getCodigo().equals(codigoPractica));
	}
	
	private String generateCodigoPractica() {
		practicasCreadas++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.PRACTICA, practicasCreadas);
	}
	
}
