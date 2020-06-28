package br.unifor.poo.view.frames;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import br.unifor.poo.modelo.Cardapio;
import br.unifor.poo.modelo.Cliente;
import br.unifor.poo.modelo.Bar;
import br.unifor.poo.view.util.Misc;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	
	private JMenu sistema = new JMenu("1 SISTEMA");
	private JMenu cadastro = new JMenu("1.1 Cadastro");
	private JMenuItem cardapio = new JMenuItem("1.1.1 Cardapios");
	private JMenuItem cliente = new JMenuItem("1.1.2 Clientes");
	private JMenuItem bar = new JMenuItem("1.1.3 Bares");
	private JMenuItem fechar = new JMenuItem("1.2 Fechar");
	
	private JMenuItem creditos = new JMenu("2 Créditos");
	private JMenuItem exibir = new JMenuItem("2.1 Exibir");
	
	private JFrame parent = null;
	private ICloseble closeble = null;
	
	public MenuBar(ICloseble _closeble) {
		this.closeble = _closeble;
		this.add(sistema);
		this.add(creditos);
		this.fonts();
		sistema.add(cadastro);
		cadastro.add(cardapio);
		cadastro.add(cliente);
		cadastro.add(bar);
		sistema.add(fechar);
		creditos.add(exibir);
		this.eventsConfig();
	}
	private void fonts() {
		this.setFont(Misc.FONT);
		sistema.setFont(Misc.FONT);
		cadastro.setFont(Misc.FONT);
		cardapio.setFont(Misc.FONT);
		cliente.setFont(Misc.FONT);
		fechar.setFont(Misc.FONT);
		bar.setFont(Misc.FONT);
		
		creditos.setFont(Misc.FONT);
		creditos.setFont(Misc.FONT);
		exibir.setFont(Misc.FONT);
	}
	private void eventsConfig() {
		this.fecharClick();
		this.cardapioClick();
		this.clienteClick();
		this.uniforClick();
		this.exibirClick();
	}
	private void uniforClick() {
		parent = (JFrame) this.getParent();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		bar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DialogBar(new Bar(), parent, "Cadastro de Bares de Fortaleza", screenSize.width-100, screenSize.height-100);
			}
		});
	}
	private void fecharClick() {
		fechar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 closeble.close();
			}
		});
	}
	private void cardapioClick() {
		parent = (JFrame) this.getParent();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		cardapio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DialogCardapio(new Cardapio(), parent,"Cardapio Teste", screenSize.width-100, screenSize.height-100);
			}
		});
	}
	private void clienteClick() {
		parent = (JFrame) this.getParent();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		cliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DialogCliente(new Cliente(), parent,"Cliente Teste", screenSize.width-100, screenSize.height-100);
			}
		});
	}
	
	private void exibirClick() {
		parent = (JFrame) this.getParent();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		exibir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(parent, "™ Faminto, Todos os direitos reservados.");
			}
		});
	}
	
	public interface ICloseble {
		public void close();
	}
}
