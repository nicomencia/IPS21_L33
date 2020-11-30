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
import pgh.business.prescripcioncitapaciente.ListaPrescripcionesCitaPaciente;
import pgh.business.prescripcioncitapaciente.PrescripcionCitaPaciente;
import pgh.business.prescripcioncitapaciente.PrescripcionCitaPacienteDTO;
import pgh.business.registro.CrearRegistro;
import pgh.ui.VentanaPrincipal;
import pgh.ui.paneles.filtros.JListFiltroPrescripcion;

public class PanelPrescripcion extends JPanel {
	
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private ListaPacientes lp;
	private ListaMedicoCita listaMedicoCita;
	private JScrollPane scrollPane_6;
	private JTextArea textAreaMedicinaInformacion;
	private JLabel lblNewLabel_13;
	private DefaultListModel<Paciente> modeloListaPacienteSeleccionadoPrescripcion;
	private DefaultListModel<Cita> modelListaCitasMedicoPaciente;
	private ListaMedicamentos listaMedicamentos;
	private ListaCitas listaCitas;
	private FindAllCitas findAllCitas;
	private JLabel lblNewLabel_5_1;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private DefaultListModel<Prescripcion> modeloListPrescripciones;
	private JButton btnIndicarPrescripcion;
	private JPanel panelPrescripcion;
	private JButton btnAnadirNuevaPrescripcion;
	private JScrollPane scrollPanePrescripciones;
	private JButton btnAnadirPrescripcion;
	private JScrollPane scrollPanePrescripcionSeleccionada;
	private JButton btnBorrarPrescripcion;
	private JListFiltroPrescripcion listPrescripciones;
	private JList listPrescripcionSeleccionada;
	private JButton btnAsignarPrescripcion;
	private JButton btnCancelarPrescripcion;
	private ListaPrescripciones listaPrescripciones;
	private DefaultListModel<Prescripcion> modeloListPrescripcionesSeleccionada;
	private DefaultListModel<Paciente> modeloListaPacientesPrescripcion;
	private PrescripcionCitaPaciente pcp;
	private PrescripcionCitaPacienteDTO pcpDTOs;
	private CrearPrescripcionCitaPaciente cpcp;
	private ListaPrescripcionesCitaPaciente lpcp;
	private int id_medico;
	private int id_prescripcion;
	private int idmedico;
	private PrescripcionCitaPaciente prescripcionCitaPaciente;
	private int id_paciente;
	private int idCita;
	private CrearPrescripcionCitaPaciente crearPrescripcionCitaPaciente;
	private PrescripcionCitaPacienteDTO prescripcionCitaPacienteDTO;
	private JPanel panelCambiar;
	private JTextField textField;
	private int idObservador;
	
	
	public PanelPrescripcion (JPanel panelAnterior, int id_medico, int idPaciente, int idCita, JPanel panelContenido, JPanel PanelMedicoCita, int idObservador) {
		
		this.panelAnterior = panelAnterior;
		this.panelContenido = panelContenido;
		this.idmedico = id_medico;
		this.idCita = idCita;
		this.id_paciente= idPaciente;
		panelPrescripcion = this;
		this.panelCambiar=PanelMedicoCita;
		this.id_medico = id_medico;
		this.idObservador = idObservador;
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
			this.add(getScrollPane_6());
			this.add(getLblNewLabel_13());
			this.add(getBtnAnadirPrescripcion());
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
	
	private JScrollPane getScrollPane_6() {
		if (scrollPane_6 == null) {
			scrollPane_6 = new JScrollPane();
			scrollPane_6.setBounds(714, 301, 328, 84);
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

					PanelCrearPrescripcion panel = new PanelCrearPrescripcion(panelPrescripcion, panelContenido, id_medico, id_paciente, idCita, idObservador);
					panelPrescripcion .setVisible(false);
					panelContenido.add(panel);
					panel.setVisible(true);
				}
			});
			btnAnadirNuevaPrescripcion.setBounds(90, 387, 224, 40);
		}
		return btnAnadirNuevaPrescripcion;
	}

	private JScrollPane getScrollPanePrescripciones() {
		if (scrollPanePrescripciones == null) {
			scrollPanePrescripciones = new JScrollPane();
			scrollPanePrescripciones.setBounds(43, 46, 328, 308);
			scrollPanePrescripciones.setViewportView(getListPrescripciones());
		}
		return scrollPanePrescripciones;
	}

	private JButton getBtnAnadirPrescripcion() {
		if (btnAnadirPrescripcion == null) {
			btnAnadirPrescripcion = new JButton("A\u00F1adir Prescripcion se\u00F1alizada");
			btnAnadirPrescripcion.setForeground(new Color(0, 128, 0));
			btnAnadirPrescripcion.setBounds(439, 186, 212, 47);
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
			scrollPanePrescripcionSeleccionada.setBounds(714, 72, 328, 103);
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
			btnBorrarPrescripcion.setBounds(781, 207, 190, 40);
		}
		return btnBorrarPrescripcion;
	}

	private JList getListPrescripciones() {
		if (listPrescripciones == null) {
			modeloListPrescripciones = new DefaultListModel();
			mostrarPrescripciones();
			listPrescripciones = new JListFiltroPrescripcion(modeloListPrescripciones);
			this.add(listPrescripciones.gettextoFiltro());
			listPrescripciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
					
					id_prescripcion = modeloListPrescripcionesSeleccionada.getElementAt(0).getIdPrescripcion();
					
					crearPrescripcionCitaPaciente = new CrearPrescripcionCitaPaciente();
					
					prescripcionCitaPacienteDTO = new PrescripcionCitaPacienteDTO();
					
				
					
						prescripcionCitaPacienteDTO.idCita= idCita;
						prescripcionCitaPacienteDTO.idPaciente= id_paciente;
						prescripcionCitaPacienteDTO.idPrescripcion= id_prescripcion;
						
						lpcp = new ListaPrescripcionesCitaPaciente();
						lpcp.creaListaPrescripciones();
						
						for(int i = 0 ; i < lpcp.getPrescripciones().size();i++){
							if(lpcp.getPrescripciones().get(i).getIdCita()==prescripcionCitaPacienteDTO.idCita) {
								if(lpcp.getPrescripciones().get(i).getIdPaciente()==prescripcionCitaPacienteDTO.idPaciente) {
									if(lpcp.getPrescripciones().get(i).getIdPrescripcion()==prescripcionCitaPacienteDTO.idPrescripcion) {
										JOptionPane.showMessageDialog(getBtnAsignarPrescripcion(), "Ya esta esta prescripion asignada para esa consulta");
									}
								}
							}
						}
						
						prescripcionCitaPaciente = new PrescripcionCitaPaciente(prescripcionCitaPacienteDTO);
						crearPrescripcionCitaPaciente.crearCita(prescripcionCitaPaciente); 
						
						//Registro
						CrearRegistro registro = new CrearRegistro();
						if (idObservador==0)
							registro.crearRegistro("El administrador asigno una prescripcion al paciente " + registro.getNombrePaciente(id_paciente) + " (" + id_paciente + "), " + modeloListPrescripcionesSeleccionada.getElementAt(0).getInstruccion());
						else 	
							registro.crearRegistro("El medico " + registro.getNombreMedico(idObservador) + " (" + idObservador + ") asigno una prescripcion al paciente " + registro.getNombrePaciente(id_paciente) + " (" + id_paciente + "), " + modeloListPrescripcionesSeleccionada.getElementAt(0).getInstruccion());
						
						
						closePanel();
						
						
						
			
				}
				
			});
			btnAsignarPrescripcion.setForeground(new Color(0, 128, 0));
			btnAsignarPrescripcion.setBounds(715, 466, 167, 41);
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
			btnCancelarPrescripcion.setBounds(892, 466, 156, 41);
		}
		return btnCancelarPrescripcion;
	}
	
	private JLabel getLblNewLabel_13() {
		if (lblNewLabel_13 == null) {
			lblNewLabel_13 = new JLabel("Informacion si la prescripcion se trata de un medicamento ");
			lblNewLabel_13.setBounds(714, 276, 389, 14);
		}
		return lblNewLabel_13;
	}
	
	
	protected void closePanel() {
		panelCambiar.setVisible(true);
		this.setVisible(false);
	}
	
	
	
	

	

	

	

	
}
