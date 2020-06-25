package br.unifor.poo.services;

import java.util.ArrayList;
import java.util.List;

import br.unifor.poo.modelo.Bebida;
import br.unifor.poo.modelo.Cardapio;
import br.unifor.poo.modelo.Cliente;
import br.unifor.poo.modelo.ItemPedido;
import br.unifor.poo.modelo.Pedido;

public class Cadastro {	
	protected List<Cardapio> cardapio = new ArrayList<Cardapio>();
	
	public void cadastro_base_cardapio() {
		Cardapio coca = new Bebida("Coca-Cola", 5, 2000); 
		Cardapio fanta = new Bebida("Fanta", 5, 2000); 
		cardapio.add(coca);
		cardapio.add(fanta);
	}
	public void simple_compra_do_joao() {
		Cliente joao = new Cliente("Joao Silva", "Rua X");
		Pedido p1 = new Pedido(joao);
		ItemPedido item1 = new ItemPedido(p1, cardapio.get(0), 6);
		ItemPedido item2 = new ItemPedido(p1, cardapio.get(1), 7);
		p1.addItem(item1);
		p1.addItem(item2);
		p1.printItens();
		
		Pedido p2 = new Pedido(joao);
		ItemPedido item3 = new ItemPedido(p2, cardapio.get(0), 10);
		ItemPedido item4 = new ItemPedido(p2, cardapio.get(1), 3);
		p2.addItem(item3);
		p2.addItem(item4);
		p2.printItens();
	}
}
