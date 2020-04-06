package clases;

import java.util.Date;
import java.util.List;

public class Peticion {

	private Paciente paciente;
	private ObraSocial obraSocial;
	private Date FechaDeCarga;
	private List<Practica> practicas;
	private Date FechaDeEntrega;
	
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
		return FechaDeCarga;
	}
	public void setFechaDeCarga(Date fechaDeCarga) {
		FechaDeCarga = fechaDeCarga;
	}
	public List<Practica> getPracticas() {
		return practicas;
	}
	public void setPracticas(List<Practica> practicas) {
		this.practicas = practicas;
	}
	public Date getFechaDeEntrega() {
		return FechaDeEntrega;
	}
	public void setFechaDeEntrega(Date fechaDeEntrega) {
		FechaDeEntrega = fechaDeEntrega;
	}
	
}
