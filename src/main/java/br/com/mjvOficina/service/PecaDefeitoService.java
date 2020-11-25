package br.com.mjvOficina.service;



import java.util.List;

import br.com.mjvOficina.model.PecaDefeito;



public interface PecaDefeitoService {

	List<PecaDefeito> recuperarListDefeito(Integer idPeca);
}