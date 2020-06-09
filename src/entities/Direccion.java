package entities;

import dtos.DireccionDTO;

public class Direccion {

	private String calle;
	private int numero;
	private String localidad;
	
	public Direccion(DireccionDTO direccionDTO) {
		this.calle = direccionDTO.getCalle();
		this.numero = direccionDTO.getNumero();
		this.localidad = direccionDTO.getLocalidad();
	}

	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public DireccionDTO toDTO() {
		return new DireccionDTO(this.calle, this.numero, this.localidad);
	}
	
}
