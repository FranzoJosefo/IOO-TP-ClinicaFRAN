package main.java.vista.estudio;

import java.util.ArrayList;

import main.java.Interface.IDto;
import main.java.controller.PeticionController;
import main.java.controller.PracticaController;
import main.java.dto.EstudioDTO;
import main.java.dto.PeticionDTO;
import main.java.vista.ITable;

public class EstudioTable extends ITable {
	
	public EstudioTable(PeticionDTO peticionDto) {
		columnNames = new String[] { "Practica", "Resultado"}; 
		columnClasses = new Class[] { String.class, String.class}; 
		lista = peticionDto != null ? PeticionController.INSTANCE.getAllEstudiosDTO(peticionDto) : new ArrayList<IDto>();
	}
    
	public Object getValueAt(int rowIndex, int columnIndex) {
		EstudioDTO estudioDto = (EstudioDTO) lista.get(rowIndex);
		String practicaNombre = "";
		
		try {
			practicaNombre = PracticaController.INSTANCE.getPractica(estudioDto.getPracticaCodigo()).getNombre();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		switch(columnIndex) 
		{ 
			case 0: return practicaNombre;
			case 1: return estudioDto.getResultado();
			default: return null; 
		}
	}

}
