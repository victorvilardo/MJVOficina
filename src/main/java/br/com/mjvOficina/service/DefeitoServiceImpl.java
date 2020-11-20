package br.com.mjvOficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mjvOficina.dao.DefeitoDao;
import br.com.mjvOficina.model.Defeito;

public class DefeitoServiceImpl implements DefeitoService {
	
	@Autowired
	private DefeitoDao defeitoDao;
	
	@Override
	public List<Defeito> listaDefeito() {
		List<Defeito> list = defeitoDao.listaDefeito();
		return list;
	}

	@Override
	public void cadastrarDefeito(Defeito defeito) {
		defeitoDao.cadastrarDefeito(defeito);
	}

	@Override
	public Defeito buscaDefeitoNome (String name) {
		return defeitoDao.buscaDefeitoNome(name);
	}

}
