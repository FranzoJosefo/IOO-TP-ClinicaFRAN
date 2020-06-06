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
	
	public void createPeticion(Paciente paciente, ObraSocial obraSocial, Date fechaDeCarga, List<String> estudios, Date fechaDeEntrega, String codigoSucursal) {
		Peticion newPeticion = new Peticion(generateCodigoPeticion(), paciente, obraSocial, fechaDeCarga, createEstudios(estudios), fechaDeEntrega, codigoSucursal);
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
	
	public void deletePeticion(String codigoPeticion) {
		peticiones.removeIf(p -> p.getCodigo().equals(codigoPeticion));
	}
	
	public boolean hasPeticionesWithEstudiosTerminados(String codigoPaciente) {
		return peticiones.stream()
			.filter(p -> p.getPaciente().getCodigo().equals(codigoPaciente))
			.map(Peticion::getEstudios)
			.flatMap(List::stream)
			.filter(e -> e.getResultado() != null)
			.findFirst()
			.isPresent();
	}
	
	// TODO
	private boolean isEstudioWithResultadosReservados(Estudio estudio) {
		return true;
	}
	
	public boolean hasEstudiosEnProceso(String codigoPractica) {
		return peticiones.stream()
			.map(Peticion::getEstudios)
			.flatMap(List::stream)
			.filter(e -> e.getPracticaCodigo().equals(codigoPractica))
			.findFirst()
			.isPresent();
	}
	
	public boolean hasPeticionesFinalizadas(String codigoSucursal) {
		return peticiones.stream()
			.filter(p -> p.getCodigoSucursal().equals(codigoSucursal))
			.map(Peticion::getEstudios)
			.flatMap(List::stream)
			.filter(e -> e.getResultado() != null)
			.findFirst()
			.isPresent();
	}
	
	public void migratePeticiones(String oldSucursal, String newSucursal) {
		peticiones.stream()
		.filter(p -> p.getCodigoSucursal().equals(oldSucursal))
		.forEach(p -> p.setCodigoSucursal(newSucursal));
	}
	
	// se pide listar todas las peticiones con valores criticos
	public void getAllPeticiones() {
		
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
