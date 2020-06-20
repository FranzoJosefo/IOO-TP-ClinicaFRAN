package main.java.dto;

import java.util.Map;

import main.java.Interface.IDto;
import main.java.enumeration.PracticaValoresTipo;

public class PracticaDTO implements IDto {

	private String codigo;
	private String nombre;
	private String grupo;
	private int horasEsperaResultado;
	private boolean habilitada;
	private PracticaValoresTipo tipo;
	private Map<String, String> valoresPosibles;

	public PracticaDTO(String codigo, String nombre, String grupo, int horasEsperaResultado, boolean habilitada,
			PracticaValoresTipo tipo, Map<String, String> valoresPosibles) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.grupo = grupo;
		this.horasEsperaResultado = horasEsperaResultado;
		this.habilitada = habilitada;
		this.tipo = tipo;
		this.valoresPosibles = valoresPosibles;
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

	public Map<String, String> getValoresPosibles() {
		return valoresPosibles;
	}

	public void setValoresPosibles(Map<String, String> valoresPosibles) {
		this.valoresPosibles = valoresPosibles;
	}

}
