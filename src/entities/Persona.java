package entities;

public abstract class Persona {

	private String apellido;
	private String nombre;
	private Direccion direccion;
	private Long dni;
	private String mail;
	
	public Persona(String apellido, String nombre, Direccion direccion, Long dni, String mail) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.mail = mail;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}
	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public Long getDni() {
		return dni;
	}
	
	public void setDni(Long dni) {
		this.dni = dni;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}
