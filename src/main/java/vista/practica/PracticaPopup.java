package main.java.vista.practica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.NumberFormatter;

import main.java.dto.PracticaDTO;
import main.java.enumeration.PracticaValores;
import main.java.enumeration.PracticaValoresTipo;
import main.java.vista.IPopup;

public class PracticaPopup extends IPopup {
	
	private JComboBox<PracticaValoresTipo> comboBoxTipo;
	private JCheckBox checkBoxHabilitada;
	private JTextField txtValorNormal;
	private JTextField txtValorCritico;
	private JTextField txtValorReservado;
	private JTextField intValorNormalMax;
	private JTextField intValorNormalMin;
	private JTextField intValorCriticoMin;
	private JTextField intValorCriticoMax;
	private JTextField intValorReservadoMin;
	private JTextField intValorReservadoMax;
	private JTextField txtNombre;
	private JTextField txtGrupo;
	private JTextField intHorasEspera;
	private JLabel lblConfiguracionValores;
	private JLabel lblColumnValoresMinimos;
	private JLabel lblColumnValoresMaximos;
	
	public PracticaPopup(JFrame frame) {
		super(frame, "Practica", 400, 350);
		setLocationRelativeTo(frame);
	}
	
	protected void inicializarControles() {
				
		NumberFormat formatInt = NumberFormat.getInstance();
	    NumberFormatter formatterInt = new NumberFormatter(formatInt);
	    formatterInt.setValueClass(Integer.class);
	    formatterInt.setMinimum(0); 
	    formatterInt.setMaximum(500);
	    formatterInt.setAllowsInvalid(false);
	    formatterInt.setCommitsOnValidEdit(true);
				
		checkBoxHabilitada = new JCheckBox("Habilitada");
	    
		JLabel lblNombre = new JLabel("Nombre*");
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblGrupo = new JLabel("Grupo");
		txtGrupo = new JTextField();
		txtGrupo.setColumns(10);
		
		JLabel lblHorasEspera = new JLabel("Horas espera*");
		intHorasEspera = new JFormattedTextField(formatterInt);
		intHorasEspera.setColumns(10);
	    
		JLabel lblTipo = new JLabel("Tipo");		
		comboBoxTipo = new JComboBox<PracticaValoresTipo>();
		comboBoxTipo.setModel(new DefaultComboBoxModel<PracticaValoresTipo>(PracticaValoresTipo.values()));
		
		lblConfiguracionValores = new JLabel("Configuraci\u00F3n de valores");
		lblConfiguracionValores.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblColumnValoresMinimos = new JLabel("minimo");
		lblColumnValoresMaximos = new JLabel("maximo");
		
		JLabel lblValoresNormales = new JLabel("Valores normales");
		txtValorNormal = new JTextField();
		txtValorNormal.setColumns(10);
		intValorNormalMin = new JFormattedTextField(formatterInt);
		intValorNormalMin.setColumns(10);
		intValorNormalMax = new JFormattedTextField(formatterInt);
		intValorNormalMax.setColumns(10);
		
		JLabel lblValoresCriticos = new JLabel("Valores criticos");
		txtValorCritico = new JTextField();
		txtValorCritico.setColumns(10);
		intValorCriticoMin = new JFormattedTextField(formatterInt);
		intValorCriticoMin.setColumns(10);
		intValorCriticoMax = new JFormattedTextField(formatterInt);
		intValorCriticoMax.setColumns(10);
		
		JLabel lblValoresReservados = new JLabel("Valores reservados");		
		txtValorReservado = new JTextField();
		txtValorReservado.setColumns(10);
		intValorReservadoMin = new JFormattedTextField(formatterInt);
		intValorReservadoMin.setColumns(10);
		intValorReservadoMax = new JFormattedTextField(formatterInt);
		intValorReservadoMax.setColumns(10);
					
    	lblColumnValoresMinimos.setVisible(false);
    	lblColumnValoresMaximos.setVisible(false);
    	intValorNormalMin.setVisible(false);
    	intValorNormalMax.setVisible(false);
    	intValorCriticoMin.setVisible(false);
    	intValorCriticoMax.setVisible(false);
    	intValorReservadoMin.setVisible(false);
    	intValorReservadoMax.setVisible(false);
	   
	    comboBoxTipo.addActionListener(
				 new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                String tipoPractica = (String) String.valueOf(comboBoxTipo.getSelectedItem());
		                switch (tipoPractica) {
		                    case "WORD":		               
		                    	txtValorNormal.setEditable(true);
		                    	txtValorCritico.setEditable(true);
		                    	txtValorReservado.setEditable(true);
		                    	lblColumnValoresMinimos.setVisible(false);
		                    	lblColumnValoresMaximos.setVisible(false);
		                    	intValorNormalMin.setVisible(false);
		                    	intValorNormalMax.setVisible(false);
		                    	intValorCriticoMin.setVisible(false);
		                    	intValorCriticoMax.setVisible(false);
		                    	intValorReservadoMin.setVisible(false);
		                    	intValorReservadoMax.setVisible(false);
		                    	intValorNormalMin.setText("");
		                    	intValorNormalMax.setText("");
		                    	intValorCriticoMin.setText("");
		                    	intValorCriticoMax.setText("");
		                    	intValorReservadoMin.setText("");
		                    	intValorReservadoMax.setText("");
		                        break;
		                    case "RANGE":
		                    	txtValorNormal.setEditable(false);
		                    	txtValorCritico.setEditable(false);
		                    	txtValorReservado.setEditable(false);
		                    	txtValorNormal.setText("");
		                    	txtValorCritico.setText("");
		                    	txtValorReservado.setText("");
		                    	lblColumnValoresMinimos.setVisible(true);
		                    	lblColumnValoresMaximos.setVisible(true);
		                    	intValorNormalMin.setVisible(true);
		                    	intValorNormalMax.setVisible(true);
		                    	intValorCriticoMin.setVisible(true);
		                    	intValorCriticoMax.setVisible(true);
		                    	intValorReservadoMin.setVisible(true);
		                    	intValorReservadoMax.setVisible(true);
		                    	break;
		                    default:
		                        break;
		                }
		            }
		        }					
		);

		GroupLayout groupLayout = new GroupLayout(contentPanel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblConfiguracionValores)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHorasEspera)
								.addComponent(lblValoresCriticos)
								.addComponent(lblValoresReservados)
								.addComponent(lblValoresNormales)
								.addComponent(lblTipo)
								.addComponent(lblNombre)
								.addComponent(lblGrupo))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtValorReservado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtValorCritico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtValorNormal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(6)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(20)
											.addComponent(lblColumnValoresMinimos))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(12)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(intValorCriticoMin, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
												.addComponent(intValorNormalMin, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
												.addComponent(intValorReservadoMin, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(24)
											.addComponent(lblColumnValoresMaximos))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(intValorCriticoMax, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
												.addComponent(intValorNormalMax, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
												.addComponent(intValorReservadoMax, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtNombre, 230, 230, 230)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
													.addComponent(intHorasEspera, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
													.addComponent(comboBoxTipo, Alignment.LEADING, 0, 67, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(checkBoxHabilitada))
											.addComponent(txtGrupo, 230, 230, 230)))
									.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)))))
					.addGap(9))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrupo)
						.addComponent(txtGrupo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHorasEspera)
								.addComponent(intHorasEspera, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBoxHabilitada))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTipo)
								.addComponent(comboBoxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(21)
							.addComponent(lblConfiguracionValores)
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblColumnValoresMinimos)
								.addComponent(lblColumnValoresMaximos))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValoresNormales)
						.addComponent(txtValorNormal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intValorNormalMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intValorNormalMax, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValoresCriticos)
						.addComponent(txtValorCritico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intValorCriticoMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intValorCriticoMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValoresReservados)
						.addComponent(txtValorReservado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intValorReservadoMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(intValorReservadoMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		contentPanel.setLayout(groupLayout);		
		
	}

	public PracticaDTO getPractica() {
		return (PracticaDTO) dto;
	}

	public void setPractica(PracticaDTO practicaDto) {
		dto = practicaDto;
		asignarDatosForm();
	}
	
	protected boolean asignarDatosEntidad() {
		try {
			checkFields();
			PracticaDTO practicaDto = (PracticaDTO) dto;
			dto = new PracticaDTO(practicaDto != null ? practicaDto.getCodigo() : null, 
									   txtNombre.getText(),
									   txtGrupo.getText(), 
									   Integer.parseInt(intHorasEspera.getText()),
							   		   checkBoxHabilitada.isSelected(),
									   PracticaValoresTipo.valueOf(String.valueOf(comboBoxTipo.getSelectedItem())), 
							   		   buildValoresMap());
			return true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "DATOS INCORRECTOS", JOptionPane.ERROR_MESSAGE);	
		}
		return false;
	}
	
	protected void asignarDatosForm(){
		PracticaDTO practicaDto = (PracticaDTO) dto;
		txtNombre.setText(practicaDto.getNombre());
		comboBoxTipo.setSelectedItem(practicaDto.getTipo());
		txtGrupo.setText(practicaDto.getGrupo());
		intHorasEspera.setText(String.valueOf(practicaDto.getHorasEsperaResultado()));
		checkBoxHabilitada.setSelected(practicaDto.isHabilitada());
		if(PracticaValoresTipo.WORD.equals(practicaDto.getTipo())) {
			txtValorNormal.setText(practicaDto.getValoresPosibles().get(PracticaValores.NORMALES.name()));
			txtValorCritico.setText(practicaDto.getValoresPosibles().get(PracticaValores.CRITICOS.name()));
			txtValorReservado.setText(practicaDto.getValoresPosibles().get(PracticaValores.RESERVADOS.name()));
		} else {
			intValorNormalMin.setText(practicaDto.getValoresPosibles().get(PracticaValores.NORMALES.name()).split("-")[0]);
			intValorNormalMax.setText(practicaDto.getValoresPosibles().get(PracticaValores.NORMALES.name()).split("-")[1]);
			intValorCriticoMin.setText(practicaDto.getValoresPosibles().get(PracticaValores.CRITICOS.name()).split("-")[0]);
			intValorCriticoMax.setText(practicaDto.getValoresPosibles().get(PracticaValores.CRITICOS.name()).split("-")[1]);
			intValorReservadoMin.setText(practicaDto.getValoresPosibles().get(PracticaValores.RESERVADOS.name()).split("-")[0]);
			intValorReservadoMax.setText(practicaDto.getValoresPosibles().get(PracticaValores.RESERVADOS.name()).split("-")[1]);
		}
	}
	
	private Map<String, String> buildValoresMap(){
		String tipoPractica = String.valueOf(comboBoxTipo.getSelectedItem());
		Map<String, String> map = new HashMap<String, String>(); 
		map.put(PracticaValores.NORMALES.name(), tipoPractica.equals(PracticaValoresTipo.WORD.name()) ? txtValorNormal.getText() : String.format("%s-%s", intValorNormalMin.getText(), intValorNormalMax.getText()));
		map.put(PracticaValores.CRITICOS.name(), tipoPractica.equals(PracticaValoresTipo.WORD.name()) ? txtValorCritico.getText() : String.format("%s-%s", intValorCriticoMin.getText(), intValorCriticoMax.getText()));
		map.put(PracticaValores.RESERVADOS.name(), tipoPractica.equals(PracticaValoresTipo.WORD.name()) ? txtValorReservado.getText() : String.format("%s-%s", intValorReservadoMin.getText(), intValorReservadoMax.getText()));
		return map;
	}
	
	protected void checkFields() throws Exception {
		if (txtNombre.getText().isEmpty() || intHorasEspera.getText().isEmpty()) {
			throw new Exception("Complete los campos obligatorios de la cabecera.");
		} else if (!areValoresConfiguradosCorrectly()) {
			throw new Exception("Valores incompletos o incorrectos.");
		}
	}
	
	private boolean areValoresConfiguradosCorrectly() {
		return (PracticaValoresTipo.WORD.equals(comboBoxTipo.getSelectedItem()) && 
				!txtValorNormal.getText().isEmpty() &&
				!txtValorCritico.getText().isEmpty() &&
				!txtValorReservado.getText().isEmpty()) ||
			   (PracticaValoresTipo.RANGE.equals(comboBoxTipo.getSelectedItem()) && 
				!intValorNormalMin.getText().isEmpty() && 
				!intValorNormalMax.getText().isEmpty() && 
				!intValorCriticoMin.getText().isEmpty() && 
				!intValorCriticoMax.getText().isEmpty() && 
				!intValorReservadoMin.getText().isEmpty() && 
				!intValorReservadoMax.getText().isEmpty() && 
				Integer.valueOf(intValorNormalMin.getText()) < Integer.valueOf(intValorNormalMax.getText()) &&
				Integer.valueOf(intValorCriticoMin.getText()) < Integer.valueOf(intValorCriticoMax.getText()) &&
				Integer.valueOf(intValorReservadoMin.getText()) < Integer.valueOf(intValorReservadoMax.getText()));			   
	}
		
}
