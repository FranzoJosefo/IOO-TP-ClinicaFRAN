package main.java.vista.sucursal;
//package vistas.sucursal;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.SystemColor;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//import javax.swing.GroupLayout;
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JSeparator;
//import javax.swing.JTable;
//import javax.swing.UIManager;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.LayoutStyle.ComponentPlacement;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.LineBorder;
//import javax.swing.table.TableCellRenderer;
//import javax.swing.table.TableColumnModel;
//
//import collections.PersonaCollection;
//import enums.ModalResult;
//import tablemodel.PersonaTableModel;
//import vista.PersonaABM;
//import vistas.paciente.PacienteTable;
//
//public class SucursalView {
//
//	public SucursalView() {
//		coleccionPersona = new PersonaCollection();
//		tableModel = new PacienteTable(coleccionPersona);
//		initialize();
//	}
//	
//	private void agregarPersona() {
//		try {
//			PacienteABM dialog = new PacienteABM(frame);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//			JOptionPane.showMessageDialog(null, "termineeee");
//			if (dialog.getModalResult() == ModalResult.OK)
//				tableModel.agregar(dialog.getPersona());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}				
//	}
//	
//	private void modificarPersona() {
//		try {
//			PacienteABM dialog = new PacienteABM(frame);
//			dialog.setPersona(coleccionPersona.getPersona(table.getSelectedRow()));
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//			if (dialog.getModalResult() == ModalResult.OK)
//				tableModel.refresh();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}			
//	}
//	
//	public void resizeColumnWidth(JTable table) {
//	    final TableColumnModel columnModel = table.getColumnModel();
//	    for (int column = 0; column < table.getColumnCount(); column++) {
//	        int width = 15; // Min width
//	        for (int row = 0; row < table.getRowCount(); row++) {
//	            TableCellRenderer renderer = table.getCellRenderer(row, column);
//	            Component comp = table.prepareRenderer(renderer, row, column);
//	            width = Math.max(comp.getPreferredSize().width +1 , width);
//	        }
//	        if(width > 300)
//	            width=300;
//	        columnModel.getColumn(column).setPreferredWidth(width);
//	    }
//	}
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}				
//
//		
//		frame = new JFrame();
//		frame.setBounds(100, 100, 752, 560);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLocationRelativeTo(null);
//		JPanel panel = new JPanel();
//		panel.setBorder(new EmptyBorder(10, 0, 0, 0));
//		panel.setMinimumSize(new Dimension(10, 50));
//		frame.getContentPane().add(panel, BorderLayout.SOUTH);
//		
//		JButton btnEliminar = new JButton("Eliminar");
//		
//		JButton btnModificar = new JButton("Modificar");
//		btnModificar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				modificarPersona();
//			}
//		});
//		
//		JButton btnAgregar = new JButton("Agregar");
//		btnAgregar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				agregarPersona();
//			}
//			
//		});
//		
//		JSeparator separator = new JSeparator();
//		GroupLayout gl_panel = new GroupLayout(panel);
//		gl_panel.setHorizontalGroup(
//			gl_panel.createParallelGroup(Alignment.LEADING)
//				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
//					.addContainerGap(423, Short.MAX_VALUE)
//					.addComponent(btnAgregar)
//					.addGap(18)
//					.addComponent(btnModificar)
//					.addGap(18)
//					.addComponent(btnEliminar)
//					.addContainerGap())
//				.addComponent(separator, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
//		);
//		gl_panel.setVerticalGroup(
//			gl_panel.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_panel.createSequentialGroup()
//					.addContainerGap()
//					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
//						.addComponent(btnEliminar)
//						.addComponent(btnModificar)
//						.addComponent(btnAgregar))
//					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//		);
//		panel.setLayout(gl_panel);
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
//		panel_1.setBackground(SystemColor.activeCaption);
//		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
//		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//		
//		JLabel lblNewLabel = new JLabel("ABM Demo");
//		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
//		panel_1.add(lblNewLabel);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setAutoscrolls(true);
//		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
//		
//		table = new JTable(tableModel);
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//	          if (arg0.getClickCount() == 2)
//	          	modificarPersona();
//			}
//		});
//		table.setAutoCreateRowSorter(true);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		scrollPane.setViewportView(table);
//	}
//	
//}
