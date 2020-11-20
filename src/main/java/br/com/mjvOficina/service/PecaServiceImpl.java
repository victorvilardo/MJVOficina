package br.com.mjvOficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mjvOficina.dao.PecaDao;
import br.com.mjvOficina.model.Defeito;
import br.com.mjvOficina.model.Peca;

public class PecaServiceImpl implements PecaService {

	@Autowired
	private PecaDao pecaDao;
	
	@Override
	public List<Peca> listaPeca() {
		return pecaDao.listaPeca();
	}

	@Override
	public Integer cadastrarPeca(Peca peca) {
		return pecaDao.cadastrarPeca(peca);
	}

	@Override
	public Peca buscaPeca(String name) {
		return pecaDao.buscaPeca(name);
	}

	@Override
	public void listaDefeitos(List<Defeito> list, Integer idPeca) {
		pecaDao.listaDefeitos(list, idPeca);
	}
}
