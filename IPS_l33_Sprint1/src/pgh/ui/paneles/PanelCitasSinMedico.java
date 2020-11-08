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

public class PanelCitasSinMedico extends JPanel {
	private JButton btnEliminarMedicoCita;
	private DefaultListModel<Medico> modeloListMedicosAnadidos;
	private CitaDTO citaDTO;
	private Cita cita;
	private CrearCitas crearCitas;
	private ListaCitas lc;
	private DefaultComboBoxModel<Cita> modeloComboCitas;
	private ListaMedicos lm; // Rep
	private ListaPacientes lp; // Rep
	private ListaUbicaciones lu;
	private DefaultListModel<Medico> modeloListMedicos; // Rep
	private JScrollPane scrollPaneMedicos;
	private JButton btnAnadirMedicos;
	private JListFitroMedicosCita listMedicos; // Rep
	private JScrollPane scrollPaneMedicosAnadidos;
	private JList<Medico> listMedicosAnadidos;
	private JLabel lblMedicos;
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
	private JLabel lblNewLabel;
	private JPanel panelContenido;
	private FindAllVacacionesMedico findVacaciones;
	private VacacionesMedico vm;
	private VacacionesMedicoDTO vmDTO;
	private List<VacacionesMedico> vacaciones = new ArrayList<VacacionesMedico>();
	private JComboBox comboBoxCita;

	public PanelCitasSinMedico(JPanel panelAnterior, JPanel panelContenido) {
		this.panelAnterior = panelAnterior;
		this.panelContenido = panelContenido;
		panelcita = this;
		getPanelCitas();
	}

	private void getPanelCitas() {

		this.setBackground(new Color(135, 206, 235));
		this.setLayout(null);
		this.add(getLblMedicos());
		this.add(getLblCita());
		this.add(getBtnCrearCita());
		this.add(getBtncancelarCita());
		this.add(getScrollPaneMedicos());
		this.add(getBtnAnadirMedicos());
		this.add(getScrollPaneMedicosAnadidos());
		this.add(getBtnEliminarMedicoCita());
		add(getLblNewLabel());
		add(getComboBoxCita());
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

	private JLabel getLblCita() {
		if (lblCita == null) {
			lblCita = new JLabel("Seleccionar Cita:");
			lblCita.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCita.setBounds(83, 120, 211, 22);
		}
		return lblCita;
	}

	private void anadirUbicacionesCitas() {

		lc = new ListaCitas();
		lc.creaListaCitas();

		for (Cita c : lc.getCitas()) {
			if (!c.getMedicoAsignado())
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
			btncancelarCita.setBounds(862, 364, 116, 23);
		}
		return btncancelarCita;
	}

	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}

	private JButton getBtnCrearCita() {
		if (btnCrearCita == null) {
			btnCrearCita = new JButton("Anadir Medicos");
			btnCrearCita.setFocusable(false);
			btnCrearCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					ActualizarMedicoCita actualizarMedicoCita = new ActualizarMedicoCita();
					
					boolean vacaciones = false;
					
					Cita citaSeleccionada = (Cita) comboBoxCita.getSelectedItem();
					int idCitaSeleccionada = citaSeleccionada.getIdCita();
					
					FindAllCitas fn = new FindAllCitas();
					citaDTO = fn.FindCitaById(idCitaSeleccionada);

					if (modeloListMedicosAnadidos.getSize()!=0) {
						
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
									citaDTO.medicoAsignado=true;
									cita = new Cita(citaDTO);
									actualizarMedicoCita.actualizar(cita);
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
													citaDTO.medicoAsignado=true;
													cita = new Cita(citaDTO);
													actualizarMedicoCita.actualizar(cita);
													crearMedicoCita.crearMedicoCita(medicoCita);
												}	
											
										   }
										}
										else {
											citaDTO.medicoAsignado=true;
											cita = new Cita(citaDTO);
											actualizarMedicoCita.actualizar(cita);
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

						message.setSubject("Cita urgente nº " + citaDTO.idCita);
						message.setText("Buenos días " + m.getNombreMedico() + " " + m.getApellidosMedico() + ". \n"
								+ "Este es un recordatorio de que tiene una cita urgente con identificador "
								+ citaDTO.idCita + " el día " + citaDTO.fecha.toString() + ".\n"
								+ "La ubicación de la cita es: " + getUbicacionNombreCita(citaDTO.idUbicacion));

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

			});
			btnCrearCita.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCrearCita.setBounds(630, 364, 222, 23);
		}
		return btnCrearCita;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Filtro sensible a MAYUSCULAS");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setBounds(83, 175, 200, 50);
		}
		return lblNewLabel;
	}
	private JComboBox getComboBoxCita() {
		if (comboBoxCita == null) {
			modeloComboCitas = new DefaultComboBoxModel<Cita>();
			comboBoxCita = new JComboBox<Cita>(modeloComboCitas);
			comboBoxCita.setEditable(true);

			anadirUbicacionesCitas();

			comboBoxCita.setFocusable(false);
			comboBoxCita.setBounds(323, 124, 766, 22);
		}
		return comboBoxCita;
	}
}
