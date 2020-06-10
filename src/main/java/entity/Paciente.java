package main.java.entity;

import main.java.dto.PacienteDTO;
import main.java.enumeration.Sexo;

public class Paciente extends Persona {

	private String codigo;
	private Sexo sexo;
	private Long edad;

	public Paciente(PacienteDTO pacienteDto) {
		super(pacienteDto.getApellido(), pacienteDto.getNombre(), new Direccion(pacienteDto.getDireccion()), pacienteDto.getDni(),
				pacienteDto.getMail());
		this.codigo = pacienteDto.getCodigo();
		this.sexo = pacienteDto.getSexo();
		this.edad = pacienteDto.getEdad();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	public PacienteDTO toDto() {
		return new PacienteDTO(this.codigo, this.sexo, this.edad, this.getApellido(), this.getNombre(), this.getDireccion().toDTO(),
				this.getDni(), this.getMail());
	}

}
