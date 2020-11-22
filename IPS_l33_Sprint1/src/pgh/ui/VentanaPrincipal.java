package pgh.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import pgh.business.cie10.Nodo;
import pgh.business.cie10.NodoMayor;
import pgh.business.cie10.ReadFile;
import pgh.business.cita.Cita;
import pgh.business.cita.FindAllCitas;
import pgh.business.cita.ListaCitas;
import pgh.business.enfermero.ListaEnfermeros;
import pgh.business.jornadaenfermero.CrearJornadaEnfermero;
import pgh.business.medicamento.ListaMedicamentos;
import pgh.business.medico.ListaMedicos;
import pgh.business.medico.Medico;
import pgh.business.paciente.ListaPacientes;
import pgh.business.prescripcion.ListaPrescripciones;
import pgh.business.prescripcion.Prescripcion;
import pgh.ui.paneles.PanelAdministrativo;
import pgh.ui.paneles.PanelLoginEnfermero;
import pgh.ui.paneles.PanelMedico;
import pgh.ui.paneles.filtros.JListFiltroLoginMedico;


public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelContenido;
	private JPanel panelPrincipal;
	private JLabel lblNewLabel;
	private JLabel lblCentroMedico;
	private JButton btnAdministrativo;
	private JButton btnEntrarComoMdico;
	private JButton btnAdministrativo_1_1;
	private JButton btnSalir;
	private JPanel panelMedico;
	private JPanel panelEnfermero;
	private JButton btnAsignarCita;
	private ListaMedicos lm;
	private ListaPacientes lp;
	private JPanel panelJornadasMedico;
	private JButton btnAsignarJornadasMedicos;
	private JButton btnAsignarJornadasAEnfermeros;
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
	private JLabel lblNewLabel_16;
	private DefaultListModel<Prescripcion> modeloListPrescripciones;
	private JButton btnIndicarPrescripcion;
	private JButton btnAnadirNuevaPrescripcion;
	private JScrollPane scrollPanePrescripciones;
	private JList listPrescripciones;
	private JList listPrescripcionSeleccionada;
	private ListaPrescripciones listaPrescripciones;
	private DefaultListModel<Prescripcion> modeloListPrescripcionesSeleccionada;
	private JPanel panelLoginMedico;
	private int id_medico;
	private JListFiltroLoginMedico listMedicosLogin;
	private JButton btnSeleccionarMedicoLogin;
	private JScrollPane scrollPane_5;
	private JList listMedicoLogueado;
	private JButton btnEliminarMedicoLogueado;
	private JButton btnSiguienteLogin;
	private JButton btnCancelar;
	private JButton btnSalirPanelMedico;
	private JScrollPane scrollPane_4;
	private DefaultListModel<Medico> modeloListaMedicosLogin;
	private DefaultListModel<Medico> modeloListaMedicosLogueados;
	private JButton btnNewButton;
	private JButton btnComprobarVacacionesSolicitadas;
	private List<NodoMayor> nodos;
	private NodoMayor raiz;


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
		
		raiz = new NodoMayor();
		nodos = raiz.getNodos();
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
			panelContenido.add(getPanelLoginMedico(), "name_186491911563700");
			

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

					PanelAdministrativo panel = new PanelAdministrativo(panelPrincipal, panelContenido);
					panelContenido.add(panel);
					panelPrincipal.setVisible(false);
					panel.setVisible(true);
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
					PanelLoginEnfermero panel = new PanelLoginEnfermero(panelPrincipal,panelContenido);
					panelContenido.add(panel);
					panelPrincipal.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnAdministrativo_1_1.setForeground(Color.WHITE);
			btnAdministrativo_1_1.setBackground(Color.RED);
			btnAdministrativo_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnAdministrativo_1_1.setBounds(362, 380, 286, 52);
		}
		return btnAdministrativo_1_1;
	}

	
	
	private void cambiarPanel(String nombre) {

		if (nombre == "panelPrincipal") {
			panelPrincipal.setVisible(true);
			panelLoginMedico.setVisible(false);


		
		} else if (nombre == "panelMedico") {
			panelPrincipal.setVisible(false);
			panelLoginMedico.setVisible(false);

		
		} else if (nombre == "panelLoginMedico") {
			panelPrincipal.setVisible(false);
			panelLoginMedico.setVisible(true);

		}
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
			panelLoginMedico.add(getBtnCancelar());

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
			lm = new ListaMedicos();
			lm.creaListaMedicos();
			for (Medico m : lm.getMedicos()) {
				modeloListaMedicosLogin.addElement((Medico) m);
			}

			listMedicosLogin = new JListFiltroLoginMedico(modeloListaMedicosLogin);
			panelLoginMedico.add(listMedicosLogin.gettextoFiltro());
			listMedicosLogin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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

					if(modeloListaMedicosLogueados.isEmpty()) {
						JOptionPane.showMessageDialog(getBtnSiguienteLogin(), "Selecciones un medico para continuar");
					}
					else {
						id_medico = modeloListaMedicosLogueados.getElementAt(0).getIdMedico();
						PanelMedico pc = new PanelMedico(panelLoginMedico, id_medico, panelContenido);
						panelContenido.add(pc);
						panelLoginMedico.setVisible(false);
						pc.setVisible(true);
					}
					
				}
			});
			btnSiguienteLogin.setBounds(807, 503, 89, 23);
		}
		return btnSiguienteLogin;
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


	private JLabel getLblNewLabel_16() {
		if (lblNewLabel_16 == null) {
			lblNewLabel_16 = new JLabel("");
			lblNewLabel_16.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/f1d0807f8ffad0197757d840bdc97d0b-icono-de-registro-medico-by-vexels.png")));
			lblNewLabel_16.setBounds(324, 0, 744, 550);
		}
		return lblNewLabel_16;
	}

	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarPanel("panelPrincipal");
				}
			});
			btnCancelar.setBounds(938, 503, 89, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnSalirPanelMedico() {
		if (btnSalirPanelMedico == null) {
			btnSalirPanelMedico = new JButton("Salir");
			btnSalirPanelMedico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					cambiarPanel("panelPrincipal");
				}
			});
			btnSalirPanelMedico.setBounds(944, 504, 124, 46);
		}
		return btnSalirPanelMedico;
	}
	

}
