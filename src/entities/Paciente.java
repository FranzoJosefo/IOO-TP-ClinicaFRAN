package entities;

import enums.Sexo;

public class Paciente extends Persona {

	private String codigo;
	private Sexo sexo;
	private Edad edad;
	
	public Paciente (String codigo, String nombre, Long dni, Direccion direccion, String mail, Sexo sexo, Edad edad) {
		setCodigo(codigo);
		setNombre(nombre);
		setDni(dni);
		setDireccion(direccion);
		setMail(mail);
		setSexo(sexo);
		setEdad(edad);
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Sexo getSexo() {
		return sexo;
	}
	
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public Edad getEdad() {
		return edad;
	}
	
	public void setEdad(Edad edad) {
		this.edad = edad;
	}
	
}
