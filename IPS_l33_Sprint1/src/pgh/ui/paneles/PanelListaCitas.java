package pgh.ui.paneles;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import pgh.business.cita.Cita;
import pgh.business.cita.ListaCitas;
import pgh.business.medico.Medico;
import pgh.business.medicocita.ListaMedicoCita;
import pgh.business.medicocita.MedicoCita;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelListaCitas extends JPanel {
	private JScrollPane scrollPaneCitas;
	private JList<Cita> listCitas;
	private JLabel lblCitas;
	private JButton btnVerCita;
	private List<MedicoCita> medicoCitas;
	private List<Cita> citas;
	private DefaultListModel<Cita> modeloListaCitas;
	private Medico medico;
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private ListaCitas listaCitas = new ListaCitas();
	private JPanel panelListaCitas;
	/**
	 * Create the panel.
	 */
	public PanelListaCitas(JPanel panelAnterior, JPanel panelContenido, Medico medico) {
		this.medico = medico;
		this.panelAnterior = panelAnterior;
		this.panelContenido = panelContenido;
		panelListaCitas = this;
		medicoCitas = new ListaMedicoCita().getMedicoCitas();
		listaCitas.creaListaCitas();
		citas =  listaCitas.getCitas();
		setLayout(null);
		add(getScrollPaneCitas());
		add(getLblCitas());
		add(getBtnVerCita());

	}
	
	private void crearModelo()
	{
		if(medico!=null)
		{
			for(int i=0;i<citas.size();i++)
			{
				for(int j=0;j<medicoCitas.size();j++)
				{
					if((medico.getIdMedico()==medicoCitas.get(j).getIdMedico()) && (citas.get(i).getIdCita() == medicoCitas.get(j).getIdCita()))
					{
						modeloListaCitas.addElement(citas.get(i));
					}
				}
			}
		}
		else
		{
			for(int i=0;i<citas.size();i++)
			{
				modeloListaCitas.addElement(citas.get(i));
			}
		}
	}
	
	private JScrollPane getScrollPaneCitas() {
		if (scrollPaneCitas == null) {
			scrollPaneCitas = new JScrollPane();
			scrollPaneCitas.setBounds(73, 88, 443, 426);
			scrollPaneCitas.setViewportView(getListCitas());
		}
		return scrollPaneCitas;
	}
	private JList<Cita> getListCitas() {
		if (listCitas == null) {
			modeloListaCitas = new DefaultListModel<Cita>();
			crearModelo();
			listCitas = new JList(modeloListaCitas);
		}
		return listCitas;
	}
	private JLabel getLblCitas() {
		if (lblCitas == null) {
			lblCitas = new JLabel("Citas:");
			lblCitas.setBounds(73, 43, 89, 34);
		}
		return lblCitas;
	}
	private JButton getBtnVerCita() {
		if (btnVerCita == null) {
			btnVerCita = new JButton("Ver Cita");
			btnVerCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(listCitas.getSelectedValue()!=null) {
						PanelCita panel = new PanelCita(panelContenido, (Cita) listCitas.getSelectedValue());
						panelContenido.add(panel);
						panel.setVisible(true);
						panelListaCitas.setVisible(false);
					}
					
					else {
						
						JOptionPane.showInputDialog("Tienes que elegir una cita");
					}
				}
			});
			btnVerCita.setBounds(580, 480, 116, 34);
		}
		return btnVerCita;
	}
}
