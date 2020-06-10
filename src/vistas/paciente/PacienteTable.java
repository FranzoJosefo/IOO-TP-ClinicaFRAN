package vistas.paciente;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import controllers.PacienteController;
import dtos.PacienteDTO;
import enums.Sexo;;

public class PacienteTable extends AbstractTableModel{

	private static final long serialVersionUID = 1L;

	private List<PacienteDTO> lista;
	
	protected String[] columnNames = new String[] { "Codigo", "Apellido", "Nombre", "DNI", "Edad", "Sexo", "Direccion", "E-Mail"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class, String.class, Long.class, Long.class, Sexo.class, String.class, String.class}; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public PacienteTable() {
		lista = PacienteController.INSTANCE.getPacientesDTO();
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
			case 1: return lista.get(rowIndex).getApellido();
			case 2: return lista.get(rowIndex).getNombre();
			case 3: return lista.get(rowIndex).getDni();
			case 4: return lista.get(rowIndex).getEdad();
			case 5: return lista.get(rowIndex).getSexo();
			case 6: return lista.get(rowIndex).getDireccion();
			case 7: return lista.get(rowIndex).getMail();
			default: return null; 
		}
	}
	
	public void agregar(PacienteDTO paciente) {
		lista.add(paciente);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila) {
		lista.remove(fila);
		fireTableDataChanged();
	}
	
	public void eliminar(PacienteDTO paciente) {
		eliminar(lista.indexOf(paciente));
	}	

}
