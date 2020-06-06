package entidades;

import Interfaces.PracticaValores;

public class Practica {
	
	private String codigo;
	private String nombre;
	private String grupo;
	private int horasEsperaResultado;
	private PracticaValores valoresNormales;
	private PracticaValores valoresCriticos;
	private PracticaValores valoresReservados;
	
	public Practica(String codigo, String nombre, String grupo, int horasEsperaResultado, PracticaValores valoresNormales, PracticaValores valoresCriticos, PracticaValores valoresReservados) {
		setCodigo(codigo);
		setNombre(nombre);
		setGrupo(grupo);
		setHorasEsperaResultado(horasEsperaResultado);
		setValoresNormales(valoresNormales);
		setValoresCriticos(valoresCriticos);
		setValoresReservados(valoresReservados);
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
	
}
