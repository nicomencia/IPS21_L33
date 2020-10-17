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
import pgh.business.medicamento.CrearMedicamento;
import pgh.business.medicamento.Medicamento;
import pgh.business.medicamento.MedicamentoDTO;
import pgh.business.medico.ListaMedicos;
import pgh.business.medico.Medico;
import pgh.business.medicocita.CrearMedicoCita;
import pgh.business.medicocita.MedicoCita;
import pgh.business.medicocita.MedicoCitaDTO;
import pgh.business.paciente.ListaPacientes;
import pgh.business.paciente.Paciente;
import pgh.business.prescripcion.ListaPrescripciones;
import pgh.business.prescripcion.Prescripcion;
import pgh.business.prescripcion.PrescripcionDTO;
import pgh.business.prescripcioncitapaciente.CrearPrescripcionCitaPaciente;
import pgh.business.prescripcioncitapaciente.PrescripcionCitaPaciente;
import pgh.business.prescripcioncitapaciente.PrescripcionCitaPacienteDTO;
import pgh.business.ubicacion.ListaUbicaciones;
import pgh.business.ubicacion.Ubicacion;

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
	private ListaUbicaciones lu;
	private JPanel panelJornadasMedico;
	private JButton btnAsignarJornadasMedicos;
	private JButton btnAsignarJornadasAEnfermeros;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_4_1;
	private JLabel lblNewLabel_5;
	private JComboBox comboBoxDiaInicioJornadaMedico;
	private JLabel lblNewLabel_5_1;
	private JComboBox comboBoxDiaFinJornadaMedico;
	private JLabel lblNewLabel_6;
	private JComboBox comboBoxMesInicioJornadaMedico;
	private JLabel lblNewLabel_6_1;
	private JComboBox comboBoxMesFinJornadaMedico;
	private JLabel lblNewLabel_6_1_1;
	private JComboBox comboBoxHoraInicioJornadaMedico;
	private JLabel lblNewLabel_5_1_1;
	private JComboBox comboBoxHoraFinJornadaMedico;
	private JButton btnCrearJornadaMedico;
	private JButton btnCancelarJornadaMedico;
	private JLabel lblNewLabel_6_2;
	private JLabel lblNewLabel_6_1_2;
	private JComboBox comboBoxAnoInicioJornadaMedico;
	private JComboBox comboBoxAnoFinJornadaMedico_1;
	private JScrollPane scrollPane;
	private JList listDias;
	private JButton btnAñadirDiasJornada;
	private JScrollPane scrollPaneDiasSeleccionados;
	private JButton btnBorrarDiasSeleccionados;
	private String dias = "";
	private boolean lunes = false, martes = false, miercoles = false, jueves = false, viernes = false, sabado = false, domingo = false;
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
	private DefaultComboBoxModel<Ubicacion> modeloComboUbicacionesCita;
	private JScrollPane scrollPane_1;
	private JList listPacientesCita;
	private CitaDTO citaDTO;
	private Cita cita;
	private CrearCitas crearCitas;
	private JButton btnAnadirPacienteListaCita;
	private JScrollPane scrollPanePacienteSeleccionado;
	private JList listPacienteSeleccionado;
	
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
	private JList listPacientesPrescripcion;
	private DefaultListModel<Paciente> modeloListaPacientesPrescripcion;
	private JPanel panelElegirCita;
	private JButton btnEliminarCitaElegida;
	private JButton btnTerminarProceso;
	private JButton btnCancelarProceso;
	
	private PrescripcionCitaPaciente pcp;
	private PrescripcionCitaPacienteDTO pcpDTOs;
	private CrearPrescripcionCitaPaciente cpcp;
	
	private MedicoCita medicoCita;
	private MedicoCitaDTO medicoCitaDTO;
	private CrearMedicoCita crearMedicoCita;
	private JPanel panelLoginMedico;
	private JScrollPane scrollPane_4;
	
	private DefaultListModel<Medico> modeloListaMedicosLogin;
	private DefaultListModel<Medico> modeloListaMedicosLogueados;
	private int id_medico;
	private JList listMedicosLogin;
	private JButton btnSeleccionarMedicoLogin;
	private JScrollPane scrollPane_5;
	private JList listMedicoLogueado;
	private JButton btnEliminarMedicoLogueado;
	private JButton btnSiguienteLogin;
	

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
		
		if(nombre=="panelPrincipal") {
			panelPrincipal.setVisible(true);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
			
		}
		else if (nombre=="panelAdministrativo"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(true);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
			
		}
		else if (nombre=="panelMedico"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(true);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
		}
		else if (nombre=="panelEnfermero"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(true);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
			
		}
		else if (nombre=="panelCitas"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(true);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
			
		}
		else if (nombre=="panelJornadas"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(true);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
			
		}
		else if (nombre=="panelPrescripcion"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(true);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(false);
			
		}
		else if (nombre=="panelCrearPrescripcion"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(true);
			panelLoginMedico.setVisible(false);
			
		}
		else if (nombre=="panelLoginMedico"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			panelPrescripcion.setVisible(false);
			panelCrearPrescripcion.setVisible(false);
			panelLoginMedico.setVisible(true);
			
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
			String[] listaAños = new String[5];
			for (int i = 0; i < listaAños.length; i++) {
				listaAños[i] = String.valueOf(2021 + i);
			}
			comboBoxAnoCita.setModel(new DefaultComboBoxModel<String>(listaAños));
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
			modeloComboUbicacionesCita = new DefaultComboBoxModel<Ubicacion>();
			comboBoxUbicacion = new JComboBox(modeloComboUbicacionesCita);
			anadirUbicacionesCitas();
			
			comboBoxUbicacion.setFocusable(false);
			comboBoxUbicacion.setBounds(320, 380, 347, 22);
		}
		return comboBoxUbicacion;
	}
	
	private void anadirUbicacionesCitas() {
			
			lu = new ListaUbicaciones();
			lu.creaListaUbicaciones();
			
		    for(Ubicacion u : lu.getUbicacion()) {

		    	modeloComboUbicacionesCita.addElement((Ubicacion)u);
		    }
			
		}
	
	private JComboBox getComboBoxHorasFinCita() {
		if (comboBoxHorasFinCita == null) {
			comboBoxHorasFinCita = new JComboBox();
			comboBoxHorasFinCita.setFocusable(false);
			comboBoxHorasFinCita.setBounds(840, 384, 57, 22);
			String[] horas = new String[2];
			horas[0]="08";
			horas[1]="09";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		return comboBoxHorasFinCita;
	}
	
    private void hastaQueHora (Object selectedItem) {
		
		String horaInicial = (String) selectedItem;
		String[] horas = new String[2];
		System.out.print(horaInicial);
		if(horaInicial.contains("09")) {
			horas[0]="09";
			horas[1]="10";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		if(horaInicial.contains("10")) {
			horas[0]="10";
			horas[1]="11";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		
		if(horaInicial.contains("11")) {
			horas[0]="11";
			horas[1]="12";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		
		if(horaInicial.contains("12")) {
			horas[0]="12";
			horas[1]="13";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		
		if(horaInicial.contains("13")) {
			horas[0]="13";
			horas[1]="14";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		
		if(horaInicial.contains("14")) {
			horas[0]="14";
			horas[1]="15";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		
		if(horaInicial.contains("15")) {
			horas[0]="15";
			horas[1]="16";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		if(horaInicial.contains("16")) {
			horas[0]="16";
			horas[1]="17";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		if(horaInicial.contains("17")) {
			horas[0]="17";
			horas[1]="18";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		if(horaInicial.contains("18")) {
			horas[0]="18";
			horas[1]="19";
			comboBoxHorasFinCita.setModel(new DefaultComboBoxModel<String>(horas));
		}
		if(horaInicial.contains("19")) {
			horas[0]="19";
			horas[1]="20";
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
			comboBoxHorasInicioCita.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"}));
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
					
				crearCitas = new CrearCitas();
				citaDTO = new CitaDTO();
				 
				citaDTO.idCita = generarIdCita();
				
				Paciente paciente = (Paciente) listPacientesCita.getSelectedValue();
				int idPaciente = paciente.getIdPaciente();
				citaDTO.idPaciente = idPaciente;
				 
				SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy/MM/dd");
				Date date;
				try {
					date = dateformat3.parse("2021/03/27");
					citaDTO.fecha=date;
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
					 
				citaDTO.asistencia = false;
				citaDTO.urgente = false;
				citaDTO.infocontacto = "todo";
				citaDTO.idHorario = 6001;
				
				Ubicacion ubicacion = (Ubicacion) comboBoxUbicacion.getSelectedItem();
				int idUbicacion = ubicacion.getIdUbicacion();
				citaDTO.idUbicacion = idUbicacion;
					 
				cita = new Cita(citaDTO);
				crearCitas.crearCita(cita);

					 
				}

				private int generarIdCita() {
					ListaCitas lc = new ListaCitas();
					lc.creaListaCitas();
					
					return 4000 + lc.getCitas().size();
				}
			});
			btnCrearCita.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCrearCita.setBounds(719, 468, 125, 23);
		}
		return btnCrearCita;
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
			comboBoxMinutosInicioCita.setModel(new DefaultComboBoxModel(new String[] {"00", "15", "30", "45"}));
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
			comboBoxMinutosFinCita.setModel(new DefaultComboBoxModel(new String[] {"00", "15", "30", "45"}));
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
			
			comboBoxMesCita.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
			comboBoxMesCita.setBounds(441, 330, 100, 22);
			
		}
		return comboBoxMesCita;
	}
	
	private void cambiarDias(Object selectedItem) {
		String[] dias31 = new String[31];
		String[] dias30 = new String[30];
		String[] dias29 = new String[29];
		String mes = (String) selectedItem;
		if(mes.contains("01") || mes.contains("03") || mes.contains("05") || mes.contains("07") || mes.contains("08") || mes.contains("10") || mes.contains("12")){
			for(int i=1; i<32;i++) {
				if(i<10) {
					dias31[i-1]="0"+String.valueOf(i);
				}
				else {
					dias31[i-1]=String.valueOf(i);
				}
			}
			comboBoxDiaDia.setModel(new DefaultComboBoxModel<String>(dias31));
		}
		if(mes.contains("02")){
			for(int i=1; i<30;i++) {
				if(i<10) {
					dias29[i-1]="0"+String.valueOf(i);
				}
				else {
					dias29[i-1]=String.valueOf(i);
				}
			}
			comboBoxDiaDia.setModel(new DefaultComboBoxModel<String>(dias29));
		}
		if(mes.contains("04") || mes.contains("06") || mes.contains("09") || mes.contains("11") ){
			for(int i=1; i<31;i++) {
				if(i<10) {
					dias30[i-1]="0"+String.valueOf(i);
				}
				else {
					dias30[i-1]=String.valueOf(i);
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
				for(int i=1; i<32;i++) {
					if(i<10) {
						dias31[i-1]="0"+String.valueOf(i);
					}
					else {
						dias31[i-1]=String.valueOf(i);
					}
				}
				comboBoxDiaDia.setModel(new DefaultComboBoxModel<String>(dias31));
			
		}
		return comboBoxDiaDia;
	}
	private JPanel getPanelJornadasMedico() {
		if (panelJornadasMedico == null) {
			panelJornadasMedico = new JPanel();
			panelJornadasMedico.setBackground(Color.WHITE);
			panelJornadasMedico.setLayout(null);
			panelJornadasMedico.add(getLblNewLabel_4());
			panelJornadasMedico.add(getLblNewLabel_4_1());
			panelJornadasMedico.add(getLblNewLabel_5());
			panelJornadasMedico.add(getComboBoxDiaInicioJornadaMedico());
			panelJornadasMedico.add(getLblNewLabel_5_1());
			panelJornadasMedico.add(getComboBox_1_1());
			panelJornadasMedico.add(getLblNewLabel_6());
			panelJornadasMedico.add(getComboBoxMesInicioJornadaMedico());
			panelJornadasMedico.add(getLblNewLabel_6_1());
			panelJornadasMedico.add(getComboBoxMesFinJornadaMedico());
			panelJornadasMedico.add(getLblNewLabel_6_1_1());
			panelJornadasMedico.add(getComboBoxHoraInicioJornadaMedico());
			panelJornadasMedico.add(getLblNewLabel_5_1_1());
			panelJornadasMedico.add(getComboBox_1_1_1());
			panelJornadasMedico.add(getBtnCrearJornadaMedico());
			panelJornadasMedico.add(getBtnCancelarJornadaMedico());
			panelJornadasMedico.add(getLblNewLabel_6_2());
			panelJornadasMedico.add(getLblNewLabel_6_1_2());
			panelJornadasMedico.add(getComboBoxAnoInicioJornadaMedico());
			panelJornadasMedico.add(getComboBoxAnoFinJornadaMedico_1());
			panelJornadasMedico.add(getScrollPane());
			panelJornadasMedico.add(getBtnAñadirDiasJornada());
			panelJornadasMedico.add(getScrollPaneDiasSeleccionados());
			panelJornadasMedico.add(getBtnBorrarDiasSeleccionados());
			panelJornadasMedico.add(getScrollPaneSeleccionarMedicoJornada());
			panelJornadasMedico.add(getBtnAnadirMedicoJornadas());
			panelJornadasMedico.add(getScrollPaneMedicoSeleccionadoJornada());
			panelJornadasMedico.add(getBtnNewButton_1());
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
			lblNewLabel_4_1.setBounds(72, 401, 200, 22);
		}
		return lblNewLabel_4_1;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("Seleccionar dia inicio :");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5.setBounds(72, 273, 158, 22);
		}
		return lblNewLabel_5;
	}
	private JComboBox getComboBoxDiaInicioJornadaMedico() {
		if (comboBoxDiaInicioJornadaMedico == null) {
			comboBoxDiaInicioJornadaMedico = new JComboBox();
			comboBoxDiaInicioJornadaMedico.setFocusable(false);
			comboBoxDiaInicioJornadaMedico.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16 ", "17 ", "18 ", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			comboBoxDiaInicioJornadaMedico.setBounds(237, 274, 59, 22);
		}
		return comboBoxDiaInicioJornadaMedico;
	}
	private JLabel getLblNewLabel_5_1() {
		if (lblNewLabel_5_1 == null) {
			lblNewLabel_5_1 = new JLabel("Seleccionar dia fin :");
			lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5_1.setBounds(366, 273, 133, 22);
		}
		return lblNewLabel_5_1;
	}
	private JComboBox getComboBox_1_1() {
		if (comboBoxDiaFinJornadaMedico == null) {
			comboBoxDiaFinJornadaMedico = new JComboBox();
			comboBoxDiaFinJornadaMedico.setFocusable(false);
			comboBoxDiaFinJornadaMedico.setBounds(509, 274, 59, 22);
		}
		return comboBoxDiaFinJornadaMedico;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("Seleccionar mes inicio :");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6.setBounds(69, 224, 158, 22);
		}
		return lblNewLabel_6;
	}
	private JComboBox getComboBoxMesInicioJornadaMedico() {
		if (comboBoxMesInicioJornadaMedico == null) {
			comboBoxMesInicioJornadaMedico = new JComboBox();
			comboBoxMesInicioJornadaMedico.setFocusable(false);
			comboBoxMesInicioJornadaMedico.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			comboBoxMesInicioJornadaMedico.setBounds(237, 225, 59, 22);
		}
		return comboBoxMesInicioJornadaMedico;
	}
	private JLabel getLblNewLabel_6_1() {
		if (lblNewLabel_6_1 == null) {
			lblNewLabel_6_1 = new JLabel("Seleccionar mes fin :");
			lblNewLabel_6_1.setFocusable(false);
			lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_1.setBounds(360, 224, 165, 22);
		}
		return lblNewLabel_6_1;
	}
	private JComboBox getComboBoxMesFinJornadaMedico() {
		if (comboBoxMesFinJornadaMedico == null) {
			comboBoxMesFinJornadaMedico = new JComboBox();
			comboBoxMesFinJornadaMedico.setFocusable(false);
			comboBoxMesFinJornadaMedico.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			comboBoxMesFinJornadaMedico.setBounds(509, 225, 59, 22);
		}
		return comboBoxMesFinJornadaMedico;
	}
	private JLabel getLblNewLabel_6_1_1() {
		if (lblNewLabel_6_1_1 == null) {
			lblNewLabel_6_1_1 = new JLabel("Seleccionar hora inicio :");
			lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_1_1.setBounds(615, 176, 158, 22);
		}
		return lblNewLabel_6_1_1;
	}
	private JComboBox getComboBoxHoraInicioJornadaMedico() {
		if (comboBoxHoraInicioJornadaMedico == null) {
			comboBoxHoraInicioJornadaMedico = new JComboBox();
			comboBoxHoraInicioJornadaMedico.setFocusable(false);
			comboBoxHoraInicioJornadaMedico.setModel(new DefaultComboBoxModel(new String[] {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));
			comboBoxHoraInicioJornadaMedico.setBounds(783, 177, 59, 22);
		}
		return comboBoxHoraInicioJornadaMedico;
	}
	private JLabel getLblNewLabel_5_1_1() {
		if (lblNewLabel_5_1_1 == null) {
			lblNewLabel_5_1_1 = new JLabel("Seleccionar hora fin :");
			lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5_1_1.setBounds(615, 224, 142, 22);
		}
		return lblNewLabel_5_1_1;
	}
	private JComboBox getComboBox_1_1_1() {
		if (comboBoxHoraFinJornadaMedico == null) {
			comboBoxHoraFinJornadaMedico = new JComboBox();
			comboBoxHoraFinJornadaMedico.setFocusable(false);
			comboBoxHoraFinJornadaMedico.setModel(new DefaultComboBoxModel(new String[] {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));
			comboBoxHoraFinJornadaMedico.setBounds(783, 225, 59, 22);
		}
		return comboBoxHoraFinJornadaMedico;
	}
	private JButton getBtnCrearJornadaMedico() {
		if (btnCrearJornadaMedico == null) {
			btnCrearJornadaMedico = new JButton("Crear jornada");
			btnCrearJornadaMedico.setFocusable(false);
			btnCrearJornadaMedico.setForeground(new Color(0, 128, 0));
			btnCrearJornadaMedico.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCrearJornadaMedico.setBounds(719, 466, 127, 23);
		}
		return btnCrearJornadaMedico;
	}
	private JButton getBtnCancelarJornadaMedico() {
		if (btnCancelarJornadaMedico == null) {
			btnCancelarJornadaMedico = new JButton("Cancelar");
			btnCancelarJornadaMedico.setFocusable(false);
			btnCancelarJornadaMedico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanel("panelAdministrativo");
				}
			});
			btnCancelarJornadaMedico.setForeground(new Color(255, 0, 0));
			btnCancelarJornadaMedico.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCancelarJornadaMedico.setBounds(859, 466, 102, 23);
		}
		return btnCancelarJornadaMedico;
	}
	private JLabel getLblNewLabel_6_2() {
		if (lblNewLabel_6_2 == null) {
			lblNewLabel_6_2 = new JLabel("Seleccionar a\u00F1o inicio :");
			lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_2.setBounds(72, 176, 158, 22);
		}
		return lblNewLabel_6_2;
	}
	private JLabel getLblNewLabel_6_1_2() {
		if (lblNewLabel_6_1_2 == null) {
			lblNewLabel_6_1_2 = new JLabel("Seleccionar a\u00F1o fin :");
			lblNewLabel_6_1_2.setFocusable(false);
			lblNewLabel_6_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_1_2.setBounds(360, 176, 165, 27);
		}
		return lblNewLabel_6_1_2;
	}
	private JComboBox getComboBoxAnoInicioJornadaMedico() {
		if (comboBoxAnoInicioJornadaMedico == null) {
			comboBoxAnoInicioJornadaMedico = new JComboBox();
			comboBoxAnoInicioJornadaMedico.setFocusable(false);
			comboBoxAnoInicioJornadaMedico.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025"}));
			comboBoxAnoInicioJornadaMedico.setBounds(237, 177, 59, 22);
		}
		return comboBoxAnoInicioJornadaMedico;
	}
	private JComboBox getComboBoxAnoFinJornadaMedico_1() {
		if (comboBoxAnoFinJornadaMedico_1 == null) {
			comboBoxAnoFinJornadaMedico_1 = new JComboBox();
			comboBoxAnoFinJornadaMedico_1.setFocusable(false);
			comboBoxAnoFinJornadaMedico_1.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025"}));
			comboBoxAnoFinJornadaMedico_1.setBounds(509, 177, 59, 22);
		}
		return comboBoxAnoFinJornadaMedico_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(295, 362, 88, 127);
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

	private JButton getBtnAñadirDiasJornada() {
		if (btnAñadirDiasJornada == null) {
			btnAñadirDiasJornada = new JButton("A\u00F1adir dias");
			btnAñadirDiasJornada.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
					for(Object o : listDias.getSelectedValuesList()) {
						if(!modeloListDiasSeleccionadosJornadaMedico.contains(o)){
							modeloListDiasSeleccionadosJornadaMedico.addElement((String) o);
						}
					}
					
					
				}
			});
			btnAñadirDiasJornada.setBounds(152, 434, 113, 23);
		}
		return btnAñadirDiasJornada;
	}

	private JScrollPane getScrollPaneDiasSeleccionados() {
		if (scrollPaneDiasSeleccionados == null) {
			scrollPaneDiasSeleccionados = new JScrollPane();
			scrollPaneDiasSeleccionados.setBounds(414, 401, 207, 86);
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
			btnBorrarDiasSeleccionados.setBounds(631, 417, 126, 23);
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
		
		for(Object o : listMedicos.getSelectedValuesList()) {
			
			if(!modeloListMedicosAnadidos.contains(o)) {
				modeloListMedicosAnadidos.addElement((Medico)o);
			}
			
		}
		
	}
	
	private JList getListMedicos() {
		if (listMedicos == null) {
			modeloListMedicos= new DefaultListModel();
			listMedicos = new JList(modeloListMedicos);
			anadirMedicosALaLista();
		}
		return listMedicos;
	}
	
	
	private void anadirMedicosALaLista() {
		
		lm=new ListaMedicos();
		lm.creaListaMedicos();
		for(Medico m : lm.getMedicos()) {
			modeloListMedicos.addElement((Medico)m);
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
			modeloListMedicosAnadidos= new DefaultListModel();
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
		
		lp= new ListaPacientes();
		lp.creaListaPacientes();
		
	    for(Paciente p : lp.getPacientes()) {
	    	
	    	modeloListPacientesCita.addElement((Paciente)p);
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
		
		for(Object o : listPacientesCita.getSelectedValuesList()) {
			if(modeloListPacienteCita.getSize()<1) {
				
				if(!modeloListPacienteCita.contains(o)) {
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
			modeloListDiasSeleccionadosJornadaMedico= new DefaultListModel();
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
			modeloListMedicos= new DefaultListModel();
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
					
					if(modeloListMedicosSeleccionadosJornada.getSize()<1) {
						if(!modeloListMedicosSeleccionadosJornada.contains((Medico) listMedicosJornada.getSelectedValue())) {
							modeloListMedicosSeleccionadosJornada.addElement((Medico) listMedicosJornada.getSelectedValue());
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
			modeloListMedicosSeleccionadosJornada= new DefaultListModel();
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
			panelPrescripcion.setBackground(Color.WHITE);
			panelPrescripcion.setLayout(null);
			panelPrescripcion.add(getBtnAnadirNuevaPrescripcion());
			panelPrescripcion.add(getScrollPanePrescripciones());
			panelPrescripcion.add(getBtnAnadirPrescripcion());
			panelPrescripcion.add(getScrollPanePrescripcionSeleccionada());
			panelPrescripcion.add(getBtnBorrarPrescripcion());
			panelPrescripcion.add(getBtnAsignarPrescripcion());
			panelPrescripcion.add(getBtnCancelarPrescripcion());
			
			JButton btnNewButton_2 = new JButton("Seleccionar Paciente");
			btnNewButton_2.setBounds(433, 306, 224, 47);
			panelPrescripcion.add(btnNewButton_2);
			
			JScrollPane scrollPanePaciente = new JScrollPane();
			scrollPanePaciente.setBounds(716, 258, 328, 137);
			panelPrescripcion.add(scrollPanePaciente);
			scrollPanePaciente.setViewportView(getListPacientesPrescripcion());
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
			btnAnadirNuevaPrescripcion.setBounds(85, 484, 224, 47);
		}
		return btnAnadirNuevaPrescripcion;
	}
	private JScrollPane getScrollPanePrescripciones() {
		if (scrollPanePrescripciones == null) {
			scrollPanePrescripciones = new JScrollPane();
			scrollPanePrescripciones.setBounds(40, 50, 328, 401);
			scrollPanePrescripciones.setViewportView(getListPrescripciones());
		}
		return scrollPanePrescripciones;
	}
	private JButton getBtnAnadirPrescripcion() {
		if (btnAnadirPrescripcion == null) {
			btnAnadirPrescripcion = new JButton("A\u00F1adir Prescripcion se\u00F1alizada");
			btnAnadirPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					for(Object o : listPrescripciones.getSelectedValuesList()) {
						if(!modeloListPrescripcionesSeleccionada.contains(o)) {
							if(modeloListPrescripcionesSeleccionada.getSize()<1) {
								modeloListPrescripcionesSeleccionada.addElement((Prescripcion) o);
							}
						}
					}
				
				}
			});
			btnAnadirPrescripcion.setBounds(433, 50, 226, 47);
		}
		return btnAnadirPrescripcion;
	}
	private JScrollPane getScrollPanePrescripcionSeleccionada() {
		if (scrollPanePrescripcionSeleccionada == null) {
			scrollPanePrescripcionSeleccionada = new JScrollPane();
			scrollPanePrescripcionSeleccionada.setBounds(716, 50, 328, 103);
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
				}
			});
			btnBorrarPrescripcion.setForeground(Color.RED);
			btnBorrarPrescripcion.setBounds(784, 176, 190, 40);
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
		
		for(Prescripcion p : listaPrescripciones.getPrescripciones()) {
			
			modeloListPrescripciones.addElement(p);
			
		}
		
		
		
	}

	private JList getListPrescripcionSeleccionada() {
		if (listPrescripcionSeleccionada == null) {
			modeloListPrescripcionesSeleccionada= new DefaultListModel();
			listPrescripcionSeleccionada = new JList(modeloListPrescripcionesSeleccionada);
		}
		return listPrescripcionSeleccionada;
	}
	private JButton getBtnAsignarPrescripcion() {
		if (btnAsignarPrescripcion == null) {
			btnAsignarPrescripcion = new JButton("Asignar Prescripcion");
			btnAsignarPrescripcion.setForeground(new Color(0, 128, 0));
			btnAsignarPrescripcion.setBounds(716, 487, 167, 41);
		}
		return btnAsignarPrescripcion;
	}
	private JButton getBtnCancelarPrescripcion() {
		if (btnCancelarPrescripcion == null) {
			btnCancelarPrescripcion = new JButton("Cancelar");
			btnCancelarPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListPrescripcionesSeleccionada.removeAllElements();
					cambiarPanel("panelMedico");
				}
			});
			btnCancelarPrescripcion.setForeground(Color.RED);
			btnCancelarPrescripcion.setBounds(906, 487, 156, 41);
		}
		return btnCancelarPrescripcion;
	}
	private JPanel getPanelCrearPrescripcion() {
		if (panelCrearPrescripcion == null) {
			panelCrearPrescripcion = new JPanel();
			panelCrearPrescripcion.setBackground(Color.WHITE);
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
			panelCrearPrescripcion.add(getLblNewLabel_11());
		}
		return panelCrearPrescripcion;
	}
	private JPanel getPanelTipoPrescripcion() {
		if (panelTipoPrescripcion == null) {
			panelTipoPrescripcion = new JPanel();
			panelTipoPrescripcion.setBorder(new TitledBorder(null, "Elegir tipo de prescripcion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		if(rdbtnMedicamento.isSelected()==true) {
			
			rdbtnOtroTipo.setSelected(false);
			textFieldNombreMedicamento.setEnabled(true);
			spinnerCantidadMedicamento.setEnabled(true); 
			comboBoxIntervalo.setEnabled(true);
			spinnerDiasSemanas.setEnabled(true);
			textFieldNotasAdicionalesPrescripcion.setEnabled(true);
		
			
			
		}
		
	}
	
	private void comprobarOtroTipoSeleccionado() {
		
		if(rdbtnOtroTipo.isSelected()==true) {
			
			rdbtnMedicamento.setSelected(false);
			textFieldNombreMedicamento.setEnabled(false);
			spinnerCantidadMedicamento.setEnabled(false); 
			comboBoxIntervalo.setEnabled(false);
			spinnerDiasSemanas.setEnabled(false);
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
			panelMedicamento.setBorder(new TitledBorder(null, "Medicamento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
			spinnerCantidadMedicamento.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
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
			comboBoxIntervalo.setModel(new DefaultComboBoxModel(new String[] {"Cada 4 horas", "Cada 8 horas", "Cada 12 horas", "Cada 24 horas", "Cada 2 dias", "Cada semana", "Cada dos semanas", "Cada mes"}));
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
					
					prescripcionDTO = new PrescripcionDTO();
					
					if(textFieldInstrucciones.getText()!="") {
						prescripcionDTO.instruccion = textFieldInstrucciones.getText() ;
					
					}
					else {
						JOptionPane.showMessageDialog(textFieldInstrucciones, "El campo instrucciones no se puede dejar vacio");
					}
					
					
					String hora = spinnerHoraAsignacion + "";
					String minutos = spinnerMinutosAsignacion + "";
					String segundos = spinnerSegundosAsignacion + "";
					
					String horaAsignacion = hora +" : "+ minutos+ " : " + segundos;
					
					prescripcionDTO.horaAsignacion= horaAsignacion;
					
	
	
					
					
				}
			});
			btnCrearPrescripcionNueva.setForeground(Color.GREEN);
			btnCrearPrescripcionNueva.setBounds(701, 470, 130, 35);
		}
		return btnCrearPrescripcionNueva;
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
	
	
	private JSpinner getSpinnerHoraAsignacion() {
		if (spinnerHoraAsignacion == null) {
			spinnerHoraAsignacion = new JSpinner();
			spinnerHoraAsignacion.setModel(new SpinnerNumberModel(0, 0, 24, 1));
			spinnerHoraAsignacion.setBounds(653, 145, 52, 20);
			
		}
		return spinnerHoraAsignacion;
	}
	private JSpinner getSpinnerMinutosAsignacion() {
		if (spinnerMinutosAsignacion == null) {
			spinnerMinutosAsignacion = new JSpinner();
			spinnerMinutosAsignacion.setModel(new SpinnerNumberModel(0, 0, 59, 1));
			spinnerMinutosAsignacion.setBounds(725, 145, 52, 20);
			
		}
		return spinnerMinutosAsignacion;
	}
	private JSpinner getSpinnerSegundosAsignacion() {
		if (spinnerSegundosAsignacion == null) {
			spinnerSegundosAsignacion = new JSpinner();
			spinnerSegundosAsignacion.setModel(new SpinnerNumberModel(0, 0, 59, 1));
			spinnerSegundosAsignacion.setBounds(797, 145, 52, 20);
			
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
	
	private JLabel getLblNewLabel_11() {
		if (lblNewLabel_11 == null) {
			lblNewLabel_11 = new JLabel("HH/mm/ss");
			lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_11.setBounds(874, 148, 85, 14);
		}
		return lblNewLabel_11;
	}
	
	private JList getListPacientesPrescripcion() {
		if (listPacientesPrescripcion == null) {
			modeloListaPacientesPrescripcion = new DefaultListModel();
			listPacientesPrescripcion = new JList(modeloListaPacientesPrescripcion);
			listPacientesPrescripcion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lp= new ListaPacientes();
			lp.creaListaPacientes();
			
		    for(Paciente p : lp.getPacientes()) {
		    	
		    	modeloListaPacientesPrescripcion.addElement(p);
		    }
			
		}
		return listPacientesPrescripcion;
	}
	private JPanel getPanelElegirCita() {
		if (panelElegirCita == null) {
			panelElegirCita = new JPanel();
			panelElegirCita.setBackground(Color.WHITE);
			panelElegirCita.setLayout(null);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(80, 91, 351, 395);
			panelElegirCita.add(scrollPane_2);
			
			JScrollPane scrollPane_3 = new JScrollPane();
			scrollPane_3.setBounds(764, 181, 276, 173);
			panelElegirCita.add(scrollPane_3);
			
			JButton btnElegirCita = new JButton("Elegir Cita");
			btnElegirCita.setBounds(510, 252, 160, 54);
			panelElegirCita.add(btnElegirCita);
			panelElegirCita.add(getBtnEliminarCitaElegida());
			panelElegirCita.add(getBtnTerminarProceso());
			panelElegirCita.add(getBtnCancelarProceso());
		}
		return panelElegirCita;
	}
	private JButton getBtnEliminarCitaElegida() {
		if (btnEliminarCitaElegida == null) {
			btnEliminarCitaElegida = new JButton("Eliminar Cita Elegida");
			btnEliminarCitaElegida.setBounds(839, 383, 127, 23);
		}
		return btnEliminarCitaElegida;
	}
	private JButton getBtnTerminarProceso() {
		if (btnTerminarProceso == null) {
			btnTerminarProceso = new JButton("Terminar Proceso");
			btnTerminarProceso.setBounds(764, 477, 115, 42);
		}
		return btnTerminarProceso;
	}
	private JButton getBtnCancelarProceso() {
		if (btnCancelarProceso == null) {
			btnCancelarProceso = new JButton("CancelarProceso");
			btnCancelarProceso.setBounds(925, 477, 115, 42);
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
			lm=new ListaMedicos();
			lm.creaListaMedicos();
			for(Medico m : lm.getMedicos()) {
				modeloListaMedicosLogin.addElement((Medico)m);
			}
			
		}
		return listMedicosLogin;
	}
	private JButton getBtnSeleccionarMedicoLogin() {
		if (btnSeleccionarMedicoLogin == null) {
			btnSeleccionarMedicoLogin = new JButton("Seleccionar Medico");
			btnSeleccionarMedicoLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(Object o :listMedicosLogin.getSelectedValuesList()) {
						if(!modeloListaMedicosLogueados.contains(o)) {
							if(modeloListaMedicosLogueados.getSize()<1){
								
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
			modeloListaMedicosLogueados= new DefaultListModel();
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
}
