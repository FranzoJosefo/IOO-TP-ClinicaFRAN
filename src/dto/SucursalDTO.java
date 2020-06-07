package dto;

import entities.Direccion;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SucursalDTO {

	private String codigo;
	private Direccion direccion;
	private String responsableCodigo;
	
}
