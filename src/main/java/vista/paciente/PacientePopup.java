package main.java.vista.paciente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import main.java.dto.DireccionDTO;
import main.java.dto.PacienteDTO;
import main.java.enumeration.Sexo;
import main.java.vista.ModalResult;

public class PacientePopup extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JFormattedTextField txtDNI;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JComboBox<Sexo> txtSexo;
	private JFormattedTextField txtEdad;
	private JTextField txtMail;
	private JTextField txtCalle;
	private JTextField txtNumero;
	private JTextField txtLocalidad;
	
	private PacienteDTO paciente; 
	private ModalResult modalResult;
	
	private void inicializarControles() {
		
		setBounds(100, 100, 400, 370);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	
		
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
		//txtSexo.
		
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
	
	public PacientePopup(JFrame frame) {
		super(frame, "Paciente", true);
		setLocationRelativeTo(frame);
		inicializarControles();
	}

	public PacienteDTO getPaciente() {
		return paciente;
	}

	private void asignarDatosEntidad() {
		paciente = new PacienteDTO(paciente != null ? paciente.getCodigo() : null, 
								   Sexo.valueOf(String.valueOf(txtSexo.getSelectedItem())), 
								   Long.valueOf(txtEdad.getText()), 
								   txtApellido.getText(), 
								   txtNombre.getText(), 
								   new DireccionDTO(txtCalle.getText(), Integer.valueOf(txtNumero.getText()), txtLocalidad.getText()), 
								   Long.valueOf(txtDNI.getText()), 
								   txtMail.getText());
	}
	
	private void asignarDatosForm(){
		txtDNI.setText(String.valueOf(paciente.getDni()));
		txtApellido.setText(paciente.getApellido());
		txtNombre.setText(paciente.getNombre());
		txtSexo.setToolTipText(paciente.getSexo().name());
		txtEdad.setValue(paciente.getEdad());
		txtMail.setText(paciente.getMail());
		txtCalle.setText(paciente.getDireccion().getCalle());
		txtNumero.setText(String.valueOf(paciente.getDireccion().getNumero()));
		txtLocalidad.setText(paciente.getDireccion().getLocalidad());
	}
	
	public void setPaciente(PacienteDTO paciente) {
		this.paciente = paciente;
		asignarDatosForm();
	}

	public ModalResult getModalResult() {
		return modalResult;
	}
}
