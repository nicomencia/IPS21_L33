package pgh.ui.paneles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import pgh.business.cita.Cita;
import pgh.business.cita.CitaDTO;
import pgh.business.cita.CrearCitas;
import pgh.business.cita.ListaCitas;
import pgh.business.enfermero.ActualizarEquipoEnfermero;
import pgh.business.enfermero.Enfermero;
import pgh.business.enfermero.ListaEnfermeros;
import pgh.business.equipomedico.CrearEquipoMedico;
import pgh.business.equipomedico.EquipoMedico;
import pgh.business.equipomedico.EquipoMedicoDTO;
import pgh.business.equipomedico.ListaEquiposMedicos;
import pgh.business.medico.ActualizarEquipoMedico;
import pgh.business.medico.ListaMedicos;
import pgh.business.medico.Medico;
import pgh.business.medicocita.CrearMedicoCita;
import pgh.business.medicocita.ListaMedicoCita;
import pgh.business.medicocita.MedicoCita;
import pgh.business.medicocita.MedicoCitaDTO;
import pgh.business.paciente.ListaPacientes;
import pgh.business.paciente.Paciente;
import pgh.business.ubicacion.ListaUbicaciones;
import pgh.business.ubicacion.Ubicacion;
import pgh.business.vacacionesSolicitadas.VacacionesSolicitadasMedicoDTO;
import pgh.business.vacacionesmedico.FindAllVacacionesMedico;
import pgh.business.vacacionesmedico.VacacionesMedico;
import pgh.business.vacacionesmedico.VacacionesMedicoDTO;
import pgh.ui.paneles.filtros.JListFiltroEnfermerosCita;
import pgh.ui.paneles.filtros.JListFiltroEnfermerosEquipo;
import pgh.ui.paneles.filtros.JListFiltroMedicosEquipo;


public class PanelMiembrosEquipoMedico extends JPanel {
	private JButton btnEliminarMedicoCita;
	private DefaultListModel<Enfermero> modeloListEnfermeros;
	private DefaultListModel<Enfermero> modeloListEnfermerosAnadidos;
	private DefaultListModel<Paciente> modeloListPacienteCita;
	private DefaultListModel<Medico> modeloListMedicosAnadidos;
	private EquipoMedicoDTO equipoMedicoDTO;
	private Cita cita;
	private CrearEquipoMedico crearEquipoMedico;
	private ListaCitas lc;
	private ListaEquiposMedicos lem;
	private DefaultComboBoxModel<Ubicacion> modeloComboUbicacionesCita;
	private ListaMedicos lm; // Rep
	private ListaEnfermeros le; // Rep
	private ListaUbicaciones lu;
	private DefaultListModel<Medico> modeloListMedicos; // Rep
	private JScrollPane scrollPaneMedicos;
	private JScrollPane scrollPaneEnfermeros;
	private JScrollPane scrollPaneEnfermerosAnadidos;
	private JButton btnAnadirMedicos;
	private JListFiltroMedicosEquipo listMedicos; // Rep
	private JListFiltroEnfermerosEquipo listEnfermeros;
	private JList<Enfermero> listEnfermerosAnadidos;
	private JScrollPane scrollPaneMedicosAnadidos;
	private JList<Medico> listMedicosAnadidos;
	private JLabel lblMedicos;
	private JComboBox comboBoxAnoCita;
	private JButton btnCrearEquipo;
	private JButton btncancelarCita;
	private JButton btnAnadirEnfermeros;
	private JButton btnEliminarEnfermeros;
	private JComboBox comboBoxFechaDia;
	private MedicoCita medicoCita;
	private MedicoCitaDTO medicoCitaDTO;
	private CrearMedicoCita crearMedicoCita;
	private PanelCitas panelAnterior;
	private JTextField textFieldMedicos;
	private JTextField textFieldpacientes;
	private JPanel panelcita;
	private JLabel lblNewLabel;
	private JPanel panelContenido;
	private FindAllVacacionesMedico findVacaciones;
	private VacacionesMedico vm;
	private VacacionesMedicoDTO vmDTO;
	private List<VacacionesMedico> vacaciones = new ArrayList<VacacionesMedico>();
	private int idEquipoMedico;
	private JCheckBox chckbxAnadirTodosMed;
	private JLabel lblEnfermeros;
	private JCheckBox chckbxAnadirTodosEnf;

	public PanelMiembrosEquipoMedico(PanelCitas panelAnterior, JPanel panelContenido, int idEquipoMedico) {
		this.panelAnterior = panelAnterior;
		this.panelContenido = panelContenido;
		this.idEquipoMedico = idEquipoMedico;
		panelcita = this;
		getPanelCitas();
	}

