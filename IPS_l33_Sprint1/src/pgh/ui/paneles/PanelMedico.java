package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelMedico extends JPanel {
	
    private JPanel panelMedico;
	private JPanel panelAnterior;
	private int idmedico;
	private JPanel panelContenido;
	private JButton btnElegirCita;
	private JButton btnSolicitarCita;
	private JButton btnPedirVacaciones;
	private JButton btnSalir;
	private JButton btnCalendario;
	
	public PanelMedico(JPanel panelAnterior, int id_medico, JPanel contenido) {
		
		
		setBackground(new Color(135, 206, 235));
		
		this.panelAnterior = panelAnterior;
		this.panelContenido = contenido;
		panelMedico=this;
		this.idmedico = id_medico;
		setBounds(100, 100, 1129, 600);
		setLayout(null);
		add(getBtnElegirCita());
		add(getBtnSolicitarCita());
		add(getBtnPedirVacaciones());
		add(getBtnSalir());
		add(getBtnCalendario());
		
	}
	
	
	
	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}
	private JButton getBtnElegirCita() {
		if (btnElegirCita == null) {
			btnElegirCita = new JButton("Elegir cita");
			btnElegirCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					PanelElegirPaciente panel = new PanelElegirPaciente(panelMedico, idmedico, panelContenido);
					panelContenido.add(panel);
					panelMedico.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnElegirCita.setBounds(93, 72, 140, 36);
		}
		return btnElegirCita;
	}
	private JButton getBtnSolicitarCita() {
		if (btnSolicitarCita == null) {
			btnSolicitarCita = new JButton("Solicitar Cita");
			btnSolicitarCita.setBounds(316, 72, 140, 36);
		}
		return btnSolicitarCita;
	}
	private JButton getBtnPedirVacaciones() {
		if (btnPedirVacaciones == null) {
			btnPedirVacaciones = new JButton("Pedir vacaciones");
			btnPedirVacaciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					PanelPedirVacaciones panel = new PanelPedirVacaciones(panelMedico, panelContenido, idmedico);
					panelContenido.add(panel);
					panelMedico.setVisible(false);
					panel.setVisible(true);
					
				}
			});
			btnPedirVacaciones.setBounds(542, 72, 140, 36);
		}
		return btnPedirVacaciones;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					panelAnterior.setVisible(true);
					panelMedico.setVisible(false);
				}
			});
			btnSalir.setBounds(776, 476, 140, 36);
		}
		return btnSalir;
	}

	
	private JButton getBtnCalendario() {
		if (btnCalendario == null) {
			btnCalendario = new JButton("Calendario");
			btnCalendario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					PanelCalendario panel = new PanelCalendario(panelContenido, panelMedico, idmedico);
					panelContenido.add(panel);
					panelMedico.setVisible(false);
					panel.setVisible(true);
					
				}
			});
			btnCalendario.setBounds(93, 156, 140, 36);
		}
		return btnCalendario;
	}
}
