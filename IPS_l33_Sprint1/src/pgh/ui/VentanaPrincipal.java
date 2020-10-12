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
	private JComboBox comboBoxAno;
	private JLabel lblFecha;
	private JLabel lblHoraInicio;
	private JLabel lblHoraFin;
	private JLabel lblUbicacion;
	private JComboBox comboBoxUbicacion;
	private JComboBox comboBoxHorasFin;
	private JComboBox comboBoxHorasInicio;
	private JButton btnCrearCita;
	private JButton btncancelarCita;
	private JLabel lblNewLabel_1;
	private JComboBox comboBoxMinutosInicio;
	private JLabel lblNewLabel_2;
	private JComboBox comboBoxMinutosFin;
	private JLabel lblNewLabel_3;
	private JComboBox comboBoxMes;
	private JComboBox comboBoxFechaDia;
	private JComboBox comboBoxDia;
	private ListaMedicos lm;
	private ListaPacientes lp;
	private JLabel lblconsultaDuracion;

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
		}
		return panelAdministrativo;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
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
			
		}
		else if (nombre=="panelAdministrativo"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(true);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
			
		}
		else if (nombre=="panelMedico"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(true);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(false);
		}
		else if (nombre=="panelEnfermero"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(true);
			panelCitas.setVisible(false);
			
		}
		else if (nombre=="panelCitas"){
			panelPrincipal.setVisible(false);
			panelAdministrativo.setVisible(false);
			panelMedico.setVisible(false);
			panelEnfermero.setVisible(false);
			panelCitas.setVisible(true);
			
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
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanel("panelCitas");
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton.setBounds(395, 121, 147, 38);
		}
		return btnNewButton;
	}
	private JPanel getPanelCitas() {
		if (panelCitas == null) {
			panelCitas = new JPanel();
			panelCitas.setBackground(Color.WHITE);
			panelCitas.setLayout(null);
			panelCitas.add(getComboBoxMedicos());
			panelCitas.add(getLblMedicos());
			panelCitas.add(getComboBoxPaciente());
			panelCitas.add(getLblPaciente());
			panelCitas.add(getComboBoxAno());
			panelCitas.add(getLblFecha());
			panelCitas.add(getLblHoraInicio());
			panelCitas.add(getLblHoraFin());
			panelCitas.add(getLblUbicacion());
			panelCitas.add(getComboBoxUbicacion());
			panelCitas.add(getComboBoxHorasInicio());
			panelCitas.add(getComboBoxHorasFin());
			panelCitas.add(getBtnCrearCita());
			panelCitas.add(getBtncancelarCita());
			panelCitas.add(getLblNewLabel_1());
			panelCitas.add(getComboBoxMinutosInicio());
			panelCitas.add(getLblNewLabel_2());
			panelCitas.add(getComboBox_1());
			panelCitas.add(getLblNewLabel_3());
			panelCitas.add(getComboBoxMes());
			panelCitas.add(getComboBoxDia());
			panelCitas.add(getLblconsultaDuracion());
		}
		return panelCitas;
	}
	private JComboBox getComboBoxMedicos() {
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
	private JComboBox getComboBoxPaciente() {
		lp=new ListaPacientes();
		if (comboBoxPaciente == null) {
			comboBoxPaciente = new JComboBox();
			comboBoxPaciente.setBounds(320, 145, 347, 22);
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
	private JComboBox getComboBoxAno() {
		if (comboBoxAno == null) {
			comboBoxAno = new JComboBox();
			comboBoxAno.setBounds(320, 273, 100, 22);
			String[] listaAños = new String[5];
			for (int i = 0; i < listaAños.length; i++) {
				listaAños[i] = String.valueOf(2021 + i);
			}
			comboBoxAno.setModel(new DefaultComboBoxModel<String>(listaAños));
		}
		return comboBoxAno;
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
	
	private JComboBox getComboBoxHorasFin() {
		if (comboBoxHorasFin == null) {
			comboBoxHorasFin = new JComboBox();
			comboBoxHorasFin.setBounds(840, 195, 57, 22);
			String[] horas = new String[2];
			horas[0]="08";
			horas[1]="09";
			comboBoxHorasFin.setModel(new DefaultComboBoxModel<String>(horas));
		}
		return comboBoxHorasFin;
	}
	
    private void hastaQueHora (Object selectedItem) {
		
		String horaInicial = (String) selectedItem;
		String[] horas = new String[2];
		System.out.print(horaInicial);
		if(horaInicial.contains("09")) {
			horas[0]="09";
			horas[1]="10";
			comboBoxHorasFin.setModel(new DefaultComboBoxModel<String>(horas));
		}
		if(horaInicial.contains("10")) {
			horas[0]="10";
			horas[1]="11";
			comboBoxHorasFin.setModel(new DefaultComboBoxModel<String>(horas));
		}
		
		if(horaInicial.contains("11")) {
			horas[0]="11";
			horas[1]="12";
			comboBoxHorasFin.setModel(new DefaultComboBoxModel<String>(horas));
		}
		
		if(horaInicial.contains("12")) {
			horas[0]="12";
			horas[1]="13";
			comboBoxHorasFin.setModel(new DefaultComboBoxModel<String>(horas));
		}
		
		if(horaInicial.contains("13")) {
			horas[0]="13";
			horas[1]="14";
			comboBoxHorasFin.setModel(new DefaultComboBoxModel<String>(horas));
		}
		
		if(horaInicial.contains("14")) {
			horas[0]="14";
			horas[1]="15";
			comboBoxHorasFin.setModel(new DefaultComboBoxModel<String>(horas));
		}
		
		if(horaInicial.contains("15")) {
			horas[0]="15";
			horas[1]="16";
			comboBoxHorasFin.setModel(new DefaultComboBoxModel<String>(horas));
		}
		if(horaInicial.contains("16")) {
			horas[0]="16";
			horas[1]="17";
			comboBoxHorasFin.setModel(new DefaultComboBoxModel<String>(horas));
		}
		if(horaInicial.contains("17")) {
			horas[0]="17";
			horas[1]="18";
			comboBoxHorasFin.setModel(new DefaultComboBoxModel<String>(horas));
		}
		if(horaInicial.contains("18")) {
			horas[0]="18";
			horas[1]="19";
			comboBoxHorasFin.setModel(new DefaultComboBoxModel<String>(horas));
		}
		if(horaInicial.contains("19")) {
			horas[0]="19";
			horas[1]="20";
			comboBoxHorasFin.setModel(new DefaultComboBoxModel<String>(horas));
		}
		
		
	}
    
	private JComboBox getComboBoxHorasInicio() {
		if (comboBoxHorasInicio == null) {
			comboBoxHorasInicio = new JComboBox();
			comboBoxHorasInicio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					hastaQueHora(comboBoxHorasInicio.getSelectedItem());
				}
			});
			comboBoxHorasInicio.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"}));
			comboBoxHorasInicio.setBounds(840, 145, 57, 22);
			
			
			
		}
		return comboBoxHorasInicio;
	}

	private JButton getBtnCrearCita() {
		if (btnCrearCita == null) {
			btnCrearCita = new JButton("Crear Cita");
			btnCrearCita.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCrearCita.setBounds(719, 468, 125, 23);
		}
		return btnCrearCita;
	}
	private JButton getBtncancelarCita() {
		if (btncancelarCita == null) {
			btncancelarCita = new JButton("Cancelar");
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
	private JComboBox getComboBoxMinutosInicio() {
		if (comboBoxMinutosInicio == null) {
			comboBoxMinutosInicio = new JComboBox();
			comboBoxMinutosInicio.setModel(new DefaultComboBoxModel(new String[] {"00", "15", "30", "45"}));
			comboBoxMinutosInicio.setBounds(923, 145, 57, 22);
		}
		return comboBoxMinutosInicio;
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
		if (comboBoxMinutosFin == null) {
			comboBoxMinutosFin = new JComboBox();
			comboBoxMinutosFin.setModel(new DefaultComboBoxModel(new String[] {"00", "15", "30", "45"}));
			comboBoxMinutosFin.setBounds(923, 195, 57, 22);
		}
		return comboBoxMinutosFin;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel(":");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_3.setBounds(907, 195, 21, 18);
		}
		return lblNewLabel_3;
	}
	private JComboBox getComboBoxMes() {
		if (comboBoxMes == null) {
			comboBoxMes = new JComboBox();
			comboBoxMes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					cambiarDias(comboBoxMes.getSelectedItem());
				}
			});
			
			comboBoxMes.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
			comboBoxMes.setBounds(442, 273, 100, 22);
			
		}
		return comboBoxMes;
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
			comboBoxDia.setModel(new DefaultComboBoxModel<String>(dias31));
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
			comboBoxDia.setModel(new DefaultComboBoxModel<String>(dias29));
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
			comboBoxDia.setModel(new DefaultComboBoxModel<String>(dias30));
		}
		
	}

	private JComboBox getComboBoxDia() {
		if (comboBoxDia == null) {
			comboBoxDia = new JComboBox();
			comboBoxDia.setBounds(573, 273, 94, 22);
			String[] dias31 = new String[31];
				for(int i=1; i<32;i++) {
					if(i<10) {
						dias31[i-1]="0"+String.valueOf(i);
					}
					else {
						dias31[i-1]=String.valueOf(i);
					}
				}
				comboBoxDia.setModel(new DefaultComboBoxModel<String>(dias31));
			
		}
		return comboBoxDia;
	}
	private JLabel getLblconsultaDuracion() {
		if (lblconsultaDuracion == null) {
			lblconsultaDuracion = new JLabel("Nota : La cita no puede durar mas de 2 horas");
			lblconsultaDuracion.setForeground(Color.RED);
			lblconsultaDuracion.setBounds(714, 116, 266, 14);
		}
		return lblconsultaDuracion;
	}
}
