package main.java.vista.usuario;

import java.awt.EventQueue;
import javax.swing.JDialog;

import main.java.controller.UsuarioController;
import main.java.vista.IView;
import main.java.vista.util.ModalResult;

public class UsuarioView extends IView {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioView window = new UsuarioView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public UsuarioView() {
		entidadTable = new UsuarioTable();
		init("Usuarios");
	}
	
	protected void agregarRegistro() {
		try {
			UsuarioPopup dialog = new UsuarioPopup(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				UsuarioController.INSTANCE.createUsuario(dialog.getUsuario());
				entidadTable.agregar(dialog.getUsuario());
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	
	protected void modificarRegistro() {
		try {
			UsuarioPopup dialog = new UsuarioPopup(frame);
			int selectedRow = table.getSelectedRow();
			String usuarioCodigo = String.valueOf(entidadTable.getValueAt(selectedRow, CODIGO_COLUMN));
			dialog.setUsuario(UsuarioController.INSTANCE.getUsuario(usuarioCodigo).toDto());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				UsuarioController.INSTANCE.updateUsuario(dialog.getUsuario());
				entidadTable.actualizar(dialog.getUsuario(), selectedRow);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	protected void eliminarRegistro() {
		try {
			int selectedRow = table.getSelectedRow();
			String usuarioCodigo = String.valueOf(entidadTable.getValueAt(selectedRow, CODIGO_COLUMN));
			UsuarioController.INSTANCE.deleteUsuario(usuarioCodigo);
			entidadTable.eliminar(selectedRow);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
		
}
