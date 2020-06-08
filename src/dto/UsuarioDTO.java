package dto;

import java.util.Date;

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
	private DireccionDTO direccion;
	private Long dni;
	private String mail;
	
}
