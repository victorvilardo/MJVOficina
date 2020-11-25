package br.com.mjvOficina.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.mjvOficina.model.Peca;
import br.com.mjvOficina.model.Veiculo;
import br.com.mjvOficina.service.DefeitoService;
import br.com.mjvOficina.service.PecaDefeitoService;
import br.com.mjvOficina.service.PecaService;
import br.com.mjvOficina.service.VeiculoService;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VeiculoController.class);
	

	
	@Autowired
	private PecaService pecaService;
	
	@Autowired
	private VeiculoService veiculoService;

	
	
	@GetMapping
	public String cadastrarVeiculo(Model model) {
			
			
			model.addAttribute("pecasList", pecaService.listaPeca());
			
		
			
			return "";
	}
	
	
	@PostMapping("/cadastrar")
	public String salvarVeiculo(@RequestParam("peca") String[] pecas, @RequestParam("nome") String nome,Model model) {
		
		LOGGER.info("Início do método @Post salvarVeiculo");
		
		if(StringUtils.isEmpty(nome) || pecas.length == 0) {
			return "";
		}
		
		List<String> list = Arrays.asList(pecas);
		
		List<Peca> listPeca = new ArrayList<>();
		
	
		
		Veiculo veiculo = new Veiculo();
		
		veiculo.setNome(nome);
		
		Integer idVeiculo = veiculoService.cadastrarVeiculo(veiculo);
		
		for(String name : list) {
			Peca peca = pecaService.buscaPeca(name);
			listPeca.add(peca);
		}
		
		veiculoService.listarPecas(listPeca, idVeiculo);		
		return ""; 
	}
}