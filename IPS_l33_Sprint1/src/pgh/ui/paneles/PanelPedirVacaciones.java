package pgh.ui.paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
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

import pgh.business.jornadamedico.CrearJornadaMedico;
import pgh.business.jornadamedico.JornadaMedicoDTO;
import pgh.business.jornadamedico.ListaJornadasMedico;
import pgh.business.vacacionesSolicitadas.CrearVacacionesSolicitadasMedico;
import pgh.business.vacacionesSolicitadas.ListaVacacionesSolicitadasMedico;
import pgh.business.vacacionesSolicitadas.VacacionesSolicitadasMedico;
import pgh.business.vacacionesSolicitadas.VacacionesSolicitadasMedicoDTO;

import javax.swing.JButton;
import javax.swing.JTextField;

public class PanelPedirVacaciones extends JPanel {
	
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
	private PanelPedirVacaciones thisPanel;
	private CrearVacacionesSolicitadasMedico crearVacacionesSolicitadasMedico;
	private VacacionesSolicitadasMedicoDTO vacacionesSolicitadasMedicoDTO;
	private VacacionesSolicitadasMedico vacacionesSolicitadasMedico;
	private int id_medico;
	
	
	public PanelPedirVacaciones(JPanel panelAnterior, JPanel panelContenido, int idmedico) {
		
		this.panelAnterior=panelAnterior;
		this.panelContenido= panelContenido;
		this.id_medico = idmedico;
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
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Seleccione los dias deseados :");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(138, 130, 272, 121);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Dia inicio :");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(433, 130, 113, 38);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Dia fin :");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1_1.setBounds(453, 215, 83, 28);
		}
		return lblNewLabel_1_1;
	}
	private JDateChooser getDateChooserFechaInicio() {
		if (dateChooserFechaInicio == null) {
			dateChooserFechaInicio = new JDateChooser();
			dateChooserFechaInicio.setBounds(542, 137, 113, 25);
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
			dateChooserFechaFin.setBounds(542, 218, 113, 25);
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
					
					PanelComprobarSolicitudVacaciones panel = new PanelComprobarSolicitudVacaciones(thisPanel);
					panelContenido.add( panel);
					thisPanel.setVisible(false);
					panel.setVisible(true);
				}
			});
			btnVerEstado.setBounds(745, 160, 200, 50);
			
		}
		return btnVerEstado;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Motivo (Solo rellenar para casos de dias sueltos ) : ");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_2.setBounds(138, 368, 429, 50);
		}
		return lblNewLabel_2;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(542, 358, 403, 74);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnMandarSolicitud() {
		if (btnMandarSolicitud == null) {
			btnMandarSolicitud = new JButton("Mandar solicitud ");
			btnMandarSolicitud.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					crearVacacionesSolicitadasMedico = new CrearVacacionesSolicitadasMedico();
					vacacionesSolicitadasMedicoDTO  = new VacacionesSolicitadasMedicoDTO();
					
					vacacionesSolicitadasMedicoDTO.idVacacionesMedicoSolicitadas = generarIdVacaciones();
					vacacionesSolicitadasMedicoDTO.idMedico = id_medico;
					vacacionesSolicitadasMedicoDTO.diaInicio = dateChooserFechaInicio.getDate();
					vacacionesSolicitadasMedicoDTO.diaFin = dateChooserFechaFin.getDate();
					vacacionesSolicitadasMedicoDTO.motivo = textField.getText();
					vacacionesSolicitadasMedicoDTO.aprobadas=false;
					vacacionesSolicitadasMedicoDTO.canceladas=false;
					vacacionesSolicitadasMedicoDTO.esperando=true;
					
					vacacionesSolicitadasMedico= new VacacionesSolicitadasMedico(vacacionesSolicitadasMedicoDTO);
					
					crearVacacionesSolicitadasMedico.crearVacaciones(vacacionesSolicitadasMedico);
					
					textField.setText("");
					closePanel();
					
					
				}

			});
			btnMandarSolicitud.setBounds(717, 517, 140, 28);
			
		}
		return btnMandarSolicitud;
	}
	
	private int generarIdVacaciones() {
		ListaVacacionesSolicitadasMedico lc = new ListaVacacionesSolicitadasMedico();
		lc.creaVacaciones();
		return 4700 + lc.getVacacionesSolicitadas().size();
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

}
