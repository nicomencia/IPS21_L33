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

import pgh.business.cita.ActualizarMedicoCita;
import pgh.business.cita.Cita;
import pgh.business.cita.CitaDTO;
import pgh.business.cita.CrearCitas;
import pgh.business.cita.FindAllCitas;
import pgh.business.cita.ListaCitas;
import pgh.business.citaPropuesta.ActualizarPendienteCitaPropuesta;
import pgh.business.citaPropuesta.CitaPropuesta;
import pgh.business.citaPropuesta.ListaCitasPropuestas;
import pgh.business.enfermeroCita.CrearEnfermeroCita;
import pgh.business.enfermeroCita.EnfermeroCita;
import pgh.business.enfermeroCita.EnfermeroCitaDTO;
import pgh.business.enfermeroCitaPropuesta.EnfermeroCitaPropuesta;
import pgh.business.enfermeroCitaPropuesta.ListaEnfermeroCitaPropuesta;
import pgh.business.medico.ListaMedicos;
import pgh.business.medico.Medico;
import pgh.business.medicoCitaPropuesta.ListaMedicoCitaPropuesta;
import pgh.business.medicoCitaPropuesta.MedicoCitaPropuesta;
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
import pgh.ui.paneles.filtros.JListFiltroCitaSinMedicos;
import pgh.ui.paneles.filtros.JListFiltroJornadaMedicos;
import pgh.ui.paneles.filtros.JListFiltroPacientesCita;
import pgh.ui.paneles.filtros.JListFitroMedicosCita;

public class PanelGestionarCitasPropuestas extends JPanel {
	private DefaultListModel<Medico> modeloListMedicosAnadidos;
	private CitaDTO citaDTO;
	private Cita cita;
	private CrearCitas crearCitas;
	private ListaCitasPropuestas lc;
	private DefaultComboBoxModel<CitaPropuesta> modeloComboCitas;
	private ListaMedicos lm; // Rep
	private ListaPacientes lp; // Rep
	private ListaUbicaciones lu;
	private DefaultListModel<Medico> modeloListMedicos; // Rep
	private JLabel lblCita;
	private JButton btnCrearCita;
	private JButton btncancelarCita;
	private MedicoCita medicoCita;
	private MedicoCitaDTO medicoCitaDTO;
	private CrearMedicoCita crearMedicoCita;
	private JPanel panelAnterior;
	private JTextField textFieldMedicos;
	private JTextField textFieldpacientes;
	private JPanel panelcita;
	private JPanel panelContenido;
	private FindAllVacacionesMedico findVacaciones;
	private VacacionesMedico vm;
	private VacacionesMedicoDTO vmDTO;
	private List<VacacionesMedico> vacaciones = new ArrayList<VacacionesMedico>();
	private JComboBox comboBoxCita;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private ListaCitas lcc;

	public PanelGestionarCitasPropuestas(JPanel panelAnterior, JPanel panelContenido) {
		this.panelAnterior = panelAnterior;
		this.panelContenido = panelContenido;
		panelcita = this;
		getPanelCitas();
	}

	private void getPanelCitas() {

		this.setBackground(new Color(135, 206, 235));
		this.setLayout(null);
		this.add(getLblCita());
		this.add(getBtnCrearCita());
		this.add(getBtncancelarCita());
		add(getComboBoxCita());
		add(getBtnNewButton());
		add(getBtnNewButton_1());
	}

	private void anadirMedicosALaLista() {

		lm = new ListaMedicos();
		lm.creaListaMedicos();
		for (Medico m : lm.getMedicos()) {
			modeloListMedicos.addElement((Medico) m);
		}

	}

	private JLabel getLblCita() {
		if (lblCita == null) {
			lblCita = new JLabel("Seleccionar Cita:");
			lblCita.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCita.setBounds(83, 120, 211, 22);
		}
		return lblCita;
	}

