package entidades;

public class Sucursal {
	
	private String codigo;
	private Direccion direccion;
	private Usuario responsable;
	
	public Sucursal(String codigo, Direccion direccion, Usuario responsable) {
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
	public Usuario getResponsable() {
		return responsable;
	}
	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}
	
}
