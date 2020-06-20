package main.java.dto;

import java.util.Date;

import main.java.Interface.IDto;
import main.java.enumeration.UsuarioTipo;

public class UsuarioDTO implements IDto {

	private String codigo;
	private CredentialsDTO credentials;
	private UsuarioTipo tipoUsuario;
	private Date fechaNacimiento;
	private String apellido;
	private String nombre;
	private DireccionDTO direccion;
	private Long dni;
	private String mail;

	public UsuarioDTO(String codigo, CredentialsDTO credentialsDto, UsuarioTipo tipoUsuario,
			Date fechaNacimiento, String apellido, String nombre, DireccionDTO direccion, Long dni, String mail) {
		this.codigo = codigo;
		this.credentials = credentialsDto;
		this.tipoUsuario = tipoUsuario;
		this.fechaNacimiento = fechaNacimiento;
		this.apellido = apellido;
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

	public CredentialsDTO getCredentialsDto() {
		return this.credentials;
	}

	public UsuarioTipo getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(UsuarioTipo tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
