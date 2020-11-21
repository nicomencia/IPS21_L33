package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import pgh.business.vacuna.CrearVacuna;
import pgh.business.vacuna.ListaVacunas;
import pgh.business.vacuna.Vacuna;
import pgh.business.vacuna.VacunaDTO;

import javax.swing.JSpinner;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCrearVacuna extends JPanel {
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JDateChooser dateChooser;
	private JLabel lblNewLabel_1_1_1;
	private JTextField textField_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;
	private JLabel lblNewLabel_1_1_1_1;
	private JSpinner spinnerHoraAsignacion;
	private JLabel lblNewLabel_10_1;
	private JSpinner spinnerMinutosAsignacion;
	private JLabel lblNewLabel_10;
	private JSpinner spinnerSegundosAsignacion;
	private JLabel lblNewLabel_11;
	private JPanel panelAnterior;
	private JPanel panelCambiar;
	private JPanel panelContenido;
	private JPanel estePanel;
	private int idpaciente;
	private int idEnfermero;
	private Vacuna vacuna;
	private VacunaDTO vacunaDTO;
	private CrearVacuna crearVacuna;
	private JPanel panelPrincipal;
	
	
	public PanelCrearVacuna(JPanel panelAnterior, JPanel panelContenido, int idPaciente, int idEnfermero) {
		this.panelAnterior = panelAnterior;
		this.estePanel = this;
		this.panelContenido = panelContenido;
		this.idpaciente = idPaciente;
		this.idEnfermero = idEnfermero;
		setBackground(new Color(135, 206, 235));
		setLayout(null);
		setBounds(100, 100, 1129, 600);
		add(getLblNewLabel());
		add(getComboBox());
		add(getBtnNewButton());
		add(getTextField());
		add(getLblNewLabel_1());
		add(getLblNewLabel_1_1());
		add(getDateChooser());
		add(getLblNewLabel_1_1_1());
		add(getTextField_1());
		add(getBtnNewButton_1());
		add(getBtnNewButton_1_1());
		add(getLblNewLabel_1_1_1_1());
		add(getSpinnerHoraAsignacion());
		add(getLblNewLabel_10_1());
		add(getSpinnerMinutosAsignacion());
		add(getLblNewLabel_10());
		add(getSpinnerSegundosAsignacion());
		add(getLblNewLabel_11());
	}
	
	

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Vacunas frecuentes:");
			lblNewLabel.setBounds(90, 64, 132, 50);
		}
		return lblNewLabel;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Triple v\u00EDrica. ", "Vacunas contra la hepatitis. ", "Vacuna contra la polio. ", "Vacuna contra el VPH. ", "Vacuna contra la varicela.", "Vacuna DTaP. ", "Vacuna Hib. ", "Vacuna antigripal."}));
			comboBox.setBounds(246, 75, 200, 28);
		}
		return comboBox;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Seleccionar vacuna");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					textField.setText((String) comboBox.getSelectedItem());
				}
			});
			btnNewButton.setBounds(456, 75, 156, 28);
		}
		return btnNewButton;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(246, 134, 200, 28);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Nombre vacuna: ");
			lblNewLabel_1.setBounds(109, 134, 104, 28);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Fecha vacunacion: ");
			lblNewLabel_1_1.setBounds(100, 192, 132, 28);
		}
		return lblNewLabel_1_1;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(246, 192, 200, 28);
			Calendar fecha = new GregorianCalendar();


			int dia = fecha.get(Calendar.DAY_OF_MONTH);
			int mes = 0;
			if (Calendar.MONTH == 12) {
				mes = fecha.get(Calendar.MONTH) - 11;
			} else {
				mes = fecha.get(Calendar.MONTH) + 1;
			}

			int ano = fecha.get(Calendar.YEAR);

			SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy/MM/dd");
			Date date2 = new Date();
			try {
				date2 = dateformat3.parse(ano + "/" + mes + "/" + dia);
				dateChooser.setDate(date2);
				dateChooser.getJCalendar().setMinSelectableDate(date2);
				((JTextFieldDateEditor) dateChooser.getDateEditor()).setEditable(false);

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return dateChooser;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("Observacion : ");
			lblNewLabel_1_1_1.setBounds(122, 273, 113, 28);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(246, 252, 366, 70);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Poner Vacuna");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String hora = spinnerHoraAsignacion.getValue().toString() + "";
					String minutos = spinnerMinutosAsignacion.getValue().toString() + "";
					String segundos = spinnerSegundosAsignacion.getValue().toString() + "";

					String horaAsignacion = hora + ":" + minutos + ":" + segundos;
					
		
					if(textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(btnNewButton_1, "Indique un nombre de la vacuna");
					}
					else {
						
						vacunaDTO = new VacunaDTO();
						vacunaDTO.idVacuna = generarIdVacuna();
						vacunaDTO.idPaciente = idpaciente;
						vacunaDTO.diaAsignacion= dateChooser.getDate();
						vacunaDTO.diaVacunacion = dateChooser.getDate();
						vacunaDTO.horaAsignacion = horaAsignacion;
						vacunaDTO.observacion = textField_1.getText();
						vacunaDTO.nombreVacuna = textField.getText();
						vacunaDTO.isPuesta= true;
						
						vacuna = new Vacuna(vacunaDTO);
						crearVacuna= new CrearVacuna();
						crearVacuna.crearVacuna(vacuna);
						
						PanelEnfermero panel = new PanelEnfermero(panelCambiar, panelContenido , idEnfermero, panelCambiar);
						estePanel.setVisible(false);
						panelContenido.add(panel);
						panel.setVisible(true);
						
					}
					
					
				
					
					
				}
			});
			btnNewButton_1.setBounds(651, 478, 200, 42);
		}
		return btnNewButton_1;
	}

