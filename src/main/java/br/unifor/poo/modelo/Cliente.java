package br.unifor.poo.modelo;

public class Cliente {
	protected Long id;
	protected String nome;
	protected String endereco;
	protected Boolean ativo = true;

	public Cliente() { }
	public Cliente(String nome, String endereco) {
		this();
		this.nome = nome;
		this.endereco = endereco;
	}
	public Cliente(Long _id, String nome, String endereco) {
		this(nome, endereco);
		this.id = _id;
	}
	public Long getId() { return id; }
	public void setId(Long _id) { this.id = _id; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public String getEndereco() { return endereco; }
	public void setEndereco(String endereco) { this.endereco = endereco; }
	public boolean isAtivo() { return ativo; }
	public void setAtivo(boolean ativo) { this.ativo = ativo; }
	
	@Override
	public String toString() {
		return "["+nome+"]";
	}
}