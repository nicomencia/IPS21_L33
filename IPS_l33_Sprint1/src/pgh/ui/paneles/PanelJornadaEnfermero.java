package pgh.ui.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import javax.swing.SpinnerNumberModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import pgh.business.enfermero.EditarDiasVacacionesEnfermero;
import pgh.business.enfermero.Enfermero;
import pgh.business.enfermero.ListaEnfermeros;
import pgh.business.jornadaenfermero.CrearJornadaEnfermero;
import pgh.business.jornadaenfermero.JornadaEnfermero;
import pgh.business.jornadaenfermero.JornadaEnfermeroDTO;
import pgh.business.jornadaenfermero.ListaJornadasEnfermero;
import pgh.business.medico.EditarDiasVacaciones;
import pgh.business.medico.Medico;
import pgh.business.medico.MedicoDTO;
import pgh.ui.VentanaPrincipal;
import pgh.ui.paneles.filtros.JListFiltroJornadaEnfermeros;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JRadioButton;

public class PanelJornadaEnfermero extends JPanel {

	private JPanel panelAnterior;
	private boolean fechaCambiada4;
	private boolean fechaCambiada3;

	private ListaEnfermeros le;
	private CrearJornadaEnfermero crearJornadaEnfermero;
	private JornadaEnfermero jornadaEnfermero;
	private JornadaEnfermeroDTO jornadaEnfermeroDTO;
	private JPanel panelJornadasEnfermero;
	private JLabel lblNewLabel_4_2;
	private JLabel lblNewLabel_4_1_1;
	private JLabel lblNewLabel_5_2;
	private JLabel lblNewLabel_6_1_1_1;
	private JLabel lblNewLabel_5_1_1_1;
	private JButton btnCrearJornadaEnfermero;
	private JButton btnCancelarJornadaEnfermero;
	private JScrollPane scrollPane_8;
	private JButton btnAnadirDiasJornadaEnfermero;
	private JScrollPane scrollPaneDiasSeleccionados_1;
	private JButton btnBorrarDiasSeleccionadosJornadaEnfermero;
	private JScrollPane scrollPaneSeleccionarEnfermero;
	private JButton btnAnadirEnfermeroJornadas;
	private JScrollPane scrollPaneEnfermeroSeleccionadoJornada_1;
	private JButton btnBorrarEnfermeroJornadas;
	private JLabel lblNewLabel_5_1_2;
	private JDateChooser dateChooserFechaInicioJornadaEnfermero;
	private JDateChooser dateChooserFechaFinJornadaEnfermero;
	private JSpinner spinnerHoraInicioJornadaEnfermero;
	private JSpinner spinnerHoraFinJornadaEnfermero;
	private JSpinner spinnerMinutosFinJornadaeEnfermero;
	private JLabel lblNewLabel_6_2;
	private JLabel lblNewLabel_6_1_2;

	private JSpinner spinnerMinutosInicioJornadaEnfermero;
	private JSpinner spinnerMinutosInicioJornadaEnfermero2;
	private JSpinner spinnerMinutosFinJornadaEnfermero2;
	private JListFiltroJornadaEnfermeros listEnfermerosJornada;
	private JList listEnfermerosSeleccionadosJornada;
	private JList listDiasSemanaJornadaEnfermero;
	private JList listDiasSeleccionadosJornadaEnfermero;
	private DefaultListModel<Enfermero> modeloListaEnfermerosJornada;
	private DefaultListModel<Enfermero> modeloListaEnfermerosSeleccionadosJornada;
	private DefaultListModel<String> modeloDiasSemanaJornadaEnfermero;
	private DefaultListModel<String> modeloDiasSemanaSeleccionadosJornadaEnfermero;
	private JRadioButton rdbtnAutomaticamente;
	private JRadioButton rdbtnManualmente;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JSpinner spinnerDias;
	private Medico medico;
	private MedicoDTO medicoDTO;
	private EditarDiasVacacionesEnfermero editarDias;

	public PanelJornadaEnfermero(JPanel panelAnterior) {

		this.panelAnterior = panelAnterior;
		getPanelJornadasEnfermero();

	}

