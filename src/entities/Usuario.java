package entities;

import java.util.Date;

import enums.TipoUsuario;

public class Usuario extends Persona {

	private String codigo;
	private String nombreUsuario;
	private String password;
	private TipoUsuario tipoUsuario;
	private Date fechaNacimiento;
	
	public Usuario (String codigo, String nombreUsuario, String password, TipoUsuario tipoUsuario, Date fechaNacimiento, String nombre, Long dni, Direccion direccion, String mail) {
		setCodigo(codigo);
		setNombreUsuario(nombreUsuario);
		setPassword(password);
		setTipoUsuario(tipoUsuario);
		setFechaNacimiento(fechaNacimiento);
		setNombre(nombre);
		setDni(dni);
		setDireccion(direccion);
		setMail(mail);
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
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
