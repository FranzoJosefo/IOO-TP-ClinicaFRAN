package dto;

public class SucursalDTO {

	private String codigo;
	private DireccionDTO direccion;
	private String responsableCodigo;

	public SucursalDTO(String codigo, DireccionDTO direccion, String responsableCodigo) {
		this.codigo = codigo;
		this.direccion = direccion;
		this.responsableCodigo = responsableCodigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public DireccionDTO getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionDTO direccion) {
		this.direccion = direccion;
	}

	public String getResponsableCodigo() {
		return responsableCodigo;
	}

	public void setResponsableCodigo(String responsableCodigo) {
		this.responsableCodigo = responsableCodigo;
	}

}
