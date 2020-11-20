package br.com.mjvOficina.model;

import java.util.ArrayList;
import java.util.List;

public class Veiculo {

	
	private Integer idVeiculo;
	private String nome;
	private List<Peca> pecas = new ArrayList<>();
	
	public Integer getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Peca> getPecas() {
		return pecas;
	}
}
