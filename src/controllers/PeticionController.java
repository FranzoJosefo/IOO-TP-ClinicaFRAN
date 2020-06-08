package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Interfaces.Resultado;
import dto.PeticionDTO;
import entities.Estudio;
import entities.Paciente;
import entities.Peticion;
import entities.Practica;
import enums.ObraSocial;
import enums.PrefijoCodigo;
import utils.CodigoGenerator;

public enum PeticionController {
	
	INSTANCE;
	
	private int peticionesCreadas = 0;
	private List<Peticion> peticiones = new ArrayList();
	
	public void createPeticion(PeticionDTO peticionDto) {
		Peticion newPeticion = new Peticion(generateCodigoPeticion(), 
											peticionDto.getPacienteCodigo(), 
											peticionDto.getObraSocial(), 
											peticionDto.getFechaDeCarga(),
											createEstudios(peticionDto.getPracticaCodigos()), 
											peticionDto.getFechaDeEntrega(), 
											peticionDto.getCodigoSucursal());
		peticiones.add(newPeticion);
	}
	
	public Peticion getPeticion(String codigoPeticion) throws Exception {
		return peticiones.stream()
		.filter(p -> p.getCodigo().equals(codigoPeticion))
		.findFirst()
		.orElseThrow(() -> new Exception("No se ha encontrado la peticion"));
	}
	
	public void cargarResultado(String codigoPeticion, String codigoPractica, Resultado resultado) throws Exception {
		Optional<Estudio> estudio = getPeticion(codigoPeticion)
				.getEstudios()
				.stream()
				.filter(e -> codigoPractica.equals(e.getPracticaCodigo()))
				.findFirst();

		if(estudio.isPresent() && checkResultadoValido(estudio, resultado)) {
			estudio.get().setResultado(resultado);
		} else {
			throw new Exception("No se ha encontrado el estudio asociado a dicha practica");
		}
	}
	
	public void deletePeticion(String codigoPeticion) {
		peticiones.removeIf(p -> p.getCodigo().equals(codigoPeticion));
	}
	
	public boolean hasPeticionesWithEstudiosTerminados(String codigoPaciente) {
		return peticiones.stream()
			.filter(p -> p.getPacienteCodigo().equals(codigoPaciente))
			.map(Peticion::getEstudios)
			.flatMap(List::stream)
			.filter(e -> e.getResultado() != null)
			.findFirst()
			.isPresent();
	}
	
	public boolean checkResultadoValido(Estudio estudio, Resultado resultado) {
		Practica practica = PracticaController.INSTANCE.getPractica(estudio.getPracticaCodigo());
		
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
