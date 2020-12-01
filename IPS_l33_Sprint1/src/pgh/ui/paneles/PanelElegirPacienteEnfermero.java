package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

import pgh.business.cita.Cita;
import pgh.business.cita.CitaDTO;
import pgh.business.cita.FindAllCitas;
import pgh.business.cita.ListaCitas;

import pgh.business.medico.Medico;
import pgh.ui.paneles.filtros.JListFiltroCitasPacienteEnfermero;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

import com.toedter.calendar.JTextFieldDateEditor;

public class PanelElegirPacienteEnfermero extends JPanel {
	private JScrollPane scrollPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnElegirCita;
	private JButton btnCancelar;
	private JLabel lblCitasMasProxima;
	private JScrollPane scrollPane_1;
	private JListFiltroCitasPacienteEnfermero listCitasConPaciente;
	private JList listCitaProxima;
	private DefaultListModel<Cita> modeloListCitasEnfermero;
	private DefaultListModel<Cita> modeloListCitasCercana;
	private Cita cita;
	private CitaDTO citaDTO;
	private ListaCitas lc;
	private List<Cita> citas;
	private List<Cita> citas2;
	private FindAllCitas findCitas;
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private JPanel estePanel;
	private int idEnfermero;
	private int idPaciente;
	
	
	public PanelElegirPacienteEnfermero(JPanel panelAnterior, JPanel panelContenido, int idEnfermero) {
		this.panelAnterior = panelAnterior;
		this.estePanel = this;
		this.panelContenido = panelContenido;
		this.idEnfermero = idEnfermero;
	
		setBackground(new Color(135, 206, 235));
		setLayout(null);
		setBounds(100, 100, 1129, 600);
		add(getScrollPane());
		add(getLblNewLabel());
		add(getBtnElegirCita());
		add(getBtnCancelar());
		add(getLblCitasMasProxima());
		add(getScrollPane_1());
	}
	
	

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(67, 66, 988, 234);
			scrollPane.setViewportView(getListCitasConPaciente());
		}
		return scrollPane;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Citas con pacientes: ");
			lblNewLabel.setBounds(68, 21, 200, 20);
		}
		return lblNewLabel;
	}
	private JButton getBtnElegirCita() {
		if (btnElegirCita == null) {
			btnElegirCita = new JButton("Elegir Cita");
			btnElegirCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					boolean cita = false;
					boolean citaProxima = false;
					
					int idPaciente = 0;
					
					if(listCitasConPaciente.getSelectedValuesList().size()>0) {
						
						cita = true;
					}
					
					if(listCitaProxima.getSelectedValuesList().size()>0) {
						
						citaProxima = true;
					}
					
					if(!cita && !citaProxima) {
						
						JOptionPane.showMessageDialog(getBtnElegirCita(), "No has seleccionada ninguna cita");
						
					}
					
					if(cita && citaProxima) {
						
						JOptionPane.showMessageDialog(getBtnElegirCita(), "has seleccionado dos citas, selecciona solo una, ctrl click izquierdo para deseleccionar ");
						
					}
					
					if(cita && !citaProxima ){
						
						for(Object o :listCitasConPaciente.getSelectedValuesList()) {
							Cita c = (Cita) o;
							idPaciente = c.getIdPaciente();
						}
						
						PanelVacunar panel = new PanelVacunar(estePanel, panelContenido, idPaciente, estePanel, idEnfermero );
						panelContenido.add(panel);
						estePanel.setVisible(false);
						panel.setVisible(true);
						
					}
					if(!cita && citaProxima) {
						
						for(Object o :listCitaProxima.getSelectedValuesList()) {
							Cita c = (Cita) o;
							idPaciente = c.getIdPaciente();
						}
						
						PanelVacunar panel = new PanelVacunar(estePanel, panelContenido, idPaciente, estePanel, idEnfermero );
						panelContenido.add(panel);
						estePanel.setVisible(false);
						panel.setVisible(true);
						
					}
					
					
				}
			});
			btnElegirCita.setForeground(new Color(0, 128, 0));
			btnElegirCita.setBounds(692, 512, 165, 33);
		}
		return btnElegirCita;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					estePanel.setVisible(false);
					panelAnterior.setVisible(true);
				}
			});
			btnCancelar.setForeground(new Color(255, 0, 0));
			btnCancelar.setBounds(890, 512, 165, 33);
		}
		return btnCancelar;
	}
	private JLabel getLblCitasMasProxima() {
		if (lblCitasMasProxima == null) {
			lblCitasMasProxima = new JLabel("Cita mas proxima: ");
			lblCitasMasProxima.setBounds(67, 320, 200, 20);
		}
		return lblCitasMasProxima;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(67, 346, 988, 86);
			scrollPane_1.setViewportView(getListCitaProxima());
		}
		return scrollPane_1;
	}
	private JList getListCitasConPaciente() {
		if (listCitasConPaciente == null) {
			modeloListCitasEnfermero = new DefaultListModel<Cita>();
			llenarLista();
			listCitasConPaciente = new JListFiltroCitasPacienteEnfermero(modeloListCitasEnfermero);
			listCitasConPaciente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.add(listCitasConPaciente.gettextoFiltro());
		}
		return listCitasConPaciente;
	}
	
	private void llenarLista() {
		
		citas = new ArrayList<Cita>();
		findCitas= new FindAllCitas();
		if(findCitas.FindCitaIdEnfermero(idEnfermero).size()>0) {
			for(int i=0; i < findCitas.FindCitaIdEnfermero(idEnfermero).size() ; i++) {
				
				citaDTO= findCitas.FindCitaIdEnfermero(idEnfermero).get(i);
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
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(citaDTO.fecha.equals(date2) || citaDTO.fecha.after(date2)) {
					cita = new Cita(citaDTO);
					citas.add(cita);
				}

				
			}
		}
		
		for(Cita c : citas) {
			modeloListCitasEnfermero.addElement(c);
		}
		
	}



	private JList getListCitaProxima() {
		if (listCitaProxima == null) {
			modeloListCitasCercana = new DefaultListModel<Cita>();
			llenarListaFiltrada();
			listCitaProxima = new JList(modeloListCitasCercana);
			listCitaProxima.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listCitaProxima;
	}



	private void llenarListaFiltrada() {
		
		SimpleDateFormat dateformat4 = new SimpleDateFormat("yyyy/MM/dd");
		
		Date fechaPequena = new Date();
		
		try {
			fechaPequena = dateformat4.parse(2060 + "/" + 12 + "/" + 22);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		
		SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy/MM/dd");
		Date fechaCercana = new Date();
		
		try {
			fechaCercana = dateformat3.parse(2060 + "/" + 12 + "/" + 22);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
		Date date2 = new Date();
		try {
			date2 = dateformat.parse(ano + "/" + mes + "/" + dia);
			

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		citas = new ArrayList<Cita>();
		citas2 = new ArrayList<Cita>();
		findCitas= new FindAllCitas();
		if(findCitas.FindCitaIdEnfermero(idEnfermero).size()>0) {
			for(int i=0; i < findCitas.FindCitaIdEnfermero(idEnfermero).size() ; i++) {
				
				citaDTO= findCitas.FindCitaIdEnfermero(idEnfermero).get(i);
				cita = new Cita(citaDTO);
				citas.add(cita);
			}
		}
		
		
		for(Cita c : citas) {
			
			if(c.getDate().after(date2)) {
				
					if(c.getDate().before(fechaPequena)) {
						fechaPequena = c.getDate();
						citas2.add(c);				}		
					
			}
			
		}
		
		for(Cita c : citas2) {
			
			if(c.getDate().equals(fechaPequena)) {
				
					modeloListCitasCercana.addElement(c);
					
			}
			
		}
		
		
			
			
		
	}
}
