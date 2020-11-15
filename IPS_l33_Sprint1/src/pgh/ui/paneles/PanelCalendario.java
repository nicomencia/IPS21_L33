package pgh.ui.paneles;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;

import pgh.business.cita.Cita;
import pgh.business.cita.FindAllCitas;
import pgh.business.cita.ListaCitas;
import pgh.business.medicocita.MedicoCita;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelCalendario extends JPanel {
	private JPanel panelCalendarioPicker;
	private int idmedico;
	private UtilDateModel model;
	private JLabel label;
	private JButton btnComprobarCitas;
	private JScrollPane scrollPane;
	private JList listCitas;
	private List<MedicoCita> medicoCitas;
	private List<Cita> citas;
	private DefaultListModel<Cita> modeloListaCitas = new DefaultListModel<Cita>();
	private JPanel panelAnterior;
	private ListaCitas find = new ListaCitas();
	private JButton btnNewButton;
	private JPanel panelCalendario;
	private JPanel panelContenido;
	/**
	 * Create the panel.
	 */
	public PanelCalendario(JPanel panelContenido, JPanel panelAnterior, int idmedico) {
		panelCalendario = this;
		this.panelContenido = panelContenido;
		this.panelAnterior = panelAnterior;
		this.idmedico = idmedico;
		find.creaCitas();
		this.citas = find.getCitas();
		setLayout(null);
		add(getPanelCalendarioPicker());
		add(getLabel());
		add(getBtnComprobarCitas());
		add(getScrollPane());
		add(getBtnNewButton());

	}
	
	private void crearModelo(Date fecha)
	{
		modeloListaCitas.removeAllElements();
		for(int i=0;i<citas.size();i++)
		{
			if(comprobarFecha(fecha, citas.get(i).getDate()))
			{
				modeloListaCitas.addElement(citas.get(i));
			}
		}
	}
	private JPanel getPanelCalendarioPicker() {
		if (panelCalendarioPicker == null) {
			 model = new UtilDateModel();
			//model.setDate(20,04,2014);
			// Need this...
			Properties p = new Properties();
			p.put("text.today", "Today");
			p.put("text.month", "Month");
			p.put("text.year", "Year");
			
			panelCalendarioPicker =  new JDatePanelImpl(model, p);
			panelCalendarioPicker.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					if(model.getValue()!=null)
						{
							Date prueba = model.getValue();
							getLabel().setText(prueba.toString());
							crearModelo(model.getValue());
							getListCitas();
						}
						else
						{
							JOptionPane.showConfirmDialog(btnComprobarCitas, "No has elegido un dia en el calendario");
						}
				}
			});
			panelCalendarioPicker.setBounds(875, 22, 204, 184);
			panelCalendarioPicker.setLayout(null);
		}
		return panelCalendarioPicker;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBounds(61, 22, 239, 32);
		}
		return label;
	}
	
	@SuppressWarnings("deprecation")
	private boolean comprobarFecha(Date fecha, Date fecha2)
	{
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		String prueba = calendario.get(Calendar.YEAR) + "-" + (calendario.get(Calendar.MONTH)+1) + "-" + calendario.get(Calendar.DAY_OF_MONTH);
		String prueba2 = fecha2.toString();
		
		if(prueba.equals(prueba2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private JButton getBtnComprobarCitas() {
		if (btnComprobarCitas == null) {
			btnComprobarCitas = new JButton("Comprobar Citas");
			btnComprobarCitas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(model.getValue()!=null)
					{
						Date prueba = model.getValue();
						getLabel().setText(prueba.toString());
						crearModelo(model.getValue());
						getListCitas();
					}
					else
					{
						JOptionPane.showConfirmDialog(btnComprobarCitas, "No has elegido un dia en el calendario");
					}
				}
			});
			btnComprobarCitas.setBounds(903, 259, 133, 32);
		}
		return btnComprobarCitas;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(29, 65, 824, 417);
			scrollPane.setViewportView(getListCitas());
		}
		return scrollPane;
	}
	private JList getListCitas() {
		if (listCitas == null) {
			listCitas = new JList(modeloListaCitas);
		}
		return listCitas;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Ver Cita");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(listCitas.getSelectedValue()!=null)
					{
					PanelCita panel = new PanelCita(panelContenido, panelCalendario, (Cita) listCitas.getSelectedValue());
					panelContenido.add(panel);
					panelCalendario.setVisible(false);
					panel.setVisible(true);
					}
					else
					{
						JOptionPane.showConfirmDialog(btnNewButton, "No has elegido ninguna cita");
					}
				}
			});
			btnNewButton.setBounds(903, 326, 133, 32);
		}
		return btnNewButton;
	}
}
