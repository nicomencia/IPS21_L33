package pgh.ui.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JPanel;



public class PanelAdministrativo extends JPanel {
	
	
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private JPanel panelAdministrativo;
	private JButton btnSalir;
	private JButton btnAsignarCita;
	private JButton btnAsignarJornadasMedicos;
	private JButton btnAsignarJornadasAEnfermeros;
	private JButton btnComprobarVacacionesSolicitadas;
	private JButton btnNewButton;
	private JButton btnCrearEquipoMedico;
	private JButton btnNewButton_1;

	
	
	public PanelAdministrativo (JPanel panelAnterior, JPanel panelContenido) {
		
		this.panelAnterior = panelAnterior;
		this.panelContenido= panelContenido;
		panelAdministrativo = this;
		getPanelAdministrativo();
		
	}
	
	private JPanel getPanelAdministrativo() {
		
			
			this.setBackground(Color.WHITE);
			this.setLayout(null);
			this.add(getBtnSalir());
			this.add(getBtnAsignarCita());
			this.add(getBtnAsignarJornadasMedicos());
			this.add(getBtnAsignarJornadasAEnfermeros());
			this.add(getBtnComprobarVacacionesSolicitadas());

			add(getBtnNewButton());

			
			JButton btnNewButton = new JButton("Asignar Medico a Cita");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PanelCitasSinMedico pc = new PanelCitasSinMedico(panelAdministrativo, panelContenido);
					panelContenido.add(pc);
					panelAdministrativo.setVisible(false);
					pc.setVisible(true);
				}
			});
			btnNewButton.setBounds(45, 135, 198, 38);
			add(btnNewButton);
			add(getBtnCrearEquipoMedico());
			add(getBtnNewButton_1());


		
		    return panelAdministrativo;
	}
	
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.setFocusable(false);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					closePanel();
				}
			});
			btnSalir.setBackground(Color.RED);
			btnSalir.setForeground(Color.WHITE);
			btnSalir.setBounds(862, 450, 115, 38);
		}
		return btnSalir;
	}
	
	private JButton getBtnAsignarCita() {
		if (btnAsignarCita == null) {
			btnAsignarCita = new JButton("Asignar Citas");
			btnAsignarCita.setFocusable(false);
			btnAsignarCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PanelCitas pc = new PanelCitas(panelAdministrativo, panelContenido);
					panelContenido.add(pc);
					panelAdministrativo.setVisible(false);
					pc.setVisible(true);
				}
			});
			btnAsignarCita.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnAsignarCita.setBounds(45, 54, 147, 38);
		}
		return btnAsignarCita;
	}
	
	
	private JButton getBtnAsignarJornadasMedicos() {
		if (btnAsignarJornadasMedicos == null) {
			btnAsignarJornadasMedicos = new JButton("Asignar Jornadas a Medicos");
			btnAsignarJornadasMedicos.setFocusable(false);
			btnAsignarJornadasMedicos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					PanelJornadaMedico pc = new PanelJornadaMedico(panelAdministrativo);
					panelContenido.add(pc);
					panelAdministrativo.setVisible(false);
					pc.setVisible(true);
				}
			});
			btnAsignarJornadasMedicos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnAsignarJornadasMedicos.setBounds(227, 54, 241, 38);
		}
		return btnAsignarJornadasMedicos;
	}

	private JButton getBtnAsignarJornadasAEnfermeros() {
		if (btnAsignarJornadasAEnfermeros == null) {
			btnAsignarJornadasAEnfermeros = new JButton("Asignar Jornadas a Enfermeros");
			btnAsignarJornadasAEnfermeros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					PanelJornadaEnfermero pc = new PanelJornadaEnfermero(panelAdministrativo);
					panelContenido.add(pc);
					panelAdministrativo.setVisible(false);
					pc.setVisible(true);
				}
			});
			btnAsignarJornadasAEnfermeros.setFocusable(false);
			btnAsignarJornadasAEnfermeros.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnAsignarJornadasAEnfermeros.setBounds(495, 54, 265, 38);
		}
		return btnAsignarJornadasAEnfermeros;
	}
	
	
	private JButton getBtnComprobarVacacionesSolicitadas() {
		if (btnComprobarVacacionesSolicitadas == null) {
			btnComprobarVacacionesSolicitadas = new JButton("Asignar vacaciones solicitadas");
			btnComprobarVacacionesSolicitadas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					PanelSolicitudesVacacionesAdministrador panel = new PanelSolicitudesVacacionesAdministrador(panelAdministrativo, panelContenido, panelAdministrativo);
					panelContenido.add(panel);
					panelAdministrativo.setVisible(false);
					panel.setVisible(true);
					
				}
			});
			btnComprobarVacacionesSolicitadas.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnComprobarVacacionesSolicitadas.setBounds(802, 54, 265, 38);
		}
		return btnComprobarVacacionesSolicitadas;
	}
	
	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Ver Citas");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PanelListaCitas panel = new PanelListaCitas(panelAdministrativo, panelContenido, null);
					panelContenido.add(panel);
					panelAdministrativo.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton.setBounds(268, 135, 147, 38);
		}
		return btnNewButton;
	}

	private JButton getBtnCrearEquipoMedico() {
		if (btnCrearEquipoMedico == null) {
			btnCrearEquipoMedico = new JButton("Crear Equipo Medico");
			btnCrearEquipoMedico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PanelCrearEquipoMedico pc = new PanelCrearEquipoMedico(panelAdministrativo, panelContenido);
					panelContenido.add(pc);
					panelAdministrativo.setVisible(false);
					pc.setVisible(true);
				}
			});
			btnCrearEquipoMedico.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnCrearEquipoMedico.setBounds(45, 209, 198, 38);
		}
		return btnCrearEquipoMedico;

	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Aumentar vacaciones");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PanelAumentarVacaciones panel = new PanelAumentarVacaciones(panelAdministrativo, panelContenido);
					panelContenido.add(panel);
					panelAdministrativo.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton_1.setBounds(495, 135, 200, 38);
		}
		return btnNewButton_1;
	}
}
