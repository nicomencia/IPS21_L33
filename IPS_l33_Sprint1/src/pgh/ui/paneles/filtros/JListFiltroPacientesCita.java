package pgh.ui.paneles.filtros;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


import pgh.business.paciente.Paciente;

public class JListFiltroPacientesCita extends JList {

	private TextoFiltro texto;
	

	public JListFiltroPacientesCita(DefaultListModel<Paciente> model) {
		texto = new TextoFiltro();
		Filtro filtro = new Filtro();
		for(int i=0; i< model.getSize(); i++) {
			filtro.addElement(model.getElementAt(i));
		}
		
		setModel(filtro);
		

	}

	@SuppressWarnings("unchecked")
	public void setModel(ListModel m) {
		super.setModel(m);
	}

	public void addItem(Object obj) {
		 ((Filtro)getModel()).addElement (obj);
	}

	public JTextField gettextoFiltro() {
		return texto;
	}

	class TextoFiltro extends JTextField implements DocumentListener {
		public TextoFiltro() {
			this.setBounds(323, 31, 290, 22);
			getDocument().addDocumentListener(this);
		}

		public void changedUpdate(DocumentEvent e) {
			( (Filtro) getModel()).refilter();
		}

		public void insertUpdate(DocumentEvent e) {
			((Filtro) getModel()).refilter();
		}

		public void removeUpdate(DocumentEvent e) {
			((Filtro) getModel()).refilter();
		}
	}

	class Filtro extends AbstractListModel {
		ArrayList items;
		ArrayList filterItems;

		public Filtro() {
			super();
			items = new ArrayList();
			filterItems = new ArrayList();
		}

		public Object getElementAt(int index) {
			if (index < filterItems.size())
				return filterItems.get(index);
			else
				return null;
		}

		public int getSize() {
			return filterItems.size();
		}

		public void addElement(Object o) {
			items.add(o);
			refilter();

		}

		private void refilter() {
			filterItems.clear();
			String term = gettextoFiltro().getText();
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).toString().indexOf(term, 0) != -1)
					filterItems.add(items.get(i));
				fireContentsChanged(this, 0, getSize());
			}
		}
	}
}