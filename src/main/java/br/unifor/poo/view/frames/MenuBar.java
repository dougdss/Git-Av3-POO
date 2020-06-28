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
import br.unifor.poo.modelo.Entregador;
import br.unifor.poo.modelo.Pedido;
import br.unifor.poo.modelo.Bar;
import br.unifor.poo.view.util.Misc;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	
	private JMenu sistema = new JMenu("1 SISTEMA");
	private JMenu cadastro = new JMenu("1.1 Cadastro");
	private JMenuItem cardapio = new JMenuItem("1.1.1 Cardapios");
	private JMenuItem cliente = new JMenuItem("1.1.2 Clientes");
	private JMenuItem bar = new JMenuItem("1.1.3 Bares");
	private JMenuItem entregadores = new JMenuItem("1.1.4 Entregadores");
	private JMenuItem fechar = new JMenuItem("1.2 Fechar");
	
	private JMenu pedidos = new JMenu("2 Pedidos");
	private JMenuItem novoPedido = new JMenuItem("2.1 Novo");
	private JMenuItem acompanharPedido = new JMenuItem("2.2 Acompanhar");
	
	private JMenuItem creditos = new JMenu("3 Créditos");
	private JMenuItem exibir = new JMenuItem("3.1 Exibir");
	
	private JFrame parent = null;
	private ICloseble closeble = null;
	
	public MenuBar(ICloseble _closeble) {
		this.closeble = _closeble;
		this.add(sistema);
		this.add(pedidos);
		this.add(creditos);
		this.fonts();
		sistema.add(cadastro);
		cadastro.add(cardapio);
		cadastro.add(cliente);
		cadastro.add(bar);
		cadastro.add(entregadores);
		sistema.add(fechar);
		creditos.add(exibir);
		pedidos.add(novoPedido);
		pedidos.add(acompanharPedido);
		this.eventsConfig();
	}
	private void fonts() {
		this.setFont(Misc.FONT);
		sistema.setFont(Misc.FONT);
		pedidos.setFont(Misc.FONT);
		cadastro.setFont(Misc.FONT);
		cardapio.setFont(Misc.FONT);
		cliente.setFont(Misc.FONT);
		entregadores.setFont(Misc.FONT);
		fechar.setFont(Misc.FONT);
		bar.setFont(Misc.FONT);
		
		creditos.setFont(Misc.FONT);
		creditos.setFont(Misc.FONT);
		exibir.setFont(Misc.FONT);
		novoPedido.setFont(Misc.FONT);
		acompanharPedido.setFont(Misc.FONT);
	}
	private void eventsConfig() {
		this.fecharClick();
		this.cardapioClick();
		this.entregadoresClick();
		this.clienteClick();
		this.uniforClick();
		this.exibirClick();
		this.novoPedidoClick();
		this.acompanharPedidoClick();
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
	
	private void entregadoresClick() {
		parent = (JFrame) this.getParent();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		entregadores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new DialogEntregador(new Entregador(), parent, "Entregador Teste", screenSize.width - 100, screenSize.height - 100);
			}
		});
	}
	
	private void novoPedidoClick() {
		parent = (JFrame) this.getParent();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		novoPedido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new DialogPedido(new Pedido(), parent, "Novo pedido", screenSize.width - 100, screenSize.height - 100);
			}
		});
	}
	
	private void acompanharPedidoClick() {
		parent = (JFrame) this.getParent();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		acompanharPedido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	public interface ICloseble {
		public void close();
	}
}
