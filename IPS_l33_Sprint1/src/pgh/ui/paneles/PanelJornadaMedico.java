package pgh.ui.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;


import pgh.business.jornadamedico.CrearJornadaMedico;
import pgh.business.jornadamedico.JornadaMedico;
import pgh.business.jornadamedico.JornadaMedicoDTO;
import pgh.business.jornadamedico.ListaJornadasMedico;
import pgh.business.medico.EditarDiasVacaciones;
import pgh.business.medico.FindMedicoById;
import pgh.business.medico.ListaMedicos;
import pgh.business.medico.Medico;
import pgh.business.medico.MedicoDTO;
import pgh.ui.VentanaPrincipal;
import pgh.ui.paneles.filtros.JListFiltroJornadaMedicos;


import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import org.hsqldb.lib.tar.RB;

public class PanelJornadaMedico extends JPanel  {
	
	private JPanel panelAnterior;
	private JPanel panelJornadasMedico;
	private JButton btnAsignarJornadasMedicos;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_4_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6_1_1;
	private JLabel lblNewLabel_5_1_1;
	private JButton btnCrearJornadaMedico;
	private JButton btnCancelarJornadaMedico;
	private ListaMedicos lm;
	private JLabel lblNewLabel_5_1;
	private JDateChooser dateChooserFechaInicioJornadaMedico;
	private JDateChooser dateChooserFechaFinJornadaMedico;
	private JSpinner spinnerHoraInicioJornadamedico;
	private JSpinner spinnerHoraFinJornadamedico;
	private JSpinner spinnerMinutosFinJornadamedico_1;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_6_1;
	private JSpinner spinnerMinutosInicioJornadamedico;
	private JSpinner spinnerMinutosInicioJornadamedico2;
	private JSpinner spinnerMinutosFinJornadamedico2;
	private boolean fechaCambiada;
	private boolean fechaCambiada2;
	private CrearJornadaMedico crearJornadaMedico;
	private JornadaMedico jornadaMedico;
	private JornadaMedicoDTO jornadaMedicoDTO;
	private JScrollPane scrollPane;
	private JList listDias;
	private JButton btnAnadirDiasJornada;
	private JScrollPane scrollPaneDiasSeleccionados;
	private JButton btnBorrarDiasSeleccionados;
	private JList listMedicos;
	private DefaultListModel<Medico> modeloListMedicos;
	private DefaultListModel<String> modeloListDiasJornada;
	private DefaultListModel<String> modeloListDiasSeleccionadosJornadaMedico;
	private DefaultListModel<Medico> modeloListMedicosSeleccionadosJornada;
	private JList listDiasSeleccionadosJornadaMedico;
	private JScrollPane scrollPaneSeleccionarMedicoJornada;
	private JListFiltroJornadaMedicos listMedicosJornada;
	private JButton btnAnadirMedicoJornadas;
	private JScrollPane scrollPaneMedicoSeleccionadoJornada;
	private JList listMedicosSeleccionadosJornada;
	private JButton btnNewButton_1;
	private JTextField textFieldFiltro;
	private JLabel lblNewLabel;
	private JRadioButton rdbtnAutomaticamente;
	private JRadioButton rdbtnManualmente;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JSpinner spinnerDias;
	private Medico medico;
	private MedicoDTO medicoDTO;
	private EditarDiasVacaciones editarDias;
	

	
	public PanelJornadaMedico (JPanel panelAnterior) {
		
		this.panelAnterior = panelAnterior;
		getPanelJornadasMedico();
		
	}
	
