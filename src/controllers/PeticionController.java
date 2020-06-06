package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import Interfaces.Resultado;
import entidades.Estudio;
import entidades.Paciente;
import entidades.Peticion;
import enums.ObraSocial;
import enums.PrefijoCodigo;
import utils.CodigoGenerator;

public enum PeticionController {
	
	INSTANCE;
	
	private int peticionesCreadas = 0;
	private List<Peticion> peticiones = new ArrayList();
	
	public void createPeticion(Paciente paciente, ObraSocial obraSocial, Date fechaDeCarga, List<Estudio> estudios, Date fechaDeEntrega) {
		Peticion newPeticion = new Peticion(generateCodigoPeticion(), paciente, obraSocial, fechaDeCarga, estudios, fechaDeEntrega);
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
	
	private String generateCodigoPeticion() {
		peticionesCreadas++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.PETICION, peticionesCreadas);
	}
	
}