	private void getPanelCitas() {

		this.setBackground(new Color(135, 206, 235));
		this.setLayout(null);
		this.add(getLblMedicos());
		this.add(getBtnCrearEquipo());
		this.add(getBtncancelarCita());
		this.add(getScrollPaneMedicos());
		this.add(getBtnAnadirMedicos());
		this.add(getScrollPaneMedicosAnadidos());
		this.add(getBtnEliminarMedicoCita());
		this.add(getScrollPaneEnfermeros());
		this.add(getBtnAnadirEnfermeros());
		this.add(getScrollPaneEnfermerosAnadidos());
		this.add(getBtnEliminarEnfermeros());
		
		add(getLblNewLabel());
		add(getChckbxAnadirTodosMed());
		add(getLblEnfermeros());
		add(getChckbxAnadirTodosEnf());

	}

	private void anadirMedicosALaLista() {

		lm = new ListaMedicos();
		lm.creaListaMedicos();
		for (Medico m : lm.getMedicos()) {
			if (m.getIdEquipoMedico()==idEquipoMedico)
				modeloListMedicos.addElement((Medico) m);
		}

	}

	private JList getListMedicosAnadidos() {
		if (listMedicosAnadidos == null) {
			modeloListMedicosAnadidos = new DefaultListModel();
			listMedicosAnadidos = new JList(modeloListMedicosAnadidos);
		}
		return listMedicosAnadidos;
	}

	private void anadirEnfermerosALaLista() {
		
		le = new ListaEnfermeros();
		le.creaListaEnfermeros();

		for (Enfermero e : le.getEnfermeros()) {
			if (e.getIdEquipoMedico() == idEquipoMedico)
				modeloListEnfermeros.addElement((Enfermero) e);
		}

	}

