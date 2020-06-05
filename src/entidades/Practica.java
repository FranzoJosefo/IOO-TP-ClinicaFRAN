package entidades;

public class Practica {
	
	private String codigo;
	private String nombre;
	private String grupo;
	private String valoresCriticos;
	private String valoresReservados;
	private int horasEsperaResultados;
	
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
	public String getValoresCríticos() {
		return valoresCriticos;
	}
	public void setValoresCríticos(String valoresCríticos) {
		this.valoresCriticos = valoresCríticos;
	}
	public String getValoresReservados() {
		return valoresReservados;
	}
	public void setValoresReservados(String valoresReservados) {
		this.valoresReservados = valoresReservados;
	}
	public int getHorasEsperaResultados() {
		return horasEsperaResultados;
	}
	public void setHorasEsperaResultados(int horasEsperaResultados) {
		this.horasEsperaResultados = horasEsperaResultados;
	}
	
}
