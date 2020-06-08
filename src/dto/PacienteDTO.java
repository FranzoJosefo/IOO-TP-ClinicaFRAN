package dto;

import entities.Edad;
import enums.Sexo;

public class PacienteDTO {

	private String codigo;
	private Sexo sexo;
	private Edad edad;
	private String nombre;
	private DireccionDTO direccion;
	private Long dni;
	private String mail;

	public PacienteDTO(String codigo, Sexo sexo, Edad edad, String nombre, DireccionDTO direccion, Long dni,
			String mail) {
		super();
		this.codigo = codigo;
		this.sexo = sexo;
		this.edad = edad;
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.mail = mail;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DireccionDTO getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionDTO direccion) {
		this.direccion = direccion;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
