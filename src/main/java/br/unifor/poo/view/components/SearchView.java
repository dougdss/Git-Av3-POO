package br.unifor.poo.view.components;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
@SuppressWarnings("serial")
public class SearchView<T> extends JFrame {
    private JTextField searchable = new JTextField(30);
    private JButton searchB = new JButton("Search");
    private JTable result = new JTable();
    private JPanel panel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(result);
 
    protected T item;
    protected TableModel<T> model;
    
    public SearchView(String title, T _item, Frame parentFrame, int width, int height) {
        super(title);
        inicio(_item, width, height);
    }
    
    protected void inicio(T _item, int width, int height) {
		this.item = _item;
		this.setSize(width, height);
		setResizable(true);
		addComponents();
        setTable();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
 
    private void addComponents() {
        panel.add(searchable);
        panel.add(searchB);
        panel.add(scrollPane);
        add(panel);
    }
 
    private void setTable() {
    	searchB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setModel(model);
			}
		});
    }
}