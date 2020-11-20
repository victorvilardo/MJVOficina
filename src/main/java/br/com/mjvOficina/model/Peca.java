package br.com.mjvOficina.model;

import java.util.ArrayList;
import java.util.List;

public class Peca {


	private Integer idPeca;
	private String nome;
	private List<Defeito> defeitos = new ArrayList<>();
	
	public Integer getIdPeca() {
		return idPeca;
	}
	public void setIdPeca(Integer idPeca) {
		this.idPeca = idPeca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Defeito> getDefeitos() {
		return defeitos;
	}
	
}
