package main.java.vista.paciente;

import java.text.NumberFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.NumberFormatter;

import main.java.dto.DireccionDTO;
import main.java.dto.PacienteDTO;
import main.java.enumeration.Sexo;
import main.java.vista.IPopup;

public class PacientePopup extends IPopup {
	
	private JFormattedTextField txtDNI;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JComboBox<Sexo> txtSexo;
	private JFormattedTextField txtEdad;
	private JTextField txtMail;
	private JTextField txtCalle;
	private JTextField txtNumero;
	private JTextField txtLocalidad;
	
	public PacientePopup(JFrame frame) {
		super(frame, "Paciente", 400, 370);
		setLocationRelativeTo(frame);
		inicializarControles();
	}
	
	protected void inicializarControles() {
		
		JLabel lblDni = new JLabel("DNI");
		txtDNI = new JFormattedTextField();
		txtDNI.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		txtSexo = new JComboBox<Sexo>();
		txtSexo.setModel(new DefaultComboBoxModel<Sexo>(Sexo.values()));
		
		JLabel lblEdad = new JLabel("Edad");
		NumberFormat formatEdad = NumberFormat.getInstance();
	    NumberFormatter formatterEdad = new NumberFormatter(formatEdad);
	    formatterEdad.setValueClass(Integer.class);
	    formatterEdad.setMinimum(0); 
	    formatterEdad.setMaximum(130);
	    formatterEdad.setAllowsInvalid(false);
	    formatterEdad.setCommitsOnValidEdit(true);
		txtEdad = new JFormattedTextField(formatterEdad);
		txtEdad.setColumns(10);	
		
		JLabel lblMail = new JLabel("Mail");
		txtMail = new JTextField();
		txtMail.setColumns(10);
		
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
						.addComponent(lblDni)
						.addComponent(lblApellido)
						.addComponent(lblNombre)
						.addComponent(lblSexo)
						.addComponent(lblEdad)
						.addComponent(lblMail)
						.addComponent(lblCalle)
						.addComponent(lblNumero)
						.addComponent(lblLocalidad))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSexo, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEdad, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(lblDni)
						.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellido)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSexo)
						.addComponent(txtSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEdad)
						.addComponent(txtEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMail)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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

	public PacienteDTO getPaciente() {
		return (PacienteDTO) dto;
	}
	
	public void setPaciente(PacienteDTO paciente) {
		dto = paciente;
		asignarDatosForm();
	}

	protected boolean asignarDatosEntidad() {
		try {
			checkFields();
			PacienteDTO pacienteDto = (PacienteDTO) dto;
			dto = new PacienteDTO(pacienteDto != null ? pacienteDto.getCodigo() : null, 
									   Sexo.valueOf(String.valueOf(txtSexo.getSelectedItem())), 
									   Long.valueOf(txtEdad.getText()), 
									   txtApellido.getText(), 
									   txtNombre.getText(), 
									   new DireccionDTO(txtCalle.getText(), Integer.valueOf(txtNumero.getText()), txtLocalidad.getText()), 
									   Long.valueOf(txtDNI.getText()), 
									   txtMail.getText());
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "DATOS INCORRECTOS", JOptionPane.ERROR_MESSAGE);	
		}
		return false;
	}
	
	protected void asignarDatosForm(){
		PacienteDTO pacienteDto = (PacienteDTO) dto;
		txtDNI.setText(String.valueOf(pacienteDto.getDni()));
		txtApellido.setText(pacienteDto.getApellido());
		txtNombre.setText(pacienteDto.getNombre());
		txtSexo.setToolTipText(pacienteDto.getSexo().name());
		txtEdad.setValue(pacienteDto.getEdad());
		txtMail.setText(pacienteDto.getMail());
		txtCalle.setText(pacienteDto.getDireccion().getCalle());
		txtNumero.setText(String.valueOf(pacienteDto.getDireccion().getNumero()));
		txtLocalidad.setText(pacienteDto.getDireccion().getLocalidad());
	}

	@Override
	protected void checkFields() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
