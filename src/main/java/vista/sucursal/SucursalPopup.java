package main.java.vista.sucursal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import main.java.controller.UsuarioController;
import main.java.dto.DireccionDTO;
import main.java.dto.SucursalDTO;
import main.java.entity.Usuario;
import main.java.vista.ModalResult;
import main.java.vista.util.ComboBoxItem;

public class SucursalPopup extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JComboBox<ComboBoxItem> txtResponsable;
	private JTextField txtCalle;
	private JTextField txtNumero;
	private JTextField txtLocalidad;
	
	private SucursalDTO sucursalDto; 
	private ModalResult modalResult;
	
	private void inicializarControles() {
		
		setBounds(100, 100, 350, 250);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	
		
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
						.addComponent(lblResponsable)
						.addComponent(lblCalle)
						.addComponent(lblNumero)
						.addComponent(lblLocalidad))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
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
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						asignarDatosEntidad();
						modalResult = ModalResult.OK;
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						modalResult = ModalResult.CANCELL;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	
	public SucursalPopup(JFrame frame) {
		super(frame, "Sucursal", true);
		setLocationRelativeTo(frame);
		inicializarControles();
	}

	public SucursalDTO getSucursal() {
		return sucursalDto;
	}

	private void asignarDatosEntidad() {
		sucursalDto = new SucursalDTO(sucursalDto != null ? sucursalDto.getCodigo() : null, 
								   new DireccionDTO(txtCalle.getText(), Integer.valueOf(txtNumero.getText()), txtLocalidad.getText()),
								   ((ComboBoxItem)txtResponsable.getSelectedItem()).getKey()); 
	}
	
	private void asignarDatosForm() {
		Usuario uLab;
		try {
			uLab = UsuarioController.INSTANCE.getUsuario(sucursalDto.getResponsableCodigo());
			txtResponsable.setSelectedItem(getValueFromCombo(uLab.getCodigo()));
			txtCalle.setText(sucursalDto.getDireccion().getCalle());
			txtNumero.setText(String.valueOf(sucursalDto.getDireccion().getNumero()));
			txtLocalidad.setText(sucursalDto.getDireccion().getLocalidad());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setSucursal(SucursalDTO sucursalDto) {
		this.sucursalDto = sucursalDto;
		asignarDatosForm();
	}

	public ModalResult getModalResult() {
		return modalResult;
	}
	
	private ComboBoxItem getValueFromCombo(String codigo) {
		for (int i = 0; i < txtResponsable.getItemCount(); i++) {
			if(((ComboBoxItem)txtResponsable.getItemAt(i)).getKey().equals(codigo)) {
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
}
