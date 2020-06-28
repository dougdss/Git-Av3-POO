package br.unifor.poo.services;

import java.util.ArrayList;
import java.util.List;

import br.unifor.poo.modelo.Cardapio;
import br.unifor.poo.modelo.Cliente;

public class DadosTest {
	public static List<Cardapio> cardapios = new ArrayList<Cardapio>();
	public static List<Cliente> clientes = new ArrayList<Cliente>();
	static {
		cardapios.add(new Cardapio("Coca-Cola", 5, 5000));
		cardapios.add(new Cardapio("Fanta-Laranja", 5, 4000));
		cardapios.add(new Cardapio("Suco em Caixinha", 6, 6000));
		cardapios.add(new Cardapio("Cerveja Brahma", 6, 2000));
		cardapios.add(new Cardapio("Cerveja Skoll", 7, 2800));
		cardapios.add(new Cardapio("Cerveja Skin", 5, 3800));
	}
	
	static {
		clientes.add(new Cliente("José", "Rua 1"));
		clientes.add(new Cliente("Maria", "Rua 2"));
		clientes.add(new Cliente("João", "Rua 3"));
	}
}
