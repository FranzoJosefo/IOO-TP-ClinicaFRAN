package main.java.vista.usuario;

import java.util.Date;

import main.java.controller.UsuarioController;
import main.java.dto.UsuarioDTO;
import main.java.vista.ITable;

public class UsuarioTable extends ITable {
	
	public UsuarioTable() {
		columnNames = new String[] { "Codigo", "Nombre de usuario", "Rol", "Apellido", "Nombre", "DNI", "Fecha de nacimiento", "Direccion", "E-Mail"}; 
		columnClasses = new Class[] { String.class, String.class, String.class, String.class, String.class, String.class, Date.class, String.class, String.class}; 
		lista = UsuarioController.INSTANCE.getAllUsuariosDTO();
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		UsuarioDTO usuarioDto = (UsuarioDTO) lista.get(rowIndex);
		switch(columnIndex) 
		{ 
			case 0: return usuarioDto.getCodigo();
			case 1: return usuarioDto.getCredentialsDto().getUsername();
			case 2: return usuarioDto.getTipoUsuario();
			case 3: return usuarioDto.getApellido();
			case 4: return usuarioDto.getNombre();
			case 5: return usuarioDto.getDni();
			case 6: return usuarioDto.getFechaNacimiento();
			case 7: return usuarioDto.getDireccion().toString();
			case 8: return usuarioDto.getMail();
			default: return null; 
		}
	}

}
