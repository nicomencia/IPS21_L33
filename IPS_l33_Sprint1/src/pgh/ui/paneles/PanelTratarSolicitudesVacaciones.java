package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;

import pgh.business.vacacionesSolicitadas.VacacionesSolicitadasMedico;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTratarSolicitudesVacaciones extends JPanel {
	
	
	private JScrollPane scrollPane;
	private JPanel panelAnterior;
	private JList listSolicitudadVacacionesElegida;
	private JButton btnComprobarDisponibilidad;
	private JButton btnAsignarVacaciones;
	private JButton btnCancelar;
	private VacacionesSolicitadasMedico vacacionesSeleccionada;
	
	
	public PanelTratarSolicitudesVacaciones(JPanel panelAnterior, VacacionesSolicitadasMedico v) {
		setBackground(new Color(135, 206, 235));
		this.panelAnterior=panelAnterior;
		this.vacacionesSeleccionada = v;
		setBounds(100, 100, 1129, 600);
		setLayout(null);
		add(getScrollPane());
		add(getBtnComprobarDisponibilidad());
		add(getBtnAsignarVacaciones());
		add(getBtnCancelar());
	}
	
	

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(175, 230, 380, 76);
			scrollPane.setViewportView(getListSolicitudadVacacionesElegida());
		}
		return scrollPane;
	}
	private JList getListSolicitudadVacacionesElegida() {
		if (listSolicitudadVacacionesElegida == null) {
			listSolicitudadVacacionesElegida = new JList();
		}
		return listSolicitudadVacacionesElegida;
	}
	private JButton getBtnComprobarDisponibilidad() {
		if (btnComprobarDisponibilidad == null) {
			btnComprobarDisponibilidad = new JButton("Comprobar disponibilidad");
			btnComprobarDisponibilidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					
				}
			});
			btnComprobarDisponibilidad.setBounds(666, 243, 200, 50);
			
		}
		return btnComprobarDisponibilidad;
	}
	private JButton getBtnAsignarVacaciones() {
		if (btnAsignarVacaciones == null) {
			btnAsignarVacaciones = new JButton("Asignar vacaciones");
			btnAsignarVacaciones.setEnabled(false);
			btnAsignarVacaciones.setBounds(742, 514, 162, 35);
		}
		return btnAsignarVacaciones;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					closePanel();
				}
			});
			btnCancelar.setBounds(941, 514, 162, 35);
		}
		return btnCancelar;
	}
	
	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}
}
