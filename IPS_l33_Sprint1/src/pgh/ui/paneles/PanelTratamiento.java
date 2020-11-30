package pgh.ui.paneles;

import javax.swing.JPanel;

import pgh.business.enfermedad.EnfermedadDTO;
import pgh.business.enfermedad.FindAllEnfermedades;
import pgh.business.enfermedad.GuardarEnfermedad;
import pgh.business.paciente.Paciente;
import pgh.business.paciente.PacienteDTO;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelTratamiento extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private JPanel estePanel;
	private PacienteDTO paciente;
	private JScrollPane scrollPaneTratamientos;
	private JList listTratamientos;
	private JLabel lblTratamientos;
	private JLabel lblPaciente;
	private JLabel labelNombrePaciente;
	private JButton btnAtras;
	private List<EnfermedadDTO> enfermedades = new ArrayList<EnfermedadDTO>();
	private DefaultListModel<EnfermedadDTO>  modeloTratamientos = new DefaultListModel<EnfermedadDTO>();
	private JButton btnTerminarTratamiento;
	
	public PanelTratamiento(JPanel panelAnterior, JPanel panelContenido, PacienteDTO paciente) {
		this.paciente = paciente;
		enfermedades = new FindAllEnfermedades().execute();
		añadirTratamientos();
		estePanel = this;
		this.panelAnterior = panelAnterior;
		this.panelContenido = panelContenido;
		setLayout(null);
		add(getScrollPaneTratamientos());
		add(getLblTratamientos());
		add(getLblPaciente());
		add(getLabelNombrePaciente());
		add(getBtnAtras());
		add(getBtnTerminarTratamiento());
	}
	
	private void añadirTratamientos() {
		modeloTratamientos.removeAllElements();
		if(enfermedades!=null)
		{
		for(int i=0;i<enfermedades.size();i++)
		{
			if(enfermedades.get(i).id_paciente==paciente.idPaciente && enfermedades.get(i).seguimiento)
			{
				modeloTratamientos.addElement(enfermedades.get(i));
			}
		}
		}
	}
	private JScrollPane getScrollPaneTratamientos() {
		if (scrollPaneTratamientos == null) {
			scrollPaneTratamientos = new JScrollPane();
			scrollPaneTratamientos.setBounds(77, 79, 784, 386);
			scrollPaneTratamientos.setViewportView(getListTratamientos());
		}
		return scrollPaneTratamientos;
	}
	private JList getListTratamientos() {
		if (listTratamientos == null) {
			listTratamientos = new JList(modeloTratamientos);
		}
		return listTratamientos;
	}
	private JLabel getLblTratamientos() {
		if (lblTratamientos == null) {
			lblTratamientos = new JLabel("Tratamientos");
			lblTratamientos.setBounds(77, 47, 90, 21);
		}
		return lblTratamientos;
	}
	private JLabel getLblPaciente() {
		if (lblPaciente == null) {
			lblPaciente = new JLabel("Paciente:");
			lblPaciente.setBounds(261, 50, 65, 14);
		}
		return lblPaciente;
	}
	private JLabel getLabelNombrePaciente() {
		if (labelNombrePaciente == null) {
			labelNombrePaciente = new JLabel(paciente.nombre + " " + paciente.apellidos);
			labelNombrePaciente.setBounds(336, 50, 525, 21);
		}
		return labelNombrePaciente;
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
			btnAtras.setBounds(772, 495, 89, 23);
		}
		return btnAtras;
	}
	private JButton getBtnTerminarTratamiento() {
		if (btnTerminarTratamiento == null) {
			btnTerminarTratamiento = new JButton("Terminar Tratamiento");
			btnTerminarTratamiento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(listTratamientos.getSelectedValue()!=null)
					{
						EnfermedadDTO en = (EnfermedadDTO) listTratamientos.getSelectedValue();
						if(en.seguimiento)
						{
							new GuardarEnfermedad().crearMedico(en.id_emfermedad, new Date());
							enfermedades = new FindAllEnfermedades().execute();
							añadirTratamientos();
							
						}
					}
				}
			});
			btnTerminarTratamiento.setBounds(585, 495, 177, 23);
		}
		return btnTerminarTratamiento;
	}
}
