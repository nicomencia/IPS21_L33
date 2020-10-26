package pgh.ui.paneles;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import pgh.business.cita.Cita;
import pgh.business.prescripcioncitapaciente.CrearPrescripcionCitaPaciente;
import pgh.business.prescripcioncitapaciente.PrescripcionCitaPaciente;
import pgh.business.prescripcioncitapaciente.PrescripcionCitaPacienteDTO;
import pgh.ui.VentanaPrincipal;

public class PanelElegirCita extends JPanel {
	
	private JList listCitasMedicoPacienteAFC;
	private JList listCitaElegidaAFC;
	private JLabel lblNewLabelElegirCitaAFC;
	private JButton btnEliminarCitaElegidaAFC;
	private JButton btnTerminarProcesoAFC;
	private JButton btnCancelarProcesoAFC;
	private DefaultListModel<Cita> modelListaCitasMedicoPaciente;
	private DefaultListModel<Cita> modelListaCitasMedicoPacienteAnterior;
	private DefaultListModel<Cita> modelListaCitaMedicoPacienteElegida;
	private CrearPrescripcionCitaPaciente crearPrescripcionCitaPaciente;
	private PrescripcionCitaPacienteDTO prescripcionCitaPacienteDTO;
	private int id_paciente;
	private int id_prescripcion;	
	private PrescripcionCitaPaciente prescripcionCitaPaciente;
	private JPanel panelAnterior;
	
	public PanelElegirCita(JPanel panelAnterior, DefaultListModel<Cita> modelListaCitasMedicoPaciente) {
		this.panelAnterior = panelAnterior;
		this.modelListaCitasMedicoPacienteAnterior= modelListaCitasMedicoPaciente;
		setBackground(new Color(135, 206, 235));
		setLayout(null);
		
		JScrollPane scrollPane_2AFC = new JScrollPane();
		scrollPane_2AFC.setBounds(39, 47, 351, 395);
		this.add(scrollPane_2AFC);
		scrollPane_2AFC.setViewportView(getListCitasMedicoPacienteAFC());

		JScrollPane scrollPane_3AFC = new JScrollPane();
		scrollPane_3AFC.setBounds(806, 179, 276, 173);
		this.add(scrollPane_3AFC);
		scrollPane_3AFC.setViewportView(getListCitaElegidaAFC());
		
		JButton btnElegirCitaAFC = new JButton("Elegir Cita");
		btnElegirCitaAFC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(Object o: listCitasMedicoPacienteAFC.getSelectedValuesList()) {
					
					if(!modelListaCitaMedicoPacienteElegida.contains(o)) {
						modelListaCitaMedicoPacienteElegida.addElement((Cita) o);
					}
					
				}
				

				
			}
		});
		btnElegirCitaAFC.setBounds(135, 470, 160, 54);
		this.add(btnElegirCitaAFC);
		this.add(getBtnEliminarCitaElegidaAFC());
		this.add(getBtnTerminarProcesoAFC());
		this.add(getBtnCancelarProcesoAFC());
		this.add(getLblNewLabelElegirCitaAFC());
	}
	
	
	private JButton getBtnEliminarCitaElegidaAFC() {
		if (btnEliminarCitaElegidaAFC == null) {
			btnEliminarCitaElegidaAFC = new JButton("Eliminar Cita Elegida");
			btnEliminarCitaElegidaAFC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modelListaCitaMedicoPacienteElegida.removeAllElements();
				}
			});
			btnEliminarCitaElegidaAFC.setForeground(new Color(255, 0, 0));
			btnEliminarCitaElegidaAFC.setBounds(879, 382, 127, 23);
		}
		return btnEliminarCitaElegidaAFC;
	}
	
	private JButton getBtnTerminarProcesoAFC() {
		if (btnTerminarProcesoAFC == null) {
			btnTerminarProcesoAFC = new JButton("Terminar Proceso");
			btnTerminarProcesoAFC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					crearPrescripcionCitaPaciente = new CrearPrescripcionCitaPaciente();
					
					prescripcionCitaPacienteDTO = new PrescripcionCitaPacienteDTO();
					
				
					for(int i=0;i<modelListaCitaMedicoPacienteElegida.getSize();i++) {
						prescripcionCitaPacienteDTO.idCita=modelListaCitaMedicoPacienteElegida.getElementAt(i).getIdCita();
						prescripcionCitaPacienteDTO.idPaciente=id_paciente;
						prescripcionCitaPacienteDTO.idPrescripcion=id_prescripcion;
						
						prescripcionCitaPaciente = new PrescripcionCitaPaciente(prescripcionCitaPacienteDTO);
						crearPrescripcionCitaPaciente.crearCita(prescripcionCitaPaciente); 
					}
					
					//cambiarPanelMedico
					
				}
			});
			btnTerminarProcesoAFC.setForeground(new Color(0, 128, 0));
			btnTerminarProcesoAFC.setBounds(778, 508, 136, 42);
		}
		return btnTerminarProcesoAFC;
	}

	private JButton getBtnCancelarProcesoAFC() {
		if (btnCancelarProcesoAFC == null) {
			btnCancelarProcesoAFC = new JButton("CancelarProceso");
			btnCancelarProcesoAFC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					modelListaCitaMedicoPacienteElegida.removeAllElements();
					modelListaCitasMedicoPaciente.removeAllElements();
					closePanel();
					//cambiarPanel("panelPrescripcion");
				}
			});
			btnCancelarProcesoAFC.setForeground(new Color(255, 0, 0));
			btnCancelarProcesoAFC.setBounds(939, 508, 143, 42);
		}
		return btnCancelarProcesoAFC;
	}
	
	private JList getListCitasMedicoPacienteAFC() {
		if (listCitasMedicoPacienteAFC == null) {
			modelListaCitasMedicoPaciente= new DefaultListModel();
			modelListaCitasMedicoPaciente = modelListaCitasMedicoPacienteAnterior;
			listCitasMedicoPacienteAFC = new JList(modelListaCitasMedicoPaciente);
			
			
		}
		return listCitasMedicoPacienteAFC;
	}
	private JList getListCitaElegidaAFC() {
		if (listCitaElegidaAFC == null) {
			modelListaCitaMedicoPacienteElegida = new DefaultListModel();
			listCitaElegidaAFC = new JList(modelListaCitaMedicoPacienteElegida);
		}
		return listCitaElegidaAFC;
	}
	
	private JLabel getLblNewLabelElegirCitaAFC() {
		if (lblNewLabelElegirCitaAFC == null) {
			lblNewLabelElegirCitaAFC = new JLabel("");
			lblNewLabelElegirCitaAFC.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/f1d0807f8ffad0197757d840bdc97d0b-icono-de-registro-medico-by-vexels.png")));
			lblNewLabelElegirCitaAFC.setBounds(326, 0, 742, 550);
		}
		return lblNewLabelElegirCitaAFC;
	}
	
	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}


	

}

