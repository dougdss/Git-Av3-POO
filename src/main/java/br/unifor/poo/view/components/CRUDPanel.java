package br.unifor.poo.view.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unifor.poo.view.util.Misc;

@SuppressWarnings("serial")
public class CRUDPanel<T> extends JPanel {
	public JPanel center = new JPanel(new GridLayout(10, 1));
	public final JPanel botoesPanelSouth = new JPanel(new FlowLayout(FlowLayout.LEFT));
	public JPanel inputPanelNorth = null;
	
	public final JButton btnNEW = new JButton("NEW");
	public final JButton btnSave = new JButton("SAVE");
	public final JButton btnDEL = new JButton("DELETE");
	public final Map<String, JTextField> txtFiels = new HashMap<String, JTextField>();
	public final T item;
	
	public CRUDPanel(T _item) {
		super(new BorderLayout());
		this.item = _item;
		this.inicio();
	}
	public void inicio() {
		this.firsts();
		this.setInputFields();
		this.setBotoes();		
	}
	public void firsts() {
		this.removeAll();
		center.setFont(Misc.FONT);
		this.add(center, BorderLayout.CENTER);
	}
	public void setInputFields() { 
		String[] sts = Misc.getChildAndSuperStrings(this.item);
		inputPanelNorth = new JPanel(new GridLayout(sts.length*2, 1));
		for (String s: sts) {
			JTextField tf = new JTextField(30);
			Label l = new Label(s);
			txtFiels.put(s, tf);
			Misc.setFont(tf,l);
			inputPanelNorth.add(l);
			inputPanelNorth.add(tf);
			if(s.contentEquals("id")) tf.setEnabled(false);
		}
		this.add(inputPanelNorth, BorderLayout.NORTH);
	}
	public void setBotoes() {
		this.add(botoesPanelSouth, BorderLayout.SOUTH);
		botoesPanelSouth.add(btnNEW);
		botoesPanelSouth.add(btnSave);
		botoesPanelSouth.add(btnDEL);
		botoesPanelSouth.setBackground(Color.BLACK);
	}
	public void insertComponets(Component ... components) {
		for (Component c: components) {
			this.center.add(c);
		}
	}
}
