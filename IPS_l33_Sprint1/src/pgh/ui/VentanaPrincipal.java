package pgh.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pgh.business.cita.Cita;
import pgh.business.cita.CitaDTO;
import pgh.business.cita.CrearCitas;
import pgh.business.cita.FindAllCitas;
import pgh.business.cita.ListaCitas;
import pgh.business.enfermero.Enfermero;
import pgh.business.enfermero.EnfermeroDTO;
import pgh.business.enfermero.ListaEnfermeros;
import pgh.business.jornadaenfermero.CrearJornadaEnfermero;
import pgh.business.jornadaenfermero.JornadaEnfermero;
import pgh.business.jornadaenfermero.JornadaEnfermeroDTO;
import pgh.business.jornadaenfermero.ListaJornadasEnfermero;
import pgh.business.jornadamedico.CrearJornadaMedico;
import pgh.business.jornadamedico.JornadaMedico;
import pgh.business.jornadamedico.JornadaMedicoDTO;
import pgh.business.jornadamedico.ListaJornadasMedico;
import pgh.business.medicamento.CrearMedicamento;
import pgh.business.medicamento.ListaMedicamentos;
import pgh.business.medicamento.Medicamento;
import pgh.business.medicamento.MedicamentoDTO;
import pgh.business.medico.ListaMedicos;
import pgh.business.medico.Medico;
import pgh.business.medicocita.CrearMedicoCita;
import pgh.business.medicocita.ListaMedicoCita;
import pgh.business.medicocita.MedicoCita;
import pgh.business.medicocita.MedicoCitaDTO;
import pgh.business.paciente.ListaPacientes;
import pgh.business.paciente.Paciente;
import pgh.business.prescripcion.CrearPrescripcion;
import pgh.business.prescripcion.ListaPrescripciones;
import pgh.business.prescripcion.Prescripcion;
import pgh.business.prescripcion.PrescripcionDTO;
import pgh.business.prescripcioncitapaciente.CrearPrescripcionCitaPaciente;
import pgh.business.prescripcioncitapaciente.FindAllPrescripcionesCitaPaciente;
import pgh.business.prescripcioncitapaciente.PrescripcionCitaPaciente;
import pgh.business.prescripcioncitapaciente.PrescripcionCitaPacienteDTO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import org.hsqldb.lib.tar.RB;

