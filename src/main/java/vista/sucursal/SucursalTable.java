package main.java.vista.sucursal;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import main.java.controller.SucursalController;
import main.java.dto.SucursalDTO;


public class SucursalTable extends AbstractTableModel{

	private static final long serialVersionUID = 1L;

	private List<SucursalDTO> lista;
	
	protected String[] columnNames = new String[] { "Codigo", "Responsable", "Direccion"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class, String.class}; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public SucursalTable() {
		lista = SucursalController.INSTANCE.getAllSucursalesDTO();
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
			case 1: return lista.get(rowIndex).getResponsableCodigo();
			case 2: return lista.get(rowIndex).getDireccion().toString();
			default: return null; 
		}
	}
	
	public void agregar(SucursalDTO sucursalDto) {
		lista.add(sucursalDto);
		fireTableDataChanged();
	}
	
	public void actualizar(SucursalDTO sucursalDto, int index) {
		lista.set(index, sucursalDto);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila) {
		lista.remove(fila);
		fireTableDataChanged();
	}
	
	public void eliminar(SucursalDTO sucursalDto) {
		eliminar(lista.indexOf(sucursalDto));
	}	

}
