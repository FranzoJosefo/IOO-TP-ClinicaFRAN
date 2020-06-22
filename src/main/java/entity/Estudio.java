package main.java.entity;

import main.java.controller.PracticaController;
import main.java.dto.EstudioDTO;

public class Estudio {
	
	private String practicaCodigo;
	private String resultado;
	
	public Estudio(String practicaCodigo, String resultado) {
		this.practicaCodigo = practicaCodigo;
		this.resultado = resultado;
	}
	
	public boolean checkResultadoValido(String resultado) throws Exception {
		Practica practica = PracticaController.INSTANCE.getPractica(practicaCodigo);
		return practica.getValoresPosibles()
				.isResultadoValido(resultado);
	} 
	
	// TODO
	private boolean isEstudioWithResultadosReservados(Estudio estudio) {
		return true;
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
	
	public EstudioDTO toDTO() {
		return new EstudioDTO(practicaCodigo, resultado);
	}
	
}
