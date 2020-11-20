package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import pgh.business.vacacionesSolicitadas.ListaVacacionesSolicitadasMedico;
import pgh.business.vacuna.CrearVacuna;
import pgh.business.vacuna.ListaVacunas;
import pgh.business.vacuna.Vacuna;
import pgh.business.vacuna.VacunaDTO;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JPanel panelanterior;
	private JPanel panelcontenido;
	private JPanel panelcambiar;
	private JPanel estePanel;
	private int idpaciente;
	private CrearVacuna crearVacuna;
	private Vacuna vacuna;
	private VacunaDTO vacunaDTO;
	
	public PanelProgramarVacuna(JPanel panelAnterior, JPanel panelContenido, int idPaciente, JPanel panelCambiar) {
		
		this.idpaciente = idPaciente;
		this.panelanterior= panelAnterior;
		this.panelcambiar= panelCambiar;
		this.panelcontenido = panelContenido;
		this.estePanel= this;
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
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Triple v\u00EDrica. ", "Vacunas contra la hepatitis. ", "Vacuna contra la polio. ", "Vacuna contra el VPH. ", "Vacuna contra la varicela.", "Vacuna DTaP. ", "Vacuna Hib. ", "Vacuna antigripal."}));
			comboBox.setBounds(266, 78, 227, 28);
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
			btnNewButton.setBounds(503, 78, 156, 28);
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
			textField.setBounds(266, 152, 227, 28);
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
			dateChooser.setBounds(266, 227, 227, 28);
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
			lblNewLabel_1_1_1.setBounds(142, 324, 113, 28);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(265, 303, 393, 70);
		}
		return textField_1;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Programar vacuna");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					vacunaDTO = new VacunaDTO();
					if(textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(btnNewButton_1, "Indique un nombre de la vacuna");
					}
					else {
						vacunaDTO.idVacuna = generarIdVacuna();
						vacunaDTO.idPaciente = idpaciente;
						vacunaDTO.diaAsignacion= dateChooser.getDate();
						vacunaDTO.diaVacunacion = null;
						vacunaDTO.horaAsignacion = "";
						vacunaDTO.observacion = textField_1.getText();
						vacunaDTO.nombreVacuna = textField.getText();
						vacunaDTO.isPuesta= false;
						
						vacuna = new Vacuna(vacunaDTO);
						crearVacuna= new CrearVacuna();
						crearVacuna.crearVacuna(vacuna);
						
						PanelHistorialVacunas panel = new PanelHistorialVacunas(estePanel,panelcontenido , idpaciente, panelcambiar);
						estePanel.setVisible(false);
						panelcontenido.add(panel);
						panel.setVisible(true);
					}
					
					
				}

				
			});
			btnNewButton_1.setBounds(627, 468, 204, 50);
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
					PanelHistorialVacunas panel = new PanelHistorialVacunas(estePanel,panelcontenido , idpaciente, panelcambiar);
					estePanel.setVisible(false);
					panelcontenido.add(panel);
					panel.setVisible(true);
				}
			});
			btnNewButton_1_1.setBounds(873, 468, 204, 50);
		}
		return btnNewButton_1_1;
	}
}