	private void getPanelJornadasMedico() {
		
			this.setBackground(new Color(135, 206, 235));
			this.setLayout(null);
			this.add(getLblNewLabel_4());
			this.add(getLblNewLabel_4_1());
			this.add(getLblNewLabel_5());
			this.add(getLblNewLabel_6_1_1());
			this.add(getLblNewLabel_5_1_1());
			this.add(getBtnCrearJornadaMedico());
			this.add(getBtnCancelarJornadaMedico());
			this.add(getScrollPane());
			this.add(getBtnAnadirDiasJornada());
			this.add(getScrollPaneDiasSeleccionados());
			this.add(getBtnBorrarDiasSeleccionados());
			this.add(getScrollPaneSeleccionarMedicoJornada());
			this.add(getBtnAnadirMedicoJornadas());
			this.add(getScrollPaneMedicoSeleccionadoJornada());
			this.add(getBtnNewButton_1());
			this.add(getLblNewLabel_5_1_2());
			this.add(getDateChooserFechaInicioJornadaMedico());
			this.add(getDateChooserFechaFinJornadaMedico());
			this.add(getSpinnerHoraInicioJornadamedico());
			this.add(getSpinnerHoraFinJornadamedico());
			this.add(getSpinnerMinutosFinJornadamedico_1());
			this.add(getLblNewLabel_6());
			this.add(getLblNewLabel_6_1());
			this.add(getSpinnerMinutosInicioJornadamedico());
			this.add(getSpinnerMinutosInicioJornadamedico2());
			this.add(getSpinnerMinutosFinJornadamedico2());
			add(getLblNewLabel());
			add(getLabel_1());
			add(getPanel());
			add(getSpinnerDias());
	

		
		
	}
	
	
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Seleccionar Medico :");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_4.setBounds(72, 74, 147, 22);
		}
		return lblNewLabel_4;
	}

	private JLabel getLblNewLabel_4_1() {
		if (lblNewLabel_4_1 == null) {
			lblNewLabel_4_1 = new JLabel("Seleccionar dias a la semana :");
			lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_4_1.setBounds(85, 378, 200, 22);
		}
		return lblNewLabel_4_1;
	}

	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("Seleccionar dia inicio :");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5.setBounds(85, 189, 158, 22);
		}
		return lblNewLabel_5;
	}

	private JLabel getLblNewLabel_6_1_1() {
		if (lblNewLabel_6_1_1 == null) {
			lblNewLabel_6_1_1 = new JLabel("Seleccionar hora inicio :");
			lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_1_1.setBounds(430, 189, 158, 22);
		}
		return lblNewLabel_6_1_1;
	}

	private JLabel getLblNewLabel_5_1_1() {
		if (lblNewLabel_5_1_1 == null) {
			lblNewLabel_5_1_1 = new JLabel("Seleccionar hora fin :");
			lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5_1_1.setBounds(430, 257, 142, 22);
		}
		return lblNewLabel_5_1_1;
	}

	private JButton getBtnCrearJornadaMedico() {
		if (btnCrearJornadaMedico == null) {
			btnCrearJornadaMedico = new JButton("Crear jornada");
			btnCrearJornadaMedico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(modeloListMedicosSeleccionadosJornada.isEmpty()) {
						JOptionPane.showMessageDialog(getBtnCrearJornadaMedico(), "No has seleccionado ningun medico");
					}
					else {
						
						if(modeloListDiasSeleccionadosJornadaMedico.isEmpty()) {
							JOptionPane.showMessageDialog(getBtnCrearJornadaMedico(), "No has seleccionado ningun dia");
						}
						else {
							String dias="";
							int horaInicio = (int) spinnerHoraInicioJornadamedico.getValue();
							int horaFin = (int) spinnerHoraFinJornadamedico.getValue();
							int minutos1Inicio = (int) spinnerMinutosInicioJornadamedico.getValue();
							int minutos2Inicio = (int) spinnerMinutosInicioJornadamedico2.getValue();
							int minutos1Fin = (int) spinnerMinutosFinJornadamedico_1.getValue();
							int minutos2Fin = (int) spinnerMinutosFinJornadamedico2.getValue();
								
							if (comprobarCorrecto(horaInicio, horaFin, minutos1Inicio, minutos2Inicio, minutos1Fin,
									minutos2Fin)) {

								crearJornadaMedico = new CrearJornadaMedico();
								jornadaMedicoDTO = new JornadaMedicoDTO();
								jornadaMedicoDTO.idJornadaMedico = generarIdJornadaMedico();
								jornadaMedicoDTO.diaInicio = dateChooserFechaInicioJornadaMedico.getDate();
								jornadaMedicoDTO.diaFin = dateChooserFechaFinJornadaMedico.getDate();
								for (int i = 0; i < modeloListDiasSeleccionadosJornadaMedico.getSize(); i++) {
									if(i== modeloListDiasSeleccionadosJornadaMedico.getSize()-1) {
										dias = dias + modeloListDiasSeleccionadosJornadaMedico.getElementAt(i).toString();
									}
									else {
										dias = dias + modeloListDiasSeleccionadosJornadaMedico.getElementAt(i).toString() + ", ";
									}
									
								} 
								
								jornadaMedicoDTO.dias = dias;
							

								String hora1 = horaInicio + "";
								String hora2 = horaFin + "";
								String minutos1 = minutos1Inicio + "";
								String minutos2 = minutos2Inicio + "";
								String minutos3 = minutos1Fin + "";
								String minutos4 = minutos2Fin + "";
								String horaInicial = hora1 + ":" + minutos1 + minutos2;
								String horaFinal = hora2 + ":" + minutos3 + minutos4;

								jornadaMedicoDTO.horaInicio = horaInicial;
								jornadaMedicoDTO.horaFin = horaFinal;
								
								jornadaMedicoDTO.idMedico= modeloListMedicosSeleccionadosJornada.getElementAt(0).getIdMedico();
								
								jornadaMedico= new JornadaMedico(jornadaMedicoDTO);
								
								crearJornadaMedico.crearJornadaMedico(jornadaMedico);
								
								editarDias = new EditarDiasVacaciones();
								
								if(rdbtnManualmente.isSelected()) {
									editarDias.actualizar((int) spinnerDias.getValue() + modeloListMedicosSeleccionadosJornada.getElementAt(0).getDiasDisponibles(), modeloListMedicosSeleccionadosJornada.getElementAt(0).getIdMedico());
								}
								
								if(rdbtnAutomaticamente.isSelected()) {
									
									Date fechaInicio = dateChooserFechaInicioJornadaMedico.getDate();
									Date fechaFin = dateChooserFechaFinJornadaMedico.getDate();

									int milisecondsByDay = 86400000;
									int diass = (int) ((fechaFin.getTime() - fechaInicio.getTime()) / milisecondsByDay);
									
									double diasVacaciones = (diass/30) * 2.5;
									int diaaaaas = (int) diasVacaciones + modeloListMedicosSeleccionadosJornada.getElementAt(0).getDiasDisponibles() ; 
									
									
									editarDias.actualizar(diaaaaas, modeloListMedicosSeleccionadosJornada.getElementAt(0).getIdMedico());
									

								}
								
								closePanel();
								
								spinnerHoraInicioJornadamedico.setValue(0);;
								spinnerHoraFinJornadamedico.setValue(0);
								spinnerMinutosInicioJornadamedico.setValue(0);
								spinnerMinutosInicioJornadamedico2.setValue(0);
								spinnerMinutosFinJornadamedico_1.setValue(0);
								spinnerMinutosFinJornadamedico2.setValue(0);
								
								
								modeloListMedicosSeleccionadosJornada.removeAllElements();
								modeloListDiasSeleccionadosJornadaMedico.removeAllElements();
						}
						
						
						
					}

					
						

					}
					
					
					

				}
			});
			btnCrearJornadaMedico.setFocusable(false);
			btnCrearJornadaMedico.setForeground(new Color(0, 128, 0));
			btnCrearJornadaMedico.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCrearJornadaMedico.setBounds(841, 527, 127, 23);
		}
		return btnCrearJornadaMedico;
	}
	
	private int generarIdJornadaMedico() {
		ListaJornadasMedico lc = new ListaJornadasMedico(0);
		lc.creaJornadaMedico();
		return 2200 + lc.getJornadasMedicos().size();
	}
	
	private boolean comprobarCorrecto(int horaInicio,int horaFin,int minutos1Inicio,int minutos2Inicio ,int minutos1Fin, int minutos2Fin ) {
		
		if (fechaCambiada == true && fechaCambiada2 == false) {
			JOptionPane.showMessageDialog(getBtnCrearJornadaMedico(),"La fecha final de la jornada no puede ser anterior a la fecha inicial");
			return false;
			
		} else {
			if (dateChooserFechaInicioJornadaMedico.getDate().toString().contains(dateChooserFechaFinJornadaMedico.getDate().toString())) {
	
				if (horaInicio >= horaFin) {
					if (minutos1Inicio >= minutos1Fin) {
						if (minutos2Inicio >= minutos2Fin) {
							JOptionPane.showMessageDialog(getBtnCrearJornadaMedico(),"La hora final de la jornada no puede ser anterior a la hora inicial");
							return false;
						}
					}
				}

			}
		}
		
		return true;
		
	}

	private JButton getBtnCancelarJornadaMedico() {
		if (btnCancelarJornadaMedico == null) {
			btnCancelarJornadaMedico = new JButton("Cancelar");
			btnCancelarJornadaMedico.setFocusable(false);
			btnCancelarJornadaMedico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListMedicosSeleccionadosJornada.removeAllElements();
					modeloListDiasSeleccionadosJornadaMedico.removeAllElements();
					closePanel();
				}
			});
			btnCancelarJornadaMedico.setForeground(new Color(255, 0, 0));
			btnCancelarJornadaMedico.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCancelarJornadaMedico.setBounds(981, 527, 102, 23);
		}
		return btnCancelarJornadaMedico;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(315, 340, 88, 127);
			scrollPane.setViewportView(getListDias());
		}
		return scrollPane;
	}

	private JList getListDias() {
		if (listDias == null) {
			modeloListDiasJornada = new DefaultListModel();
			listDias = new JList(modeloListDiasJornada);
			modeloListDiasJornada.addElement("Lunes");
			modeloListDiasJornada.addElement("Martes");
			modeloListDiasJornada.addElement("Miercoles");
			modeloListDiasJornada.addElement("Jueves");
			modeloListDiasJornada.addElement("Viernes");
			modeloListDiasJornada.addElement("Sabado");
			modeloListDiasJornada.addElement("Domingo");
		}
		return listDias;
	}

	private JButton getBtnAnadirDiasJornada() {
		if (btnAnadirDiasJornada == null) {
			btnAnadirDiasJornada = new JButton("A\u00F1adir dias");
			btnAnadirDiasJornada.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					for (Object o : listDias.getSelectedValuesList()) {
						if (!modeloListDiasSeleccionadosJornadaMedico.contains(o)) {
							modeloListDiasSeleccionadosJornadaMedico.addElement((String) o);
						}
					}

				}
			});
			btnAnadirDiasJornada.setBounds(430, 389, 113, 23);
		}
		return btnAnadirDiasJornada;
	}

	private JScrollPane getScrollPaneDiasSeleccionados() {
		if (scrollPaneDiasSeleccionados == null) {
			scrollPaneDiasSeleccionados = new JScrollPane();
			scrollPaneDiasSeleccionados.setBounds(574, 361, 207, 86);
			scrollPaneDiasSeleccionados.setViewportView(getListDiasSeleccionadosJornadaMedico());
		}
		return scrollPaneDiasSeleccionados;
	}

	private JButton getBtnBorrarDiasSeleccionados() {
		if (btnBorrarDiasSeleccionados == null) {
			btnBorrarDiasSeleccionados = new JButton("Borrar dias");
			btnBorrarDiasSeleccionados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					modeloListDiasSeleccionadosJornadaMedico.removeAllElements();

				}
			});
			btnBorrarDiasSeleccionados.setBounds(574, 458, 207, 23);
		}
		return btnBorrarDiasSeleccionados;
	}

	private JList getListMedicos() {
		if (listMedicos == null) {
			modeloListMedicos = new DefaultListModel();
			listMedicos = new JList(modeloListMedicos);
			anadirMedicosALaLista();
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

	private JList getListDiasSeleccionadosJornadaMedico() {
		if (listDiasSeleccionadosJornadaMedico == null) {
			modeloListDiasSeleccionadosJornadaMedico = new DefaultListModel();
			listDiasSeleccionadosJornadaMedico = new JList(modeloListDiasSeleccionadosJornadaMedico);
		}
		return listDiasSeleccionadosJornadaMedico;
	}
	
	private JScrollPane getScrollPaneSeleccionarMedicoJornada() {
		if (scrollPaneSeleccionarMedicoJornada == null) {
			scrollPaneSeleccionarMedicoJornada = new JScrollPane();
			scrollPaneSeleccionarMedicoJornada.setBounds(229, 57, 261, 77);
			scrollPaneSeleccionarMedicoJornada.setViewportView(getListMedicosJornada());
		}
		return scrollPaneSeleccionarMedicoJornada;
	}

	private JList getListMedicosJornada() {
		if (listMedicosJornada == null) {
			modeloListMedicos = new DefaultListModel();
			anadirMedicosALaLista();
			listMedicosJornada = new JListFiltroJornadaMedicos(modeloListMedicos); //CREAR A JLISTFILTRADO NO JLIST Y CAMBIAR ARRIBA LA INICIALIZACION
			this.add(listMedicosJornada.gettextoFiltro()); //AÑADIR ESO PARA QUE SALGA EL CUADRO PARA ESCRIBIR
			listMedicosJornada.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			

		}
		return listMedicosJornada;
	}

	private JButton getBtnAnadirMedicoJornadas() {
		if (btnAnadirMedicoJornadas == null) {
			btnAnadirMedicoJornadas = new JButton("A\u00F1adir");
			btnAnadirMedicoJornadas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (modeloListMedicosSeleccionadosJornada.getSize() < 1) {
						if (!modeloListMedicosSeleccionadosJornada
								.contains((Medico) listMedicosJornada.getSelectedValue())) {
							modeloListMedicosSeleccionadosJornada
									.addElement((Medico) listMedicosJornada.getSelectedValue());
						}
					}

				}
			});
			btnAnadirMedicoJornadas.setBounds(509, 86, 89, 23);
		}
		return btnAnadirMedicoJornadas;
	}

	private JScrollPane getScrollPaneMedicoSeleccionadoJornada() {
		if (scrollPaneMedicoSeleccionadoJornada == null) {
			scrollPaneMedicoSeleccionadoJornada = new JScrollPane();
			scrollPaneMedicoSeleccionadoJornada.setBounds(615, 57, 269, 77);
			scrollPaneMedicoSeleccionadoJornada.setViewportView(getListMedicosSeleccionadosJornada());
		}
		return scrollPaneMedicoSeleccionadoJornada;
	}

	private JList getListMedicosSeleccionadosJornada() {
		if (listMedicosSeleccionadosJornada == null) {
			modeloListMedicosSeleccionadosJornada = new DefaultListModel();
			listMedicosSeleccionadosJornada = new JList(modeloListMedicosSeleccionadosJornada);
		}
		return listMedicosSeleccionadosJornada;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Borrar Medico");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					modeloListMedicosSeleccionadosJornada.removeAllElements();
				}
			});
			btnNewButton_1.setBounds(894, 86, 115, 23);
		}
		return btnNewButton_1;
	}
	
	private JLabel getLblNewLabel_5_1_2() {
		if (lblNewLabel_5_1 == null) {
			lblNewLabel_5_1 = new JLabel("Seleccionar dia fin :");
			lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5_1.setBounds(99, 257, 158, 22);
		}
		return lblNewLabel_5_1;
	}
	private JDateChooser getDateChooserFechaInicioJornadaMedico() {
		if (dateChooserFechaInicioJornadaMedico == null) {
			dateChooserFechaInicioJornadaMedico = new JDateChooser();
			dateChooserFechaInicioJornadaMedico.setBounds(229, 189, 102, 20);
			
			Calendar fecha = new GregorianCalendar();
			
			fechaCambiada=false;

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
				dateChooserFechaInicioJornadaMedico.setDate(date2);
				dateChooserFechaInicioJornadaMedico.getJCalendar().setMinSelectableDate(date2);
				((JTextFieldDateEditor) dateChooserFechaInicioJornadaMedico.getDateEditor()).setEditable(false);
				

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			dateChooserFechaInicioJornadaMedico.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					fechaCambiada=true;
				}
			});

		}
		return dateChooserFechaInicioJornadaMedico;
	}
	
	private JDateChooser getDateChooserFechaFinJornadaMedico() {
		if (dateChooserFechaFinJornadaMedico == null) {
			dateChooserFechaFinJornadaMedico = new JDateChooser();
			
			Calendar fecha = new GregorianCalendar();
			
			fechaCambiada2=false;

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
				dateChooserFechaFinJornadaMedico.setDate(date2);
				dateChooserFechaFinJornadaMedico.getJCalendar().setMinSelectableDate(date2);
				((JTextFieldDateEditor) dateChooserFechaFinJornadaMedico.getDateEditor()).setEditable(false);
				

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			dateChooserFechaFinJornadaMedico.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dateChooserFechaFinJornadaMedico.setDate(dateChooserFechaInicioJornadaMedico.getDate());
					dateChooserFechaFinJornadaMedico.getJCalendar().setMinSelectableDate(dateChooserFechaInicioJornadaMedico.getDate());
					((JTextFieldDateEditor) dateChooserFechaFinJornadaMedico.getDateEditor()).setEditable(false);
					fechaCambiada2=true;
				}
			});
			dateChooserFechaFinJornadaMedico.setBounds(229, 257, 102, 20);
			

			

			
		}
		return dateChooserFechaFinJornadaMedico;
	}
	private JSpinner getSpinnerHoraInicioJornadamedico() {
		if (spinnerHoraInicioJornadamedico == null) {
			spinnerHoraInicioJornadamedico = new JSpinner();
			spinnerHoraInicioJornadamedico.setModel(new SpinnerNumberModel(0, 0, 23, 1));
			spinnerHoraInicioJornadamedico.setBounds(598, 191, 48, 20);
		}
		return spinnerHoraInicioJornadamedico;
	}
	private JSpinner getSpinnerHoraFinJornadamedico() {
		if (spinnerHoraFinJornadamedico == null) {
			spinnerHoraFinJornadamedico = new JSpinner();
			spinnerHoraFinJornadamedico.setModel(new SpinnerNumberModel(0, 0, 23, 1));
			spinnerHoraFinJornadamedico.setBounds(598, 259, 48, 20);
		}
		return spinnerHoraFinJornadamedico;
	}
	private JSpinner getSpinnerMinutosFinJornadamedico_1() {
		if (spinnerMinutosFinJornadamedico_1 == null) {
			spinnerMinutosFinJornadamedico_1 = new JSpinner();
			spinnerMinutosFinJornadamedico_1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
			spinnerMinutosFinJornadamedico_1.setBounds(672, 259, 48, 20);
		}
		return spinnerMinutosFinJornadamedico_1;
	}
	
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel(":");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6.setBounds(656, 193, 30, 14);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_6_1() {
		if (lblNewLabel_6_1 == null) {
			lblNewLabel_6_1 = new JLabel(":");
			lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_1.setBounds(656, 262, 30, 14);
		}
		return lblNewLabel_6_1;
	}
	private JSpinner getSpinnerMinutosInicioJornadamedico() {
		if (spinnerMinutosInicioJornadamedico == null) {
			spinnerMinutosInicioJornadamedico = new JSpinner();
			spinnerMinutosInicioJornadamedico.setModel(new SpinnerNumberModel(0, 0, 5, 1));
			spinnerMinutosInicioJornadamedico.setBounds(672, 191, 48, 20);
		}
		return spinnerMinutosInicioJornadamedico;
	}
	private JSpinner getSpinnerMinutosInicioJornadamedico2() {
		if (spinnerMinutosInicioJornadamedico2 == null) {
			spinnerMinutosInicioJornadamedico2 = new JSpinner();
			spinnerMinutosInicioJornadamedico2.setModel(new SpinnerNumberModel(0, 0, 9, 1));
			spinnerMinutosInicioJornadamedico2.setBounds(730, 191, 48, 20);
		}
		return spinnerMinutosInicioJornadamedico2;
	}
	private JSpinner getSpinnerMinutosFinJornadamedico2() {
		if (spinnerMinutosFinJornadamedico2 == null) {
			spinnerMinutosFinJornadamedico2 = new JSpinner();
			spinnerMinutosFinJornadamedico2.setModel(new SpinnerNumberModel(0, 0, 9, 1));
			spinnerMinutosFinJornadamedico2.setBounds(730, 259, 48, 20);
		}
		return spinnerMinutosFinJornadamedico2;
	}
	
	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Filtro sensible a MAYUSCULAS");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setBounds(26, 18, 200, 50);
		}
		return lblNewLabel;
	}
	private JRadioButton getRadioButton_1() {
		if (rdbtnAutomaticamente == null) {
			rdbtnAutomaticamente = new JRadioButton("Automaticamente");
			rdbtnAutomaticamente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					rdbtnAutomaticamente.setSelected(true);
					rdbtnManualmente.setSelected(false);
					spinnerDias.setEnabled(false);
					
					
				}
			});
			rdbtnAutomaticamente.setSelected(true);
			rdbtnAutomaticamente.setBackground(new Color(135, 206, 235));
		}
		return rdbtnAutomaticamente;
	}
	private JRadioButton getRdbtnManualmente() {
		if (rdbtnManualmente == null) {
			rdbtnManualmente = new JRadioButton("Manualmente");
			rdbtnManualmente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnAutomaticamente.setSelected(false);
					rdbtnManualmente.setSelected(true);
					spinnerDias.setEnabled(true);
				}
			});
			rdbtnManualmente.setBackground(new Color(135, 206, 235));
		}
		return rdbtnManualmente;
	}
	private JLabel getLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Numeros de dias de vacaciones : ");
			lblNewLabel_1.setBounds(820, 298, 188, 56);
		}
		return lblNewLabel_1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Designar dias de vacaciones ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(820, 189, 263, 98);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			panel.add(getRadioButton_1());
			panel.add(getRdbtnManualmente());
		}
		return panel;
	}
	private JSpinner getSpinnerDias() {
		if (spinnerDias == null) {
			spinnerDias = new JSpinner();
			spinnerDias.setEnabled(false);
			spinnerDias.setBounds(1006, 312, 62, 28);
		}
		return spinnerDias;
	}
}
