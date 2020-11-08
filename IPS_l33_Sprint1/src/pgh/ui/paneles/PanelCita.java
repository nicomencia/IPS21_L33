package pgh.ui.paneles;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pgh.business.cita.Cita;
import pgh.business.horario.HorarioDTO;
import pgh.business.horario.ListaHorario;
import pgh.business.medico.FindMedicoById;
import pgh.business.medico.MedicoDTO;
import pgh.business.medicocita.ListaMedicoCita;
import pgh.business.medicocita.MedicoCita;
import pgh.business.paciente.FindPacienteById;
import pgh.business.paciente.PacienteDTO;
import pgh.business.ubicacion.ListaUbicaciones;
import pgh.business.ubicacion.UbicacionDTO;

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
	private HorarioDTO horario;
	private UbicacionDTO ubicacion;
	private JPanel panelAnterior;

	/**
	 * Create the panel.
	 */
	public PanelCita(JPanel panelAnterior, Cita cita) {
		this.panelAnterior = panelAnterior;
		this.cita = cita;
		horarios = new ListaHorario().getHorarios();
		paciente = new FindPacienteById().execute(cita.getIdPaciente());
		medicoCita = new ListaMedicoCita().getMedicoCitas();
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

	}
	
	private MedicoDTO getIdMedico()
	{
		for(int i=0;i<medicoCita.size();i++)
		{
			if(medicoCita.get(i).getIdCita() == cita.getIdCita())
			{
				return new FindMedicoById().execute(medicoCita.get(i).getIdMedico());
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
			lblPaciente.setBounds(112, 93, 81, 20);
		}
		return lblPaciente;
	}
	private JLabel getLabelNombreApellidosPaciente() {
		if (labelNombreApellidosPaciente == null) {
			labelNombreApellidosPaciente = new JLabel("");
			labelNombreApellidosPaciente.setText(paciente.nombre + " " + paciente.apellidos);
			labelNombreApellidosPaciente.setBounds(218, 93, 189, 20);
		}
		return labelNombreApellidosPaciente;
	}
	private JLabel getLblMedicos() {
		if (lblMedicos == null) {
			lblMedicos = new JLabel("Medicos:");
			lblMedicos.setBounds(112, 171, 81, 20);
		}
		return lblMedicos;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(218, 171, 189, 189);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnHistorial() {
		if (btnHistorial == null) {
			btnHistorial = new JButton("Historial");
			btnHistorial.setBounds(488, 92, 89, 23);
		}
		return btnHistorial;
	}
	private JLabel getLblHorario() {
		if (lblHorario == null) {
			lblHorario = new JLabel("Horario:");
			lblHorario.setBounds(488, 171, 89, 20);
		}
		return lblHorario;
	}
	private JLabel getLabelHoras() {
		if (labelHoras == null) {
			labelHoras = new JLabel("");
			labelHoras.setText(horario.horaInicio + ":" + horario.horaFin);
			labelHoras.setBounds(587, 171, 119, 20);
		}
		return labelHoras;
	}
	private JLabel getLblUbicacion() {
		if (lblUbicacion == null) {
			lblUbicacion = new JLabel("Ubicacion:");
			lblUbicacion.setBounds(488, 234, 81, 20);
		}
		return lblUbicacion;
	}
	private JLabel getLabelSala() {
		if (labelSala == null) {
			labelSala = new JLabel(ubicacion.nombre);
			labelSala.setBounds(587, 237, 176, 17);
		}
		return labelSala;
	}
	private JLabel getLblEsUrgente() {
		if (lblEsUrgente == null) {
			lblEsUrgente = new JLabel("Es Urgente:");
			lblEsUrgente.setBounds(488, 307, 89, 20);
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
			labelUrgente.setBounds(587, 310, 61, 17);
		}
		return labelUrgente;
	}
	private JLabel getLblInformacionDeContacto() {
		if (lblInformacionDeContacto == null) {
			lblInformacionDeContacto = new JLabel("Informacion de Contacto:");
			lblInformacionDeContacto.setBounds(488, 385, 137, 20);
		}
		return lblInformacionDeContacto;
	}
	private JLabel getLabelContacto() {
		if (labelContacto == null) {
			labelContacto = new JLabel(cita.infoContacto());
			labelContacto.setBounds(635, 385, 176, 23);
		}
		return labelContacto;
	}
}
