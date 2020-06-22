package main.java.dto;

import main.java.Interface.IDto;

public class SucursalDTO implements IDto {

	private String codigo;
	private String nombre;
	private DireccionDTO direccion;
	private String responsableCodigo;

	public SucursalDTO(String codigo, String nombre, DireccionDTO direccion, String responsableCodigo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.responsableCodigo = responsableCodigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public DireccionDTO getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionDTO direccion) {
		this.direccion = direccion;
	}

	public String getResponsableCodigo() {
		return responsableCodigo;
	}

	public void setResponsableCodigo(String responsableCodigo) {
		this.responsableCodigo = responsableCodigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
