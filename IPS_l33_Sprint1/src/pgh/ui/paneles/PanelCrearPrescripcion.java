package pgh.ui.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import pgh.business.medicamento.CrearMedicamento;
import pgh.business.medicamento.ListaMedicamentos;
import pgh.business.medicamento.Medicamento;
import pgh.business.medicamento.MedicamentoDTO;
import pgh.business.prescripcion.CrearPrescripcion;
import pgh.business.prescripcion.ListaPrescripciones;
import pgh.business.prescripcion.Prescripcion;
import pgh.business.prescripcion.PrescripcionDTO;
import pgh.ui.VentanaPrincipal;

public class PanelCrearPrescripcion extends JPanel {
	
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private JRadioButton rdbtnDiasPrescripcion;
	private JRadioButton rdbtnSemanasPrescripcion;
	private JRadioButton rdbtnMesesPrescripcion;
	private JRadioButton rdbtnAnosPrescripcion;
	private JDateChooser dateChooserPrescripcion;
	private JLabel lblNewLabel_12;
	private CrearPrescripcion crearPrescripcion;
	private DefaultListModel<Prescripcion> modeloListPrescripciones;
	private JPanel panelTipoPrescripcion;
	private JRadioButton rdbtnMedicamento;
	private JRadioButton rdbtnOtroTipo;
	private JLabel lblNewLabel_7;
	private JTextField textFieldInstrucciones;
	private JPanel panelMedicamento;
	private JLabel lblNewLabel_8;
	private JTextField textFieldNombreMedicamento;
	private JLabel lblNewLabel_8_1;
	private JSpinner spinnerCantidadMedicamento;
	private JLabel lblNewLabel_8_1_1;
	private JLabel lblNewLabel_8_1_2;
	private JLabel lblNewLabel_8_1_2_1;
	private JSpinner spinnerDiasSemanas;
	private JLabel lblNewLabel_8_1_2_1_1;
	private JTextField textFieldNotasAdicionalesPrescripcion;
	private JButton btnCrearPrescripcionNueva;
	private JButton btnCancelarCrearPrescripcionNueva;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_9_1;
	private ListaPrescripciones listaPrescripciones;
	private JSpinner spinnerHoraAsignacion;
	private JSpinner spinnerMinutosAsignacion;
	private JSpinner spinnerSegundosAsignacion;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_10_1;
	private JLabel lblNewLabel_11;
	private DefaultListModel<Prescripcion> modeloListPrescripcionesSeleccionada;
	private PrescripcionDTO prescripcionDTO;
	private Prescripcion prescripcion;
	private MedicamentoDTO medicamentoDTO;
	private Medicamento medicamento;
	private CrearMedicamento crearMedicamento;
	private int idmedico;
	private JPanel panelCrearPrescripcion;
	private JRadioButton rdbtnDiasIntervalo;
	private JRadioButton rdbtnSemanasIntervalo;
	private JRadioButton rdbtnMesesIntervalo;
	private JRadioButton rdbtnAnosIntervalo;
	private JSpinner spinnerIntervalo;
	private int idPaciente;
	private int idCita;
	private int idObservador;
	
	public PanelCrearPrescripcion(JPanel panelAnterior, JPanel panelContenido, int id_medico, int idPaciente, int idCita, int idObservador) {
		
		this.panelAnterior = panelAnterior;
		this.panelContenido= panelContenido;
		panelCrearPrescripcion= this;
		this.idmedico= id_medico;
		this.idCita = idCita;
		this.idPaciente= idPaciente;
		this.idObservador = idObservador;
		getPanelCrearPrescripcion();
	}

	private void getPanelCrearPrescripcion() {
		
			
			this.setBackground(new Color(135, 206, 235));
			this.setLayout(null);
			this.add(getPanelTipoPrescripcion());
			this.add(getLblNewLabel_7());
			this.add(getTextFieldInstrucciones());
			this.add(getPanelMedicamento());
			this.add(getBtnCrearPrescripcionNueva());
			this.add(getBtnCancelarCrearPrescripcionNueva());
			this.add(getLblNewLabel_9());
			this.add(getLblNewLabel_9_1());
			this.add(getSpinnerHoraAsignacion());
			this.add(getSpinnerMinutosAsignacion());
			this.add(getSpinnerSegundosAsignacion());
			this.add(getLblNewLabel_10());
			this.add(getLblNewLabel_10_1());
			this.add(getDateChooserPrescripcion());
			this.add(getLblNewLabel_11());
			this.add(getLblNewLabel_12());
		
		
	}