	private void getPanelJornadasEnfermero() {

		this.setBackground(new Color(135, 206, 235));
		setLayout(null);
		this.add(getLblNewLabel_4_2());
		this.add(getLblNewLabel_4_1_1());
		this.add(getLblNewLabel_5_2_1());
		this.add(getLblNewLabel_6_1_1_1());
		this.add(getLblNewLabel_5_1_1_1());
		this.add(getBtnCrearJornadaEnfermero());
		this.add(getBtnCancelarJornadaEnfermero());
		this.add(getScrollPane_8_1());
		this.add(getBtnAnadirDiasJornadaEnfermero());
		this.add(getScrollPaneDiasSeleccionados_1());
		this.add(getBtnBorrarDiasSeleccionadosJornadaEnfermero());
		this.add(getScrollPaneSeleccionarEnfermero());
		this.add(getBtnAnadirEnfermeroJornadas());
		this.add(getScrollPaneEnfermeroSeleccionadoJornada_1());
		this.add(getBtnBorrarEnfermeroJornadas());
		this.add(getLblNewLabel_5_1_2_2());
		this.add(getDateChooserFechaInicioJornadaEnfermero());
		this.add(getDateChooserFechaFinJornadaEnfermero());
		this.add(getSpinnerHoraInicioJornadaEnfermero());
		this.add(getSpinnerHoraFinJornadaEnfermero());
		this.add(getSpinnerMinutosFinJornadaeEnfermero());
		this.add(getLblNewLabel_6_2());
		this.add(getLblNewLabel_6_1_2());
		this.add(getSpinnerMinutosInicioJornadaEnfermero());
		this.add(getSpinnerMinutosInicioJornadaEnfermero2());
		this.add(getSpinnerMinutosFinJornadaEnfermero2());
		add(getLabel_1());
		add(getPanel());
		add(getSpinnerDias());

		
	}

	private JLabel getLblNewLabel_4_2() {
		if (lblNewLabel_4_2 == null) {
			lblNewLabel_4_2 = new JLabel("Seleccionar Enfermero :");
			lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_4_2.setBounds(29, 73, 190, 22);
		}
		return lblNewLabel_4_2;
	}

	private JLabel getLblNewLabel_4_1_1() {
		if (lblNewLabel_4_1_1 == null) {
			lblNewLabel_4_1_1 = new JLabel("Seleccionar dias a la semana :");
			lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_4_1_1.setBounds(171, 386, 200, 22);
		}
		return lblNewLabel_4_1_1;
	}

	private JLabel getLblNewLabel_5_2_1() {
		if (lblNewLabel_5_2 == null) {
			lblNewLabel_5_2 = new JLabel("Seleccionar dia inicio :");
			lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5_2.setBounds(78, 199, 158, 22);
		}
		return lblNewLabel_5_2;
	}

	private JLabel getLblNewLabel_6_1_1_1() {
		if (lblNewLabel_6_1_1_1 == null) {
			lblNewLabel_6_1_1_1 = new JLabel("Seleccionar hora inicio :");
			lblNewLabel_6_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_1_1_1.setBounds(393, 199, 158, 22);
		}
		return lblNewLabel_6_1_1_1;
	}

	private JLabel getLblNewLabel_5_1_1_1() {
		if (lblNewLabel_5_1_1_1 == null) {
			lblNewLabel_5_1_1_1 = new JLabel("Seleccionar hora fin :");
			lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5_1_1_1.setBounds(393, 267, 142, 22);
		}
		return lblNewLabel_5_1_1_1;
	}

