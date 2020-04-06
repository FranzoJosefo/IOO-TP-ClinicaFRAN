package clases;

public class Paciente extends Persona {

	private Sexo sexo;
	private Edad edad;
	
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
