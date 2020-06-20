package main.java.vista.practica;

import main.java.controller.PracticaController;
import main.java.dto.PracticaDTO;
import main.java.enumeration.PracticaValores;
import main.java.vista.ITable;

public class PracticaTable extends ITable {
	
	public PracticaTable() {
		columnNames = new String[] { "Codigo", "Practica", "Grupo", "Horas de espera", "Habilitada", "Valores normales", "Valores criticos", "Valores reservados"}; 
		columnClasses = new Class[] { String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}; 
		lista = PracticaController.INSTANCE.getAllPracticaDTO();
	}
    
	public Object getValueAt(int rowIndex, int columnIndex) {
		PracticaDTO practicaDto = (PracticaDTO) lista.get(rowIndex);
		switch(columnIndex) 
		{ 
			case 0: return practicaDto.getCodigo();
			case 1: return practicaDto.getNombre();
			case 2: return practicaDto.getGrupo();
			case 3: return practicaDto.getHorasEsperaResultado();
			case 4: return practicaDto.isHabilitada();
			case 5: return practicaDto.getValoresPosibles().get(PracticaValores.NORMALES.name()).toString();
			case 6: return practicaDto.getValoresPosibles().get(PracticaValores.CRITICOS.name()).toString();
			case 7: return practicaDto.getValoresPosibles().get(PracticaValores.RESERVADOS.name()).toString();
			default: return null; 
		}
	}

}
