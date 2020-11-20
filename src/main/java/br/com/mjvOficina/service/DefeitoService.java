package br.com.mjvOficina.service;

import java.util.List;

import br.com.mjvOficina.model.Defeito;

public interface DefeitoService {

	

	List<Defeito> listaDefeito();
	
	
	void cadastrarDefeito(Defeito defeito);
	
	
	Defeito buscaDefeitoNome(String name);
}
