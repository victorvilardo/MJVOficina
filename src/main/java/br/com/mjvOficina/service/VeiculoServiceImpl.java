package br.com.mjvOficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjvOficina.dao.VeiculoDao;
import br.com.mjvOficina.model.Peca;
import br.com.mjvOficina.model.Veiculo;


	
@Service
public class VeiculoServiceImpl implements VeiculoService {

		@Autowired
		private VeiculoDao veiculoDao;
		
		@Override
		public List<Veiculo> listaVeiculo() {
			return veiculoDao.listaVeiculo();
		}

		@Override
		public Integer cadastrarVeiculo(Veiculo veiculo) {
			return veiculoDao.cadastrarVeiculo(veiculo);
		}

		@Override
		public Veiculo buscaVeiculo(String name) {
			return veiculoDao.buscaVeiculo(name);
		}

		@Override
		public void listarPecas(List<Peca> list, Integer idVeiculo) {
			veiculoDao.linkarPecas(list, idVeiculo);
		}
}
