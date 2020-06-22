
package main.java.entity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import main.java.controller.PracticaController;
import main.java.dto.EstudioDTO;
import main.java.dto.PeticionDTO;
import main.java.dto.PracticaDTO;
import main.java.enumeration.ObraSocial;
import main.java.factory.PracticaValoresFactory;

public class Peticion {

	private String codigo;
	private String pacienteCodigo;
	private ObraSocial obraSocial;
	private Date fechaDeCarga;
	private List<Estudio> estudios;
	private Date fechaDeEntrega;
	private String sucursalCodigo;
	
	public Peticion(PeticionDTO peticionDto) {
		this.codigo = peticionDto.getCodigo();
		this.pacienteCodigo = peticionDto.getPacienteCodigo();
		this.obraSocial = peticionDto.getObraSocial();
		this.fechaDeCarga = peticionDto.getFechaDeCarga();
		this.estudios = createEstudios(peticionDto.getEstudios());
		this.fechaDeEntrega = peticionDto.getFechaDeEntrega();
		this.sucursalCodigo = peticionDto.getCodigoSucursal();
	}
	
	private List<Estudio> createEstudios(List<EstudioDTO> estudios) {
		return estudios.stream()
		.map(estudioDto -> new Estudio(estudioDto.getPracticaCodigo(), estudioDto.getResultado()))
		.collect(Collectors.toList());
	}
	
	public void update(PeticionDTO peticionDto) {
		this.setPacienteCodigo(peticionDto.getPacienteCodigo());
		this.setObraSocial(peticionDto.getObraSocial());
		this.setFechaDeCarga(peticionDto.getFechaDeCarga());
		this.setEstudios(createEstudios(peticionDto.getEstudios()));
		this.setFechaDeEntrega(peticionDto.getFechaDeEntrega());
		this.setCodigoSucursal(peticionDto.getCodigoSucursal());
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
		return sucursalCodigo;
	}

	public void setCodigoSucursal(String codigoSucursal) {
		this.sucursalCodigo = codigoSucursal;
	}
	
	public PeticionDTO toDto() {
		return new PeticionDTO(codigo, pacienteCodigo, obraSocial, fechaDeCarga, getEstudiosDTO(), fechaDeEntrega, sucursalCodigo);
	}
	
	private List<EstudioDTO> getEstudiosDTO() {
		return this.estudios.stream()
				.map(Estudio::toDTO)
				.collect(Collectors.toList());
	}

}
