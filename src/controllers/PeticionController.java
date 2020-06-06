package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Interfaces.Resultado;
import entities.Estudio;
import entities.Paciente;
import entities.Peticion;
import enums.ObraSocial;
import enums.PrefijoCodigo;
import utils.CodigoGenerator;

public enum PeticionController {
	
	INSTANCE;
	
	private int peticionesCreadas = 0;
	private List<Peticion> peticiones = new ArrayList();
	
	public void createPeticion(Paciente paciente, ObraSocial obraSocial, Date fechaDeCarga, List<String> estudios, Date fechaDeEntrega) {
		Peticion newPeticion = new Peticion(generateCodigoPeticion(), paciente, obraSocial, fechaDeCarga, createEstudios(estudios), fechaDeEntrega);
		peticiones.add(newPeticion);
	}
	
	public Peticion getPeticion(String codigoPeticion) throws Exception {
		return peticiones.stream()
		.filter(p -> p.getCodigo().equals(codigoPeticion))
		.findFirst()
		.orElseThrow(() -> new Exception("No se ha encontrado la petición"));
	}
	
	public void cargarResultado(String codigoPeticion, String codigoPractica, Resultado resultado) throws Exception {
		Optional<Estudio> estudio = getPeticion(codigoPeticion)
				.getEstudios()
				.stream()
				.filter(e -> codigoPractica.equals(e.getPracticaCodigo()))
				.findFirst();

		if(estudio.isPresent()) {
			estudio.get().setResultado(resultado);
		} else {
			throw new Exception("No se ha encontrado el estudio asociado a dicha práctica");
		}
	}
	
	private List<Estudio> createEstudios(List<String> estudios) {
		return estudios.stream()
		.filter(PracticaController.INSTANCE::isPracticaHabilitada)
		.map(Estudio::new)
		.collect(Collectors.toList());
	}
	
	private String generateCodigoPeticion() {
		peticionesCreadas++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.PETICION, peticionesCreadas);
	}
	
}
