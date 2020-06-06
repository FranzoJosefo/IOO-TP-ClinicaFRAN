package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Direccion;
import entities.Edad;
import entities.Paciente;
import entities.Usuario;
import enums.PrefijoCodigo;
import enums.Sexo;
import enums.TipoUsuario;
import utils.CodigoGenerator;

public enum PacienteController {

	INSTANCE;
	
	private int pacientesCreados = 0;
	private List<Paciente> pacientes = new ArrayList();
	
	public void createPaciente(String codigo, String nombre, Long dni, Direccion direccion, String mail, Sexo sexo, Edad edad) {
		Paciente newPaciente = new Paciente(generateCodigoPaciente(), nombre, dni, direccion, mail, sexo, edad);
		pacientes.add(newPaciente);
	}
	
	public Paciente getPaciente(String codigoPaciente) throws Exception {
		return pacientes.stream()
		.filter(p -> p.getCodigo().equals(codigoPaciente))
		.findFirst()
		.orElseThrow(() -> new Exception("No se ha encontrado el paciente"));
	}
	
	public void deletePaciente(String codigoPaciente) throws Exception {
		if(PeticionController.INSTANCE.hasPeticionesWithEstudiosTerminados(codigoPaciente)) {
			throw new Exception("No se puede eliminar al paciente porque tiene estudios finalizados.");
		}
		pacientes.removeIf(p -> p.getCodigo().equals(codigoPaciente));
	}
	
	private String generateCodigoPaciente() {
		pacientesCreados++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.PACIENTE, pacientesCreados);
	}
	
}
