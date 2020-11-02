package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JScrollPane;

import pgh.business.vacacionesSolicitadas.ListaVacacionesSolicitadasMedico;
import pgh.business.vacacionesSolicitadas.VacacionesSolicitadasMedico;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSolicitudesVacacionesAdministrador extends JPanel {

	private JScrollPane scrollPane;
	private JButton btnAbrirSeleccionada;
	private JButton btnCancelar;
	private JList listVacacionesSolicitadas;
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private DefaultListModel<VacacionesSolicitadasMedico> modeloVacacioneSolicitadas;
	private ListaVacacionesSolicitadasMedico lvs;
	private PanelSolicitudesVacacionesAdministrador p;
	private VacacionesSolicitadasMedico vsm;

	public PanelSolicitudesVacacionesAdministrador(JPanel panelAnterior, JPanel panelContenido) {

		p=this;
		this.panelAnterior = panelAnterior;
		this.panelContenido = panelContenido;

		setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 1129, 600);
		setLayout(null);
		add(getScrollPane());
		add(getBtnAbrirSeleccionada());
		add(getBtnCancelar());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(137, 124, 499, 266);
			scrollPane.setViewportView(getListVacacionesSolicitadas());
			
		}
		return scrollPane;
	}

	private JButton getBtnAbrirSeleccionada() {
		if (btnAbrirSeleccionada == null) {
			btnAbrirSeleccionada = new JButton("Abrir seleccionada");
			btnAbrirSeleccionada.setBounds(720, 238, 149, 37);
			btnAbrirSeleccionada.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					for(Object o : listVacacionesSolicitadas.getSelectedValuesList()) {
						vsm= (VacacionesSolicitadasMedico) o;
					}
					
					PanelTratarSolicitudesVacaciones panel = new PanelTratarSolicitudesVacaciones(p, vsm);
					panelContenido.add( panel);
					p.setVisible(false);
					panel.setVisible(true);
				}
			});
			
		}
		return btnAbrirSeleccionada;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					closePanel();
				}
			});

			btnCancelar.setBounds(945, 540, 138, 31);
		}
		return btnCancelar;
	}

	private JList getListVacacionesSolicitadas() {
		if (listVacacionesSolicitadas == null) {
			modeloVacacioneSolicitadas = new DefaultListModel();
			llenarLista();
			listVacacionesSolicitadas = new JList(modeloVacacioneSolicitadas);
		}
		return listVacacionesSolicitadas;
	}

	private void llenarLista() {

		lvs = new ListaVacacionesSolicitadasMedico();
		lvs.creaVacaciones();
		for (VacacionesSolicitadasMedico e : lvs.getVacacionesSolicitadas()) {
			modeloVacacioneSolicitadas.addElement(e);
		}

	}

	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}
}
