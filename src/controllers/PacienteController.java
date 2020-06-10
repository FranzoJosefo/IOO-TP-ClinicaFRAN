package controllers;

import java.util.List;
import java.util.stream.Collectors;

import data.ApiService;
import dtos.DireccionDTO;
import dtos.PacienteDTO;
import entities.Direccion;
import entities.Paciente;
import enums.DataFilesNames;
import enums.PrefijoCodigo;
import utils.CodigoGenerator;

public enum PacienteController {

	INSTANCE;

	private int pacientesCreados;
	private List<Paciente> pacientes;

	PacienteController() {
		pacientesCreados = 0;
		pacientes = fetchPacientesPersistidos();
	}

	public void createPaciente(PacienteDTO pacienteDto) {
		pacienteDto.setCodigo(generateCodigoPaciente());
		Paciente newPaciente = new Paciente(pacienteDto);
		pacientes.add(newPaciente);
		updatePacientesPersistidos();
	}

	private List<Paciente> fetchPacientesPersistidos() {
		List<PacienteDTO> dtos = ApiService.leer(PacienteDTO.class, DataFilesNames.FILE_PACIENTES.getName());
		return dtos.stream().map(Paciente::new).collect(Collectors.toList());
	}

	private void updatePacientesPersistidos() {
		ApiService.grabar(getPacientesDTO(), DataFilesNames.FILE_PACIENTES.getName());
	}

	public List<PacienteDTO> getPacientesDTO() {
		return pacientes.stream().map(Paciente::toDto).collect(Collectors.toList());
	}

	public Paciente getPaciente(String codigoPaciente) throws Exception {
		return pacientes.stream().filter(p -> p.getCodigo().equals(codigoPaciente)).findFirst()
				.orElseThrow(() -> new Exception("No se ha encontrado el paciente"));
	}

	public void deletePaciente(String codigoPaciente) throws Exception {
		if (PeticionController.INSTANCE.hasPeticionesWithEstudiosTerminados(codigoPaciente)) {
			throw new Exception("No se puede eliminar al paciente porque tiene estudios finalizados.");
		}
		pacientes.removeIf(p -> p.getCodigo().equals(codigoPaciente));
	}

	public Direccion createDireccion(DireccionDTO direccionDto) {
		return new Direccion(direccionDto);
	}

	private String generateCodigoPaciente() {
		pacientesCreados++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.PACIENTE, pacientesCreados);
	}

}
