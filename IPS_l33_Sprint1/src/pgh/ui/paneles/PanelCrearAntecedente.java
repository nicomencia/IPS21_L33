package pgh.ui.paneles;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import pgh.business.antecedentesClinicos.Antecedentes;
import pgh.business.antecedentesClinicos.AntecedentesDTO;
import pgh.business.antecedentesClinicos.CrearAntecedentes;
import pgh.business.antecedentesClinicos.ListaAntecedentes;
import pgh.business.prescripcion.ListaPrescripciones;
import pgh.business.prescripcion.Prescripcion;

import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

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
	private CrearAntecedentes crearAntecedente;
	private Antecedentes antecedente;
	private JPanel panelCrearAntecedentes;
	private AntecedentesDTO antecedenteDTO;
	private JPanel panelAnterior;
	private JPanel panelContenido;
	
	
	
	public PanelCrearAntecedente(JPanel panelAnterior, JPanel panelContenido) {
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
			
			Calendar fecha = new GregorianCalendar();

			int dia = fecha.get(Calendar.DAY_OF_MONTH);
			int mes=0;
			if(Calendar.MONTH==12) {
				mes = fecha.get(Calendar.MONTH) - 11;
			}
			else {
				mes = fecha.get(Calendar.MONTH) + 1;
			}
			
			int ano = fecha.get(Calendar.YEAR);

			SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy/MM/dd");
			Date date2 = new Date();
			try {
				date2 = dateformat3.parse(ano + "/" + mes + "/" + dia);
				dateChooserAntecedente.setDate(date2);
				dateChooserAntecedente.getJCalendar().setMinSelectableDate(date2);
				((JTextFieldDateEditor) dateChooserAntecedente.getDateEditor()).setEditable(false);
				

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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
			spinnerHoraInicioJornadaEnfermero.setModel(new SpinnerNumberModel(0, 0, 23, 1));
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
			spinnerMinutosAntecedente.setModel(new SpinnerNumberModel(0, 0, 5, 1));
			spinnerMinutosAntecedente.setBounds(417, 306, 48, 20);
		}
		return spinnerMinutosAntecedente;
	}
	private JSpinner getSpinnerMinutos2Antecedente() {
		if (spinnerMinutos2Antecedente == null) {
			spinnerMinutos2Antecedente = new JSpinner();
			spinnerMinutos2Antecedente.setModel(new SpinnerNumberModel(0, 0, 9, 1));
			spinnerMinutos2Antecedente.setBounds(475, 306, 48, 20);
		}
		return spinnerMinutos2Antecedente;
	}
	private JButton getBtnCrear() {
		if (btnCrear == null) {
			btnCrear = new JButton("Crear antecedente");
			btnCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					crearAntecedente = new CrearAntecedentes();
					antecedenteDTO = new AntecedentesDTO();
					antecedenteDTO.idAntecedenteClinico = generarIdAntecedente();
					
					if (textField.getText()!= "") {
						antecedenteDTO.descripcion = textField.getText();

					} else {
						JOptionPane.showMessageDialog(textField,
								"El campo descripcion no se puede dejar vacio");
					}
					
					String hora = spinnerHoraInicioJornadaEnfermero.getValue().toString() + "";
					String minutos = spinnerMinutosAntecedente.getValue().toString() + "";
					String segundos = spinnerMinutos2Antecedente.getValue().toString() + "";

					String horaAsignacion = hora + ":" + minutos+segundos;
					antecedenteDTO.horaAsignacion = horaAsignacion;
					antecedenteDTO.diaAsignacion = dateChooserAntecedente.getDate();
					
					textField.setText("");
					
					antecedente = new Antecedentes(antecedenteDTO);
					crearAntecedente.crearPrescripcion(antecedente);
					
					 PanelAntecedentesClinicos panel = new PanelAntecedentesClinicos(panelCrearAntecedentes, panelContenido);
					 panelCrearAntecedentes.setVisible(false);
					 panelContenido.add(panel);
					 panel.setVisible(true);

					
					
				}

			});
			btnCrear.setBounds(740, 539, 149, 23);
		}
		return btnCrear;
	}
	
	private int generarIdAntecedente() {
		ListaAntecedentes la = new ListaAntecedentes();
		la.creaListaAntecedentes();
		return 4600 + la.getAntecedentes().size();
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Cancelar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setBounds(922, 539, 149, 23);
		}
		return btnNewButton;
	}
}
