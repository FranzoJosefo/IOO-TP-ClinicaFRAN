package main.java.controller;

import java.util.List;
import java.util.stream.Collectors;

import main.java.Interface.IDto;
import main.java.dto.PacienteDTO;
import main.java.entity.Paciente;
import main.java.enumeration.DataFilesNames;
import main.java.enumeration.PrefijoCodigo;
import main.java.mock.EntitiesMocks;
import main.java.rest.ApiService;
import main.java.util.CodigoGenerator;

public enum PacienteController {

	INSTANCE;

	private int pacientesCreados;
	private List<Paciente> pacientes;

	PacienteController() {
		pacientesCreados = 0;
		ApiService.grabar(EntitiesMocks.getPacientesMock(), DataFilesNames.FILE_PACIENTES.getName());
		pacientes = getAllPacientesFromDataBase();
	}
	
	public Paciente getPaciente(String codigoPaciente) throws Exception {
		return pacientes.stream()
				.filter(p -> p.getCodigo().equals(codigoPaciente))
				.findFirst()
				.orElseThrow(() -> new Exception("No se ha encontrado el paciente"));
	}

	public void createPaciente(PacienteDTO pacienteDto) {
		pacienteDto.setCodigo(generateCodigoPaciente());
		Paciente newPaciente = new Paciente(pacienteDto);
		pacientes.add(newPaciente);
		updatePacientesDataBase();
	}
	
	public void updatePaciente(PacienteDTO pacienteDto) throws Exception {
		Paciente existingPaciente = getPaciente(pacienteDto.getCodigo());
		existingPaciente.update(pacienteDto);
		updatePacientesDataBase();
	}
	
	public void deletePaciente(String codigoPaciente) throws Exception {
		if (PeticionController.INSTANCE.hasPeticionesWithEstudiosTerminados(codigoPaciente)) {
			throw new Exception("No se puede eliminar al paciente porque tiene estudios finalizados.");
		}
		pacientes.removeIf(p -> p.getCodigo().equals(codigoPaciente));
		updatePacientesDataBase();
	}
	
	public List<IDto> getAllPacientesDTO() {
		return pacientes.stream()
				.map(Paciente::toDto)
				.collect(Collectors.toList());
	}

	private List<Paciente> getAllPacientesFromDataBase() {
		List<PacienteDTO> dtos = ApiService.leer(PacienteDTO.class, DataFilesNames.FILE_PACIENTES.getName());
		return dtos.stream()
				.map(Paciente::new)
				.collect(Collectors.toList());
	}

	private void updatePacientesDataBase() {
		ApiService.grabar(getAllPacientesDTO(), DataFilesNames.FILE_PACIENTES.getName());
	}
	
	private String generateCodigoPaciente() {
		pacientesCreados++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.PAC, pacientesCreados);
	}

}
