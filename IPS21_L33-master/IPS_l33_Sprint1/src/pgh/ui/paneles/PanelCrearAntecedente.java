package pgh.ui.paneles;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class PanelCrearAntecedente extends JPanel {
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblFecha;
	private JDateChooser dateChooserAntecedente;
	private JLabel lblHoraAsignacionAntecedente;
	private JSpinner spinnerHoraInicioJornadaEnfermero;
	private JLabel lblNewLabel_6_2;
	private JSpinner spinnerMinutosAntecedente;
	private JSpinner spinnerMinutos2Antecedente;
	private JButton btnCrear;
	private JButton btnNewButton;
	public PanelCrearAntecedente() {
		this.setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 1129, 600);
		setLayout(null);
		add(getLblNewLabel());
		add(getTextField());
		add(getLblFecha());
		add(getDateChooserAntecedente());
		add(getLblHoraAsignacionAntecedente());
		add(getSpinnerHoraInicioJornadaEnfermero());
		add(getLblNewLabel_6_2());
		add(getSpinnerMinutosAntecedente());
		add(getSpinnerMinutos2Antecedente());
		add(getBtnCrear());
		add(getBtnNewButton());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Escribir nuevo antecedente : ");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBounds(123, 92, 329, 46);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(445, 86, 626, 67);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblFecha() {
		if (lblFecha == null) {
			lblFecha = new JLabel("Fecha Asignacion  : ");
			lblFecha.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblFecha.setBounds(123, 209, 247, 46);
		}
		return lblFecha;
	}
	private JDateChooser getDateChooserAntecedente() {
		if (dateChooserAntecedente == null) {
			dateChooserAntecedente = new JDateChooser();
			dateChooserAntecedente.setBounds(343, 224, 95, 20);
		}
		return dateChooserAntecedente;
	}
	private JLabel getLblHoraAsignacionAntecedente() {
		if (lblHoraAsignacionAntecedente == null) {
			lblHoraAsignacionAntecedente = new JLabel("Hora asignacion  : ");
			lblHoraAsignacionAntecedente.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblHoraAsignacionAntecedente.setBounds(123, 291, 247, 46);
		}
		return lblHoraAsignacionAntecedente;
	}
	private JSpinner getSpinnerHoraInicioJornadaEnfermero() {
		if (spinnerHoraInicioJornadaEnfermero == null) {
			spinnerHoraInicioJornadaEnfermero = new JSpinner();
			spinnerHoraInicioJornadaEnfermero.setBounds(343, 306, 48, 20);
		}
		return spinnerHoraInicioJornadaEnfermero;
	}
	private JLabel getLblNewLabel_6_2() {
		if (lblNewLabel_6_2 == null) {
			lblNewLabel_6_2 = new JLabel(":");
			lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_2.setBounds(401, 308, 30, 14);
		}
		return lblNewLabel_6_2;
	}
	private JSpinner getSpinnerMinutosAntecedente() {
		if (spinnerMinutosAntecedente == null) {
			spinnerMinutosAntecedente = new JSpinner();
			spinnerMinutosAntecedente.setBounds(417, 306, 48, 20);
		}
		return spinnerMinutosAntecedente;
	}
	private JSpinner getSpinnerMinutos2Antecedente() {
		if (spinnerMinutos2Antecedente == null) {
			spinnerMinutos2Antecedente = new JSpinner();
			spinnerMinutos2Antecedente.setBounds(475, 306, 48, 20);
		}
		return spinnerMinutos2Antecedente;
	}
	private JButton getBtnCrear() {
		if (btnCrear == null) {
			btnCrear = new JButton("Crear antecedente");
			btnCrear.setBounds(740, 539, 149, 23);
		}
		return btnCrear;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Cancelar");
			btnNewButton.setBounds(922, 539, 149, 23);
		}
		return btnNewButton;
	}
}
