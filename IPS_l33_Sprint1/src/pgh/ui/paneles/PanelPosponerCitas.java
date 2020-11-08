package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import pgh.business.cita.Cita;
import pgh.business.cita.CitaDTO;
import pgh.business.cita.EditarCita;
import pgh.business.cita.FindAllCitas;
import pgh.business.vacacionesSolicitadas.VacacionesSolicitadasMedico;
import pgh.ui.paneles.filtros.JListFiltroPosponerCita;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

public class PanelPosponerCitas extends JPanel {
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JDateChooser dateChooserFechaNueva;
	private JScrollPane scrollPane_1;
	private JLabel lblFechaDeLas;
	private JScrollPane scrollPane_2;
	private JLabel lblCitaSeleccionadaA;
	private JButton btnPosponerCita;
	private JButton btnCancelar;
	private JLabel lblListaDeCitas;
	private JButton btnElegirCita;
	private JTextField textField;
	private JListFiltroPosponerCita listCitasAAsignar;
	private JList listCitaSeleccionada;
	private VacacionesSolicitadasMedico VacacioneSolicitadas;
	private DefaultListModel<Cita> modeloCita;
	private DefaultListModel<Cita> modeloCitaSeleccionada;
	private DefaultListModel<VacacionesSolicitadasMedico> modeloVacaciones;
	private FindAllCitas findCitas;
	private Cita cita;
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private JPanel panelPorponerCitas;
	private JList listVacacionesSolicitadas;
	private EditarCita editarCita;
	private JPanel panelcambiar;
	
	
	
