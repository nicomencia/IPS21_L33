package pgh.ui.paneles;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import pgh.business.cita.Cita;
import pgh.business.cita.ListaCitas;
import pgh.business.prescripcion.ListaPrescripciones;
import pgh.business.prescripcion.Prescripcion;
import pgh.business.prescripcioncitapaciente.ListaPrescripcionesCitaPaciente;
import pgh.business.prescripcioncitapaciente.PrescripcionCitaPaciente;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelHistorial extends JPanel {
	private JScrollPane scrollPaneCitas;
	private JLabel lblCitas;
	private JLabel lblPrescripciones;
	private JScrollPane scrollPanePrescripciones;
	private JLabel lblHistorial;
	private JScrollPane scrollPaneHistorial;
	private JTextField textFieldHistorial;
	private JPanel panelAnterior;
	private int idPaciente;
	private DefaultListModel<Cita> modeloListaCitas = new DefaultListModel<Cita>();
	private DefaultListModel<Prescripcion> modeloListaPrescipciones = new DefaultListModel<Prescripcion>();
	private ListaCitas findCitas = new ListaCitas();
	private ListaPrescripciones findPrescripciones = new ListaPrescripciones();
	private ListaPrescripcionesCitaPaciente findPrescripcionCitaPaciente = new ListaPrescripcionesCitaPaciente();
	private List<Cita> listaCitas;
	private List<Prescripcion> listaPrescripciones;
	private List<PrescripcionCitaPaciente> listaPrescripcionCita;
	private JList listCitas;
	private JList listPrescripciones;
	private JButton btnAtras;
	private JPanel estePanel;
	private JButton btnHistorialVacunas;
	/**
	 * Create the panel.
	 */
	public PanelHistorial(JPanel panelAnterior, int idPaciente) {
		estePanel = this;
		findPrescripcionCitaPaciente.creaListaPrescripciones();
		findCitas.creaCitas();
		findPrescripciones.creaListaPrescripciones();
		listaPrescripcionCita = findPrescripcionCitaPaciente.getPrescripciones();
		listaCitas = findCitas.getCitas();
		listaPrescripciones = findPrescripciones.getPrescripciones();
		this.idPaciente=idPaciente;
		this.panelAnterior = panelAnterior;
		setLayout(null);
		add(getScrollPaneCitas());
		add(getLblCitas());
		add(getLblPrescripciones());
		add(getScrollPanePrescripciones());
		add(getLblHistorial());
		add(getScrollPaneHistorial());
		add(getBtnAtras());
		add(getBtnHistorialVacunas());

	}
	
	private void crearModeloPrescripciones()
	{
		for(int i=0;i<listaPrescripcionCita.size();i++)
		{
			if(listaPrescripcionCita.get(i).getIdPaciente() == idPaciente)
			{
				if(getPrescripcion(listaPrescripcionCita.get(i).getIdPrescripcion())!=null)
				{
					modeloListaPrescipciones.addElement(getPrescripcion(listaPrescripcionCita.get(i).getIdPrescripcion()));
				}
			}
		}
	}
	
	private void crearModeloCitas()
	{
		for(int i=0;i<listaCitas.size();i++)
		{
			if(listaCitas.get(i).getIdPaciente()==idPaciente)
			{
				modeloListaCitas.addElement(listaCitas.get(i));
			}
		}
	}
	
	private Prescripcion getPrescripcion(int id)
	{
		for(int i=0;i<listaPrescripciones.size();i++)
		{
			if(listaPrescripciones.get(i).getIdPrescripcion() == id)
			{
				return listaPrescripciones.get(i);
			}
		}
		return null;
	}
	private JScrollPane getScrollPaneCitas() {
		if (scrollPaneCitas == null) {
			scrollPaneCitas = new JScrollPane();
			scrollPaneCitas.setBounds(82, 407, 810, 72);
			scrollPaneCitas.setViewportView(getListCitas());
		}
		return scrollPaneCitas;
	}
	private JLabel getLblCitas() {
		if (lblCitas == null) {
			lblCitas = new JLabel("Citas:");
			lblCitas.setBounds(82, 365, 70, 31);
		}
		return lblCitas;
	}
	private JLabel getLblPrescripciones() {
		if (lblPrescripciones == null) {
			lblPrescripciones = new JLabel("Prescripciones:");
			lblPrescripciones.setBounds(82, 201, 127, 23);
		}
		return lblPrescripciones;
	}
	private JScrollPane getScrollPanePrescripciones() {
		if (scrollPanePrescripciones == null) {
			scrollPanePrescripciones = new JScrollPane();
			scrollPanePrescripciones.setBounds(82, 235, 810, 119);
			scrollPanePrescripciones.setViewportView(getListPrescripciones());
		}
		return scrollPanePrescripciones;
	}
	private JLabel getLblHistorial() {
		if (lblHistorial == null) {
			lblHistorial = new JLabel("Historial:");
			lblHistorial.setBounds(82, 29, 87, 31);
		}
		return lblHistorial;
	}
	private JScrollPane getScrollPaneHistorial() {
		if (scrollPaneHistorial == null) {
			scrollPaneHistorial = new JScrollPane();
			scrollPaneHistorial.setBounds(82, 71, 810, 119);
			scrollPaneHistorial.setViewportView(getTextFieldHistorial());
		}
		return scrollPaneHistorial;
	}
	private JTextField getTextFieldHistorial() {
		if (textFieldHistorial == null) {
			textFieldHistorial = new JTextField();
			textFieldHistorial.setText("Historial de abusos.");
			textFieldHistorial.setColumns(10);
		}
		return textFieldHistorial;
	}
	private JList getListCitas() {
		if (listCitas == null) {
			crearModeloCitas();
			listCitas = new JList(modeloListaCitas);
		}
		return listCitas;
	}
	private JList getListPrescripciones() {
		if (listPrescripciones == null) {
			crearModeloPrescripciones();
			listPrescripciones = new JList(modeloListaPrescipciones);
		}
		return listPrescripciones;
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
			btnAtras.setBounds(927, 495, 102, 31);
		}
		return btnAtras;
	}
	private JButton getBtnHistorialVacunas() {
		if (btnHistorialVacunas == null) {
			btnHistorialVacunas = new JButton("Historial vacunas");
			btnHistorialVacunas.setBounds(82, 490, 234, 36);
		}
		return btnHistorialVacunas;
	}
}
