package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;

import pgh.business.medico.EditarDiasVacaciones;
import pgh.business.medico.FindAllMedicos;
import pgh.business.medico.ListaMedicos;
import pgh.business.medico.Medico;
import pgh.ui.paneles.filtros.JListFiltroElegirMedicoAumentarDias;

import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelAumentarVacaciones extends JPanel {
	private JScrollPane scrollPane;
	private JTextField textField;
	private JSpinner spinner;
	private JLabel lblNewLabel;
	private JLabel lblNuevosDias;
	private JTextField textField_1;
	private JButton btnAsignar;
	private JButton btnCancelar;
	private JListFiltroElegirMedicoAumentarDias listMedicos;
	private DefaultListModel<Medico> modeloListMedicos;
	private ListaMedicos lm;
	private int diasSolicitados;
	private Medico medico;
	private Medico medico2;
	private EditarDiasVacaciones editarDias;
	private FindAllMedicos findMedicos;
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private JPanel estePanel;
	private JTextField textField_2;

	public PanelAumentarVacaciones(JPanel panelAnterior, JPanel panelContenido) {
		this.panelAnterior = panelAnterior;
		this.panelContenido = panelContenido;
		estePanel= this;
		setBackground(new Color(135, 206, 235));
		setBounds(305, 0, 1009, 561);
		setLayout(null);
		add(getScrollPane());
		add(getSpinner());
		add(getLblNewLabel());
		add(getLblNuevosDias());
		add(getTextField_1());
		add(getBtnAsignar());
		add(getBtnCancelar());
		
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(65, 73, 384, 407);
			scrollPane.setViewportView(getListMedicos());
		}
		return scrollPane;
	}
	
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.setBounds(746, 180, 68, 27);
		}
		return spinner;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Dias previos:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(606, 122, 115, 27);
		}
		return lblNewLabel;
	}
	private JLabel getLblNuevosDias() {
		if (lblNuevosDias == null) {
			lblNuevosDias = new JLabel("Nuevos dias : ");
			lblNuevosDias.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNuevosDias.setBounds(606, 178, 130, 27);
		}
		return lblNuevosDias;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_1.setBounds(746, 124, 94, 27);
			textField_1.setColumns(10);
			
		}
		return textField_1;
	}
	private JButton getBtnAsignar() {
		if (btnAsignar == null) {
			btnAsignar = new JButton("Asignar ");
			btnAsignar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					editarDias = new EditarDiasVacaciones();
					for(Object o: listMedicos.getSelectedValuesList()) {
						medico = (Medico) o;
					}
					editarDias.actualizar((int) spinner.getValue(), medico.getIdMedico());
					
					PanelAumentarVacaciones panel = new PanelAumentarVacaciones(panelAnterior,panelContenido);
					estePanel.setVisible(false);
					panelContenido.add(panel);
					panel.setVisible(true);
					
				}
			});
			btnAsignar.setBounds(606, 430, 170, 39);
		}
		return btnAsignar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					estePanel.setVisible(false);
					panelAnterior.setVisible(true);
				}
			});
			btnCancelar.setBounds(801, 430, 170, 39);
		}
		return btnCancelar;
	}
	private JList getListMedicos() {
		if (listMedicos == null) {
			modeloListMedicos = new DefaultListModel();
			anadirMedicosALaLista();
			listMedicos = new JListFiltroElegirMedicoAumentarDias(modeloListMedicos);
			this.add(listMedicos.gettextoFiltro());
			listMedicos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					textField_1.setText(getDiasDispobibles()+ "");
				}
			});
			
		}
		return listMedicos;
	}
	
	private void anadirMedicosALaLista() {

		lm = new ListaMedicos();
		lm.creaListaMedicos();
		for (Medico m : lm.getMedicos()) {
			modeloListMedicos.addElement(m);
		}
	}
	
	private int getDiasDispobibles() {
		
		findMedicos = new FindAllMedicos();	
		for(Object o: listMedicos.getSelectedValuesList()) {
			medico = (Medico) o;
		}
		medico2 = new Medico(findMedicos.diasDisponibles(medico.getIdMedico()));
		return medico2.getDiasDisponibles();
			
	}
	
}