private int generarIdVacuna() {
	ListaVacunas lc = new ListaVacunas();
	lc.creaListaPrescripciones();
	return 4800 + lc.getPrescripciones().size();
}
	private JButton getBtnNewButton_1_1() {
		if (btnNewButton_1_1 == null) {
			btnNewButton_1_1 = new JButton("Cancelar");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					estePanel.setVisible(false);
					panelAnterior.setVisible(true);
				}
			});
			btnNewButton_1_1.setBounds(892, 478, 200, 42);
		}
		return btnNewButton_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("Hora vacunacion : ");
			lblNewLabel_1_1_1_1.setBounds(109, 372, 113, 28);
		}
		return lblNewLabel_1_1_1_1;
	}
	
	public int obtenerHoraActual() {
		int hora = 0;
		DateFormat dateFormat = new SimpleDateFormat("HH");
		Date date = new Date();
		hora = Integer.parseInt(dateFormat.format(date));
		return hora;

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
	
	private JSpinner getSpinnerHoraAsignacion() {
		if (spinnerHoraAsignacion == null) {
			spinnerHoraAsignacion = new JSpinner();
			spinnerHoraAsignacion.setBounds(262, 376, 52, 20);
			spinnerHoraAsignacion.setValue(obtenerHoraActual());
		}
		return spinnerHoraAsignacion;
	}
	private JLabel getLblNewLabel_10_1() {
		if (lblNewLabel_10_1 == null) {
			lblNewLabel_10_1 = new JLabel(":");
			lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_10_1.setBounds(324, 379, 22, 14);
		}
		return lblNewLabel_10_1;
	}
	private JSpinner getSpinnerMinutosAsignacion() {
		if (spinnerMinutosAsignacion == null) {
			spinnerMinutosAsignacion = new JSpinner();
			spinnerMinutosAsignacion.setBounds(334, 376, 52, 20);
			spinnerMinutosAsignacion.setValue(obtenerMinutosActual());
		}
		return spinnerMinutosAsignacion;
	}
	private JLabel getLblNewLabel_10() {
		if (lblNewLabel_10 == null) {
			lblNewLabel_10 = new JLabel(":");
			lblNewLabel_10.setForeground(Color.BLACK);
			lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_10.setBounds(396, 379, 22, 14);
			
		}
		return lblNewLabel_10;
	}
	private JSpinner getSpinnerSegundosAsignacion() {
		if (spinnerSegundosAsignacion == null) {
			spinnerSegundosAsignacion = new JSpinner();
			spinnerSegundosAsignacion.setBounds(406, 376, 52, 20);
			spinnerSegundosAsignacion.setValue(obtenerSegundosActual());
		}
		return spinnerSegundosAsignacion;
	}
	private JLabel getLblNewLabel_11() {
		if (lblNewLabel_11 == null) {
			lblNewLabel_11 = new JLabel("HH/mm/ss");
			lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_11.setBounds(483, 379, 85, 14);
		}
		return lblNewLabel_11;
	}
}
