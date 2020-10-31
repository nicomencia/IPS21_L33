package pgh.ui.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


import pgh.business.medico.ListaMedicos;
import pgh.business.medico.Medico;


public class PanelLoginMedico extends JPanel {
	
	private JPanel panelLoginMedico;
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private ListaMedicos lm;
	private JScrollPane scrollPane_4;
	private DefaultListModel<Medico> modeloListaMedicosLogin;
	private DefaultListModel<Medico> modeloListaMedicosLogueados;
	private int id_medico;
	private JList listMedicosLogin;
	private JButton btnSeleccionarMedicoLogin;
	private JScrollPane scrollPane_5;
	private JList listMedicoLogueado;
	private JButton btnEliminarMedicoLogueado;
	private JButton btnSiguienteLogin;
	private JButton btnCancelar;
	private JButton btnSalirPanelMedico;
	
	public PanelLoginMedico (JPanel panelAnterior) {
		
		this.panelAnterior = panelAnterior;
		getPanelLoginMedico();
		panelLoginMedico=this;
		
	}
	
	private JPanel getPanelLoginMedico() {
		if (panelLoginMedico == null) {
			panelLoginMedico = new JPanel();
			panelLoginMedico.setBackground(Color.WHITE);
			panelLoginMedico.setLayout(null);
			panelLoginMedico.add(getScrollPane_4());
			panelLoginMedico.add(getBtnSeleccionarMedicoLogin());
			panelLoginMedico.add(getScrollPane_5());
			panelLoginMedico.add(getBtnEliminarMedicoLogueado());
			panelLoginMedico.add(getBtnSiguienteLogin());
			panelLoginMedico.add(getBtnCancelar());

		}
		return panelLoginMedico;
	}

	private JScrollPane getScrollPane_4() {
		if (scrollPane_4 == null) {
			scrollPane_4 = new JScrollPane();
			scrollPane_4.setBounds(119, 152, 283, 263);
			scrollPane_4.setViewportView(getListMedicosLogin());

		}
		return scrollPane_4;
	}

	private JList getListMedicosLogin() {
		if (listMedicosLogin == null) {
			modeloListaMedicosLogin = new DefaultListModel();
			listMedicosLogin = new JList(modeloListaMedicosLogin);
			listMedicosLogin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lm = new ListaMedicos();
			lm.creaListaMedicos();
			for (Medico m : lm.getMedicos()) {
				modeloListaMedicosLogin.addElement((Medico) m);
			}

		}
		return listMedicosLogin;
	}

	private JButton getBtnSeleccionarMedicoLogin() {
		if (btnSeleccionarMedicoLogin == null) {
			btnSeleccionarMedicoLogin = new JButton("Seleccionar Medico");
			btnSeleccionarMedicoLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (Object o : listMedicosLogin.getSelectedValuesList()) {
						if (!modeloListaMedicosLogueados.contains(o)) {
							if (modeloListaMedicosLogueados.getSize() < 1) {

								modeloListaMedicosLogueados.addElement((Medico) o);

							}
						}
					}
				}
			});
			btnSeleccionarMedicoLogin.setBounds(462, 249, 166, 39);

		}
		return btnSeleccionarMedicoLogin;
	}

	private JScrollPane getScrollPane_5() {
		if (scrollPane_5 == null) {
			scrollPane_5 = new JScrollPane();
			scrollPane_5.setBounds(678, 167, 338, 184);
			scrollPane_5.setViewportView(getListMedicoLogueado());
		}
		return scrollPane_5;
	}

	private JList getListMedicoLogueado() {
		if (listMedicoLogueado == null) {
			modeloListaMedicosLogueados = new DefaultListModel();
			listMedicoLogueado = new JList(modeloListaMedicosLogueados);
		}
		return listMedicoLogueado;
	}

	private JButton getBtnEliminarMedicoLogueado() {
		if (btnEliminarMedicoLogueado == null) {
			btnEliminarMedicoLogueado = new JButton("Eliminar");
			btnEliminarMedicoLogueado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListaMedicosLogueados.removeAllElements();
				}
			});
			btnEliminarMedicoLogueado.setBounds(807, 373, 89, 23);
		}
		return btnEliminarMedicoLogueado;
	}

	private JButton getBtnSiguienteLogin() {
		if (btnSiguienteLogin == null) {
			btnSiguienteLogin = new JButton("Siguiente");
			btnSiguienteLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					id_medico = modeloListaMedicosLogueados.getElementAt(0).getIdMedico();
					//AQUI NO IR A PRESCRIPCION; IR A ELEGIR CITA Y LUEGO TODO EL PROCESO DE UNA CITA
					PanelPrescripcion panel = new PanelPrescripcion(panelLoginMedico, id_medico, panelContenido);
					panelContenido.add(panel);
					panelLoginMedico.setVisible(false);
					panel.setVisible(true);
//					cambiarPanel("panelMedico");
				}
			});
			btnSiguienteLogin.setBounds(807, 503, 89, 23);
		}
		return btnSiguienteLogin;
	}
	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					cambiarPanel("panelPrincipal");
				}
			});
			btnCancelar.setBounds(938, 503, 89, 23);
		}
		return btnCancelar;
	}
	
	
	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}

}
