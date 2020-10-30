package pgh.ui.paneles;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PanelAntecedentesClinicos extends JPanel {
	private JScrollPane scrollPaneListaAntecedentes;
	private JList listAntecedentes;
	private JLabel lblNewLabelistaAnt;
	private JButton btnAnadirAntecedente;
	private JTextField textField;
	private JLabel lblFiltro;
	private JButton btnNewButton;
	private JScrollPane scrollPaneInfo;
	private JList listInformacionAntecedente;
	private JLabel lblInfo;
	private JButton btnSalir;
	
	
	public PanelAntecedentesClinicos() {
		this.setBackground(new Color(135, 206, 235));
		setLayout(null);
		setBounds(100, 100, 1129, 600);
		add(getScrollPaneListaAntecedentes());
		add(getLblNewLabelistaAnt());
		add(getBtnAnadirAntecedente());
		add(getTextField());
		add(getLblFiltro());
		add(getBtnNewButton());
		add(getScrollPaneInfo());
		add(getLblInfo());
		add(getBtnSalir());
	}
	private JScrollPane getScrollPaneListaAntecedentes() {
		if (scrollPaneListaAntecedentes == null) {
			scrollPaneListaAntecedentes = new JScrollPane();
			scrollPaneListaAntecedentes.setBounds(104, 152, 371, 363);
			scrollPaneListaAntecedentes.setViewportView(getListAntecedentes());
		}
		return scrollPaneListaAntecedentes;
	}
	private JList getListAntecedentes() {
		if (listAntecedentes == null) {
			listAntecedentes = new JList();
			listAntecedentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listAntecedentes;
	}
	private JLabel getLblNewLabelistaAnt() {
		if (lblNewLabelistaAnt == null) {
			lblNewLabelistaAnt = new JLabel("Lista de antecedentes ");
			lblNewLabelistaAnt.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabelistaAnt.setBounds(180, 79, 371, 25);
		}
		return lblNewLabelistaAnt;
	}
	private JButton getBtnAnadirAntecedente() {
		if (btnAnadirAntecedente == null) {
			btnAnadirAntecedente = new JButton("A\u00F1adir antecedente");
			btnAnadirAntecedente.setBounds(104, 535, 371, 23);
		}
		return btnAnadirAntecedente;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(104, 133, 371, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblFiltro() {
		if (lblFiltro == null) {
			lblFiltro = new JLabel("FILTRO :");
			lblFiltro.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblFiltro.setBounds(29, 136, 65, 14);
		}
		return lblFiltro;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Ver Informacion de la seleccionada");
			btnNewButton.setBounds(502, 294, 199, 39);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPaneInfo() {
		if (scrollPaneInfo == null) {
			scrollPaneInfo = new JScrollPane();
			scrollPaneInfo.setBounds(750, 207, 343, 279);
			scrollPaneInfo.setViewportView(getListInformacionAntecedente());
		}
		return scrollPaneInfo;
	}
	private JList getListInformacionAntecedente() {
		if (listInformacionAntecedente == null) {
			listInformacionAntecedente = new JList();
			listInformacionAntecedente.setEnabled(false);
			listInformacionAntecedente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listInformacionAntecedente;
	}
	private JLabel getLblInfo() {
		if (lblInfo == null) {
			lblInfo = new JLabel("Informacion del Antecedente");
			lblInfo.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblInfo.setBounds(776, 152, 343, 25);
		}
		return lblInfo;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir ");
			btnSalir.setBounds(934, 550, 154, 25);
		}
		return btnSalir;
	}
}
