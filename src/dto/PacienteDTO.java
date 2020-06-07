package dto;

import entities.Direccion;
import entities.Edad;
import enums.Sexo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PacienteDTO {

	private String codigo;
	private Sexo sexo;
	private Edad edad;
	private String nombre;
	private Direccion direccion;
	private Long dni;
	private String mail;
	
}
