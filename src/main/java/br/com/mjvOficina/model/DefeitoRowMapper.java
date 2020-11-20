package br.com.mjvOficina.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

public class DefeitoRowMapper implements RowMapper<Defeito> {
	
	private final Logger LOGGER = LoggerFactory.getLogger(DefeitoRowMapper.class);
	
	@Override
	public Defeito mapRow(ResultSet rs, int rowNum) throws SQLException {
		LOGGER.info("Inicio Defeito rowMapper");
		Defeito defeito = new Defeito();
		
		defeito.setIdDefeito(rs.getInt("idDefeito"));
		defeito.setNome(rs.getString("nome"));
		
		LOGGER.info("Fim Defeito rowMapper");
		return defeito;
	}

}
