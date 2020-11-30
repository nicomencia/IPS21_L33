package pgh.ui.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import pgh.business.registro.CrearRegistro;

public class PanelMedicoCita extends JPanel {
	
	private JPanel panelMedicoCita;
	private JPanel panelAnterior;
	private int idmedico;
	private JButton btnSalirPanelMedico;
	private JButton btnIndicarPrescripcion;
	private JButton btnAntecedentesClinicos;
	private JPanel panelContenido;
	private int id_paciente;
	private int id_cita ;
	
	
	
	public PanelMedicoCita(JPanel panelAnterior, int id_medico,int idPaciente,int idCita, JPanel contenido) {
		
		this.setBounds(100, 100, 1129, 600);
		this.panelAnterior = panelAnterior;
		this.idmedico = id_medico;
		this.id_cita = idCita;
		this.id_paciente= idPaciente;
		this.panelContenido = contenido;
		panelMedicoCita=this;
		getPanelMedico();
		
	}
	
	private JPanel getPanelMedico() {
			panelMedicoCita.setBackground(new Color(135, 206, 235));
			panelMedicoCita.setLayout(null);
			setLayout(null);
			panelMedicoCita.add(getBtnIndicarPrescripcion());
			panelMedicoCita.add(getBtnSalirPanelMedico());
			add(getBtnAntecedentesClinicos());
		
		return panelMedicoCita;
	}
	
	private JButton getBtnIndicarPrescripcion() {
		if (btnIndicarPrescripcion == null) {
			btnIndicarPrescripcion = new JButton("Indicar prescripcion");
			btnIndicarPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					PanelPrescripcion panel = new PanelPrescripcion(panelMedicoCita, idmedico, id_paciente, id_cita, panelContenido, panelMedicoCita, idmedico);
					panelContenido.add( panel);
					panelMedicoCita.setVisible(false);
					panel.setVisible(true);
					
				}
			});
			btnIndicarPrescripcion.setBounds(78, 69, 151, 38);
		}
		return btnIndicarPrescripcion;
	}
	
	private JButton getBtnSalirPanelMedico() {
		if (btnSalirPanelMedico == null) {
			btnSalirPanelMedico = new JButton("Salir");
			btnSalirPanelMedico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					panelAnterior.setVisible(true);
					panelMedicoCita.setVisible(false);
				}
			});
			btnSalirPanelMedico.setBounds(941, 452, 124, 46);
		}
		return btnSalirPanelMedico;
	}
	
	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}
	private JButton getBtnAntecedentesClinicos() {
		if (btnAntecedentesClinicos == null) {
			btnAntecedentesClinicos = new JButton("Antecedentes Clinicos");
			btnAntecedentesClinicos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//Registro
					CrearRegistro registro = new CrearRegistro();
					registro.crearRegistro("El medico " + registro.getNombreMedico(idmedico) + " (" + idmedico + ") consulto los antecedentes clinicos del paciente " + registro.getNombrePaciente(id_paciente) + " (" + id_paciente + ")");
					
					PanelAntecedentesClinicos panel = new PanelAntecedentesClinicos(panelMedicoCita, panelContenido, id_paciente, panelMedicoCita,id_cita );
					panelContenido.add(panel);
					panelMedicoCita.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnAntecedentesClinicos.setBounds(279, 69, 177, 38);
		}
		return btnAntecedentesClinicos;
	}
}
