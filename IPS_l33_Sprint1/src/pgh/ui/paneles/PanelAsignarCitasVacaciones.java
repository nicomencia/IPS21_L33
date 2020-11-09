package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import pgh.business.cita.Cita;
import pgh.business.cita.CitaDTO;
import pgh.business.cita.FindAllCitas;
import pgh.business.jornadamedico.FindAllJornadasMedico;
import pgh.business.jornadamedico.JornadaMedico;
import pgh.business.jornadamedico.JornadaMedicoDTO;
import pgh.business.jornadamedico.ListaJornadasMedico;
import pgh.business.medico.ListaMedicos;
import pgh.business.medico.Medico;
import pgh.business.medico.MedicoDTO;
import pgh.business.medico.CrearMedico;
import pgh.business.medicoSustituto.ListaMedicosSustitutos;
import pgh.business.medicoSustituto.MedicoSustituto;
import pgh.business.medicoSustituto.MedicoSustitutoDTO;
import pgh.business.medicoSustituto.RemoveMedicoSuplente;
import pgh.business.medicocita.EditarMedicoCitas;
import pgh.business.medicocita.FindAllMedicoCita;
import pgh.business.medicocita.MedicoCita;
import pgh.business.medicocita.MedicoCitaDTO;
import pgh.business.vacacionesSolicitadas.VacacionesSolicitadasMedico;
import pgh.ui.paneles.filtros.JListFiltroMedicoCitasAsignarVacaciones;
import pgh.ui.paneles.filtros.JListFiltroMedicosSustitutosAsignarCitas;
import pgh.ui.paneles.filtros.JListFiltroPanelCitaAsignarCitasVacaciones;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PanelAsignarCitasVacaciones extends JPanel {
	private JScrollPane scrollPaneCitasMedicoAnterior;
	private JListFiltroPanelCitaAsignarCitasVacaciones listCitasMedicoAnterior;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton btnSeleccionarMedicoTitular;
	private JButton btnSeleccionarMedicoSuplente;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnAsignarCita;
	private JButton btnCancelarCita;
	private JScrollPane scrollPane_3;
	private JButton btnEliminarCitaSeleccionada;
	private DefaultListModel<Cita> modeloCitasAAsignar;
	private DefaultListModel<Cita> modeloCitasAsignadas;
	private DefaultListModel<Medico> modeloListMedicos;
	private DefaultListModel<MedicoSustituto> modeloListMedicosSuplentes;
	private JButton btnSeleccionarCita;
	private JLabel lblNewLabel;
	private JLabel lblListaDeMedicos;
	private JLabel lblListaDeMedicos_2;
	private JLabel lblListaDeMedicos_2_1;
	private JListFiltroMedicoCitasAsignarVacaciones listMedicosActivos;
	private JListFiltroMedicosSustitutosAsignarCitas listMedicosSuplentes;
	private JList listCitaAReasignar;
	private FindAllCitas findCitas;
	private CitaDTO citaCTO;
	private Cita cita;
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private VacacionesSolicitadasMedico vacaciones;
	private JPanel estePanel;
	private ListaMedicos lm;
	private ListaMedicosSustitutos lms;
	private FindAllJornadasMedico findJornadaMedico;
	private JornadaMedicoDTO jornadaDTO;
	private JornadaMedico jornada;
	private EditarMedicoCitas editarMedicoCitas;
	private FindAllMedicoCita findMedicoCita;
	private MedicoCita medicoCita;
	private MedicoDTO medicoDTO;
	private CrearMedico crearMedico;
	private RemoveMedicoSuplente removeMedicoSuplente;
	private JPanel panelcambiar;
	
	
	
	
	public PanelAsignarCitasVacaciones(JPanel panelAnterior, JPanel panelContenido , VacacionesSolicitadasMedico v, JPanel panelCambiar) {
		
		this.panelcambiar = panelCambiar;
		this.panelAnterior=panelAnterior;
		this.vacaciones = v;
		this.panelContenido = panelContenido;
		estePanel=this;
		setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 1129, 545);
		setLayout(null);
		add(getBtnSeleccionarMedicoTitular());
		add(getBtnSeleccionarMedicoSuplente());
		add(getBtnAsignarCita());
		add(getBtnCancelarCita());
		add(getBtnEliminarCitaSeleccionada());
		add(getBtnSeleccionarCita());
		add(getScrollPane_3());
		add(getScrollPaneCitasMedicoAnterior());
		add(getScrollPane());
		add(getScrollPane_1());
		add(getLblNewLabel());
		add(getLblListaDeMedicos());
		add(getLblListaDeMedicos_2());
		add(getLblListaDeMedicos_2_1());
	
	}
	
	

	private JScrollPane getScrollPaneCitasMedicoAnterior() {
			if (scrollPaneCitasMedicoAnterior == null) {
			scrollPaneCitasMedicoAnterior = new JScrollPane();
			scrollPaneCitasMedicoAnterior.setBounds(39, 51, 412, 423);
			scrollPaneCitasMedicoAnterior.setViewportView(getListCitasMedicoAnterior());
			}
		
		return scrollPaneCitasMedicoAnterior;
	}
	private JList getListCitasMedicoAnterior() {
		
			if(listCitasMedicoAnterior==null) {
			modeloCitasAAsignar = new DefaultListModel<Cita>();
			llenarListaCitas();
			listCitasMedicoAnterior = new JListFiltroPanelCitaAsignarCitasVacaciones(modeloCitasAAsignar);
			this.add(listCitasMedicoAnterior.gettextoFiltro());
			listCitasMedicoAnterior.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			}
		
		return listCitasMedicoAnterior;
	}
	private void llenarListaCitas() {
	
		findCitas = new FindAllCitas();
		
		for(CitaDTO c : findCitas.FindCitaIdMedico(vacaciones.getIdMedico())) {
			
					System.out.println(findCitas.FindCitaIdMedico(vacaciones.getIdMedico()).size());
					
					System.out.println(c.idCita);
		
					if(vacaciones.getFechaInicio().before(c.fecha) || vacaciones.getFechaInicio().equals(c.fecha) || vacaciones.getFechaFin().equals(c.fecha) ) {
						if(vacaciones.getFechaFin().after(c.fecha)) {
							cita = new Cita(c);
							modeloCitasAAsignar.addElement(cita);
						}
					}	
				}
		
	}



	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(507, 51, 294, 167);
			scrollPane.setViewportView(getListMedicosActivos());
		}
		return scrollPane;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(507, 286, 294, 185);
			scrollPane_1.setViewportView(getListMedicosSuplentes());
		}
		return scrollPane_1;
	}

	private JButton getBtnSeleccionarMedicoTitular() {
		if (btnSeleccionarMedicoTitular == null) {
			btnSeleccionarMedicoTitular = new JButton("Comprobar disponibilidad Medico activo");
			btnSeleccionarMedicoTitular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					findCitas = new FindAllCitas();
					findJornadaMedico = new FindAllJornadasMedico();
					boolean disponibilidad = false;
					boolean diaCorrecto = false;
					boolean citaVacia = true;

					if (!modeloCitasAsignadas.isEmpty()) {
						citaVacia = false;

						for (Object o : listMedicosActivos.getSelectedValuesList()) {
							Medico m = (Medico) o;

							for (int i = 0; i < modeloCitasAsignadas.getSize(); i++) {

								for (JornadaMedicoDTO j : findJornadaMedico.FindIdMedico(m.getIdMedico())) {
									System.out.println(findJornadaMedico.FindIdMedico(m.getIdMedico()).size());
									if (j.diaInicio.before(modeloCitasAsignadas.getElementAt(i).getDate())) {
										if (j.diaFin.after(modeloCitasAsignadas.getElementAt(i).getDate())) {
											diaCorrecto = true;
										}

									}
								}

								for (CitaDTO c : findCitas.FindCitaIdMedico(m.getIdMedico())) {
									if (diaCorrecto) {
										System.out.println(modeloCitasAsignadas.getElementAt(i).getDate());
										if (!c.fecha.equals(modeloCitasAsignadas.getElementAt(i).getDate())) {

											disponibilidad = true;

										} else {
											JOptionPane.showMessageDialog(getBtnSeleccionarMedicoSuplente(),
													"El medico ya tiene citas ese dia");
											getBtnAsignarCita().setEnabled(false);
										}
									}

								}
							}
							
						}
					
					}
					

					if (!citaVacia) {

						if (disponibilidad) {
							JOptionPane.showMessageDialog(getBtnSeleccionarMedicoSuplente(),
									"Al medico se le puede asignar la cita ese dia");
							getBtnAsignarCita().setEnabled(true);
						} else {
							JOptionPane.showMessageDialog(getBtnSeleccionarMedicoSuplente(),
									"Estas intentando asignarle esa cita a un medico fuera de su jornada laboral");
							getBtnAsignarCita().setEnabled(false);
						}

					}
					else
					{
						JOptionPane.showMessageDialog(getBtnSeleccionarMedicoSuplente(), "Elige la cita que quieres asignar primero");
					}
					
					
					
					
					

				}
			});
			btnSeleccionarMedicoTitular.setBounds(507, 217, 294, 28);
		}
		return btnSeleccionarMedicoTitular;
	}
	private JButton getBtnSeleccionarMedicoSuplente() {
		if (btnSeleccionarMedicoSuplente == null) {
			btnSeleccionarMedicoSuplente = new JButton("Comprobar disponibilidad medico suplente");
			btnSeleccionarMedicoSuplente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (!modeloCitasAsignadas.isEmpty()) {
					JOptionPane.showMessageDialog(getBtnSeleccionarMedicoSuplente(), "El medico suplente esta disponible");
					getBtnAsignarCita().setEnabled(true);
					}
					else {
						JOptionPane.showMessageDialog(getBtnSeleccionarMedicoSuplente(), "Elige la cita que quieres asignar primero");
					}
				}
			});
			btnSeleccionarMedicoSuplente.setBounds(507, 470, 294, 28);
		}
		return btnSeleccionarMedicoSuplente;
	}
	
	
	private JButton getBtnAsignarCita() {
		if (btnAsignarCita == null) {
			btnAsignarCita = new JButton("Asignar Cita");
			btnAsignarCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					boolean medicoSeleccioando = false;
					boolean medicoSustitutosSeleccioando = false;

					
					editarMedicoCitas = new EditarMedicoCitas();
					
					if(listMedicosActivos.getSelectedValuesList().size()>0) {
						
						medicoSeleccioando = true;
					}
					
					if(listMedicosSuplentes.getSelectedValuesList().size()>0) {
						
						medicoSustitutosSeleccioando = true;
					}
					
					if(!medicoSeleccioando && !medicoSustitutosSeleccioando) {
						
						JOptionPane.showMessageDialog(getBtnAsignarCita(), "No has seleccionada ningun medico");
						
					}
					
					if(medicoSeleccioando && medicoSustitutosSeleccioando) {
						
						JOptionPane.showMessageDialog(getBtnAsignarCita(), "has seleccionado dos medicos, selecciona solo uno");
						
					}
					
					if(medicoSeleccioando && !medicoSustitutosSeleccioando){
						
						editarMedicoCitas = new EditarMedicoCitas();
						Medico medico = (Medico) listMedicosActivos.getSelectedValuesList().get(0);
						for(int i=0; i< modeloCitasAsignadas.size();i++) {
							
							editarMedicoCitas.AsignarCitaAOtroMedico(medico.getIdMedico() , modeloCitasAsignadas.getElementAt(i).getIdCita(), vacaciones.getIdMedico());
							JOptionPane.showMessageDialog(getBtnAsignarCita(), "Cita/s otorgadas con exito");
							
							PanelAsignarCitasVacaciones panel = new PanelAsignarCitasVacaciones(estePanel, panelContenido, vacaciones, panelcambiar);
							panelContenido.add(panel);
							estePanel.setVisible(false);
							panel.setVisible(true);
		
						}
						
						
					}
					
					if(medicoSustitutosSeleccioando && !medicoSeleccioando) {
						
						MedicoSustituto medicoSuplente = (MedicoSustituto) listMedicosSuplentes.getSelectedValuesList().get(0);
						medicoDTO = new MedicoDTO();
						medicoDTO.idMedico = generadorDeIdMedico();
						medicoDTO.nombre = medicoSuplente.getNombreMedico();
						medicoDTO.apellidos = medicoSuplente.getApellidosMedico();
						medicoDTO.email = medicoSuplente.getEmailMedico();
						medicoDTO.especialidad = "NINGUNA";
						medicoDTO.idEquipoMedico = 7000;
						
						
						editarMedicoCitas = new EditarMedicoCitas();
						
						Medico medico = new Medico(medicoDTO);
						
						crearMedico = new CrearMedico();
						crearMedico.crearMedico(medico);
						
						removeMedicoSuplente = new RemoveMedicoSuplente();
						removeMedicoSuplente.borrarSustituto(medicoSuplente.getIdMedico());
						
						for(int i=0; i< modeloCitasAsignadas.size();i++) {
							
							editarMedicoCitas.AsignarCitaAOtroMedico(medico.getIdMedico() , modeloCitasAsignadas.getElementAt(i).getIdCita(), vacaciones.getIdMedico());
							JOptionPane.showMessageDialog(getBtnAsignarCita(), "Cita/s otorgadas con exito");
							
							System.out.println(modeloCitasAAsignar.getSize());
							modeloCitasAAsignar.removeAllElements();
							System.out.println(modeloCitasAAsignar.getSize());
							PanelAsignarCitasVacaciones panel = new PanelAsignarCitasVacaciones(estePanel, panelContenido, vacaciones, panelcambiar);
							panelContenido.add(panel);
							estePanel.setVisible(false);
							panel.setVisible(true);
	
						}
						
						
						
					}
				}

			});
			btnAsignarCita.setEnabled(false);
			btnAsignarCita.setForeground(new Color(0, 128, 0));
			btnAsignarCita.setBounds(850, 462, 111, 36);
		}
		return btnAsignarCita;
	}
	
	private int generadorDeIdMedico() {
		
		ListaMedicos lm = new ListaMedicos();
		lm.creaListaMedicos();
		return 1000 + lm.getMedicos().size();
	}
	
	private JButton getBtnCancelarCita() {
		if (btnCancelarCita == null) {
			btnCancelarCita = new JButton("Cancelar");
			btnCancelarCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PanelTratarSolicitudesVacaciones panel = new PanelTratarSolicitudesVacaciones(estePanel, vacaciones,panelcambiar,panelContenido);
					panelContenido.add(panel);
					estePanel.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnCancelarCita.setForeground(new Color(255, 0, 0));
			btnCancelarCita.setBounds(980, 462, 111, 36);
		}
		return btnCancelarCita;
	}
	
	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}
	private JScrollPane getScrollPane_3() {
		if (scrollPane_3 == null) {
			scrollPane_3 = new JScrollPane();
			scrollPane_3.setBounds(856, 170, 235, 140);
			scrollPane_3.setViewportView(getListCitaAReasignar());
		}
		return scrollPane_3;
	}
	private JButton getBtnEliminarCitaSeleccionada() {
		if (btnEliminarCitaSeleccionada == null) {
			btnEliminarCitaSeleccionada = new JButton("Eliminar cita/s seleccionada");
			btnEliminarCitaSeleccionada.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					modeloCitasAsignadas.removeAllElements();
					
				}
			});
			btnEliminarCitaSeleccionada.setBounds(856, 310, 235, 23);
		}
		return btnEliminarCitaSeleccionada;
	}
	private JButton getBtnSeleccionarCita() {
		if (btnSeleccionarCita == null) {
			btnSeleccionarCita = new JButton("Seleccionar Cita/s");
			btnSeleccionarCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					for(Object o :listCitasMedicoAnterior.getSelectedValuesList()) {
						if(modeloCitasAsignadas.getSize()<1) {
							if(!modeloCitasAsignadas.contains(o)) {
								modeloCitasAsignadas.addElement((Cita) o);
							}
						}
						
						
					}
				}
			});
			btnSeleccionarCita.setBounds(39, 470, 412, 28);
		}
		return btnSeleccionarCita;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Citas afectadas por las vacaciones :");
			lblNewLabel.setBounds(39, 11, 200, 19);
		}
		return lblNewLabel;
	}
	private JLabel getLblListaDeMedicos() {
		if (lblListaDeMedicos == null) {
			lblListaDeMedicos = new JLabel("Lista de medicos en activo:");
			lblListaDeMedicos.setBounds(507, 11, 200, 19);
		}
		return lblListaDeMedicos;
	}
	private JLabel getLblListaDeMedicos_2() {
		if (lblListaDeMedicos_2 == null) {
			lblListaDeMedicos_2 = new JLabel("Lista de medicos sustitutos:");
			lblListaDeMedicos_2.setBounds(507, 249, 200, 14);
		}
		return lblListaDeMedicos_2;
	}
	private JLabel getLblListaDeMedicos_2_1() {
		if (lblListaDeMedicos_2_1 == null) {
			lblListaDeMedicos_2_1 = new JLabel("Cita a reasignar :");
			lblListaDeMedicos_2_1.setBounds(856, 152, 200, 14);
		}
		return lblListaDeMedicos_2_1;
	}
	private JList getListMedicosActivos() {
		if (listMedicosActivos == null) {
			modeloListMedicos = new DefaultListModel<Medico>();
			añadirMedicos();
			listMedicosActivos = new JListFiltroMedicoCitasAsignarVacaciones(modeloListMedicos);
			this.add(listMedicosActivos.gettextoFiltro());
			listMedicosActivos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listMedicosActivos;
	}
	
	private void añadirMedicos() {
		
		lm = new ListaMedicos();
		lm.creaListaMedicos();
		for (Medico m : lm.getMedicos()) {
			if(m.getIdMedico()!=vacaciones.getIdMedico()) {
				modeloListMedicos.addElement(m);
			}
			
		}
		
	}
	
	private void añadirMedicosSuplentes() {
	
		lms = new ListaMedicosSustitutos();
		lms.creaListaMedicos();
		for (MedicoSustituto m : lms.getMedicos()) {
			modeloListMedicosSuplentes.addElement(m);
		}
		
	}




	private JList getListMedicosSuplentes() {
		if (listMedicosSuplentes == null) {
			modeloListMedicosSuplentes = new DefaultListModel<MedicoSustituto>();
			añadirMedicosSuplentes();
			listMedicosSuplentes = new JListFiltroMedicosSustitutosAsignarCitas(modeloListMedicosSuplentes);
			this.add(listMedicosSuplentes.gettextoFiltro());
			listMedicosSuplentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listMedicosSuplentes;
	}
	private JList getListCitaAReasignar() {
		if (listCitaAReasignar == null) {
			modeloCitasAsignadas = new DefaultListModel<Cita>();
			listCitaAReasignar = new JList(modeloCitasAsignadas);
			listCitaAReasignar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listCitaAReasignar;
	}
	
	
}
