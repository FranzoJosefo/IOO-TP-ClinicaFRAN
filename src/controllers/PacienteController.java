package controllers;

import java.util.ArrayList;
import java.util.List;

import data.ApiService;
import dtos.DireccionDTO;
import dtos.PacienteDTO;
import entities.Direccion;
import entities.Paciente;
import enums.PrefijoCodigo;
import utils.CodigoGenerator;

public enum PacienteController {

	INSTANCE;

	private int pacientesCreados;
	private List<Paciente> pacientes;

	PacienteController() {
		pacientesCreados = 0;
		pacientes = new ArrayList();
		fetchPacientesJson();
	}

	public void createPaciente(PacienteDTO pacienteDto) {
		pacienteDto.setCodigo(generateCodigoPaciente());
		Paciente newPaciente = new Paciente(pacienteDto);
		pacientes.add(newPaciente);
		updatePacientesJson();
	}

	private void fetchPacientesJson() {
		String file = "./pacientes.txt";
		List<PacienteDTO> dtos = ApiService.leer(PacienteDTO.class, file);
		for (PacienteDTO dto : dtos) {
			pacientes.add(new Paciente(dto));
		}
	}

	private void updatePacientesJson() {
		String file = "./pacientes.txt";
		
		ApiService.grabar(getPacientesDTO(), file);
	}

	public Paciente getPaciente(String codigoPaciente) throws Exception {
		return pacientes.stream().filter(p -> p.getCodigo().equals(codigoPaciente)).findFirst()
				.orElseThrow(() -> new Exception("No se ha encontrado el paciente"));
	}
	
	public List<PacienteDTO> getPacientesDTO() {
		List<PacienteDTO> dtos = new ArrayList<PacienteDTO>();
		for (Paciente paciente : pacientes) {
			dtos.add(paciente.toDto());
		}
		return dtos;
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
