package br.unifor.poo.modelo;

public class ItemPedido {
	protected Long id;
	protected int qtd;
	private Pedido pedido = null;
	private Cardapio cardapio = null;
	
	public ItemPedido() {}
	public ItemPedido(Pedido pedido, Cardapio cardapio, int quantidade) {
		this();
		this.pedido = pedido;
		this.cardapio = cardapio;
		this.qtd = quantidade;
	}
	
	public ItemPedido(Long id, Pedido pedido, Cardapio cardapio, int quantidade) {
		this();
		this.id = id;
		this.pedido = pedido;
		this.cardapio = cardapio;
		this.qtd = quantidade;
	}
	
	public Pedido getPedido() { return pedido; }
	public void setPedido(Pedido pedido) { this.pedido = pedido; }
	public Cardapio getCardapio() { return cardapio; }
	public void setCardapio(Cardapio cardapio) { this.cardapio = cardapio; }
	public int getQuantidade() { return qtd; }
	public void setQuantidade(int quantidade) { this.qtd = quantidade; }
	
	@Override
	public String toString() {
		return "[" + cardapio + ", " + qtd + "]";
	}
}
