package dto;

import enums.PracticaValoresTipo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PracticaDTO {

	private String codigo;
	private String nombre;
	private String grupo;
	private int horasEsperaResultado;
	private boolean habilitada;
	private PracticaValoresTipo tipo;
	private String valorNormalMin;
	private String valorNormalMax;
	private String valorCriticoMin;
	private String valorCriticoMax;
	private String valorReservadoMin;
	private String valorReservadoMax;
	
}
