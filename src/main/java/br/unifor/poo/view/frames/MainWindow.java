package br.unifor.poo.view.frames;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import br.unifor.poo.view.frames.MenuBar.ICloseble;
import br.unifor.poo.view.util.Misc;

@SuppressWarnings("serial")
public class MainWindow extends JFrame implements ICloseble{
	private final JMenuBar menuBar;
	private JPanel center = new JPanel();
	private static final String TITLE = "Sistema 1.0";
	
	public MainWindow() {
		menuBar = new MenuBar(this);
		this.firsts();
		this.mids();
		this.lasts();
	}
	private void firsts() {
		this.setTitle(TITLE);
		this.fonts();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	private void mids() {
		this.add(menuBar, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		center.setBackground(Color.BLACK);
	}
	private void lasts() {
		this.setVisible(true);
	}
	private void fonts() {
		this.setFont(Misc.FONT);
		center.setFont(Misc.FONT);
	}

	public void close() {
		System.exit(0);
		//ConnectionFactory.close();
	}
}
