package br.unifor.poo.modelo;

public class Cardapio {
	protected Long id = 0l;
	protected String nome;
	protected double preco;
	protected int qtd;
	
	public Cardapio() {}
	
	public Cardapio(String nome, double preco) {
		this();
		this.nome = nome;
		this.preco = preco;
	}
	public Cardapio(String nome, double preco, int _qtd) {
		this(nome, preco);
		this.qtd = _qtd;
	}
	public Cardapio(Long _id, String nome, double preco, int _qtd) {
		this(nome, preco, _qtd);
		this.id = _id;
	}
	public Long getId() { return this.id; }
	public void setId(long _id) { this.id = _id; }
	public int getQtd() { return this.qtd; }
	public void setQtd(int _qtd) { this.qtd = _qtd; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public double getPreco() { return preco; }
	public void setPreco(double preco) { this.preco = preco; }

	@Override
	public String toString() {
		return nome + ", " + preco + ", " + qtd;
	}
}
