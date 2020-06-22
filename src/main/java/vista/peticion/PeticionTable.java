package main.java.vista.peticion;

import java.util.Date;

import main.java.controller.PeticionController;
import main.java.dto.PeticionDTO;
import main.java.enumeration.ObraSocial;
import main.java.vista.ITable;

public class PeticionTable extends ITable {
	
	public PeticionTable() {
		columnNames = new String[] { "Codigo", "Paciente codigo", "Obra social", "Fecha de carga", "Fecha de entrega", "Sucursal codigo"}; 
		columnClasses = new Class[] { String.class, String.class, ObraSocial.class, Date.class, Date.class, String.class}; 
		lista = PeticionController.INSTANCE.getAllPeticionesDTO();
	}
    
	public Object getValueAt(int rowIndex, int columnIndex) {
		PeticionDTO peticionDto = (PeticionDTO) lista.get(rowIndex);
		
		switch(columnIndex) 
		{ 
			case 0: return peticionDto.getCodigo();
			case 1: return peticionDto.getPacienteCodigo();
			case 2: return peticionDto.getObraSocial();
			case 3: return peticionDto.getFechaDeCarga();
			case 4: return peticionDto.getFechaDeEntrega();
			case 5: return peticionDto.getCodigoSucursal();
			default: return null; 
		}
	}

}
