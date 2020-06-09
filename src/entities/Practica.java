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
	private PracticaValores valoresNormales;
	private PracticaValores valoresCriticos;
	private PracticaValores valoresReservados;


	public Practica(PracticaDTO practicaDto) {
		this.codigo = practicaDto.getCodigo();
		this.nombre = practicaDto.getNombre();
		this.grupo = practicaDto.getGrupo();
		this.horasEsperaResultado = practicaDto.getHorasEsperaResultado();
		this.habilitada = practicaDto.isHabilitada();
		this.tipo = practicaDto.getTipo();
		this.valoresNormales = new PracticaValores(practicaDto.getValorNormalMin(), practicaDto.getValorNormalMax());
		this.valoresCriticos = new PracticaValores(practicaDto.getValorCriticoMin(), practicaDto.getValorCriticoMax());
		this.valoresReservados = new PracticaValores(practicaDto.getValorReservadoMin(),
				practicaDto.getValorReservadoMax());
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

	public PracticaValores getValoresNormales() {
		return valoresNormales;
	}

	public void setValoresNormales(PracticaValores valoresNormales) {
		this.valoresNormales = valoresNormales;
	}

	public PracticaValores getValoresCriticos() {
		return valoresCriticos;
	}

	public void setValoresCriticos(PracticaValores valoresCriticos) {
		this.valoresCriticos = valoresCriticos;
	}

	public PracticaValores getValoresReservados() {
		return valoresReservados;
	}

	public void setValoresReservados(PracticaValores valoresReservados) {
		this.valoresReservados = valoresReservados;
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
	
	public PracticaDTO toDto() {
		return new PracticaDTO(codigo, nombre, grupo, horasEsperaResultado, habilitada, tipo,
				valoresNormales.getLimites().getValue0().toString(), valoresNormales.getLimites().getValue1().toString(),
				valoresCriticos.getLimites().getValue0().toString(), valoresCriticos.getLimites().getValue1().toString(),
				valoresReservados.getLimites().getValue0().toString(), valoresReservados.getLimites().getValue1().toString());
	}
}
