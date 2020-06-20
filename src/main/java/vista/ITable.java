package main.java.vista;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import main.java.Interface.IDto;

public abstract class ITable extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	protected List<IDto> lista;
	
	protected String[] columnNames;
	protected Class[] columnClasses; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	
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
	public abstract Object getValueAt(int rowIndex, int columnIndex);
	
	public void agregar(IDto dto) {
		lista.add(dto);
		fireTableDataChanged();
	}
	
	public void actualizar(IDto dto, int index) {
		lista.set(index, dto);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila) {
		lista.remove(fila);
		fireTableDataChanged();
	}
	
	public void eliminar(IDto dto) {
		eliminar(lista.indexOf(dto));
	}	

}
