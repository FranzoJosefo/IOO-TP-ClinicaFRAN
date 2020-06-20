package main.java.vista.paciente;

import main.java.controller.PacienteController;
import main.java.dto.PacienteDTO;
import main.java.enumeration.Sexo;
import main.java.vista.ITable;;

public class PacienteTable extends ITable {

	public PacienteTable() {
		columnNames = new String[] { "Codigo", "Apellido", "Nombre", "DNI", "Edad", "Sexo", "Direccion", "E-Mail"}; 
		columnClasses = new Class[] { String.class, String.class, String.class, Long.class, Long.class, Sexo.class, String.class, String.class}; 
		lista = PacienteController.INSTANCE.getAllPacientesDTO();
	}
    
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		PacienteDTO PacienteDto = (PacienteDTO) lista.get(rowIndex);
		switch(columnIndex) 
		{ 
			case 0: return PacienteDto.getCodigo(); 
			case 1: return PacienteDto.getApellido();
			case 2: return PacienteDto.getNombre();
			case 3: return PacienteDto.getDni();
			case 4: return PacienteDto.getEdad();
			case 5: return PacienteDto.getSexo();
			case 6: return PacienteDto.getDireccion().toString();
			case 7: return PacienteDto.getMail();
			default: return null; 
		}
	}

}
