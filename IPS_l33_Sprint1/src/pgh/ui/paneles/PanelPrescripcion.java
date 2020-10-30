package pgh.ui.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


import com.toedter.calendar.JDateChooser;

import pgh.business.cita.Cita;
import pgh.business.cita.CitaDTO;
import pgh.business.cita.FindAllCitas;
import pgh.business.cita.ListaCitas;
import pgh.business.enfermero.ListaEnfermeros;
import pgh.business.jornadaenfermero.CrearJornadaEnfermero;
import pgh.business.medicamento.CrearMedicamento;
import pgh.business.medicamento.ListaMedicamentos;
import pgh.business.medicamento.Medicamento;
import pgh.business.medicamento.MedicamentoDTO;
import pgh.business.medico.ListaMedicos;
import pgh.business.medico.Medico;
import pgh.business.medicocita.ListaMedicoCita;
import pgh.business.paciente.ListaPacientes;
import pgh.business.paciente.Paciente;
import pgh.business.prescripcion.CrearPrescripcion;
import pgh.business.prescripcion.ListaPrescripciones;
import pgh.business.prescripcion.Prescripcion;
import pgh.business.prescripcion.PrescripcionDTO;
import pgh.business.prescripcioncitapaciente.CrearPrescripcionCitaPaciente;
import pgh.business.prescripcioncitapaciente.PrescripcionCitaPaciente;
import pgh.business.prescripcioncitapaciente.PrescripcionCitaPacienteDTO;
import pgh.ui.VentanaPrincipal;

public class PanelPrescripcion extends JPanel {
	
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private ListaPacientes lp;
	private ListaMedicoCita listaMedicoCita;
	private JScrollPane scrollPane_6;
	private JTextArea textAreaMedicinaInformacion;
	private JLabel lblNewLabel_13;
	private JScrollPane scrollPane_7;
	private JList listpacienteSeleccionadoPrescripcion;
	private DefaultListModel<Paciente> modeloListaPacienteSeleccionadoPrescripcion;
	private DefaultListModel<Cita> modelListaCitasMedicoPaciente;
	private ListaMedicamentos listaMedicamentos;
	private int id_paciente;
	private ListaCitas listaCitas;
	private FindAllCitas findAllCitas;
	private JButton btnEliminarPacientePrescripcion;
	private JLabel lblNewLabel_17;
	private DefaultListModel<Prescripcion> modeloListPrescripciones;
	private JPanel panelPrescripcion;
	private JButton btnAnadirNuevaPrescripcion;
	private JScrollPane scrollPanePrescripciones;
	private JButton btnAnadirPrescripcion;
	private JScrollPane scrollPanePrescripcionSeleccionada;
	private JButton btnBorrarPrescripcion;
	private JList listPrescripciones;
	private JList listPrescripcionSeleccionada;
	private JButton btnAsignarPrescripcion;
	private JButton btnCancelarPrescripcion;
	private ListaPrescripciones listaPrescripciones;
	private DefaultListModel<Prescripcion> modeloListPrescripcionesSeleccionada;
	private JList listPacientesPrescripcion;
	private DefaultListModel<Paciente> modeloListaPacientesPrescripcion;
	private int id_medico;
	private int id_prescripcion;
	
	
	
	public PanelPrescripcion (JPanel panelAnterior, int id_medico, JPanel panelContenido) {
		
		this.panelAnterior = panelAnterior;
		this.panelContenido = panelContenido;
		panelPrescripcion = this;
		this.id_medico = id_medico;
		getPanelPrescripcion();
		
	}
	
