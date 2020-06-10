package main.java.vista.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import main.java.controller.LoginController;
import main.java.controller.OnLoginCallback;
import main.java.dto.CredentialsDTO;
import main.java.enumeration.UsuarioTipo;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuarioField;
	private JPasswordField passwordField;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginController.INSTANCE.login(new CredentialsDTO(usuarioField.getText(), passwordField.getText()),
						new OnLoginCallback() {

							@Override
							public void onLoginSuccess(UsuarioTipo usuarioTipo) {
								setVisible(false);
//								
							}

							@Override
							public void onLoginFailure() {
								// TODO generar dialog y mostrar error
							}

						});
			}
		});

		passwordField = new JPasswordField();
		passwordField.setToolTipText("contraseña");

		usuarioField = new JTextField();
		usuarioField.setForeground(Color.BLACK);
		usuarioField.setToolTipText("Usuario");
		usuarioField.setBackground(Color.WHITE);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(146)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(usuarioField, GroupLayout.DEFAULT_SIZE, 145,
														Short.MAX_VALUE)
												.addComponent(passwordField)))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(176).addComponent(btnLogin,
										GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(149, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addGap(85)
								.addComponent(usuarioField, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE).addGap(18)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addGap(27).addComponent(btnLogin).addGap(66)));
		contentPane.setLayout(gl_contentPane);
	}
	
}
