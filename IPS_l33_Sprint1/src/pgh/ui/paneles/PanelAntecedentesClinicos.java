


package pgh.ui.paneles;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import pgh.business.antecedentesClinicos.Antecedentes;
import pgh.business.antecedentesClinicos.AntecedentesDTO;
import pgh.business.antecedentesClinicos.FindAllAntecedentes;
import pgh.business.antecedentesClinicos.ListaAntecedentes;
import pgh.business.medico.ListaMedicos;
import pgh.business.medico.Medico;
import pgh.ui.paneles.filtros.JListFiltroAntecedentesClinicos;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAntecedentesClinicos extends JPanel {
	private JScrollPane scrollPaneListaAntecedentes;
	private JListFiltroAntecedentesClinicos listAntecedentes;
	private JLabel lblNewLabelistaAnt;
	private JButton btnAnadirAntecedente;
	private JTextField textField;
	private JLabel lblFiltro;
	private JButton btnNewButton;
	private JScrollPane scrollPaneInfo;
	private JList listInformacionAntecedente;
	private JLabel lblInfo;
	private JButton btnSalir;
	private DefaultListModel<Antecedentes> modeloListAntecedentes;
	private DefaultListModel<Antecedentes> modeloListAntecedenteElegido;
	private ListaAntecedentes la;
	private JButton btnEliminar;
	private JPanel panelAnterior;
	private JPanel panelPrevio;
	private JPanel panelContenido;
	private int id_paciente;
	private JPanel panelAntecedentes;
	private int idCita;
	
	
	
	
	public PanelAntecedentesClinicos(JPanel panelAnterior, JPanel panelContenido, int idpaciente, JPanel panelPrevio, int idcita) {
		this.setBackground(new Color(135, 206, 235));
		this.panelAnterior = panelAnterior;
		this.panelPrevio = panelPrevio;
		this.panelContenido = panelContenido;
		this.id_paciente=idpaciente;
		this.idCita = idcita;
		panelAntecedentes=this;
		setLayout(null);
		setBounds(100, 100, 1129, 600);
		add(getScrollPaneListaAntecedentes());
		add(getLblNewLabelistaAnt());
		add(getBtnAnadirAntecedente());
		add(getLblFiltro());
		add(getBtnNewButton());
		add(getScrollPaneInfo());
		add(getLblInfo());
		add(getBtnSalir());
		add(getBtnEliminar());
	}
	private JScrollPane getScrollPaneListaAntecedentes() {
		if (scrollPaneListaAntecedentes == null) {
			scrollPaneListaAntecedentes = new JScrollPane();
			scrollPaneListaAntecedentes.setBounds(104, 152, 371, 363);
			scrollPaneListaAntecedentes.setViewportView(getListAntecedentes());
		}
		return scrollPaneListaAntecedentes;
	}
	private JList getListAntecedentes() {
		if (listAntecedentes == null) {
			modeloListAntecedentes = new DefaultListModel();
			añadirAntecedentesLista();
			listAntecedentes = new JListFiltroAntecedentesClinicos(modeloListAntecedentes);
			this.add(listAntecedentes.gettextoFiltro());
			listAntecedentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listAntecedentes;
	}
	
	private void añadirAntecedentesLista() {
	
		la = new ListaAntecedentes(id_paciente);
		la.creaListaAntecedentesFiltrados();
		for (Antecedentes a : la.getAntecedentesFiltrados()) {
			modeloListAntecedentes.addElement(a);
		}

	}
	private JLabel getLblNewLabelistaAnt() {
		if (lblNewLabelistaAnt == null) {
			lblNewLabelistaAnt = new JLabel("Lista de antecedentes ");
			lblNewLabelistaAnt.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabelistaAnt.setBounds(180, 79, 371, 25);
		}
		return lblNewLabelistaAnt;
	}
	private JButton getBtnAnadirAntecedente() {
		if (btnAnadirAntecedente == null) {
			btnAnadirAntecedente = new JButton("A\u00F1adir antecedente");
			btnAnadirAntecedente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					PanelCrearAntecedente panel = new PanelCrearAntecedente(panelAntecedentes, panelContenido, id_paciente, panelPrevio, idCita);
					panelContenido.add(panel);
					panelAntecedentes.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnAnadirAntecedente.setBounds(104, 514, 371, 23);
		}
		return btnAnadirAntecedente;
	}
	
	private JLabel getLblFiltro() {
		if (lblFiltro == null) {
			lblFiltro = new JLabel("FILTRO :");
			lblFiltro.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblFiltro.setBounds(29, 136, 65, 14);
		}
		return lblFiltro;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Ver Informacion de la seleccionada");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					for(Object o : listAntecedentes.getSelectedValuesList()) {
						if(modeloListAntecedenteElegido.getSize()<1) {
							
							if(!modeloListAntecedenteElegido.contains(o)) {
								modeloListAntecedenteElegido.addElement((Antecedentes) o);
							}
						}
					}
					
				}
			});
			btnNewButton.setBounds(502, 294, 224, 39);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPaneInfo() {
		if (scrollPaneInfo == null) {
			scrollPaneInfo = new JScrollPane();
			scrollPaneInfo.setBounds(750, 186, 343, 279);
			scrollPaneInfo.setViewportView(getListInformacionAntecedente());
		}
		return scrollPaneInfo;
	}
	private JList getListInformacionAntecedente() {
		if (listInformacionAntecedente == null) {
			modeloListAntecedenteElegido = new DefaultListModel();
			listInformacionAntecedente = new JList(modeloListAntecedenteElegido);
			listInformacionAntecedente.setEnabled(false);
			listInformacionAntecedente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listInformacionAntecedente;
	}
	private JLabel getLblInfo() {
		if (lblInfo == null) {
			lblInfo = new JLabel("Informacion del Antecedente");
			lblInfo.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblInfo.setBounds(776, 131, 343, 25);
		}
		return lblInfo;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir ");
			btnSalir.setBounds(939, 513, 154, 25);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					closePanel();
				}
			});
			
		}
		return btnSalir;
	}
	
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Dejar de ver este antecedente");
			btnEliminar.setBounds(750, 464, 343, 23);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						modeloListAntecedenteElegido.removeAllElements();
				}
			});
		}
		return btnEliminar;
	}
	

	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}
	
	
	
}




