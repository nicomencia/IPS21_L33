package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;

import pgh.business.jornadamedico.JornadaMedico;
import pgh.business.jornadamedico.JornadaMedicoDTO;
import pgh.business.jornadamedico.ListaJornadasMedico;
import pgh.business.vacacionesSolicitadas.ListaVacacionesSolicitadasMedico;
import pgh.business.vacacionesSolicitadas.ModificarVacacionesSolicitadasMedico;
import pgh.business.vacacionesSolicitadas.VacacionesSolicitadasMedico;
import pgh.business.vacacionesmedico.CrearVacacionesMedico;
import pgh.business.vacacionesmedico.ListaVacacionesMedico;
import pgh.business.vacacionesmedico.VacacionesMedico;
import pgh.business.vacacionesmedico.VacacionesMedicoDTO;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
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
	private DefaultListModel<VacacionesSolicitadasMedico> modeloVacacioneSolicitadas;
	private ListaJornadasMedico ljm;
	private CrearVacacionesMedico crearVacaciones;
	private VacacionesMedicoDTO vacacionesMedicoDTO;
	private VacacionesMedico vacacionesMedico;
	private JPanel panelCambiar;
	private JPanel panelContenido;
	private ModificarVacacionesSolicitadasMedico modificar;
	
	private JPanel estePanel;
	private JButton btnDenegarlas;
	
	public PanelTratarSolicitudesVacaciones(JPanel panelAnterior, VacacionesSolicitadasMedico v, JPanel panelcambiar, JPanel panelContenido) {
		setBackground(new Color(135, 206, 235));
		this.panelAnterior=panelAnterior;
		this.vacacionesSeleccionada = v;
		this.panelContenido = panelContenido;
		this.panelCambiar = panelCambiar;
		estePanel=this;
		setBounds(100, 100, 1129, 600);
		setLayout(null);
		add(getScrollPane());
		add(getBtnComprobarDisponibilidad());
		add(getBtnAsignarVacaciones());
		add(getBtnCancelar());
		add(getBtnDenegarlas());
	}
	
	

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(175, 173, 380, 76);
			scrollPane.setViewportView(getListSolicitudadVacacionesElegida());
		}
		return scrollPane;
	}
	private JList getListSolicitudadVacacionesElegida() {
		if (listSolicitudadVacacionesElegida == null) {
			modeloVacacioneSolicitadas = new DefaultListModel<VacacionesSolicitadasMedico>();
			llenarLista();
			listSolicitudadVacacionesElegida = new JList(modeloVacacioneSolicitadas);
		}
		return listSolicitudadVacacionesElegida;
	}
	private void llenarLista() {
	
	
		
		modeloVacacioneSolicitadas.addElement(vacacionesSeleccionada);
	

		
	}



	private JButton getBtnComprobarDisponibilidad() {
		if (btnComprobarDisponibilidad == null) {
			btnComprobarDisponibilidad = new JButton("Comprobar disponibilidad");
			btnComprobarDisponibilidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					boolean correcto = false;
					ljm = new ListaJornadasMedico(modeloVacacioneSolicitadas.getElementAt(0).getIdMedico());
					ljm.creaJornadaMedicoFiltro();
				
					for(int i=0; i<ljm.getJornadasMedicosFiltro().size();i++) {
						if(ljm.getJornadasMedicosFiltro().get(i).getDiaInicio().before(modeloVacacioneSolicitadas.getElementAt(0).getFechaInicio())) {
							if(ljm.getJornadasMedicosFiltro().get(i).getDiaFin().after(modeloVacacioneSolicitadas.getElementAt(0).getFechaFin())) {
								btnAsignarVacaciones.setEnabled(true);
								correcto = true;
							}
						}
					}
					
					if(correcto == true) {
							
						JOptionPane.showMessageDialog(btnComprobarDisponibilidad, "Las vacaciones pueden ser asignadas");
						
					}
					else{
						JOptionPane.showMessageDialog(btnComprobarDisponibilidad, "Las vacaciones no pueden ser asignadas, no estan dentro de su jornada laboral");
					}
					
					
				}
			});
			btnComprobarDisponibilidad.setBounds(666, 186, 200, 50);
			
		}
		return btnComprobarDisponibilidad;
	}
	private JButton getBtnAsignarVacaciones() {
		if (btnAsignarVacaciones == null) {
			btnAsignarVacaciones = new JButton("Asignar vacaciones");
			btnAsignarVacaciones.setEnabled(false);
			btnAsignarVacaciones.setBounds(547, 489, 162, 35);
			btnAsignarVacaciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					vacacionesMedicoDTO = new VacacionesMedicoDTO();
					vacacionesMedicoDTO.idVacacionesMedico= generarIDVacacionesMedico();
					vacacionesMedicoDTO.idMedico = modeloVacacioneSolicitadas.getElementAt(0).getIdMedico();
					vacacionesMedicoDTO.diaInicio = modeloVacacioneSolicitadas.getElementAt(0).getFechaInicio();
					vacacionesMedicoDTO.diaFin = modeloVacacioneSolicitadas.getElementAt(0).getFechaFin();
					
					vacacionesMedico = new VacacionesMedico(vacacionesMedicoDTO);
					crearVacaciones= new CrearVacacionesMedico();
					crearVacaciones.crearVacaciones(vacacionesMedico);
					
					modeloVacacioneSolicitadas.removeAllElements();
					
					modificar = new ModificarVacacionesSolicitadasMedico();
					
					modificar.modificarEstados(true, false, false);
					
					closePanel();
					
				}

			});
		}
		return btnAsignarVacaciones;
	}
	
	private int generarIDVacacionesMedico() {
		
		ListaVacacionesMedico lm = new ListaVacacionesMedico();
		lm.creaVacaciones();
		return 1100 + lm.getVacaciones().size();
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					closePanel();
				}
			});
			btnCancelar.setBounds(940, 489, 162, 35);
		}
		return btnCancelar;
	}
	
	protected void closePanel() {
	
		PanelSolicitudesVacacionesAdministrador panel = new PanelSolicitudesVacacionesAdministrador(estePanel, panelContenido, panelCambiar);
		estePanel.setVisible(false);
		panelContenido.add(panel);
		panel.setVisible(true);
		
	}
	private JButton getBtnDenegarlas() {
		if (btnDenegarlas == null) {
			btnDenegarlas = new JButton("Denegarlas");
			btnDenegarlas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					modificar = new ModificarVacacionesSolicitadasMedico();
					modificar.modificarEstados(false, true, false);
					
					closePanel();
				}
			});
			btnDenegarlas.setBounds(739, 489, 176, 35);
		}
		return btnDenegarlas;
	}
}
