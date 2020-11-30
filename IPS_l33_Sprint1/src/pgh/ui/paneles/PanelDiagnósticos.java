package pgh.ui.paneles;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import pgh.business.cie10.Nodo;
import pgh.business.cie10.NodoMayor;
import pgh.business.cita.Cita;
import pgh.business.diagnostico.DiagnosticoDTO;
import pgh.business.diagnostico.FindAllDiagnosticos;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PanelDiagnósticos extends JPanel {
	private JScrollPane scrollPaneCategorias;
	private JScrollPane scrollPaneEnfermedades;
	private JButton btnSeleccionar;
	private JCheckBox chckbxSeguimiento;
	private JCheckBox chckbxDeclaracion;
	private JLabel lblFiltro;
	private JTextField textFiltro;
	private JScrollPane scrollPaneDiagnosticos;
	private JList listCategorias;
	private JList listEnfermedades;
	private JList listDiagnosticos;
	private List<NodoMayor> listaNodosMayores = new ArrayList<NodoMayor>();
	private List<Nodo> listaNodosMenores = new ArrayList<Nodo>();
	private List<DiagnosticoDTO> listaDiagnosticos;
	private NodoMayor raiz;
	private DefaultListModel<NodoMayor> modeloListaNodosMayores = new DefaultListModel<NodoMayor>();
	private DefaultListModel<Nodo> modeloListaNodosMenores = new DefaultListModel<Nodo>();
	private DefaultListModel<DiagnosticoDTO> modeloListaDiagnosticos = new DefaultListModel<DiagnosticoDTO>();
	private JPanel panelContenido;
	private JPanel panelAnterior;
	private JPanel panelAnteriorAnterior;
	private JPanel estePanel;
	private JButton btnAtras;
	private JButton btnAadirDiagnostico;
	private JButton btnBorrarDiagnostico;
	private JButton btnFiltrar;
	private JButton btnReset;
	
	private Cita cita;
	
	public PanelDiagnósticos(JPanel panelContenido, JPanel panelAnterior, JPanel panelAnteriorAnterior, Cita cita, List<DiagnosticoDTO> diagnosticos) {
		if(diagnosticos!=null)
		{
			if(diagnosticos.size()>0)
			{
				listaDiagnosticos = diagnosticos;
				crearModeloListaDiagnosticos();
			}
			else
			{
				this.listaDiagnosticos = new ArrayList<DiagnosticoDTO>();
				//diagnosticos  = new FindAllDiagnosticos().execute();
			}
		}
		else
		{
			this.listaDiagnosticos = new ArrayList<DiagnosticoDTO>();
			//diagnosticos  = new FindAllDiagnosticos().execute();
		}
		this.panelAnteriorAnterior=panelAnteriorAnterior;
		this.cita = cita;
		estePanel = this;
		this.panelAnterior = panelAnterior;
		this.panelContenido = panelContenido;
		raiz = new NodoMayor();
		listaNodosMayores = raiz.getNodos();
		crearModeloListaNodosMayores();
		setLayout(null);
		add(getScrollPaneCategorias());
		add(getScrollPaneEnfermedades());
		add(getBtnSeleccionar());
		add(getChckbxSeguimiento());
		add(getChckbxDeclaracion());
		add(getLblFiltro());
		add(getTextFiltro());
		add(getScrollPaneDiagnosticos());
		add(getBtnAtras());
		add(getBtnAadirDiagnostico());
		add(getBtnBorrarDiagnostico());
		add(getBtnFiltrar());
		add(getBtnReset());
	}
	
	

	private void  crearModeloListaNodosMayores()
	{
		modeloListaNodosMayores.removeAllElements();
		for(int i=0;i<listaNodosMayores.size();i++)
		{
			modeloListaNodosMayores.addElement(listaNodosMayores.get(i));
		}
	}
	
	private void crearModeloListaNodosCategoria(NodoMayor nodo)
	{
		modeloListaNodosMayores.removeAllElements();
		for(int i = 0;i<nodo.getNodos().size();i++)
		{
			modeloListaNodosMayores.addElement(nodo.getNodos().get(i));
		}
	}
	
	private void crearModeloListaDiagnosticos() {
		//modeloListaDiagnosticos.removeAllElements();
		for(int i =0; i<listaDiagnosticos.size();i++)
		{
			modeloListaDiagnosticos.addElement(listaDiagnosticos.get(i));
		}
	}
	
	private void crearModeloListaNodosMenores(NodoMayor nodo)
	{
		modeloListaNodosMenores.removeAllElements();
		for(int i=0;i<nodo.getNodosMenores().size();i++)
		{
			modeloListaNodosMenores.addElement(nodo.getNodosMenores().get(i));
		}
	}
	
	private JScrollPane getScrollPaneCategorias() {
		if (scrollPaneCategorias == null) {
			scrollPaneCategorias = new JScrollPane();
			scrollPaneCategorias.setBounds(25, 108, 461, 289);
			scrollPaneCategorias.setViewportView(getListCategorias());
		}
		return scrollPaneCategorias;
	}
	private JScrollPane getScrollPaneEnfermedades() {
		if (scrollPaneEnfermedades == null) {
			scrollPaneEnfermedades = new JScrollPane();
			scrollPaneEnfermedades.setBounds(529, 108, 478, 145);
			scrollPaneEnfermedades.setViewportView(getListEnfermedades());
		}
		return scrollPaneEnfermedades;
	}
	private JButton getBtnSeleccionar() {
		if (btnSeleccionar == null) {
			btnSeleccionar = new JButton("Seleccionar");
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(listaDiagnosticos.size()==0)
					{
					estePanel.setVisible(false);
					panelAnterior.setVisible(true);
					}
					else
					{
						estePanel.setVisible(false);
						PanelCita panel = new PanelCita(panelContenido, panelAnteriorAnterior, cita, listaDiagnosticos);
						panelContenido.add(panel);
						panel.setVisible(true);
					}
				}
			});
			btnSeleccionar.setBounds(25, 439, 104, 31);
		}
		return btnSeleccionar;
	}
	private JCheckBox getChckbxSeguimiento() {
		if (chckbxSeguimiento == null) {
			chckbxSeguimiento = new JCheckBox("Seguimiento");
			chckbxSeguimiento.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(chckbxSeguimiento.isSelected())
					{
						new JOptionPane().showMessageDialog(null, "Acabamos de marcar este diagnóstico para hacerle un seguimiento");;
						chckbxSeguimiento.setSelected(true);
					}
				}
			});
			
			chckbxSeguimiento.setBounds(529, 451, 97, 23);
		}
		return chckbxSeguimiento;
	}
	private JCheckBox getChckbxDeclaracion() {
		if (chckbxDeclaracion == null) {
			chckbxDeclaracion = new JCheckBox("Declaracion Obligatoria");
			chckbxDeclaracion.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(chckbxDeclaracion.isSelected())
					{
						new JOptionPane().showMessageDialog(null, "Acabamos de marcar este diagnóstico como de declaración obligatoria");;
						chckbxDeclaracion.setSelected(true);
					}
				}
			});
			chckbxDeclaracion.setBounds(529, 477, 154, 23);
		}
		return chckbxDeclaracion;
	}
	private JLabel getLblFiltro() {
		if (lblFiltro == null) {
			lblFiltro = new JLabel("Filtro:");
			lblFiltro.setBounds(25, 57, 46, 14);
		}
		return lblFiltro;
	}
	private JTextField getTextFiltro() {
		if (textFiltro == null) {
			textFiltro = new JTextField();
			textFiltro.setBounds(81, 54, 118, 20);
			textFiltro.setColumns(10);
		}
		return textFiltro;
	}
	private JScrollPane getScrollPaneDiagnosticos() {
		if (scrollPaneDiagnosticos == null) {
			scrollPaneDiagnosticos = new JScrollPane();
			scrollPaneDiagnosticos.setBounds(529, 286, 478, 111);
			scrollPaneDiagnosticos.setViewportView(getListDiagnosticos());
		}
		return scrollPaneDiagnosticos;
	}
	private JList getListCategorias() {
		if (listCategorias == null) {
			listCategorias = new JList(modeloListaNodosMayores);
			listCategorias.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(listCategorias.getSelectedValue()!=null)
					{
						if(listCategorias.getSelectedValue() instanceof NodoMayor)
						{
							if(((NodoMayor)listCategorias.getSelectedValue()).getNodosMenores().size()>0)
							{
								crearModeloListaNodosMenores((NodoMayor)listCategorias.getSelectedValue());
							}
							else
							{
								crearModeloListaNodosCategoria((NodoMayor)listCategorias.getSelectedValue()); 
							}
						}
					}
				}
			});
		}
		return listCategorias;
	}
	
	
	
	
	private JList getListEnfermedades() {
		if (listEnfermedades == null) {
			listEnfermedades = new JList(modeloListaNodosMenores);
		}
		return listEnfermedades;
	}
	private JList getListDiagnosticos() {
		if (listDiagnosticos == null) {
			listDiagnosticos = new JList(modeloListaDiagnosticos);
		}
		return listDiagnosticos;
	}
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atras");
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					estePanel.setVisible(false);
					panelAnterior.setVisible(true);
				}
			});
			btnAtras.setBounds(835, 508, 172, 23);
		}
		return btnAtras;
	}
	private JButton getBtnAadirDiagnostico() {
		if (btnAadirDiagnostico == null) {
			btnAadirDiagnostico = new JButton("A\u00F1adir Diagnostico");
			btnAadirDiagnostico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(listEnfermedades.getSelectedValue()!=null)
					{
						Nodo nodo = (Nodo) listEnfermedades.getSelectedValue();
						DiagnosticoDTO diagnostico = new DiagnosticoDTO();
						diagnostico.idCita = cita.getIdCita();
						diagnostico.descripcion = nodo.nombre;
						diagnostico.idDiagnostico = listaDiagnosticos.size() +"";
						diagnostico.idPaciente = cita.getIdPaciente();
						diagnostico.obligatorio = chckbxDeclaracion.isSelected();
						diagnostico.seguimiento = chckbxSeguimiento.isSelected();
						listaDiagnosticos.add(diagnostico);
						modeloListaDiagnosticos.addElement(diagnostico);
					}
				}
			});
			btnAadirDiagnostico.setBounds(835, 443, 172, 23);
		}
		return btnAadirDiagnostico;
	}
	private JButton getBtnBorrarDiagnostico() {
		if (btnBorrarDiagnostico == null) {
			btnBorrarDiagnostico = new JButton("Borrar Diagnostico");
			btnBorrarDiagnostico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(listDiagnosticos.getSelectedValue()!=null)
					{
						modeloListaDiagnosticos.remove(listDiagnosticos.getSelectedIndex());
					}
				}
			});
			btnBorrarDiagnostico.setBounds(835, 477, 172, 23);
		}
		return btnBorrarDiagnostico;
	}
	private JButton getBtnFiltrar() {
		if (btnFiltrar == null) {
			btnFiltrar = new JButton("Filtrar");
			btnFiltrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textFiltro.getText()!="")
					{
						filtrar(textFiltro.getText());
					}
				}
			});
			btnFiltrar.setBounds(209, 53, 89, 23);
		}
		return btnFiltrar;
	}
	
	private void filtrar(String filtro)
	{
		modeloListaNodosMayores.removeAllElements();
		for(int i=0;i<raiz.getNodos().size();i++)
			for(int j=0;j<raiz.getNodos().get(i).getNodos().size();j++)
			{
				if(raiz.getNodos().get(i).getNodos().get(j).getNombre().toLowerCase().contains(filtro.toLowerCase()))
				{
					modeloListaNodosMayores.addElement(raiz.getNodos().get(i).getNodos().get(j));
				}
			}
	}
	private JButton getBtnReset() {
		if (btnReset == null) {
			btnReset = new JButton("Reset");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListaNodosMenores.removeAllElements();
					crearModeloListaNodosMayores();
				}
			});
			btnReset.setBounds(308, 53, 97, 23);
		}
		return btnReset;
	}
}
