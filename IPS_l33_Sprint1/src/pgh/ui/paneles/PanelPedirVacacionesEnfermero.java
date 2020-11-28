package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import pgh.business.enfermero.EditarDiasVacacionesEnfermero;
import pgh.business.enfermero.Enfermero;
import pgh.business.enfermero.FindAllEnfermeros;
import pgh.business.enfermero.ListaEnfermeros;
import pgh.business.jornadamedico.CrearJornadaMedico;
import pgh.business.jornadamedico.JornadaMedicoDTO;
import pgh.business.jornadamedico.ListaJornadasMedico;
import pgh.business.medicamento.FindAllMedicamentos;
import pgh.business.medico.EditarDiasVacaciones;
import pgh.business.medico.FindAllMedicos;
import pgh.business.medico.ListaMedicos;
import pgh.business.medico.Medico;
import pgh.business.vacacionesSolicitadas.CrearVacacionesSolicitadasMedico;
import pgh.business.vacacionesSolicitadas.FindAllVacacionesSolicitadasMedico;
import pgh.business.vacacionesSolicitadas.ListaVacacionesSolicitadasMedico;
import pgh.business.vacacionesSolicitadas.VacacionesSolicitadasMedico;
import pgh.business.vacacionesSolicitadas.VacacionesSolicitadasMedicoDTO;
import pgh.business.vacacionesSolicitadasEnfermero.CrearVacacionesSolicitadasEnfermero;
import pgh.business.vacacionesSolicitadasEnfermero.FindAllVacacionesSolicitadasEnfermero;
import pgh.business.vacacionesSolicitadasEnfermero.ListaVacacionesSolicitadasEnfermero;
import pgh.business.vacacionesSolicitadasEnfermero.RemoveVacacionesSolicitadasEnfermero;
import pgh.business.vacacionesSolicitadasEnfermero.VacacionesSolicitadasEnfermero;
import pgh.business.vacacionesSolicitadasEnfermero.VacacionesSolicitadasEnfermeroDTO;
import pgh.business.vacacionesSolicitadas.RemoveVacacionesSolicitadas;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelPedirVacacionesEnfermero extends JPanel {
	
	private JPanel panelAnterior;
	private JPanel panelContenido;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JDateChooser dateChooserFechaInicio;
	private JDateChooser dateChooserFechaFin;
	private JButton btnVerEstado;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JButton btnMandarSolicitud;
	private JButton btnCancelar;
	private boolean fechaCambiada4;
	private boolean fechaCambiada3;
	private PanelPedirVacacionesEnfermero thisPanel;
	private CrearVacacionesSolicitadasEnfermero crearVacacionesSolicitadasEnfermero;
	private VacacionesSolicitadasEnfermeroDTO vacacionesSolicitadasEnfermeroDTO;
	private VacacionesSolicitadasEnfermero vacacionesSolicitadasEnfermero;
	private int id_enfermero;
	private ListaEnfermeros lm;
	private VacacionesSolicitadasEnfermeroDTO vsmDTO;
	private FindAllVacacionesSolicitadasEnfermero findAllVacacionesSolicitadas;
	private RemoveVacacionesSolicitadasEnfermero removeVacaciones;
	private JLabel lblNewLabel_3;
	private JTextField textFieldDiasDisponibles;
	private int diasSolicitados;
	private Enfermero enfermero;
	private FindAllEnfermeros findEnfermeros;
	private EditarDiasVacacionesEnfermero editarDias;
	
	public PanelPedirVacacionesEnfermero(JPanel panelAnterior, JPanel panelContenido, int idenfermero) {
		
		this.panelAnterior=panelAnterior;
		this.panelContenido= panelContenido;
		this.id_enfermero = idenfermero;
		thisPanel=this;
		setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 1129, 600);
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLblNewLabel_1_1());
		add(getDateChooserFechaInicio());
		add(getDateChooserFechaFin());
		add(getBtnVerEstado());
		add(getLblNewLabel_2());
		add(getTextField());
		add(getBtnMandarSolicitud());
		add(getBtnCancelar());
		add(getLblNewLabel_3());
		add(getTextFieldDiasDisponibles());
	}
	
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Seleccione los dias deseados :");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(135, 111, 272, 121);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Dia inicio :");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(430, 111, 113, 38);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Dia fin :");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1_1.setBounds(450, 196, 83, 28);
		}
		return lblNewLabel_1_1;
	}
	private JDateChooser getDateChooserFechaInicio() {
		if (dateChooserFechaInicio == null) {
			dateChooserFechaInicio = new JDateChooser();
			dateChooserFechaInicio.setBounds(539, 118, 113, 25);
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
				dateChooserFechaInicio.setDate(date2);
				dateChooserFechaInicio.getJCalendar().setMinSelectableDate(date2);
				((JTextFieldDateEditor) dateChooserFechaInicio.getDateEditor()).setEditable(false);

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			dateChooserFechaInicio.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fechaCambiada3 = true;
				}
			});

		}
		return dateChooserFechaInicio;
	}
	private JDateChooser getDateChooserFechaFin() {
		if (dateChooserFechaFin == null) {
			dateChooserFechaFin = new JDateChooser();
			dateChooserFechaFin.setBounds(539, 199, 113, 25);
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
				dateChooserFechaFin.setDate(date2);
				dateChooserFechaFin.getJCalendar().setMinSelectableDate(date2);
				((JTextFieldDateEditor) dateChooserFechaFin.getDateEditor()).setEditable(false);

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			dateChooserFechaFin.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dateChooserFechaFin.setDate(dateChooserFechaInicio.getDate());
					dateChooserFechaFin.getJCalendar()
							.setMinSelectableDate(dateChooserFechaInicio.getDate());
					((JTextFieldDateEditor) dateChooserFechaFin.getDateEditor()).setEditable(false);
					fechaCambiada4 = true;
				}
			});
		}
		return dateChooserFechaFin;
	}
	private JButton getBtnVerEstado() {
		if (btnVerEstado == null) {
			btnVerEstado = new JButton("Ver estado de mi solicitud");
			btnVerEstado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					PanelComprobarSolicitudVacacionesEnfermero panel = new PanelComprobarSolicitudVacacionesEnfermero(thisPanel, id_enfermero);
					panelContenido.add( panel);
					thisPanel.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnVerEstado.setBounds(742, 141, 200, 50);
			
		}
		return btnVerEstado;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Motivo (Solo rellenar para casos de dias sueltos ) : ");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_2.setBounds(135, 349, 429, 50);
		}
		return lblNewLabel_2;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(539, 339, 403, 74);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnMandarSolicitud() {
		if (btnMandarSolicitud == null) {
			btnMandarSolicitud = new JButton("Mandar solicitud ");
			btnMandarSolicitud.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					crearVacacionesSolicitadasEnfermero = new CrearVacacionesSolicitadasEnfermero();
					vacacionesSolicitadasEnfermeroDTO  = new VacacionesSolicitadasEnfermeroDTO();
					
					findAllVacacionesSolicitadas = new FindAllVacacionesSolicitadasEnfermero();
					vsmDTO= new VacacionesSolicitadasEnfermeroDTO();
					
					
					Date fechaInicio = dateChooserFechaInicio.getDate();
					Date fechaFin = dateChooserFechaFin.getDate();
					editarDias = new EditarDiasVacacionesEnfermero();

					int milisecondsByDay = 86400000;
					int diass = (int) ((fechaFin.getTime() - fechaInicio.getTime()) / milisecondsByDay);
					int diaaaaas = getDiasDispobibles() - diass;
					
					if(diaaaaas < 0 ) {
						JOptionPane.showMessageDialog(getBtnMandarSolicitud(), "No tienes suficientes dias como para pedir estas vacaciones' ");
					}else {
						editarDias.actualizar(diaaaaas, id_enfermero);
					
						vacacionesSolicitadasEnfermeroDTO.idVacacionesMedicoSolicitadas = generarIdVacaciones();
						vacacionesSolicitadasEnfermeroDTO.idMedico = id_enfermero;
						vacacionesSolicitadasEnfermeroDTO.diaInicio = dateChooserFechaInicio.getDate();
						vacacionesSolicitadasEnfermeroDTO.diaFin = dateChooserFechaFin.getDate();
						vacacionesSolicitadasEnfermeroDTO.motivo = textField.getText();
						vacacionesSolicitadasEnfermeroDTO.aprobadas=false;
						vacacionesSolicitadasEnfermeroDTO.canceladas=false;
						vacacionesSolicitadasEnfermeroDTO.esperando=true;
						
						lm = new ListaEnfermeros();
						lm.creaListaEnfermeros();
						for(int i=0; i<lm.getEnfermeros().size();i++) {
							if(id_enfermero == lm.getEnfermeros().get(i).getIdEnfermero()) {
								vacacionesSolicitadasEnfermeroDTO.nombreMedico = lm.getEnfermeros().get(i).getNombreEnfermero() + " " + lm.getEnfermeros().get(i).getApellidosEnfermo();
							}
						}
						
						vacacionesSolicitadasEnfermero= new VacacionesSolicitadasEnfermero(vacacionesSolicitadasEnfermeroDTO);
						
						crearVacacionesSolicitadasEnfermero.crearVacaciones(vacacionesSolicitadasEnfermero);
						
						
						textField.setText("");
						closePanel();
					
					
					
					}
					
					
					}

					
				

			});
			btnMandarSolicitud.setBounds(717, 517, 140, 28);
			
		}
		return btnMandarSolicitud;
	}
	
	private int generarIdVacaciones() {
		ListaVacacionesSolicitadasEnfermero lc = new ListaVacacionesSolicitadasEnfermero();
		lc.creaVacaciones();
		return 5000 + lc.getVacacionesSolicitadas().size();
	}
	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(895, 517, 140, 28);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					closePanel();
				}
			});
		}
		return btnCancelar;
	}
	
	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Dias disponibles : ");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_3.setBounds(136, 477, 140, 38);
		}
		return lblNewLabel_3;
	}
	private JTextField getTextFieldDiasDisponibles() {
		if (textFieldDiasDisponibles == null) {
			textFieldDiasDisponibles = new JTextField();
			textFieldDiasDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldDiasDisponibles.setBounds(258, 477, 120, 38);
			textFieldDiasDisponibles.setColumns(10);
			textFieldDiasDisponibles.setText(""+getDiasDispobibles());
		}
		return textFieldDiasDisponibles;
	}


	private int getDiasDispobibles() {
		
		findEnfermeros = new FindAllEnfermeros();	
		enfermero = new Enfermero(findEnfermeros.diasDisponibles(id_enfermero));
		return enfermero.getDiasDisponibles();
			
	}
}