	private JButton getBtnEliminarMedicoCita() {
		if (btnEliminarMedicoCita == null) {
			btnEliminarMedicoCita = new JButton("Eliminar");
			btnEliminarMedicoCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					modeloListMedicosAnadidos.removeAllElements();
				}
			});
			btnEliminarMedicoCita.setBounds(1023, 167, 89, 23);
		}
		return btnEliminarMedicoCita;
	}

	private JScrollPane getScrollPaneMedicosAnadidos() {
		if (scrollPaneMedicosAnadidos == null) {
			scrollPaneMedicosAnadidos = new JScrollPane();
			scrollPaneMedicosAnadidos.setBounds(816, 130, 186, 88);
			scrollPaneMedicosAnadidos.setViewportView(getListMedicosAnadidos());
		}
		return scrollPaneMedicosAnadidos;
	}

	private JScrollPane getScrollPaneMedicos() {
		if (scrollPaneMedicos == null) {
			scrollPaneMedicos = new JScrollPane();
			scrollPaneMedicos.setBounds(323, 130, 287, 88);
			scrollPaneMedicos.setViewportView(getListMedicos());
		}
		return scrollPaneMedicos;
	}

	private JList getListMedicos() {
		if (listMedicos == null) {
			modeloListMedicos = new DefaultListModel();
			anadirMedicosALaLista();
			listMedicos = new JListFiltroMedicosEquipo(modeloListMedicos);
			this.add(listMedicos.gettextoFiltro());

		}
		return listMedicos;
	}

	private JButton getBtnAnadirMedicos() {
		if (btnAnadirMedicos == null) {
			btnAnadirMedicos = new JButton("A\u00F1adir Medico/s");
			btnAnadirMedicos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					anadirMedicosSeleccinados();
				}
			});
			btnAnadirMedicos.setBounds(635, 151, 149, 55);
		}
		return btnAnadirMedicos;
	}

	private void anadirMedicosSeleccinados() {

		if (chckbxAnadirTodosMed.isSelected()) {
			
			for (int i = 0; i < modeloListMedicos.getSize();i++) {
				
				Medico m = modeloListMedicos.elementAt(i);
				
				if (!modeloListMedicosAnadidos.contains(m)) {
					modeloListMedicosAnadidos.addElement(m);
					
				}
			}
			
		} else {
		
			for (Object o : listMedicos.getSelectedValuesList()) {
	
				if (!modeloListMedicosAnadidos.contains(o)) {
					modeloListMedicosAnadidos.addElement((Medico) o);
				}
	
			}
		}
	}

	private JLabel getLblMedicos() {
		if (lblMedicos == null) {
			lblMedicos = new JLabel("Seleccionar Medicos :");
			lblMedicos.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblMedicos.setBounds(61, 163, 233, 22);
		}
		return lblMedicos;
	}

	private JButton getBtncancelarCita() {
		if (btncancelarCita == null) {
			btncancelarCita = new JButton("Cancelar");
			btncancelarCita.setFocusable(false);
			btncancelarCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					closePanel();
				}
			});
			btncancelarCita.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btncancelarCita.setBounds(996, 501, 116, 23);
		}
		return btncancelarCita;
	}

	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}

	private JButton getBtnCrearEquipo() {
		if (btnCrearEquipo == null) {
			btnCrearEquipo = new JButton("A\u00F1adir Miembros");
			btnCrearEquipo.setFocusable(false);
			btnCrearEquipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						
						for (int i = 0; i < modeloListMedicosAnadidos.getSize(); i++) {
							Medico m = modeloListMedicosAnadidos.getElementAt(i);
							panelAnterior.anadirMiembrosEquipoMedico(m);
						}
						
						for (int i = 0; i < modeloListEnfermerosAnadidos.getSize(); i++) {
							Enfermero enf = modeloListEnfermerosAnadidos.getElementAt(i);
							panelAnterior.anadirMiembrosEquipoEnfermero(enf);
						}
						
						panelcita.setVisible(false);
						panelAnterior.setVisible(true);
					}
				}
			);
			btnCrearEquipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCrearEquipo.setBounds(778, 501, 208, 23);
		}
		return btnCrearEquipo;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Filtro sensible a MAYUSCULAS");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setBounds(61, 88, 200, 50);
		}
		return lblNewLabel;
	}
	private JCheckBox getChckbxAnadirTodosMed() {
		if (chckbxAnadirTodosMed == null) {
			chckbxAnadirTodosMed = new JCheckBox("A\u00F1adir todos");
			chckbxAnadirTodosMed.setBounds(323, 225, 97, 23);
		}
		return chckbxAnadirTodosMed;
	}
	private JLabel getLblEnfermeros() {
		if (lblEnfermeros == null) {
			lblEnfermeros = new JLabel("Seleccionar Enfermeros:");
			lblEnfermeros.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblEnfermeros.setBounds(61, 329, 233, 22);
		}
		return lblEnfermeros;
	}
	
	private JList getListEnfermeros() {
		if (listEnfermeros == null) {
			modeloListEnfermeros = new DefaultListModel();
			anadirEnfermerosALaLista();
			listEnfermeros = new JListFiltroEnfermerosEquipo(modeloListEnfermeros);
			this.add(listEnfermeros.gettextoFiltro());

		}
		return listEnfermeros;
	}

	private JScrollPane getScrollPaneEnfermeros() {
		if (scrollPaneEnfermeros == null) {
			scrollPaneEnfermeros = new JScrollPane();
			scrollPaneEnfermeros.setBounds(323, 301, 287, 88);
			scrollPaneEnfermeros.setViewportView(getListEnfermeros());
		}
		return scrollPaneEnfermeros;
	}
	private JButton getBtnAnadirEnfermeros() {
		if (btnAnadirEnfermeros == null) {
			btnAnadirEnfermeros = new JButton("A\u00F1adir Enfermero/s");
			btnAnadirEnfermeros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if (chckbxAnadirTodosEnf.isSelected()) {
						
						for (int i = 0; i < modeloListEnfermeros.getSize();i++) {
							
							Enfermero e = modeloListEnfermeros.elementAt(i);
							
							if (!modeloListEnfermerosAnadidos.contains(e)) {
								modeloListEnfermerosAnadidos.addElement(e);
								
							}
						}
						
					} else {
					
						for (Object o : listEnfermeros.getSelectedValuesList()) {
				
							if (!modeloListEnfermerosAnadidos.contains(o)) {
								modeloListEnfermerosAnadidos.addElement((Enfermero) o);
							}
				
						}
					}
				}

			});
			btnAnadirEnfermeros.setBounds(635, 317, 149, 55);
		}
		return btnAnadirEnfermeros;
	}
	
	private JScrollPane getScrollPaneEnfermerosAnadidos() {
		if (scrollPaneEnfermerosAnadidos == null) {
			scrollPaneEnfermerosAnadidos = new JScrollPane();
			scrollPaneEnfermerosAnadidos.setBounds(816, 301, 186, 88);
			scrollPaneEnfermerosAnadidos.setViewportView(getListEnfermerosAnadidos());
		}
		return scrollPaneEnfermerosAnadidos;
	}

	private Component getListEnfermerosAnadidos() {
		if (listEnfermerosAnadidos == null) {
			modeloListEnfermerosAnadidos = new DefaultListModel();
			listEnfermerosAnadidos = new JList(modeloListEnfermerosAnadidos);
		}
		return listEnfermerosAnadidos;
	}
	
	private JButton getBtnEliminarEnfermeros() {
		if (btnEliminarEnfermeros == null) {
			btnEliminarEnfermeros = new JButton("Eliminar");
			btnEliminarEnfermeros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					modeloListEnfermerosAnadidos.removeAllElements();
				}
			});
			btnEliminarEnfermeros.setBounds(1023, 333, 89, 23);
		}
		return btnEliminarEnfermeros;
	}
	private JCheckBox getChckbxAnadirTodosEnf() {
		if (chckbxAnadirTodosEnf == null) {
			chckbxAnadirTodosEnf = new JCheckBox("A\u00F1adir todos");
			chckbxAnadirTodosEnf.setBounds(323, 396, 97, 23);
		}
		return chckbxAnadirTodosEnf;
	}
}
