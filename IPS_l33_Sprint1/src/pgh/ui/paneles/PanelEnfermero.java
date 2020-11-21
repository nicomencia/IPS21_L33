package pgh.ui.paneles;

import javax.swing.JPanel;

import pgh.ui.VentanaPrincipal;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEnfermero extends JPanel {
	
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private JPanel estePanel;
	private int idEnfermero;
	private JButton btnElegirCita;
	private JButton btnCancelar;
	private JPanel panelCambiar;
	private JPanel panelPrincipal;
	
	public PanelEnfermero(JPanel panelAnterior, JPanel panelContenido, int idEnfermero, JPanel panelCambiar) {
		this.panelAnterior = panelAnterior;
		this.estePanel = this;
		this.panelContenido = panelContenido;
		this.idEnfermero = idEnfermero;
	
		this.panelCambiar = panelCambiar;
		setBackground(new Color(135, 206, 235));
		setLayout(null);
		add(getBtnElegirCita());
		add(getBtnCancelar());
	}
	private JButton getBtnElegirCita() {
		if (btnElegirCita == null) {
			btnElegirCita = new JButton("Poner Vacuna");
			btnElegirCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PanelElegirPacienteEnfermero panel = new PanelElegirPacienteEnfermero(panelAnterior, panelContenido, idEnfermero);
					panelContenido.add(panel);
					estePanel.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnElegirCita.setBounds(68, 75, 200, 50);
		}
		return btnElegirCita;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					PanelLoginEnfermero panel = new PanelLoginEnfermero(panelAnterior, panelContenido);
					estePanel.setVisible(false);
					panelContenido.add(panel);
					panel.setVisible(true);
					 
				}
			});
			btnCancelar.setBounds(729, 432, 200, 50);
		}
		return btnCancelar;
	}
}
