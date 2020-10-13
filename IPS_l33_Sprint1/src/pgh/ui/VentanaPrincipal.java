package pgh.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pgh.business.medico.ListaMedicos;
import pgh.business.medico.Medico;
import pgh.business.paciente.ListaPacientes;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;

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
	private JComboBox comboBoxMedicos;
	private JLabel lblMedicos;
	private JComboBox comboBoxPaciente;
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
	private JLabel lblconsultaDuracion;
	private JPanel panelJornadasMedico;
	private JButton btnAsignarJornadasMedicos;
	private JButton btnAsignarJornadasAEnfermeros;
	private JComboBox comboBoxMedicosJornada;
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
	private JLabel lblNewLabel_7;
	private JScrollPane scrollPane;
	private JList list;
	private JButton btnNewButton_1;
	private JScrollPane scrollPaneDiasSeleccionados;
	private JTextArea textAreaDiasSeleccionados;

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
		setTitle("Gestor Hospital");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1045, 562);
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
			lblNewLabel.setBounds(699, 22, 217, 209);
		}
		return lblNewLabel;
	}
	private JLabel getLblCentroMedico() {
		if (lblCentroMedico == null) {
			lblCentroMedico = new JLabel("CENTRO MEDICO");
			lblCentroMedico.setFont(new Font("Sitka Small", Font.PLAIN, 40));
			lblCentroMedico.setBounds(191, 98, 404, 52);
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
			btnAdministrativo.setBounds(329, 224, 286, 52);
		}
		return btnAdministrativo;
	}
	private JButton getBtnEntrarComoMdico() {
		if (btnEntrarComoMdico == null) {
			btnEntrarComoMdico = new JButton("Entrar como m\u00E9dico");
			btnEntrarComoMdico.setFocusable(false);
			btnEntrarComoMdico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					cambiarPanel("panelMedico");
				}
			});
			btnEntrarComoMdico.setForeground(Color.WHITE);
			btnEntrarComoMdico.setBackground(Color.RED);
			btnEntrarComoMdico.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnEntrarComoMdico.setBounds(329, 298, 286, 52);
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
			btnAdministrativo_1_1.setBounds(329, 380, 286, 52);
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
			
		}
		else if (nombre=="panelAdministrativo"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(true);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			
		}
		else if (nombre=="panelMedico"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(true);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
		}
		else if (nombre=="panelEnfermero"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(true);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(false);
			
		}
		else if (nombre=="panelCitas"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(true);
			panelJornadasMedico.setVisible(false);
			
		}
		else if (nombre=="panelJornadas"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			panelJornadasMedico.setVisible(true);
			
		}
	}
	private JPanel getPanelMedico() {
		if (panelMedico == null) {
			panelMedico = new JPanel();
			panelMedico.setBackground(Color.WHITE);
			panelMedico.setLayout(null);
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
			panelCitas.add(getComboBoxMedicosCita());
			panelCitas.add(getLblMedicos());
			panelCitas.add(getComboBoxPacienteCita());
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
			panelCitas.add(getLblconsultaDuracion());
		}
		return panelCitas;
	}
	private JComboBox getComboBoxMedicosCita() {
		lm=new ListaMedicos();
		if (comboBoxMedicos == null) {
			comboBoxMedicos = new JComboBox();
			comboBoxMedicos.setBounds(320, 203, 347, 22);
			lm.creaListaMedicos();
			String[] medico = new String[lm.getMedicos().size()];
			int i=0;
			for(int j=0; j<lm.getMedicos().size();j++) {
				 medico[i] = lm.getMedicos().get(j).toString();
				 i++;
			}
			 comboBoxMedicos.setModel(new DefaultComboBoxModel<String>(medico));
			
		}
		return comboBoxMedicos;
	}
	private JLabel getLblMedicos() {
		if (lblMedicos == null) {
			lblMedicos = new JLabel("Seleccionar Medicos :");
			lblMedicos.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblMedicos.setBounds(83, 199, 211, 22);
		}
		return lblMedicos;
	}
	private JComboBox getComboBoxPacienteCita() {
		if (comboBoxPaciente == null) {
			comboBoxPaciente = new JComboBox();
			comboBoxPaciente.setBounds(320, 145, 347, 22);
			lp=new ListaPacientes();
			lp.creaListaPacientes();
			String[] paciente = new String[lp.getPacientes().size()];
			int i=0;
			for(int j=0; j<lp.getPacientes().size();j++) {
				 paciente[i] = lp.getPacientes().get(j).toString();
				 i++;
			}
			 comboBoxPaciente.setModel(new DefaultComboBoxModel<String>(paciente));
			
		}
		return comboBoxPaciente;
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
			comboBoxAnoCita.setBounds(320, 273, 100, 22);
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
			lblFecha.setBounds(83, 269, 191, 22);
		}
		return lblFecha;
	}
	private JLabel getLblHoraInicio() {
		if (lblHoraInicio == null) {
			lblHoraInicio = new JLabel("Hora Inicio :");
			lblHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblHoraInicio.setBounds(714, 141, 116, 22);
		}
		return lblHoraInicio;
	}
	private JLabel getLblHoraFin() {
		if (lblHoraFin == null) {
			lblHoraFin = new JLabel("Hora Fin :");
			lblHoraFin.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblHoraFin.setBounds(714, 195, 95, 22);
		}
		return lblHoraFin;
	}
	private JLabel getLblUbicacion() {
		if (lblUbicacion == null) {
			lblUbicacion = new JLabel("Ubicacion :");
			lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblUbicacion.setBounds(83, 341, 109, 22);
		}
		return lblUbicacion;
	}
	private JComboBox getComboBoxUbicacion() {
		if (comboBoxUbicacion == null) {
			comboBoxUbicacion = new JComboBox();
			comboBoxUbicacion.setFocusable(false);
			comboBoxUbicacion.setBounds(320, 345, 347, 22);
			String[] consultas = new String[10];
			for(int i=0; i<consultas.length;i++) {
				int suma =i+1;
				consultas[i]="Consulta " + suma;
			}
			comboBoxUbicacion.setModel(new DefaultComboBoxModel<String>(consultas));
		}
		return comboBoxUbicacion;
	}
	
	private JComboBox getComboBoxHorasFinCita() {
		if (comboBoxHorasFinCita == null) {
			comboBoxHorasFinCita = new JComboBox();
			comboBoxHorasFinCita.setFocusable(false);
			comboBoxHorasFinCita.setBounds(840, 195, 57, 22);
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
			comboBoxHorasInicioCita.setBounds(840, 145, 57, 22);
			
			
			
		}
		return comboBoxHorasInicioCita;
	}

	private JButton getBtnCrearCita() {
		if (btnCrearCita == null) {
			btnCrearCita = new JButton("Crear Cita");
			btnCrearCita.setFocusable(false);
			btnCrearCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					 
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
			lblNewLabel_1.setBounds(381, 41, 235, 46);
		}
		return lblNewLabel_1;
	}
	private JComboBox getComboBoxMinutosInicioCita() {
		if (comboBoxMinutosInicioCita == null) {
			comboBoxMinutosInicioCita = new JComboBox();
			comboBoxMinutosInicioCita.setFocusable(false);
			comboBoxMinutosInicioCita.setModel(new DefaultComboBoxModel(new String[] {"00", "15", "30", "45"}));
			comboBoxMinutosInicioCita.setBounds(923, 145, 57, 22);
		}
		return comboBoxMinutosInicioCita;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel(":");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_2.setBounds(907, 138, 12, 29);
		}
		return lblNewLabel_2;
	}
	private JComboBox getComboBox_1() {
		if (comboBoxMinutosFinCita == null) {
			comboBoxMinutosFinCita = new JComboBox();
			comboBoxMinutosFinCita.setFocusable(false);
			comboBoxMinutosFinCita.setModel(new DefaultComboBoxModel(new String[] {"00", "15", "30", "45"}));
			comboBoxMinutosFinCita.setBounds(923, 195, 57, 22);
		}
		return comboBoxMinutosFinCita;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel(":");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_3.setBounds(907, 195, 21, 18);
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
			comboBoxMesCita.setBounds(442, 273, 100, 22);
			
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
			comboBoxDiaDia.setBounds(573, 273, 94, 22);
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
	private JLabel getLblconsultaDuracion() {
		if (lblconsultaDuracion == null) {
			lblconsultaDuracion = new JLabel("Nota : La cita no puede durar mas de 2 horas");
			lblconsultaDuracion.setForeground(Color.RED);
			lblconsultaDuracion.setBounds(714, 116, 266, 14);
		}
		return lblconsultaDuracion;
	}
	private JPanel getPanelJornadasMedico() {
		if (panelJornadasMedico == null) {
			panelJornadasMedico = new JPanel();
			panelJornadasMedico.setBackground(Color.WHITE);
			panelJornadasMedico.setLayout(null);
			panelJornadasMedico.add(getComboBoxMedicosJornada());
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
			panelJornadasMedico.add(getLblNewLabel_7());
			panelJornadasMedico.add(getScrollPane());
			panelJornadasMedico.add(getBtnNewButton_1());
			panelJornadasMedico.add(getScrollPaneDiasSeleccionados());
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
	private JComboBox getComboBoxMedicosJornada() {
		if (comboBoxMedicosJornada == null) {
			comboBoxMedicosJornada = new JComboBox();
			comboBoxMedicosJornada.setFocusable(false);
			comboBoxMedicosJornada.setBounds(379, 77, 359, 22);
			
			lm = new ListaMedicos();
			lm.creaListaMedicos();
			String[] medico = new String[lm.getMedicos().size()];
			int i=0;
			for(int j=0; j<lm.getMedicos().size();j++) {
				 medico[i] = lm.getMedicos().get(j).toString();
				 i++;
			}
			 comboBoxMedicosJornada.setModel(new DefaultComboBoxModel<String>(medico));
			
			
		}
		return comboBoxMedicosJornada;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Seleccionar Medico :");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_4.setBounds(236, 76, 147, 22);
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
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("Nota: marcar mas de un dia si quieres varios.");
			lblNewLabel_7.setForeground(Color.RED);
			lblNewLabel_7.setBounds(414, 376, 315, 14);
		}
		return lblNewLabel_7;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(295, 362, 88, 127);
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		}
		return list;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("A\u00F1adir dias");
			btnNewButton_1.setBounds(176, 434, 89, 23);
		}
		return btnNewButton_1;
	}
	private JScrollPane getScrollPaneDiasSeleccionados() {
		if (scrollPaneDiasSeleccionados == null) {
			scrollPaneDiasSeleccionados = new JScrollPane();
			scrollPaneDiasSeleccionados.setBounds(414, 401, 207, 86);
			scrollPaneDiasSeleccionados.setViewportView(getTextAreaDiasSeleccionados());
		}
		return scrollPaneDiasSeleccionados;
	}
	private JTextArea getTextAreaDiasSeleccionados() {
		if (textAreaDiasSeleccionados == null) {
			textAreaDiasSeleccionados = new JTextArea();
		}
		return textAreaDiasSeleccionados;
	}
}
