package br.unifor.poo.modelo;

public class Bebida extends Cardapio {
	public Bebida() {}
	public Bebida(String nome, double preco) {
		super(nome, preco);
	}
	public Bebida(String nome, double preco, int qtd) {
		super(nome, preco, qtd);
	}
	public Bebida(Long _id, String nome, double preco, int qtd) {
		super(_id, nome, preco, qtd);
	}
	@Override
	public String toString() {
		return "Bebida: "+super.toString();
	}
}

