package entities;

import java.util.Date;
import java.util.List;

import enums.ObraSocial;

public class Peticion {

	private String codigo;
	private Paciente paciente;
	private ObraSocial obraSocial;
	private Date fechaDeCarga;
	private List<Estudio> estudios;
	private Date fechaDeEntrega;
	
	public Peticion(String codigo, Paciente paciente, ObraSocial obraSocial, Date fechaDeCarga, List<Estudio> estudios, Date fechaDeEntrega) {
		setCodigo(codigo);
		setPaciente(paciente);
		setObraSocial(obraSocial);
		setFechaDeCarga(fechaDeCarga);
		setEstudios(estudios);
		setFechaDeEntrega(fechaDeEntrega);
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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

}
