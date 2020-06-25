package br.unifor.poo.modelo;

public class Bar {
	protected long id;
	protected String nome;
	protected String lema;
	protected String historico;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLema() {
		return lema;
	}
	public void setLema(String lema) {
		this.lema = lema;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historio) {
		this.historico = historio;
	}
}
