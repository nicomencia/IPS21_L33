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
import pgh.ui.paneles.filtros.JListFiltroJornadaMedicos;
import pgh.ui.paneles.filtros.JListFiltroPacientesCita;
import pgh.ui.paneles.filtros.JListFitroMedicosCita;

public class PanelCitas extends JPanel {

	private JButton btnEliminarPacienteCita;
	private JButton btnEliminarMedicoCita;
	private DefaultListModel<Paciente> modeloListPacientesCita;
	private DefaultListModel<Paciente> modeloListPacienteCita;
	private JLabel lblInfocontacto;
	private JTextField txtFieldInfoContacto;
	private JLabel lblUrgente;
	private JCheckBox chckbxUrgente;
	private DefaultListModel<Medico> modeloListMedicosAnadidos;
	private CitaDTO citaDTO;
	private Cita cita;
	private CrearCitas crearCitas;
	private ListaCitas lc;
	private JButton btnAnadirPacienteListaCita;
	private JListFiltroPacientesCita listPacientesCita;
	private DefaultComboBoxModel<Ubicacion> modeloComboUbicacionesCita;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPanePacienteSeleccionado;
	private ListaMedicos lm; // Rep
	private ListaPacientes lp; // Rep
	private ListaUbicaciones lu;
	private DefaultListModel<Medico> modeloListMedicos; // Rep
	private JScrollPane scrollPaneMedicos;
	private JButton btnAnadirMedicos;
	private JListFitroMedicosCita listMedicos; // Rep
	private JScrollPane scrollPaneMedicosAnadidos;
	private JList<Medico> listMedicosAnadidos;
	private JList listPacienteSeleccionado;
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
	private JComboBox comboBoxMinutosInicioCita;
	private JLabel lblNewLabel_2;
	private JComboBox comboBoxMinutosFinCita;
	private JLabel lblNewLabel_3;
	private JComboBox comboBoxMesCita;
	private JComboBox comboBoxFechaDia;
	private JComboBox comboBoxDiaDia;
	private MedicoCita medicoCita;
	private MedicoCitaDTO medicoCitaDTO;
	private CrearMedicoCita crearMedicoCita;
	private JPanel panelAnterior;
	private JTextField textFieldMedicos;
	private JTextField textFieldpacientes;
	private JPanel panelcita;
	private JLabel lblNewLabel;
	private JPanel panelContenido;
	private FindAllVacacionesMedico findVacaciones;
	private VacacionesMedico vm;
	private VacacionesMedicoDTO vmDTO;
	private List<VacacionesMedico> vacaciones = new ArrayList<VacacionesMedico>();

	public PanelCitas(JPanel panelAnterior, JPanel panelContenido) {
		this.panelAnterior = panelAnterior;
		this.panelContenido = panelContenido;
		panelcita = this;
		getPanelCitas();
	}

	private void getPanelCitas() {

		this.setBackground(new Color(135, 206, 235));
		this.setLayout(null);
		this.add(getLblMedicos());
		this.add(getLblPaciente());
		this.add(getLblFecha());
		this.add(getLblHoraInicio());
		this.add(getLblHoraFin());
		this.add(getLblUbicacion());
		this.add(getComboBoxUbicacion());
		this.add(getComboBoxHorasInicioCita());
		this.add(getComboBoxHorasFinCita());
		this.add(getBtnCrearCita());
		this.add(getBtncancelarCita());
		this.add(getComboBoxMinutosInicioCita());
		this.add(getLblNewLabel_2());
		this.add(getComboBox_1());
		this.add(getLblNewLabel_3());
		this.add(getComboBoxMesCita());
		this.add(getComboBoxDiaDia());
		this.add(getScrollPaneMedicos());
		this.add(getBtnAnadirMedicos());
		this.add(getScrollPaneMedicosAnadidos());
		this.add(getScrollPane_1());
		this.add(getBtnAnadirPacienteListaCita());
		this.add(getScrollPanePacienteSeleccionado());
		this.add(getLblInfocontacto());
		this.add(getTxtFieldInfoContacto());
		this.add(getLblUrgente());
		this.add(getChckbxUrgente());
		this.add(getBtnEliminarPacienteCita());
		this.add(getBtnEliminarMedicoCita());
		add(getLblNewLabel());

	}

