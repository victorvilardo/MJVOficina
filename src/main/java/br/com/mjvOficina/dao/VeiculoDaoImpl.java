package br.com.mjvOficina.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import br.com.mjvOficina.model.Peca;
import br.com.mjvOficina.model.Veiculo;
import br.com.mjvOficina.model.VeiculoRowMapper;

public class VeiculoDaoImpl implements VeiculoDao {
	

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private DataSource dataSource;
	
	private final Logger LOGGER = LoggerFactory.getLogger(VeiculoDaoImpl.class);
	
	@Override
	public List<Veiculo> listaVeiculo() {
		String sql = "SELECT * FROM TB_VEICULO";
		List<Veiculo> list = new ArrayList<>();
		try {
			LOGGER.info("Inicio do método listaVeiculo");
			list.addAll(template.query(sql, new VeiculoRowMapper()));
			LOGGER.info("Fim do método listaVeiculo");
			return list;
		}catch(EmptyResultDataAccessException e) {
			LOGGER.error("Erro emptyResult do método listaVeiculo: " + e.getMessage());
			return list;
		}
	}

	@Override
	public Integer cadastrarVeiculo(Veiculo veiculo) {
		LOGGER.info("Inicio do método cadastrarVeiculo");
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource).withTableName("TB_VEICULO").usingColumns("nome").usingGeneratedKeyColumns("idVeiculo");
		MapSqlParameterSource params = new MapSqlParameterSource().addValue("nome", veiculo.getNome());
		Integer key = (Integer) insert.executeAndReturnKey(params);
		
		LOGGER.info("Fim do método cadastrarVeiculo");
		return key;
	}

	@Override
	public Veiculo buscaVeiculo(String name) {
		String sql = "SELECT * FROM TB_VEICULO WHERE nome = :nome";
		try {
			LOGGER.info("Inicio do método buscaVeiculo");

			MapSqlParameterSource params = new MapSqlParameterSource().addValue("nome", name);
			Veiculo veiculo = template.queryForObject(sql, params, new VeiculoRowMapper());
			
			LOGGER.info("Fim do método buscaVeiculo");
			return veiculo;
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error("Erro emptyResult no método buscaVeiculo: " + e.getMessage());
			return null;
		}
	}

	@Override
	public void linkarPecas(List<Peca> list, Integer idVeiculo) {
		LOGGER.info("Inicio do método linkarPecas");
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource).withTableName("TB_PECA_VEICULO").usingColumns("fkIdPeca", "fkIdVeiculo");
		
		for(Peca peca : list) {
			MapSqlParameterSource param = new MapSqlParameterSource().addValue("fkIdPeca", peca.getIdPeca()).addValue("fkIdVeiculo", idVeiculo);
			
			insert.execute(param);
		}
		
		LOGGER.info("Fim do método linkarPecas");
	}
	
	@Override
	public Veiculo buscaId (Integer id) {
		String sql = "SELECT * FROM TB_VEICULO WHERE idVeiculo = :idVeiculo";
		try {
			LOGGER.info("Inicio do método getById");
			MapSqlParameterSource param = new MapSqlParameterSource().addValue("idVeiculo", id);
			Veiculo veiculo = template.queryForObject(sql, param, new VeiculoRowMapper());
			LOGGER.info("Fim do método buscaId");
			return veiculo;
		}catch(EmptyResultDataAccessException e) {
			LOGGER.error("Erro emptyResult no método buscaId: " + e.getMessage());
			return null;
		}
	}

}