	private JPanel getPanelTipoPrescripcion() {
		if (panelTipoPrescripcion == null) {
			panelTipoPrescripcion = new JPanel();
			panelTipoPrescripcion.setBorder(new TitledBorder(null, "Elegir tipo de prescripcion", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			panelTipoPrescripcion.setForeground(Color.WHITE);
			panelTipoPrescripcion.setBackground(new Color(135, 206, 235));
			panelTipoPrescripcion.setBounds(90, 44, 257, 100);
			panelTipoPrescripcion.setLayout(null);
			panelTipoPrescripcion.add(getRdbtnMedicamento());
			panelTipoPrescripcion.add(getRdbtnOtroTipo());
		}
		return panelTipoPrescripcion;
	}

	private JRadioButton getRdbtnMedicamento() {
		if (rdbtnMedicamento == null) {
			rdbtnMedicamento = new JRadioButton("Medicamento");
			rdbtnMedicamento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comprobarMedicamentoSeleccionado();
				}
			});
			rdbtnMedicamento.setForeground(new Color(0, 0, 0));
			rdbtnMedicamento.setFont(new Font("Tahoma", Font.BOLD, 11));
			rdbtnMedicamento.setBackground(new Color(135, 206, 235));
			rdbtnMedicamento.setBounds(28, 40, 109, 23);

		}
		return rdbtnMedicamento;
	}

	private void comprobarMedicamentoSeleccionado() {

		if (rdbtnMedicamento.isSelected() == true) {

			rdbtnOtroTipo.setSelected(false);
			textFieldNombreMedicamento.setEnabled(true);
			spinnerCantidadMedicamento.setEnabled(true);
			spinnerIntervalo.setEnabled(true);
			spinnerDiasSemanas.setEnabled(true);
			rdbtnAnosPrescripcion.setEnabled(true);
			rdbtnDiasPrescripcion.setEnabled(true);
			rdbtnSemanasPrescripcion.setEnabled(true);
			rdbtnMesesPrescripcion.setEnabled(true);
			textFieldNotasAdicionalesPrescripcion.setEnabled(true);
			rdbtnDiasIntervalo.setEnabled(true);
			rdbtnSemanasIntervalo.setEnabled(true);
			rdbtnMesesIntervalo.setEnabled(true);
			rdbtnAnosIntervalo.setEnabled(true);


		}

	}

	private void comprobarOtroTipoSeleccionado() {

		if (rdbtnOtroTipo.isSelected() == true) {

			rdbtnMedicamento.setSelected(false);
			textFieldNombreMedicamento.setEnabled(false);
			spinnerCantidadMedicamento.setEnabled(false);
			spinnerIntervalo.setEnabled(false);
			spinnerDiasSemanas.setEnabled(false);
			rdbtnAnosPrescripcion.setEnabled(false);
			rdbtnDiasPrescripcion.setEnabled(false);
			rdbtnSemanasPrescripcion.setEnabled(false);
			rdbtnMesesPrescripcion.setEnabled(false);
			rdbtnAnosPrescripcion.setEnabled(false);
			rdbtnDiasIntervalo.setEnabled(false);
			rdbtnSemanasIntervalo.setEnabled(false);
			rdbtnMesesIntervalo.setEnabled(false);
			rdbtnAnosIntervalo.setEnabled(false);
			textFieldNotasAdicionalesPrescripcion.setEnabled(false);

		}

	}

	private JRadioButton getRdbtnOtroTipo() {
		if (rdbtnOtroTipo == null) {
			rdbtnOtroTipo = new JRadioButton("Otro tipo");
			rdbtnOtroTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comprobarOtroTipoSeleccionado();
				}
			});
			rdbtnOtroTipo.setSelected(true);
			rdbtnOtroTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
			rdbtnOtroTipo.setBackground(new Color(135, 206, 235));
			rdbtnOtroTipo.setBounds(139, 40, 88, 23);

		}
		return rdbtnOtroTipo;
	}

	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("Instruccion/es :");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel_7.setBounds(384, 44, 138, 25);
		}
		return lblNewLabel_7;
	}

	private JTextField getTextFieldInstrucciones() {
		if (textFieldInstrucciones == null) {
			textFieldInstrucciones = new JTextField();
			textFieldInstrucciones.setBounds(517, 39, 332, 41);
			textFieldInstrucciones.setColumns(10);
		}
		return textFieldInstrucciones;
	}

	private JPanel getPanelMedicamento() {
		if (panelMedicamento == null) {
			panelMedicamento = new JPanel();
			panelMedicamento.setBorder(
					new TitledBorder(null, "Medicamento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelMedicamento.setBackground(new Color(135, 206, 250));
			panelMedicamento.setBounds(460, 209, 517, 250);
			panelMedicamento.setLayout(null);
			panelMedicamento.add(getLblNewLabel_8());
			panelMedicamento.add(getTextFieldNombreMedicamento());
			panelMedicamento.add(getLblNewLabel_8_1());
			panelMedicamento.add(getSpinnerCantidadMedicamento());
			panelMedicamento.add(getLblNewLabel_8_1_1());
			panelMedicamento.add(getLblNewLabel_8_1_2());
			panelMedicamento.add(getLblNewLabel_8_1_2_1());
			panelMedicamento.add(getSpinnerDiasSemanas());
			panelMedicamento.add(getRdbtnDiasPrescripcion());
			panelMedicamento.add(getRdbtnSemanasPrescripcion());
			panelMedicamento.add(getRdbtnMesesPrescripcion());
			panelMedicamento.add(getRdbtnAnosPrescripcion());
			panelMedicamento.add(getLblNewLabel_8_1_2_1_1());
			panelMedicamento.add(getTextFieldNotasAdicionalesPrescripcion());
			panelMedicamento.add(getRdbtnDiasIntervalo());
			panelMedicamento.add(getRdbtnSemanasIntervalo());
			panelMedicamento.add(getRdbtnMesesIntervalo());
			panelMedicamento.add(getRdbtnAnosIntervalo());
			panelMedicamento.add(getSpinnerIntervalo());
		}
		return panelMedicamento;
	}

	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("Nombre :");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_8.setBounds(22, 33, 74, 25);
		}
		return lblNewLabel_8;
	}

	private JTextField getTextFieldNombreMedicamento() {
		if (textFieldNombreMedicamento == null) {
			textFieldNombreMedicamento = new JTextField();
			textFieldNombreMedicamento.setEnabled(false);
			textFieldNombreMedicamento.setBounds(113, 35, 162, 20);
			textFieldNombreMedicamento.setColumns(10);
		}
		return textFieldNombreMedicamento;
	}

	private JLabel getLblNewLabel_8_1() {
		if (lblNewLabel_8_1 == null) {
			lblNewLabel_8_1 = new JLabel("Cantidad :");
			lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_8_1.setBounds(22, 67, 84, 25);
		}
		return lblNewLabel_8_1;
	}

	private JSpinner getSpinnerCantidadMedicamento() {
		if (spinnerCantidadMedicamento == null) {
			spinnerCantidadMedicamento = new JSpinner();
			spinnerCantidadMedicamento.setEnabled(false);
			spinnerCantidadMedicamento
					.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinnerCantidadMedicamento.setBounds(113, 69, 43, 20);
		}
		return spinnerCantidadMedicamento;
	}

	private JLabel getLblNewLabel_8_1_1() {
		if (lblNewLabel_8_1_1 == null) {
			lblNewLabel_8_1_1 = new JLabel("Unidades");
			lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_8_1_1.setBounds(166, 69, 84, 25);
		}
		return lblNewLabel_8_1_1;
	}

	private JLabel getLblNewLabel_8_1_2() {
		if (lblNewLabel_8_1_2 == null) {
			lblNewLabel_8_1_2 = new JLabel("Intervalo :");
			lblNewLabel_8_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_8_1_2.setBounds(22, 104, 84, 25);
		}
		return lblNewLabel_8_1_2;
	}

	private JLabel getLblNewLabel_8_1_2_1() {
		if (lblNewLabel_8_1_2_1 == null) {
			lblNewLabel_8_1_2_1 = new JLabel("Duracion :");
			lblNewLabel_8_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_8_1_2_1.setBounds(22, 146, 84, 25);
		}
		return lblNewLabel_8_1_2_1;
	}

	private JSpinner getSpinnerDiasSemanas() {
		if (spinnerDiasSemanas == null) {
			spinnerDiasSemanas = new JSpinner();
			spinnerDiasSemanas.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinnerDiasSemanas.setEnabled(false);
			spinnerDiasSemanas.setBounds(113, 148, 30, 20);
		}
		return spinnerDiasSemanas;
	}

	private JRadioButton getRdbtnDiasPrescripcion() {
		if (rdbtnDiasPrescripcion == null) {
			rdbtnDiasPrescripcion = new JRadioButton("Dias");
			rdbtnDiasPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rdbtnDiasPrescripcion.isSelected() == true) {

						rdbtnSemanasPrescripcion.setSelected(false);
						rdbtnMesesPrescripcion.setSelected(false);
						rdbtnAnosPrescripcion.setSelected(false);
						rdbtnDiasPrescripcion.setSelected(true);
					}
					if (rdbtnDiasPrescripcion.isSelected() == false) {

						rdbtnDiasPrescripcion.setSelected(true);
					}
				}
			});
			rdbtnDiasPrescripcion.setEnabled(false);
			rdbtnDiasPrescripcion.setSelected(true);
			rdbtnDiasPrescripcion.setBackground(new Color(135, 206, 235));
			rdbtnDiasPrescripcion.setBounds(153, 147, 63, 23);
		}
		return rdbtnDiasPrescripcion;
	}

	private JRadioButton getRdbtnSemanasPrescripcion() {
		if (rdbtnSemanasPrescripcion == null) {
			rdbtnSemanasPrescripcion = new JRadioButton("Semanas");
			rdbtnSemanasPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (rdbtnSemanasPrescripcion.isSelected() == true) {

						rdbtnDiasPrescripcion.setSelected(false);
						rdbtnMesesPrescripcion.setSelected(false);
						rdbtnAnosPrescripcion.setSelected(false);
						rdbtnSemanasPrescripcion.setSelected(true);
					}
					if (rdbtnSemanasPrescripcion.isSelected() == false) {

						rdbtnDiasPrescripcion.setSelected(false);
						rdbtnMesesPrescripcion.setSelected(false);
						rdbtnAnosPrescripcion.setSelected(false);
						rdbtnSemanasPrescripcion.setSelected(true);
					}
				}
			});
			rdbtnSemanasPrescripcion.setEnabled(false);
			rdbtnSemanasPrescripcion.setBackground(new Color(135, 206, 235));
			rdbtnSemanasPrescripcion.setBounds(218, 147, 84, 23);
		}
		return rdbtnSemanasPrescripcion;
	}

	private JRadioButton getRdbtnMesesPrescripcion() {
		if (rdbtnMesesPrescripcion == null) {
			rdbtnMesesPrescripcion = new JRadioButton("Meses");
			rdbtnMesesPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rdbtnMesesPrescripcion.isSelected() == true) {

						rdbtnSemanasPrescripcion.setSelected(false);
						rdbtnDiasPrescripcion.setSelected(false);
						rdbtnAnosPrescripcion.setSelected(false);
						rdbtnMesesPrescripcion.setSelected(true);
					}
					if (rdbtnMesesPrescripcion.isSelected() == false) {

						rdbtnMesesPrescripcion.setSelected(true);
					}
				}
			});
			rdbtnMesesPrescripcion.setEnabled(false);
			rdbtnMesesPrescripcion.setBackground(new Color(135, 206, 235));
			rdbtnMesesPrescripcion.setBounds(304, 147, 84, 23);
		}
		return rdbtnMesesPrescripcion;
	}

	private JRadioButton getRdbtnAnosPrescripcion() {
		if (rdbtnAnosPrescripcion == null) {
			rdbtnAnosPrescripcion = new JRadioButton("A\u00F1os");
			rdbtnAnosPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rdbtnAnosPrescripcion.isSelected() == true) {

						rdbtnSemanasPrescripcion.setSelected(false);
						rdbtnMesesPrescripcion.setSelected(false);
						rdbtnDiasPrescripcion.setSelected(false);
						rdbtnAnosPrescripcion.setSelected(true);

					}
					if (rdbtnAnosPrescripcion.isSelected() == false) {

						rdbtnAnosPrescripcion.setSelected(true);

					}
				}
			});
			rdbtnAnosPrescripcion.setEnabled(false);
			rdbtnAnosPrescripcion.setBackground(new Color(135, 206, 235));
			rdbtnAnosPrescripcion.setBounds(390, 147, 84, 23);
		}
		return rdbtnAnosPrescripcion;
	}

	private JLabel getLblNewLabel_8_1_2_1_1() {
		if (lblNewLabel_8_1_2_1_1 == null) {
			lblNewLabel_8_1_2_1_1 = new JLabel("Notaciones adicionales :");
			lblNewLabel_8_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_8_1_2_1_1.setBounds(22, 193, 145, 25);
		}
		return lblNewLabel_8_1_2_1_1;
	}

	private JTextField getTextFieldNotasAdicionalesPrescripcion() {
		if (textFieldNotasAdicionalesPrescripcion == null) {
			textFieldNotasAdicionalesPrescripcion = new JTextField();
			textFieldNotasAdicionalesPrescripcion.setEnabled(false);
			textFieldNotasAdicionalesPrescripcion.setBounds(176, 195, 314, 20);
			textFieldNotasAdicionalesPrescripcion.setColumns(10);
		}
		return textFieldNotasAdicionalesPrescripcion;
	}

	
	private JButton getBtnCrearPrescripcionNueva() {
		if (btnCrearPrescripcionNueva == null) {
			btnCrearPrescripcionNueva = new JButton("Crear");
			btnCrearPrescripcionNueva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					crearPrescripcion = new CrearPrescripcion();

					prescripcionDTO = new PrescripcionDTO();
					
					prescripcionDTO.idPrescripcion = generarIdPrescripcion();

					if (textFieldInstrucciones.getText() != "") {
						prescripcionDTO.instruccion = textFieldInstrucciones.getText();

					} else {
						JOptionPane.showMessageDialog(textFieldInstrucciones,
								"El campo instrucciones no se puede dejar vacio");
					}

					String hora = spinnerHoraAsignacion.getValue().toString() + "";
					String minutos = spinnerMinutosAsignacion.getValue().toString() + "";
					String segundos = spinnerSegundosAsignacion.getValue().toString() + "";

					String horaAsignacion = hora + ":" + minutos + ":" + segundos;

					
					
					prescripcionDTO.horaAsignacion = horaAsignacion;
					
					prescripcionDTO.diaAsignacion = dateChooserPrescripcion.getDate();
					prescripcionDTO.esMedicamento=false;

					String dia = spinnerCantidadMedicamento.getValue().toString() + " dia/s";
					String semanas = spinnerCantidadMedicamento.getValue().toString() + " semana/s";
					String mes = spinnerCantidadMedicamento.getValue().toString() + " mes/es";
					String ano = spinnerCantidadMedicamento.getValue().toString() + " año/s";
					
					String diaIntervalo = spinnerIntervalo.getValue().toString() + " dia/s";
					String semanasIntervalo = spinnerIntervalo.getValue().toString() + " semana/s";
					String mesIntervalo = spinnerIntervalo.getValue().toString() + " mes/es";
					String anoIntervalo = spinnerIntervalo.getValue().toString() + " año/s";
					
					System.out.print(dia);
					if (rdbtnMedicamento.isSelected()) {
						prescripcionDTO.esMedicamento=true;
					}
					prescripcion = new Prescripcion(prescripcionDTO);
					crearPrescripcion.crearPrescripcion(prescripcion);

					if (rdbtnMedicamento.isSelected()) {

						
						medicamentoDTO = new MedicamentoDTO();
						
						medicamentoDTO.idMedicamento = generarIdMedicamento();

						medicamentoDTO.idPrescripcion= prescripcionDTO.idPrescripcion;
						if (textFieldNombreMedicamento.getText() != "") {
							medicamentoDTO.nombre = textFieldNombreMedicamento.getText();

						} else {
							JOptionPane.showMessageDialog(textFieldNombreMedicamento,
									"El campo instrucciones no se puede dejar vacio");
						}

						medicamentoDTO.cantidad = (int) spinnerCantidadMedicamento.getValue();
						
						if (rdbtnDiasIntervalo.isSelected()) {
							medicamentoDTO.intervalo = dia;
						}
						if (rdbtnSemanasIntervalo.isSelected()) {
							medicamentoDTO.intervalo = semanas;
						}
						if (rdbtnMesesIntervalo.isSelected()) {
							medicamentoDTO.intervalo = mes;
						}
						if (rdbtnAnosIntervalo.isSelected()) {
							medicamentoDTO.intervalo = ano;
						}
						
						if (rdbtnDiasPrescripcion.isSelected()) {
							medicamentoDTO.duracion = dia;
						}
						if (rdbtnSemanasPrescripcion.isSelected()) {
							medicamentoDTO.duracion = semanas;
						}
						if (rdbtnMesesPrescripcion.isSelected()) {
							medicamentoDTO.duracion = mes;
						}
						if (rdbtnAnosPrescripcion.isSelected()) {
							medicamentoDTO.duracion = ano;
						}

						if (textFieldNotasAdicionalesPrescripcion.getText() != "") {
							medicamentoDTO.anotacion = textFieldNotasAdicionalesPrescripcion.getText();

						} else {
							JOptionPane.showMessageDialog(textFieldNotasAdicionalesPrescripcion,
									"El campo instrucciones no se puede dejar vacio");
						}

						medicamento = new Medicamento(medicamentoDTO);
						
						crearMedicamento = new CrearMedicamento();

						crearMedicamento.crearMedicamento(medicamento);
						

					}
					
					
					 textFieldInstrucciones.setText("");
					 
					    PanelPrescripcion panel = new PanelPrescripcion(panelCrearPrescripcion,idmedico,idPaciente,idCita,panelContenido, panelAnterior, idObservador);
					    panelCrearPrescripcion .setVisible(false);
						panelContenido.add(panel);
						panel.setVisible(true);
					 
					 

				}

			
			});
			btnCrearPrescripcionNueva.setForeground(Color.GREEN);
			btnCrearPrescripcionNueva.setBounds(701, 470, 130, 35);
		}
		return btnCrearPrescripcionNueva;
	}
	
	private int generarIdMedicamento() {
		ListaMedicamentos lc = new ListaMedicamentos();
		lc.creaListaMedicamentos();
		return 4300 + lc.getMedicamentos().size();
	}
	
	private int generarIdPrescripcion() {
		ListaPrescripciones lc = new ListaPrescripciones();
		lc.creaListaPrescripciones();;
		return 4200 + lc.getPrescripciones().size();
	}
	
	
	
	

	private void mostrarPrescripciones() {

		listaPrescripciones = new ListaPrescripciones();

		listaPrescripciones.creaListaPrescripciones();

		for (Prescripcion p : listaPrescripciones.getPrescripciones()) {

			modeloListPrescripciones.addElement(p);

		}

	}

	

	private JButton getBtnCancelarCrearPrescripcionNueva() {
		if (btnCancelarCrearPrescripcionNueva == null) {
			btnCancelarCrearPrescripcionNueva = new JButton("Cancelar");
			btnCancelarCrearPrescripcionNueva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					closePanel();

				}
			});
			btnCancelarCrearPrescripcionNueva.setForeground(Color.RED);
			btnCancelarCrearPrescripcionNueva.setBounds(847, 470, 130, 35);
		}
		return btnCancelarCrearPrescripcionNueva;
	}

	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("Dia de asignacion : ");
			lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_9.setBounds(517, 91, 151, 24);
		}
		return lblNewLabel_9;
	}

	private JLabel getLblNewLabel_9_1() {
		if (lblNewLabel_9_1 == null) {
			lblNewLabel_9_1 = new JLabel("Hora de asignacion : ");
			lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_9_1.setBounds(517, 142, 151, 24);
		}
		return lblNewLabel_9_1;
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
			spinnerHoraAsignacion.setModel(new SpinnerNumberModel(0, 0, 24, 1));
			spinnerHoraAsignacion.setBounds(653, 145, 52, 20);
			spinnerHoraAsignacion.setValue(obtenerHoraActual());
		}
		return spinnerHoraAsignacion;
	}

	private JSpinner getSpinnerMinutosAsignacion() {
		if (spinnerMinutosAsignacion == null) {
			spinnerMinutosAsignacion = new JSpinner();
			spinnerMinutosAsignacion.setModel(new SpinnerNumberModel(0, 0, 59, 1));
			spinnerMinutosAsignacion.setBounds(725, 145, 52, 20);
			spinnerMinutosAsignacion.setValue(obtenerMinutosActual());
		}
		return spinnerMinutosAsignacion;
	}

	private JSpinner getSpinnerSegundosAsignacion() {
		if (spinnerSegundosAsignacion == null) {
			spinnerSegundosAsignacion = new JSpinner();
			spinnerSegundosAsignacion.setModel(new SpinnerNumberModel(0, 0, 59, 1));
			spinnerSegundosAsignacion.setBounds(797, 145, 52, 20);
			spinnerSegundosAsignacion.setValue(obtenerSegundosActual());
		}
		return spinnerSegundosAsignacion;
	}

	private JLabel getLblNewLabel_10() {
		if (lblNewLabel_10 == null) {
			lblNewLabel_10 = new JLabel(":");
			lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_10.setForeground(new Color(0, 0, 0));
			lblNewLabel_10.setBounds(787, 148, 22, 14);
		}
		return lblNewLabel_10;
	}

	private JLabel getLblNewLabel_10_1() {
		if (lblNewLabel_10_1 == null) {
			lblNewLabel_10_1 = new JLabel(":");
			lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_10_1.setBounds(715, 148, 22, 14);
		}
		return lblNewLabel_10_1;
	}

	private JDateChooser getDateChooserPrescripcion() {
		if (dateChooserPrescripcion == null) {
			dateChooserPrescripcion = new JDateChooser();

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
				dateChooserPrescripcion.setDate(date2);
				dateChooserPrescripcion.getJCalendar().setMinSelectableDate(date2);
				((JTextFieldDateEditor) dateChooserPrescripcion.getDateEditor()).setEditable(false);

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			dateChooserPrescripcion.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			dateChooserPrescripcion.setBounds(653, 95, 113, 20);
		}
		return dateChooserPrescripcion;
	}

	private JLabel getLblNewLabel_11() {
		if (lblNewLabel_11 == null) {
			lblNewLabel_11 = new JLabel("HH/mm/ss");
			lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_11.setBounds(874, 148, 85, 14);
		}
		return lblNewLabel_11;
	}

	private JLabel getLblNewLabel_12() {
		if (lblNewLabel_12 == null) {
			lblNewLabel_12 = new JLabel("");
			lblNewLabel_12
					.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ICONOS-AGENDA-Y-MEMORIA3.png")));
			lblNewLabel_12.setBounds(0, 0, 1103, 533);
		}
		return lblNewLabel_12;
	}
	
	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}
	private JRadioButton getRdbtnDiasIntervalo() {
		if (rdbtnDiasIntervalo == null) {
			rdbtnDiasIntervalo = new JRadioButton("Dias");
			rdbtnDiasIntervalo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rdbtnDiasIntervalo.isSelected() == true) {

						rdbtnSemanasIntervalo.setSelected(false);
						rdbtnMesesIntervalo.setSelected(false);
						rdbtnAnosIntervalo.setSelected(false);
						rdbtnDiasIntervalo.setSelected(true);
					}
					if (rdbtnDiasIntervalo.isSelected() == false) {

						rdbtnDiasIntervalo.setSelected(true);
					}
				}
			});
			rdbtnDiasIntervalo.setSelected(true);
			rdbtnDiasIntervalo.setEnabled(false);
			rdbtnDiasIntervalo.setBackground(new Color(135, 206, 235));
			rdbtnDiasIntervalo.setBounds(153, 106, 63, 23);
		}
		return rdbtnDiasIntervalo;
	}
	private JRadioButton getRdbtnSemanasIntervalo() {
		if (rdbtnSemanasIntervalo == null) {
			rdbtnSemanasIntervalo = new JRadioButton("Semanas");
			rdbtnSemanasIntervalo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rdbtnSemanasIntervalo.isSelected() == true) {

						rdbtnSemanasIntervalo.setSelected(true);
						rdbtnMesesIntervalo.setSelected(false);
						rdbtnAnosIntervalo.setSelected(false);
						rdbtnDiasIntervalo.setSelected(false);
					}
					if (rdbtnSemanasIntervalo.isSelected() == false) {

						rdbtnSemanasIntervalo.setSelected(true);
					}
				}
			});
			rdbtnSemanasIntervalo.setEnabled(false);
			rdbtnSemanasIntervalo.setBackground(new Color(135, 206, 235));
			rdbtnSemanasIntervalo.setBounds(218, 106, 84, 23);
		}
		return rdbtnSemanasIntervalo;
	}
	private JRadioButton getRdbtnMesesIntervalo() {
		if (rdbtnMesesIntervalo == null) {
			rdbtnMesesIntervalo = new JRadioButton("Meses");
			rdbtnMesesIntervalo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rdbtnMesesIntervalo.isSelected() == true) {

						rdbtnSemanasIntervalo.setSelected(false);
						rdbtnMesesIntervalo.setSelected(true);
						rdbtnAnosIntervalo.setSelected(false);
						rdbtnDiasIntervalo.setSelected(false);
					}
					if (rdbtnMesesIntervalo.isSelected() == false) {

						rdbtnMesesIntervalo.setSelected(true);
					}
				}
			});
			rdbtnMesesIntervalo.setEnabled(false);
			rdbtnMesesIntervalo.setBackground(new Color(135, 206, 235));
			rdbtnMesesIntervalo.setBounds(304, 106, 84, 23);
		}
		return rdbtnMesesIntervalo;
	}
	private JRadioButton getRdbtnAnosIntervalo() {
		if (rdbtnAnosIntervalo == null) {
			rdbtnAnosIntervalo = new JRadioButton("A\u00F1os");
			rdbtnAnosIntervalo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rdbtnAnosIntervalo.isSelected() == true) {

						rdbtnSemanasIntervalo.setSelected(false);
						rdbtnMesesIntervalo.setSelected(false);
						rdbtnAnosIntervalo.setSelected(true);
						rdbtnDiasIntervalo.setSelected(false);
					}
					if (rdbtnAnosIntervalo.isSelected() == false) {

						rdbtnAnosIntervalo.setSelected(true);
					}
				}
			});
			rdbtnAnosIntervalo.setEnabled(false);
			rdbtnAnosIntervalo.setBackground(new Color(135, 206, 235));
			rdbtnAnosIntervalo.setBounds(390, 106, 84, 23);
		}
		return rdbtnAnosIntervalo;
	}
	
	
	
	
	private JSpinner getSpinnerIntervalo() {
		if (spinnerIntervalo == null) {
			spinnerIntervalo = new JSpinner();
			spinnerIntervalo.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinnerIntervalo.setEnabled(false);
			spinnerIntervalo.setBounds(113, 106, 29, 20);
		}
		
		
		return spinnerIntervalo;							
					
	}
	
	
	
	
	
	
}
