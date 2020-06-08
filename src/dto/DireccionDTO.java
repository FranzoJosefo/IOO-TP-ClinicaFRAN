package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DireccionDTO {

	private String calle;
	private int numero;
	private String localidad;
	
}
