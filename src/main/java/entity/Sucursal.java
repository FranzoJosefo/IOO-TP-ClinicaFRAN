package main.java.entity;

import main.java.dto.SucursalDTO;

public class Sucursal {

	private String codigo;
	private String nombre;

	private Direccion direccion;
	private String responsableCodigo;

	public Sucursal(SucursalDTO sucursalDto) {
		this.codigo = sucursalDto.getCodigo();
		this.nombre = sucursalDto.getNombre();
		this.direccion = new Direccion(sucursalDto.getDireccion());
		this.responsableCodigo = sucursalDto.getResponsableCodigo();
	}
	
	public void update(SucursalDTO sucursalDto) {
		this.setNombre(sucursalDto.getNombre());
		this.setResponsableCodigo(sucursalDto.getResponsableCodigo());
		this.setDireccion(new Direccion(sucursalDto.getDireccion()));
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getResponsableCodigo() {
		return responsableCodigo;
	}

	public void setResponsableCodigo(String responsableCodigo) {
		this.responsableCodigo = responsableCodigo;
	}

	public SucursalDTO toDTO() {
		return new SucursalDTO(codigo, nombre, direccion.toDTO(), responsableCodigo);
	}
}
