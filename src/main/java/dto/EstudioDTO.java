package main.java.dto;

import main.java.Interface.IDto;

public class EstudioDTO implements IDto {

	private String practicaCodigo;
	private String resultado;
	
	public EstudioDTO(String practicaCodigo, String resultado) {
		this.practicaCodigo = practicaCodigo;
		this.resultado = resultado;
	}
	
	public String getPracticaCodigo() {
		return practicaCodigo;
	}
	
	public void setPracticaCodigo(String practicaCodigo) {
		this.practicaCodigo = practicaCodigo;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
