package main.java.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import main.java.Interface.IDto;
import main.java.dto.PeticionDTO;
import main.java.entity.Estudio;
import main.java.entity.Peticion;
import main.java.enumeration.DataFilesNames;
import main.java.enumeration.PrefijoCodigo;
import main.java.mock.EntitiesMocks;
import main.java.rest.ApiService;
import main.java.util.CodigoGenerator;

public enum PeticionController {
	
	INSTANCE;
	
	private int peticionesCreadas;
	private List<Peticion> peticiones;
	
	PeticionController() {
		peticionesCreadas = 0;
		ApiService.grabar(EntitiesMocks.getPeticionesMock(), DataFilesNames.FILE_PETICIONES.getName());
		peticiones = getPeticionesFromDataBase();
	}
	
	public Peticion getPeticion(String codigoPeticion) throws Exception {
		return peticiones.stream()
		.filter(p -> p.getCodigo().equals(codigoPeticion))
		.findFirst()
		.orElseThrow(() -> new Exception("No se ha encontrado la peticion"));
	}
	
	public void createPeticion(PeticionDTO peticionDto) {
		peticionDto.setCodigo(generateCodigoPeticion());
		Peticion newPeticion = new Peticion(peticionDto);
		peticiones.add(newPeticion);
		updatePeticionesDataBase();
	}
	
	public void updatePeticion(PeticionDTO peticionDto) throws Exception {
		Peticion existingPeticion = getPeticion(peticionDto.getCodigo());
		existingPeticion.update(peticionDto);
		updatePeticionesDataBase();
	}
	
	public void deletePeticion(String codigoPeticion) {
		peticiones.removeIf(p -> p.getCodigo().equals(codigoPeticion));
		updatePeticionesDataBase();
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
	
	private List<Peticion> getPeticionesFromDataBase() {
		List<PeticionDTO> dtos = ApiService.leer(PeticionDTO.class, DataFilesNames.FILE_PETICIONES.getName());
		return dtos.stream()
				.map(Peticion::new)
				.collect(Collectors.toList());				
	}

	private void updatePeticionesDataBase() {
		ApiService.grabar(getAllPeticionesDTO(), DataFilesNames.FILE_PETICIONES.getName());
	}
	
	public List<IDto> getAllPeticionesDTO() {
		return peticiones.stream()
				.map(Peticion::toDto)
				.collect(Collectors.toList());
	}
	
	public List<IDto> getAllEstudiosDTO(PeticionDTO peticionDto) {
		return peticionDto.getEstudios()
				.stream()
				.collect(Collectors.toList());
	}
	
	private String generateCodigoPeticion() {
		peticionesCreadas++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.PET, peticionesCreadas);
	}
	
}