	private void anadirUbicacionesCitas() {

		modeloComboCitas.removeAllElements();
		
		lc = new ListaCitasPropuestas();
		lc.creaListaCitasPropuesta();

		for (CitaPropuesta c : lc.getCitasPropuestas()) {
			if (c.getPendienteAprobacion())
				modeloComboCitas.addElement(c);
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
			btncancelarCita.setBounds(973, 530, 116, 23);
		}
		return btncancelarCita;
	}

	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}

	private JButton getBtnCrearCita() {
		if (btnCrearCita == null) {
			btnCrearCita = new JButton("Aceptar Cita");
			btnCrearCita.setFocusable(false);
			btnCrearCita.addActionListener(new ActionListener() {
				private CrearEnfermeroCita crearEnfermeroCita;

				public void actionPerformed(ActionEvent e) {

					ActualizarPendienteCitaPropuesta actualizarPendienteCitaPropuesta = new ActualizarPendienteCitaPropuesta();
					
					CitaPropuesta citaSeleccionada = (CitaPropuesta) comboBoxCita.getSelectedItem();
					actualizarPendienteCitaPropuesta.actualizar(citaSeleccionada);

					cita = citaPropuestaACita(citaSeleccionada);

					crearCitas = new CrearCitas();
					crearCitas.crearCita(cita);
					
					ListaMedicoCitaPropuesta lmcp = new ListaMedicoCitaPropuesta();
					lmcp.creaListaMedicoCitas();
					
					crearMedicoCita = new CrearMedicoCita();
					
					for (MedicoCitaPropuesta m : lmcp.getMedicoCitas()) {
						if (m.getIdCitaPropuesta() == citaSeleccionada.getIdCitaPropuesta()) {
							
							MedicoCitaDTO mc = new MedicoCitaDTO();
							mc.idCita = m.getIdCitaPropuesta();
							mc.idMedico = m.getIdMedico();
							
							crearMedicoCita.crearMedicoCita(new MedicoCita(mc));
						}
					}
					
					ListaEnfermeroCitaPropuesta lecp = new ListaEnfermeroCitaPropuesta();
					lecp.creaListaEnfermeroCitas();
					
					crearEnfermeroCita = new CrearEnfermeroCita();
					
					for (EnfermeroCitaPropuesta m : lecp.getEnfermeroCitas()) {
						if (m.getIdCitaPropuesta() == citaSeleccionada.getIdCitaPropuesta()) {
							
							EnfermeroCitaDTO ec = new EnfermeroCitaDTO();
							ec.idCita = m.getIdCitaPropuesta();
							ec.idEnfermero = m.getIdEnfermero();
							
							crearEnfermeroCita.crearEnfermeroCita(new EnfermeroCita(ec));
						}
					}
					
					anadirUbicacionesCitas();

				}

				private Cita citaPropuestaACita(CitaPropuesta citaSeleccionada) {
					
					CitaDTO citaDTO = new CitaDTO();

					citaDTO.idCita = citaSeleccionada.getIdCitaPropuesta();
					citaDTO.idPaciente = citaSeleccionada.getIdPaciente();
					citaDTO.idUbicacion = citaSeleccionada.getIdUbicacion();
					citaDTO.fecha = citaSeleccionada.getDate();
					citaDTO.asistencia = false;
					citaDTO.urgente = citaSeleccionada.getUrgente();
					citaDTO.infocontacto = citaSeleccionada.infoContacto();
					citaDTO.idHorario = citaSeleccionada.getIdHorario();
					citaDTO.nombrePaciente = citaSeleccionada.getNombrePaciente();
					citaDTO.medicoAsignado = citaSeleccionada.getMedicoAsignado();

					return new Cita(citaDTO);
				}

			});
			btnCrearCita.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCrearCita.setBounds(741, 530, 222, 23);
		}
		return btnCrearCita;
	}
	private JComboBox getComboBoxCita() {
		if (comboBoxCita == null) {
			modeloComboCitas = new DefaultComboBoxModel<CitaPropuesta>();
			comboBoxCita = new JComboBox<CitaPropuesta>(modeloComboCitas);
			comboBoxCita.setEditable(true);

			anadirUbicacionesCitas();

			comboBoxCita.setFocusable(false);
			comboBoxCita.setBounds(83, 153, 1006, 22);
		}
		return comboBoxCita;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Comprobar Disponibilidad");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					CitaPropuesta citaSeleccionada = (CitaPropuesta) comboBoxCita.getSelectedItem();
					
					if (comprobarDisponibilidad(citaSeleccionada.getIdUbicacion(), citaSeleccionada.getIdHorario(), citaSeleccionada.getDate())) {
						
						JOptionPane.showMessageDialog(btnNewButton,
								"La ubicacion esta ocupada durante esa franja horaria");
					} else {
						JOptionPane.showMessageDialog(btnNewButton,
								"La ubicacion esta disponible durante esa franja horaria");
					}

					
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton.setBounds(412, 325, 304, 33);
		}
		return btnNewButton;
	}
	
	private boolean comprobarDisponibilidad(int idUbicacion, int idHorario, Date fecha) {
		lcc = new ListaCitas();
		lcc.creaCitas();
		for (Cita cita : lcc.getCitas()) {
			if (cita.getIdUbicacion() == idUbicacion && cita.getIdHorario() == idHorario
					&& cita.getDate().equals(fecha)) {
				return true;
			}
		}
		return false;
	}
	
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Denegar Cita");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					ActualizarPendienteCitaPropuesta actualizarPendienteCitaPropuesta = new ActualizarPendienteCitaPropuesta();
					
					CitaPropuesta citaSeleccionada = (CitaPropuesta) comboBoxCita.getSelectedItem();
					actualizarPendienteCitaPropuesta.actualizar(citaSeleccionada);
					
					anadirUbicacionesCitas();
				}

			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_1.setBounds(507, 530, 224, 23);
		}
		return btnNewButton_1;
	}
}
