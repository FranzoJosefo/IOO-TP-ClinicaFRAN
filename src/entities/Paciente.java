package entities;

import dto.PacienteDTO;
import enums.Sexo;

public class Paciente extends Persona {

	private String codigo;
	private Sexo sexo;
	private Edad edad;

	public Paciente(PacienteDTO pacienteDto) {
		super(pacienteDto.getNombre(), new Direccion(pacienteDto.getDireccion()), pacienteDto.getDni(),
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

	public Edad getEdad() {
		return edad;
	}

	public void setEdad(Edad edad) {
		this.edad = edad;
	}

	public PacienteDTO toDto() {
		return new PacienteDTO(this.codigo, this.sexo, this.edad, this.getNombre(), this.getDireccion().toDTO(),
				this.getDni(), this.getMail());
	}

}
