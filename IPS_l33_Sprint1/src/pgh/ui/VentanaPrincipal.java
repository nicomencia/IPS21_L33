package pgh.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pgh.business.causa.AsignarCausa;
import pgh.business.causa.Causa;
import pgh.business.causa.CausaDTO;
import pgh.business.causa.ListaCausas;
import pgh.business.cita.Cita;
import pgh.business.cita.CitaDTO;
import pgh.business.cita.ConfirmarAsistencia;
import pgh.business.cita.CrearCitas;
import pgh.business.cita.ListaCitas;
import pgh.business.enfermero.Enfermero;
import pgh.business.enfermero.ListaEnfermeros;
import pgh.business.horario.ActualizarHorario;
import pgh.business.horario.Horario;
import pgh.business.horario.ListaHorarios;
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
import pgh.business.vacacionesenfermero.CrearVacacionesEnfermeros;
import pgh.business.vacacionesenfermero.ListaVacacionesEnfermero;
import pgh.business.vacacionesenfermero.VacacionesEnfermero;
import pgh.business.vacacionesenfermero.VacacionesEnfermeroDTO;
import pgh.business.vacacionesmedico.CrearVacacionesMedicos;
import pgh.business.vacacionesmedico.ListaVacacionesMedico;
import pgh.business.vacacionesmedico.VacacionesMedico;
import pgh.business.vacacionesmedico.VacacionesMedicoDTO;

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
	private JButton btnNewButton;
	private JComboBox comboBoxFechaDia;
	private ListaMedicos lm;
	private ListaPacientes lp;
	private ListaCitas lc;
	private JButton btnAsignarJornadasMedicos;
	private JButton btnAsignarJornadasAEnfermeros;
	private String dias = "";
	private boolean lunes = false, martes = false, miercoles = false, jueves = false, viernes = false, sabado = false, domingo = false;
	private DefaultListModel<Medico> modeloListMedicos;
	private DefaultListModel<Medico> modeloListMedicosVacaciones;
	private DefaultListModel<Medico> modeloListMedicosAnadidos;
	private DefaultListModel<Paciente> modeloListPacientesCita;
	private DefaultListModel<Paciente> modeloListPacienteCita;
	private DefaultListModel<String> modeloListDiasJornada;
	private DefaultListModel<String> modeloListDiasSeleccionadosJornadaMedico;
	private DefaultListModel<Medico> modeloListMedicosSeleccionadosJornada;
	private DefaultListModel<Prescripcion> modeloListPrescripciones;
	private CitaDTO citaDTO;
	private Cita cita;
	private CrearCitas crearCitas;
	private CrearVacacionesEnfermeros crearVacacionesEnfermeros;
	
	private int contador;
	private JButton btnIndicarPrescripcion;
	private ListaPrescripciones listaPrescripciones;
	private DefaultListModel<Prescripcion> modeloListPrescripcionesSeleccionada;
	private PrescripcionDTO prescripcionDTO;
	private Prescripcion prescripcion;
	private MedicamentoDTO medicamentoDTO;
	private Medicamento medicamento;
	private CrearMedicamento crearMedicamento;
	private DefaultListModel<Paciente> modeloListaPacientesPrescripcion;
	
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
	private JButton btnComprobarAsistencia;
	private JPanel panelComprobarAsistencia;
	private JScrollPane scrollPane_6;
	private JList listComprobarAsistencia;
	
	private DefaultListModel<Cita> modeloListaComprobarAsistencia;
	private DefaultListModel<Cita> modeloListaIndicarHorarios;
	private DefaultListModel<VacacionesMedico> modeloListaVacacionesMedico;
	private JTextField textFieldComprobarAsistencia;
	private JButton btnComprobar;
	private JButton btnConfirmarAsistencia;
	private JButton btnSalir_1;
	private JButton btnAñadirCausas;
	private JPanel panelAñadirCausas;
	private JButton btnIndicarHorarios;
	private JPanel panelIndicarHorarios;
	private JList listCitasIndicarHorarios;
	private JScrollPane scrollPane_7;
	private JList listIndicarHorarios;
	private JButton btnSeleccionar;
	private ListaHorarios lh;
	private JLabel lblHoraDeEntrada;
	private JLabel lblHoraDeSalida;
	private JTextField textFieldEntradaNueva;
	private JTextField textFieldSalidaNueva;
	private JLabel lblNueva;
	private JButton btnConfirmar;
	private JButton btnSalir2;
	private JTextField textFieldHorarioActual;
	private JLabel lblHorarioActual;
	private JPanel panelVacacionesMedicos;
	private JButton btnAsignarVacacionesA;
	private JScrollPane scrollPane_8;
	private JList listMedicos_1;
	private JLabel lblMedicoSeleccionado;
	private JTextField textFieldMedicoSeleccionado;
	private JButton btnSeleccionar_1;
	private JComboBox comboBoxDiaInicioV;
	private JLabel lblNewLabel_12;
	private JComboBox comboBoxMesInicioV;
	private JComboBox comboBoxAñoInicioV;
	private JComboBox comboBoxDiaFinV;
	private JComboBox comboBoxMesFinV;
	private JComboBox comboBoxAñoFinV;
	private JLabel lblMesInicio;
	private JLabel lblAoInicio;
	private JLabel lblDiaFin;
	private JLabel lblMesFin;
	private JLabel lblAoFin;
	private ListaVacacionesMedico lvm;
	private ListaVacacionesEnfermero lve;
	private JButton btnSalirVM;
	private JScrollPane scrollPane_9;
	private JList listVacacionesMedico;
	private JLabel lblVacacionesSeleccionadas;
	private JTextField textFieldVacacionesMedico;
	private JButton btnSeleccionarVM;
	private JButton btnAnularVM;
	private JButton btnAsignarVM;
	private JButton btnCrearVM;
	private JScrollPane scrollPane_10;
	private JList listCitasCausas;
	private DefaultListModel<Cita> modeloListaCitasCausas;
	private JScrollPane scrollPane_11;
	private JList listCausas;
	private DefaultListModel<Causa> modeloListaCausas;
	private DefaultListModel<Enfermero> modeloListaEnfermeros;
	private DefaultListModel<VacacionesEnfermero> modeloListaVacacionesEnfermeros;
	private ListaCausas lcs;
	private JPanel panelVacacionesEnfermeros;
	private JScrollPane scrollPane_12;
	private JLabel lblEnfermeroSeleccionado;
	private JTextField textFieldEnfermeroSeleccionado;
	private JButton btnSeleccionarEnfermero;
	private JComboBox comboBoxDiaInicioVE;
	private JLabel label_1;
	private JComboBox comboBoxMesInicioVE;
	private JComboBox comboBoxAñoInicioVE;
	private JComboBox comboBoxDiaFinVE;
	private JComboBox comboBoxMesFinVE;
	private JComboBox comboBoxAñoFinVE;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JButton button_1;
	private JScrollPane scrollPane_13;
	private JLabel label_7;
	private JTextField textFieldVacacionesEnfermeros;
	private JButton btnSeleccionarVE;
	private JButton btnAnularVE;
	private JButton btnAsignarVE;
	private JButton btnCrearVE;
	private JList listEnfermeros;
	private JList listVacacionesEnfermeros;
	private ListaEnfermeros le;
	private JButton btnAsignarVacacionesA_1;
	private CrearVacacionesMedicos crearVacacionesMedicos;
	private JLabel lblCitaSeleccionada;
	private JTextField textFieldCitaSeleccionada;
	private JLabel lblCausaSeleccionada;
	private JTextField textFieldCausaSeleccionada;
	private JButton btnEstablecerCausa;
	private JLabel lblNuevaCausa;
	private JTextField textFieldNuevaCausa;
	private JButton btnCrearYAsignarCausa;
	private JButton btnSeleccionarCita;
	private JButton btnSeleccionarCausa;
	private JButton btnSalirAsignarCausas;
	

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
			panelContenido.add(getPanelIndicarHorarios(), "name_108977252709700");
			panelContenido.add(getPanelAñadirCausas(), "name_107292124431800");
			panelContenido.add(getPanelComprobarAsistencia(), "name_95563681564800");
			panelContenido.add(getPanelLoginMedico(), "name_119791109586100");
			panelContenido.add(getPanelVacacionesMedicos(), "name_184530927298100");
			panelContenido.add(getPanelVacacionesEnfermeros(), "name_247166431666100");
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
			panelAdministrativo.add(getBtnAsignarVacacionesA());
			panelAdministrativo.add(getBtnAsignarVacacionesA_1());
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
			panelLoginMedico.setVisible(false);
			
		}
		else if (nombre=="panelAdministrativo"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(true);
			panelMedico.setVisible(false);
			panelLoginMedico.setVisible(false);
			panelVacacionesMedicos.setVisible(false);
			
		}
		else if (nombre=="panelMedico"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(true);
			panelLoginMedico.setVisible(false);
			panelComprobarAsistencia.setVisible(false);
			panelAñadirCausas.setVisible(false);
		}
		else if (nombre=="panelEnfermero"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelLoginMedico.setVisible(false);
			
		}
		else if (nombre=="panelCitas"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelLoginMedico.setVisible(false);
			
		}
		else if (nombre=="panelJornadas"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelLoginMedico.setVisible(false);
			
		}
		else if (nombre=="panelPrescripcion"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelLoginMedico.setVisible(false);
			
		}
		else if (nombre=="panelCrearPrescripcion"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelLoginMedico.setVisible(false);
			
		}
		else if (nombre=="panelLoginMedico"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelLoginMedico.setVisible(true);			
		}
		
		else if (nombre=="panelComprobarAsistencia") {
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelComprobarAsistencia.setVisible(true);
		}
		
		else if (nombre == "panelAñadirCausas") {
			panelMedico.setVisible(false);
			panelAñadirCausas.setVisible(true);
		}
		
		else if (nombre == "panelIndicarHorarios") {
			panelMedico.setVisible(false);
			panelIndicarHorarios.setVisible(true);
		}
		
		else if (nombre == "panelVacacionesMedicos") {
			panelAdministrativo.setVisible(false);
			panelVacacionesMedicos.setVisible(true);
		}
		
		else if (nombre == "PanelVacacionesEnfermeros") {
			panelAdministrativo.setVisible(false);
			panelVacacionesEnfermeros.setVisible(true);
		}
	}
	private JPanel getPanelMedico() {
		if (panelMedico == null) {
			panelMedico = new JPanel();
			panelMedico.setBackground(Color.WHITE);
			panelMedico.setLayout(null);
			panelMedico.add(getBtnIndicarPrescripcion());
			panelMedico.add(getBtnComprobarAsistencia());
			panelMedico.add(getBtnAñadirCausas());
			panelMedico.add(getBtnIndicarHorarios());
		}
		return panelMedico;
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
	
	private void anadirMedicosALaLista() {
		
		lm=new ListaMedicos();
		lm.creaListaMedicos();
		for(Medico m : lm.getMedicos()) {
			modeloListMedicos.addElement((Medico)m);
		}
		
	}

	private void anadirPacientesCitas() {
		
		lp= new ListaPacientes();
		lp.creaListaPacientes();
		
	    for(Paciente p : lp.getPacientes()) {
	    	
	    	modeloListPacientesCita.addElement((Paciente)p);
	    }
		
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
	
	private void mostrarPrescripciones() {
		
		listaPrescripciones = new ListaPrescripciones();
		
		listaPrescripciones.creaListaPrescripciones();
		
		for(Prescripcion p : listaPrescripciones.getPrescripciones()) {
			
			modeloListPrescripciones.addElement(p);
			
		}
		
		
		
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
	
	private JList getListComprobarAsistencia() {
		if (listComprobarAsistencia == null) {
			modeloListaComprobarAsistencia = new DefaultListModel();
			listComprobarAsistencia = new JList(modeloListaComprobarAsistencia);
			listComprobarAsistencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lc = new ListaCitas();
			lc.creaListaCitas();
			for(Cita c : lc.getListaCitas()) {
				modeloListaComprobarAsistencia.addElement((Cita)c);
			}
		}
		return listComprobarAsistencia;
	}
	
	private JList getListIndicarHorarios() {
		if (listIndicarHorarios == null) {
			modeloListaIndicarHorarios = new DefaultListModel();
			listIndicarHorarios = new JList(modeloListaIndicarHorarios);
			listIndicarHorarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lc = new ListaCitas();
			lc.creaListaCitas();
			for(Cita c : lc.getListaCitas()) {
				modeloListaIndicarHorarios.addElement((Cita)c);
			}
			listIndicarHorarios.setSelectedIndex(0);
		}
		return listIndicarHorarios;
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
	private JButton getBtnComprobarAsistencia() {
		if (btnComprobarAsistencia == null) {
			btnComprobarAsistencia = new JButton("Comprobar asistencia");
			btnComprobarAsistencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					cambiarPanel("panelComprobarAsistencia");
					
				}
			});
			btnComprobarAsistencia.setBounds(256, 69, 195, 38);
		}
		return btnComprobarAsistencia;
	}
	private JPanel getPanelComprobarAsistencia() {
		if (panelComprobarAsistencia == null) {
			panelComprobarAsistencia = new JPanel();
			panelComprobarAsistencia.setBackground(Color.WHITE);
			panelComprobarAsistencia.setLayout(null);
			panelComprobarAsistencia.add(getScrollPane_6());
			panelComprobarAsistencia.add(getTextFieldComprobarAsistencia());
			panelComprobarAsistencia.add(getBtnComprobar());
			panelComprobarAsistencia.add(getBtnConfirmarAsistencia());
			panelComprobarAsistencia.add(getBtnSalir_1());
		}
		return panelComprobarAsistencia;
	}
	private JScrollPane getScrollPane_6() {
		if (scrollPane_6 == null) {
			scrollPane_6 = new JScrollPane();
			scrollPane_6.setBounds(36, 38, 369, 484);
			scrollPane_6.setViewportView(getListComprobarAsistencia());
		}
		return scrollPane_6;
	}
	private JTextField getTextFieldComprobarAsistencia() {
		if (textFieldComprobarAsistencia == null) {
			textFieldComprobarAsistencia = new JTextField();
			textFieldComprobarAsistencia.setEditable(false);
			textFieldComprobarAsistencia.setBounds(631, 60, 86, 20);
			textFieldComprobarAsistencia.setColumns(10);
		}
		return textFieldComprobarAsistencia;
	}
	private JButton getBtnComprobar() {
		if (btnComprobar == null) {
			btnComprobar = new JButton("Comprobar");
			btnComprobar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTextFieldComprobarAsistencia().setText(((Cita)(getListComprobarAsistencia().getSelectedValue())).getAsistencia() + "");
					if (getTextFieldComprobarAsistencia().getText().contentEquals("true")) {
						getBtnConfirmarAsistencia().setEnabled(false);
					}
					else {
						getBtnConfirmarAsistencia().setEnabled(true);
					}
				}
			});
			btnComprobar.setBounds(480, 52, 118, 36);
		}
		return btnComprobar;
	}
	private JButton getBtnConfirmarAsistencia() {
		if (btnConfirmarAsistencia == null) {
			btnConfirmarAsistencia = new JButton("Confirmar Asistencia");
			btnConfirmarAsistencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lc = new ListaCitas();
					lc.creaListaCitas();
					for (Cita c : lc.getListaCitas()) {
						if (c.getIdCita() == ((Cita)getListComprobarAsistencia().getSelectedValue()).getIdCita()) {
							c.confirmarAsistencia();
							ConfirmarAsistencia ca = new ConfirmarAsistencia();
							ca.confirmarAsistencia(c);							
							break;
						}
					}
					lc = new ListaCitas();
					lc.creaListaCitas();
					modeloListaComprobarAsistencia.clear();
					for(Cita c : lc.getListaCitas()) {
						modeloListaComprobarAsistencia.addElement((Cita)c);
					}
					getBtnConfirmarAsistencia().setEnabled(false);
					JOptionPane.showMessageDialog(null, "La asistencia se ha confirmado correctamente");
					getListComprobarAsistencia().setSelectedIndex(0);
				}
			});
			btnConfirmarAsistencia.setEnabled(false);
			btnConfirmarAsistencia.setBounds(511, 169, 192, 89);
		}
		return btnConfirmarAsistencia;
	}
	private JButton getBtnSalir_1() {
		if (btnSalir_1 == null) {
			btnSalir_1 = new JButton("Salir");
			btnSalir_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanel("panelMedico");
				}
			});
			btnSalir_1.setBounds(1000, 519, 103, 31);
		}
		return btnSalir_1;
	}
	private JButton getBtnAñadirCausas() {
		if (btnAñadirCausas == null) {
			btnAñadirCausas = new JButton("A\u00F1adir causas");
			btnAñadirCausas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanel("panelAñadirCausas");
				}
			});
			btnAñadirCausas.setBounds(477, 69, 151, 38);
		}
		return btnAñadirCausas;
	}
	private JPanel getPanelAñadirCausas() {
		if (panelAñadirCausas == null) {
			panelAñadirCausas = new JPanel();
			panelAñadirCausas.setLayout(null);
			panelAñadirCausas.add(getScrollPane_10());
			panelAñadirCausas.add(getScrollPane_11());
			panelAñadirCausas.add(getLblCitaSeleccionada());
			panelAñadirCausas.add(getTextFieldCitaSeleccionada());
			panelAñadirCausas.add(getLblCausaSeleccionada());
			panelAñadirCausas.add(getTextFieldCausaSeleccionada());
			panelAñadirCausas.add(getBtnEstablecerCausa());
			panelAñadirCausas.add(getLblNuevaCausa());
			panelAñadirCausas.add(getTextFieldNuevaCausa());
			panelAñadirCausas.add(getBtnCrearYAsignarCausa());
			panelAñadirCausas.add(getBtnSeleccionarCita());
			panelAñadirCausas.add(getBtnSeleccionarCausa());
			panelAñadirCausas.add(getBtnSalirAsignarCausas());
		}
		return panelAñadirCausas;
	}
	private JButton getBtnIndicarHorarios() {
		if (btnIndicarHorarios == null) {
			btnIndicarHorarios = new JButton("Indicar Horarios");
			btnIndicarHorarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanel("panelIndicarHorarios");
				}
			});
			btnIndicarHorarios.setBounds(642, 69, 166, 38);
		}
		return btnIndicarHorarios;
	}
	private JPanel getPanelIndicarHorarios() {
		if (panelIndicarHorarios == null) {
			panelIndicarHorarios = new JPanel();
			panelIndicarHorarios.setLayout(null);
			panelIndicarHorarios.add(getScrollPane_7_1());
			panelIndicarHorarios.add(getBtnSeleccionar());
			panelIndicarHorarios.add(getLblHoraDeEntrada());
			panelIndicarHorarios.add(getLblHoraDeSalida());
			panelIndicarHorarios.add(getTextFieldEntradaNueva());
			panelIndicarHorarios.add(getTextFieldSalidaNueva());
			panelIndicarHorarios.add(getLblNueva());
			panelIndicarHorarios.add(getBtnConfirmar());
			panelIndicarHorarios.add(getBtnSalir2());
			panelIndicarHorarios.add(getTextFieldHorarioActual());
			panelIndicarHorarios.add(getLblHorarioActual());
		}
		return panelIndicarHorarios;
	}
	private JScrollPane getScrollPane_7_1() {
		if (scrollPane_7 == null) {
			scrollPane_7 = new JScrollPane();
			scrollPane_7.setBounds(23, 30, 363, 496);
			scrollPane_7.setViewportView(getListIndicarHorarios());
		}
		return scrollPane_7;
	}

	private JButton getBtnSeleccionar() {
		if (btnSeleccionar == null) {
			btnSeleccionar = new JButton("Seleccionar");
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lh = new ListaHorarios();
					lh.creaListaHorarios();
					for (Horario h : lh.getHorarios()) {
						if (((Cita)getListIndicarHorarios().getSelectedValue()).getIdHorario() == h.getIdHorario()) {
							textFieldHorarioActual.setText(h.getHoraInicio() + " " + h.getHoraFin());
							break;
						}
					}
					getTextFieldEntradaNueva().setEditable(true);
					getTextFieldSalidaNueva().setEditable(true);
					
					//System.out.println();
				}
			});
			btnSeleccionar.setBounds(440, 30, 126, 38);
		}
		return btnSeleccionar;
	}
	private JLabel getLblHoraDeEntrada() {
		if (lblHoraDeEntrada == null) {
			lblHoraDeEntrada = new JLabel("Hora de entrada:");
			lblHoraDeEntrada.setBounds(558, 136, 110, 14);
		}
		return lblHoraDeEntrada;
	}
	private JLabel getLblHoraDeSalida() {
		if (lblHoraDeSalida == null) {
			lblHoraDeSalida = new JLabel("Hora de salida:");
			lblHoraDeSalida.setBounds(698, 136, 110, 14);
		}
		return lblHoraDeSalida;
	}
	private JTextField getTextFieldEntradaNueva() {
		if (textFieldEntradaNueva == null) {
			textFieldEntradaNueva = new JTextField();
			textFieldEntradaNueva.setEditable(false);
			textFieldEntradaNueva.setBounds(558, 161, 86, 20);
			textFieldEntradaNueva.setColumns(10);
			textFieldEntradaNueva.setText(getHoraSistema());
		}
		return textFieldEntradaNueva;
	}
	private JTextField getTextFieldSalidaNueva() {
		if (textFieldSalidaNueva == null) {
			textFieldSalidaNueva = new JTextField();
			textFieldSalidaNueva.setEditable(false);
			textFieldSalidaNueva.setBounds(698, 161, 86, 20);
			textFieldSalidaNueva.setColumns(10);
			textFieldSalidaNueva.setText(getHoraSistema30());
		}
		return textFieldSalidaNueva;
	}
	
	public String getHoraSistema() {
		Calendar calendario = Calendar.getInstance();
		int hora = calendario.get(Calendar.HOUR_OF_DAY);
		int minutos = calendario.get(Calendar.MINUTE);
		return hora + ":" + minutos;
	}
	
	public String getHoraSistema30() {
		Calendar calendario = Calendar.getInstance();
		int hora = calendario.get(Calendar.HOUR_OF_DAY);
		int minutos = calendario.get(Calendar.MINUTE);
		int minutos30 = minutos + 30;
		if (minutos30 > 59) {
			hora+=1;
			minutos30 = minutos30 - 60;
		}
		return hora + ":" + minutos30;
	}
	
	private JLabel getLblNueva() {
		if (lblNueva == null) {
			lblNueva = new JLabel("Nueva");
			lblNueva.setBounds(482, 164, 46, 14);
		}
		return lblNueva;
	}
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getTextFieldEntradaNueva().getText() != "" && getTextFieldSalidaNueva().getText() != "") {
						lh = new ListaHorarios();
						lh.creaListaHorarios();
						for (Horario h : lh.getHorarios()) {
							if (((Cita)getListIndicarHorarios().getSelectedValue()).getIdHorario() == h.getIdHorario()) {
								h.cambioHoraInicio(getTextFieldEntradaNueva().getText());
								h.cambioHoraFinal(getTextFieldSalidaNueva().getText());
								textFieldHorarioActual.setText(h.getHoraInicio() + " " + h.getHoraFin());
								ActualizarHorario ah = new ActualizarHorario();
								ah.actualizarHorario(h);
								break;
							}
						}
						lc = new ListaCitas();
						lc.creaListaCitas();
						modeloListaIndicarHorarios.clear();
						for (Cita c : lc.getListaCitas()) {
							modeloListaIndicarHorarios.addElement((Cita)c);
						}
					}
				}
			});
			btnConfirmar.setBounds(609, 225, 118, 23);
		}
		return btnConfirmar;
	}
	private JButton getBtnSalir2() {
		if (btnSalir2 == null) {
			btnSalir2 = new JButton("Salir");
			btnSalir2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanel("panelMedico");
				}
			});
			btnSalir2.setBounds(970, 481, 100, 38);
		}
		return btnSalir2;
	}
	private JTextField getTextFieldHorarioActual() {
		if (textFieldHorarioActual == null) {
			textFieldHorarioActual = new JTextField();
			textFieldHorarioActual.setEditable(false);
			textFieldHorarioActual.setBounds(590, 39, 153, 20);
			textFieldHorarioActual.setColumns(10);
			textFieldHorarioActual.setText("");
		}
		return textFieldHorarioActual;
	}
	private JLabel getLblHorarioActual() {
		if (lblHorarioActual == null) {
			lblHorarioActual = new JLabel("Horario actual");
			lblHorarioActual.setBounds(590, 11, 153, 14);
		}
		return lblHorarioActual;
	}
	private JPanel getPanelVacacionesMedicos() {
		if (panelVacacionesMedicos == null) {
			panelVacacionesMedicos = new JPanel();
			panelVacacionesMedicos.setLayout(null);
			panelVacacionesMedicos.add(getScrollPane_8());
			panelVacacionesMedicos.add(getLblMedicoSeleccionado());
			panelVacacionesMedicos.add(getTextFieldMedicoSeleccionado());
			panelVacacionesMedicos.add(getBtnSeleccionar_1());
			panelVacacionesMedicos.add(getComboBoxDiaInicioV());
			panelVacacionesMedicos.add(getLblNewLabel_12());
			panelVacacionesMedicos.add(getComboBoxMesInicioV());
			panelVacacionesMedicos.add(getComboBoxAñoInicioV());
			panelVacacionesMedicos.add(getComboBoxDiaFinV());
			panelVacacionesMedicos.add(getComboBoxMesFinV());
			panelVacacionesMedicos.add(getComboBoxAñoFinV());
			panelVacacionesMedicos.add(getLblMesInicio());
			panelVacacionesMedicos.add(getLblAoInicio());
			panelVacacionesMedicos.add(getLblDiaFin());
			panelVacacionesMedicos.add(getLblMesFin());
			panelVacacionesMedicos.add(getLblAoFin());
			panelVacacionesMedicos.add(getBtnSalirVM());
			panelVacacionesMedicos.add(getScrollPane_9());
			panelVacacionesMedicos.add(getLblVacacionesSeleccionadas());
			panelVacacionesMedicos.add(getTextFieldVacacionesMedico());
			panelVacacionesMedicos.add(getBtnSeleccionarVM());
			panelVacacionesMedicos.add(getBtnAnularVM());
			panelVacacionesMedicos.add(getBtnAsignarVM());
			panelVacacionesMedicos.add(getBtnCrearVM());
		}
		return panelVacacionesMedicos;
	}
	private JButton getBtnAsignarVacacionesA() {
		if (btnAsignarVacacionesA == null) {
			btnAsignarVacacionesA = new JButton("Asignar Vacaciones a Medicos");
			btnAsignarVacacionesA.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnAsignarVacacionesA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanel("panelVacacionesMedicos");
				}
			});
			btnAsignarVacacionesA.setBounds(45, 132, 296, 38);
		}
		return btnAsignarVacacionesA;
	}
	private JScrollPane getScrollPane_8() {
		if (scrollPane_8 == null) {
			scrollPane_8 = new JScrollPane();
			scrollPane_8.setBounds(28, 21, 297, 299);
			scrollPane_8.setViewportView(getListMedicos_1());
		}
		return scrollPane_8;
	}
	private JList getListMedicos_1() {
		if (listMedicos_1 == null) {
			modeloListMedicosVacaciones= new DefaultListModel();
			listMedicos_1 = new JList(modeloListMedicosVacaciones);
			listMedicos_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			if (lm == null) {
				lm=new ListaMedicos();
				lm.creaListaMedicos();
			}
			for(Medico m : lm.getMedicos()) {
				modeloListMedicosVacaciones.addElement((Medico)m);
			}
		}
		return listMedicos_1;
	}
	private JLabel getLblMedicoSeleccionado() {
		if (lblMedicoSeleccionado == null) {
			lblMedicoSeleccionado = new JLabel("M\u00E9dico seleccionado:");
			lblMedicoSeleccionado.setBounds(335, 23, 128, 14);
		}
		return lblMedicoSeleccionado;
	}
	private JTextField getTextFieldMedicoSeleccionado() {
		if (textFieldMedicoSeleccionado == null) {
			textFieldMedicoSeleccionado = new JTextField();
			textFieldMedicoSeleccionado.setEditable(false);
			textFieldMedicoSeleccionado.setBounds(335, 48, 216, 20);
			textFieldMedicoSeleccionado.setColumns(10);
		}
		return textFieldMedicoSeleccionado;
	}
	private JButton getBtnSeleccionar_1() {
		if (btnSeleccionar_1 == null) {
			btnSeleccionar_1 = new JButton("Seleccionar");
			btnSeleccionar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldMedicoSeleccionado.setText(((Medico)getListMedicos_1().getSelectedValue()).getNombreMedico() + " " + ((Medico)getListMedicos_1().getSelectedValue()).getApellidosMedico());
					getBtnCrearVM().setEnabled(true);
//					if (lvm == null) {
//						lvm = new ListaVacacionesMedico();
//						lvm.creaListaVacacionesMedico();
//					}
//					for (VacacionesMedico vm : lvm.getVacacionesMedicos()) {
//						if (vm.getIdMedico() == (((Medico)getListMedicos_1().getSelectedValue()).getIdMedico())) {
//							//getTextFieldVacacionesMedico().setText(vm.getFechaInicio() + " " + vm.getFechaFin());
//						}
//					}
				}
			});
			btnSeleccionar_1.setBounds(335, 79, 107, 31);
		}
		return btnSeleccionar_1;
	}
	private JComboBox getComboBoxDiaInicioV() {
		if (comboBoxDiaInicioV == null) {
			comboBoxDiaInicioV = new JComboBox();
			comboBoxDiaInicioV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			comboBoxDiaInicioV.setBounds(452, 176, 64, 20);
			comboBoxDiaInicioV.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16 ", "17 ", "18 ", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

		}
		return comboBoxDiaInicioV;
	}
	private JLabel getLblNewLabel_12() {
		if (lblNewLabel_12 == null) {
			lblNewLabel_12 = new JLabel("Dia inicio:");
			lblNewLabel_12.setBounds(352, 179, 90, 14);
		}
		return lblNewLabel_12;
	}
	private JComboBox getComboBoxMesInicioV() {
		if (comboBoxMesInicioV == null) {
			comboBoxMesInicioV = new JComboBox();
			comboBoxMesInicioV.setBounds(452, 224, 64, 20);
			comboBoxMesInicioV.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));

		}
		return comboBoxMesInicioV;
	}
	private JComboBox getComboBoxAñoInicioV() {
		if (comboBoxAñoInicioV == null) {
			comboBoxAñoInicioV = new JComboBox();
			comboBoxAñoInicioV.setBounds(452, 271, 64, 20);
			comboBoxAñoInicioV.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025"}));
		}
		return comboBoxAñoInicioV;
	}
	private JComboBox getComboBoxDiaFinV() {
		if (comboBoxDiaFinV == null) {
			comboBoxDiaFinV = new JComboBox();
			comboBoxDiaFinV.setBounds(763, 176, 64, 20);
			comboBoxDiaFinV.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16 ", "17 ", "18 ", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

		}
		return comboBoxDiaFinV;
	}
	private JComboBox getComboBoxMesFinV() {
		if (comboBoxMesFinV == null) {
			comboBoxMesFinV = new JComboBox();
			comboBoxMesFinV.setBounds(763, 224, 64, 20);
			comboBoxMesFinV.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		}
		return comboBoxMesFinV;
	}
	private JComboBox getComboBoxAñoFinV() {
		if (comboBoxAñoFinV == null) {
			comboBoxAñoFinV = new JComboBox();
			comboBoxAñoFinV.setBounds(763, 271, 64, 20);
			comboBoxAñoFinV.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025"}));

			
		}
		return comboBoxAñoFinV;
	}
	private JLabel getLblMesInicio() {
		if (lblMesInicio == null) {
			lblMesInicio = new JLabel("Mes inicio:");
			lblMesInicio.setBounds(352, 227, 90, 14);
		}
		return lblMesInicio;
	}
	private JLabel getLblAoInicio() {
		if (lblAoInicio == null) {
			lblAoInicio = new JLabel("A\u00F1o inicio:");
			lblAoInicio.setBounds(352, 274, 90, 14);
		}
		return lblAoInicio;
	}
	private JLabel getLblDiaFin() {
		if (lblDiaFin == null) {
			lblDiaFin = new JLabel("Dia fin:");
			lblDiaFin.setBounds(656, 179, 97, 14);
		}
		return lblDiaFin;
	}
	private JLabel getLblMesFin() {
		if (lblMesFin == null) {
			lblMesFin = new JLabel("Mes fin:");
			lblMesFin.setBounds(656, 227, 97, 14);
		}
		return lblMesFin;
	}
	private JLabel getLblAoFin() {
		if (lblAoFin == null) {
			lblAoFin = new JLabel("A\u00F1o Fin:");
			lblAoFin.setBounds(656, 274, 97, 14);
		}
		return lblAoFin;
	}
	private JButton getBtnSalirVM() {
		if (btnSalirVM == null) {
			btnSalirVM = new JButton("Salir");
			btnSalirVM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanel("panelAdministrativo");
				}
			});
			btnSalirVM.setBounds(1006, 519, 97, 31);
		}
		return btnSalirVM;
	}
	private JScrollPane getScrollPane_9() {
		if (scrollPane_9 == null) {
			scrollPane_9 = new JScrollPane();
			scrollPane_9.setBounds(601, 21, 226, 131);
			scrollPane_9.setViewportView(getListVacacionesMedico());
		}
		return scrollPane_9;
	}
	private JList getListVacacionesMedico() {
		if (listVacacionesMedico == null) {
			modeloListaVacacionesMedico = new DefaultListModel<VacacionesMedico>();
			listVacacionesMedico = new JList(modeloListaVacacionesMedico);
			listVacacionesMedico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			if (lvm == null) {
				lvm = new ListaVacacionesMedico();
				lvm.creaListaVacacionesMedico();
			}
			for (VacacionesMedico vm : lvm.getVacacionesMedicos()) {
				modeloListaVacacionesMedico.addElement((VacacionesMedico)vm);
			}
		}
		return listVacacionesMedico;
	}
	private JLabel getLblVacacionesSeleccionadas() {
		if (lblVacacionesSeleccionadas == null) {
			lblVacacionesSeleccionadas = new JLabel("Vacaciones Seleccionadas:");
			lblVacacionesSeleccionadas.setBounds(837, 23, 266, 14);
		}
		return lblVacacionesSeleccionadas;
	}
	private JTextField getTextFieldVacacionesMedico() {
		if (textFieldVacacionesMedico == null) {
			textFieldVacacionesMedico = new JTextField();
			textFieldVacacionesMedico.setEditable(false);
			textFieldVacacionesMedico.setBounds(837, 48, 207, 20);
			textFieldVacacionesMedico.setColumns(10);
		}
		return textFieldVacacionesMedico;
	}
	private JButton getBtnSeleccionarVM() {
		if (btnSeleccionarVM == null) {
			btnSeleccionarVM = new JButton("Seleccionar");
			btnSeleccionarVM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTextFieldVacacionesMedico().setText((((VacacionesMedico)getListVacacionesMedico().getSelectedValue()).toString()));
					getBtnAsignarVM().setEnabled(true);
					getBtnCrearVM().setEnabled(false);
				}
			});
			btnSeleccionarVM.setBounds(837, 83, 107, 31);
		}
		return btnSeleccionarVM;
	}
	private JButton getBtnAnularVM() {
		if (btnAnularVM == null) {
			btnAnularVM = new JButton("Anular");
			btnAnularVM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTextFieldVacacionesMedico().setText("");
					getBtnAsignarVM().setEnabled(false);
					getBtnCrearVM().setEnabled(true);
				}
			});
			btnAnularVM.setBounds(954, 83, 90, 31);
		}
		return btnAnularVM;
	}
	private JButton getBtnAsignarVM() {
		if (btnAsignarVM == null) {
			btnAsignarVM = new JButton("Asignar vacaciones");
			btnAsignarVM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lvm = new ListaVacacionesMedico();
					lvm.creaListaVacacionesMedico();
					Date fechaInicio = (((VacacionesMedico)getListVacacionesMedico().getSelectedValue()).getFechaInicio());
					Date fechaFin = (((VacacionesMedico)getListVacacionesMedico().getSelectedValue()).getFechaFin());
					int idVM = lvm.getVacacionesMedicos().size() + 1100;
					int idMed = ((Medico)getListMedicos_1().getSelectedValue()).getIdMedico();
					
					VacacionesMedicoDTO vmdto = new VacacionesMedicoDTO();
					vmdto.idVacacionesMedico = idVM;
					vmdto.idMedico = idMed;
					vmdto.diaInicio = fechaInicio;
					vmdto.diaFin = fechaFin;
					VacacionesMedico vm = new VacacionesMedico(vmdto);
					crearVacacionesMedicos = new CrearVacacionesMedicos();
					crearVacacionesMedicos.crearVacacionesMedico(vm);
					modeloListaVacacionesMedico.clear();
					for (VacacionesMedico vmm : lvm.getVacacionesMedicos()) {
						modeloListaVacacionesMedico.addElement((VacacionesMedico)vmm);
					}
				}
			});
			btnAsignarVM.setEnabled(false);
			btnAsignarVM.setBounds(837, 129, 207, 23);
		}
		return btnAsignarVM;
	}
	private JButton getBtnCrearVM() {
		if (btnCrearVM == null) {
			btnCrearVM = new JButton("Crear y asignar vacaciones");
			btnCrearVM.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lvm = new ListaVacacionesMedico();
					lvm.creaListaVacacionesMedico();
					int diaInicio = Integer.parseInt((String)getComboBoxDiaInicioV().getSelectedItem());
					int mesInicio = Integer.parseInt((String)getComboBoxMesInicioV().getSelectedItem());
					int añoInicio = Integer.parseInt((String)getComboBoxAñoInicioV().getSelectedItem());
					Date fechaInicio = new Date(añoInicio, mesInicio, diaInicio);
					
					int diaFin = Integer.parseInt((String)getComboBoxDiaFinV().getSelectedItem());
					int mesFin = Integer.parseInt((String)getComboBoxMesFinV().getSelectedItem());
					int añoFin = Integer.parseInt((String)getComboBoxAñoFinV().getSelectedItem());
					
					Date fechaFin= new Date(añoFin, mesFin, diaFin);
					
					int idVM = lvm.getVacacionesMedicos().size() + 1100;
					int idMed = ((Medico)getListMedicos_1().getSelectedValue()).getIdMedico();
					
					VacacionesMedicoDTO vmdto = new VacacionesMedicoDTO();
					vmdto.idVacacionesMedico = idVM;
					vmdto.idMedico = idMed;
					vmdto.diaInicio = fechaInicio;
					vmdto.diaFin = fechaFin;
					VacacionesMedico vm = new VacacionesMedico(vmdto);
					crearVacacionesMedicos = new CrearVacacionesMedicos();
					crearVacacionesMedicos.crearVacacionesMedico(vm);
					modeloListaVacacionesMedico.clear();
					for (VacacionesMedico vmm : lvm.getVacacionesMedicos()) {
						modeloListaVacacionesMedico.addElement((VacacionesMedico)vmm);
					}
				}
			});
			btnCrearVM.setEnabled(false);
			btnCrearVM.setBounds(498, 363, 183, 23);
		}
		return btnCrearVM;
	}
	private JScrollPane getScrollPane_10() {
		if (scrollPane_10 == null) {
			scrollPane_10 = new JScrollPane();
			scrollPane_10.setBounds(10, 11, 345, 435);
			scrollPane_10.setViewportView(getListCitasCausas());
		}
		return scrollPane_10;
	}
	private JList getListCitasCausas() {
		if (listCitasCausas == null) {
			modeloListaCitasCausas = new DefaultListModel<Cita>();
			listCitasCausas = new JList(modeloListaCitasCausas);
			listCitasCausas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lc = new ListaCitas();
			lc.creaListaCitas();
			for (Cita c : lc.getListaCitas()) {
				modeloListaCitasCausas.addElement((Cita)c);
			}
		}
		return listCitasCausas;
	}
	private JScrollPane getScrollPane_11() {
		if (scrollPane_11 == null) {
			scrollPane_11 = new JScrollPane();
			scrollPane_11.setBounds(837, 11, 266, 190);
			scrollPane_11.setViewportView(getListCausas());
		}
		return scrollPane_11;
	}
	private JList getListCausas() {
		if (listCausas == null) {
			modeloListaCausas = new DefaultListModel<Causa>();
			listCausas = new JList(modeloListaCausas);
			listCausas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lcs = new ListaCausas();
			lcs.creaListaCausas();
			for (Causa c : lcs.getCausas()) {
				modeloListaCausas.addElement((Causa)c);
			}
			
		}
		return listCausas;
	}
	private JPanel getPanelVacacionesEnfermeros() {
		if (panelVacacionesEnfermeros == null) {
			panelVacacionesEnfermeros = new JPanel();
			panelVacacionesEnfermeros.setLayout(null);
			panelVacacionesEnfermeros.add(getScrollPane_12());
			panelVacacionesEnfermeros.add(getLblEnfermeroSeleccionado());
			panelVacacionesEnfermeros.add(getTextFieldEnfermeroSeleccionado());
			panelVacacionesEnfermeros.add(getBtnSeleccionarEnfermero());
			panelVacacionesEnfermeros.add(getComboBoxDiaInicioVE());
			panelVacacionesEnfermeros.add(getLabel_1());
			panelVacacionesEnfermeros.add(getComboBoxMesInicioVE());
			panelVacacionesEnfermeros.add(getComboBoxAñoInicioVE());
			panelVacacionesEnfermeros.add(getComboBoxDiaFinVE());
			panelVacacionesEnfermeros.add(getComboBoxMesFinVE());
			panelVacacionesEnfermeros.add(getComboBoxAñoFinVE());
			panelVacacionesEnfermeros.add(getLabel_2());
			panelVacacionesEnfermeros.add(getLabel_3());
			panelVacacionesEnfermeros.add(getLabel_4());
			panelVacacionesEnfermeros.add(getLabel_5());
			panelVacacionesEnfermeros.add(getLabel_6());
			panelVacacionesEnfermeros.add(getButton_1());
			panelVacacionesEnfermeros.add(getScrollPane_13());
			panelVacacionesEnfermeros.add(getLabel_7());
			panelVacacionesEnfermeros.add(getTextFieldVacacionesEnfermeros());
			panelVacacionesEnfermeros.add(getBtnSeleccionarVE());
			panelVacacionesEnfermeros.add(getBtnAnularVE());
			panelVacacionesEnfermeros.add(getBtnAsignarVE());
			panelVacacionesEnfermeros.add(getBtnCrearVE());
		}
		return panelVacacionesEnfermeros;
	}
	private JScrollPane getScrollPane_12() {
		if (scrollPane_12 == null) {
			scrollPane_12 = new JScrollPane();
			scrollPane_12.setBounds(28, 21, 297, 299);
			scrollPane_12.setViewportView(getListEnfermeros());
		}
		return scrollPane_12;
	}
	private JLabel getLblEnfermeroSeleccionado() {
		if (lblEnfermeroSeleccionado == null) {
			lblEnfermeroSeleccionado = new JLabel("Enfermero seleccionado");
			lblEnfermeroSeleccionado.setBounds(335, 23, 128, 14);
		}
		return lblEnfermeroSeleccionado;
	}
	private JTextField getTextFieldEnfermeroSeleccionado() {
		if (textFieldEnfermeroSeleccionado == null) {
			textFieldEnfermeroSeleccionado = new JTextField();
			textFieldEnfermeroSeleccionado.setEditable(false);
			textFieldEnfermeroSeleccionado.setColumns(10);
			textFieldEnfermeroSeleccionado.setBounds(335, 48, 216, 20);
		}
		return textFieldEnfermeroSeleccionado;
	}
	private JButton getBtnSeleccionarEnfermero() {
		if (btnSeleccionarEnfermero == null) {
			btnSeleccionarEnfermero = new JButton("Seleccionar");
			btnSeleccionarEnfermero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldEnfermeroSeleccionado.setText(((Enfermero)getListEnfermeros().getSelectedValue()).getNombre() + " " + ((Enfermero)getListEnfermeros().getSelectedValue()).getApellidos());
					getBtnCrearVE().setEnabled(true);
				}
			});
			btnSeleccionarEnfermero.setBounds(335, 79, 107, 31);
		}
		return btnSeleccionarEnfermero;
	}
	private JComboBox getComboBoxDiaInicioVE() {
		if (comboBoxDiaInicioVE == null) {
			comboBoxDiaInicioVE = new JComboBox();
			comboBoxDiaInicioVE.setBounds(452, 176, 64, 20);
			comboBoxDiaInicioVE.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16 ", "17 ", "18 ", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		}
		return comboBoxDiaInicioVE;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Dia inicio:");
			label_1.setBounds(352, 179, 90, 14);
		}
		return label_1;
	}
	private JComboBox getComboBoxMesInicioVE() {
		if (comboBoxMesInicioVE == null) {
			comboBoxMesInicioVE = new JComboBox();
			comboBoxMesInicioVE.setBounds(452, 224, 64, 20);
			comboBoxMesInicioVE.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));

		}
		return comboBoxMesInicioVE;
	}
	private JComboBox getComboBoxAñoInicioVE() {
		if (comboBoxAñoInicioVE == null) {
			comboBoxAñoInicioVE = new JComboBox();
			comboBoxAñoInicioVE.setBounds(452, 271, 64, 20);
			comboBoxAñoInicioVE.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025"}));

		}
		return comboBoxAñoInicioVE;
	}
	private JComboBox getComboBoxDiaFinVE() {
		if (comboBoxDiaFinVE == null) {
			comboBoxDiaFinVE = new JComboBox();
			comboBoxDiaFinVE.setBounds(763, 176, 64, 20);
			comboBoxDiaFinVE.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16 ", "17 ", "18 ", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

		}
		return comboBoxDiaFinVE;
	}
	private JComboBox getComboBoxMesFinVE() {
		if (comboBoxMesFinVE == null) {
			comboBoxMesFinVE = new JComboBox();
			comboBoxMesFinVE.setBounds(763, 224, 64, 20);
			comboBoxMesFinVE.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));

		}
		return comboBoxMesFinVE;
	}
	private JComboBox getComboBoxAñoFinVE() {
		if (comboBoxAñoFinVE == null) {
			comboBoxAñoFinVE = new JComboBox();
			comboBoxAñoFinVE.setBounds(763, 271, 64, 20);
			comboBoxAñoFinVE.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025"}));

		}
		return comboBoxAñoFinVE;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Mes inicio:");
			label_2.setBounds(352, 227, 90, 14);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("A\u00F1o inicio:");
			label_3.setBounds(352, 274, 90, 14);
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("Dia fin:");
			label_4.setBounds(656, 179, 97, 14);
		}
		return label_4;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("Mes fin:");
			label_5.setBounds(656, 227, 97, 14);
		}
		return label_5;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("A\u00F1o Fin:");
			label_6.setBounds(656, 274, 97, 14);
		}
		return label_6;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("Salir");
			button_1.setBounds(1006, 519, 97, 31);
		}
		return button_1;
	}
	private JScrollPane getScrollPane_13() {
		if (scrollPane_13 == null) {
			scrollPane_13 = new JScrollPane();
			scrollPane_13.setBounds(601, 21, 226, 131);
			scrollPane_13.setViewportView(getListVacacionesEnfermeros());
		}
		return scrollPane_13;
	}
	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("Vacaciones Seleccionadas:");
			label_7.setBounds(837, 23, 266, 14);
		}
		return label_7;
	}
	private JTextField getTextFieldVacacionesEnfermeros() {
		if (textFieldVacacionesEnfermeros == null) {
			textFieldVacacionesEnfermeros = new JTextField();
			textFieldVacacionesEnfermeros.setEditable(false);
			textFieldVacacionesEnfermeros.setColumns(10);
			textFieldVacacionesEnfermeros.setBounds(837, 48, 207, 20);
		}
		return textFieldVacacionesEnfermeros;
	}
	private JButton getBtnSeleccionarVE() {
		if (btnSeleccionarVE == null) {
			btnSeleccionarVE = new JButton("Seleccionar");
			btnSeleccionarVE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTextFieldVacacionesEnfermeros().setText((((VacacionesEnfermero)getListVacacionesEnfermeros().getSelectedValue()).toString()));
					getBtnAsignarVE().setEnabled(true);
					getBtnCrearVE().setEnabled(false);
				}
			});
			btnSeleccionarVE.setBounds(837, 83, 107, 31);
		}
		return btnSeleccionarVE;
	}
	private JButton getBtnAnularVE() {
		if (btnAnularVE == null) {
			btnAnularVE = new JButton("Anular");
			btnAnularVE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTextFieldVacacionesEnfermeros().setText("");
					getBtnAsignarVE().setEnabled(false);
					getBtnCrearVE().setEnabled(true);
				}
			});
			btnAnularVE.setBounds(954, 83, 90, 31);
		}
		return btnAnularVE;
	}
	private JButton getBtnAsignarVE() {
		if (btnAsignarVE == null) {
			btnAsignarVE = new JButton("Asignar vacaciones");
			btnAsignarVE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lve = new ListaVacacionesEnfermero();
					lve.creaListaVacacionesEnfermero();
					Date fechaInicio = (((VacacionesEnfermero)getListVacacionesEnfermeros().getSelectedValue()).getFechaInicio());
					Date fechaFin = (((VacacionesEnfermero)getListVacacionesEnfermeros().getSelectedValue()).getFechaFin());
					int idVE = lve.getVacacionesEnfermero().size() + 2100;
					int idEnf = ((Enfermero)getListEnfermeros().getSelectedValue()).getIdEnfermero();
					
					VacacionesEnfermeroDTO vedto = new VacacionesEnfermeroDTO();
					vedto.idVacacionesEnfermero= idVE;
					vedto.idEnfermero = idEnf;
					vedto.diaInicio = fechaInicio;
					vedto.diaFin = fechaFin;
					VacacionesEnfermero ve = new VacacionesEnfermero(vedto);
					crearVacacionesEnfermeros = new CrearVacacionesEnfermeros();
					crearVacacionesEnfermeros.crearVacacionesEnfermero(ve);
					modeloListaVacacionesEnfermeros.clear();
					lve = new ListaVacacionesEnfermero();
					lve.creaListaVacacionesEnfermero();
					for (VacacionesEnfermero vmm : lve.getVacacionesEnfermero()) {
						modeloListaVacacionesEnfermeros.addElement((VacacionesEnfermero)vmm);
					}
				}
			});
			btnAsignarVE.setEnabled(false);
			btnAsignarVE.setBounds(837, 129, 207, 23);
		}
		return btnAsignarVE;
	}
	private JButton getBtnCrearVE() {
		if (btnCrearVE == null) {
			btnCrearVE = new JButton("Crear y asignar vacaciones");
			btnCrearVE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lve = new ListaVacacionesEnfermero();
					lve.creaListaVacacionesEnfermero();
					int diaInicio = Integer.parseInt((String)getComboBoxDiaInicioVE().getSelectedItem());
					int mesInicio = Integer.parseInt((String)getComboBoxMesInicioVE().getSelectedItem());
					int añoInicio = Integer.parseInt((String)getComboBoxAñoInicioVE().getSelectedItem());
					Date fechaInicio = new Date(añoInicio, mesInicio, diaInicio);
					
					int diaFin = Integer.parseInt((String)getComboBoxDiaFinVE().getSelectedItem());
					int mesFin = Integer.parseInt((String)getComboBoxMesFinVE().getSelectedItem());
					int añoFin = Integer.parseInt((String)getComboBoxAñoFinVE().getSelectedItem());
					
					Date fechaFin= new Date(añoFin, mesFin, diaFin);
					
					int idVE = lve.getVacacionesEnfermero().size() + 2100;
					int idEnf = ((Enfermero)getListEnfermeros().getSelectedValue()).getIdEnfermero();
					
					VacacionesEnfermeroDTO vedto = new VacacionesEnfermeroDTO();
					vedto.idVacacionesEnfermero = idVE;
					vedto.idEnfermero = idEnf;
					vedto.diaInicio = fechaInicio;
					vedto.diaFin = fechaFin;
					VacacionesEnfermero ve = new VacacionesEnfermero(vedto);
					crearVacacionesEnfermeros = new CrearVacacionesEnfermeros();
					crearVacacionesEnfermeros.crearVacacionesEnfermero(ve);
					lve = new ListaVacacionesEnfermero();
					lve.creaListaVacacionesEnfermero();
					modeloListaVacacionesEnfermeros.clear();
					for (VacacionesEnfermero vee : lve.getVacacionesEnfermero()) {
						modeloListaVacacionesEnfermeros.addElement((VacacionesEnfermero)vee);
					}
				}
			});
			btnCrearVE.setEnabled(false);
			btnCrearVE.setBounds(498, 363, 183, 23);
		}
		return btnCrearVE;
	}
	private JList getListEnfermeros() {
		if (listEnfermeros == null) {
			modeloListaEnfermeros = new DefaultListModel();
			listEnfermeros = new JList(modeloListaEnfermeros);
			listEnfermeros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			le = new ListaEnfermeros();
			le.creaListaEnfermeros();
			for(Enfermero e : le.getEnfermeros()) {
				modeloListaEnfermeros.addElement((Enfermero)e);
			}
		}
		return listEnfermeros;
	}
	private JList getListVacacionesEnfermeros() {
		if (listVacacionesEnfermeros == null) {
			modeloListaVacacionesEnfermeros = new DefaultListModel();
			listVacacionesEnfermeros = new JList(modeloListaVacacionesEnfermeros);
			listVacacionesEnfermeros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lve = new ListaVacacionesEnfermero();
			lve.creaListaVacacionesEnfermero();
			for (VacacionesEnfermero ve : lve.getVacacionesEnfermero()) {
				modeloListaVacacionesEnfermeros.addElement((VacacionesEnfermero)ve);
			}
			
		}
		return listVacacionesEnfermeros;
	}
	private JButton getBtnAsignarVacacionesA_1() {
		if (btnAsignarVacacionesA_1 == null) {
			btnAsignarVacacionesA_1 = new JButton("Asignar Vacaciones a Enfermeros");
			btnAsignarVacacionesA_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanel("PanelVacacionesEnfermeros");
				}
			});
			btnAsignarVacacionesA_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnAsignarVacacionesA_1.setBounds(351, 132, 303, 38);
		}
		return btnAsignarVacacionesA_1;
	}
	private JLabel getLblCitaSeleccionada() {
		if (lblCitaSeleccionada == null) {
			lblCitaSeleccionada = new JLabel("Cita Seleccionada:");
			lblCitaSeleccionada.setBounds(660, 224, 443, 14);
		}
		return lblCitaSeleccionada;
	}
	private JTextField getTextFieldCitaSeleccionada() {
		if (textFieldCitaSeleccionada == null) {
			textFieldCitaSeleccionada = new JTextField();
			textFieldCitaSeleccionada.setEditable(false);
			textFieldCitaSeleccionada.setBounds(660, 249, 443, 20);
			textFieldCitaSeleccionada.setColumns(10);
		}
		return textFieldCitaSeleccionada;
	}
	private JLabel getLblCausaSeleccionada() {
		if (lblCausaSeleccionada == null) {
			lblCausaSeleccionada = new JLabel("Causa Seleccionada");
			lblCausaSeleccionada.setBounds(660, 280, 443, 14);
		}
		return lblCausaSeleccionada;
	}
	private JTextField getTextFieldCausaSeleccionada() {
		if (textFieldCausaSeleccionada == null) {
			textFieldCausaSeleccionada = new JTextField();
			textFieldCausaSeleccionada.setEditable(false);
			textFieldCausaSeleccionada.setBounds(660, 305, 443, 20);
			textFieldCausaSeleccionada.setColumns(10);
		}
		return textFieldCausaSeleccionada;
	}
	private JButton getBtnEstablecerCausa() {
		if (btnEstablecerCausa == null) {
			btnEstablecerCausa = new JButton("Establecer Causa");
			btnEstablecerCausa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lcs = new ListaCausas();
					lcs.creaListaCausas();
					CausaDTO causa= new CausaDTO();
					causa.idCausa = lcs.getCausas().size() + 4100;
					causa.idCita = (((Cita)getListCitasCausas().getSelectedValue()).getIdCita());
					causa.idPaciente = (((Cita)getListCitasCausas().getSelectedValue()).getIdPaciente());
					causa.descripcion = (((Causa)getListCausas().getSelectedValue()).getDescripcion());
					Causa c = new Causa(causa);
					AsignarCausa asignarCausas = new AsignarCausa();
					asignarCausas.asignarCausa(c);
					lcs = new ListaCausas();
					lcs.creaListaCausas();
					modeloListaCausas.clear();
					for (Causa ca : lcs.getCausas()) {
						modeloListaCausas.addElement((Causa)ca);
					}
				}
			});
			btnEstablecerCausa.setEnabled(false);
			btnEstablecerCausa.setBounds(660, 336, 144, 23);
		}
		return btnEstablecerCausa;
	}
	private JLabel getLblNuevaCausa() {
		if (lblNuevaCausa == null) {
			lblNuevaCausa = new JLabel("Nueva causa:");
			lblNuevaCausa.setBounds(365, 432, 266, 14);
		}
		return lblNuevaCausa;
	}
	private JTextField getTextFieldNuevaCausa() {
		if (textFieldNuevaCausa == null) {
			textFieldNuevaCausa = new JTextField();
			textFieldNuevaCausa.setEditable(false);
			textFieldNuevaCausa.setBounds(365, 457, 266, 20);
			textFieldNuevaCausa.setColumns(10);
		}
		return textFieldNuevaCausa;
	}
	private JButton getBtnCrearYAsignarCausa() {
		if (btnCrearYAsignarCausa == null) {
			btnCrearYAsignarCausa = new JButton("Crear y asignar nueva causa");
			btnCrearYAsignarCausa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!getTextFieldNuevaCausa().getText().isEmpty()) {
						lcs = new ListaCausas();
						lcs.creaListaCausas();
						CausaDTO causa= new CausaDTO();
						causa.idCausa = lcs.getCausas().size() + 4100;
						causa.idCita = (((Cita)getListCitasCausas().getSelectedValue()).getIdCita());
						causa.idPaciente = (((Cita)getListCitasCausas().getSelectedValue()).getIdPaciente());
						causa.descripcion = getTextFieldNuevaCausa().getText();
						Causa c = new Causa(causa);
						AsignarCausa asignarCausas = new AsignarCausa();
						asignarCausas.asignarCausa(c);
						lcs = new ListaCausas();
						lcs.creaListaCausas();
						modeloListaCausas.clear();
						for (Causa ca : lcs.getCausas()) {
							modeloListaCausas.addElement((Causa)ca);
						}
					}
				}
			});
			btnCrearYAsignarCausa.setEnabled(false);
			btnCrearYAsignarCausa.setBounds(365, 488, 266, 23);
		}
		return btnCrearYAsignarCausa;
	}
	private JButton getBtnSeleccionarCita() {
		if (btnSeleccionarCita == null) {
			btnSeleccionarCita = new JButton("Seleccionar");
			btnSeleccionarCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getTextFieldCitaSeleccionada().setText(((Cita)getListCitasCausas().getSelectedValue()).toString());
					getTextFieldNuevaCausa().setEditable(true);
					getBtnCrearYAsignarCausa().setEnabled(true);
					if(!getTextFieldCitaSeleccionada().getText().isEmpty() && !getTextFieldCausaSeleccionada().getText().isEmpty()) {
						getBtnEstablecerCausa().setEnabled(true);
						getBtnCrearYAsignarCausa().setEnabled(true);
					}
				}
			});
			btnSeleccionarCita.setBounds(365, 11, 89, 23);
		}
		return btnSeleccionarCita;
	}
	private JButton getBtnSeleccionarCausa() {
		if (btnSeleccionarCausa == null) {
			btnSeleccionarCausa = new JButton("Seleccionar");
			btnSeleccionarCausa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getTextFieldCausaSeleccionada().setText(((Causa)getListCausas().getSelectedValue()).toString());
					if(!getTextFieldCitaSeleccionada().getText().isEmpty() && !getTextFieldCausaSeleccionada().getText().isEmpty()) {
						getBtnEstablecerCausa().setEnabled(true);
						getBtnCrearYAsignarCausa().setEnabled(true);
						getTextFieldNuevaCausa().setEditable(true);
					}
				}
			});
			btnSeleccionarCausa.setBounds(738, 9, 89, 23);
		}
		return btnSeleccionarCausa;
	}
	private JButton getBtnSalirAsignarCausas() {
		if (btnSalirAsignarCausas == null) {
			btnSalirAsignarCausas = new JButton("Salir");
			btnSalirAsignarCausas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanel("panelMedico");
				}
			});
			btnSalirAsignarCausas.setBounds(1014, 527, 89, 23);
		}
		return btnSalirAsignarCausas;
	}
}
