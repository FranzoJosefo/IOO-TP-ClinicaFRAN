package main.java.entity;

import main.java.Interface.IPracticaValores;
import main.java.dto.PracticaDTO;
import main.java.enumeration.PracticaValoresTipo;
import main.java.factory.PracticaValoresFactory;

public class Practica {

	private String codigo;
	private String nombre;
	private String grupo;
	private int horasEsperaResultado;
	private boolean habilitada;
	private PracticaValoresTipo tipo;
	private IPracticaValores valoresPosibles; 

	public Practica(PracticaDTO practicaDto) {
		this.codigo = practicaDto.getCodigo();
		this.nombre = practicaDto.getNombre();
		this.grupo = practicaDto.getGrupo();
		this.horasEsperaResultado = practicaDto.getHorasEsperaResultado();
		this.habilitada = practicaDto.isHabilitada();
		this.tipo = practicaDto.getTipo();
		this.valoresPosibles = PracticaValoresFactory.createPracticaValores(practicaDto.getTipo(), practicaDto.getValoresPosibles());
	}
	
	public void update(PracticaDTO practicaDto) {
		this.setNombre(practicaDto.getNombre());
		this.setTipo(practicaDto.getTipo());
		this.setHabilitada(practicaDto.isHabilitada());
		this.setGrupo(practicaDto.getGrupo());
		this.setHorasEsperaResultado(practicaDto.getHorasEsperaResultado());
		this.setValoresPosibles(PracticaValoresFactory.createPracticaValores(practicaDto.getTipo(), practicaDto.getValoresPosibles()));
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

	public IPracticaValores getValoresPosibles() {
		return valoresPosibles;
	}

	public void setValoresPosibles(IPracticaValores valoresPosibles) {
		this.valoresPosibles = valoresPosibles;
	}
	
	public PracticaDTO toDto() {
		return new PracticaDTO(codigo, nombre, grupo, horasEsperaResultado, habilitada, tipo, valoresPosibles.toDto());
	}
}
