package main.java.vista.estudio;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JDialog;

import main.java.dto.EstudioDTO;
import main.java.dto.PeticionDTO;
import main.java.vista.IView;
import main.java.vista.util.ModalResult;

public class EstudioView extends IView {
		
	PeticionDTO peticionDto = null;
	
	private int PRACTICA_COLUMN = 0;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstudioView window = new EstudioView(null);
					window.setFrameVisible();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public EstudioView(PeticionDTO peticionDto) {
		entidadTable = new EstudioTable(peticionDto);
		this.peticionDto = peticionDto;
		init("Estudios", 400, 250);
		
	}
	
	protected void agregarRegistro() {
		try {
			
			EstudioPopup dialog = new EstudioPopup(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				
				if (this.peticionDto.getEstudios() == null) {
					peticionDto.setEstudios(new ArrayList<EstudioDTO>());
				}
				peticionDto.getEstudios().add(dialog.getEstudio());		
			
				entidadTable.agregar(dialog.getEstudio());
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	
	protected void modificarRegistro() {
		try {
			
			EstudioPopup dialog = new EstudioPopup(frame);
			int selectedRow = table.getSelectedRow();
			String practicaCodigo = String.valueOf(entidadTable.getValueAt(selectedRow, PRACTICA_COLUMN));
			dialog.setEstudio(peticionDto.getEstudios()
					.stream()
					.filter(estudio -> estudio.getPracticaCodigo().equals(practicaCodigo))
					.findFirst()
					.get());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK)
				peticionDto.getEstudios()
				.stream()
				.forEach(estudio -> {
					if(estudio.getPracticaCodigo().equals(dialog.getEstudio().getPracticaCodigo()))
						estudio = dialog.getEstudio();
				});

				entidadTable.actualizar(dialog.getEstudio(), selectedRow);
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	protected void eliminarRegistro() {
		try {

			int selectedRow = table.getSelectedRow();
			String practicaCodigo = String.valueOf(entidadTable.getValueAt(selectedRow, PRACTICA_COLUMN));
			peticionDto.getEstudios()
				.removeIf(estudio -> estudio.getPracticaCodigo().equals(practicaCodigo));
			entidadTable.eliminar(selectedRow);
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
}
