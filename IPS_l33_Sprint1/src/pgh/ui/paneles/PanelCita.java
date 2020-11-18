package pgh.ui.paneles;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pgh.business.cita.Cita;
import pgh.business.equipomedico.EquipoMedico;
import pgh.business.equipomedico.EquipoMedicoDTO;
import pgh.business.equipomedico.FindAllEquiposMedicos;
import pgh.business.horario.HorarioDTO;
import pgh.business.horario.ListaHorario;
import pgh.business.medico.FindAllMedicos;
import pgh.business.medico.FindMedicoById;
import pgh.business.medico.MedicoDTO;
import pgh.business.medicocita.ListaMedicoCita;
import pgh.business.medicocita.MedicoCita;
import pgh.business.paciente.FindAllPacientes;
import pgh.business.paciente.PacienteDTO;
import pgh.business.ubicacion.ListaUbicaciones;
import pgh.business.ubicacion.UbicacionDTO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCita extends JPanel {
	private JLabel lblPaciente;
	private JLabel labelNombreApellidosPaciente;
	private JLabel lblMedicos;
	private JTextField textField;
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
	private JLabel lblEquipoDelMdico;
	private JLabel lblEquipoMedico;
	private JButton btnIndicarPrescripcion;
	private JButton btnAntecedentesClinicos;
	
	/**
	 * Create the panel.
	 */
	public PanelCita(JPanel panelContenido, JPanel panelAnterior, Cita cita) {
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
		setLayout(null);
		add(getLblPaciente());
		add(getLabelNombreApellidosPaciente());
		add(getLblMedicos());
		add(getTextField());
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
		add(getLblEquipoDelMdico());
		add(getLblEquipoMedico());
		add(getBtnIndicarPrescripcion());
		add(getBtnAntecedentesClinicos());
		
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
			lblPaciente.setBounds(134, 172, 81, 20);
		}
		return lblPaciente;
	}
	private JLabel getLabelNombreApellidosPaciente() {
		if (labelNombreApellidosPaciente == null) {
			labelNombreApellidosPaciente = new JLabel("");
			labelNombreApellidosPaciente.setText(paciente.nombre + " " + paciente.apellidos);
			labelNombreApellidosPaciente.setBounds(225, 172, 295, 20);
		}
		return labelNombreApellidosPaciente;
	}
	private JLabel getLblMedicos() {
		if (lblMedicos == null) {
			lblMedicos = new JLabel("Medicos:");
			lblMedicos.setBounds(134, 250, 81, 20);
		}
		return lblMedicos;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField(medico.nombre + " " + medico.apellidos);
			textField.setBounds(225, 250, 237, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnHistorial() {
		if (btnHistorial == null) {
			btnHistorial = new JButton("Historial");
			btnHistorial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PanelHistorial panel = new PanelHistorial(estePanel, cita.getIdPaciente());
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
	private JLabel getLblEquipoDelMdico() {
		if (lblEquipoDelMdico == null) {
			lblEquipoDelMdico = new JLabel("Equipo del M\u00E9dico:");
			lblEquipoDelMdico.setBounds(134, 318, 108, 17);
		}
		return lblEquipoDelMdico;
	}
	private JButton getBtnAntecedentesClinicos() {
		if (btnAntecedentesClinicos == null) {
			btnAntecedentesClinicos = new JButton("Antecedentes Clinicos");
			btnAntecedentesClinicos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
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

					PanelPrescripcion panel = new PanelPrescripcion(estePanel, medico.idMedico, paciente.idPaciente, cita.getIdCita(), panelContenido, estePanel);
					panelContenido.add( panel);
					estePanel.setVisible(false);
					panel.setVisible(true);
					
				}
			});
			btnIndicarPrescripcion.setBounds(134, 68, 179, 28);
		}
		return btnIndicarPrescripcion;
	}
	private JLabel getLblEquipoMedico() {
		if (lblEquipoMedico == null) {
			lblEquipoMedico = new JLabel("");
			lblEquipoMedico.setText(getEquipoMedicos(medico));
			lblEquipoMedico.setBounds(252, 318, 210, 17);
		}
		return lblEquipoMedico;
	}
}
