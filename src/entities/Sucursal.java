package entities;

public class Sucursal {
	
	private String codigo;
	private Direccion direccion;
	private String responsable;
	
	public Sucursal(String codigo, Direccion direccion, String responsable) {
		setCodigo(codigo);
		setDireccion(direccion);
		setResponsable(responsable);
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
}
