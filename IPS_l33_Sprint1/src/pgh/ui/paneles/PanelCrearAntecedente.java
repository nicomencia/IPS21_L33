package pgh.ui.paneles;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
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
import pgh.business.antecedentescitapaciente.AntecedentesCitaPaciente;
import pgh.business.antecedentescitapaciente.AntecedentesCitaPacienteDTO;
import pgh.business.antecedentescitapaciente.CrearAntecedentesCitaPaciente;
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
	private JPanel panelPrevio;
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private int id_paciente;
	private JLabel lblNewLabel_6_2_1;
	private JLabel lblNewLabel_11;
	private int idCita;
	private AntecedentesCitaPaciente acp;
	private AntecedentesCitaPacienteDTO acpDTO;
	private CrearAntecedentesCitaPaciente crearACP;
	
	
	
	public PanelCrearAntecedente(JPanel panelAnterior, JPanel panelContenido, int idPaciente, JPanel panelPrevio,int idcita) {
		this.setBackground(new Color(135, 206, 235));
		this.panelAnterior = panelAnterior;
		this.panelContenido = panelContenido;
		this.id_paciente=idPaciente;
		panelCrearAntecedentes=this;
		this.idCita = idcita;
		this.panelPrevio = panelPrevio;
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
		add(getLblNewLabel_6_2_1());
		add(getLblNewLabel_11());
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
	
	public int obtenerHoraActual() {
		int hora = 0;
		DateFormat dateFormat = new SimpleDateFormat("HH");
		Date date = new Date();
		hora = Integer.parseInt(dateFormat.format(date));
		return hora;

	}
	
	private JSpinner getSpinnerHoraInicioJornadaEnfermero() {
		if (spinnerHoraInicioJornadaEnfermero == null) {
			spinnerHoraInicioJornadaEnfermero = new JSpinner();
			spinnerHoraInicioJornadaEnfermero.setModel(new SpinnerNumberModel(0, 0, 23, 1));
			spinnerHoraInicioJornadaEnfermero.setBounds(343, 306, 48, 20);
			spinnerHoraInicioJornadaEnfermero.setValue(obtenerHoraActual());
		}
		return spinnerHoraInicioJornadaEnfermero;
	}
	
	public int obtenerMinutosActual() {

		int hora = 0;
		DateFormat dateFormat = new SimpleDateFormat("mm");
		Date date = new Date();
		hora = Integer.parseInt(dateFormat.format(date));
		return hora;

	}

	public int obtenerSegundosActual() {

		int hora = 0;
		DateFormat dateFormat = new SimpleDateFormat("ss");
		Date date = new Date();
		hora = Integer.parseInt(dateFormat.format(date));
		return hora;

	}
	

	private JLabel getLblNewLabel_6_2() {
		if (lblNewLabel_6_2 == null) {
			lblNewLabel_6_2 = new JLabel(":");
			lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_2.setBounds(401, 310, 30, 14);
		}
		return lblNewLabel_6_2;
	}
	private JSpinner getSpinnerMinutosAntecedente() {
		if (spinnerMinutosAntecedente == null) {
			spinnerMinutosAntecedente = new JSpinner();
			spinnerMinutosAntecedente.setModel(new SpinnerNumberModel(0, 0, 59, 1));
			spinnerMinutosAntecedente.setBounds(417, 306, 48, 20);
			spinnerMinutosAntecedente.setValue(obtenerMinutosActual());
		}
		return spinnerMinutosAntecedente;
	}
	private JSpinner getSpinnerMinutos2Antecedente() {
		if (spinnerMinutos2Antecedente == null) {
			spinnerMinutos2Antecedente = new JSpinner();
			spinnerMinutos2Antecedente.setModel(new SpinnerNumberModel(0, 0, 59, 1));
			spinnerMinutos2Antecedente.setBounds(487, 306, 48, 20);
			spinnerMinutos2Antecedente.setValue(obtenerSegundosActual());
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

					String horaAsignacion = hora + ":" + minutos+ ":" + segundos;
					antecedenteDTO.horaAsignacion = horaAsignacion;
					antecedenteDTO.diaAsignacion = dateChooserAntecedente.getDate();
					
					textField.setText("");
					
					antecedente = new Antecedentes(antecedenteDTO);
					crearAntecedente.crearPrescripcion(antecedente);
					acpDTO = new AntecedentesCitaPacienteDTO();
					
					acpDTO.idAntecedente=antecedente.getIdAntecedentes();
					acpDTO.idCita=idCita;
					acpDTO.idPaciente=id_paciente;
					
					
					crearACP = new CrearAntecedentesCitaPaciente();
					acp = new AntecedentesCitaPaciente(acpDTO);
					crearACP.crearCita(acp);
					
					 PanelAntecedentesClinicos panel = new PanelAntecedentesClinicos(panelCrearAntecedentes, panelContenido, id_paciente, panelPrevio, idCita);
					 panelCrearAntecedentes.setVisible(false);
					 panelContenido.add(panel);
					 panel.setVisible(true);

					
					
				}

			});
			btnCrear.setBounds(739, 502, 149, 23);
		}
		return btnCrear;
	}
	
	private int generarIdAntecedente() {
		ListaAntecedentes la = new ListaAntecedentes(id_paciente);
		la.creaListaAntecedentes();
		return 4600 + la.getAntecedentes().size();
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Cancelar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelAnterior.setVisible(true);
					panelCrearAntecedentes.setVisible(false);
				}
			});
			btnNewButton.setBounds(922, 502, 149, 23);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_6_2_1() {
		if (lblNewLabel_6_2_1 == null) {
			lblNewLabel_6_2_1 = new JLabel(":");
			lblNewLabel_6_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_2_1.setBounds(475, 310, 30, 14);
		}
		return lblNewLabel_6_2_1;
	}
	private JLabel getLblNewLabel_11() {
		if (lblNewLabel_11 == null) {
			lblNewLabel_11 = new JLabel("HH/mm/ss");
			lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_11.setBounds(551, 312, 85, 14);
		}
		return lblNewLabel_11;
	}
}
