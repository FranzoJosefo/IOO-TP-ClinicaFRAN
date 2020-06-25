package main.java.vista.estudio;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.java.controller.PracticaController;
import main.java.dto.EstudioDTO;
import main.java.dto.PracticaDTO;
import main.java.entity.Practica;
import main.java.entity.Usuario;
import main.java.vista.IPopup;
import main.java.vista.util.ComboBoxItem;

public class EstudioPopup extends IPopup {
	
	private JComboBox<ComboBoxItem> comboBoxPractica;
	private JTextField txtResultado;

	public EstudioPopup(JFrame frame) {
		super(frame, "Sucursal", 200, 150);
		setLocationRelativeTo(frame);
		inicializarControles();
	}

	protected void inicializarControles() {

		JLabel lblComboBoxPractica = new JLabel("Practica");
		comboBoxPractica = buildPracticaComboBox();
		
		JLabel lblResultado = new JLabel("Resultado");
		txtResultado = new JTextField();
		txtResultado.setColumns(10);

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);	
		
			gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblComboBoxPractica)
							.addComponent(lblResultado))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(comboBoxPractica)
							.addComponent(txtResultado)))
			);
			gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBoxPractica, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblComboBoxPractica))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtResultado, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblResultado))
						.addPreferredGap(ComponentPlacement.RELATED))
			);

		contentPanel.setLayout(gl_contentPanel);

	}

	public EstudioDTO getEstudio() {
		return (EstudioDTO) dto;
	}

	public void setEstudio(EstudioDTO estudioDto) {
		dto = estudioDto;
		asignarDatosForm();
	}

	protected boolean asignarDatosEntidad() {
		try {
			checkFields();
			dto = new EstudioDTO(((ComboBoxItem) comboBoxPractica.getSelectedItem()).getKey(), txtResultado.getText());
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "DATOS INCORRECTOS", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}

	protected void asignarDatosForm() {
		Usuario uLab;
		try {
			EstudioDTO estudioDto = (EstudioDTO) dto;
			txtResultado.setText(estudioDto.getResultado());
			comboBoxPractica.setSelectedItem(getValueFromCombo(estudioDto.getPracticaCodigo()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ComboBoxItem getValueFromCombo(String codigo) {
		for (int i = 0; i < comboBoxPractica.getItemCount(); i++) {
			if (comboBoxPractica.getItemAt(i).getKey().equals(codigo)) {
				return comboBoxPractica.getItemAt(i);
			}
		}
		return null;
	}

	private JComboBox<ComboBoxItem> buildPracticaComboBox() {
		JComboBox<ComboBoxItem> txtCombo = new JComboBox<ComboBoxItem>();
		PracticaController.INSTANCE.getAllPracticaDTO()
				.stream()
				.map(dto -> ((PracticaDTO)dto))
				.map(practicaDto -> new ComboBoxItem(practicaDto.getNombre(), practicaDto.getCodigo()))
				.forEach(comboItem -> txtCombo.addItem(comboItem));
		return txtCombo;
	}

	protected void checkFields() throws Exception {
		
		Practica practica = PracticaController.INSTANCE.getPractica(((ComboBoxItem) comboBoxPractica.getSelectedItem()).getKey());
		if (practica.getValoresPosibles().isResultadoValido(txtResultado.getText())) {
			throw new Exception("El resultado no se encuentra dentro de los valores posibles para dicha practica.");
		}

	}

}
