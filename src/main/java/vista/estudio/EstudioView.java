package main.java.vista.estudio;

import main.java.dto.PeticionDTO;
import main.java.vista.IView;

public class EstudioView extends IView {
	
	public EstudioView(PeticionDTO peticionDto) {
		entidadTable = new EstudioTable(peticionDto);
		init("Estudios", 400, 250);
	}
	
	protected void agregarRegistro() {
		try {
			/*
			EstudioPopup dialog = new EstudioPopup(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				PeticionController.INSTANCE.createPeticion(dialog.getPeticion());
				entidadTable.agregar(dialog.getPeticion());
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	
	protected void modificarRegistro() {
		try {
			/*
			EstudioPopup dialog = new EstudioPopup(frame);
			int selectedRow = table.getSelectedRow();
			String peticionCodigo = String.valueOf(entidadTable.getValueAt(selectedRow, CODIGO_COLUMN));
			dialog.setPeticion(PeticionController.INSTANCE.getPeticion(peticionCodigo).toDto());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				PeticionController.INSTANCE.updatePeticion(dialog.getPeticion());
				entidadTable.actualizar(dialog.getPeticion(), selectedRow);
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	protected void eliminarRegistro() {
		try {
			/*
			int selectedRow = table.getSelectedRow();
			String peticionCodigo = String.valueOf(entidadTable.getValueAt(selectedRow, CODIGO_COLUMN));
			dialog.setPeticion(PeticionController.INSTANCE.getPeticion(peticionCodigo).toDto());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			PeticionController.INSTANCE.updatePeticion(peticionCodigo);
			entidadTable.eliminar(selectedRow);
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
}