import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JDateChooser;
import javax.swing.SpinnerNumberModel;
import com.toedter.calendar.JTextFieldDateEditor;
import com.toedter.calendar.JYearChooser;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerDateModel;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelContenido;
	private JPanel panelPrincipal;
	private JLabel lblNewLabel;
	private JLabel lblCentroMedico;
	private JButton btnAdministrativo;
	private JButton btnEntrarComoMdico;
	private JButton btnAdministrativo_1_1;
	private JPanel panelAdministrativo;
	private JButton btnSalir;
	private JPanel panelMedico;
	private JPanel panelEnfermero;
	private JButton btnNewButton;
	private JPanel panelCitas;
	private JLabel lblMedicos;
	private JLabel lblPaciente;
	private JComboBox comboBoxAnoCita;
	private JLabel lblFecha;
	private JLabel lblHoraInicio;
	private JLabel lblHoraFin;
	private JLabel lblUbicacion;
	private JComboBox comboBoxUbicacion;
	private JComboBox comboBoxHorasFinCita;
	private JComboBox comboBoxHorasInicioCita;
	private JButton btnCrearCita;
	private JButton btncancelarCita;
	private JLabel lblNewLabel_1;
	private JComboBox comboBoxMinutosInicioCita;
	private JLabel lblNewLabel_2;
	private JComboBox comboBoxMinutosFinCita;
	private JLabel lblNewLabel_3;
	private JComboBox comboBoxMesCita;
	private JComboBox comboBoxFechaDia;
	private JComboBox comboBoxDiaDia;
	private ListaMedicos lm;
	private ListaPacientes lp;
	private JPanel panelJornadasMedico;
	private JButton btnAsignarJornadasMedicos;
	private JButton btnAsignarJornadasAEnfermeros;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_4_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6_1_1;
	private JLabel lblNewLabel_5_1_1;
	private JButton btnCrearJornadaMedico;
	private JButton btnCancelarJornadaMedico;
	private JScrollPane scrollPane;
	private JList listDias;
	private JButton btnA�adirDiasJornada;
	private JScrollPane scrollPaneDiasSeleccionados;
	private JButton btnBorrarDiasSeleccionados;
	private String dias = "";
	private boolean lunes = false, martes = false, miercoles = false, jueves = false, viernes = false, sabado = false,
			domingo = false;
	private JScrollPane scrollPaneMedicos;
	private JButton btnAnadirMedicos;
	private JList listMedicos;
	private JScrollPane scrollPaneMedicosAnadidos;
	private JList listMedicosAnadidos;
	private DefaultListModel<Medico> modeloListMedicos;
	private DefaultListModel<Medico> modeloListMedicosAnadidos;
	private DefaultListModel<Paciente> modeloListPacientesCita;
	private DefaultListModel<Paciente> modeloListPacienteCita;
	private DefaultListModel<String> modeloListDiasJornada;
	private DefaultListModel<String> modeloListDiasSeleccionadosJornadaMedico;
	private DefaultListModel<Medico> modeloListMedicosSeleccionadosJornada;
	private DefaultListModel<Prescripcion> modeloListPrescripciones;
	private JScrollPane scrollPane_1;
	private JList listPacientesCita;
	private CitaDTO citaDTO;
	private Cita cita;
	private CrearCitas crearCitas;
	private JButton btnAnadirPacienteListaCita;
	private JScrollPane scrollPanePacienteSeleccionado;
	private JList listPacienteSeleccionado;
	private ListaMedicoCita listaMedicoCita;
	private int contador;
	private JList listDiasSeleccionadosJornadaMedico;
	private JScrollPane scrollPaneSeleccionarMedicoJornada;
	private JList listMedicosJornada;
	private JButton btnAnadirMedicoJornadas;
	private JScrollPane scrollPaneMedicoSeleccionadoJornada;
	private JList listMedicosSeleccionadosJornada;
	private JButton btnNewButton_1;
	private JButton btnIndicarPrescripcion;
	private JPanel panelPrescripcion;
	private JButton btnAnadirNuevaPrescripcion;
	private JScrollPane scrollPanePrescripciones;
	private JButton btnAnadirPrescripcion;
	private JScrollPane scrollPanePrescripcionSeleccionada;
	private JButton btnBorrarPrescripcion;
	private JList listPrescripciones;
	private JList listPrescripcionSeleccionada;
	private JButton btnAsignarPrescripcion;
	private JButton btnCancelarPrescripcion;
	private JPanel panelCrearPrescripcion;
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
	private JComboBox comboBoxIntervalo;
	private JLabel lblNewLabel_8_1_2_1;
	private JSpinner spinnerDiasSemanas;
	private JRadioButton rdbtnDiasPrescripcion;
	private JRadioButton rdbtnSemanasPrescripcion;
	private JRadioButton rdbtnMesesPrescripcion;
	private JRadioButton rdbtnAnosPrescripcion;
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
	private JDateChooser dateChooserPrescripcion;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private DefaultListModel<Prescripcion> modeloListPrescripcionesSeleccionada;
	private PrescripcionDTO prescripcionDTO;
	private Prescripcion prescripcion;
	private MedicamentoDTO medicamentoDTO;
	private Medicamento medicamento;
	private CrearMedicamento crearMedicamento;
	private JList listPacientesPrescripcion;
	private DefaultListModel<Paciente> modeloListaPacientesPrescripcion;
	private JPanel panelElegirCita;
	private JButton btnEliminarCitaElegida;
	private JButton btnTerminarProceso;
	private JButton btnCancelarProceso;

	private PrescripcionCitaPaciente prescripcionCitaPaciente;
	private PrescripcionCitaPacienteDTO prescripcionCitaPacienteDTO;
	private CrearPrescripcionCitaPaciente crearPrescripcionCitaPaciente;

	private MedicoCita medicoCita;
	private MedicoCitaDTO medicoCitaDTO;
	private CrearMedicoCita crearMedicoCita;
	private JPanel panelLoginMedico;
	private JScrollPane scrollPane_4;
	
	private CrearPrescripcion crearPrescripcion;
	private boolean fechaCambiada4;
	private boolean fechaCambiada3;
	private DefaultListModel<Medico> modeloListaMedicosLogin;
	private DefaultListModel<Medico> modeloListaMedicosLogueados;
	private int id_medico;
	private JList listMedicosLogin;
	private JButton btnSeleccionarMedicoLogin;
	private JScrollPane scrollPane_5;
	private JList listMedicoLogueado;
	private JButton btnEliminarMedicoLogueado;
	private JButton btnSiguienteLogin;
	private JScrollPane scrollPane_6;
	private JTextArea textAreaMedicinaInformacion;
	private JLabel lblNewLabel_13;
	private JScrollPane scrollPane_7;
	private JList listpacienteSeleccionadoPrescripcion;
	private DefaultListModel<Paciente> modeloListaPacienteSeleccionadoPrescripcion;
	private DefaultListModel<Cita> modelListaCitasMedicoPaciente;
	private DefaultListModel<Cita> modelListaCitaMedicoPacienteElegida;
	private int id_prescripcion;
	private ListaEnfermeros le;
	private CrearJornadaEnfermero crearJornadaEnfermero;
	private ListaMedicamentos listaMedicamentos;
	private JList listCitasMedicoPaciente;
	private JList listCitaElegida;
	private int id_paciente;
	private ListaCitas listaCitas;
	private FindAllCitas findAllCitas;
	private JButton btnEliminarPacientePrescripcion;
	private JLabel lblNewLabel_5_1;
	private JDateChooser dateChooserFechaInicioJornadaMedico;
	private JDateChooser dateChooserFechaFinJornadaMedico;
	private JSpinner spinnerHoraInicioJornadamedico;
	private JSpinner spinnerHoraFinJornadamedico;
	private JSpinner spinnerMinutosFinJornadamedico_1;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_6_1;
	private JSpinner spinnerMinutosInicioJornadamedico;
	private JSpinner spinnerMinutosInicioJornadamedico2;
	private JSpinner spinnerMinutosFinJornadamedico2;
	private boolean fechaCambiada;
	private boolean fechaCambiada2;
	private CrearJornadaMedico crearJornadaMedico;
	private JornadaMedico jornadaMedico;
	private JornadaMedicoDTO jornadaMedicoDTO;

	private JornadaEnfermero jornadaEnfermero;
	private JornadaEnfermeroDTO jornadaEnfermeroDTO;
	private JPanel panelJornadasEnfermero;
	private JPanel panelJornadasEnfermero1;
	private JLabel lblNewLabel_4_2;
	private JLabel lblNewLabel_4_1_1;
	private JLabel lblNewLabel_5_2;
	private JLabel lblNewLabel_6_1_1_1;
	private JLabel lblNewLabel_5_1_1_1;
	private JButton btnCrearJornadaEnfermero;
	private JButton btnCancelarJornadaEnfermero;
	private JScrollPane scrollPane_8;
	private JButton btnA�adirDiasJornadaEnfermero;
	private JScrollPane scrollPaneDiasSeleccionados_1;
	private JButton btnBorrarDiasSeleccionadosJornadaEnfermero;
	private JScrollPane scrollPaneSeleccionarEnfermero;
	private JButton btnAnadirEnfermeroJornadas;
	private JScrollPane scrollPaneEnfermeroSeleccionadoJornada_1;
	private JButton btnBorrarEnfermeroJornadas;
	private JLabel lblNewLabel_5_1_2;
	private JDateChooser dateChooserFechaInicioJornadaEnfermero;
	private JDateChooser dateChooserFechaFinJornadaEnfermero;
	private JSpinner spinnerHoraInicioJornadaEnfermero;
	private JSpinner spinnerHoraFinJornadaEnfermero;
	private JSpinner spinnerMinutosFinJornadaeEnfermero;
	private JLabel lblNewLabel_6_2;
	private JLabel lblNewLabel_6_1_2;
	private JSpinner spinnerMinutosInicioJornadaEnfermero;
	private JSpinner spinnerMinutosInicioJornadaEnfermero2;
	private JSpinner spinnerMinutosFinJornadaEnfermero2;
	private JList listEnfermerosJornada;
	private JList listEnfermerosSeleccionadosJornada;
	private JList listDiasSemanaJornadaEnfermero;
	private JList listDiasSeleccionadosJornadaEnfermero;
	private DefaultListModel<Enfermero> modeloListaEnfermerosJornada;
	private DefaultListModel<Enfermero> modeloListaEnfermerosSeleccionadosJornada;
	
	private DefaultListModel<String> modeloDiasSemanaJornadaEnfermero;
	private DefaultListModel<String> modeloDiasSemanaSeleccionadosJornadaEnfermero;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setResizable(false);
		setTitle("Gestor Hospital");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1129, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelContenido(), BorderLayout.CENTER);

	}

	private JPanel getPanelContenido() {
		if (panelContenido == null) {
			panelContenido = new JPanel();
			panelContenido.setBackground(Color.WHITE);
			panelContenido.setLayout(new CardLayout(0, 0));
			panelContenido.add(getPanelPrincipal(), "name_185722150351700");
			panelContenido.add(getPanelAdministrativo(), "name_186082169172900");
			panelContenido.add(getPanelMedico(), "name_186456591110200");
			panelContenido.add(getPanelEnfermero(), "name_186491911563700");
			panelContenido.add(getPanelCitas(), "name_190322796624300");
			panelContenido.add(getPanelJornadasMedico(), "name_328185980980700");
			panelContenido.add(getPanelPrescripcion(), "name_88672483873800");
			panelContenido.add(getPanelCrearPrescripcion(), "name_89559032849200");
			panelContenido.add(getPanelElegirCita(), "name_98460094904300");
			panelContenido.add(getPanelLoginMedico(), "name_119791109586100");
			panelContenido.add(getPanelJornadasEnfermero(), "name_200856728113900");
		}
		return panelContenido;
	}

	private JPanel getPanelPrincipal() {
		if (panelPrincipal == null) {
			panelPrincipal = new JPanel();
			panelPrincipal.setBackground(Color.WHITE);
			panelPrincipal.setLayout(null);
			panelPrincipal.add(getLblNewLabel());
			panelPrincipal.add(getLblCentroMedico());
			panelPrincipal.add(getBtnAdministrativo());
			panelPrincipal.add(getBtnEntrarComoMdico());
			panelPrincipal.add(getBtnAdministrativo_1_1());
		}
		return panelPrincipal;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/cruz.png")));
			lblNewLabel.setBounds(821, 22, 217, 209);
		}
		return lblNewLabel;
	}

	private JLabel getLblCentroMedico() {
		if (lblCentroMedico == null) {
			lblCentroMedico = new JLabel("CENTRO MEDICO");
			lblCentroMedico.setFont(new Font("Sitka Small", Font.PLAIN, 40));
			lblCentroMedico.setBounds(329, 98, 404, 52);
		}
		return lblCentroMedico;
	}

	private JButton getBtnAdministrativo() {
		if (btnAdministrativo == null) {
			btnAdministrativo = new JButton("Entrar como administrativo");
			btnAdministrativo.setFocusable(false);
			btnAdministrativo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					cambiarPanel("panelAdministrativo");
				}
			});
			btnAdministrativo.setBackground(Color.RED);
			btnAdministrativo.setForeground(Color.WHITE);
			btnAdministrativo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnAdministrativo.setBounds(362, 220, 286, 52);
		}
		return btnAdministrativo;
	}

	private JButton getBtnEntrarComoMdico() {
		if (btnEntrarComoMdico == null) {
			btnEntrarComoMdico = new JButton("Entrar como m\u00E9dico");
			btnEntrarComoMdico.setFocusable(false);
			btnEntrarComoMdico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					cambiarPanel("panelLoginMedico");
				}
			});
			btnEntrarComoMdico.setForeground(Color.WHITE);
			btnEntrarComoMdico.setBackground(Color.RED);
			btnEntrarComoMdico.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnEntrarComoMdico.setBounds(362, 298, 286, 52);
		}
		return btnEntrarComoMdico;
	}

	private JButton getBtnAdministrativo_1_1() {
		if (btnAdministrativo_1_1 == null) {
			btnAdministrativo_1_1 = new JButton("Entrar como enfermero");
			btnAdministrativo_1_1.setFocusable(false);
			btnAdministrativo_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanel("panelEnfermero");
				}
			});
			btnAdministrativo_1_1.setForeground(Color.WHITE);
			btnAdministrativo_1_1.setBackground(Color.RED);
			btnAdministrativo_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnAdministrativo_1_1.setBounds(362, 380, 286, 52);
		}
		return btnAdministrativo_1_1;
	}

	private JPanel getPanelAdministrativo() {
		if (panelAdministrativo == null) {
			panelAdministrativo = new JPanel();
			panelAdministrativo.setBackground(Color.WHITE);
			panelAdministrativo.setLayout(null);
			panelAdministrativo.add(getBtnSalir());
			panelAdministrativo.add(getBtnNewButton());
			panelAdministrativo.add(getBtnAsignarJornadasMedicos());
			panelAdministrativo.add(getBtnAsignarJornadasAEnfermeros());
		}
		return panelAdministrativo;
	}

	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.setFocusable(false);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnSalir.setBackground(Color.RED);
			btnSalir.setForeground(Color.WHITE);
			btnSalir.setBounds(862, 450, 115, 38);
		}
		return btnSalir;
	}

	private void cambiarPanel(String nombre) {

		if (nombre == "panelPrincipal") {
			panelPrincipal.setVisible(true);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
			panelElegirCita.setVisible(false);
			panelJornadasEnfermero.setVisible(false);

		} else if (nombre == "panelAdministrativo") {
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(true);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
			panelElegirCita.setVisible(false);
			panelJornadasEnfermero.setVisible(false);

		} else if (nombre == "panelMedico") {
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(true);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
			panelElegirCita.setVisible(false);
			panelJornadasEnfermero.setVisible(false);
		} else if (nombre == "panelEnfermero") {
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(true);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
			panelElegirCita.setVisible(false);
			panelJornadasEnfermero.setVisible(false);

		} else if (nombre == "panelCitas") {
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(true);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
			panelElegirCita.setVisible(false);
			panelJornadasEnfermero.setVisible(false);

		} else if (nombre == "panelJornadas") {
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(true);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
			panelElegirCita.setVisible(false);
			panelJornadasEnfermero.setVisible(false);

		} else if (nombre == "panelPrescripcion") {
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(true);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
			panelElegirCita.setVisible(false);
			panelJornadasEnfermero.setVisible(false);

		} else if (nombre == "panelCrearPrescripcion") {
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(true);
			panelLoginMedico.setVisible(false);
			panelElegirCita.setVisible(false);
			panelJornadasEnfermero.setVisible(false);

		} else if (nombre == "panelLoginMedico") {
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(true);
			panelElegirCita.setVisible(false);
			panelJornadasEnfermero.setVisible(false);

		}
		else if (nombre == "panelElegirCita") {
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
			panelElegirCita.setVisible(true);
			panelJornadasEnfermero.setVisible(false);

		}
		else if (nombre == "panelJornadasEnfermero") {
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
			panelElegirCita.setVisible(false);
			panelJornadasEnfermero.setVisible(true);

		}
	}

	private JPanel getPanelMedico() {
		if (panelMedico == null) {
			panelMedico = new JPanel();
			panelMedico.setBackground(Color.WHITE);
			panelMedico.setLayout(null);
			panelMedico.add(getBtnIndicarPrescripcion());
		}
		return panelMedico;
	}

	private JPanel getPanelEnfermero() {
		if (panelEnfermero == null) {
			panelEnfermero = new JPanel();
			panelEnfermero.setBackground(Color.WHITE);
		}
		return panelEnfermero;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Asignar Citas");
			btnNewButton.setFocusable(false);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanel("panelCitas");
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton.setBounds(45, 54, 147, 38);
		}
		return btnNewButton;
	}

	private JPanel getPanelCitas() {
		if (panelCitas == null) {
			panelCitas = new JPanel();
			panelCitas.setBackground(Color.WHITE);
			panelCitas.setLayout(null);
			panelCitas.add(getLblMedicos());
			panelCitas.add(getLblPaciente());
			panelCitas.add(getComboBoxAnoCita());
			panelCitas.add(getLblFecha());
			panelCitas.add(getLblHoraInicio());
			panelCitas.add(getLblHoraFin());
			panelCitas.add(getLblUbicacion());
			panelCitas.add(getComboBoxUbicacion());
			panelCitas.add(getComboBoxHorasInicioCita());
			panelCitas.add(getComboBoxHorasFinCita());
			panelCitas.add(getBtnCrearCita());
			panelCitas.add(getBtncancelarCita());
			panelCitas.add(getLblNewLabel_1());
			panelCitas.add(getComboBoxMinutosInicioCita());
			panelCitas.add(getLblNewLabel_2());
			panelCitas.add(getComboBox_1());
			panelCitas.add(getLblNewLabel_3());
			panelCitas.add(getComboBoxMesCita());
			panelCitas.add(getComboBoxDiaDia());
			panelCitas.add(getScrollPaneMedicos());
			panelCitas.add(getBtnAnadirMedicos());
			panelCitas.add(getScrollPaneMedicosAnadidos());
			panelCitas.add(getScrollPane_1());
			panelCitas.add(getBtnAnadirPacienteListaCita());
			panelCitas.add(getScrollPanePacienteSeleccionado());
		}
		return panelCitas;
	}

	private JLabel getLblMedicos() {
		if (lblMedicos == null) {
			lblMedicos = new JLabel("Seleccionar Medicos :");
			lblMedicos.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblMedicos.setBounds(83, 236, 211, 22);
		}
		return lblMedicos;
	}

	private JLabel getLblPaciente() {
		if (lblPaciente == null) {
			lblPaciente = new JLabel("Seleccionar Paciente :");
			lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPaciente.setBounds(83, 141, 211, 22);
		}
		return lblPaciente;
	}

	private JComboBox getComboBoxAnoCita() {
		if (comboBoxAnoCita == null) {
			comboBoxAnoCita = new JComboBox();
			comboBoxAnoCita.setFocusable(false);
			comboBoxAnoCita.setBounds(321, 330, 100, 22);
			String[] listaA�os = new String[5];
			for (int i = 0; i < listaA�os.length; i++) {
				listaA�os[i] = String.valueOf(2021 + i);
			}
			comboBoxAnoCita.setModel(new DefaultComboBoxModel<String>(listaA�os));
		}
		return comboBoxAnoCita;
	}

	private JLabel getLblFecha() {
		if (lblFecha == null) {
			lblFecha = new JLabel("Seleccionar Fecha  :");
			lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblFecha.setBounds(83, 326, 191, 22);
		}
		return lblFecha;
	}

	private JLabel getLblHoraInicio() {
		if (lblHoraInicio == null) {
			lblHoraInicio = new JLabel("Hora Inicio :");
			lblHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblHoraInicio.setBounds(709, 326, 116, 22);
		}
		return lblHoraInicio;
	}

	private JLabel getLblHoraFin() {
		if (lblHoraFin == null) {
			lblHoraFin = new JLabel("Hora Fin :");
			lblHoraFin.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblHoraFin.setBounds(709, 380, 95, 22);
		}
		return lblHoraFin;
	}

	private JLabel getLblUbicacion() {
		if (lblUbicacion == null) {
			lblUbicacion = new JLabel("Ubicacion :");
			lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblUbicacion.setBounds(83, 380, 109, 22);
		}
		return lblUbicacion;
	}

	private JComboBox getComboBoxUbicacion() {
		if (comboBoxUbicacion == null) {
			comboBoxUbicacion = new JComboBox();
			comboBoxUbicacion.setFocusable(false);
			comboBoxUbicacion.setBounds(320, 380, 347, 22);
			String[] consultas = new String[10];
			for (int i = 0; i < consultas.length; i++) {
				int suma = i + 1;
				consultas[i] = "Consulta " + suma;
			}
			comboBoxUbicacion.setModel(new DefaultComboBoxModel<String>(consultas));
		}
		return comboBoxUbicacion;
	}

	private JComboBox getComboBoxHorasFinCita() {
		if (comboBoxHorasFinCita == null) {
			comboBoxHorasFinCita = new JComboBox();
			comboBoxHorasFinCita.setFocusable(false);
			comboBoxHorasFinCita.setBounds(840, 384, 57, 22);
			String[] horas = new String[2];
			horas[0] = "08";
			horas[1] = "09";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		return comboBoxHorasFinCita;
	}

	private void hastaQueHora(Object selectedItem) {

		String horaInicial = (String) selectedItem;
		String[] horas = new String[2];
		System.out.print(horaInicial);
		if (horaInicial.contains("09")) {
			horas[0] = "09";
			horas[1] = "10";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		if (horaInicial.contains("10")) {
			horas[0] = "10";
			horas[1] = "11";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}

		if (horaInicial.contains("11")) {
			horas[0] = "11";
			horas[1] = "12";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}

		if (horaInicial.contains("12")) {
			horas[0] = "12";
			horas[1] = "13";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}

		if (horaInicial.contains("13")) {
			horas[0] = "13";
			horas[1] = "14";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}

		if (horaInicial.contains("14")) {
			horas[0] = "14";
			horas[1] = "15";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}

		if (horaInicial.contains("15")) {
			horas[0] = "15";
			horas[1] = "16";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		if (horaInicial.contains("16")) {
			horas[0] = "16";
			horas[1] = "17";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		if (horaInicial.contains("17")) {
			horas[0] = "17";
			horas[1] = "18";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		if (horaInicial.contains("18")) {
			horas[0] = "18";
			horas[1] = "19";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		if (horaInicial.contains("19")) {
			horas[0] = "19";
			horas[1] = "20";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}

	}

	private JComboBox getComboBoxHorasInicioCita() {
		if (comboBoxHorasInicioCita == null) {
			comboBoxHorasInicioCita = new JComboBox();
			comboBoxHorasInicioCita.setFocusable(false);
			comboBoxHorasInicioCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					hastaQueHora(comboBoxHorasInicioCita.getSelectedItem());
				}
			});
			comboBoxHorasInicioCita.setModel(new DefaultComboBoxModel(
					new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" }));
			comboBoxHorasInicioCita.setBounds(840, 330, 57, 22);

		}
		return comboBoxHorasInicioCita;
	}

	private JButton getBtnCrearCita() {
		if (btnCrearCita == null) {
			btnCrearCita = new JButton("Crear Cita");
			btnCrearCita.setFocusable(false);
			btnCrearCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Paciente paciente = (Paciente) listPacientesCita.getSelectedValue();
					int idPaciente = paciente.getIdPaciente();

					List<CitaDTO> citasDto = new ArrayList<CitaDTO>();
					List<Cita> citas = new ArrayList<Cita>();

					crearCitas = new CrearCitas();
					citaDTO = new CitaDTO();

					citaDTO.idCita = 400;

					// VALORES PARA QUE METAIS VUESTRA PARTE DE CREAR CITA

					citaDTO.asistencia = false;
					citaDTO.idPaciente = idPaciente;
		

					SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy/MM/dd");
					Date date;
					try {
						date = dateformat3.parse("2021/03/27");
						citaDTO.fecha = date;
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

//						 cita = new Cita(citaDTO);

					// ASEGURARSE DE QUE EN EL CITADTO ESTAN TODOS LOS VALORES DE LA TABLA CITA
					// ANTES DE CREAR LA CITA
//						 crearCitas.crearCita(cita);

					// HISTORIA ALBERTO
//					 for(int i=0; i<modeloListMedicosAnadidos.getSize(); i++) {
//						 
//						 
//						 medicoCitaDTO= new MedicoCitaDTO(); 
//						 
//						 medicoCitaDTO.idCita=generarIdMedicoCitas();  //el id cita de la cita creada previamente
//						 Medico m = modeloListMedicosAnadidos.getElementAt(i);
//						 medicoCitaDTO.idMedico = m.getIdMedico();
//						 
//						 medicoCita = new MedicoCita(medicoCitaDTO);
//						 crearMedicoCita = new CrearMedicoCita();
//						 
//						 crearMedicoCita.crearMedicoCita(medicoCita);
//						 			 
//						  
//					 }

				}
			});
			btnCrearCita.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCrearCita.setBounds(719, 468, 125, 23);
		}
		return btnCrearCita;
	}
	
	private int generarIdMedicoCitas() {
		ListaMedicoCita lc = new ListaMedicoCita();
		lc.creaListaMedicoCitas();
		return 2200 + lc.getMedicoCitas().size();
	}
	

	private JButton getBtncancelarCita() {
		if (btncancelarCita == null) {
			btncancelarCita = new JButton("Cancelar");
			btncancelarCita.setFocusable(false);
			btncancelarCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanel("panelAdministrativo");
				}
			});
			btncancelarCita.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btncancelarCita.setBounds(854, 468, 116, 23);
		}
		return btncancelarCita;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("CREAR CITA");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
			lblNewLabel_1.setBounds(380, 28, 235, 46);
		}
		return lblNewLabel_1;
	}

	private JComboBox getComboBoxMinutosInicioCita() {
		if (comboBoxMinutosInicioCita == null) {
			comboBoxMinutosInicioCita = new JComboBox();
			comboBoxMinutosInicioCita.setFocusable(false);
			comboBoxMinutosInicioCita.setModel(new DefaultComboBoxModel(new String[] { "00", "15", "30", "45" }));
			comboBoxMinutosInicioCita.setBounds(923, 330, 57, 22);
		}
		return comboBoxMinutosInicioCita;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel(":");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_2.setBounds(907, 323, 12, 29);
		}
		return lblNewLabel_2;
	}

	private JComboBox getComboBox_1() {
		if (comboBoxMinutosFinCita == null) {
			comboBoxMinutosFinCita = new JComboBox();
			comboBoxMinutosFinCita.setFocusable(false);
			comboBoxMinutosFinCita.setModel(new DefaultComboBoxModel(new String[] { "00", "15", "30", "45" }));
			comboBoxMinutosFinCita.setBounds(923, 384, 57, 22);
		}
		return comboBoxMinutosFinCita;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel(":");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_3.setBounds(907, 382, 21, 18);
		}
		return lblNewLabel_3;
	}

	private JComboBox getComboBoxMesCita() {
		if (comboBoxMesCita == null) {
			comboBoxMesCita = new JComboBox();
			comboBoxMesCita.setFocusable(false);
			comboBoxMesCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					cambiarDias(comboBoxMesCita.getSelectedItem());
				}
			});

			comboBoxMesCita.setModel(new DefaultComboBoxModel(
					new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
			comboBoxMesCita.setBounds(441, 330, 100, 22);

		}
		return comboBoxMesCita;
	}

	private void cambiarDias(Object selectedItem) {
		String[] dias31 = new String[31];
		String[] dias30 = new String[30];
		String[] dias29 = new String[29];
		String mes = (String) selectedItem;
		if (mes.contains("01") || mes.contains("03") || mes.contains("05") || mes.contains("07") || mes.contains("08")
				|| mes.contains("10") || mes.contains("12")) {
			for (int i = 1; i < 32; i++) {
				if (i < 10) {
					dias31[i - 1] = "0" + String.valueOf(i);
				} else {
					dias31[i - 1] = String.valueOf(i);
				}
			}
			comboBoxDiaDia.setModel(new DefaultComboBoxModel<String>(dias31));
		}
		if (mes.contains("02")) {
			for (int i = 1; i < 30; i++) {
				if (i < 10) {
					dias29[i - 1] = "0" + String.valueOf(i);
				} else {
					dias29[i - 1] = String.valueOf(i);
				}
			}
			comboBoxDiaDia.setModel(new DefaultComboBoxModel<String>(dias29));
		}
		if (mes.contains("04") || mes.contains("06") || mes.contains("09") || mes.contains("11")) {
			for (int i = 1; i < 31; i++) {
				if (i < 10) {
					dias30[i - 1] = "0" + String.valueOf(i);
				} else {
					dias30[i - 1] = String.valueOf(i);
				}
			}
			comboBoxDiaDia.setModel(new DefaultComboBoxModel<String>(dias30));
		}

	}

	private JComboBox getComboBoxDiaDia() {
		if (comboBoxDiaDia == null) {
			comboBoxDiaDia = new JComboBox();
			comboBoxDiaDia.setFocusable(false);
			comboBoxDiaDia.setBounds(573, 330, 94, 22);
			String[] dias31 = new String[31];
			for (int i = 1; i < 32; i++) {
				if (i < 10) {
					dias31[i - 1] = "0" + String.valueOf(i);
				} else {
					dias31[i - 1] = String.valueOf(i);
				}
			}
			comboBoxDiaDia.setModel(new DefaultComboBoxModel<String>(dias31));

		}
		return comboBoxDiaDia;
	}

	private JPanel getPanelJornadasMedico() {
		if (panelJornadasMedico == null) {
			panelJornadasMedico = new JPanel();
			panelJornadasMedico.setBackground(new Color(135, 206, 235));
			panelJornadasMedico.setLayout(null);
			panelJornadasMedico.add(getLblNewLabel_4());
			panelJornadasMedico.add(getLblNewLabel_4_1());
			panelJornadasMedico.add(getLblNewLabel_5());
			panelJornadasMedico.add(getLblNewLabel_6_1_1());
			panelJornadasMedico.add(getLblNewLabel_5_1_1());
			panelJornadasMedico.add(getBtnCrearJornadaMedico());
			panelJornadasMedico.add(getBtnCancelarJornadaMedico());
			panelJornadasMedico.add(getScrollPane());
			panelJornadasMedico.add(getBtnA�adirDiasJornada());
			panelJornadasMedico.add(getScrollPaneDiasSeleccionados());
			panelJornadasMedico.add(getBtnBorrarDiasSeleccionados());
			panelJornadasMedico.add(getScrollPaneSeleccionarMedicoJornada());
			panelJornadasMedico.add(getBtnAnadirMedicoJornadas());
			panelJornadasMedico.add(getScrollPaneMedicoSeleccionadoJornada());
			panelJornadasMedico.add(getBtnNewButton_1());
			panelJornadasMedico.add(getLblNewLabel_5_1_2());
			panelJornadasMedico.add(getDateChooserFechaInicioJornadaMedico());
			panelJornadasMedico.add(getDateChooserFechaFinJornadaMedico());
			panelJornadasMedico.add(getSpinnerHoraInicioJornadamedico());
			panelJornadasMedico.add(getSpinnerHoraFinJornadamedico());
			panelJornadasMedico.add(getSpinnerMinutosFinJornadamedico_1());
			panelJornadasMedico.add(getLblNewLabel_6());
			panelJornadasMedico.add(getLblNewLabel_6_1());
			panelJornadasMedico.add(getSpinnerMinutosInicioJornadamedico());
			panelJornadasMedico.add(getSpinnerMinutosInicioJornadamedico2());
			panelJornadasMedico.add(getSpinnerMinutosFinJornadamedico2());
			panelJornadasMedico.add(getLblNewLabel_14());
		}
		return panelJornadasMedico;
	}

	private JButton getBtnAsignarJornadasMedicos() {
		if (btnAsignarJornadasMedicos == null) {
			btnAsignarJornadasMedicos = new JButton("Asignar Jornadas a Medicos");
			btnAsignarJornadasMedicos.setFocusable(false);
			btnAsignarJornadasMedicos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanel("panelJornadas");
				}
			});
			btnAsignarJornadasMedicos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnAsignarJornadasMedicos.setBounds(227, 54, 235, 38);
		}
		return btnAsignarJornadasMedicos;
	}

	private JButton getBtnAsignarJornadasAEnfermeros() {
		if (btnAsignarJornadasAEnfermeros == null) {
			btnAsignarJornadasAEnfermeros = new JButton("Asignar Jornadas a Enfermeros");
			btnAsignarJornadasAEnfermeros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					cambiarPanel("panelJornadasEnfermero");
				}
			});
			btnAsignarJornadasAEnfermeros.setFocusable(false);
			btnAsignarJornadasAEnfermeros.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnAsignarJornadasAEnfermeros.setBounds(495, 54, 265, 38);
		}
		return btnAsignarJornadasAEnfermeros;
	}

	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Seleccionar Medico :");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_4.setBounds(72, 74, 147, 22);
		}
		return lblNewLabel_4;
	}

	private JLabel getLblNewLabel_4_1() {
		if (lblNewLabel_4_1 == null) {
			lblNewLabel_4_1 = new JLabel("Seleccionar dias a la semana :");
			lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_4_1.setBounds(195, 378, 200, 22);
		}
		return lblNewLabel_4_1;
	}

	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("Seleccionar dia inicio :");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5.setBounds(85, 189, 158, 22);
		}
		return lblNewLabel_5;
	}

	private JLabel getLblNewLabel_6_1_1() {
		if (lblNewLabel_6_1_1 == null) {
			lblNewLabel_6_1_1 = new JLabel("Seleccionar hora inicio :");
			lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_1_1.setBounds(712, 189, 158, 22);
		}
		return lblNewLabel_6_1_1;
	}

	private JLabel getLblNewLabel_5_1_1() {
		if (lblNewLabel_5_1_1 == null) {
			lblNewLabel_5_1_1 = new JLabel("Seleccionar hora fin :");
			lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5_1_1.setBounds(712, 257, 142, 22);
		}
		return lblNewLabel_5_1_1;
	}

	private JButton getBtnCrearJornadaMedico() {
		if (btnCrearJornadaMedico == null) {
			btnCrearJornadaMedico = new JButton("Crear jornada");
			btnCrearJornadaMedico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String dias="";
					int horaInicio = (int) spinnerHoraInicioJornadamedico.getValue();
					int horaFin = (int) spinnerHoraFinJornadamedico.getValue();
					int minutos1Inicio = (int) spinnerMinutosInicioJornadamedico.getValue();
					int minutos2Inicio = (int) spinnerMinutosInicioJornadamedico2.getValue();
					int minutos1Fin = (int) spinnerMinutosFinJornadamedico_1.getValue();
					int minutos2Fin = (int) spinnerMinutosFinJornadamedico2.getValue();
						
					if (comprobarCorrecto(horaInicio, horaFin, minutos1Inicio, minutos2Inicio, minutos1Fin,
							minutos2Fin)) {

						crearJornadaMedico = new CrearJornadaMedico();
						jornadaMedicoDTO = new JornadaMedicoDTO();
						jornadaMedicoDTO.idJornadaMedico = generarIdJornadaMedico();
						jornadaMedicoDTO.diaInicio = dateChooserFechaInicioJornadaMedico.getDate();
						jornadaMedicoDTO.diaFin = dateChooserFechaFinJornadaMedico.getDate();
						for (int i = 0; i < modeloListDiasSeleccionadosJornadaMedico.getSize(); i++) {
							if(i== modeloListDiasSeleccionadosJornadaMedico.getSize()-1) {
								dias = dias + modeloListDiasSeleccionadosJornadaMedico.getElementAt(i).toString();
							}
							else {
								dias = dias + modeloListDiasSeleccionadosJornadaMedico.getElementAt(i).toString() + ", ";
							}
							
						} 
						
						jornadaMedicoDTO.dias = dias;
					

						String hora1 = horaInicio + "";
						String hora2 = horaFin + "";
						String minutos1 = minutos1Inicio + "";
						String minutos2 = minutos2Inicio + "";
						String minutos3 = minutos1Fin + "";
						String minutos4 = minutos2Fin + "";
						String horaInicial = hora1 + ":" + minutos1 + minutos2;
						String horaFinal = hora2 + ":" + minutos3 + minutos4;

						jornadaMedicoDTO.horaInicio = horaInicial;
						jornadaMedicoDTO.horaFin = horaFinal;
						
						jornadaMedicoDTO.idMedico= modeloListMedicosSeleccionadosJornada.getElementAt(0).getIdMedico();
						
						jornadaMedico= new JornadaMedico(jornadaMedicoDTO);
						
						crearJornadaMedico.crearJornadaMedico(jornadaMedico);
						
						
						
						cambiarPanel("panelAdministrativo");
						
						spinnerHoraInicioJornadamedico.setValue(0);;
						spinnerHoraFinJornadamedico.setValue(0);
						spinnerMinutosInicioJornadamedico.setValue(0);
						spinnerMinutosInicioJornadamedico2.setValue(0);
						spinnerMinutosFinJornadamedico_1.setValue(0);
						spinnerMinutosFinJornadamedico2.setValue(0);
						
						
						modeloListMedicosSeleccionadosJornada.removeAllElements();
						modeloListDiasSeleccionadosJornadaMedico.removeAllElements();
						

					}
					
					
					

				}
			});
			btnCrearJornadaMedico.setFocusable(false);
			btnCrearJornadaMedico.setForeground(new Color(0, 128, 0));
			btnCrearJornadaMedico.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCrearJornadaMedico.setBounds(841, 527, 127, 23);
		}
		return btnCrearJornadaMedico;
	}
	
	private int generarIdJornadaMedico() {
		ListaJornadasMedico lc = new ListaJornadasMedico();
		lc.creaJornadaMedico();
		return 2200 + lc.getJornadasMedicos().size();
	}
	
	private boolean comprobarCorrecto(int horaInicio,int horaFin,int minutos1Inicio,int minutos2Inicio ,int minutos1Fin, int minutos2Fin ) {
		
		if (fechaCambiada == true && fechaCambiada2 == false) {
			JOptionPane.showMessageDialog(getBtnCrearJornadaMedico(),"La fecha final de la jornada no puede ser anterior a la fecha inicial");
			return false;
			
		} else {
			if (dateChooserFechaInicioJornadaMedico.getDate().toString().contains(dateChooserFechaFinJornadaMedico.getDate().toString())) {
	
				if (horaInicio >= horaFin) {
					if (minutos1Inicio >= minutos1Fin) {
						if (minutos2Inicio >= minutos2Fin) {
							JOptionPane.showMessageDialog(getBtnCrearJornadaMedico(),"La hora final de la jornada no puede ser anterior a la hora inicial");
							return false;
						}
					}
				}

			}
		}
		
		return true;
		
	}

	private JButton getBtnCancelarJornadaMedico() {
		if (btnCancelarJornadaMedico == null) {
			btnCancelarJornadaMedico = new JButton("Cancelar");
			btnCancelarJornadaMedico.setFocusable(false);
			btnCancelarJornadaMedico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListMedicosSeleccionadosJornada.removeAllElements();
					modeloListDiasSeleccionadosJornadaMedico.removeAllElements();
					cambiarPanel("panelAdministrativo");
				}
			});
			btnCancelarJornadaMedico.setForeground(new Color(255, 0, 0));
			btnCancelarJornadaMedico.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCancelarJornadaMedico.setBounds(981, 527, 102, 23);
		}
		return btnCancelarJornadaMedico;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(414, 381, 88, 127);
			scrollPane.setViewportView(getListDias());
		}
		return scrollPane;
	}

	private JList getListDias() {
		if (listDias == null) {
			modeloListDiasJornada = new DefaultListModel();
			listDias = new JList(modeloListDiasJornada);
			modeloListDiasJornada.addElement("Lunes");
			modeloListDiasJornada.addElement("Martes");
			modeloListDiasJornada.addElement("Miercoles");
			modeloListDiasJornada.addElement("Jueves");
			modeloListDiasJornada.addElement("Viernes");
			modeloListDiasJornada.addElement("Sabado");
			modeloListDiasJornada.addElement("Domingo");
		}
		return listDias;
	}

	private JButton getBtnA�adirDiasJornada() {
		if (btnA�adirDiasJornada == null) {
			btnA�adirDiasJornada = new JButton("A\u00F1adir dias");
			btnA�adirDiasJornada.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					for (Object o : listDias.getSelectedValuesList()) {
						if (!modeloListDiasSeleccionadosJornadaMedico.contains(o)) {
							modeloListDiasSeleccionadosJornadaMedico.addElement((String) o);
						}
					}

				}
			});
			btnA�adirDiasJornada.setBounds(512, 451, 113, 23);
		}
		return btnA�adirDiasJornada;
	}

	private JScrollPane getScrollPaneDiasSeleccionados() {
		if (scrollPaneDiasSeleccionados == null) {
			scrollPaneDiasSeleccionados = new JScrollPane();
			scrollPaneDiasSeleccionados.setBounds(665, 403, 207, 86);
			scrollPaneDiasSeleccionados.setViewportView(getListDiasSeleccionadosJornadaMedico());
		}
		return scrollPaneDiasSeleccionados;
	}

	private JButton getBtnBorrarDiasSeleccionados() {
		if (btnBorrarDiasSeleccionados == null) {
			btnBorrarDiasSeleccionados = new JButton("Borrar dias");
			btnBorrarDiasSeleccionados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					modeloListDiasSeleccionadosJornadaMedico.removeAllElements();

				}
			});
			btnBorrarDiasSeleccionados.setBounds(882, 419, 126, 23);
		}
		return btnBorrarDiasSeleccionados;
	}

	private JScrollPane getScrollPaneMedicos() {
		if (scrollPaneMedicos == null) {
			scrollPaneMedicos = new JScrollPane();
			scrollPaneMedicos.setBounds(323, 213, 287, 88);
			scrollPaneMedicos.setViewportView(getListMedicos());
		}
		return scrollPaneMedicos;
	}

	private JButton getBtnAnadirMedicos() {
		if (btnAnadirMedicos == null) {
			btnAnadirMedicos = new JButton("A\u00F1adir Medico/s");
			btnAnadirMedicos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					anadirMedicosSeleccinados();
				}
			});
			btnAnadirMedicos.setBounds(630, 224, 149, 55);
		}
		return btnAnadirMedicos;
	}

	private void anadirMedicosSeleccinados() {

		for (Object o : listMedicos.getSelectedValuesList()) {

			if (!modeloListMedicosAnadidos.contains(o)) {
				modeloListMedicosAnadidos.addElement((Medico) o);
			}

		}

	}

	private JList getListMedicos() {
		if (listMedicos == null) {
			modeloListMedicos = new DefaultListModel();
			listMedicos = new JList(modeloListMedicos);
			anadirMedicosALaLista();
		}
		return listMedicos;
	}

	private void anadirMedicosALaLista() {

		lm = new ListaMedicos();
		lm.creaListaMedicos();
		for (Medico m : lm.getMedicos()) {
			modeloListMedicos.addElement((Medico) m);
		}

	}

	private JScrollPane getScrollPaneMedicosAnadidos() {
		if (scrollPaneMedicosAnadidos == null) {
			scrollPaneMedicosAnadidos = new JScrollPane();
			scrollPaneMedicosAnadidos.setBounds(794, 213, 186, 88);
			scrollPaneMedicosAnadidos.setViewportView(getListMedicosAnadidos());
		}
		return scrollPaneMedicosAnadidos;
	}

	private JList getListMedicosAnadidos() {
		if (listMedicosAnadidos == null) {
			modeloListMedicosAnadidos = new DefaultListModel();
			listMedicosAnadidos = new JList(modeloListMedicosAnadidos);
		}
		return listMedicosAnadidos;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(321, 114, 289, 88);
			scrollPane_1.setViewportView(getListPacientesCita());
		}
		return scrollPane_1;
	}

	private JList getListPacientesCita() {
		if (listPacientesCita == null) {
			modeloListPacientesCita = new DefaultListModel();
			listPacientesCita = new JList(modeloListPacientesCita);

			anadirPacientesCitas();
		}
		return listPacientesCita;
	}

	private void anadirPacientesCitas() {

		lp = new ListaPacientes();
		lp.creaListaPacientes();

		for (Paciente p : lp.getPacientes()) {

			modeloListPacientesCita.addElement((Paciente) p);
		}

	}

	private JButton getBtnAnadirPacienteListaCita() {
		if (btnAnadirPacienteListaCita == null) {
			btnAnadirPacienteListaCita = new JButton("A\u00F1adir Paciente");
			btnAnadirPacienteListaCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					anadirPacienteListaCita();
				}
			});
			btnAnadirPacienteListaCita.setBounds(630, 126, 149, 55);
		}
		return btnAnadirPacienteListaCita;
	}

	private void anadirPacienteListaCita() {

		for (Object o : listPacientesCita.getSelectedValuesList()) {
			if (modeloListPacienteCita.getSize() < 1) {

				if (!modeloListPacienteCita.contains(o)) {
					modeloListPacienteCita.addElement((Paciente) o);
				}

			}
		}

	}

	private JScrollPane getScrollPanePacienteSeleccionado() {
		if (scrollPanePacienteSeleccionado == null) {
			scrollPanePacienteSeleccionado = new JScrollPane();
			scrollPanePacienteSeleccionado.setBounds(794, 114, 186, 88);
			scrollPanePacienteSeleccionado.setViewportView(getListPacienteSeleccionado());
		}
		return scrollPanePacienteSeleccionado;
	}

	private JList getListPacienteSeleccionado() {
		if (listPacienteSeleccionado == null) {
			modeloListPacienteCita = new DefaultListModel();
			listPacienteSeleccionado = new JList(modeloListPacienteCita);

		}
		return listPacienteSeleccionado;
	}

	private JList getListDiasSeleccionadosJornadaMedico() {
		if (listDiasSeleccionadosJornadaMedico == null) {
			modeloListDiasSeleccionadosJornadaMedico = new DefaultListModel();
			listDiasSeleccionadosJornadaMedico = new JList(modeloListDiasSeleccionadosJornadaMedico);
		}
		return listDiasSeleccionadosJornadaMedico;
	}

	private JScrollPane getScrollPaneSeleccionarMedicoJornada() {
		if (scrollPaneSeleccionarMedicoJornada == null) {
			scrollPaneSeleccionarMedicoJornada = new JScrollPane();
			scrollPaneSeleccionarMedicoJornada.setBounds(229, 57, 261, 77);
			scrollPaneSeleccionarMedicoJornada.setViewportView(getListMedicosJornada());
		}
		return scrollPaneSeleccionarMedicoJornada;
	}

	private JList getListMedicosJornada() {
		if (listMedicosJornada == null) {
			modeloListMedicos = new DefaultListModel();
			listMedicosJornada = new JList(modeloListMedicos);
			listMedicosJornada.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			anadirMedicosALaLista();

		}
		return listMedicosJornada;
	}

	private JButton getBtnAnadirMedicoJornadas() {
		if (btnAnadirMedicoJornadas == null) {
			btnAnadirMedicoJornadas = new JButton("A\u00F1adir");
			btnAnadirMedicoJornadas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (modeloListMedicosSeleccionadosJornada.getSize() < 1) {
						if (!modeloListMedicosSeleccionadosJornada
								.contains((Medico) listMedicosJornada.getSelectedValue())) {
							modeloListMedicosSeleccionadosJornada
									.addElement((Medico) listMedicosJornada.getSelectedValue());
						}
					}

				}
			});
			btnAnadirMedicoJornadas.setBounds(509, 86, 89, 23);
		}
		return btnAnadirMedicoJornadas;
	}

	private JScrollPane getScrollPaneMedicoSeleccionadoJornada() {
		if (scrollPaneMedicoSeleccionadoJornada == null) {
			scrollPaneMedicoSeleccionadoJornada = new JScrollPane();
			scrollPaneMedicoSeleccionadoJornada.setBounds(615, 57, 269, 77);
			scrollPaneMedicoSeleccionadoJornada.setViewportView(getListMedicosSeleccionadosJornada());
		}
		return scrollPaneMedicoSeleccionadoJornada;
	}

	private JList getListMedicosSeleccionadosJornada() {
		if (listMedicosSeleccionadosJornada == null) {
			modeloListMedicosSeleccionadosJornada = new DefaultListModel();
			listMedicosSeleccionadosJornada = new JList(modeloListMedicosSeleccionadosJornada);
		}
		return listMedicosSeleccionadosJornada;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Borrar Medico");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					modeloListMedicosSeleccionadosJornada.removeAllElements();
				}
			});
			btnNewButton_1.setBounds(894, 86, 115, 23);
		}
		return btnNewButton_1;
	}

	private JButton getBtnIndicarPrescripcion() {
		if (btnIndicarPrescripcion == null) {
			btnIndicarPrescripcion = new JButton("Indicar prescripcion");
			btnIndicarPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					cambiarPanel("panelPrescripcion");
				}
			});
			btnIndicarPrescripcion.setBounds(78, 69, 151, 38);
		}
		return btnIndicarPrescripcion;
	}

	private JPanel getPanelPrescripcion() {
		if (panelPrescripcion == null) {
			panelPrescripcion = new JPanel();
			panelPrescripcion.setBackground(new Color(135, 206, 235));
			panelPrescripcion.setLayout(null);
			panelPrescripcion.add(getBtnAnadirNuevaPrescripcion());
			panelPrescripcion.add(getScrollPanePrescripciones());
			panelPrescripcion.add(getScrollPanePrescripcionSeleccionada());
			panelPrescripcion.add(getBtnBorrarPrescripcion());
			panelPrescripcion.add(getBtnAsignarPrescripcion());
			panelPrescripcion.add(getBtnCancelarPrescripcion());

			JButton btnNewButton_2 = new JButton("Seleccionar Paciente");
			btnNewButton_2.setForeground(new Color(0, 128, 0));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					for(Object o : listPacientesPrescripcion.getSelectedValuesList()) {
						if(!modeloListaPacienteSeleccionadoPrescripcion.contains(o)) {
							if(modeloListaPacienteSeleccionadoPrescripcion.getSize()<1) {
								modeloListaPacienteSeleccionadoPrescripcion.addElement((Paciente) o);
							}
						}
					}
					
				}
			});
			btnNewButton_2.setBounds(418, 351, 224, 47);
			panelPrescripcion.add(btnNewButton_2);

			JScrollPane scrollPanePaciente = new JScrollPane();
			scrollPanePaciente.setBounds(40, 329, 328, 101);
			panelPrescripcion.add(scrollPanePaciente);
			scrollPanePaciente.setViewportView(getListPacientesPrescripcion());
			panelPrescripcion.add(getScrollPane_6());
			panelPrescripcion.add(getLblNewLabel_13());
			panelPrescripcion.add(getScrollPane_7());
			panelPrescripcion.add(getBtnAnadirPrescripcion());
			panelPrescripcion.add(getBtnEliminarPacientePrescripcion());
			panelPrescripcion.add(getLblNewLabel_17());
		}
		return panelPrescripcion;
	}

	private JButton getBtnAnadirNuevaPrescripcion() {
		if (btnAnadirNuevaPrescripcion == null) {
			btnAnadirNuevaPrescripcion = new JButton("A\u00F1adir nueva prescripcion");
			btnAnadirNuevaPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					cambiarPanel("panelCrearPrescripcion");
				}
			});
			btnAnadirNuevaPrescripcion.setBounds(92, 202, 224, 40);
		}
		return btnAnadirNuevaPrescripcion;
	}

	private JScrollPane getScrollPanePrescripciones() {
		if (scrollPanePrescripciones == null) {
			scrollPanePrescripciones = new JScrollPane();
			scrollPanePrescripciones.setBounds(40, 11, 328, 162);
			scrollPanePrescripciones.setViewportView(getListPrescripciones());
		}
		return scrollPanePrescripciones;
	}

	private JButton getBtnAnadirPrescripcion() {
		if (btnAnadirPrescripcion == null) {
			btnAnadirPrescripcion = new JButton("A\u00F1adir Prescripcion se\u00F1alizada");
			btnAnadirPrescripcion.setForeground(new Color(0, 128, 0));
			btnAnadirPrescripcion.setBounds(430, 32, 212, 47);
			btnAnadirPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					for (Object o : listPrescripciones.getSelectedValuesList()) {
						if (!modeloListPrescripcionesSeleccionada.contains(o)) {
							if (modeloListPrescripcionesSeleccionada.getSize() < 1) {
								modeloListPrescripcionesSeleccionada.addElement((Prescripcion) o);
							}
						}
					}
					
					listaMedicamentos = new ListaMedicamentos();
					listaMedicamentos.creaListaMedicamentos();
					if(modeloListPrescripcionesSeleccionada.getElementAt(0).esMedicamento()) {
						for(Medicamento m :listaMedicamentos.getMedicamentos()) {
							if(m.getIdPrescripcion()==modeloListPrescripcionesSeleccionada.getElementAt(0).getIdPrescripcion())
							textAreaMedicinaInformacion.setText("Informacion del medicamento : " + m.toString() );
						}
					}
					else {
						textAreaMedicinaInformacion.setText("No se trata de un medicamento");
					}

				}
			});
		}
		return btnAnadirPrescripcion;
	}

	private JScrollPane getScrollPanePrescripcionSeleccionada() {
		if (scrollPanePrescripcionSeleccionada == null) {
			scrollPanePrescripcionSeleccionada = new JScrollPane();
			scrollPanePrescripcionSeleccionada.setBounds(714, 11, 328, 103);
			scrollPanePrescripcionSeleccionada.setViewportView(getListPrescripcionSeleccionada());
		}
		return scrollPanePrescripcionSeleccionada;
	}

	private JButton getBtnBorrarPrescripcion() {
		if (btnBorrarPrescripcion == null) {
			btnBorrarPrescripcion = new JButton("Eliminar prescripcion");
			btnBorrarPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					modeloListPrescripcionesSeleccionada.removeAllElements();
					textAreaMedicinaInformacion.setText("");
				}
			});
			btnBorrarPrescripcion.setForeground(Color.RED);
			btnBorrarPrescripcion.setBounds(779, 135, 190, 40);
		}
		return btnBorrarPrescripcion;
	}

	private JList getListPrescripciones() {
		if (listPrescripciones == null) {
			modeloListPrescripciones = new DefaultListModel();
			listPrescripciones = new JList(modeloListPrescripciones);
			listPrescripciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			mostrarPrescripciones();
		}
		return listPrescripciones;
	}

	private void mostrarPrescripciones() {

		listaPrescripciones = new ListaPrescripciones();

		listaPrescripciones.creaListaPrescripciones();

		for (Prescripcion p : listaPrescripciones.getPrescripciones()) {

			modeloListPrescripciones.addElement(p);

		}

	}

	private JList getListPrescripcionSeleccionada() {
		if (listPrescripcionSeleccionada == null) {
			modeloListPrescripcionesSeleccionada = new DefaultListModel();
			listPrescripcionSeleccionada = new JList(modeloListPrescripcionesSeleccionada);
		}
		return listPrescripcionSeleccionada;
	}

	private JButton getBtnAsignarPrescripcion() {
		if (btnAsignarPrescripcion == null) {
			btnAsignarPrescripcion = new JButton("Asignar Prescripcion");
			btnAsignarPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					id_paciente = modeloListaPacienteSeleccionadoPrescripcion.getElementAt(0).getIdPaciente();
					id_prescripcion = modeloListPrescripcionesSeleccionada.getElementAt(0).getIdPrescripcion();
					
					
					
					findAllCitas = new FindAllCitas();
					listaCitas = new ListaCitas();
					listaCitas.creaCitas();
					listaMedicoCita= new ListaMedicoCita();
					listaMedicoCita.creaListaMedicoCitas();
					
					
					List<CitaDTO> filtroCitas= new ArrayList<CitaDTO>();
					filtroCitas = findAllCitas.FindIdCita(id_medico, id_paciente);
					
					List<Cita> citas = new ArrayList<Cita>();	
					
					
					for(CitaDTO c : filtroCitas) {
						Cita cita = new Cita(c);
						citas.add(cita);
					}
					
					if(citas.size()==0) {
						JOptionPane.showMessageDialog(getBtnAsignarPrescripcion(), "El paciente no tiene ni ha tenido ninguna cita con usted");
					}
					else {
					for(Cita c: citas ) {
						
						modelListaCitasMedicoPaciente.addElement(c);
					}
					
					cambiarPanel("panelElegirCita");
					}
					}
				
			});
			btnAsignarPrescripcion.setForeground(new Color(0, 128, 0));
			btnAsignarPrescripcion.setBounds(714, 509, 167, 41);
		}
		return btnAsignarPrescripcion;
	}

	private JButton getBtnCancelarPrescripcion() {
		if (btnCancelarPrescripcion == null) {
			btnCancelarPrescripcion = new JButton("Cancelar");
			btnCancelarPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListPrescripcionesSeleccionada.removeAllElements();
					textAreaMedicinaInformacion.setText("");
					cambiarPanel("panelMedico");
				}
			});
			btnCancelarPrescripcion.setForeground(Color.RED);
			btnCancelarPrescripcion.setBounds(905, 509, 156, 41);
		}
		return btnCancelarPrescripcion;
	}

	private JPanel getPanelCrearPrescripcion() {
		if (panelCrearPrescripcion == null) {
			panelCrearPrescripcion = new JPanel();
			panelCrearPrescripcion.setBackground(new Color(135, 206, 235));
			panelCrearPrescripcion.setLayout(null);
			panelCrearPrescripcion.add(getPanelTipoPrescripcion());
			panelCrearPrescripcion.add(getLblNewLabel_7());
			panelCrearPrescripcion.add(getTextFieldInstrucciones());
			panelCrearPrescripcion.add(getPanelMedicamento());
			panelCrearPrescripcion.add(getBtnCrearPrescripcionNueva());
			panelCrearPrescripcion.add(getBtnCancelarCrearPrescripcionNueva());
			panelCrearPrescripcion.add(getLblNewLabel_9());
			panelCrearPrescripcion.add(getLblNewLabel_9_1());
			panelCrearPrescripcion.add(getSpinnerHoraAsignacion());
			panelCrearPrescripcion.add(getSpinnerMinutosAsignacion());
			panelCrearPrescripcion.add(getSpinnerSegundosAsignacion());
			panelCrearPrescripcion.add(getLblNewLabel_10());
			panelCrearPrescripcion.add(getLblNewLabel_10_1());
			panelCrearPrescripcion.add(getDateChooserPrescripcion());
			panelCrearPrescripcion.add(getLblNewLabel_11());
			panelCrearPrescripcion.add(getLblNewLabel_12());
		}
		return panelCrearPrescripcion;
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
			comboBoxIntervalo.setEnabled(true);
			spinnerDiasSemanas.setEnabled(true);
			rdbtnAnosPrescripcion.setEnabled(true);
			rdbtnDiasPrescripcion.setEnabled(true);
			rdbtnSemanasPrescripcion.setEnabled(true);
			rdbtnMesesPrescripcion.setEnabled(true);
			textFieldNotasAdicionalesPrescripcion.setEnabled(true);

		}

	}

	private void comprobarOtroTipoSeleccionado() {

		if (rdbtnOtroTipo.isSelected() == true) {

			rdbtnMedicamento.setSelected(false);
			textFieldNombreMedicamento.setEnabled(false);
			spinnerCantidadMedicamento.setEnabled(false);
			comboBoxIntervalo.setEnabled(false);
			spinnerDiasSemanas.setEnabled(false);
			rdbtnAnosPrescripcion.setEnabled(false);
			rdbtnDiasPrescripcion.setEnabled(false);
			rdbtnSemanasPrescripcion.setEnabled(false);
			rdbtnMesesPrescripcion.setEnabled(false);
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
			panelMedicamento.add(getComboBoxIntervalo());
			panelMedicamento.add(getLblNewLabel_8_1_2_1());
			panelMedicamento.add(getSpinnerDiasSemanas());
			panelMedicamento.add(getRdbtnDiasPrescripcion());
			panelMedicamento.add(getRdbtnSemanasPrescripcion());
			panelMedicamento.add(getRdbtnMesesPrescripcion());
			panelMedicamento.add(getRdbtnAnosPrescripcion());
			panelMedicamento.add(getLblNewLabel_8_1_2_1_1());
			panelMedicamento.add(getTextFieldNotasAdicionalesPrescripcion());
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

	private JComboBox getComboBoxIntervalo() {
		if (comboBoxIntervalo == null) {
			comboBoxIntervalo = new JComboBox();
			comboBoxIntervalo.setEnabled(false);
			comboBoxIntervalo.setModel(new DefaultComboBoxModel(new String[] { "Cada 4 horas", "Cada 8 horas",
					"Cada 12 horas", "Cada 24 horas", "Cada 2 dias", "Cada semana", "Cada dos semanas", "Cada mes" }));
			comboBoxIntervalo.setBounds(113, 105, 162, 22);
		}
		return comboBoxIntervalo;
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
					String ano = spinnerCantidadMedicamento.getValue().toString() + " a�o/s";
					
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
						medicamentoDTO.intervalo = (String) comboBoxIntervalo.getSelectedItem();
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
					
					 actualizarListaPrescripciones();
					 
					 cambiarPanel("panelPrescripcion");

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
	
	
	private void actualizarListaPrescripciones() {
		
		mostrarPrescripciones();
		
	}

	private JButton getBtnCancelarCrearPrescripcionNueva() {
		if (btnCancelarCrearPrescripcionNueva == null) {
			btnCancelarCrearPrescripcionNueva = new JButton("Cancelar");
			btnCancelarCrearPrescripcionNueva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					cambiarPanel("panelPrescripcion");

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

	private JList getListPacientesPrescripcion() {
		if (listPacientesPrescripcion == null) {
			modeloListaPacientesPrescripcion = new DefaultListModel();
			listPacientesPrescripcion = new JList(modeloListaPacientesPrescripcion);
			listPacientesPrescripcion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lp = new ListaPacientes();
			lp.creaListaPacientes();

			for (Paciente p : lp.getPacientes()) {

				modeloListaPacientesPrescripcion.addElement(p);
			}

		}
		return listPacientesPrescripcion;
	}

	private JPanel getPanelElegirCita() {
		if (panelElegirCita == null) {
			panelElegirCita = new JPanel();
			panelElegirCita.setBackground(new Color(135, 206, 235));
			panelElegirCita.setLayout(null);

			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(39, 47, 351, 395);
			panelElegirCita.add(scrollPane_2);
			scrollPane_2.setViewportView(getListCitasMedicoPaciente());

			JScrollPane scrollPane_3 = new JScrollPane();
			scrollPane_3.setBounds(806, 179, 276, 173);
			panelElegirCita.add(scrollPane_3);
			scrollPane_3.setViewportView(getListCitaElegida());

			JButton btnElegirCita = new JButton("Elegir Cita");
			btnElegirCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					for(Object o: listCitasMedicoPaciente.getSelectedValuesList()) {
						
						if(!modelListaCitaMedicoPacienteElegida.contains(o)) {
							modelListaCitaMedicoPacienteElegida.addElement((Cita) o);
						}
						
					}
					

					
				}
			});
			btnElegirCita.setBounds(135, 470, 160, 54);
			panelElegirCita.add(btnElegirCita);
			panelElegirCita.add(getBtnEliminarCitaElegida());
			panelElegirCita.add(getBtnTerminarProceso());
			panelElegirCita.add(getBtnCancelarProceso());
			panelElegirCita.add(getLblNewLabel_16());
		}
		return panelElegirCita;
	}

	private JButton getBtnEliminarCitaElegida() {
		if (btnEliminarCitaElegida == null) {
			btnEliminarCitaElegida = new JButton("Eliminar Cita Elegida");
			btnEliminarCitaElegida.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modelListaCitaMedicoPacienteElegida.removeAllElements();
				}
			});
			btnEliminarCitaElegida.setForeground(new Color(255, 0, 0));
			btnEliminarCitaElegida.setBounds(879, 382, 127, 23);
		}
		return btnEliminarCitaElegida;
	}

	private JButton getBtnTerminarProceso() {
		if (btnTerminarProceso == null) {
			btnTerminarProceso = new JButton("Terminar Proceso");
			btnTerminarProceso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					crearPrescripcionCitaPaciente = new CrearPrescripcionCitaPaciente();
					
					prescripcionCitaPacienteDTO = new PrescripcionCitaPacienteDTO();
					
				
					for(int i=0;i<modelListaCitaMedicoPacienteElegida.getSize();i++) {
						prescripcionCitaPacienteDTO.idCita=modelListaCitaMedicoPacienteElegida.getElementAt(i).getIdCita();
						prescripcionCitaPacienteDTO.idPaciente=id_paciente;
						prescripcionCitaPacienteDTO.idPrescripcion=id_prescripcion;
						
						prescripcionCitaPaciente = new PrescripcionCitaPaciente(prescripcionCitaPacienteDTO);
						crearPrescripcionCitaPaciente.crearCita(prescripcionCitaPaciente); 
					}
					
					cambiarPanel("panelMedico");
					
				}
			});
			btnTerminarProceso.setForeground(new Color(0, 128, 0));
			btnTerminarProceso.setBounds(778, 508, 136, 42);
		}
		return btnTerminarProceso;
	}

	private JButton getBtnCancelarProceso() {
		if (btnCancelarProceso == null) {
			btnCancelarProceso = new JButton("CancelarProceso");
			btnCancelarProceso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					modelListaCitaMedicoPacienteElegida.removeAllElements();
					modelListaCitasMedicoPaciente.removeAllElements();
					cambiarPanel("panelPrescripcion");
				}
			});
			btnCancelarProceso.setForeground(new Color(255, 0, 0));
			btnCancelarProceso.setBounds(939, 508, 143, 42);
		}
		return btnCancelarProceso;
	}

	private JPanel getPanelLoginMedico() {
		if (panelLoginMedico == null) {
			panelLoginMedico = new JPanel();
			panelLoginMedico.setBackground(Color.WHITE);
			panelLoginMedico.setLayout(null);
			panelLoginMedico.add(getScrollPane_4());
			panelLoginMedico.add(getBtnSeleccionarMedicoLogin());
			panelLoginMedico.add(getScrollPane_5());
			panelLoginMedico.add(getBtnEliminarMedicoLogueado());
			panelLoginMedico.add(getBtnSiguienteLogin());

		}
		return panelLoginMedico;
	}

	private JScrollPane getScrollPane_4() {
		if (scrollPane_4 == null) {
			scrollPane_4 = new JScrollPane();
			scrollPane_4.setBounds(119, 152, 283, 263);
			scrollPane_4.setViewportView(getListMedicosLogin());

		}
		return scrollPane_4;
	}

	private JList getListMedicosLogin() {
		if (listMedicosLogin == null) {
			modeloListaMedicosLogin = new DefaultListModel();
			listMedicosLogin = new JList(modeloListaMedicosLogin);
			listMedicosLogin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lm = new ListaMedicos();
			lm.creaListaMedicos();
			for (Medico m : lm.getMedicos()) {
				modeloListaMedicosLogin.addElement((Medico) m);
			}

		}
		return listMedicosLogin;
	}

	private JButton getBtnSeleccionarMedicoLogin() {
		if (btnSeleccionarMedicoLogin == null) {
			btnSeleccionarMedicoLogin = new JButton("Seleccionar Medico");
			btnSeleccionarMedicoLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (Object o : listMedicosLogin.getSelectedValuesList()) {
						if (!modeloListaMedicosLogueados.contains(o)) {
							if (modeloListaMedicosLogueados.getSize() < 1) {

								modeloListaMedicosLogueados.addElement((Medico) o);

							}
						}
					}
				}
			});
			btnSeleccionarMedicoLogin.setBounds(462, 249, 166, 39);

		}
		return btnSeleccionarMedicoLogin;
	}

	private JScrollPane getScrollPane_5() {
		if (scrollPane_5 == null) {
			scrollPane_5 = new JScrollPane();
			scrollPane_5.setBounds(678, 167, 338, 184);
			scrollPane_5.setViewportView(getListMedicoLogueado());
		}
		return scrollPane_5;
	}

	private JList getListMedicoLogueado() {
		if (listMedicoLogueado == null) {
			modeloListaMedicosLogueados = new DefaultListModel();
			listMedicoLogueado = new JList(modeloListaMedicosLogueados);
		}
		return listMedicoLogueado;
	}

	private JButton getBtnEliminarMedicoLogueado() {
		if (btnEliminarMedicoLogueado == null) {
			btnEliminarMedicoLogueado = new JButton("Eliminar");
			btnEliminarMedicoLogueado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListaMedicosLogueados.removeAllElements();
				}
			});
			btnEliminarMedicoLogueado.setBounds(807, 373, 89, 23);
		}
		return btnEliminarMedicoLogueado;
	}

	private JButton getBtnSiguienteLogin() {
		if (btnSiguienteLogin == null) {
			btnSiguienteLogin = new JButton("Siguiente");
			btnSiguienteLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					id_medico = modeloListaMedicosLogueados.getElementAt(0).getIdMedico();
					cambiarPanel("panelMedico");
				}
			});
			btnSiguienteLogin.setBounds(889, 502, 89, 23);
		}
		return btnSiguienteLogin;
	}
	private JScrollPane getScrollPane_6() {
		if (scrollPane_6 == null) {
			scrollPane_6 = new JScrollPane();
			scrollPane_6.setBounds(714, 211, 328, 84);
			scrollPane_6.setViewportView(getTextAreaMedicinaInformacion());
		}
		return scrollPane_6;
	}
	private JTextArea getTextAreaMedicinaInformacion() {
		if (textAreaMedicinaInformacion == null) {
			textAreaMedicinaInformacion = new JTextArea();
			
		}
		return textAreaMedicinaInformacion;
	}
	private JLabel getLblNewLabel_13() {
		if (lblNewLabel_13 == null) {
			lblNewLabel_13 = new JLabel("Informacion si la prescripcion se trata de un medicamento ");
			lblNewLabel_13.setBounds(714, 186, 389, 14);
		}
		return lblNewLabel_13;
	}
	private JScrollPane getScrollPane_7() {
		if (scrollPane_7 == null) {
			scrollPane_7 = new JScrollPane();
			scrollPane_7.setBounds(714, 329, 328, 92);
			scrollPane_7.setViewportView(getListpacienteSeleccionadoPrescripcion());
		}
		return scrollPane_7;
	}
	private JList getListpacienteSeleccionadoPrescripcion() {
		if (listpacienteSeleccionadoPrescripcion == null) {
			modeloListaPacienteSeleccionadoPrescripcion = new DefaultListModel();
			listpacienteSeleccionadoPrescripcion = new JList(modeloListaPacienteSeleccionadoPrescripcion);
		}
		return listpacienteSeleccionadoPrescripcion;
	}
	private JList getListCitasMedicoPaciente() {
		if (listCitasMedicoPaciente == null) {
			modelListaCitasMedicoPaciente= new DefaultListModel();
			listCitasMedicoPaciente = new JList(modelListaCitasMedicoPaciente);
			
			
		}
		return listCitasMedicoPaciente;
	}
	private JList getListCitaElegida() {
		if (listCitaElegida == null) {
			modelListaCitaMedicoPacienteElegida = new DefaultListModel();
			listCitaElegida = new JList(modelListaCitaMedicoPacienteElegida);
		}
		return listCitaElegida;
	}
	private JButton getBtnEliminarPacientePrescripcion() {
		if (btnEliminarPacientePrescripcion == null) {
			btnEliminarPacientePrescripcion = new JButton("Eliminar paciente");
			btnEliminarPacientePrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListaPacienteSeleccionadoPrescripcion.removeAllElements();
				}
			});
			btnEliminarPacientePrescripcion.setForeground(new Color(255, 0, 0));
			btnEliminarPacientePrescripcion.setBounds(779, 432, 190, 40);
		}
		return btnEliminarPacientePrescripcion;
	}
	private JLabel getLblNewLabel_5_1_2() {
		if (lblNewLabel_5_1 == null) {
			lblNewLabel_5_1 = new JLabel("Seleccionar dia fin :");
			lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5_1.setBounds(99, 257, 158, 22);
		}
		return lblNewLabel_5_1;
	}
	private JDateChooser getDateChooserFechaInicioJornadaMedico() {
		if (dateChooserFechaInicioJornadaMedico == null) {
			dateChooserFechaInicioJornadaMedico = new JDateChooser();
			dateChooserFechaInicioJornadaMedico.setBounds(229, 189, 102, 20);
			
			Calendar fecha = new GregorianCalendar();
			
			fechaCambiada=false;

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
				dateChooserFechaInicioJornadaMedico.setDate(date2);
				dateChooserFechaInicioJornadaMedico.getJCalendar().setMinSelectableDate(date2);
				((JTextFieldDateEditor) dateChooserFechaInicioJornadaMedico.getDateEditor()).setEditable(false);
				

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			dateChooserFechaInicioJornadaMedico.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					fechaCambiada=true;
				}
			});

		}
		return dateChooserFechaInicioJornadaMedico;
	}
	private JDateChooser getDateChooserFechaFinJornadaMedico() {
		if (dateChooserFechaFinJornadaMedico == null) {
			dateChooserFechaFinJornadaMedico = new JDateChooser();
			
			Calendar fecha = new GregorianCalendar();
			
			fechaCambiada2=false;

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
				dateChooserFechaFinJornadaMedico.setDate(date2);
				dateChooserFechaFinJornadaMedico.getJCalendar().setMinSelectableDate(date2);
				((JTextFieldDateEditor) dateChooserFechaFinJornadaMedico.getDateEditor()).setEditable(false);
				

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			dateChooserFechaFinJornadaMedico.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dateChooserFechaFinJornadaMedico.setDate(dateChooserFechaInicioJornadaMedico.getDate());
					dateChooserFechaFinJornadaMedico.getJCalendar().setMinSelectableDate(dateChooserFechaInicioJornadaMedico.getDate());
					((JTextFieldDateEditor) dateChooserFechaFinJornadaMedico.getDateEditor()).setEditable(false);
					fechaCambiada2=true;
				}
			});
			dateChooserFechaFinJornadaMedico.setBounds(229, 257, 102, 20);
			

			

			
		}
		return dateChooserFechaFinJornadaMedico;
	}
	private JSpinner getSpinnerHoraInicioJornadamedico() {
		if (spinnerHoraInicioJornadamedico == null) {
			spinnerHoraInicioJornadamedico = new JSpinner();
			spinnerHoraInicioJornadamedico.setModel(new SpinnerNumberModel(0, 0, 23, 1));
			spinnerHoraInicioJornadamedico.setBounds(880, 191, 48, 20);
		}
		return spinnerHoraInicioJornadamedico;
	}
	private JSpinner getSpinnerHoraFinJornadamedico() {
		if (spinnerHoraFinJornadamedico == null) {
			spinnerHoraFinJornadamedico = new JSpinner();
			spinnerHoraFinJornadamedico.setModel(new SpinnerNumberModel(0, 0, 23, 1));
			spinnerHoraFinJornadamedico.setBounds(880, 259, 48, 20);
		}
		return spinnerHoraFinJornadamedico;
	}
	private JSpinner getSpinnerMinutosFinJornadamedico_1() {
		if (spinnerMinutosFinJornadamedico_1 == null) {
			spinnerMinutosFinJornadamedico_1 = new JSpinner();
			spinnerMinutosFinJornadamedico_1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
			spinnerMinutosFinJornadamedico_1.setBounds(954, 259, 48, 20);
		}
		return spinnerMinutosFinJornadamedico_1;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel(":");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6.setBounds(938, 193, 30, 14);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_6_1() {
		if (lblNewLabel_6_1 == null) {
			lblNewLabel_6_1 = new JLabel(":");
			lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_1.setBounds(938, 262, 30, 14);
		}
		return lblNewLabel_6_1;
	}
	private JSpinner getSpinnerMinutosInicioJornadamedico() {
		if (spinnerMinutosInicioJornadamedico == null) {
			spinnerMinutosInicioJornadamedico = new JSpinner();
			spinnerMinutosInicioJornadamedico.setModel(new SpinnerNumberModel(0, 0, 5, 1));
			spinnerMinutosInicioJornadamedico.setBounds(954, 191, 48, 20);
		}
		return spinnerMinutosInicioJornadamedico;
	}
	private JSpinner getSpinnerMinutosInicioJornadamedico2() {
		if (spinnerMinutosInicioJornadamedico2 == null) {
			spinnerMinutosInicioJornadamedico2 = new JSpinner();
			spinnerMinutosInicioJornadamedico2.setModel(new SpinnerNumberModel(0, 0, 9, 1));
			spinnerMinutosInicioJornadamedico2.setBounds(1012, 191, 48, 20);
		}
		return spinnerMinutosInicioJornadamedico2;
	}
	private JSpinner getSpinnerMinutosFinJornadamedico2() {
		if (spinnerMinutosFinJornadamedico2 == null) {
			spinnerMinutosFinJornadamedico2 = new JSpinner();
			spinnerMinutosFinJornadamedico2.setModel(new SpinnerNumberModel(0, 0, 9, 1));
			spinnerMinutosFinJornadamedico2.setBounds(1012, 259, 48, 20);
		}
		return spinnerMinutosFinJornadamedico2;
	}
	private JPanel getPanelJornadasEnfermero() {
		if (panelJornadasEnfermero == null) {
			panelJornadasEnfermero = new JPanel();
			panelJornadasEnfermero.setBackground(new Color(135, 206, 235));
			panelJornadasEnfermero.setLayout(new BorderLayout(0, 0));
			panelJornadasEnfermero.add(getPanelJornadasEnfermero1());
		}
		return panelJornadasEnfermero;
	}
	private JPanel getPanelJornadasEnfermero1() {
		if (panelJornadasEnfermero1 == null) {
			panelJornadasEnfermero1 = new JPanel();
			panelJornadasEnfermero1.setLayout(null);
			panelJornadasEnfermero1.setBackground(new Color(135, 206, 235));
			panelJornadasEnfermero1.add(getLblNewLabel_4_2());
			panelJornadasEnfermero1.add(getLblNewLabel_4_1_1());
			panelJornadasEnfermero1.add(getLblNewLabel_5_2_1());
			panelJornadasEnfermero1.add(getLblNewLabel_6_1_1_1());
			panelJornadasEnfermero1.add(getLblNewLabel_5_1_1_1());
			panelJornadasEnfermero1.add(getBtnCrearJornadaEnfermero());
			panelJornadasEnfermero1.add(getBtnCancelarJornadaEnfermero());
			panelJornadasEnfermero1.add(getScrollPane_8_1());
			panelJornadasEnfermero1.add(getBtnA�adirDiasJornadaEnfermero());
			panelJornadasEnfermero1.add(getScrollPaneDiasSeleccionados_1());
			panelJornadasEnfermero1.add(getBtnBorrarDiasSeleccionadosJornadaEnfermero());
			panelJornadasEnfermero1.add(getScrollPaneSeleccionarEnfermero());
			panelJornadasEnfermero1.add(getBtnAnadirEnfermeroJornadas());
			panelJornadasEnfermero1.add(getScrollPaneEnfermeroSeleccionadoJornada_1());
			panelJornadasEnfermero1.add(getBtnBorrarEnfermeroJornadas());
			panelJornadasEnfermero1.add(getLblNewLabel_5_1_2_2());
			panelJornadasEnfermero1.add(getDateChooserFechaInicioJornadaEnfermero());
			panelJornadasEnfermero1.add(getDateChooserFechaFinJornadaEnfermero());
			panelJornadasEnfermero1.add(getSpinnerHoraInicioJornadaEnfermero());
			panelJornadasEnfermero1.add(getSpinnerHoraFinJornadaEnfermero());
			panelJornadasEnfermero1.add(getSpinnerMinutosFinJornadaeEnfermero());
			panelJornadasEnfermero1.add(getLblNewLabel_6_2());
			panelJornadasEnfermero1.add(getLblNewLabel_6_1_2());
			panelJornadasEnfermero1.add(getSpinnerMinutosInicioJornadaEnfermero());
			panelJornadasEnfermero1.add(getSpinnerMinutosInicioJornadaEnfermero2());
			panelJornadasEnfermero1.add(getSpinnerMinutosFinJornadaEnfermero2());
			panelJornadasEnfermero1.add(getLblNewLabel_15());
		}
		return panelJornadasEnfermero1;
	}
	private JLabel getLblNewLabel_4_2() {
		if (lblNewLabel_4_2 == null) {
			lblNewLabel_4_2 = new JLabel("Seleccionar Enfermero :");
			lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_4_2.setBounds(29, 73, 190, 22);
		}
		return lblNewLabel_4_2;
	}
	private JLabel getLblNewLabel_4_1_1() {
		if (lblNewLabel_4_1_1 == null) {
			lblNewLabel_4_1_1 = new JLabel("Seleccionar dias a la semana :");
			lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_4_1_1.setBounds(171, 386, 200, 22);
		}
		return lblNewLabel_4_1_1;
	}
	private JLabel getLblNewLabel_5_2_1() {
		if (lblNewLabel_5_2 == null) {
			lblNewLabel_5_2 = new JLabel("Seleccionar dia inicio :");
			lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5_2.setBounds(78, 199, 158, 22);
		}
		return lblNewLabel_5_2;
	}
	private JLabel getLblNewLabel_6_1_1_1() {
		if (lblNewLabel_6_1_1_1 == null) {
			lblNewLabel_6_1_1_1 = new JLabel("Seleccionar hora inicio :");
			lblNewLabel_6_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_1_1_1.setBounds(713, 199, 158, 22);
		}
		return lblNewLabel_6_1_1_1;
	}
	private JLabel getLblNewLabel_5_1_1_1() {
		if (lblNewLabel_5_1_1_1 == null) {
			lblNewLabel_5_1_1_1 = new JLabel("Seleccionar hora fin :");
			lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5_1_1_1.setBounds(713, 267, 142, 22);
		}
		return lblNewLabel_5_1_1_1;
	}
	private JButton getBtnCrearJornadaEnfermero() {
		if (btnCrearJornadaEnfermero == null) {
			btnCrearJornadaEnfermero = new JButton("Crear jornada");
			btnCrearJornadaEnfermero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String dias="";
					int horaInicio = (int) spinnerHoraInicioJornadaEnfermero .getValue();
					int horaFin = (int) spinnerHoraFinJornadaEnfermero.getValue();
					int minutos1Inicio = (int) spinnerMinutosInicioJornadaEnfermero.getValue();
					int minutos2Inicio = (int) spinnerMinutosInicioJornadaEnfermero2.getValue();
					int minutos1Fin = (int) spinnerMinutosFinJornadaeEnfermero.getValue();
					int minutos2Fin = (int) spinnerMinutosFinJornadaEnfermero2.getValue();
						
					if (comprobarCorrecto2(horaInicio, horaFin, minutos1Inicio, minutos2Inicio, minutos1Fin,
							minutos2Fin)) {
						
						

						crearJornadaEnfermero = new CrearJornadaEnfermero();
						jornadaEnfermeroDTO = new JornadaEnfermeroDTO();
						jornadaEnfermeroDTO.idJornadaEnfermero = generarIdJornadaEnfermero();
						jornadaEnfermeroDTO.diaInicio = dateChooserFechaInicioJornadaEnfermero.getDate();
						jornadaEnfermeroDTO.diaFin = dateChooserFechaFinJornadaEnfermero.getDate();
						for (int i = 0; i < modeloDiasSemanaSeleccionadosJornadaEnfermero.getSize(); i++) {
							if(i== modeloDiasSemanaSeleccionadosJornadaEnfermero.getSize()-1) {
								dias = dias + modeloDiasSemanaSeleccionadosJornadaEnfermero.getElementAt(i).toString();
							}
							else {
								dias = dias + modeloDiasSemanaSeleccionadosJornadaEnfermero.getElementAt(i).toString() + ", ";
							}
							
						}
						
						jornadaEnfermeroDTO.dias = dias;
					

						String hora1 = horaInicio + "";
						String hora2 = horaFin + "";
						String minutos1 = minutos1Inicio + "";
						String minutos2 = minutos2Inicio + "";
						String minutos3 = minutos1Fin + "";
						String minutos4 = minutos2Fin + "";
						String horaInicial = hora1 + ":" + minutos1 + minutos2;
						String horaFinal = hora2 + ":" + minutos3 + minutos4;

						jornadaEnfermeroDTO.horaInicio = horaInicial;
						jornadaEnfermeroDTO.horaFin = horaFinal;
						
						jornadaEnfermeroDTO.idEnfermero= modeloListaEnfermerosSeleccionadosJornada.getElementAt(0).getIdEnfermero();
						
						jornadaEnfermero= new JornadaEnfermero(jornadaEnfermeroDTO);
						
						crearJornadaEnfermero.crearJornadaEnfermero(jornadaEnfermero);
						
						
						spinnerHoraInicioJornadaEnfermero.setValue(0);;
						spinnerHoraFinJornadaEnfermero.setValue(0);
						spinnerMinutosInicioJornadaEnfermero.setValue(0);
						spinnerMinutosInicioJornadaEnfermero2.setValue(0);
						spinnerMinutosFinJornadaeEnfermero.setValue(0);
						spinnerMinutosFinJornadaEnfermero2.setValue(0);
						
						
						modeloListaEnfermerosSeleccionadosJornada.removeAllElements();
						modeloDiasSemanaSeleccionadosJornadaEnfermero.removeAllElements();
						
						cambiarPanel("panelAdministrativo");
						
						

					}
					
					
					
					
				}
			});
			btnCrearJornadaEnfermero.setForeground(new Color(0, 128, 0));
			btnCrearJornadaEnfermero.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCrearJornadaEnfermero.setFocusable(false);
			btnCrearJornadaEnfermero.setBounds(841, 527, 127, 23);
		}
		return btnCrearJornadaEnfermero;
	}
	
	private int generarIdJornadaEnfermero() {
		ListaJornadasEnfermero lc = new ListaJornadasEnfermero();
		lc.creaJornadaEnfermeros();
		return 2200 + lc.getJornadasEnfermeros().size();
	}
	private JButton getBtnCancelarJornadaEnfermero() {
		if (btnCancelarJornadaEnfermero == null) {
			btnCancelarJornadaEnfermero = new JButton("Cancelar");
			btnCancelarJornadaEnfermero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					cambiarPanel("panelAdministrativo");
				}
			});
			btnCancelarJornadaEnfermero.setForeground(Color.RED);
			btnCancelarJornadaEnfermero.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCancelarJornadaEnfermero.setFocusable(false);
			btnCancelarJornadaEnfermero.setBounds(981, 527, 102, 23);
		}
		return btnCancelarJornadaEnfermero;
	}
	private JScrollPane getScrollPane_8_1() {
		if (scrollPane_8 == null) {
			scrollPane_8 = new JScrollPane();
			scrollPane_8.setBounds(381, 379, 88, 127);
			scrollPane_8.setViewportView(getListDiasSemanaJornadaEnfermero());
		}
		return scrollPane_8;
	}
	private JButton getBtnA�adirDiasJornadaEnfermero() {
		if (btnA�adirDiasJornadaEnfermero == null) {
			btnA�adirDiasJornadaEnfermero = new JButton("A\u00F1adir dias");
			btnA�adirDiasJornadaEnfermero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (Object o : listDiasSemanaJornadaEnfermero.getSelectedValuesList()) {
						if (!modeloDiasSemanaSeleccionadosJornadaEnfermero.contains(o)) {
							modeloDiasSemanaSeleccionadosJornadaEnfermero.addElement((String) o);
						}
					}
				}
			});
			btnA�adirDiasJornadaEnfermero.setBounds(479, 431, 113, 23);
		}
		return btnA�adirDiasJornadaEnfermero;
	}
	private JScrollPane getScrollPaneDiasSeleccionados_1() {
		if (scrollPaneDiasSeleccionados_1 == null) {
			scrollPaneDiasSeleccionados_1 = new JScrollPane();
			scrollPaneDiasSeleccionados_1.setBounds(608, 401, 207, 86);
			scrollPaneDiasSeleccionados_1.setViewportView(getListDiasSeleccionadosJornadaEnfermero());
		}
		return scrollPaneDiasSeleccionados_1;
	}
	private JButton getBtnBorrarDiasSeleccionadosJornadaEnfermero() {
		if (btnBorrarDiasSeleccionadosJornadaEnfermero == null) {
			btnBorrarDiasSeleccionadosJornadaEnfermero = new JButton("Borrar dias");
			btnBorrarDiasSeleccionadosJornadaEnfermero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloDiasSemanaSeleccionadosJornadaEnfermero.removeAllElements();
				}
			});
			btnBorrarDiasSeleccionadosJornadaEnfermero.setBounds(825, 417, 126, 23);
		}
		return btnBorrarDiasSeleccionadosJornadaEnfermero;
	}
	private JScrollPane getScrollPaneSeleccionarEnfermero() {
		if (scrollPaneSeleccionarEnfermero == null) {
			scrollPaneSeleccionarEnfermero = new JScrollPane();
			scrollPaneSeleccionarEnfermero.setBounds(229, 57, 261, 77);
			scrollPaneSeleccionarEnfermero.setViewportView(getListEnfermerosJornada());
		}
		return scrollPaneSeleccionarEnfermero;
	}
	private JButton getBtnAnadirEnfermeroJornadas() {
		if (btnAnadirEnfermeroJornadas == null) {
			btnAnadirEnfermeroJornadas = new JButton("A\u00F1adir");
			btnAnadirEnfermeroJornadas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					for(Object o: listEnfermerosJornada.getSelectedValuesList()) {
						if (modeloListaEnfermerosSeleccionadosJornada.getSize() < 1) {
							if (!modeloListaEnfermerosSeleccionadosJornada.contains(o)) {
								modeloListaEnfermerosSeleccionadosJornada.addElement((Enfermero) o);
							}
						}
					}
					
				}
			});
			btnAnadirEnfermeroJornadas.setBounds(509, 86, 89, 23);
		}
		return btnAnadirEnfermeroJornadas;
	}
	private JScrollPane getScrollPaneEnfermeroSeleccionadoJornada_1() {
		if (scrollPaneEnfermeroSeleccionadoJornada_1 == null) {
			scrollPaneEnfermeroSeleccionadoJornada_1 = new JScrollPane();
			scrollPaneEnfermeroSeleccionadoJornada_1.setBounds(615, 57, 269, 77);
			scrollPaneEnfermeroSeleccionadoJornada_1.setViewportView(getListEnfermerosSeleccionadosJornada());
		}
		return scrollPaneEnfermeroSeleccionadoJornada_1;
	}
	private JButton getBtnBorrarEnfermeroJornadas() {
		if (btnBorrarEnfermeroJornadas == null) {
			btnBorrarEnfermeroJornadas = new JButton("Borrar Enfermero");
			btnBorrarEnfermeroJornadas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListaEnfermerosSeleccionadosJornada.removeAllElements();
				}
			});
			btnBorrarEnfermeroJornadas.setBounds(894, 86, 158, 23);
		}
		return btnBorrarEnfermeroJornadas;
	}
	private JLabel getLblNewLabel_5_1_2_2() {
		if (lblNewLabel_5_1_2 == null) {
			lblNewLabel_5_1_2 = new JLabel("Seleccionar dia fin :");
			lblNewLabel_5_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5_1_2.setBounds(92, 267, 158, 22);
		}
		return lblNewLabel_5_1_2;
	}
	private JDateChooser getDateChooserFechaInicioJornadaEnfermero() {
		if (dateChooserFechaInicioJornadaEnfermero == null) {
			dateChooserFechaInicioJornadaEnfermero = new JDateChooser();
			
			dateChooserFechaInicioJornadaEnfermero.setBounds(222, 199, 102, 20);
			Calendar fecha = new GregorianCalendar();
			
			fechaCambiada3=false;

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
				dateChooserFechaInicioJornadaEnfermero.setDate(date2);
				dateChooserFechaInicioJornadaEnfermero.getJCalendar().setMinSelectableDate(date2);
				((JTextFieldDateEditor) dateChooserFechaInicioJornadaEnfermero.getDateEditor()).setEditable(false);
				

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			dateChooserFechaInicioJornadaEnfermero.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fechaCambiada3=true;
				}
			});
			
		}
		return dateChooserFechaInicioJornadaEnfermero;
	}
	private JDateChooser getDateChooserFechaFinJornadaEnfermero() {
		if (dateChooserFechaFinJornadaEnfermero == null) {
			dateChooserFechaFinJornadaEnfermero = new JDateChooser();
			dateChooserFechaFinJornadaEnfermero.setBounds(222, 267, 102, 20);
			Calendar fecha = new GregorianCalendar();
			
			fechaCambiada4=false;

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
				dateChooserFechaFinJornadaEnfermero.setDate(date2);
				dateChooserFechaFinJornadaEnfermero.getJCalendar().setMinSelectableDate(date2);
				((JTextFieldDateEditor) dateChooserFechaFinJornadaEnfermero.getDateEditor()).setEditable(false);
				

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			dateChooserFechaFinJornadaEnfermero.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dateChooserFechaFinJornadaEnfermero.setDate(dateChooserFechaInicioJornadaEnfermero.getDate());
					dateChooserFechaFinJornadaEnfermero.getJCalendar().setMinSelectableDate(dateChooserFechaInicioJornadaEnfermero.getDate());
					((JTextFieldDateEditor) dateChooserFechaFinJornadaEnfermero.getDateEditor()).setEditable(false);
					fechaCambiada4=true;
				}
			});
		}
		return dateChooserFechaFinJornadaEnfermero;
	}
	private JSpinner getSpinnerHoraInicioJornadaEnfermero() {
		if (spinnerHoraInicioJornadaEnfermero == null) {
			spinnerHoraInicioJornadaEnfermero = new JSpinner();
			spinnerHoraInicioJornadaEnfermero.setModel(new SpinnerNumberModel(0, 0, 23, 1));
			spinnerHoraInicioJornadaEnfermero.setBounds(881, 201, 48, 20);
		}
		return spinnerHoraInicioJornadaEnfermero;
	}
	private JSpinner getSpinnerHoraFinJornadaEnfermero() {
		if (spinnerHoraFinJornadaEnfermero == null) {
			spinnerHoraFinJornadaEnfermero = new JSpinner();
			spinnerHoraFinJornadaEnfermero.setModel(new SpinnerNumberModel(0, 0, 23, 1));
			spinnerHoraFinJornadaEnfermero.setBounds(881, 269, 48, 20);
		}
		return spinnerHoraFinJornadaEnfermero;
	}
	private JSpinner getSpinnerMinutosFinJornadaeEnfermero() {
		if (spinnerMinutosFinJornadaeEnfermero == null) {
			spinnerMinutosFinJornadaeEnfermero = new JSpinner();
			spinnerMinutosFinJornadaeEnfermero.setModel(new SpinnerNumberModel(0, 0, 5, 1));
			spinnerMinutosFinJornadaeEnfermero.setBounds(955, 269, 48, 20);
		}
		return spinnerMinutosFinJornadaeEnfermero;
	}
	private JLabel getLblNewLabel_6_2() {
		if (lblNewLabel_6_2 == null) {
			lblNewLabel_6_2 = new JLabel(":");
			lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_2.setBounds(939, 203, 30, 14);
		}
		return lblNewLabel_6_2;
	}
	private JLabel getLblNewLabel_6_1_2() {
		if (lblNewLabel_6_1_2 == null) {
			lblNewLabel_6_1_2 = new JLabel(":");
			lblNewLabel_6_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_1_2.setBounds(939, 272, 30, 14);
		}
		return lblNewLabel_6_1_2;
	}
	private JSpinner getSpinnerMinutosInicioJornadaEnfermero() {
		if (spinnerMinutosInicioJornadaEnfermero == null) {
			spinnerMinutosInicioJornadaEnfermero = new JSpinner();
			spinnerMinutosInicioJornadaEnfermero.setModel(new SpinnerNumberModel(0, 0, 5, 1));
			spinnerMinutosInicioJornadaEnfermero.setBounds(955, 201, 48, 20);
		}
		return spinnerMinutosInicioJornadaEnfermero;
	}
	private JSpinner getSpinnerMinutosInicioJornadaEnfermero2() {
		if (spinnerMinutosInicioJornadaEnfermero2 == null) {
			spinnerMinutosInicioJornadaEnfermero2 = new JSpinner();
			spinnerMinutosInicioJornadaEnfermero2.setModel(new SpinnerNumberModel(0, 0, 9, 1));
			spinnerMinutosInicioJornadaEnfermero2.setBounds(1013, 201, 48, 20);
		}
		return spinnerMinutosInicioJornadaEnfermero2;
	}
	private JSpinner getSpinnerMinutosFinJornadaEnfermero2() {
		if (spinnerMinutosFinJornadaEnfermero2 == null) {
			spinnerMinutosFinJornadaEnfermero2 = new JSpinner();
			spinnerMinutosFinJornadaEnfermero2.setModel(new SpinnerNumberModel(0, 0, 9, 1));
			spinnerMinutosFinJornadaEnfermero2.setBounds(1013, 269, 48, 20);
		}
		return spinnerMinutosFinJornadaEnfermero2;
	}
	private JList getListEnfermerosJornada() {
		if (listEnfermerosJornada == null) {
			modeloListaEnfermerosJornada = new DefaultListModel();
			listEnfermerosJornada = new JList(modeloListaEnfermerosJornada);
			le = new ListaEnfermeros();
			le.creaListaEnfermeros();
			for (Enfermero e : le.getEnfermeros()) {
				modeloListaEnfermerosJornada.addElement(e);
			}
		}
		return listEnfermerosJornada;
	}
	private JList getListEnfermerosSeleccionadosJornada() {
		if (listEnfermerosSeleccionadosJornada == null) {
			modeloListaEnfermerosSeleccionadosJornada = new DefaultListModel();
			listEnfermerosSeleccionadosJornada = new JList(modeloListaEnfermerosSeleccionadosJornada);
		}
		return listEnfermerosSeleccionadosJornada;
	}
	private JList getListDiasSemanaJornadaEnfermero() {
		if (listDiasSemanaJornadaEnfermero == null) {
			modeloDiasSemanaJornadaEnfermero= new DefaultListModel();
			listDiasSemanaJornadaEnfermero = new JList(new AbstractListModel() {
				String[] values = new String[] {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		}
		return listDiasSemanaJornadaEnfermero;
	}
	private JList getListDiasSeleccionadosJornadaEnfermero() {
		if (listDiasSeleccionadosJornadaEnfermero == null) {
			modeloDiasSemanaSeleccionadosJornadaEnfermero= new DefaultListModel();
			listDiasSeleccionadosJornadaEnfermero = new JList(modeloDiasSemanaSeleccionadosJornadaEnfermero);
		}
		return listDiasSeleccionadosJornadaEnfermero;
	}
	
private boolean comprobarCorrecto2(int horaInicio,int horaFin,int minutos1Inicio,int minutos2Inicio ,int minutos1Fin, int minutos2Fin ) {
		
		if (fechaCambiada3 == true && fechaCambiada4 == false) {
			JOptionPane.showMessageDialog(getBtnCrearJornadaEnfermero(),"La fecha final de la jornada no puede ser anterior a la fecha inicial");
			return false;
			
		} else {
			if (dateChooserFechaInicioJornadaEnfermero.getDate().toString().contains(dateChooserFechaFinJornadaEnfermero.getDate().toString())) {
	
				if (horaInicio >= horaFin) {
					if (minutos1Inicio >= minutos1Fin) {
						if (minutos2Inicio >= minutos2Fin) {
							JOptionPane.showMessageDialog(getBtnCrearJornadaEnfermero(),"La hora final de la jornada no puede ser anterior a la hora inicial");
							return false;
						}
					}
				}

			}
		}
		
		return true;
		
	}
	private JLabel getLblNewLabel_14() {
		if (lblNewLabel_14 == null) {
			lblNewLabel_14 = new JLabel("");
			lblNewLabel_14.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/085e2efd9a10a1d20e259f487a17cf23-malet--n-medico-by-vexels.png")));
			lblNewLabel_14.setBounds(305, 0, 808, 561);
		}
		return lblNewLabel_14;
	}
	private JLabel getLblNewLabel_15() {
		if (lblNewLabel_15 == null) {
			lblNewLabel_15 = new JLabel("");
			lblNewLabel_15.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/085e2efd9a10a1d20e259f487a17cf23-malet--n-medico-by-vexels.png")));
			lblNewLabel_15.setBounds(305, 0, 808, 561);
		}
		return lblNewLabel_15;
	}
	private JLabel getLblNewLabel_16() {
		if (lblNewLabel_16 == null) {
			lblNewLabel_16 = new JLabel("");
			lblNewLabel_16.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/f1d0807f8ffad0197757d840bdc97d0b-icono-de-registro-medico-by-vexels.png")));
			lblNewLabel_16.setBounds(324, 0, 744, 550);
		}
		return lblNewLabel_16;
	}
	private JLabel getLblNewLabel_17() {
		if (lblNewLabel_17 == null) {
			lblNewLabel_17 = new JLabel("");
			lblNewLabel_17.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/f1d0807f8ffad0197757d840bdc97d0b-icono-de-registro-medico-by-vexels.png")));
			lblNewLabel_17.setBounds(313, 0, 800, 561);
		}
		return lblNewLabel_17;
	}
}
