package br.com.mjvOficina.service;

import java.util.List;

import br.com.mjvOficina.model.Defeito;
import br.com.mjvOficina.model.Peca;

public interface PecaService {

	List<Peca> listaPeca();
	
	
	Integer cadastrarPeca(Peca peca);
	
	
	Peca buscaPeca(String name);
	
	
	void listaDefeitos(List<Defeito> list, Integer idPeca);
}
