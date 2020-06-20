package main.java.vista.sucursal;

import java.awt.EventQueue;

import javax.swing.JDialog;

import main.java.controller.SucursalController;
import main.java.vista.IView;
import main.java.vista.util.ModalResult;

public class SucursalView extends IView {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SucursalView window = new SucursalView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public SucursalView() {
		entidadTable = new SucursalTable();
		init("Sucursales");
	}
	
	protected void agregarRegistro() {
		try {
			SucursalPopup dialog = new SucursalPopup(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				SucursalController.INSTANCE.createSucursal(dialog.getSucursal());
				entidadTable.agregar(dialog.getSucursal());
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	
	protected void modificarRegistro() {
		try {
			SucursalPopup dialog = new SucursalPopup(frame);
			int selectedRow = table.getSelectedRow();
			String sucursalCodigo = String.valueOf(entidadTable.getValueAt(selectedRow, CODIGO_COLUMN));
			dialog.setSucursal(SucursalController.INSTANCE.getSucursal(sucursalCodigo).toDTO());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				SucursalController.INSTANCE.updateSucursal(dialog.getSucursal());
				entidadTable.actualizar(dialog.getSucursal(), selectedRow);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	protected void eliminarRegistro() {
		try {
			int selectedRow = table.getSelectedRow();
			String sucursalCodigo = String.valueOf(entidadTable.getValueAt(selectedRow, CODIGO_COLUMN));
			SucursalController.INSTANCE.deleteSucursal(sucursalCodigo);
			entidadTable.eliminar(selectedRow);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
}
