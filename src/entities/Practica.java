package entities;

import Interfaces.PracticaValores;
import dto.PracticaDTO;
import enums.PracticaValoresTipo;

public class Practica {
	
	private String codigo;
	private String nombre;
	private String grupo;
	private int horasEsperaResultado;
	private boolean habilitada;
	private PracticaValoresTipo tipo;
	private PracticaValores valoresPosibles; 
	
	public Practica(PracticaDTO practicaDto) {
		this.codigo = practicaDto.getCodigo();
		this.nombre = practicaDto.getNombre();
		this.grupo = practicaDto.getGrupo();
		this.horasEsperaResultado = practicaDto.getHorasEsperaResultado();
		this.habilitada = practicaDto.isHabilitada();
		this.tipo = practicaDto.getTipo();
		

	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public int getHorasEsperaResultado() {
		return horasEsperaResultado;
	}
	public void setHorasEsperaResultado(int horasEsperaResultado) {
		this.horasEsperaResultado = horasEsperaResultado;
	}
	public boolean isHabilitada() {
		return habilitada;
	}

	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}
	public PracticaValoresTipo getTipo() {
		return tipo;
	}

	public void setTipo(PracticaValoresTipo tipo) {
		this.tipo = tipo;
	}

	public PracticaValores getValoresPosibles() {
		return valoresPosibles;
	}

	public void setValoresPosibles(PracticaValores valoresPosibles) {
		this.valoresPosibles = valoresPosibles;
	}
	
}
