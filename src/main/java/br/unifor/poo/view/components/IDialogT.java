package br.unifor.poo.view.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.unifor.poo.view.util.Misc;

@SuppressWarnings("serial")
public abstract class IDialogT<T> extends JDialog {
	protected T item = null;
	protected CRUDPanel<T> crudPanel;
	protected JPanel center = new JPanel(new BorderLayout());
	protected JTable tabela = null;
	protected TableModel<T> modelo = null;
	public IDialogT(T _item, Frame parentFrame, String title, int width, int height) {
		super(parentFrame, title, true);
		this.inicio(_item, width, height);
	}
	public IDialogT(T _item, JDialog parentFrame, String title, int width, int height) {
		super(parentFrame, title, true);
		this.inicio(_item, width, height);
	}
	protected void inicio(T _item, int width, int height) {
		this.item = _item;
		this.crudPanel = new CRUDPanel<T>(_item);
		this.setSize(width, height);
		this.firsts();
		this.setCenterComponents();
		this.events(); 
		this.setCrudComponents();
		this.lasts();
	}
	protected void firsts() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	protected void setCenterComponents() {
		this.add(center, BorderLayout.CENTER);
		center.setBackground(Color.BLACK);
		center.add(crudPanel, BorderLayout.WEST);
		
		tabela = new JTable();
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setFont(Misc.FONT);
		center.add(scroll, BorderLayout.CENTER);
		this.tableDraw();
	}
	protected void setCrudComponents() {
		this.crudPanel.setInputFields();
	}
	@SuppressWarnings("unchecked")
	private void tableDraw() {
		if(modelo==null) {
			modelo = new TableModel<T>();
			modelo.add(item);
			tabela.setModel(modelo);
			modelo.clear();
			modelo.fireTableDataChanged();
		}
	}
	protected void lasts() {
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}	
	@SuppressWarnings("unused")
	protected void events() {
		JDialog parent = this;
		crudPanel.btnNEW.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newItem();
			}
		});
		crudPanel.btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateItem();
			}
		});
		crudPanel.btnDEL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteItem();
			}
		});
	}
	protected abstract void newItem();
	protected abstract void updateItem();
	protected abstract void deleteItem();
}
