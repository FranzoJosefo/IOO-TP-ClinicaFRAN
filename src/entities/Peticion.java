
package entities;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import controllers.PracticaController;
import dtos.PeticionDTO;
import enums.ObraSocial;

public class Peticion {

	private String codigo;
	private String pacienteCodigo;
	private ObraSocial obraSocial;
	private Date fechaDeCarga;
	private List<Estudio> estudios;
	private Date fechaDeEntrega;
	private String codigoSucursal;
	
	public Peticion(PeticionDTO peticionDto) {
		this.codigo = peticionDto.getCodigo();
		this.pacienteCodigo = peticionDto.getPacienteCodigo();
		this.obraSocial = peticionDto.getObraSocial();
		this.fechaDeCarga = peticionDto.getFechaDeCarga();
		this.estudios = createEstudios(peticionDto.getPracticaCodigos());
		this.fechaDeEntrega = peticionDto.getFechaDeEntrega();
		this.codigoSucursal = peticionDto.getCodigoSucursal();
	}
	
	// Ver que pasa si alguna practica no existe o está deshabilitada, si se lo informamos al usuario
	private List<Estudio> createEstudios(List<String> codigosPracticas) {
		return codigosPracticas.stream()
		.filter(PracticaController.INSTANCE::isPracticaHabilitada)
		.map(Estudio::new)
		.collect(Collectors.toList());
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
	public void setPacienteCodigo(String paciente) {
		this.pacienteCodigo = paciente;
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
	public List<Estudio> getEstudios() {
		return estudios;
	}
	public void setEstudios(List<Estudio> estudios) {
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
