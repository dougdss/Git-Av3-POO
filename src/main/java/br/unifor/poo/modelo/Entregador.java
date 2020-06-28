package br.unifor.poo.modelo;

public class Entregador {
	protected Long id;
	private String nome;
	private String placa;
	
	public Entregador() {
		
	}
	
	public Entregador(String nome, String placa) {
		super();
		this.nome = nome;
		this.placa = placa;
	}

	public Entregador(Long id, String nome, String placa) {
		this.id = id;
		this.nome = nome;
		this.placa = placa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	
	
}
