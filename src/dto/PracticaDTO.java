package dto;

import enums.PracticaValoresTipo;

public class PracticaDTO {

	private String codigo;
	private String nombre;
	private String grupo;
	private int horasEsperaResultado;
	private boolean habilitada;
	private PracticaValoresTipo tipo;
	private String valorNormalMin;
	private String valorNormalMax;
	private String valorCriticoMin;
	private String valorCriticoMax;
	private String valorReservadoMin;
	private String valorReservadoMax;

	public PracticaDTO(String codigo, String nombre, String grupo, int horasEsperaResultado, boolean habilitada,
			PracticaValoresTipo tipo, String valorNormalMin, String valorNormalMax, String valorCriticoMin,
			String valorCriticoMax, String valorReservadoMin, String valorReservadoMax) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.grupo = grupo;
		this.horasEsperaResultado = horasEsperaResultado;
		this.habilitada = habilitada;
		this.tipo = tipo;
		this.valorNormalMin = valorNormalMin;
		this.valorNormalMax = valorNormalMax;
		this.valorCriticoMin = valorCriticoMin;
		this.valorCriticoMax = valorCriticoMax;
		this.valorReservadoMin = valorReservadoMin;
		this.valorReservadoMax = valorReservadoMax;
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

	public String getValorNormalMin() {
		return valorNormalMin;
	}

	public void setValorNormalMin(String valorNormalMin) {
		this.valorNormalMin = valorNormalMin;
	}

	public String getValorNormalMax() {
		return valorNormalMax;
	}

	public void setValorNormalMax(String valorNormalMax) {
		this.valorNormalMax = valorNormalMax;
	}

	public String getValorCriticoMin() {
		return valorCriticoMin;
	}

	public void setValorCriticoMin(String valorCriticoMin) {
		this.valorCriticoMin = valorCriticoMin;
	}

	public String getValorCriticoMax() {
		return valorCriticoMax;
	}

	public void setValorCriticoMax(String valorCriticoMax) {
		this.valorCriticoMax = valorCriticoMax;
	}

	public String getValorReservadoMin() {
		return valorReservadoMin;
	}

	public void setValorReservadoMin(String valorReservadoMin) {
		this.valorReservadoMin = valorReservadoMin;
	}

	public String getValorReservadoMax() {
		return valorReservadoMax;
	}

	public void setValorReservadoMax(String valorReservadoMax) {
		this.valorReservadoMax = valorReservadoMax;
	}

}
