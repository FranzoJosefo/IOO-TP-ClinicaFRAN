package dto;

import java.util.Date;
import java.util.List;

import enums.ObraSocial;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PeticionDTO {

	private String codigo;
	private String pacienteCodigo;
	private ObraSocial obraSocial;
	private Date fechaDeCarga;
	private List<String> practicaCodigos;
	private Date fechaDeEntrega;
	private String codigoSucursal;
	
}
