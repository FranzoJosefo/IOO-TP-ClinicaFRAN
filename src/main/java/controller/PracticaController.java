package main.java.controller;

import java.util.List;
import java.util.stream.Collectors;

import main.java.Interface.IDto;
import main.java.dto.PracticaDTO;
import main.java.entity.Practica;
import main.java.enumeration.DataFilesNames;
import main.java.enumeration.PrefijoCodigo;
import main.java.mock.EntitiesMocks;
import main.java.rest.ApiService;
import main.java.util.CodigoGenerator;

public enum PracticaController {

	INSTANCE;
	
	private int practicasCreadas;
	private List<Practica> practicas;
	
	PracticaController() {
		practicasCreadas = 0;
		ApiService.grabar(EntitiesMocks.getPracticasMock(), DataFilesNames.FILE_PRACTICAS.getName());
		practicas = getPracticasFromDataBase();
	}
	
	public Practica getPractica(String codigoPractica) throws Exception {
		return practicas.stream()
		.filter(p -> p.getCodigo().equals(codigoPractica))
		.findFirst()
		.orElseThrow(() -> new Exception("No se ha encontrado la practica"));
	}
	
	public void createPractica(PracticaDTO practicaDto) {
		practicaDto.setCodigo(generateCodigoPractica());
		Practica newPractica = new Practica(practicaDto);
		practicas.add(newPractica);
		updatePracticasDataBase();
	}
	
	public void updatePractica(PracticaDTO practicaDto) throws Exception {
		Practica existingPractica = getPractica(practicaDto.getCodigo());
		existingPractica.update(practicaDto);
		updatePracticasDataBase();
	}
	
	public void deletePractica(String codigoPractica) throws Exception {
		if(PeticionController.INSTANCE.hasEstudiosEnProceso(codigoPractica)) {
			throw new Exception("No es posible eliminar la practica porque tiene estudios en proceso.");
		}
		practicas.removeIf(p -> p.getCodigo().equals(codigoPractica));
		updatePracticasDataBase();
	}
	
	public boolean isPracticaHabilitada(String codigoPractica) {
		try {
		return getPractica(codigoPractica)
				.isHabilitada();
		} catch (Exception e) {
			return false;
		}
	}
	
	private List<Practica> getPracticasFromDataBase() {
		List<PracticaDTO> dtos = ApiService.leer(PracticaDTO.class, DataFilesNames.FILE_PRACTICAS.getName());
		return dtos.stream()
				.map(Practica::new)
				.collect(Collectors.toList());				
	}

	private void updatePracticasDataBase() {
		ApiService.grabar(getAllPracticaDTO(), DataFilesNames.FILE_PRACTICAS.getName());
	}
	
	public List<IDto> getAllPracticaDTO() {
		return practicas.stream()
				.map(Practica::toDto)
				.collect(Collectors.toList());
	}

	private String generateCodigoPractica() {
		practicasCreadas++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.PRA, practicasCreadas);
	}
	
}
