package pgh.ui.paneles;

import java.awt.Color;
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
import pgh.ui.paneles.filtros.JListFiltroJornadaMedicos;
import pgh.ui.paneles.filtros.JListFiltroPacientesCita;
import pgh.ui.paneles.filtros.JListFitroMedicosCita;

public class PanelMiembrosEquipoMedico extends JPanel {
	private JButton btnEliminarMedicoCita;
	private DefaultListModel<Enfermero> modeloListEnfermeros;
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
	private JButton btnAnadirMedicos;
	private JListFitroMedicosCita listMedicos; // Rep
	private JScrollPane scrollPaneMedicosAnadidos;
	private JList<Medico> listMedicosAnadidos;
	private JLabel lblMedicos;
	private JComboBox comboBoxAnoCita;
	private JButton btnCrearEquipo;
	private JButton btncancelarCita;
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
	private JCheckBox chckbxAnadirTodos;

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
		add(getLblNewLabel());
		add(getChckbxAnadirTodos());

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

	private void anadirEnfermeros() {

		le = new ListaEnfermeros();
		le.creaListaEnfermeros();

		for (Enfermero e : le.getEnfermeros()) {
			if (e.getIdEquipoMedico() == 7000)
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
			btnEliminarMedicoCita.setBounds(1000, 240, 89, 23);
		}
		return btnEliminarMedicoCita;
	}

	private JScrollPane getScrollPaneMedicosAnadidos() {
		if (scrollPaneMedicosAnadidos == null) {
			scrollPaneMedicosAnadidos = new JScrollPane();
			scrollPaneMedicosAnadidos.setBounds(794, 213, 186, 88);
			scrollPaneMedicosAnadidos.setViewportView(getListMedicosAnadidos());
		}
		return scrollPaneMedicosAnadidos;
	}

	private JScrollPane getScrollPaneMedicos() {
		if (scrollPaneMedicos == null) {
			scrollPaneMedicos = new JScrollPane();
			scrollPaneMedicos.setBounds(323, 213, 287, 88);
			scrollPaneMedicos.setViewportView(getListMedicos());
		}
		return scrollPaneMedicos;
	}

	private JList getListMedicos() {
		if (listMedicos == null) {
			modeloListMedicos = new DefaultListModel();
			anadirMedicosALaLista();
			listMedicos = new JListFitroMedicosCita(modeloListMedicos);
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
			btnAnadirMedicos.setBounds(630, 224, 149, 55);
		}
		return btnAnadirMedicos;
	}

	private void anadirMedicosSeleccinados() {

		if (chckbxAnadirTodos.isSelected()) {
			
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
			lblMedicos.setBounds(61, 236, 233, 22);
		}
		return lblMedicos;
	}

	private void anadirUbicacionesCitas() {

		lu = new ListaUbicaciones();
		lu.creaListaUbicaciones();

		for (Ubicacion u : lu.getUbicacion()) {

			modeloComboUbicacionesCita.addElement(u);
		}
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
					closePanel();
				}
			});
			btncancelarCita.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btncancelarCita.setBounds(864, 481, 116, 23);
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
							panelAnterior.anadirMiembrosEquipo(m);
						}
						
						panelcita.setVisible(false);
						panelAnterior.setVisible(true);
					}
				}
			);
			btnCrearEquipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCrearEquipo.setBounds(646, 481, 208, 23);
		}
		return btnCrearEquipo;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Filtro sensible a MAYUSCULAS");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setBounds(61, 175, 200, 50);
		}
		return lblNewLabel;
	}
	private JCheckBox getChckbxAnadirTodos() {
		if (chckbxAnadirTodos == null) {
			chckbxAnadirTodos = new JCheckBox("A\u00F1adir todos");
			chckbxAnadirTodos.setBounds(323, 312, 97, 23);
		}
		return chckbxAnadirTodos;
	}
}
