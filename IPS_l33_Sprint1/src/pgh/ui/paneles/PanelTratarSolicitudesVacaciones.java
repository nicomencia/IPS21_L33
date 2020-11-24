package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;

import pgh.business.cita.Cita;
import pgh.business.cita.CitaDTO;
import pgh.business.cita.FindAllCitas;
import pgh.business.jornadamedico.ListaJornadasMedico;
import pgh.business.vacacionesSolicitadas.ModificarVacacionesSolicitadasMedico;
import pgh.business.vacacionesSolicitadas.VacacionesSolicitadasMedico;
import pgh.business.vacacionesmedico.CrearVacacionesMedico;
import pgh.business.vacacionesmedico.ListaVacacionesMedico;
import pgh.business.vacacionesmedico.VacacionesMedico;
import pgh.business.vacacionesmedico.VacacionesMedicoDTO;
import pgh.ui.paneles.filtros.JListFiltroPanelSolicitudesCitas;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
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
	private DefaultListModel<Cita> modelCitas;
	private JPanel estePanel;
	private JButton btnDenegarlas;
	private JScrollPane scrollPaneCitasMedico;
	private JListFiltroPanelSolicitudesCitas listCitasMedico;
	private JButton btnAsignarMedico;
	private JButton btnPosponerCitas;
	private FindAllCitas findCitas;
	private CitaDTO citaCTO;
	private Cita cita;
	private JLabel lblNewLabel;
	
	public PanelTratarSolicitudesVacaciones(JPanel panelAnterior, VacacionesSolicitadasMedico v, JPanel panelcambiar, JPanel panelContenido) {
		setBackground(new Color(135, 206, 235));
		this.panelAnterior=panelAnterior;
		this.vacacionesSeleccionada = v;
		this.panelContenido = panelContenido;
		this.panelCambiar = panelcambiar;
		estePanel=this;
		setBounds(100, 100, 1129, 545);
		setLayout(null);
		add(getScrollPane());
		add(getBtnComprobarDisponibilidad());
		add(getBtnAsignarVacaciones());
		add(getBtnCancelar());
		add(getBtnDenegarlas());
		add(getScrollPaneCitasMedico());
		add(getBtnAsignarMedico());
		add(getBtnPosponerCitas());
		add(getLblNewLabel());
	}
	
	

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(175, 71, 380, 76);
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
					
					if(correcto == true ) {
							
						JOptionPane.showMessageDialog(btnComprobarDisponibilidad, "Las vacaciones pueden ser asignadas");
						getBtnPosponerCitas().setEnabled(true);
						getBtnAsignarMedico().setEnabled(true);
						
					}
					else{
						
						
							JOptionPane.showMessageDialog(btnComprobarDisponibilidad, "Las vacaciones no pueden ser asignadas, no estan dentro de su jornada laboral");
						
						
						
					}
					
					
				}
			});
			btnComprobarDisponibilidad.setBounds(672, 81, 200, 50);
			
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
					
					if(!modelCitas.isEmpty()) {
						JOptionPane.showMessageDialog(getBtnAsignarVacaciones(), "Las vacaciones no pueden ser asignadas sin posponer o asignar sus citas previamente");
					}
					else {
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
						
						modificar.modificarEstados(true, false, false, vacacionesSeleccionada.getIdVacacionesSolicitadas());
						
						closePanel();
					}
					
					
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
					modificar.modificarEstados(false, true, false, vacacionesSeleccionada.getIdVacacionesSolicitadas());
					
					closePanel();
				}
			});
			btnDenegarlas.setBounds(739, 489, 176, 35);
		}
		return btnDenegarlas;
	}
	private JScrollPane getScrollPaneCitasMedico() {
		if (scrollPaneCitasMedico == null) {
			scrollPaneCitasMedico = new JScrollPane();
			scrollPaneCitasMedico.setBounds(175, 217, 380, 189);
			scrollPaneCitasMedico.setViewportView(getListCitasMedico());
		}
		return scrollPaneCitasMedico;
	}
	private JList getListCitasMedico() {
		if (listCitasMedico == null) {
			modelCitas = new DefaultListModel<Cita>();
			llenarListaCitas();
			listCitasMedico = new JListFiltroPanelSolicitudesCitas(modelCitas);
			listCitasMedico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.add(listCitasMedico.gettextoFiltro());
			if(modelCitas.isEmpty()) {
				getBtnAsignarMedico().setEnabled(false);
				getBtnPosponerCitas().setEnabled(false);
			}
		}
		return listCitasMedico;
	}
	
	private void llenarListaCitas() {
		
		findCitas = new FindAllCitas();
		
		for(CitaDTO c : findCitas.FindCitaIdMedico(modeloVacacioneSolicitadas.getElementAt(0).getIdMedico())) {
			
		
		
					if(modeloVacacioneSolicitadas.getElementAt(0).getFechaInicio().before(c.fecha) || modeloVacacioneSolicitadas.getElementAt(0).getFechaInicio().equals(c.fecha) || modeloVacacioneSolicitadas.getElementAt(0).getFechaFin().equals(c.fecha) ) {
						if(modeloVacacioneSolicitadas.getElementAt(0).getFechaFin().after(c.fecha)) {
							cita = new Cita(c);
							modelCitas.addElement(cita);
						}
					}	
				}
		}
			
			



	private JButton getBtnAsignarMedico() {
		if (btnAsignarMedico == null) {
			btnAsignarMedico = new JButton("Asignar citas del medico");
			btnAsignarMedico.setEnabled(false);
			btnAsignarMedico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					PanelAsignarCitasVacaciones panel = new PanelAsignarCitasVacaciones(panelAnterior, panelContenido, vacacionesSeleccionada, panelCambiar);
					estePanel.setVisible(false);
					panelContenido.add(panel);
					panel.setVisible(true);
					
				}
			});
			btnAsignarMedico.setBounds(672, 232, 200, 50);
		}
		return btnAsignarMedico;
	}
	private JButton getBtnPosponerCitas() {
		if (btnPosponerCitas == null) {
			btnPosponerCitas = new JButton("Posponer citas");
			btnPosponerCitas.setEnabled(false);
			btnPosponerCitas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					PanelPosponerCitas panel = new PanelPosponerCitas(estePanel, panelContenido, vacacionesSeleccionada, panelCambiar);
					panelContenido.add(panel);
					estePanel.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnPosponerCitas.setBounds(672, 320, 200, 50);
		}
		return btnPosponerCitas;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("NOTA : Si la lista de citas esta vacia es porque no tiene citas durante sus vacaciones ");
			lblNewLabel.setForeground(new Color(255, 0, 0));
			lblNewLabel.setBounds(175, 413, 697, 50);
		}
		return lblNewLabel;
	}
}
