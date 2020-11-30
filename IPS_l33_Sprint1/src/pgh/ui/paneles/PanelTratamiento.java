package pgh.ui.paneles;

import javax.swing.JPanel;

import pgh.business.paciente.Paciente;
import pgh.business.paciente.PacienteDTO;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTratamiento extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private JPanel estePanel;
	private PacienteDTO paciente;
	private JScrollPane scrollPaneTratamientos;
	private JList listTratamientos;
	private JLabel lblTratamientos;
	private JLabel lblPaciente;
	private JLabel labelNombrePaciente;
	private JButton btnAtras;
	public PanelTratamiento(JPanel panelAnterior, JPanel panelContenido, PacienteDTO paciente) {
		estePanel = this;
		this.panelAnterior = panelAnterior;
		this.panelContenido = panelContenido;
		this.paciente = paciente;
		setLayout(null);
		add(getScrollPaneTratamientos());
		add(getLblTratamientos());
		add(getLblPaciente());
		add(getLabelNombrePaciente());
		add(getBtnAtras());
	}
	private JScrollPane getScrollPaneTratamientos() {
		if (scrollPaneTratamientos == null) {
			scrollPaneTratamientos = new JScrollPane();
			scrollPaneTratamientos.setBounds(77, 79, 784, 386);
			scrollPaneTratamientos.setViewportView(getListTratamientos());
		}
		return scrollPaneTratamientos;
	}
	private JList getListTratamientos() {
		if (listTratamientos == null) {
			listTratamientos = new JList();
		}
		return listTratamientos;
	}
	private JLabel getLblTratamientos() {
		if (lblTratamientos == null) {
			lblTratamientos = new JLabel("Tratamientos");
			lblTratamientos.setBounds(77, 47, 90, 21);
		}
		return lblTratamientos;
	}
	private JLabel getLblPaciente() {
		if (lblPaciente == null) {
			lblPaciente = new JLabel("Paciente:");
			lblPaciente.setBounds(261, 50, 65, 14);
		}
		return lblPaciente;
	}
	private JLabel getLabelNombrePaciente() {
		if (labelNombrePaciente == null) {
			labelNombrePaciente = new JLabel(paciente.nombre + " " + paciente.apellidos);
			labelNombrePaciente.setBounds(336, 50, 525, 21);
		}
		return labelNombrePaciente;
	}
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atras");
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					estePanel.setVisible(false);
					panelAnterior.setVisible(true);
				}
			});
			btnAtras.setBounds(772, 495, 89, 23);
		}
		return btnAtras;
	}
}