	public PanelPosponerCitas(JPanel panelAnterior , JPanel panelContenido, VacacionesSolicitadasMedico v, JPanel panelCambiar) {
		
		setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 1129, 545);
		this.panelAnterior=panelAnterior;
		this.VacacioneSolicitadas = v;
		this.panelContenido = panelContenido;
		panelPorponerCitas=this;
		this.panelcambiar = panelCambiar;
		setLayout(null);
		add(getLblNewLabel());
		add(getDateChooserFechaNueva());
		add(getScrollPane_1());
		add(getLblFechaDeLas());
		add(getScrollPane_2());
		add(getLblCitaSeleccionadaA());
		add(getBtnPosponerCita());
		add(getBtnCancelar());
		add(getLblListaDeCitas());
		add(getBtnElegirCita());
		add(getScrollPane());
		
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(48, 89, 383, 386);
			scrollPane.setViewportView(getListCitasAAsignar());
		}
		return scrollPane;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Nueva fecha para la cita : ");
			lblNewLabel.setBounds(777, 61, 164, 38);
		}
		return lblNewLabel;
	}
	private JDateChooser getDateChooserFechaNueva() {
		if (dateChooserFechaNueva == null) {
			dateChooserFechaNueva = new JDateChooser();
			dateChooserFechaNueva.setBounds(787, 110, 105, 20);
			
			Calendar fecha = new GregorianCalendar();

			int dia = fecha.get(Calendar.DAY_OF_MONTH);
			int mes=0;
			if(Calendar.MONTH==12) {
				mes = fecha.get(Calendar.MONTH) - 11;
			}
			else {
				mes = fecha.get(Calendar.MONTH) + 1;
			}
			
			int ano = fecha.get(Calendar.YEAR);

			SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy/MM/dd");
			Date date2 = new Date();
			try {
				date2 = dateformat3.parse(ano + "/" + mes + "/" + dia);
				dateChooserFechaNueva.setDate(date2);
				dateChooserFechaNueva.getJCalendar().setMinSelectableDate(date2);
				((JTextFieldDateEditor) dateChooserFechaNueva.getDateEditor()).setEditable(false);
				

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return dateChooserFechaNueva;
	}
	
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(493, 110, 240, 50);
			scrollPane_1.setViewportView(getListVacacionesSolicitadas());
		}
		return scrollPane_1;
	}
	private JLabel getLblFechaDeLas() {
		if (lblFechaDeLas == null) {
			lblFechaDeLas = new JLabel("Fecha de las vacaciones solicitadas :");
			lblFechaDeLas.setBounds(493, 61, 240, 38);
		}
		return lblFechaDeLas;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(493, 217, 399, 89);
			scrollPane_2.setViewportView(getListCitaSeleccionada());
		}
		return scrollPane_2;
	}
	private JLabel getLblCitaSeleccionadaA() {
		if (lblCitaSeleccionadaA == null) {
			lblCitaSeleccionadaA = new JLabel("Cita seleccionada a posponer : ");
			lblCitaSeleccionadaA.setBounds(493, 173, 240, 38);
		}
		return lblCitaSeleccionadaA;
	}
	private JButton getBtnPosponerCita() {
		if (btnPosponerCita == null) {
			btnPosponerCita = new JButton("Posponer cita");
			btnPosponerCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					editarCita =new EditarCita();
					editarCita.editarFecha(dateChooserFechaNueva.getDate(), modeloCitaSeleccionada.getElementAt(0).getIdCita());
					
					
					Calendar fecha = new GregorianCalendar();

					int dia = fecha.get(Calendar.DAY_OF_MONTH);
					int mes=0;
					if(Calendar.MONTH==12) {
						mes = fecha.get(Calendar.MONTH) - 11;
					}
					else {
						mes = fecha.get(Calendar.MONTH) + 1;
					}
					
					int ano = fecha.get(Calendar.YEAR);

					SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy/MM/dd");
					Date date2 = new Date();
					try {
						date2 = dateformat3.parse(ano + "/" + mes + "/" + dia);
						dateChooserFechaNueva.setDate(date2);
						dateChooserFechaNueva.getJCalendar().setMinSelectableDate(date2);
						((JTextFieldDateEditor) dateChooserFechaNueva.getDateEditor()).setEditable(false);
						

					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					modeloCitaSeleccionada.removeAllElements();
					modeloCita.removeAllElements();
					llenarCita();
					
					
					
				}	
					
				
			});
			btnPosponerCita.setForeground(new Color(0, 128, 0));
			btnPosponerCita.setBounds(688, 474, 147, 44);
		}
		return btnPosponerCita;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PanelTratarSolicitudesVacaciones panel = new PanelTratarSolicitudesVacaciones(panelPorponerCitas, VacacioneSolicitadas, panelcambiar, panelContenido);
					panelContenido.add(panel);
					panelPorponerCitas.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnCancelar.setForeground(new Color(255, 0, 0));
			btnCancelar.setBounds(875, 474, 147, 44);
		}
		return btnCancelar;
	}
	private JLabel getLblListaDeCitas() {
		if (lblListaDeCitas == null) {
			lblListaDeCitas = new JLabel("Lista de citas afectadas por las vacaciones : ");
			lblListaDeCitas.setBounds(48, 20, 240, 38);
		}
		return lblListaDeCitas;
	}
	private JButton getBtnElegirCita() {
		if (btnElegirCita == null) {
			btnElegirCita = new JButton("Seleccionar cita");
			btnElegirCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					for(Object o : listCitasAAsignar.getSelectedValuesList()) {
						if(!modeloCitaSeleccionada.contains(o)) {
							if(modeloCitaSeleccionada.getSize()<1) {
								modeloCitaSeleccionada.addElement((Cita) o);
							}
						}
					}
					
				}
			});
			btnElegirCita.setBounds(48, 481, 383, 23);
		}
		return btnElegirCita;
	}
	
	private JList getListCitasAAsignar() {
		if (listCitasAAsignar == null) {
			modeloCita = new DefaultListModel<Cita>();
			llenarCita();
			listCitasAAsignar = new JListFiltroPosponerCita(modeloCita);
			this.add(listCitasAAsignar.gettextoFiltro());
			listCitasAAsignar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listCitasAAsignar;
	}
	
	private JList getListVacacionesSolicitadas() {
		if (listVacacionesSolicitadas == null) {
			modeloVacaciones = new DefaultListModel<VacacionesSolicitadasMedico>();
			llenarVacaciones();
			listVacacionesSolicitadas = new JList(modeloVacaciones);
		}
		return listVacacionesSolicitadas;
	}
	private void llenarVacaciones() {
		
		modeloVacaciones.addElement(VacacioneSolicitadas);
		
		
	}
	
	private void llenarCita() {
		

		findCitas = new FindAllCitas();
		
		for(CitaDTO c : findCitas.FindCitaIdMedico(modeloVacaciones.getElementAt(0).getIdMedico())) {

					if(modeloVacaciones.getElementAt(0).getFechaInicio().before(c.fecha) || modeloVacaciones.getElementAt(0).getFechaInicio().equals(c.fecha) || modeloVacaciones.getElementAt(0).getFechaFin().equals(c.fecha) ) {
						if(modeloVacaciones.getElementAt(0).getFechaFin().after(c.fecha)) {
							cita = new Cita(c);
							modeloCita.addElement(cita);
						}
					}	
		}
		
		
	}
	private JList getListCitaSeleccionada() {
		if (listCitaSeleccionada == null) {
			modeloCitaSeleccionada = new DefaultListModel<Cita>();
			listCitaSeleccionada = new JList(modeloCitaSeleccionada);
		}
		return listCitaSeleccionada;
	}
	
	
	
}
