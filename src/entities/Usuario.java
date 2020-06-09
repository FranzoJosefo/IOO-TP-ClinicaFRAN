package entities;

import java.util.Date;

import dtos.UsuarioDTO;
import enums.UsuarioTipo;

public class Usuario extends Persona {

	private String codigo;
	private String nombreUsuario;
	private String password;
	private UsuarioTipo tipoUsuario;
	private Date fechaNacimiento;

	public Usuario(UsuarioDTO usuarioDto) {
		super(usuarioDto.getNombre(), new Direccion(usuarioDto.getDireccion()), usuarioDto.getDni(),
				usuarioDto.getMail());
		this.codigo = usuarioDto.getCodigo();
		this.nombreUsuario = usuarioDto.getNombreUsuario();
		this.password = usuarioDto.getPassword();
		this.tipoUsuario = usuarioDto.getTipoUsuario();
		this.fechaNacimiento = usuarioDto.getFechaNacimiento();
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

	public UsuarioTipo getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(UsuarioTipo tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public UsuarioDTO toDTO() {
		return new UsuarioDTO(codigo, nombreUsuario, password, tipoUsuario, fechaNacimiento, this.getNombre(),
				this.getDireccion().toDTO(), this.getDni(), this.getMail());
	}
}
