package entidades;

import java.util.Date;
import java.util.List;

public class Peticion {

	private String codigo;
	private Paciente paciente;
	private ObraSocial obraSocial;
	private Date FechaDeCarga;
	private List<Estudio> Estudios;
	private Date FechaDeEntrega;
	
	
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
		return FechaDeCarga;
	}
	public void setFechaDeCarga(Date fechaDeCarga) {
		FechaDeCarga = fechaDeCarga;
	}
	public List<Estudio> getEstudios() {
		return Estudios;
	}

	public void setEstudios(List<Estudio> estudios) {
		Estudios = estudios;
	}
	public Date getFechaDeEntrega() {
		return FechaDeEntrega;
	}
	public void setFechaDeEntrega(Date fechaDeEntrega) {
		FechaDeEntrega = fechaDeEntrega;
	}

}
