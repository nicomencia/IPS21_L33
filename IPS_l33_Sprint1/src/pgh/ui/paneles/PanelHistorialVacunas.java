package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

public class PanelHistorialVacunas extends JPanel{
	private JScrollPane scrollPane;
	private JButton btnProgramarVacuna;
	private JButton btnSalir;
	private JList listVacunas;
	private JTextField textField;
	public PanelHistorialVacunas() {
		setBackground(new Color(135, 206, 235));
		this.setBounds(100, 100, 1129, 600);
		setLayout(null);
		add(getScrollPane());
		add(getBtnProgramarVacuna());
		add(getBtnSalir());
		add(getTextField());
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(80, 52, 1016, 374);
			scrollPane.setViewportView(getListVacunas());
		}
		return scrollPane;
	}
	private JButton getBtnProgramarVacuna() {
		if (btnProgramarVacuna == null) {
			btnProgramarVacuna = new JButton("Programar nueva vacuna");
			btnProgramarVacuna.setBounds(479, 460, 200, 50);
		}
		return btnProgramarVacuna;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.setForeground(new Color(255, 0, 0));
			btnSalir.setBounds(921, 510, 175, 42);
		}
		return btnSalir;
	}
	private JList getListVacunas() {
		if (listVacunas == null) {
			listVacunas = new JList();
		}
		return listVacunas;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(80, 31, 1016, 20);
			textField.setColumns(10);
		}
		return textField;
	}
}
