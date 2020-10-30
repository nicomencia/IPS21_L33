package pgh.ui.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMedico extends JPanel {
	
	private JPanel panelMedico;
	private JPanel panelAnterior;
	private int idmedico;
	private JButton btnSalirPanelMedico;
	private JButton btnIndicarPrescripcion;
	private JPanel panelContenido;
	
	public PanelMedico(JPanel panelAnterior, int id_medico, JPanel contenido) {
		
		this.panelAnterior = panelAnterior;
		this.panelContenido = contenido;
//		contenido.add(this);
		panelMedico=this;
		getPanelMedico();
		
	}
	
	private JPanel getPanelMedico() {
		if (panelMedico == null) {
			panelMedico = new JPanel();
			panelMedico.setBackground(Color.WHITE);
			panelMedico.setLayout(null);
			panelMedico.add(getBtnIndicarPrescripcion());
			panelMedico.add(getBtnSalirPanelMedico());
		}
		return panelMedico;
	}
	
	private JButton getBtnIndicarPrescripcion() {
		if (btnIndicarPrescripcion == null) {
			btnIndicarPrescripcion = new JButton("Indicar prescripcion");
			btnIndicarPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

//					PanelPrescripcion panel = new PanelPrescripcion(panelMedico, id_medico, panelContenido);
//					contentPane.add( panel);
//					panelMedico.setVisible(false);
//					panel.setVisible(true);
					
				}
			});
			btnIndicarPrescripcion.setBounds(78, 69, 151, 38);
		}
		return btnIndicarPrescripcion;
	}
	
	private JButton getBtnSalirPanelMedico() {
		if (btnSalirPanelMedico == null) {
			btnSalirPanelMedico = new JButton("Salir");
			btnSalirPanelMedico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
//					cambiarPanel("panelPrincipal");
				}
			});
			btnSalirPanelMedico.setBounds(944, 504, 124, 46);
		}
		return btnSalirPanelMedico;
	}
	
	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}
	

	

}
