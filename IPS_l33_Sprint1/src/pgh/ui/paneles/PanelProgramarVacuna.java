package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class PanelProgramarVacuna extends JPanel {
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JLabel lblNewLabel_1_1;
	private JDateChooser dateChooser;
	private JLabel lblNewLabel_1_1_1;
	private JTextField textField_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;
	public PanelProgramarVacuna() {
		setBackground(new Color(135, 206, 235));
		this.setBounds(100, 100, 1129, 600);
		setLayout(null);
		add(getLblNewLabel());
		add(getComboBox());
		add(getBtnNewButton());
		add(getLblNewLabel_1());
		add(getTextField());
		add(getLblNewLabel_1_1());
		add(getDateChooser());
		add(getLblNewLabel_1_1_1());
		add(getTextField_1());
		add(getBtnNewButton_1());
		add(getBtnNewButton_1_1());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Vacunas frecuentes:");
			lblNewLabel.setBounds(111, 67, 132, 50);
		}
		return lblNewLabel;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(221, 78, 227, 28);
		}
		return comboBox;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Seleccionar vacuna");
			btnNewButton.setBounds(458, 78, 156, 28);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Nombre vacuna: ");
			lblNewLabel_1.setBounds(130, 152, 104, 28);
		}
		return lblNewLabel_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(221, 152, 227, 28);
		}
		return textField;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Fecha vacunacion: ");
			lblNewLabel_1_1.setBounds(121, 227, 132, 28);
		}
		return lblNewLabel_1_1;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(221, 227, 227, 28);
		}
		return dateChooser;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("Observacion : ");
			lblNewLabel_1_1_1.setBounds(142, 324, 113, 28);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(220, 303, 393, 70);
		}
		return textField_1;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Programar vacuna");
			btnNewButton_1.setBounds(627, 468, 204, 50);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_1_1() {
		if (btnNewButton_1_1 == null) {
			btnNewButton_1_1 = new JButton("Cancelar");
			btnNewButton_1_1.setBounds(873, 468, 204, 50);
		}
		return btnNewButton_1_1;
	}
}
