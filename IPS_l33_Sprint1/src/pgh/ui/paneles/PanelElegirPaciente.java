package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import pgh.business.paciente.ListaPacientes;
import pgh.business.paciente.Paciente;
import pgh.ui.paneles.filtros.JListFiltroElegirPacientes;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelElegirPaciente extends JPanel {
	private JScrollPane scrollPanePacientes;
	private JListFiltroElegirPacientes listPacientes;
	private JButton btnNewButton;
	private JScrollPane scrollPanePacienteSeleccioanado;
	private JList listPacienteSeleccionado;
	private JButton btnEliminarPaciente;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JPanel panelAnterior;
	private int idmedico;
	private JPanel panelContenido;
	private JPanel panelElegirPaciente;
	private DefaultListModel<Paciente> modelPacientes;
	private DefaultListModel<Paciente> modelPacienteSeleccionado;
	private ListaPacientes lp;
	
	
	public PanelElegirPaciente(JPanel panelAnterior, int id_medico, JPanel contenido) {
		
		this.panelAnterior = panelAnterior;
		panelElegirPaciente= this;
		this.panelContenido = contenido;
		this.idmedico = id_medico;
		setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 1129, 600);
		setLayout(null);
		add(getScrollPanePacientes());
		add(getBtnNewButton());
		add(getScrollPanePacienteSeleccioanado());
		add(getBtnEliminarPaciente());
		add(getBtnCancelar());
		add(getBtnAceptar());
	}
	private JScrollPane getScrollPanePacientes() {
		if (scrollPanePacientes == null) {
			scrollPanePacientes = new JScrollPane();
			scrollPanePacientes.setBounds(76, 131, 465, 397);
			scrollPanePacientes.setViewportView(getListPacientes());
		}
		return scrollPanePacientes;
	}
	private JList getListPacientes() {
		if (listPacientes == null) {
			modelPacientes = new DefaultListModel<Paciente>();
			llenarListaPacientes();
			listPacientes = new JListFiltroElegirPacientes(modelPacientes);
			this.add(listPacientes.gettextoFiltro());
			listPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listPacientes;
	}
	
	private void llenarListaPacientes() {
		
		lp = new ListaPacientes();
		lp.creaListaPacientes();

		for (Paciente p : lp.getPacientes()) {

			modelPacientes.addElement(p);
		}
		
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Elegir paciente seleccionado");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					for(Object o : listPacientes.getSelectedValuesList()) {
						if(!modelPacienteSeleccionado.contains(o)) {
							if(modelPacienteSeleccionado.getSize()<1) {
								modelPacienteSeleccionado.addElement((Paciente) o);
							}
						}
					}
					
				}
			});
			btnNewButton.setBounds(574, 284, 207, 41);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPanePacienteSeleccioanado() {
		if (scrollPanePacienteSeleccioanado == null) {
			scrollPanePacienteSeleccioanado = new JScrollPane();
			scrollPanePacienteSeleccioanado.setBounds(800, 210, 282, 198);
			scrollPanePacienteSeleccioanado.setViewportView(getListPacienteSeleccionado());
		}
		return scrollPanePacienteSeleccioanado;
	}
	private JList getListPacienteSeleccionado() {
		if (listPacienteSeleccionado == null) {
			modelPacienteSeleccionado = new DefaultListModel<Paciente>();
			listPacienteSeleccionado = new JList(modelPacienteSeleccionado);
		}
		return listPacienteSeleccionado;
	}
	private JButton getBtnEliminarPaciente() {
		if (btnEliminarPaciente == null) {
			btnEliminarPaciente = new JButton("Eliminar paciente");
			btnEliminarPaciente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					modelPacienteSeleccionado.removeAllElements();
				}
			});
			btnEliminarPaciente.setForeground(new Color(255, 0, 0));
			btnEliminarPaciente.setBounds(800, 425, 282, 31);
		}
		return btnEliminarPaciente;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setForeground(new Color(255, 0, 0));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					closePanel();
				}
			});
			btnCancelar.setBounds(950, 498, 132, 31);
		}
		return btnCancelar;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setForeground(new Color(0, 128, 0));
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int idPaciente = modelPacienteSeleccionado.getElementAt(0).getIdPaciente();
					PanelElegirCita panel = new PanelElegirCita(panelElegirPaciente, panelContenido, idmedico, idPaciente);
					panelContenido.add(panel);
					panelElegirPaciente.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnAceptar.setBounds(800, 498, 132, 31);
		}
		return btnAceptar;
	}
	
	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}

	
	
}
