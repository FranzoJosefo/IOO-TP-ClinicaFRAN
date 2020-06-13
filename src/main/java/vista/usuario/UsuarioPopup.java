package main.java.vista.usuario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import main.java.dto.CredentialsDTO;
import main.java.dto.DireccionDTO;
import main.java.dto.UsuarioDTO;
import main.java.enumeration.UsuarioTipo;
import main.java.vista.ModalResult;

public class UsuarioPopup extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtNombreUsuario;
	//private JTextField txtPassword;
	private JPasswordField txtPassword;
	private JComboBox<UsuarioTipo> txtTipo;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JFormattedTextField txtDNI;
	private JFormattedTextField txtFechaNacimiento;
	private JTextField txtMail;
	private JTextField txtCalle;
	private JTextField txtNumero;
	private JTextField txtLocalidad;
	
	private UsuarioDTO usuarioDto; 
	private ModalResult modalResult;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private void inicializarControles() {
		
		setBounds(100, 100, 450, 450);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	
		JLabel lblNombreUsuario = new JLabel("Nombre usuario");
		txtNombreUsuario = new JFormattedTextField();
		txtNombreUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contraseña");
		txtPassword = new JPasswordField();
		txtPassword.setEchoChar('*');
		txtPassword.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		txtDNI = new JFormattedTextField();
		txtDNI.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		txtTipo = new JComboBox<UsuarioTipo>();
		txtTipo.setModel(new DefaultComboBoxModel<UsuarioTipo>(UsuarioTipo.values()));
		
		JLabel lblFechaNac = new JLabel("Fecha de nacimiento");
	    DateFormatter formatterFechaNac = new DateFormatter(dateFormat);
	    formatterFechaNac.setValueClass(Date.class);
	    formatterFechaNac.setAllowsInvalid(false);
	    formatterFechaNac.setCommitsOnValidEdit(true);
	    txtFechaNacimiento = new JFormattedTextField(formatterFechaNac);
	    txtFechaNacimiento.setColumns(10);	
		
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
						.addComponent(lblNombreUsuario)
						.addComponent(lblPassword)
						.addComponent(lblTipo)
						.addComponent(lblApellido)
						.addComponent(lblNombre)
						.addComponent(lblDni)
						.addComponent(lblFechaNac)
						.addComponent(lblMail)
						.addComponent(lblCalle)
						.addComponent(lblNumero)
						.addComponent(lblLocalidad))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNombreUsuario, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTipo, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFechaNacimiento, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
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
							.addComponent(lblNombreUsuario)
							.addComponent(txtNombreUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPassword)
							.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTipo)
							.addComponent(txtTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
							.addComponent(lblDni)
							.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)	
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaNac)
						.addComponent(txtFechaNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
	
	public UsuarioPopup(JFrame frame) {
		super(frame, "Usuario", true);
		setLocationRelativeTo(frame);
		inicializarControles();
	}

	public UsuarioDTO getUsuario() {
		return usuarioDto;
	}

	private void asignarDatosEntidad() {
		try {
			usuarioDto = new UsuarioDTO(usuarioDto != null ? usuarioDto.getCodigo() : null, 
									   new CredentialsDTO(txtNombreUsuario.getText(), txtPassword.getText()),
									   UsuarioTipo.valueOf(String.valueOf(txtTipo.getSelectedItem())), 
									   dateFormat.parse(txtFechaNacimiento.getText()), 
									   txtApellido.getText(), 
									   txtNombre.getText(), 
									   new DireccionDTO(txtCalle.getText(), Integer.valueOf(txtNumero.getText()), txtLocalidad.getText()), 
									   Long.valueOf(txtDNI.getText()), 
									   txtMail.getText());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void asignarDatosForm(){
		txtNombreUsuario.setText(String.valueOf(usuarioDto.getCredentialsDto().getUsername()));
		txtPassword.setText(String.valueOf(usuarioDto.getCredentialsDto().getPassword()));
		txtTipo.setToolTipText(usuarioDto.getTipoUsuario().name());
		txtApellido.setText(usuarioDto.getApellido());
		txtNombre.setText(usuarioDto.getNombre());
		txtDNI.setText(String.valueOf(usuarioDto.getDni()));
		txtFechaNacimiento.setValue(usuarioDto.getFechaNacimiento());
		txtMail.setText(usuarioDto.getMail());
		txtCalle.setText(usuarioDto.getDireccion().getCalle());
		txtNumero.setText(String.valueOf(usuarioDto.getDireccion().getNumero()));
		txtLocalidad.setText(usuarioDto.getDireccion().getLocalidad());
	}
	
	public void setUsuario(UsuarioDTO usuarioDto) {
		this.usuarioDto = usuarioDto;
		asignarDatosForm();
	}

	public ModalResult getModalResult() {
		return modalResult;
	}
}
