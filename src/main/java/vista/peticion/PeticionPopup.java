package main.java.vista.peticion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdatepicker.impl.JDatePickerImpl;

import main.java.controller.PacienteController;
import main.java.controller.SucursalController;
import main.java.dto.PacienteDTO;
import main.java.dto.PeticionDTO;
import main.java.dto.SucursalDTO;
import main.java.enumeration.ObraSocial;
import main.java.util.DateUtil;
import main.java.vista.IPopup;
import main.java.vista.estudio.EstudioView;
import main.java.vista.util.ComboBoxItem;
import main.java.vista.util.DatePicker;

public class PeticionPopup extends IPopup {
	
	private JComboBox<ComboBoxItem> comboBoxPaciente;
	private JComboBox<ComboBoxItem> comboBoxSucursal;
	private JComboBox<ObraSocial> comboBoxObraSocial;
	private JDatePickerImpl dateFechaCarga;
	private JDatePickerImpl dateFechaEntrega;
	private JButton estudiosButton;
	private EstudioView estudioView;
	
	public PeticionPopup(JFrame frame) {
		super(frame, "Peticion", 300, 300);
		setLocationRelativeTo(frame);
	}
	
	protected void inicializarControles() {
				
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
		
		estudiosButton = new JButton("Estudios");
		estudiosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estudioView = new EstudioView((PeticionDTO) dto);	
				estudioView.setFrameVisible();
			}
		});

		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
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
		
		contentPanel.setLayout(gl_contentPanel);		
		
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
			PeticionDTO PeticionDto = (PeticionDTO) dto;
			/*dto = new PracticaDTO(practicaDto != null ? PeticionDto.getCodigo() : null, 
									   txtNombre.getText(),
									   txtGrupo.getText(), 
									   Integer.parseInt(intHorasEspera.getText()),
							   		   checkBoxHabilitada.isSelected(),
									   PracticaValoresTipo.valueOf(String.valueOf(comboBoxTipo.getSelectedItem())), */
							   		   //buildValoresMap());
			return true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "DATOS INCORRECTOS", JOptionPane.ERROR_MESSAGE);	
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
