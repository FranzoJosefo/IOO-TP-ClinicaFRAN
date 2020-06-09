package entities;

import dtos.SucursalDTO;

public class Sucursal {

	private String codigo;
	private Direccion direccion;
	private String responsableCodigo;

	public Sucursal(SucursalDTO dto) {
		this.codigo = dto.getCodigo();
		this.direccion = new Direccion(dto.getDireccion());
		this.responsableCodigo = dto.getResponsableCodigo();
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

	public String getResponsable() {
		return responsableCodigo;
	}

	public void setResponsable(String responsable) {
		this.responsableCodigo = responsable;
	}

	public SucursalDTO toDTO() {
		return new SucursalDTO(codigo, direccion.toDTO(), responsableCodigo);
	}
}
