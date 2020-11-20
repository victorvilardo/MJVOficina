package br.com.mjvOficina.dao;

import java.util.List;

import br.com.mjvOficina.model.Defeito;

public interface DefeitoDao {



	List<Defeito> listaDefeito();
	

	void cadastrarDefeito(Defeito defeito);

	Defeito buscaDefeitoNome (String name);
	

	Defeito buscaId (Integer id);
}
