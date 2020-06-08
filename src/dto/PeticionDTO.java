package dto;

import java.util.Date;
import java.util.List;

import enums.ObraSocial;

public class PeticionDTO {

	private String codigo;
	private String pacienteCodigo;
	private ObraSocial obraSocial;
	private Date fechaDeCarga;
	private List<String> practicaCodigos;
	private Date fechaDeEntrega;
	private String codigoSucursal;

	public PeticionDTO(String codigo, String pacienteCodigo, ObraSocial obraSocial, Date fechaDeCarga,
			List<String> practicaCodigos, Date fechaDeEntrega, String codigoSucursal) {
		super();
		this.codigo = codigo;
		this.pacienteCodigo = pacienteCodigo;
		this.obraSocial = obraSocial;
		this.fechaDeCarga = fechaDeCarga;
		this.practicaCodigos = practicaCodigos;
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

	public List<String> getPracticaCodigos() {
		return practicaCodigos;
	}

	public void setPracticaCodigos(List<String> practicaCodigos) {
		this.practicaCodigos = practicaCodigos;
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