	private void anadirMedicosALaLista() {

		lm = new ListaMedicos();
		lm.creaListaMedicos();
		for (Medico m : lm.getMedicos()) {
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

	private JList getListPacientesCita() {
		if (listPacientesCita == null) {
			modeloListPacientesCita = new DefaultListModel();
			anadirPacientesCitas();
			listPacientesCita = new JListFiltroPacientesCita(modeloListPacientesCita);
			this.add(listPacientesCita.gettextoFiltro());

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

	private JList getListPacienteSeleccionado() {
		if (listPacienteSeleccionado == null) {
			modeloListPacienteCita = new DefaultListModel();
			listPacienteSeleccionado = new JList(modeloListPacienteCita);

		}
		return listPacienteSeleccionado;
	}

	private JButton getBtnEliminarPacienteCita() {
		if (btnEliminarPacienteCita == null) {
			btnEliminarPacienteCita = new JButton("Eliminar ");
			btnEliminarPacienteCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					modeloListPacienteCita.removeAllElements();
					txtFieldInfoContacto.setText("(Añadir paciente)");
				}
			});
			btnEliminarPacienteCita.setBounds(1002, 124, 103, 23);
		}
		return btnEliminarPacienteCita;
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

	private JLabel getLblInfocontacto() {
		if (lblInfocontacto == null) {
			lblInfocontacto = new JLabel("Informaci\u00F3n contacto :");
			lblInfocontacto.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblInfocontacto.setBounds(83, 430, 235, 22);
		}
		return lblInfocontacto;
	}

	private JTextField getTxtFieldInfoContacto() {
		if (txtFieldInfoContacto == null) {
			txtFieldInfoContacto = new JTextField();
			txtFieldInfoContacto.setText("(A\u00F1adir paciente)");
			txtFieldInfoContacto.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtFieldInfoContacto.setBounds(321, 435, 346, 20);
			txtFieldInfoContacto.setColumns(10);
		}
		return txtFieldInfoContacto;
	}

	private JLabel getLblUrgente() {
		if (lblUrgente == null) {
			lblUrgente = new JLabel("Urgente :");
			lblUrgente.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblUrgente.setBounds(83, 478, 191, 29);
		}
		return lblUrgente;
	}

	private JCheckBox getChckbxUrgente() {
		if (chckbxUrgente == null) {
			chckbxUrgente = new JCheckBox("Si");
			chckbxUrgente.setBounds(321, 485, 41, 23);
		}
		return chckbxUrgente;
	}

	private JButton getBtnAnadirPacienteListaCita() {
		if (btnAnadirPacienteListaCita == null) {
			btnAnadirPacienteListaCita = new JButton("A\u00F1adir Paciente");
			btnAnadirPacienteListaCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					anadirPacienteListaCita();
				}
			});
			btnAnadirPacienteListaCita.setBounds(630, 108, 149, 55);
		}
		return btnAnadirPacienteListaCita;
	}

	private void anadirPacienteListaCita() {

		for (Object o : listPacientesCita.getSelectedValuesList()) {
			if (modeloListPacienteCita.getSize() < 1) {

				if (!modeloListPacienteCita.contains(o)) {
					Paciente paciente = (Paciente) o;
					modeloListPacienteCita.addElement(paciente);
					txtFieldInfoContacto
							.setText("Teléfono: " + paciente.getTelefono() + " email: " + paciente.getEmail());
				}

			}
		}

	}

	private JScrollPane getScrollPanePacienteSeleccionado() {
		if (scrollPanePacienteSeleccionado == null) {
			scrollPanePacienteSeleccionado = new JScrollPane();
			scrollPanePacienteSeleccionado.setBounds(794, 88, 186, 88);
			scrollPanePacienteSeleccionado.setViewportView(getListPacienteSeleccionado());
		}
		return scrollPanePacienteSeleccionado;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(321, 88, 289, 88);
			scrollPane_1.setViewportView(getListPacientesCita());
		}
		return scrollPane_1;
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

		for (Object o : listMedicos.getSelectedValuesList()) {

			if (!modeloListMedicosAnadidos.contains(o)) {
				modeloListMedicosAnadidos.addElement((Medico) o);
			}

		}

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

	private JComboBox<Ubicacion> getComboBoxUbicacion() {

		if (comboBoxUbicacion == null) {
			modeloComboUbicacionesCita = new DefaultComboBoxModel<Ubicacion>();
			comboBoxUbicacion = new JComboBox<Ubicacion>(modeloComboUbicacionesCita);
			comboBoxUbicacion.setEditable(true);

			anadirUbicacionesCitas();

			comboBoxUbicacion.setFocusable(false);
			comboBoxUbicacion.setBounds(320, 380, 347, 22);
		}
		return comboBoxUbicacion;
	}

	private void anadirUbicacionesCitas() {

		lu = new ListaUbicaciones();
		lu.creaListaUbicaciones();

		for (Ubicacion u : lu.getUbicacion()) {

			modeloComboUbicacionesCita.addElement(u);
		}
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

	private JButton getBtnCrearCita() {
		if (btnCrearCita == null) {
			btnCrearCita = new JButton("Crear Cita");
			btnCrearCita.setFocusable(false);
			btnCrearCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					boolean vacaciones =false;
					lc = new ListaCitas();
					lc.creaListaCitas();
					crearCitas = new CrearCitas();
					citaDTO = new CitaDTO();

					citaDTO.idCita = generarIdCita();

					Paciente paciente = (Paciente) listPacientesCita.getSelectedValue();
					int idPaciente = paciente.getIdPaciente();
					citaDTO.idPaciente = idPaciente;

					SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy/MM/dd");
					Date date = new Date();
					try {
						date = dateformat3.parse("2021/03/27");
						citaDTO.fecha = date;
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					

					citaDTO.asistencia = false;

					if (chckbxUrgente.isSelected()) {
						citaDTO.urgente = true;
					} else
						citaDTO.urgente = false;

					citaDTO.infocontacto = txtFieldInfoContacto.getText();

					int idHorario = 6002;
					citaDTO.idHorario = idHorario;

					Ubicacion ubicacion = (Ubicacion) comboBoxUbicacion.getSelectedItem();
					int idUbicacion = ubicacion.getIdUbicacion();
					citaDTO.idUbicacion = idUbicacion;

					if (comprobarDisponibilidad(idUbicacion, idHorario, date)) {
						int a = JOptionPane.showConfirmDialog(new JPanel(),
								"La ubicacion esta ocupada durante esa franja horaria, ¿quiere crear la cita igualmente?");

						if (a == JOptionPane.OK_OPTION) {

							if (citaDTO.urgente) {
								mandarEmailMedicosCita();
							}
							
							for (int i = 0; i < modeloListMedicosAnadidos.getSize(); i++) {

								medicoCitaDTO = new MedicoCitaDTO();

								medicoCitaDTO.idCita = citaDTO.idCita; // el id cita de la cita creada previamente
								Medico m = modeloListMedicosAnadidos.getElementAt(i);
								medicoCitaDTO.idMedico = m.getIdMedico();
								

								medicoCita = new MedicoCita(medicoCitaDTO);
								crearMedicoCita = new CrearMedicoCita();
								
								findVacaciones = new FindAllVacacionesMedico();
								vmDTO = new VacacionesMedicoDTO();
								if(findVacaciones.FindIdMedico(m.getIdMedico()).isEmpty()) {
									crearMedicoCita.crearMedicoCita(medicoCita);
									cita = new Cita(citaDTO);
									crearCitas.crearCita(cita);
								}
								else {
									
									for(int j=0;j< findVacaciones.FindIdMedico(m.getIdMedico()).size();j++) {
										
										vmDTO = findVacaciones.FindIdMedico(m.getIdMedico()).get(j);
										if(vmDTO.diaInicio.before(citaDTO.fecha)) {
											if(vmDTO.diaFin.after(citaDTO.fecha)) {
												JOptionPane.showMessageDialog(getBtnCrearCita(), "El medico " + m.getNombreMedico() + " al que intentas otorgarle una cita se encunetra de vacaciones en esos momentos");
												vacaciones = true;
											}
											else {
												if(!vacaciones) {
													cita = new Cita(citaDTO);
													crearCitas.crearCita(cita);
													crearMedicoCita.crearMedicoCita(medicoCita);
												}	
											
										   }
										}
										else {
											cita = new Cita(citaDTO);
											crearCitas.crearCita(cita);
											crearMedicoCita.crearMedicoCita(medicoCita);
										}
										
									}
									
								}

								
					

							}


						}
					} else {

						if (citaDTO.urgente) {
							mandarEmailMedicosCita();
						}


						for (int i = 0; i < modeloListMedicosAnadidos.getSize(); i++) {

							medicoCitaDTO = new MedicoCitaDTO();

							medicoCitaDTO.idCita = citaDTO.idCita; // el id cita de la cita creada previamente
							Medico m = modeloListMedicosAnadidos.getElementAt(i);
							medicoCitaDTO.idMedico = m.getIdMedico();

							medicoCita = new MedicoCita(medicoCitaDTO);
							crearMedicoCita = new CrearMedicoCita();
							
							findVacaciones = new FindAllVacacionesMedico();
							vmDTO = new VacacionesMedicoDTO();
							if(findVacaciones.FindIdMedico(m.getIdMedico()).isEmpty()) {
								crearMedicoCita.crearMedicoCita(medicoCita);
								cita = new Cita(citaDTO);
								crearCitas.crearCita(cita);
							}
							else {
								
								for(int j=0; j< findVacaciones.FindIdMedico(m.getIdMedico()).size();j++) {
									System.out.println(findVacaciones.FindIdMedico(m.getIdMedico()).size());
									vmDTO = findVacaciones.FindIdMedico(m.getIdMedico()).get(j);
									if(vmDTO.diaInicio.before(citaDTO.fecha)) {
										if(vmDTO.diaFin.after(citaDTO.fecha)) {
											JOptionPane.showMessageDialog(getBtnCrearCita(), "El medico " + m.getNombreMedico() + " al que intentas otorgarle una cita se encunetra de vacaciones en esos momentos");
											vacaciones = true;
										}
										else {
											if(!vacaciones) {
												cita = new Cita(citaDTO);
												crearCitas.crearCita(cita);
												crearMedicoCita.crearMedicoCita(medicoCita);
											}	
										
									   }
									}
									else {
										cita = new Cita(citaDTO);
										crearCitas.crearCita(cita);
										crearMedicoCita.crearMedicoCita(medicoCita);
									}
								}
								
							}

							

							

						}

					}

				}

				private void mandarEmailMedicosCita() {

					for (int i = 0; i < listMedicosAnadidos.getModel().getSize(); i++) {
						mandarEmail(listMedicosAnadidos.getModel().getElementAt(i));
					}

				}

				private void mandarEmail(Medico m) {

					Properties props = new Properties();

					props.setProperty("mail.smtp.host", "smtp.gmail.com");
					props.setProperty("mail.smtp.starttls.enable", "true");
					props.setProperty("mail.smtp.port", "587");
					props.setProperty("mail.smtp.auth", "true");

					Session session = Session.getInstance(props, new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication("ips.l33.hospital@gmail.com", "IPSl33**__");
						}
					});
					session.setDebug(true);

					MimeMessage message = new MimeMessage(session);

					try {
						message.setFrom(new InternetAddress("ips.l33.hospital@gmail.com"));

						message.addRecipient(Message.RecipientType.TO, new InternetAddress(m.getEmailMedico()));

						message.setSubject("Cita urgente nÂº " + citaDTO.idCita);
						message.setText("Buenos dÃ­as " + m.getNombreMedico() + " " + m.getApellidosMedico() + ". \n"
								+ "Este es un recordatorio de que tiene una cita urgente con identificador "
								+ citaDTO.idCita + " el dÃ­a " + citaDTO.fecha.toString() + ".\n"
								+ "La ubicaciÃ³n de la cita es: " + getUbicacionNombreCita(citaDTO.idUbicacion));

						Transport t = session.getTransport("smtp");

						t.connect("ips.l33.hospital@gmail.com", "IPSl33**__");

						t.sendMessage(message, message.getAllRecipients());

						t.close();

					} catch (AddressException ae) {
						ae.printStackTrace();
					} catch (MessagingException me) {
						me.printStackTrace();
					}
					System.out.println("Mandado email a " + m.getNombreMedico() + " " + m.getApellidosMedico() + "  ("
							+ m.getEmailMedico() + ")");
				}

				private String getUbicacionNombreCita(int idUbicacion) {
					String ubicacion = "No disponible";
					for (Ubicacion u : lu.getUbicacion()) {
						if (u.getIdUbicacion() == idUbicacion)
							ubicacion = u.getNombreUbicacion();
					}
					return ubicacion;
				}

				private boolean comprobarDisponibilidad(int idUbicacion, int idHorario, Date fecha) {
					for (Cita cita : lc.getCitas()) {
						if (cita.getIdUbicacion() == idUbicacion && cita.getIdHorario() == idHorario
								&& cita.getDate().equals(fecha)) {
							return true;
						}
					}
					return false;
				}

				private int generarIdCita() {
					return 4000 + lc.getCitas().size();
				}

			});
			btnCrearCita.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCrearCita.setBounds(729, 481, 125, 23);
		}
		return btnCrearCita;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Filtro sensible a MAYUSCULAS");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setBounds(74, 51, 200, 50);
		}
		return lblNewLabel;
	}
}
