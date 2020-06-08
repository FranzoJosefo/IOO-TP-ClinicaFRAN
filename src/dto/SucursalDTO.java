package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SucursalDTO {

	private String codigo;
	private DireccionDTO direccion;
	private String responsableCodigo;
	
}
