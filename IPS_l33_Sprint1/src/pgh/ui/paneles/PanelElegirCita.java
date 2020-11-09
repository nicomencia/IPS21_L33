package pgh.ui.paneles;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import pgh.business.cita.Cita;
import pgh.business.cita.CitaDTO;
import pgh.business.cita.FindAllCitas;
import pgh.business.cita.ListaCitas;
import pgh.business.medico.ListaMedicos;
import pgh.business.prescripcioncitapaciente.CrearPrescripcionCitaPaciente;
import pgh.business.prescripcioncitapaciente.PrescripcionCitaPaciente;
import pgh.business.prescripcioncitapaciente.PrescripcionCitaPacienteDTO;
import pgh.ui.VentanaPrincipal;
import pgh.ui.paneles.filtros.JListFiltroPanelElegirCita;

public class PanelElegirCita extends JPanel {
	
	private JListFiltroPanelElegirCita listCitasMedicoPacienteAFC;
	private JList listCitaElegidaAFC;
	private JLabel lblNewLabelElegirCitaAFC;
	private JButton btnEliminarCitaElegidaAFC;
	private JButton btnTerminarProcesoAFC;
	private JButton btnCancelarProcesoAFC;
	private DefaultListModel<Cita> modelListaCitasMedicoPaciente;
	private DefaultListModel<Cita> modelListaCitaMedicoPacienteElegida;
	private CrearPrescripcionCitaPaciente crearPrescripcionCitaPaciente;
	private PrescripcionCitaPacienteDTO prescripcionCitaPacienteDTO;
	private int id_paciente;
	private int id_prescripcion;	
	private PrescripcionCitaPaciente prescripcionCitaPaciente;
	private JPanel panelAnterior;
	private int id_medico;
	private JPanel panelContenido;
	private FindAllCitas findCitas;
	private Cita cita;
	private CitaDTO citaDTO;
	private ListaCitas lc;
	private List<Cita> citas;
	private JPanel panelElegirCita;
	private int idCita;
	
	public PanelElegirCita(JPanel panelAnterior, JPanel panelContenido, int idmedico, int idPaciente) {
		this.panelAnterior = panelAnterior;
		this.id_paciente = idPaciente;
		this.id_medico = idmedico;
		this.panelContenido = panelContenido;
		panelElegirCita=this;
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
		btnElegirCitaAFC.setBounds(135, 470, 160, 42);
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
			btnEliminarCitaElegidaAFC.setBounds(806, 356, 276, 23);
		}
		return btnEliminarCitaElegidaAFC;
	}
	
	private JButton getBtnTerminarProcesoAFC() {
		if (btnTerminarProcesoAFC == null) {
			btnTerminarProcesoAFC = new JButton("Terminar Proceso");
			btnTerminarProcesoAFC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
//					crearPrescripcionCitaPaciente = new CrearPrescripcionCitaPaciente();
//					
//					prescripcionCitaPacienteDTO = new PrescripcionCitaPacienteDTO();
//					
//				
//					for(int i=0;i<modelListaCitaMedicoPacienteElegida.getSize();i++) {
//						prescripcionCitaPacienteDTO.idCita=modelListaCitaMedicoPacienteElegida.getElementAt(i).getIdCita();
//						prescripcionCitaPacienteDTO.idPaciente=id_paciente;
//						prescripcionCitaPacienteDTO.idPrescripcion=id_prescripcion;
//						
//						prescripcionCitaPaciente = new PrescripcionCitaPaciente(prescripcionCitaPacienteDTO);
//						crearPrescripcionCitaPaciente.crearCita(prescripcionCitaPaciente); 
//					}
					
					for(int i=0;i<modelListaCitaMedicoPacienteElegida.getSize();i++) {
						idCita=modelListaCitaMedicoPacienteElegida.getElementAt(i).getIdCita();
					}
					
					if(modelListaCitaMedicoPacienteElegida.isEmpty()) {
						JOptionPane.showMessageDialog(getBtnTerminarProcesoAFC(), "Tienes que elegir una cita");
					}
					
					else {
						PanelMedicoCita panel = new PanelMedicoCita(panelElegirCita, id_medico, id_paciente, idCita , panelContenido);
						panelContenido.add(panel);
						panel.setVisible(true);
						panelElegirCita.setVisible(false);
					}
					
					
		
					
				}
			});
			btnTerminarProcesoAFC.setForeground(new Color(0, 128, 0));
			btnTerminarProcesoAFC.setBounds(728, 476, 160, 42);
		}
		return btnTerminarProcesoAFC;
	}

	private JButton getBtnCancelarProcesoAFC() {
		if (btnCancelarProcesoAFC == null) {
			btnCancelarProcesoAFC = new JButton("Cancelar Proceso");
			btnCancelarProcesoAFC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					modelListaCitaMedicoPacienteElegida.removeAllElements();
					modelListaCitasMedicoPaciente.removeAllElements();
					closePanel();
					//cambiarPanel("panelPrescripcion");
				}
			});
			btnCancelarProcesoAFC.setForeground(new Color(255, 0, 0));
			btnCancelarProcesoAFC.setBounds(921, 476, 160, 42);
		}
		return btnCancelarProcesoAFC;
	}
	
	private JList getListCitasMedicoPacienteAFC() {
		if (listCitasMedicoPacienteAFC == null) {
			modelListaCitasMedicoPaciente= new DefaultListModel();
			llenarLista();
			listCitasMedicoPacienteAFC = new JListFiltroPanelElegirCita(modelListaCitasMedicoPaciente);
			this.add(listCitasMedicoPacienteAFC.gettextoFiltro());
			
			
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
	
	private void llenarLista() {
		citas = new ArrayList<Cita>();
		findCitas= new FindAllCitas();
		if(findCitas.FindIdCita(id_medico, id_paciente).size()>0) {
			for(int i=0; i < findCitas.FindIdCita(id_medico, id_paciente).size() ; i++) {
				
				citaDTO= findCitas.FindIdCita(id_medico, id_paciente).get(i);
				cita = new Cita(citaDTO);
				citas.add(cita);
			}
		}
		
		for(Cita c : citas) {
			modelListaCitasMedicoPaciente.addElement(c);
		}
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
	
	private Cita findCita(int id)
	{
		for(int i=0; i<citas.size();i++)
		{
			if(citas.get(i).getIdCita() == id)
			{
				return citas.get(i);
			}
		}
		return null;
	}
}

