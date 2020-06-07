package dto;

import java.util.Date;

import entities.Direccion;
import entities.Edad;
import enums.Sexo;
import enums.UsuarioTipo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {

	private String codigo;
	private String nombreUsuario;
	private String password;
	private UsuarioTipo tipoUsuario;
	private Date fechaNacimiento;
	private String nombre;
	private Direccion direccion;
	private Long dni;
	private String mail;
	
}
