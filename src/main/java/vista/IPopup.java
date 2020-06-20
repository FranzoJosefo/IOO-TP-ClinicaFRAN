package main.java.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.java.Interface.IDto;
import main.java.vista.util.ModalResult;

public abstract class IPopup extends JDialog {

	protected final JPanel contentPanel = new JPanel();
	protected ModalResult modalResult;
	protected IDto dto; 
	
	public IPopup(JFrame frame, String name, int width, int height) {
		super(frame, name, true);
		setLocationRelativeTo(frame);
		init(width, height);
		inicializarControles();
	}
	
	private void init(int width, int height) {
				
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setBounds(0, 0, width, height);
		setLocationRelativeTo(null);
			
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(asignarDatosEntidad()) {
							modalResult = ModalResult.OK;
							dispose();
						}	
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
	
	public ModalResult getModalResult() {
		return modalResult;
	}
	
	protected abstract void inicializarControles();

	protected abstract boolean asignarDatosEntidad();
	
	protected abstract void asignarDatosForm();
	
	protected abstract void checkFields() throws Exception;
		
}
