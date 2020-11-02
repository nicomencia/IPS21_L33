package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import pgh.business.enfermero.Enfermero;
import pgh.business.vacacionesSolicitadas.ListaVacacionesSolicitadasMedico;
import pgh.business.enfermero.ListaEnfermeros;
import pgh.business.vacacionesSolicitadas.VacacionesSolicitadasMedico;
import pgh.business.vacacionesSolicitadas.VacacionesSolicitadasMedicoDTO;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelComprobarSolicitudVacaciones extends JPanel {
	
	private JPanel panelAnterior;
	private JScrollPane scrollPane;
	private JList listInfoSolicitud;
	private JTextField textFieldEstado;
	private JLabel lblNewLabel;
	private JLabel lblEstadoDeLa;
	private JButton btnVolver;
	private DefaultListModel<String> modeloVacacioneSolicitadas;
	private ListaVacacionesSolicitadasMedico lvs;
	
	
	public PanelComprobarSolicitudVacaciones(JPanel panelAnterior) {
		
		this.panelAnterior=panelAnterior;
	
		setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 1129, 600);
		setLayout(null);
		add(getScrollPane());
		add(getTextFieldEstado());
		add(getLblNewLabel());
		add(getLblEstadoDeLa());
		add(getBtnVolver());
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(165, 145, 799, 77);
			scrollPane.setViewportView(getListInfoSolicitud());
		}
		return scrollPane;
	}
	private JList getListInfoSolicitud() {
		if (listInfoSolicitud == null) {
			modeloVacacioneSolicitadas = new DefaultListModel();
			llenarLista();
			listInfoSolicitud = new JList(modeloVacacioneSolicitadas);
		}
		return listInfoSolicitud;
	}
	
	private void llenarLista() {
		
		lvs = new ListaVacacionesSolicitadasMedico();
		lvs.creaVacaciones();
		for (VacacionesSolicitadasMedico e : lvs.getVacacionesSolicitadas()) {
			modeloVacacioneSolicitadas.addElement(e.toString());
		}
		
	}
	private JTextField getTextFieldEstado() {
		if (textFieldEstado == null) {
			textFieldEstado = new JTextField();
			textFieldEstado.setBounds(440, 314, 200, 50);
			textFieldEstado.setColumns(10);
			for(Object o: listInfoSolicitud.getSelectedValuesList()) {
				VacacionesSolicitadasMedico v = (VacacionesSolicitadasMedico) o;
				textFieldEstado.setText(v.estado());
			
			}
		}
		return textFieldEstado;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Informacion de las vacaciones solicitadas  ");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBounds(165, 89, 799, 50);
		}
		return lblNewLabel;
	}
	private JLabel getLblEstadoDeLa() {
		if (lblEstadoDeLa == null) {
			lblEstadoDeLa = new JLabel("Estado de la solicitud");
			lblEstadoDeLa.setHorizontalAlignment(SwingConstants.CENTER);
			lblEstadoDeLa.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblEstadoDeLa.setBounds(142, 264, 799, 50);
		}
		return lblEstadoDeLa;
	}
	private JButton getBtnVolver() {
		if (btnVolver == null) {
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					closePanel();
				}
			});
			btnVolver.setBounds(925, 527, 138, 40);
		}
		return btnVolver;
	}
	
	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}
}
