package main.java.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import main.java.dto.PeticionDTO;
import main.java.entity.Estudio;
import main.java.entity.Peticion;
import main.java.enumeration.PrefijoCodigo;
import main.java.util.CodigoGenerator;

public enum PeticionController {
	
	INSTANCE;
	
	private int peticionesCreadas;
	private List<Peticion> peticiones;
	
	PeticionController() {
		peticionesCreadas = 0;
		peticiones = new ArrayList();
	}
	
	public void createPeticion(PeticionDTO peticionDto) {
		peticionDto.setCodigo(generateCodigoPeticion());
		Peticion newPeticion = new Peticion(peticionDto);
		peticiones.add(newPeticion);
	}
	
	public Peticion getPeticion(String codigoPeticion) throws Exception {
		return peticiones.stream()
		.filter(p -> p.getCodigo().equals(codigoPeticion))
		.findFirst()
		.orElseThrow(() -> new Exception("No se ha encontrado la peticion"));
	}
	
	public void cargarResultado(String codigoPeticion, String codigoPractica, String resultado) throws Exception {
		Optional<Estudio> estudio = getPeticion(codigoPeticion)
				.getEstudios()
				.stream()
				.filter(e -> codigoPractica.equals(e.getPracticaCodigo()))
				.findFirst();

		if(!estudio.isPresent()) {
			throw new Exception("No se ha encontrado el estudio asociado a dicha practica.");
		} else if (!estudio.get().checkResultadoValido(resultado)) {
			throw new Exception("Se ha cargado un resultado invalido.");
		} else {
			estudio.get().setResultado(resultado);
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
	
	private String generateCodigoPeticion() {
		peticionesCreadas++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.PETICION, peticionesCreadas);
	}
	
}
