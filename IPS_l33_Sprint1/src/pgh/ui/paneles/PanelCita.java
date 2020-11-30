package pgh.ui.paneles;

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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pgh.business.cita.Cita;
import pgh.business.diagnostico.DiagnosticoDTO;
import pgh.business.enfermedad.GuardarEnfermedad;
import pgh.business.equipomedico.EquipoMedico;
import pgh.business.equipomedico.EquipoMedicoDTO;
import pgh.business.equipomedico.FindAllEquiposMedicos;
import pgh.business.horario.HorarioDTO;
import pgh.business.horario.ListaHorario;
import pgh.business.medico.FindAllMedicos;
import pgh.business.medico.FindMedicoById;
import pgh.business.medico.Medico;
import pgh.business.medico.MedicoDTO;
import pgh.business.medicocita.ListaMedicoCita;
import pgh.business.medicocita.MedicoCita;
import pgh.business.paciente.FindAllPacientes;
import pgh.business.paciente.PacienteDTO;
import pgh.business.registro.CrearRegistro;
import pgh.business.ubicacion.ListaUbicaciones;
import pgh.business.ubicacion.UbicacionDTO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class PanelCita extends JPanel {
	private JLabel lblPaciente;
	private JLabel labelNombreApellidosPaciente;
	private JLabel lblMedicos;
	private JButton btnHistorial;
	private JLabel lblHorario;
	private JLabel labelHoras;
	private JLabel lblUbicacion;
	private JLabel labelSala;
	private JLabel lblEsUrgente;
	private JLabel labelUrgente;
	private JLabel lblInformacionDeContacto;
	private JLabel labelContacto;
	private Cita cita;
	private PacienteDTO paciente;
	private MedicoDTO medico;
	private List<MedicoCita> medicoCita;
	private List<HorarioDTO> horarios;
	private List<PacienteDTO> pacientes;
	private HorarioDTO horario;
	private UbicacionDTO ubicacion;
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private List<MedicoDTO> medicos;
	private ListaMedicoCita listaMedicoCita = new ListaMedicoCita();
	private JButton btnAtras;
	private JPanel estePanel;
	private FindAllEquiposMedicos fM;
	private List<EquipoMedicoDTO> equipo;
	private JButton btnIndicarPrescripcion;
	private JButton btnAntecedentesClinicos;
	private JButton btnHacerDiagnstico;
	private JList listDiagnosticos;
	private JScrollPane scrollPaneDiagnosticos;
	private List<DiagnosticoDTO> diagnosticos = new ArrayList<DiagnosticoDTO>();
	private DefaultListModel<DiagnosticoDTO> modeloListaDiagnosticos = new DefaultListModel<DiagnosticoDTO>();
	private JScrollPane scrollPaneMedicos;
	private JList listMedicos;
	private JButton btnValidarDiagnostico;
	private JButton btnComprobarTratamientos;
	private DefaultListModel<MedicoDTO> modeloListaMedicos = new DefaultListModel<MedicoDTO>();
	private int idObservador;
	
	/**
	 * Create the panel.
	 */
	public PanelCita(JPanel panelContenido, JPanel panelAnterior, Cita cita, List<DiagnosticoDTO> diagnosticos, int idObservador) {
		this.idObservador=idObservador;
		if(diagnosticos!=null)
		{
			this.diagnosticos = diagnosticos;
			if(diagnosticos.size()>0) {
				añadirDiagnosticosAlModelo();
			}
		}
		fM = new FindAllEquiposMedicos();
		equipo = fM.execute();
		this.panelAnterior = panelAnterior;
		this.cita = cita;
		estePanel = this;
		this.panelContenido = panelContenido;
		listaMedicoCita.creaListaMedicoCitas();
		medicos = new FindAllMedicos().execute();
		pacientes = new FindAllPacientes().execute();
		horarios = new ListaHorario().getHorarios();
		paciente = getPaciente(cita.getIdPaciente());
		medicoCita = listaMedicoCita.getMedicoCitas();
		medico = getIdMedico();
		horario = getHorario();
		ubicacion = new ListaUbicaciones().getUbicacionById(cita.getIdUbicacion());
		rellenarModeloMedicos();
		setLayout(null);
		add(getLblPaciente());
		add(getLabelNombreApellidosPaciente());
		add(getLblMedicos());
		add(getBtnHistorial());
		add(getLblHorario());
		add(getLabelHoras());
		add(getLblUbicacion());
		add(getLabelSala());
		add(getLblEsUrgente());
		add(getLabelUrgente());
		add(getLblInformacionDeContacto());
		add(getLabelContacto());
		add(getBtnAtras());
		add(getBtnIndicarPrescripcion());
		add(getBtnAntecedentesClinicos());
		add(getBtnHacerDiagnstico());
		add(getScrollPaneDiagnosticos());
		add(getScrollPaneMedicos());
		add(getBtnValidarDiagnostico());
		add(getBtnComprobarTratamientos());
		
	}
	
	private void rellenarModeloMedicos() {
		// TODO Auto-generated method stub
		for(int i=0;i<medicoCita.size();i++)
		{
			if(medicoCita.get(i).getIdCita() == cita.getIdCita())
			{
				modeloListaMedicos.addElement(getMedico(medicoCita.get(i).getIdMedico()));
			}
		}
		
	}
	
	

	private void añadirDiagnosticosAlModelo() {
		// TODO Auto-generated method stub
		for(int i=0;i<diagnosticos.size();i++)
		{
			modeloListaDiagnosticos.addElement(diagnosticos.get(i));
		}
		
	}

	private String getEquipoMedicos(MedicoDTO medico) {
		String devolver ="";
		for(int i=0;i<equipo.size();i++)
		{
			if(equipo.get(i).idEquipoMedico==medico.idEquipoMedico)
			{
				devolver = equipo.get(i).nombre;  
			
			}
		}
		return devolver;
		
	}
	
	private PacienteDTO getPaciente(int id)
	{
		for(int i =0;i<pacientes.size();i++)
		{
			if(pacientes.get(i).idPaciente==id)
			{
				return pacientes.get(i);
			}
		}
		return null;
	}
	
	private MedicoDTO getIdMedico()
	{
		for(int i=0;i<medicoCita.size();i++)
		{
			if(medicoCita.get(i).getIdCita() == cita.getIdCita())
			{
				return getMedico(medicoCita.get(i).getIdMedico());
			}
		}
		return null;
	}
	
	private MedicoDTO getMedico(int idMedico) {
		// TODO Auto-generated method stub
		for(int i=0;i<medicos.size();i++)
		{
			if(medicos.get(i).idMedico==idMedico)
			{
				return medicos.get(i);
			}
		}
		return null;
	}

	private HorarioDTO getHorario() {
		for(int i=0;i<horarios.size();i++)
		{
			if(horarios.get(i).idHorario == cita.getIdHorario())
			{
				return horarios.get(i);
			}
		}
		return null;
	}
	
	private JLabel getLblPaciente() {
		if (lblPaciente == null) {
			lblPaciente = new JLabel("Paciente:");
			lblPaciente.setBounds(134, 107, 81, 20);
		}
		return lblPaciente;
	}
	private JLabel getLabelNombreApellidosPaciente() {
		if (labelNombreApellidosPaciente == null) {
			labelNombreApellidosPaciente = new JLabel("");
			labelNombreApellidosPaciente.setText(paciente.nombre + " " + paciente.apellidos);
			labelNombreApellidosPaciente.setBounds(225, 107, 295, 20);
		}
		return labelNombreApellidosPaciente;
	}
	private JLabel getLblMedicos() {
		if (lblMedicos == null) {
			lblMedicos = new JLabel("Medicos:");
			lblMedicos.setBounds(134, 138, 81, 20);
		}
		return lblMedicos;
	}
	private JButton getBtnHistorial() {
		if (btnHistorial == null) {
			btnHistorial = new JButton("Historial");
			btnHistorial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Registro
					CrearRegistro registro = new CrearRegistro();
					if (idObservador==0)
						registro.crearRegistro("El administrador consulto el historial del paciente " + registro.getNombrePaciente(paciente.idPaciente) + " (" + paciente.idPaciente + ")");
					else 
						registro.crearRegistro("El medico " + registro.getNombreMedico(idObservador) + " (" + idObservador + ") consulto el historial del paciente " + registro.getNombrePaciente(paciente.idPaciente) + " (" + paciente.idPaciente + ")");
					
					
					PanelHistorial panel = new PanelHistorial(estePanel, cita.getIdPaciente(), panelContenido);
					panelContenido.add(panel);
					estePanel.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnHistorial.setBounds(637, 93, 89, 23);
		}
		return btnHistorial;
	}
	private JLabel getLblHorario() {
		if (lblHorario == null) {
			lblHorario = new JLabel("Horario:");
			lblHorario.setBounds(637, 172, 89, 20);
		}
		return lblHorario;
	}
	private JLabel getLabelHoras() {
		if (labelHoras == null) {
			labelHoras = new JLabel("");
			labelHoras.setText(horario.horaInicio + ":" + horario.horaFin);
			labelHoras.setBounds(728, 172, 212, 20);
		}
		return labelHoras;
	}
	private JLabel getLblUbicacion() {
		if (lblUbicacion == null) {
			lblUbicacion = new JLabel("Ubicacion:");
			lblUbicacion.setBounds(637, 236, 81, 20);
		}
		return lblUbicacion;
	}
	private JLabel getLabelSala() {
		if (labelSala == null) {
			labelSala = new JLabel(ubicacion.nombre);
			labelSala.setBounds(728, 238, 253, 17);
		}
		return labelSala;
	}
	private JLabel getLblEsUrgente() {
		if (lblEsUrgente == null) {
			lblEsUrgente = new JLabel("Es Urgente:");
			lblEsUrgente.setBounds(637, 304, 89, 20);
		}
		return lblEsUrgente;
	}
	private JLabel getLabelUrgente() {
		if (labelUrgente == null) {
			
			
			
			if(cita.getUrgente())
			{
			labelUrgente = new JLabel("Es Urgente");
			}
			else
			{
				labelUrgente = new JLabel("No es Urgente");
			}
			
			labelUrgente.setBounds(728, 303, 89, 22);
		}
		return labelUrgente;
	}
	private JLabel getLblInformacionDeContacto() {
		if (lblInformacionDeContacto == null) {
			lblInformacionDeContacto = new JLabel("Informacion de Contacto:");
			lblInformacionDeContacto.setBounds(637, 387, 179, 20);
		}
		return lblInformacionDeContacto;
	}
	private JLabel getLabelContacto() {
		if (labelContacto == null) {
			labelContacto = new JLabel(cita.infoContacto());
			labelContacto.setBounds(826, 386, 295, 23);
		}
		return labelContacto;
	}
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atras");
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					estePanel.setVisible(false);
					panelAnterior.setVisible(true);
				}
			});
			btnAtras.setBounds(637, 474, 89, 23);
		}
		return btnAtras;
	}
	private JButton getBtnAntecedentesClinicos() {
		if (btnAntecedentesClinicos == null) {
			btnAntecedentesClinicos = new JButton("Antecedentes Clinicos");
			btnAntecedentesClinicos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//Registro
					CrearRegistro registro = new CrearRegistro();
					if (idObservador==0)
						registro.crearRegistro("El administrador consulto los antecedentes clinicos del paciente " + registro.getNombrePaciente(paciente.idPaciente) + " (" + paciente.idPaciente + ")");
					else 
						registro.crearRegistro("El medico " + registro.getNombreMedico(idObservador) + " (" + idObservador + ") consulto los antecedentes clinicos del paciente " + registro.getNombrePaciente(paciente.idPaciente) + " (" + paciente.idPaciente + ")");
					
						
					PanelAntecedentesClinicos panel = new PanelAntecedentesClinicos(estePanel, panelContenido, paciente.idPaciente, estePanel, cita.getIdCita());
					panelContenido.add(panel);
					estePanel.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnAntecedentesClinicos.setBounds(341, 68, 179, 28);
		}
		return btnAntecedentesClinicos;
	}
	private JButton getBtnIndicarPrescripcion() {
		if (btnIndicarPrescripcion == null) {
			btnIndicarPrescripcion = new JButton("Indicar prescripcion");
			btnIndicarPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					PanelPrescripcion panel = new PanelPrescripcion(estePanel, medico.idMedico, paciente.idPaciente, cita.getIdCita(), panelContenido, estePanel, idObservador);
					panelContenido.add( panel);
					estePanel.setVisible(false);
					panel.setVisible(true);
					
				}
			});
			btnIndicarPrescripcion.setBounds(134, 68, 179, 28);
		}
		return btnIndicarPrescripcion;
	}
	private JButton getBtnHacerDiagnstico() {
		if (btnHacerDiagnstico == null) {
			btnHacerDiagnstico = new JButton("Hacer Diagn\u00F3stico");
			btnHacerDiagnstico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PanelDiagnósticos panel = new PanelDiagnósticos(panelContenido, estePanel, panelAnterior, cita, diagnosticos, idObservador);
					panelContenido.add(panel);
					estePanel.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnHacerDiagnstico.setBounds(341, 471, 179, 28);
		}
		return btnHacerDiagnstico;
	}
	private JList getListDiagnosticos() {
		if (listDiagnosticos == null) {
			listDiagnosticos = new JList(modeloListaDiagnosticos);
		}
		return listDiagnosticos;
	}
	private JScrollPane getScrollPaneDiagnosticos() {
		if (scrollPaneDiagnosticos == null) {
			scrollPaneDiagnosticos = new JScrollPane();
			scrollPaneDiagnosticos.setBounds(134, 329, 386, 109);
			scrollPaneDiagnosticos.setViewportView(getListDiagnosticos());
		}
		return scrollPaneDiagnosticos;
	}
	private JScrollPane getScrollPaneMedicos() {
		if (scrollPaneMedicos == null) {
			scrollPaneMedicos = new JScrollPane();
			scrollPaneMedicos.setBounds(134, 169, 386, 109);
			scrollPaneMedicos.setViewportView(getListMedicos());
		}
		return scrollPaneMedicos;
	}
	private JList getListMedicos() {
		if (listMedicos == null) {
			listMedicos = new JList(modeloListaMedicos);
		}
		return listMedicos;
	}
	private JButton getBtnValidarDiagnostico() {
		if (btnValidarDiagnostico == null) {
			btnValidarDiagnostico = new JButton("Validar Diagnostico");
			btnValidarDiagnostico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(diagnosticos.size()>0)
					{
						JOptionPane message = new JOptionPane();
						int valor = message.showConfirmDialog(null, "¿Estas seguro de que quieres validar este diagnostico?");
						System.out.println(valor);
						if(valor == 0)
						{
							validarDiagnosticos();
						}
					}
					else
					{
						new JOptionPane().showMessageDialog(null, "No hay ningún diagnóstico asignado a esta cita"); 
					}
				}
			});
			btnValidarDiagnostico.setBounds(134, 472, 179, 27);
		}
		return btnValidarDiagnostico;
	}
	
	private void validarDiagnosticos() {
		// TODO Auto-generated method stub
		for(int i=0;i<diagnosticos.size();i++)
		{
			if(diagnosticos.get(i).obligatorio)
			{
				mandarEmail(diagnosticos.get(i));
			}
			if(diagnosticos.get(i).seguimiento)
			{
				new GuardarEnfermedad().crearMedico(diagnosticos.get(i));
			}
		}
		
	}
	
	private void mandarEmail(DiagnosticoDTO d) {

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

			message.addRecipient(Message.RecipientType.TO, new InternetAddress("gerentedehospital123@gmail.com"));

			message.setSubject("Enfermedad de declaración obligatoria en la cita n# " + d.idCita);
			message.setText("Buenos dias " + "Alberto" + " " +"Martinez Martinez" + ". \n"
					+ "Este es un recordatorio de que se ha diagnosticado una enfermedad de declaración obligatorio en la cita "
					+ d.idCita + " el dia " + (new Date()).toString() + ".\n"
					+ "El medico que ha realizado este diagnostico es: " + medico.nombre + " " + medico.apellidos  + ".\n" +
					"Y el paciente es :" + paciente.nombre + " " + paciente.apellidos  + ".\n" +
					"La enfermedad que se le ha diagnosticado es: " + d.descripcion   + ".\n" +
					"Realice los procedimientos que crea necesarios para lidiar con esta patalogía"  + ".\n" +
					"Un saludo");

			Transport t = session.getTransport("smtp");

			t.connect("ips.l33.hospital@gmail.com", "IPSl33**__");

			t.sendMessage(message, message.getAllRecipients());

			t.close();

		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
		System.out.println("Mandado email al gerente");
		
		
		
	}
	private void enviarEmail(DiagnosticoDTO diagnosticoDTO) {
		// TODO Auto-generated method stub
		
	}

	private JButton getBtnComprobarTratamientos() {
		if (btnComprobarTratamientos == null) {
			btnComprobarTratamientos = new JButton("Comprobar tratamientos");
			btnComprobarTratamientos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {		
					
					//Registro
					CrearRegistro registro = new CrearRegistro();
					if (idObservador==0)
						registro.crearRegistro("El administrador consulto el historial del paciente " + registro.getNombrePaciente(paciente.idPaciente) + " (" + paciente.idPaciente + ")");
					else 
						registro.crearRegistro("El medico " + registro.getNombreMedico(idObservador) + " (" + idObservador + ") consulto el historial del paciente " + registro.getNombrePaciente(paciente.idPaciente) + " (" + paciente.idPaciente + ")");
					
					
					PanelTratamiento panel  = new PanelTratamiento(estePanel, panelContenido, paciente);			
					panelContenido.add(panel);
					panel.setVisible(true);
					estePanel.setVisible(false);
					
				}
			});
			btnComprobarTratamientos.setBounds(637, 54, 179, 28);
		}
		return btnComprobarTratamientos;
	}
}
