package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import pgh.business.cita.Cita;
import pgh.business.cita.FindAllCitas;
import pgh.business.cita.ListaCitas;
import pgh.business.enfermero.Enfermero;
import pgh.business.vacuna.CrearVacuna;
import pgh.business.vacuna.EditarVacuna;
import pgh.business.vacuna.FindAllVacunas;
import pgh.business.vacuna.ListaVacunas;
import pgh.business.vacuna.Vacuna;
import pgh.business.vacuna.VacunaDTO;
import pgh.ui.paneles.filtros.JListFiltroVacunasVacunar;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelVacunar extends JPanel {
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton btnPonerVacuna;
	private JButton btnNewButton;
	private JButton btnCancelar;
	private JLabel lblNewLabel;
	private JLabel lblVacunasMasProxima;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane_2;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_1_1_1_1;
	private JSpinner spinnerHoraAsignacion;
	private JSpinner spinnerMinutosAsignacion;
	private JLabel lblNewLabel_10_1;
	private JSpinner spinnerSegundosAsignacion;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_1_1;
	private JDateChooser dateChooser;
	private JPanel panelAnterior;
	private JPanel panelCambiar;
	private JPanel panelContenido;
	private JPanel estePanel;
	private int idPaciente;
	private DefaultListModel<Vacuna> modeloVacunas;
	private DefaultListModel<Vacuna> modeloVacunaProxima;
	private DefaultListModel<Vacuna> modeloVacunaSeleccionada;
	private JListFiltroVacunasVacunar listVacunas;
	private FindAllVacunas findAllVacunas;
	private Vacuna vacuna;
	private VacunaDTO vacunaDTO;
	private JList listVacunaProxima;
	private ListaVacunas lc;
	private List<Vacuna> vacunas;
	private JList listVacunaSeleccionada;
	private int idEnfermero;	
	private EditarVacuna editarVacuna;
	
	
	
	public PanelVacunar(JPanel panelAnterior, JPanel panelContenido, int idPaciente, JPanel panelCambiar, int idEnfermero) {
		this.panelAnterior = panelAnterior;
		this.estePanel = this;
		this.panelContenido = panelContenido;
		this.idPaciente = idPaciente;
		this.idEnfermero= idEnfermero;
		this.panelCambiar=panelCambiar;
		setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 1129, 600);
		setLayout(null);
		add(getScrollPane());
		add(getScrollPane_1());
		add(getBtnPonerVacuna());
		add(getBtnNewButton());
		add(getBtnCancelar());
		add(getLblNewLabel());
		add(getLblVacunasMasProxima());
		add(getBtnNewButton_1());
		add(getScrollPane_2());
		add(getBtnNewButton_2());
		add(getLblNewLabel_1_1_1_1());
		add(getSpinnerHoraAsignacion());
		add(getSpinnerMinutosAsignacion());
		add(getLblNewLabel_10_1());
		add(getSpinnerSegundosAsignacion());
		add(getLblNewLabel_10());
		add(getLblNewLabel_11());
		add(getLblNewLabel_1_1());
		add(getDateChooser());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(54, 84, 369, 302);
			scrollPane.setViewportView(getListVacunas());
		}
		return scrollPane;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(54, 418, 369, 66);
			scrollPane_1.setViewportView(getListVacunaProxima());
		}
		return scrollPane_1;
	}
	private JButton getBtnPonerVacuna() {
		if (btnPonerVacuna == null) {
			btnPonerVacuna = new JButton("Poner vacuna Elegida");
			btnPonerVacuna.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					editarVacuna = new EditarVacuna();
					
					editarVacuna.modificarEstados(true, modeloVacunaSeleccionada.get(0).getIdVacuna());
					
					PanelEnfermero panel = new PanelEnfermero(panelCambiar, panelContenido , idEnfermero, panelCambiar);
					estePanel.setVisible(false);
					panelContenido.add(panel);
					panel.setVisible(true);
				}
			});
			btnPonerVacuna.setEnabled(false);
			btnPonerVacuna.setBounds(677, 442, 200, 42);
		}
		return btnPonerVacuna;
	}
	
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Poner  nueva vacuna");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PanelCrearVacuna panel = new PanelCrearVacuna(estePanel, panelContenido, idPaciente,idEnfermero);
					panelContenido.add(panel);
					estePanel.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnNewButton.setBounds(471, 442, 184, 42);
		}
		return btnNewButton;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					panelCambiar.setVisible(true);
					estePanel.setVisible(false);
				
				}
			});
			btnCancelar.setBounds(898, 442, 164, 42);
		}
		return btnCancelar;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Vacunas pendientes :");
			lblNewLabel.setBounds(54, 28, 200, 32);
		}
		return lblNewLabel;
	}
	private JLabel getLblVacunasMasProxima() {
		if (lblVacunasMasProxima == null) {
			lblVacunasMasProxima = new JLabel("Vacuna mas proxima por ponerse:");
			lblVacunasMasProxima.setBounds(54, 386, 200, 32);
		}
		return lblVacunasMasProxima;
	}
	
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Seleccionar vacuna");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean vacuna = false;
					boolean VacunaProxima = false;
					
					int idPaciente = 0;
					
					if(listVacunas.getSelectedValuesList().size()>0) {
						
						vacuna = true;
					}
					
					if(listVacunaProxima.getSelectedValuesList().size()>0) {
						
						VacunaProxima = true;
					}
					
					if(!vacuna && !VacunaProxima) {
						
						JOptionPane.showMessageDialog(getBtnNewButton_1(), "No has seleccionada ninguna vacuna");
						
					}
					
					if(vacuna && VacunaProxima) {
						
						JOptionPane.showMessageDialog(getBtnNewButton_1(), "has seleccionado dos vacunas, selecciona solo una, ctrl click izquierdo para deseleccionar ");
						
					}
					
					if(vacuna && !VacunaProxima ){
						
						for(Object o :listVacunas.getSelectedValuesList()) {
							Vacuna c = (Vacuna) o;
							idPaciente = c.getIdPaciente();
							if(modeloVacunaSeleccionada.getSize()<1) {
								modeloVacunaSeleccionada.addElement(c);
							}
						}
						
						
						
					}
					if(!vacuna && VacunaProxima) {
						
						for(Object o :listVacunaProxima.getSelectedValuesList()) {
							Vacuna c = (Vacuna) o;
							idPaciente = c.getIdPaciente();
							if(modeloVacunaSeleccionada.getSize()<1) {
								modeloVacunaSeleccionada.addElement(c);
							}
						}
						
						
					}
					
					btnPonerVacuna.setEnabled(true);
					
				}
			});
			btnNewButton_1.setBounds(480, 200, 155, 32);
		}
		return btnNewButton_1;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(677, 99, 389, 147);
			scrollPane_2.setViewportView(getListVacunaSeleccionada());
		}
		return scrollPane_2;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Eliminar vacuna seleccionada");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					modeloVacunaSeleccionada.removeAllElements();
					btnPonerVacuna.setEnabled(false);
				}
			});
			btnNewButton_2.setBounds(677, 252, 389, 32);
		}
		return btnNewButton_2;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("Hora vacunacion : ");
			lblNewLabel_1_1_1_1.setBounds(677, 321, 113, 28);
		}
		return lblNewLabel_1_1_1_1;
	}
	
	public int obtenerHoraActual() {
		int hora = 0;
		DateFormat dateFormat = new SimpleDateFormat("HH");
		Date date = new Date();
		hora = Integer.parseInt(dateFormat.format(date));
		return hora;

	}

	public int obtenerMinutosActual() {

		int hora = 0;
		DateFormat dateFormat = new SimpleDateFormat("mm");
		Date date = new Date();
		hora = Integer.parseInt(dateFormat.format(date));
		return hora;

	}

	public int obtenerSegundosActual() {

		int hora = 0;
		DateFormat dateFormat = new SimpleDateFormat("ss");
		Date date = new Date();
		hora = Integer.parseInt(dateFormat.format(date));
		return hora;

	}
	
	private JSpinner getSpinnerHoraAsignacion() {
		if (spinnerHoraAsignacion == null) {
			spinnerHoraAsignacion = new JSpinner();
			spinnerHoraAsignacion.setBounds(784, 325, 52, 20);
			spinnerHoraAsignacion.setValue(obtenerHoraActual());
		}
		return spinnerHoraAsignacion;
	}
	private JSpinner getSpinnerMinutosAsignacion() {
		if (spinnerMinutosAsignacion == null) {
			spinnerMinutosAsignacion = new JSpinner();
			spinnerMinutosAsignacion.setBounds(856, 325, 52, 20);
			spinnerMinutosAsignacion.setValue(obtenerMinutosActual());
		}
		return spinnerMinutosAsignacion;
	}
	private JLabel getLblNewLabel_10_1() {
		if (lblNewLabel_10_1 == null) {
			lblNewLabel_10_1 = new JLabel(":");
			lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_10_1.setBounds(846, 328, 22, 14);
		}
		return lblNewLabel_10_1;
	}
	private JSpinner getSpinnerSegundosAsignacion() {
		if (spinnerSegundosAsignacion == null) {
			spinnerSegundosAsignacion = new JSpinner();
			spinnerSegundosAsignacion.setBounds(928, 325, 52, 20);
			spinnerSegundosAsignacion.setValue(obtenerSegundosActual());
		}
		return spinnerSegundosAsignacion;
	}
	private JLabel getLblNewLabel_10() {
		if (lblNewLabel_10 == null) {
			lblNewLabel_10 = new JLabel(":");
			lblNewLabel_10.setForeground(Color.BLACK);
			lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_10.setBounds(918, 328, 22, 14);
		}
		return lblNewLabel_10;
	}
	private JLabel getLblNewLabel_11() {
		if (lblNewLabel_11 == null) {
			lblNewLabel_11 = new JLabel("HH/mm/ss");
			lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_11.setBounds(1005, 328, 85, 14);
		}
		return lblNewLabel_11;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Fecha vacunacion: ");
			lblNewLabel_1_1.setBounds(677, 373, 132, 28);
		}
		return lblNewLabel_1_1;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(799, 373, 178, 28);
			
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
				dateChooser.setDate(date2);
				dateChooser.getJCalendar().setMinSelectableDate(date2);
				((JTextFieldDateEditor) dateChooser.getDateEditor()).setEditable(false);

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		return dateChooser;
	}
	private JList getListVacunas() {
		if (listVacunas == null) {
			modeloVacunas = new DefaultListModel<Vacuna>();
			llenarVacunas();
			listVacunas = new JListFiltroVacunasVacunar(modeloVacunas);
			this.add(listVacunas.gettextoFiltro());
		}
		return listVacunas;
	}

	private void llenarVacunas() {
		
		findAllVacunas = new FindAllVacunas();
		
		for(VacunaDTO c : findAllVacunas.FindVacunaByIdNoPuesta(idPaciente)) {

				vacuna = new Vacuna(c);
				modeloVacunas.addElement(vacuna);
		}
		
	}
	private JList getListVacunaProxima() {
		if (listVacunaProxima == null) {
			modeloVacunaProxima = new DefaultListModel<Vacuna>();
			llenarListaFiltrada();
			listVacunaProxima = new JList(modeloVacunaProxima);
		}
		return listVacunaProxima;
	}

	private void llenarListaFiltrada() {
		
		SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy/MM/dd");
		Date fechaCercana = new Date();
		
		try {
			fechaCercana = dateformat3.parse(2060 + "/" + 12 + "/" + 22);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		vacunas = new ArrayList<Vacuna>();
		findAllVacunas= new FindAllVacunas();
		if(findAllVacunas.FindVacunaByIdNoPuesta(idPaciente).size()>0) {
			for(int i=0; i < findAllVacunas.FindVacunaByIdNoPuesta(idPaciente).size() ; i++) {
				
				vacunaDTO= findAllVacunas.FindVacunaByIdNoPuesta(idPaciente).get(i);
				vacuna = new Vacuna(vacunaDTO);
				vacunas.add(vacuna);
			}
		}
		
		for(Vacuna c : vacunas) {
			
			if(c.getDiaAsignacion().before(fechaCercana)) {
				fechaCercana = c.getDiaAsignacion();
			}
			
		
			
		}
		
		for(Vacuna c : vacunas) {
			
			if(c.getDiaAsignacion()==fechaCercana) {
				modeloVacunaProxima.addElement(c);
			}
			
		}
		
	}
	private JList getListVacunaSeleccionada() {
		if (listVacunaSeleccionada == null) {
			modeloVacunaSeleccionada = new DefaultListModel<Vacuna>();
			listVacunaSeleccionada = new JList(modeloVacunaSeleccionada);
			
		}
		return listVacunaSeleccionada;
	}
}