	private JButton getBtnCrearJornadaEnfermero() {
		if (btnCrearJornadaEnfermero == null) {
			btnCrearJornadaEnfermero = new JButton("Crear jornada");
			btnCrearJornadaEnfermero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					
					if(modeloListaEnfermerosSeleccionadosJornada.isEmpty()) {
						JOptionPane.showMessageDialog(getBtnCrearJornadaEnfermero(), "No has seleccionado ningun medico");
					}
					else {
						
						if(modeloDiasSemanaSeleccionadosJornadaEnfermero.isEmpty()) {
							JOptionPane.showMessageDialog(getBtnCrearJornadaEnfermero(), "No has seleccionado ningun dia");
						}
						else {
							String dias = "";
							int horaInicio = (int) spinnerHoraInicioJornadaEnfermero.getValue();
							int horaFin = (int) spinnerHoraFinJornadaEnfermero.getValue();
							int minutos1Inicio = (int) spinnerMinutosInicioJornadaEnfermero.getValue();
							int minutos2Inicio = (int) spinnerMinutosInicioJornadaEnfermero2.getValue();
							int minutos1Fin = (int) spinnerMinutosFinJornadaeEnfermero.getValue();
							int minutos2Fin = (int) spinnerMinutosFinJornadaEnfermero2.getValue();

							if (comprobarCorrecto2(horaInicio, horaFin, minutos1Inicio, minutos2Inicio, minutos1Fin,
									minutos2Fin)) {

								crearJornadaEnfermero = new CrearJornadaEnfermero();
								jornadaEnfermeroDTO = new JornadaEnfermeroDTO();
								jornadaEnfermeroDTO.idJornadaEnfermero = generarIdJornadaEnfermero();
								jornadaEnfermeroDTO.diaInicio = dateChooserFechaInicioJornadaEnfermero.getDate();
								jornadaEnfermeroDTO.diaFin = dateChooserFechaFinJornadaEnfermero.getDate();
								for (int i = 0; i < modeloDiasSemanaSeleccionadosJornadaEnfermero.getSize(); i++) {
									if (i == modeloDiasSemanaSeleccionadosJornadaEnfermero.getSize() - 1) {
										dias = dias + modeloDiasSemanaSeleccionadosJornadaEnfermero.getElementAt(i).toString();
									} else {
										dias = dias + modeloDiasSemanaSeleccionadosJornadaEnfermero.getElementAt(i).toString()
												+ ", ";
									}

								}

								jornadaEnfermeroDTO.dias = dias;

								String hora1 = horaInicio + "";
								String hora2 = horaFin + "";
								String minutos1 = minutos1Inicio + "";
								String minutos2 = minutos2Inicio + "";
								String minutos3 = minutos1Fin + "";
								String minutos4 = minutos2Fin + "";
								String horaInicial = hora1 + ":" + minutos1 + minutos2;
								String horaFinal = hora2 + ":" + minutos3 + minutos4;

								jornadaEnfermeroDTO.horaInicio = horaInicial;
								jornadaEnfermeroDTO.horaFin = horaFinal;

								jornadaEnfermeroDTO.idEnfermero = modeloListaEnfermerosSeleccionadosJornada.getElementAt(0)
										.getIdEnfermero();

								jornadaEnfermero = new JornadaEnfermero(jornadaEnfermeroDTO);

								crearJornadaEnfermero.crearJornadaEnfermero(jornadaEnfermero);

								spinnerHoraInicioJornadaEnfermero.setValue(0);
								;
								spinnerHoraFinJornadaEnfermero.setValue(0);
								spinnerMinutosInicioJornadaEnfermero.setValue(0);
								spinnerMinutosInicioJornadaEnfermero2.setValue(0);
								spinnerMinutosFinJornadaeEnfermero.setValue(0);
								spinnerMinutosFinJornadaEnfermero2.setValue(0);
								
								editarDias = new EditarDiasVacacionesEnfermero();
								
								if(rdbtnManualmente.isSelected()) {
									editarDias.actualizar((int) spinnerDias.getValue() + modeloListaEnfermerosSeleccionadosJornada.getElementAt(0).getDiasDisponibles(), modeloListaEnfermerosSeleccionadosJornada.getElementAt(0).getIdEnfermero());
								}
								
								if(rdbtnAutomaticamente.isSelected()) {
									
									Date fechaInicio = dateChooserFechaInicioJornadaEnfermero.getDate();
									Date fechaFin = dateChooserFechaFinJornadaEnfermero.getDate();

									int milisecondsByDay = 86400000;
									int diass = (int) ((fechaFin.getTime() - fechaInicio.getTime()) / milisecondsByDay);
									
									double diasVacaciones = (diass/30) * 2.5;
									int diaaaaas = (int) diasVacaciones + modeloListaEnfermerosSeleccionadosJornada.getElementAt(0).getDiasDisponibles();
									
									
									editarDias.actualizar(diaaaaas, modeloListaEnfermerosSeleccionadosJornada.getElementAt(0).getIdEnfermero());
									

								}
								

								modeloListaEnfermerosSeleccionadosJornada.removeAllElements();
								modeloDiasSemanaSeleccionadosJornadaEnfermero.removeAllElements();
								
								

								closePanel();

						}
						}
					
					}

				}
			});
			btnCrearJornadaEnfermero.setForeground(new Color(0, 128, 0));
			btnCrearJornadaEnfermero.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCrearJornadaEnfermero.setFocusable(false);
			btnCrearJornadaEnfermero.setBounds(841, 527, 127, 23);
		}
		return btnCrearJornadaEnfermero;
	}

	private int generarIdJornadaEnfermero() {
		ListaJornadasEnfermero lc = new ListaJornadasEnfermero(0);
		lc.creaJornadaEnfermeros();
		return 2200 + lc.getJornadasEnfermeros().size();
	}

	private JButton getBtnCancelarJornadaEnfermero() {
		if (btnCancelarJornadaEnfermero == null) {
			btnCancelarJornadaEnfermero = new JButton("Cancelar");
			btnCancelarJornadaEnfermero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					closePanel();
				}
			});
			btnCancelarJornadaEnfermero.setForeground(Color.RED);
			btnCancelarJornadaEnfermero.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCancelarJornadaEnfermero.setFocusable(false);
			btnCancelarJornadaEnfermero.setBounds(981, 527, 102, 23);
		}
		return btnCancelarJornadaEnfermero;
	}

	private JScrollPane getScrollPane_8_1() {
		if (scrollPane_8 == null) {
			scrollPane_8 = new JScrollPane();
			scrollPane_8.setBounds(381, 343, 88, 127);
			scrollPane_8.setViewportView(getListDiasSemanaJornadaEnfermero());
		}
		return scrollPane_8;
	}

	private JButton getBtnAnadirDiasJornadaEnfermero() {
		if (btnAnadirDiasJornadaEnfermero == null) {
			btnAnadirDiasJornadaEnfermero = new JButton("A\u00F1adir dias");
			btnAnadirDiasJornadaEnfermero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (Object o : listDiasSemanaJornadaEnfermero.getSelectedValuesList()) {
						if (!modeloDiasSemanaSeleccionadosJornadaEnfermero.contains(o)) {
							modeloDiasSemanaSeleccionadosJornadaEnfermero.addElement((String) o);
						}
					}
				}
			});
			btnAnadirDiasJornadaEnfermero.setBounds(479, 387, 113, 23);
		}
		return btnAnadirDiasJornadaEnfermero;
	}

	private JScrollPane getScrollPaneDiasSeleccionados_1() {
		if (scrollPaneDiasSeleccionados_1 == null) {
			scrollPaneDiasSeleccionados_1 = new JScrollPane();
			scrollPaneDiasSeleccionados_1.setBounds(602, 357, 207, 86);
			scrollPaneDiasSeleccionados_1.setViewportView(getListDiasSeleccionadosJornadaEnfermero());
		}
		return scrollPaneDiasSeleccionados_1;
	}

	private JButton getBtnBorrarDiasSeleccionadosJornadaEnfermero() {
		if (btnBorrarDiasSeleccionadosJornadaEnfermero == null) {
			btnBorrarDiasSeleccionadosJornadaEnfermero = new JButton("Borrar dias");
			btnBorrarDiasSeleccionadosJornadaEnfermero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloDiasSemanaSeleccionadosJornadaEnfermero.removeAllElements();
				}
			});
			btnBorrarDiasSeleccionadosJornadaEnfermero.setBounds(819, 387, 126, 23);
		}
		return btnBorrarDiasSeleccionadosJornadaEnfermero;
	}

	private JScrollPane getScrollPaneSeleccionarEnfermero() {
		if (scrollPaneSeleccionarEnfermero == null) {
			scrollPaneSeleccionarEnfermero = new JScrollPane();
			scrollPaneSeleccionarEnfermero.setBounds(229, 57, 261, 77);
			scrollPaneSeleccionarEnfermero.setViewportView(getListEnfermerosJornada());
		}
		return scrollPaneSeleccionarEnfermero;
	}

	private JButton getBtnAnadirEnfermeroJornadas() {
		if (btnAnadirEnfermeroJornadas == null) {
			btnAnadirEnfermeroJornadas = new JButton("A\u00F1adir");
			btnAnadirEnfermeroJornadas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					for (Object o : listEnfermerosJornada.getSelectedValuesList()) {
						if (modeloListaEnfermerosSeleccionadosJornada.getSize() < 1) {
							if (!modeloListaEnfermerosSeleccionadosJornada.contains(o)) {
								modeloListaEnfermerosSeleccionadosJornada.addElement((Enfermero) o);
							}
						}
					}

				}
			});
			btnAnadirEnfermeroJornadas.setBounds(509, 86, 89, 23);
		}
		return btnAnadirEnfermeroJornadas;
	}

	private JScrollPane getScrollPaneEnfermeroSeleccionadoJornada_1() {
		if (scrollPaneEnfermeroSeleccionadoJornada_1 == null) {
			scrollPaneEnfermeroSeleccionadoJornada_1 = new JScrollPane();
			scrollPaneEnfermeroSeleccionadoJornada_1.setBounds(615, 57, 269, 77);
			scrollPaneEnfermeroSeleccionadoJornada_1.setViewportView(getListEnfermerosSeleccionadosJornada());
		}
		return scrollPaneEnfermeroSeleccionadoJornada_1;
	}

	private JButton getBtnBorrarEnfermeroJornadas() {
		if (btnBorrarEnfermeroJornadas == null) {
			btnBorrarEnfermeroJornadas = new JButton("Borrar Enfermero");
			btnBorrarEnfermeroJornadas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListaEnfermerosSeleccionadosJornada.removeAllElements();
				}
			});
			btnBorrarEnfermeroJornadas.setBounds(894, 86, 158, 23);
		}
		return btnBorrarEnfermeroJornadas;
	}

	private JLabel getLblNewLabel_5_1_2_2() {
		if (lblNewLabel_5_1_2 == null) {
			lblNewLabel_5_1_2 = new JLabel("Seleccionar dia fin :");
			lblNewLabel_5_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5_1_2.setBounds(92, 267, 158, 22);
		}
		return lblNewLabel_5_1_2;
	}

	private JDateChooser getDateChooserFechaInicioJornadaEnfermero() {
		if (dateChooserFechaInicioJornadaEnfermero == null) {
			dateChooserFechaInicioJornadaEnfermero = new JDateChooser();

			dateChooserFechaInicioJornadaEnfermero.setBounds(222, 199, 102, 20);
			Calendar fecha = new GregorianCalendar();

			fechaCambiada3 = false;

			int dia = fecha.get(Calendar.DAY_OF_MONTH);
			int mes = 0;
			if (Calendar.MONTH == 12) {
				mes = fecha.get(Calendar.MONTH) - 11;
			} else {
				mes = fecha.get(Calendar.MONTH) + 1;
			}

			int ano = fecha.get(Calendar.YEAR);

			SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy/MM/dd");
			Date date2 = new Date();
			try {
				date2 = dateformat3.parse(ano + "/" + mes + "/" + dia);
				dateChooserFechaInicioJornadaEnfermero.setDate(date2);
				dateChooserFechaInicioJornadaEnfermero.getJCalendar().setMinSelectableDate(date2);
				((JTextFieldDateEditor) dateChooserFechaInicioJornadaEnfermero.getDateEditor()).setEditable(false);

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			dateChooserFechaInicioJornadaEnfermero.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fechaCambiada3 = true;
				}
			});

		}
		return dateChooserFechaInicioJornadaEnfermero;
	}

	private JDateChooser getDateChooserFechaFinJornadaEnfermero() {
		if (dateChooserFechaFinJornadaEnfermero == null) {
			dateChooserFechaFinJornadaEnfermero = new JDateChooser();
			dateChooserFechaFinJornadaEnfermero.setBounds(222, 267, 102, 20);
			Calendar fecha = new GregorianCalendar();

			fechaCambiada4 = false;

			int dia = fecha.get(Calendar.DAY_OF_MONTH);
			int mes = 0;
			if (Calendar.MONTH == 12) {
				mes = fecha.get(Calendar.MONTH) - 11;
			} else {
				mes = fecha.get(Calendar.MONTH) + 1;
			}

			int ano = fecha.get(Calendar.YEAR);

			SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy/MM/dd");
			Date date2 = new Date();
			try {
				date2 = dateformat3.parse(ano + "/" + mes + "/" + dia);
				dateChooserFechaFinJornadaEnfermero.setDate(date2);
				dateChooserFechaFinJornadaEnfermero.getJCalendar().setMinSelectableDate(date2);
				((JTextFieldDateEditor) dateChooserFechaFinJornadaEnfermero.getDateEditor()).setEditable(false);

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			dateChooserFechaFinJornadaEnfermero.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dateChooserFechaFinJornadaEnfermero.setDate(dateChooserFechaInicioJornadaEnfermero.getDate());
					dateChooserFechaFinJornadaEnfermero.getJCalendar()
							.setMinSelectableDate(dateChooserFechaInicioJornadaEnfermero.getDate());
					((JTextFieldDateEditor) dateChooserFechaFinJornadaEnfermero.getDateEditor()).setEditable(false);
					fechaCambiada4 = true;
				}
			});
		}
		return dateChooserFechaFinJornadaEnfermero;
	}

	private JSpinner getSpinnerHoraInicioJornadaEnfermero() {
		if (spinnerHoraInicioJornadaEnfermero == null) {
			spinnerHoraInicioJornadaEnfermero = new JSpinner();
			spinnerHoraInicioJornadaEnfermero.setModel(new SpinnerNumberModel(0, 0, 23, 1));
			spinnerHoraInicioJornadaEnfermero.setBounds(561, 201, 48, 20);
		}
		return spinnerHoraInicioJornadaEnfermero;
	}

	private JSpinner getSpinnerHoraFinJornadaEnfermero() {
		if (spinnerHoraFinJornadaEnfermero == null) {
			spinnerHoraFinJornadaEnfermero = new JSpinner();
			spinnerHoraFinJornadaEnfermero.setModel(new SpinnerNumberModel(0, 0, 23, 1));
			spinnerHoraFinJornadaEnfermero.setBounds(561, 269, 48, 20);
		}
		return spinnerHoraFinJornadaEnfermero;
	}

	private JSpinner getSpinnerMinutosFinJornadaeEnfermero() {
		if (spinnerMinutosFinJornadaeEnfermero == null) {
			spinnerMinutosFinJornadaeEnfermero = new JSpinner();
			spinnerMinutosFinJornadaeEnfermero.setModel(new SpinnerNumberModel(0, 0, 5, 1));
			spinnerMinutosFinJornadaeEnfermero.setBounds(635, 269, 48, 20);
		}
		return spinnerMinutosFinJornadaeEnfermero;
	}

	private JLabel getLblNewLabel_6_2() {
		if (lblNewLabel_6_2 == null) {
			lblNewLabel_6_2 = new JLabel(":");
			lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_2.setBounds(619, 203, 30, 14);
		}
		return lblNewLabel_6_2;
	}

	private JLabel getLblNewLabel_6_1_2() {
		if (lblNewLabel_6_1_2 == null) {
			lblNewLabel_6_1_2 = new JLabel(":");
			lblNewLabel_6_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6_1_2.setBounds(619, 272, 30, 14);
		}
		return lblNewLabel_6_1_2;
	}

	private JSpinner getSpinnerMinutosInicioJornadaEnfermero() {
		if (spinnerMinutosInicioJornadaEnfermero == null) {
			spinnerMinutosInicioJornadaEnfermero = new JSpinner();
			spinnerMinutosInicioJornadaEnfermero.setModel(new SpinnerNumberModel(0, 0, 5, 1));
			spinnerMinutosInicioJornadaEnfermero.setBounds(635, 201, 48, 20);
		}
		return spinnerMinutosInicioJornadaEnfermero;
	}

	private JSpinner getSpinnerMinutosInicioJornadaEnfermero2() {
		if (spinnerMinutosInicioJornadaEnfermero2 == null) {
			spinnerMinutosInicioJornadaEnfermero2 = new JSpinner();
			spinnerMinutosInicioJornadaEnfermero2.setModel(new SpinnerNumberModel(0, 0, 9, 1));
			spinnerMinutosInicioJornadaEnfermero2.setBounds(693, 201, 48, 20);
		}
		return spinnerMinutosInicioJornadaEnfermero2;
	}

	private JSpinner getSpinnerMinutosFinJornadaEnfermero2() {
		if (spinnerMinutosFinJornadaEnfermero2 == null) {
			spinnerMinutosFinJornadaEnfermero2 = new JSpinner();
			spinnerMinutosFinJornadaEnfermero2.setModel(new SpinnerNumberModel(0, 0, 9, 1));
			spinnerMinutosFinJornadaEnfermero2.setBounds(693, 269, 48, 20);
		}
		return spinnerMinutosFinJornadaEnfermero2;
	}

	private JList getListEnfermerosJornada() {
		if (listEnfermerosJornada == null) {
			modeloListaEnfermerosJornada = new DefaultListModel();
			le = new ListaEnfermeros();
			le.creaListaEnfermeros();
			for (Enfermero e : le.getEnfermeros()) {
				modeloListaEnfermerosJornada.addElement(e);
			}
			listEnfermerosJornada = new JListFiltroJornadaEnfermeros(modeloListaEnfermerosJornada);
			this.add(listEnfermerosJornada.gettextoFiltro());
			
		}
		return listEnfermerosJornada;
	}

	private JList getListEnfermerosSeleccionadosJornada() {
		if (listEnfermerosSeleccionadosJornada == null) {
			modeloListaEnfermerosSeleccionadosJornada = new DefaultListModel();
			listEnfermerosSeleccionadosJornada = new JList(modeloListaEnfermerosSeleccionadosJornada);
		}
		return listEnfermerosSeleccionadosJornada;
	}

	private JList getListDiasSemanaJornadaEnfermero() {
		if (listDiasSemanaJornadaEnfermero == null) {
			modeloDiasSemanaJornadaEnfermero = new DefaultListModel();
			listDiasSemanaJornadaEnfermero = new JList(new AbstractListModel() {
				String[] values = new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado",
						"Domingo" };

				public int getSize() {
					return values.length;
				}

				public Object getElementAt(int index) {
					return values[index];
				}
			});

		}
		return listDiasSemanaJornadaEnfermero;
	}

	private JList getListDiasSeleccionadosJornadaEnfermero() {
		if (listDiasSeleccionadosJornadaEnfermero == null) {
			modeloDiasSemanaSeleccionadosJornadaEnfermero = new DefaultListModel();
			listDiasSeleccionadosJornadaEnfermero = new JList(modeloDiasSemanaSeleccionadosJornadaEnfermero);
		}
		return listDiasSeleccionadosJornadaEnfermero;
	}

	private boolean comprobarCorrecto2(int horaInicio, int horaFin, int minutos1Inicio, int minutos2Inicio,
			int minutos1Fin, int minutos2Fin) {

		if (fechaCambiada3 == true && fechaCambiada4 == false) {
			JOptionPane.showMessageDialog(getBtnCrearJornadaEnfermero(),
					"La fecha final de la jornada no puede ser anterior a la fecha inicial");
			return false;

		} else {
			if (dateChooserFechaInicioJornadaEnfermero.getDate().toString()
					.contains(dateChooserFechaFinJornadaEnfermero.getDate().toString())) {

				if (horaInicio >= horaFin) {
					if (minutos1Inicio >= minutos1Fin) {
						if (minutos2Inicio >= minutos2Fin) {
							JOptionPane.showMessageDialog(getBtnCrearJornadaEnfermero(),
									"La hora final de la jornada no puede ser anterior a la hora inicial");
							return false;
						}
					}
				}

			}
		}

		return true;

	}

	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
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
