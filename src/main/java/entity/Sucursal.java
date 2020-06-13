package main.java.entity;

import main.java.dto.SucursalDTO;

public class Sucursal {

	private String codigo;
	private Direccion direccion;
	private String responsableCodigo;

	public Sucursal(SucursalDTO sucursalDto) {
		this.codigo = sucursalDto.getCodigo();
		this.direccion = new Direccion(sucursalDto.getDireccion());
		this.responsableCodigo = sucursalDto.getResponsableCodigo();
	}
	
	public void update(SucursalDTO sucursalDto) {
		this.setResponsableCodigo(sucursalDto.getResponsableCodigo());
		this.setDireccion(new Direccion(sucursalDto.getDireccion()));
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		return new SucursalDTO(codigo, direccion.toDTO(), responsableCodigo);
	}
}
