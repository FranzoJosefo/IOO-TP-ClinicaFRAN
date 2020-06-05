package entidades;

import Interfaces.Resultado;

public class Estudio {
	
	private Practica practica;
	private Resultado resultado;
	
	public Practica getPractica() {
		return practica;
	}
	public void setPractica(Practica practica) {
		this.practica = practica;
	}
	public Resultado getResultado() {
		return resultado;
	}
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
}
