package main.java.vista.paciente;

import java.awt.EventQueue;

import javax.swing.JDialog;

import main.java.controller.PacienteController;
import main.java.vista.IView;
import main.java.vista.util.ModalResult;

public class PacienteView extends IView {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacienteView window = new PacienteView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PacienteView() {
		entidadTable = new PacienteTable();
		init("Pacientes");
	}
	
	protected void agregarRegistro() {
		try {
			PacientePopup dialog = new PacientePopup(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				PacienteController.INSTANCE.createPaciente(dialog.getPaciente());
				entidadTable.agregar(dialog.getPaciente());
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	
	protected void modificarRegistro() {
		try {
			PacientePopup dialog = new PacientePopup(frame);
			int selectedRow = table.getSelectedRow();
			String pacienteCodigo = String.valueOf(entidadTable.getValueAt(selectedRow, CODIGO_COLUMN));
			dialog.setPaciente(PacienteController.INSTANCE.getPaciente(pacienteCodigo).toDto());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				PacienteController.INSTANCE.updatePaciente(dialog.getPaciente());
				entidadTable.actualizar(dialog.getPaciente(), selectedRow);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	protected void eliminarRegistro() {
		try {
			int selectedRow = table.getSelectedRow();
			String pacienteCodigo = String.valueOf(entidadTable.getValueAt(selectedRow, CODIGO_COLUMN));
			PacienteController.INSTANCE.deletePaciente(pacienteCodigo);
			entidadTable.eliminar(selectedRow);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
}
