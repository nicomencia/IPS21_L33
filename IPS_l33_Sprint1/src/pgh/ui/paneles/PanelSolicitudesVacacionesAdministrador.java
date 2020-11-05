package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JScrollPane;

import pgh.business.vacacionesSolicitadas.ListaVacacionesSolicitadasMedico;
import pgh.business.vacacionesSolicitadas.VacacionesSolicitadasMedico;
import pgh.ui.paneles.filtros.JListFiltroElegirVacaciones;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;

public class PanelSolicitudesVacacionesAdministrador extends JPanel {

	private JScrollPane scrollPane;
	private JButton btnAbrirSeleccionada;
	private JButton btnCancelar;
	private JListFiltroElegirVacaciones listVacacionesSolicitadas;
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private DefaultListModel<VacacionesSolicitadasMedico> modeloVacacioneSolicitadas;
	private ListaVacacionesSolicitadasMedico lvs;
	private PanelSolicitudesVacacionesAdministrador p;
	private VacacionesSolicitadasMedico vsm;
	private JLabel lblNewLabel;
	private JPanel panelCambiar;
	private JTextField textField;
	

	public PanelSolicitudesVacacionesAdministrador(JPanel panelAnterior, JPanel panelContenido, JPanel panelCambiar) {

		p=this;
		this.panelAnterior = panelAnterior;
		this.panelContenido = panelContenido;
		this.panelCambiar = panelCambiar;
		setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 1129, 600);
		setLayout(null);
		add(getScrollPane());
		add(getBtnAbrirSeleccionada());
		add(getBtnCancelar());
		add(getLblNewLabel());
		
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
					
					PanelTratarSolicitudesVacaciones panel = new PanelTratarSolicitudesVacaciones(p, vsm, panelCambiar, panelContenido);
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

			btnCancelar.setBounds(944, 505, 138, 31);
		}
		return btnCancelar;
	}

	private JList getListVacacionesSolicitadas() {
		if (listVacacionesSolicitadas == null) {
			modeloVacacioneSolicitadas = new DefaultListModel();
			llenarLista();
			listVacacionesSolicitadas = new JListFiltroElegirVacaciones(modeloVacacioneSolicitadas);
			this.add(listVacacionesSolicitadas.gettextoFiltro());
			listVacacionesSolicitadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listVacacionesSolicitadas;
	}

	private void llenarLista() {

		lvs = new ListaVacacionesSolicitadasMedico();
		lvs.creaVacaciones();
		for (VacacionesSolicitadasMedico e : lvs.getVacacionesSolicitadas()) {
			if(e.getEsperando()==true) {
				modeloVacacioneSolicitadas.addElement(e);
			}
			
		}
			

	}

	protected void closePanel() {
		this.setVisible(false);
		this.panelCambiar.setVisible(true);
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Filtro sensible a MAYUSCULAS");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setBounds(136, 25, 200, 50);
		}
		return lblNewLabel;
	}
	
}
