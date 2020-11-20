package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

import pgh.business.cita.Cita;
import pgh.business.cita.CitaDTO;
import pgh.business.cita.FindAllCitas;
import pgh.business.medico.Medico;
import pgh.business.vacuna.FindAllVacunas;
import pgh.business.vacuna.Vacuna;
import pgh.business.vacuna.VacunaDTO;
import pgh.ui.paneles.filtros.JListFiltroCalendarioVacunas;
import pgh.ui.paneles.filtros.JListFiltroCalendarioVacunasPuestas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelHistorialVacunas extends JPanel{
	private JScrollPane scrollPane;
	private JButton btnProgramarVacuna;
	private JButton btnSalir;
	private JListFiltroCalendarioVacunas listVacunas;
	private DefaultListModel<Vacuna> modeloListVacunas;
	private DefaultListModel<Vacuna> modeloListVacunasPuestas;
	private JTextField textField;
	private JPanel panelanterior;
	private JPanel panelcontenido;
	private JPanel panelcambiar;
	private JPanel estePanel;
	private int idpaciente;
	private FindAllVacunas findAllVacunas;
	private Vacuna vacuna;
	private JScrollPane scrollPane_1;
	private JTextField textField_1;
	private JListFiltroCalendarioVacunasPuestas listVacunasPuestas;
	
	public PanelHistorialVacunas(JPanel panelAnterior, JPanel panelContenido, int idPaciente, JPanel panelCambiar) {
		
		this.idpaciente = idPaciente;
		this.panelanterior= panelAnterior;
		this.panelcambiar= panelCambiar;
		this.panelcontenido = panelContenido;
		this.estePanel= this;
		
		setBackground(new Color(135, 206, 235));
		this.setBounds(100, 100, 1129, 600);
		setLayout(null);
		add(getScrollPane());
		add(getBtnProgramarVacuna());
		add(getBtnSalir());
		add(getScrollPane_1());
		
		
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(61, 51, 519, 374);
			scrollPane.setViewportView(getListVacunas());
		}
		return scrollPane;
	}
	private JButton getBtnProgramarVacuna() {
		if (btnProgramarVacuna == null) {
			btnProgramarVacuna = new JButton("Programar nueva vacuna");
			btnProgramarVacuna.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					PanelProgramarVacuna panel = new PanelProgramarVacuna(estePanel, panelcontenido, idpaciente, panelcambiar);
					estePanel.setVisible(false);
					panelcontenido.add(panel);
					panel.setVisible(true);
				}
			});
			btnProgramarVacuna.setBounds(61, 460, 519, 42);
		}
		return btnProgramarVacuna;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panelcambiar.setVisible(true);
					estePanel.setVisible(false);
				}
			});
			btnSalir.setForeground(new Color(255, 0, 0));
			btnSalir.setBounds(903, 460, 175, 42);
		}
		return btnSalir;
	}
	
	private JList getListVacunas() {
		if (listVacunas == null) {
			modeloListVacunas = new DefaultListModel<Vacuna>();
			llenarListaVacunas();
			listVacunas = new JListFiltroCalendarioVacunas(modeloListVacunas);
			this.add(listVacunas.gettextoFiltro());
		}
		return listVacunas;
	}
	private void llenarListaVacunas() {
		
		findAllVacunas = new FindAllVacunas();
		
		for(VacunaDTO c : findAllVacunas.FindVacunaByIdNoPuesta(idpaciente)) {

				vacuna = new Vacuna(c);
				modeloListVacunas.addElement(vacuna);
		}
		
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(616, 50, 460, 375);
			scrollPane_1.setViewportView(getListVacunasPuestas());
		}
		return scrollPane_1;
	}
	private JList getListVacunasPuestas() {
		if (listVacunasPuestas == null) {
			modeloListVacunasPuestas = new DefaultListModel<Vacuna>();
			llenarListaVacunasPuestas();
			listVacunasPuestas = new JListFiltroCalendarioVacunasPuestas(modeloListVacunasPuestas);
			this.add(listVacunasPuestas.gettextoFiltro());
			
		}
		return listVacunasPuestas;
	}
	private void llenarListaVacunasPuestas() {
		
findAllVacunas = new FindAllVacunas();
		
		for(VacunaDTO c : findAllVacunas.FindVacunaByIdPuesta(idpaciente)) {

				vacuna = new Vacuna(c);
				modeloListVacunasPuestas.addElement(vacuna);
		}
		
	}
}
