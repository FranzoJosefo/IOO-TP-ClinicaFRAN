package main.java.vista.sucursal;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.java.controller.UsuarioController;
import main.java.dto.DireccionDTO;
import main.java.dto.SucursalDTO;
import main.java.entity.Usuario;
import main.java.vista.IPopup;
import main.java.vista.util.ComboBoxItem;

public class SucursalPopup extends IPopup {
	
	private JTextField txtNombre;
	private JComboBox<ComboBoxItem> txtResponsable;
	private JTextField txtCalle;
	private JTextField txtNumero;
	private JTextField txtLocalidad;
	
	public SucursalPopup(JFrame frame) {
		super(frame, "Sucursal", 350, 250);
		setLocationRelativeTo(frame);
		inicializarControles();
	}
	
	protected void inicializarControles() {	
		
		JLabel lblNombre = new JLabel("Nombre");
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblResponsable = new JLabel("Responsable");
		txtResponsable = buildLaboratoristasComboBox();
		
		JLabel lblCalle = new JLabel("Calle");
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		txtLocalidad = new JTextField();
		txtLocalidad.setColumns(10);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre)
						.addComponent(lblResponsable)
						.addComponent(lblCalle)
						.addComponent(lblNumero)
						.addComponent(lblLocalidad))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtResponsable, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCalle, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLocalidad, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(108, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblResponsable)
						.addComponent(txtResponsable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCalle)
						.addComponent(txtCalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)						
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumero)
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)	
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocalidad)
						.addComponent(txtLocalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)						
					.addContainerGap(60, Short.MAX_VALUE))
		);
		
		contentPanel.setLayout(gl_contentPanel);
		
	}
	
	public SucursalDTO getSucursal() {
		return (SucursalDTO) dto;
	}
	
	public void setSucursal(SucursalDTO sucursalDto) {
		dto = sucursalDto;
		asignarDatosForm();
	}

	protected boolean asignarDatosEntidad() {
		try {
			checkFields();
			SucursalDTO sucursalDto = (SucursalDTO) dto;
			dto = new SucursalDTO(sucursalDto != null ? sucursalDto.getCodigo() : null,
									   txtNombre.getText(),
									   new DireccionDTO(txtCalle.getText(), Integer.valueOf(txtNumero.getText()), txtLocalidad.getText()),
									   ((ComboBoxItem)txtResponsable.getSelectedItem()).getKey()); 
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "DATOS INCORRECTOS", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	protected void asignarDatosForm() {
		Usuario uLab;
		try {
			SucursalDTO sucursalDto = (SucursalDTO) dto;
			uLab = UsuarioController.INSTANCE.getUsuario(sucursalDto.getResponsableCodigo());
			txtNombre.setText(sucursalDto.getNombre());
			txtResponsable.setSelectedItem(getValueFromCombo(uLab.getCodigo()));
			txtCalle.setText(sucursalDto.getDireccion().getCalle());
			txtNumero.setText(String.valueOf(sucursalDto.getDireccion().getNumero()));
			txtLocalidad.setText(sucursalDto.getDireccion().getLocalidad());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private ComboBoxItem getValueFromCombo(String codigo) {
		for (int i = 0; i < txtResponsable.getItemCount(); i++) {
			if(txtResponsable.getItemAt(i).getKey().equals(codigo)) {
				return txtResponsable.getItemAt(i);
			}
		}
		return null;
	}
	
	private JComboBox<ComboBoxItem> buildLaboratoristasComboBox() {
		JComboBox<ComboBoxItem> txtCombo = new JComboBox<ComboBoxItem>();
		UsuarioController.INSTANCE.getLaboratoristasDTO()
				.stream()
				.map(uLab -> new ComboBoxItem(String.format("%s %s", uLab.getApellido(), uLab.getNombre()), uLab.getCodigo()))
				.forEach(comboItem -> txtCombo.addItem(comboItem));
		return txtCombo;		
	}

	protected void checkFields() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
