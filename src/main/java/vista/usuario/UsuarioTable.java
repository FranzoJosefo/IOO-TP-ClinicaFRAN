package main.java.vista.usuario;

import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import main.java.controller.UsuarioController;
import main.java.dto.UsuarioDTO;

public class UsuarioTable extends AbstractTableModel{

	private static final long serialVersionUID = 1L;

	private List<UsuarioDTO> lista;
	
	protected String[] columnNames = new String[] { "Codigo", "Nombre de usuario", "Rol", "Apellido", "Nombre", "DNI", "Fecha de nacimiento", "Direccion", "E-Mail"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class, String.class, String.class, String.class, String.class, Date.class, String.class, String.class}; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public UsuarioTable() {
		lista = UsuarioController.INSTANCE.getAllUsuariosDTO();
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}
	
    @Override
    public boolean isCellEditable(int row, int column) {
    	return false;
    }
    
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) 
		{ 
			case 0: return lista.get(rowIndex).getCodigo();
			case 1: return lista.get(rowIndex).getCredentialsDto().getUsername();
			case 2: return lista.get(rowIndex).getTipoUsuario();
			case 3: return lista.get(rowIndex).getApellido();
			case 4: return lista.get(rowIndex).getNombre();
			case 5: return lista.get(rowIndex).getDni();
			case 6: return lista.get(rowIndex).getFechaNacimiento();
			case 7: return lista.get(rowIndex).getDireccion().toString();
			case 8: return lista.get(rowIndex).getMail();
			default: return null; 
		}
	}
	
	public void agregar(UsuarioDTO usuarioDto) {
		lista.add(usuarioDto);
		fireTableDataChanged();
	}
	
	public void actualizar(UsuarioDTO usuarioDto, int index) {
		lista.set(index, usuarioDto);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila) {
		lista.remove(fila);
		fireTableDataChanged();
	}
	
	public void eliminar(UsuarioDTO usuarioDto) {
		eliminar(lista.indexOf(usuarioDto));
	}	

}
