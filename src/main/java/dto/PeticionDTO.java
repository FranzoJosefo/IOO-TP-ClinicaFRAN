package main.java.dto;

import java.util.Date;
import java.util.List;

import main.java.Interface.IDto;
import main.java.enumeration.ObraSocial;

public class PeticionDTO implements IDto {

	private String codigo;
	private String pacienteCodigo;
	private ObraSocial obraSocial;
	private Date fechaDeCarga;
	private List<EstudioDTO> estudios;
	private Date fechaDeEntrega;
	private String codigoSucursal;

	public PeticionDTO(String codigo, String pacienteCodigo, ObraSocial obraSocial, Date fechaDeCarga,
			List<EstudioDTO> estudios, Date fechaDeEntrega, String codigoSucursal) {
		this.codigo = codigo;
		this.pacienteCodigo = pacienteCodigo;
		this.obraSocial = obraSocial;
		this.fechaDeCarga = fechaDeCarga;
		this.estudios = estudios;
		this.fechaDeEntrega = fechaDeEntrega;
		this.codigoSucursal = codigoSucursal;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPacienteCodigo() {
		return pacienteCodigo;
	}

	public void setPacienteCodigo(String pacienteCodigo) {
		this.pacienteCodigo = pacienteCodigo;
	}

	public ObraSocial getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}

	public Date getFechaDeCarga() {
		return fechaDeCarga;
	}

	public void setFechaDeCarga(Date fechaDeCarga) {
		this.fechaDeCarga = fechaDeCarga;
	}

	public List<EstudioDTO> getEstudios() {
		return estudios;
	}

	public void setEstudios(List<EstudioDTO> estudios) {
		this.estudios = estudios;
	}

	public Date getFechaDeEntrega() {
		return fechaDeEntrega;
	}

	public void setFechaDeEntrega(Date fechaDeEntrega) {
		this.fechaDeEntrega = fechaDeEntrega;
	}

	public String getCodigoSucursal() {
		return codigoSucursal;
	}

	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

}
