package pgh.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pgh.business.medico.ListaMedicos;
import java.awt.Color;
import javax.swing.JLabel;
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
	private JComboBox comboBoxFecha;
	private JLabel lblFecha;
	private JLabel lblHoraInicio;
	private JLabel lblHoraFin;
	private JLabel lblUbicacion;
	private JComboBox comboBoxUbicacion;
	private JComboBox comboBoxHoraInicio;
	private JComboBox comboBoxHoraFin;
	private JButton btnCrearCita;
	private JButton btncancelarCita;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					
					ListaMedicos lm = new ListaMedicos();
					
					lm.listarMedicos();
					
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
			panelCitas.add(getComboBoxFecha());
			panelCitas.add(getLblFecha());
			panelCitas.add(getLblHoraInicio());
			panelCitas.add(getLblHoraFin());
			panelCitas.add(getLblUbicacion());
			panelCitas.add(getComboBoxUbicacion());
			panelCitas.add(getComboBoxHoraInicio());
			panelCitas.add(getComboBoxHoraFin());
			panelCitas.add(getBtnCrearCita());
			panelCitas.add(getBtncancelarCita());
			panelCitas.add(getLblNewLabel_1());
		}
		return panelCitas;
	}
	private JComboBox getComboBoxMedicos() {
		if (comboBoxMedicos == null) {
			comboBoxMedicos = new JComboBox();
			comboBoxMedicos.setBounds(320, 203, 347, 22);
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
		if (comboBoxPaciente == null) {
			comboBoxPaciente = new JComboBox();
			comboBoxPaciente.setBounds(320, 145, 347, 22);
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
	private JComboBox getComboBoxFecha() {
		if (comboBoxFecha == null) {
			comboBoxFecha = new JComboBox();
			comboBoxFecha.setBounds(320, 273, 347, 22);
		}
		return comboBoxFecha;
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
			lblHoraFin.setBounds(714, 199, 95, 22);
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
		}
		return comboBoxUbicacion;
	}
	private JComboBox getComboBoxHoraInicio() {
		if (comboBoxHoraInicio == null) {
			comboBoxHoraInicio = new JComboBox();
			comboBoxHoraInicio.setBounds(840, 145, 157, 22);
		}
		return comboBoxHoraInicio;
	}
	private JComboBox getComboBoxHoraFin() {
		if (comboBoxHoraFin == null) {
			comboBoxHoraFin = new JComboBox();
			comboBoxHoraFin.setBounds(840, 203, 157, 22);
		}
		return comboBoxHoraFin;
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
}
