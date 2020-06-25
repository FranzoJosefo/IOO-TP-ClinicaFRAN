package main.java.vista.peticion;

import java.awt.EventQueue;
import javax.swing.JDialog;

import main.java.controller.PeticionController;
import main.java.vista.IView;
import main.java.vista.util.ModalResult;

public class PeticionView extends IView {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PeticionView window = new PeticionView();
					window.setFrameVisible();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PeticionView() {
		entidadTable = new PeticionTable();
		init("Peticiones", 1000, 350);
	}
	
//	protected void agregarRegistro() {
//		try {
//			PeticionPopup dialog = new PeticionPopup(frame);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//			if (dialog.getModalResult() == ModalResult.OK)
//				PeticionController.INSTANCE.createPeticion(dialog.getPeticion());
//				entidadTable.agregar(dialog.getPeticion());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}				
//	}
	
	protected void agregarRegistro() {
		try {
			AgregarPeticionView view = new AgregarPeticionView();
			view.setVisible(true);
					
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	
	protected void modificarRegistro() {
		try {
			PeticionPopup dialog = new PeticionPopup(frame);
			int selectedRow = table.getSelectedRow();
			String peticionCodigo = String.valueOf(entidadTable.getValueAt(selectedRow, CODIGO_COLUMN));
			dialog.setPeticion(PeticionController.INSTANCE.getPeticion(peticionCodigo).toDto());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				PeticionController.INSTANCE.updatePeticion(dialog.getPeticion());
				entidadTable.actualizar(dialog.getPeticion(), selectedRow);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	protected void eliminarRegistro() {
		try {
			int selectedRow = table.getSelectedRow();
			String peticionCodigo = String.valueOf(entidadTable.getValueAt(selectedRow, CODIGO_COLUMN));
			PeticionController.INSTANCE.deletePeticion(peticionCodigo);
			entidadTable.eliminar(selectedRow);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
}
