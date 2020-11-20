package br.com.mjvOficina.dao;

import java.util.List;

import br.com.mjvOficina.model.Peca;
import br.com.mjvOficina.model.Veiculo;

public interface VeiculoDao {

	

	List<Veiculo> listaVeiculo();
	
	
	Integer cadastrarVeiculo(Veiculo veiculo);
	

	Veiculo buscaVeiculo(String name);
	
	
	void linkarPecas(List<Peca> list, Integer idVeiculo);
	
	Veiculo buscaId(Integer id);
}
