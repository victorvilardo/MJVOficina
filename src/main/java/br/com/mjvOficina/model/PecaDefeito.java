package br.com.mjvOficina.model;

public class PecaDefeito {

	private Integer idPecaDefeito;
	private Integer fkIdPeca;
	private Integer fkIdDefeito;
	private String nomePeca;
	private String nomeDefeito;
	
	public Integer getIdPecaDefeito() {
		return idPecaDefeito;
	}
	public void setIdPecaDefeito(Integer idPecaDefeito) {
		this.idPecaDefeito = idPecaDefeito;
	}
	public Integer getFkIdPeca() {
		return fkIdPeca;
	}
	public void setFkIdPeca(Integer fkIdPeca) {
		this.fkIdPeca = fkIdPeca;
	}
	public Integer getFkIdDefeito() {
		return fkIdDefeito;
	}
	public void setFkIdDefeito(Integer fkIdDefeito) {
		this.fkIdDefeito = fkIdDefeito;
	}
	public String getNomePeca() {
		return nomePeca;
	}
	public void setNomePeca(String nomePeca) {
		this.nomePeca = nomePeca;
	}
	public String getNomeDefeito() {
		return nomeDefeito;
	}
	public void setNomeDefeito(String nomeDefeito) {
		this.nomeDefeito = nomeDefeito;
	}
	
}