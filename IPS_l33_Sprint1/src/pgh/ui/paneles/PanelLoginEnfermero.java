package pgh.ui.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import pgh.business.enfermero.Enfermero;
import pgh.business.enfermero.ListaEnfermeros;
import pgh.ui.VentanaPrincipal;
import pgh.ui.paneles.filtros.JListFiltroLoginEnfermero;


public class PanelLoginEnfermero extends JPanel {
	
	
	private JPanel panelContenido;
	private ListaEnfermeros lm;
	private JPanel panelLoginEnfermero;
	private int id_enfermero;
	private JListFiltroLoginEnfermero listEnfermerosLogin;
	private JButton btnSeleccionarMedicoLogin;
	private JScrollPane scrollPane_5;
	private JList listEnfermeroLogueado;
	private JButton btnEliminarMedicoLogueado;
	private JButton btnSiguienteLogin;
	private JButton btnCancelar;
	private JScrollPane scrollPane_4;
	private DefaultListModel<Enfermero> modeloListaEnfermerosLogin;
	private DefaultListModel<Enfermero> modeloListaEnfermerosLogueados;
	private JPanel panelAnterior;
	private JPanel estePanel;
	private JPanel panelPrincipal;
	
	

	
	
	public PanelLoginEnfermero(JPanel panelAnterior, JPanel panelContenido) {
		
		this.panelAnterior = panelAnterior;
		this.estePanel = this;
		this.panelContenido = panelContenido;
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.add(getScrollPane_4());
		this.add(getBtnSeleccionarMedicoLogin());
		this.add(getScrollPane_5());
		this.add(getBtnEliminarMedicoLogueado());
		this.add(getBtnSiguienteLogin());
		this.add(getBtnCancelar());
		
	}
	
	
	private JScrollPane getScrollPane_4() {
		if (scrollPane_4 == null) {
			scrollPane_4 = new JScrollPane();
			scrollPane_4.setBounds(119, 152, 283, 263);
			scrollPane_4.setViewportView(getListEnfermerosLogin());

		}
		return scrollPane_4;
	}

	private JList getListEnfermerosLogin() {
		if (listEnfermerosLogin == null) {
			modeloListaEnfermerosLogin = new DefaultListModel();
			lm = new ListaEnfermeros();
			lm.creaListaEnfermeros();
			for (Enfermero m : lm.getEnfermeros()) {
				modeloListaEnfermerosLogin.addElement((Enfermero) m);
			}

			listEnfermerosLogin = new JListFiltroLoginEnfermero(modeloListaEnfermerosLogin);
			this.add(listEnfermerosLogin.gettextoFiltro());
			listEnfermerosLogin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		}
		return listEnfermerosLogin;
	}

	private JButton getBtnSeleccionarMedicoLogin() {
		if (btnSeleccionarMedicoLogin == null) {
			btnSeleccionarMedicoLogin = new JButton("Seleccionar Medico");
			btnSeleccionarMedicoLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (Object o : listEnfermerosLogin.getSelectedValuesList()) {
						if (!modeloListaEnfermerosLogueados.contains(o)) {
							if (modeloListaEnfermerosLogueados.getSize() < 1) {

								modeloListaEnfermerosLogueados.addElement((Enfermero) o);

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
		if (listEnfermeroLogueado == null) {
			modeloListaEnfermerosLogueados = new DefaultListModel();
			listEnfermeroLogueado = new JList(modeloListaEnfermerosLogueados);
		}
		return listEnfermeroLogueado;
	}

	private JButton getBtnEliminarMedicoLogueado() {
		if (btnEliminarMedicoLogueado == null) {
			btnEliminarMedicoLogueado = new JButton("Eliminar");
			btnEliminarMedicoLogueado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListaEnfermerosLogueados.removeAllElements();
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

					if(modeloListaEnfermerosLogueados.isEmpty()) {
						JOptionPane.showMessageDialog(getBtnSiguienteLogin(), "Selecciones un medico para continuar");
					}
					else {
						id_enfermero = modeloListaEnfermerosLogueados.getElementAt(0).getIdEnfermero();
						PanelEnfermero pc = new PanelEnfermero(estePanel,panelContenido, id_enfermero, estePanel);
						panelContenido.add(pc);
						estePanel.setVisible(false);
						pc.setVisible(true);
					}
					
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
					
					estePanel.setVisible(false);
					
					
				}
			});
			btnCancelar.setBounds(938, 503, 89, 23);
		}
		return btnCancelar;
	}
	
	

}
