package main.java.vista.peticion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePickerImpl;

import main.java.Interface.IDto;
import main.java.controller.PacienteController;
import main.java.controller.PeticionController;
import main.java.controller.SucursalController;
import main.java.dto.EstudioDTO;
import main.java.dto.PacienteDTO;
import main.java.dto.PeticionDTO;
import main.java.dto.PracticaDTO;
import main.java.dto.SucursalDTO;
import main.java.enumeration.ObraSocial;
import main.java.util.DateUtil;
import main.java.vista.estudio.EstudioView;
import main.java.vista.util.ComboBoxItem;
import main.java.vista.util.DatePicker;

public class AgregarPeticionView extends JFrame {

	private JPanel contentPane;
	private JComboBox<ComboBoxItem> comboBoxPaciente;
	private JComboBox<ComboBoxItem> comboBoxSucursal;
	private JComboBox<ObraSocial> comboBoxObraSocial;
	private JDatePickerImpl dateFechaCarga;
	private JDatePickerImpl dateFechaEntrega;
	private JButton estudiosButton;
	private EstudioView estudioView;
	private JButton crearPeticionButton;
	protected IDto dto = null; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarPeticionView frame = new AgregarPeticionView();
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
	public AgregarPeticionView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblPaciente = new JLabel("Paciente");
		comboBoxPaciente = buildPacienteComboBox();
		
		JLabel lblSucursal = new JLabel("Sucursal");
		comboBoxSucursal = buildSucursalComboBox();
		
		JLabel lblObraSocial = new JLabel("Obra social");
		comboBoxObraSocial = new JComboBox<ObraSocial>();	
		comboBoxObraSocial.setModel(new DefaultComboBoxModel<ObraSocial>(ObraSocial.values()));
		
		JLabel lblFechaCarga = new JLabel("Fecha carga");
		dateFechaCarga = DatePicker.INSTANCE.getDatePicker();	
		
		JLabel lblFechaEntrega = new JLabel("Fecha entrega");
		dateFechaEntrega =  DatePicker.INSTANCE.getDatePicker();		
		
		estudiosButton = new JButton("Ir a Estudios");
		estudiosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(asignarDatosEntidad()) {
					estudioView = new EstudioView((PeticionDTO) dto);	
					estudioView.setFrameVisible();
				} else {
					//TODO show error
				}
			}
		});

		
		GroupLayout gl_contentPanel = new GroupLayout(contentPane);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPaciente)
						.addComponent(lblObraSocial)
						.addComponent(lblSucursal)
						.addComponent(lblFechaCarga)
						.addComponent(lblFechaEntrega))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxObraSocial)
						.addComponent(comboBoxPaciente)
						.addComponent(comboBoxSucursal)
						.addComponent(dateFechaCarga)
						.addComponent(dateFechaEntrega)
						.addComponent(estudiosButton)))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxPaciente, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPaciente))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxObraSocial, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblObraSocial))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxSucursal, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSucursal))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(dateFechaCarga, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaCarga))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(dateFechaEntrega, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaEntrega))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(estudiosButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
		);
		
		contentPane.setLayout(gl_contentPanel);		
		
	}
	

	public PeticionDTO getPeticion() {
		return (PeticionDTO) dto;
	}

	public void setPeticion(PeticionDTO peticionDto) {
		dto = peticionDto;
		asignarDatosForm();
	}
	
	protected boolean asignarDatosEntidad() {
		try {
			checkFields();
			PeticionDTO peticionDto = (PeticionDTO) dto;
			List<EstudioDTO> estudios = null;
			dto = new PeticionDTO(peticionDto!=null?peticionDto.getCodigo():null,
					comboBoxPaciente.getSelectedItem().toString(), 
					(ObraSocial)comboBoxObraSocial.getSelectedItem(), 
					(Date)dateFechaCarga.getModel().getValue(), 
					estudios, 
					(Date)dateFechaEntrega.getModel().getValue(), 
					comboBoxSucursal.getSelectedItem().toString());
			return true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage(), "DATOS INCORRECTOS", JOptionPane.ERROR_MESSAGE);	
		}
		return false;
	}
	
	protected void asignarDatosForm(){
		PeticionDTO peticionDto = (PeticionDTO) dto;	
		comboBoxPaciente.setSelectedItem(getValueFromCombo(peticionDto.getPacienteCodigo(), comboBoxPaciente));
		comboBoxSucursal.setSelectedItem(getValueFromCombo(peticionDto.getCodigoSucursal(), comboBoxSucursal));
		comboBoxObraSocial.setSelectedItem(peticionDto.getObraSocial()); // ver diferencia con pacientePopup con sexo
		dateFechaCarga.getJFormattedTextField().setText(DateUtil.getDateFormat().format(peticionDto.getFechaDeCarga()));
		dateFechaEntrega.getJFormattedTextField().setText(DateUtil.getDateFormat().format(peticionDto.getFechaDeEntrega()));
		//((EstudioTable)tableEstudios.getModel()).fill(peticionDto);
	}
	
	protected void checkFields() throws Exception {
		
	}
	
	private ComboBoxItem getValueFromCombo(String codigo, JComboBox<ComboBoxItem> combo) {
		for (int i = 0; i < combo.getItemCount(); i++) {
			if(combo.getItemAt(i).getKey().equals(codigo)) {
				return combo.getItemAt(i);
			}
		}
		return null;
	}
	
	private JComboBox<ComboBoxItem> buildPacienteComboBox() {
		JComboBox<ComboBoxItem> comboBox = new JComboBox<ComboBoxItem>();
		PacienteController.INSTANCE.getAllPacientesDTO()
				.stream()
				.map(dto -> ((PacienteDTO)dto))
				.map(pacienteDto -> new ComboBoxItem(String.valueOf(pacienteDto.getDni()), pacienteDto.getCodigo()))
				.forEach(comboItem -> comboBox.addItem(comboItem));
		return comboBox;		
	}
	
	private JComboBox<ComboBoxItem> buildSucursalComboBox() {
		JComboBox<ComboBoxItem> comboBox = new JComboBox<ComboBoxItem>();
		SucursalController.INSTANCE.getAllSucursalesDTO()
				.stream()
				.map(dto -> ((SucursalDTO)dto))
				.map(sucursalDto -> new ComboBoxItem(sucursalDto.getNombre(), sucursalDto.getCodigo()))
				.forEach(comboItem -> comboBox.addItem(comboItem));
		return comboBox;		
	}
	
	

}
