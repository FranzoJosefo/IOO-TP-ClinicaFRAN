package main.java.vista.sucursal;

import main.java.controller.SucursalController;
import main.java.dto.SucursalDTO;
import main.java.vista.ITable;

public class SucursalTable extends ITable {

	public SucursalTable() {
		columnNames = new String[] { "Codigo", "Responsable", "Direccion"}; 
		columnClasses = new Class[] { String.class, String.class, String.class}; 
		lista = SucursalController.INSTANCE.getAllSucursalesDTO();
	}
    
	public Object getValueAt(int rowIndex, int columnIndex) {
		SucursalDTO sucursalDto = (SucursalDTO) lista.get(rowIndex);
		switch(columnIndex) 
		{ 
			case 0: return sucursalDto.getCodigo(); 
			case 1: return sucursalDto.getResponsableCodigo();
			case 2: return sucursalDto.getDireccion().toString();
			default: return null; 
		}
	}

}
