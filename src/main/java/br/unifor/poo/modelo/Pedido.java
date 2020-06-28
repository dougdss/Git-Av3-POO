package br.unifor.poo.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	protected Long id;
	protected Cliente cliente = null;
	private String situacao = "pendente";
	protected String data = null;
	protected List<ItemPedido> itens = new ArrayList<ItemPedido>();
	
	public Pedido() { }
	public Pedido(Cliente cliente) {	
		this();
		this.data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		this.cliente = cliente;
	}
	public void addItem(ItemPedido item) {
		itens.add(item);
	}
	public void printItens() {
		itens.forEach(item->{
			System.out.println(item);
		});
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSituacao() { return situacao; }
	public void setSituacao(String situacao) { this.situacao = situacao; }
	public String getData() { return data; }
	public void setData(String data) { this.data = data; }
	public Cliente getCliente() { return cliente; }
	public void setCliente(Cliente cliente) { this.cliente = cliente; }
}
