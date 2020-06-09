package dtos;

import java.util.Date;

import enums.UsuarioTipo;

public class UsuarioDTO {

	private String codigo;
	private String nombreUsuario;
	private String password;
	private UsuarioTipo tipoUsuario;
	private Date fechaNacimiento;
	private String nombre;
	private DireccionDTO direccion;
	private Long dni;
	private String mail;

	public UsuarioDTO(String codigo, String nombreUsuario, String password, UsuarioTipo tipoUsuario,
			Date fechaNacimiento, String nombre, DireccionDTO direccion, Long dni, String mail) {
		this.codigo = codigo;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
		this.fechaNacimiento = fechaNacimiento;
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

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
