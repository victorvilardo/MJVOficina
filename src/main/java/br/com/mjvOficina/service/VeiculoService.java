package br.com.mjvOficina.service;

import java.util.List;
import br.com.mjvOficina.model.Peca;
import br.com.mjvOficina.model.Veiculo;

public interface VeiculoService {

	
	List<Veiculo> listaVeiculo();
	

	Integer cadastrarVeiculo(Veiculo veiculo);
	

	Veiculo getVeiculoFirstResultByName(String name);
	

	void linkarPecas(List<Peca> list, Integer idVeiculo);
	}

