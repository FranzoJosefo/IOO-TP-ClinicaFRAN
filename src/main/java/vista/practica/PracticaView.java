package main.java.vista.practica;

import java.awt.EventQueue;
import javax.swing.JDialog;

import main.java.controller.PracticaController;
import main.java.vista.IView;
import main.java.vista.util.ModalResult;

public class PracticaView extends IView {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PracticaView window = new PracticaView();
					window.setFrameVisible();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PracticaView() {
		entidadTable = new PracticaTable();
		init("Practicas", 1000, 350);
	}
	
	protected void agregarRegistro() {
		try {
			PracticaPopup dialog = new PracticaPopup(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				PracticaController.INSTANCE.createPractica(dialog.getPractica());
				entidadTable.agregar(dialog.getPractica());
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	
	protected void modificarRegistro() {
		try {
			PracticaPopup dialog = new PracticaPopup(frame);
			int selectedRow = table.getSelectedRow();
			String practicaCodigo = String.valueOf(entidadTable.getValueAt(selectedRow, CODIGO_COLUMN));
			dialog.setPractica(PracticaController.INSTANCE.getPractica(practicaCodigo).toDto());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				PracticaController.INSTANCE.updatePractica(dialog.getPractica());
				entidadTable.actualizar(dialog.getPractica(), selectedRow);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	protected void eliminarRegistro() {
		try {
			int selectedRow = table.getSelectedRow();
			String practicaCodigo = String.valueOf(entidadTable.getValueAt(selectedRow, CODIGO_COLUMN));
			PracticaController.INSTANCE.deletePractica(practicaCodigo);
			entidadTable.eliminar(selectedRow);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
}
