package main.java.vista.home;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.java.controller.LoginController;
import main.java.enumeration.UsuarioTipo;
import main.java.vista.paciente.PacienteView;
import main.java.vista.peticion.PeticionView;
import main.java.vista.practica.PracticaView;
import main.java.vista.sucursal.SucursalView;
import main.java.vista.usuario.UsuarioView;

import java.awt.GridLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class HomeView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView frame = new HomeView();
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
	public HomeView() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3, 12, 12));

		switch(LoginController.INSTANCE.getCurrentUserDTO().getTipoUsuario()) {
		case ADMINISTRADOR : 
			addPacientesBtn();
			addPracticasBtn();
			addPeticionesBtn();
			addSucursalesBtn();
			addUsuariosBtn();
			break;
		case LABORATORISTA:
			addPeticionesBtn();
			break;
		case RECEPCIONISTA:
			addPacientesBtn();
			addPeticionesBtn();
		}
	}

	private void addUsuariosBtn() {
		Button usuariosBtn = new Button("Usuarios");
		usuariosBtn.setFont(UIManager.getFont("Button.font"));
		usuariosBtn.setBackground(Color.DARK_GRAY);
		usuariosBtn.setForeground(Color.LIGHT_GRAY);
		usuariosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsuarioView usuarioView = new UsuarioView();
				usuarioView.setFrameVisible();
			}
		});
		contentPane.add(usuariosBtn);
	}

	private void addSucursalesBtn() {
		Button sucursalesBtn = new Button("Sucursales");
		sucursalesBtn.setFont(UIManager.getFont("Button.font"));
		sucursalesBtn.setBackground(Color.DARK_GRAY);
		sucursalesBtn.setForeground(Color.LIGHT_GRAY);
		sucursalesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SucursalView sucursalView = new SucursalView();
				sucursalView.setFrameVisible();
			}
		});
		contentPane.add(sucursalesBtn);
	}

	private void addResultadosBtn() {
		Button resultadosBtn = new Button("Resultados de Estudios");
		resultadosBtn.setFont(UIManager.getFont("Button.font"));
		resultadosBtn.setBackground(Color.DARK_GRAY);
		resultadosBtn.setForeground(Color.LIGHT_GRAY);
		resultadosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		contentPane.add(resultadosBtn);
	}

	private void addPeticionesBtn() {
		Button peticionesBtn = new Button("Peticiones de Estudios");
		peticionesBtn.setFont(UIManager.getFont("Button.font"));
		peticionesBtn.setForeground(Color.LIGHT_GRAY);
		peticionesBtn.setBackground(Color.DARK_GRAY);
		peticionesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PeticionView peticionView = new PeticionView();
				peticionView.setFrameVisible();
			}
		});
		contentPane.add(peticionesBtn);
	}

	private void addPracticasBtn() {
		Button practicasBtn = new Button("Practicas");
		practicasBtn.setFont(UIManager.getFont("Button.font"));
		practicasBtn.setBackground(Color.DARK_GRAY);
		practicasBtn.setForeground(Color.LIGHT_GRAY);
		practicasBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PracticaView practicaView = new PracticaView();
				practicaView.setFrameVisible();
			}
		});
		contentPane.add(practicasBtn);
	}

	private void addPacientesBtn() {
		Button pacientesBtn = new Button("Pacientes");
		pacientesBtn.setFont(UIManager.getFont("Button.font"));
		pacientesBtn.setBackground(Color.DARK_GRAY);
		pacientesBtn.setForeground(Color.LIGHT_GRAY);
		pacientesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PacienteView pacienteView = new PacienteView();
				pacienteView.setFrameVisible();
			}
		});
		contentPane.add(pacientesBtn);
	}

}
