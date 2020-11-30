package pgh.ui.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import pgh.business.registro.ListaRegistros;
import pgh.business.registro.Registro;
import javax.swing.JScrollPane;

public class PanelAuditor extends JPanel {

	private JPanel panelAnterior;
	private JPanel panelContenido;
	private JPanel panelAuditor;
	private JButton btnSalir;
	private JLabel lblRegistro;
	private JTable tableRegistro;

	
	public PanelAuditor (JPanel panelAnterior, JPanel panelContenido) {
		
		this.panelAnterior = panelAnterior;
		this.panelContenido = panelContenido;
		panelAuditor = this;
		getPanelAuditor();
		
	}
	
	private JPanel getPanelAuditor() {
			
			this.setBackground(Color.WHITE);
			this.setLayout(null);
			this.add(getBtnSalir());
			add(getLblRegistro());
			add(getScrollPane());
		
		    return panelAuditor;
	}
	
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.setFocusable(false);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					closePanel();
				}
			});
			btnSalir.setBounds(1008, 580, 115, 38);
		}
		return btnSalir;
	}
	
	protected void closePanel() {
		this.setVisible(false);
		this.panelAnterior.setVisible(true);
	}
	private JLabel getLblRegistro() {
		if (lblRegistro == null) {
			lblRegistro = new JLabel("Registro");
			lblRegistro.setFont(new Font("Sitka Small", Font.PLAIN, 35));
			lblRegistro.setBounds(496, -4, 163, 68);
		}
		return lblRegistro;
	}
	
	DefaultTableModel modelo = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;
	};
	private JScrollPane scrollPane;
	
	private JTable getTableRegistro() {
		if (tableRegistro == null) {
			tableRegistro = new JTable();
			tableRegistro.setModel(modelo);
			
			modelo.addColumn("ID");
			modelo.addColumn("FECHA");
			modelo.addColumn("DESCRIPCION");
			
			tableRegistro.getColumnModel().getColumn(0).setPreferredWidth(55);
			tableRegistro.getColumnModel().getColumn(1).setPreferredWidth(150);
			tableRegistro.getColumnModel().getColumn(2).setPreferredWidth(950);
			tableRegistro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			
			cargarDatosTabla();
		}
		return tableRegistro;
	}

	private void cargarDatosTabla() {
		
		ListaRegistros lr = new ListaRegistros();
		lr.creaListaRegistros();
		
		for(Registro r : lr.getRegistros()) {
			Object[] registro = new Object[3];
			registro[0] = r.getIdRegistro();
			registro[1] = r.getFecha();
			registro[2] = r.getDescripcion();
			
			modelo.addRow(registro);
		}
		
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(Color.WHITE);
			scrollPane.setBounds(10, 75, 1155, 480);
			scrollPane.setViewportView(getTableRegistro());
		}
		return scrollPane;
	}
}