	private void getPanelPrescripcion() {
		
			this.setBackground(new Color(135, 206, 235));
			this.setLayout(null);
			this.add(getBtnAnadirNuevaPrescripcion());
			this.add(getScrollPanePrescripciones());
			this.add(getScrollPanePrescripcionSeleccionada());
			this.add(getBtnBorrarPrescripcion());
			this.add(getBtnAsignarPrescripcion());
			this.add(getBtnCancelarPrescripcion());

			JButton btnNewButton_2 = new JButton("Seleccionar Paciente");
			btnNewButton_2.setForeground(new Color(0, 128, 0));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					for(Object o : listPacientesPrescripcion.getSelectedValuesList()) {
						if(!modeloListaPacienteSeleccionadoPrescripcion.contains(o)) {
							if(modeloListaPacienteSeleccionadoPrescripcion.getSize()<1) {
								modeloListaPacienteSeleccionadoPrescripcion.addElement((Paciente) o);
							}
						}
					}
					
				}
			});
			btnNewButton_2.setBounds(418, 351, 224, 47);
			this.add(btnNewButton_2);

			JScrollPane scrollPanePaciente = new JScrollPane();
			scrollPanePaciente.setBounds(40, 329, 328, 101);
			this.add(scrollPanePaciente);
			scrollPanePaciente.setViewportView(getListPacientesPrescripcion());
			this.add(getScrollPane_6());
			this.add(getLblNewLabel_13());
			this.add(getScrollPane_7());
			this.add(getBtnAnadirPrescripcion());
			this.add(getBtnEliminarPacientePrescripcion());
			this.add(getLblNewLabel_17());
		
		
	}
	
	private JLabel getLblNewLabel_17() {
		if (lblNewLabel_17 == null) {
			lblNewLabel_17 = new JLabel("");
			lblNewLabel_17.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/f1d0807f8ffad0197757d840bdc97d0b-icono-de-registro-medico-by-vexels.png")));
			lblNewLabel_17.setBounds(313, 0, 800, 561);
		}
		return lblNewLabel_17;
	}
	
	private JButton getBtnEliminarPacientePrescripcion() {
		if (btnEliminarPacientePrescripcion == null) {
			btnEliminarPacientePrescripcion = new JButton("Eliminar paciente");
			btnEliminarPacientePrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListaPacienteSeleccionadoPrescripcion.removeAllElements();
				}
			});
			btnEliminarPacientePrescripcion.setForeground(new Color(255, 0, 0));
			btnEliminarPacientePrescripcion.setBounds(779, 432, 190, 40);
		}
		return btnEliminarPacientePrescripcion;
	}
	
	private JScrollPane getScrollPane_6() {
		if (scrollPane_6 == null) {
			scrollPane_6 = new JScrollPane();
			scrollPane_6.setBounds(714, 211, 328, 84);
			scrollPane_6.setViewportView(getTextAreaMedicinaInformacion());
		}
		return scrollPane_6;
	}
	
	private JTextArea getTextAreaMedicinaInformacion() {
		if (textAreaMedicinaInformacion == null) {
			textAreaMedicinaInformacion = new JTextArea();
			
		}
		return textAreaMedicinaInformacion;
	}
	
	private JButton getBtnAnadirNuevaPrescripcion() {
		if (btnAnadirNuevaPrescripcion == null) {
			btnAnadirNuevaPrescripcion = new JButton("A\u00F1adir nueva prescripcion");
			btnAnadirNuevaPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					PanelCrearPrescripcion panel = new PanelCrearPrescripcion(panelPrescripcion, panelContenido, id_medico);
					panelPrescripcion .setVisible(false);
					panelContenido.add(panel);
					panelContenido.remove(panelPrescripcion);
					panel.setVisible(true);
				}
			});
			btnAnadirNuevaPrescripcion.setBounds(92, 202, 224, 40);
		}
		return btnAnadirNuevaPrescripcion;
	}

	private JScrollPane getScrollPanePrescripciones() {
		if (scrollPanePrescripciones == null) {
			scrollPanePrescripciones = new JScrollPane();
			scrollPanePrescripciones.setBounds(40, 11, 328, 162);
			scrollPanePrescripciones.setViewportView(getListPrescripciones());
		}
		return scrollPanePrescripciones;
	}

	private JButton getBtnAnadirPrescripcion() {
		if (btnAnadirPrescripcion == null) {
			btnAnadirPrescripcion = new JButton("A\u00F1adir Prescripcion se\u00F1alizada");
			btnAnadirPrescripcion.setForeground(new Color(0, 128, 0));
			btnAnadirPrescripcion.setBounds(430, 32, 212, 47);
			btnAnadirPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					for (Object o : listPrescripciones.getSelectedValuesList()) {
						if (!modeloListPrescripcionesSeleccionada.contains(o)) {
							if (modeloListPrescripcionesSeleccionada.getSize() < 1) {
								modeloListPrescripcionesSeleccionada.addElement((Prescripcion) o);
							}
						}
					}
					
					listaMedicamentos = new ListaMedicamentos();
					listaMedicamentos.creaListaMedicamentos();
					if(modeloListPrescripcionesSeleccionada.getElementAt(0).esMedicamento()) {
						for(Medicamento m :listaMedicamentos.getMedicamentos()) {
							if(m.getIdPrescripcion()==modeloListPrescripcionesSeleccionada.getElementAt(0).getIdPrescripcion())
							textAreaMedicinaInformacion.setText("Informacion del medicamento : " + m.toString() );
						}
					}
					else {
						textAreaMedicinaInformacion.setText("No se trata de un medicamento");
					}

				}
			});
		}
		return btnAnadirPrescripcion;
	}

	private JScrollPane getScrollPanePrescripcionSeleccionada() {
		if (scrollPanePrescripcionSeleccionada == null) {
			scrollPanePrescripcionSeleccionada = new JScrollPane();
			scrollPanePrescripcionSeleccionada.setBounds(714, 11, 328, 103);
			scrollPanePrescripcionSeleccionada.setViewportView(getListPrescripcionSeleccionada());
		}
		return scrollPanePrescripcionSeleccionada;
	}

	private JButton getBtnBorrarPrescripcion() {
		if (btnBorrarPrescripcion == null) {
			btnBorrarPrescripcion = new JButton("Eliminar prescripcion");
			btnBorrarPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					modeloListPrescripcionesSeleccionada.removeAllElements();
					textAreaMedicinaInformacion.setText("");
				}
			});
			btnBorrarPrescripcion.setForeground(Color.RED);
			btnBorrarPrescripcion.setBounds(779, 135, 190, 40);
		}
		return btnBorrarPrescripcion;
	}

	private JList getListPrescripciones() {
		if (listPrescripciones == null) {
			modeloListPrescripciones = new DefaultListModel();
			listPrescripciones = new JList(modeloListPrescripciones);
			listPrescripciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			mostrarPrescripciones();
		}
		return listPrescripciones;
	}

	private void mostrarPrescripciones() {

		listaPrescripciones = new ListaPrescripciones();

		listaPrescripciones.creaListaPrescripciones();

		for (Prescripcion p : listaPrescripciones.getPrescripciones()) {

			modeloListPrescripciones.addElement(p);

		}

	}

	private JList getListPrescripcionSeleccionada() {
		if (listPrescripcionSeleccionada == null) {
			modeloListPrescripcionesSeleccionada = new DefaultListModel();
			listPrescripcionSeleccionada = new JList(modeloListPrescripcionesSeleccionada);
		}
		return listPrescripcionSeleccionada;
	}
	

	private JButton getBtnAsignarPrescripcion() {
		if (btnAsignarPrescripcion == null) {
			btnAsignarPrescripcion = new JButton("Asignar Prescripcion");
			btnAsignarPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					id_paciente = modeloListaPacienteSeleccionadoPrescripcion.getElementAt(0).getIdPaciente();
					id_prescripcion = modeloListPrescripcionesSeleccionada.getElementAt(0).getIdPrescripcion();
					modelListaCitasMedicoPaciente = new DefaultListModel();
					
					findAllCitas = new FindAllCitas();
					listaCitas = new ListaCitas();
					listaCitas.creaCitas();
					listaMedicoCita= new ListaMedicoCita();
					listaMedicoCita.creaListaMedicoCitas();
					
					
					List<CitaDTO> filtroCitas= new ArrayList<CitaDTO>();
					filtroCitas = findAllCitas.FindIdCita(id_medico, id_paciente);
					
					List<Cita> citas = new ArrayList<Cita>();	
					
					
					for(CitaDTO c : filtroCitas) {
						Cita cita = new Cita(c);
						citas.add(cita);
					}
					
					if(citas.size()==0) {
						JOptionPane.showMessageDialog(getBtnAsignarPrescripcion(), "El paciente no tiene ni ha tenido ninguna cita con usted");
					}
					else {
						
					for(Cita c: citas ) {
						
						modelListaCitasMedicoPaciente.addElement(c);
					}
					
					PanelElegirCita pec = new PanelElegirCita(panelPrescripcion, modelListaCitasMedicoPaciente);
					panelContenido.add(pec);
					panelPrescripcion.setVisible(false);
					pec.setVisible(true);
					
					}
					}
				
			});
			btnAsignarPrescripcion.setForeground(new Color(0, 128, 0));
			btnAsignarPrescripcion.setBounds(714, 509, 167, 41);
		}
		return btnAsignarPrescripcion;
	}

	private JButton getBtnCancelarPrescripcion() {
		if (btnCancelarPrescripcion == null) {
			btnCancelarPrescripcion = new JButton("Cancelar");
			btnCancelarPrescripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListPrescripcionesSeleccionada.removeAllElements();
					textAreaMedicinaInformacion.setText("");
					closePanel();
				}
			});
			btnCancelarPrescripcion.setForeground(Color.RED);
			btnCancelarPrescripcion.setBounds(905, 509, 156, 41);
		}
		return btnCancelarPrescripcion;
	}
	
	private JList getListPacientesPrescripcion() {
		if (listPacientesPrescripcion == null) {
			modeloListaPacientesPrescripcion = new DefaultListModel();
			listPacientesPrescripcion = new JList(modeloListaPacientesPrescripcion);
			listPacientesPrescripcion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lp = new ListaPacientes();
			lp.creaListaPacientes();

			for (Paciente p : lp.getPacientes()) {

				modeloListaPacientesPrescripcion.addElement(p);
			}

		}
		return listPacientesPrescripcion;
	}
	
	private JList getListpacienteSeleccionadoPrescripcion() {
		if (listpacienteSeleccionadoPrescripcion == null) {
			modeloListaPacienteSeleccionadoPrescripcion = new DefaultListModel();
			listpacienteSeleccionadoPrescripcion = new JList(modeloListaPacienteSeleccionadoPrescripcion);
		}
		return listpacienteSeleccionadoPrescripcion;
	}
	
	private JLabel getLblNewLabel_13() {
		if (lblNewLabel_13 == null) {
			lblNewLabel_13 = new JLabel("Informacion si la prescripcion se trata de un medicamento ");
			lblNewLabel_13.setBounds(714, 186, 389, 14);
		}
		return lblNewLabel_13;
	}
	private JScrollPane getScrollPane_7() {
		if (scrollPane_7 == null) {
			scrollPane_7 = new JScrollPane();
			scrollPane_7.setBounds(714, 329, 328, 92);
			scrollPane_7.setViewportView(getListpacienteSeleccionadoPrescripcion());
		}
		return scrollPane_7;
	}
	
	
	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}
	
	
	
	

	

	

	

}
