package br.com.mjvOficina.controller;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.mjvOficina.model.Defeito;
import br.com.mjvOficina.model.Peca;
import br.com.mjvOficina.service.DefeitoService;
import br.com.mjvOficina.service.PecaService;



@Controller
@RequestMapping("/peca")
public class PecaController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PecaController.class);
	
	@Autowired
	private PecaService pecaService;
	
	@Autowired
	private DefeitoService defeitoService;
	
	
	@GetMapping
	public String cadastrarPeca(Model model) {
			LOGGER.info("Início do método @Get cadastrarPeca");
			
			model.addAttribute("defeitosList", defeitoService.listaDefeito());
			
			LOGGER.info("Fim do método @Get cadastrarPeca");
			
			return "cadastrarpeca";
	}
	
	
	@SuppressWarnings("deprecation")
	@PostMapping("/cadastrar")
	public String salvarPeca(@RequestParam("defeito") String[] defeitos, @RequestParam("nome") String nome,Model model) {
		

		
		if(StringUtils.isEmpty(nome) || defeitos.length == 0) {
			return "redirect:/peca";
		}
		
		List<String> list = Arrays.asList(defeitos);
		
		List<Defeito> listDefeitos = new ArrayList<>();
		
		Peca peca = new Peca();
		
		peca.setNome(nome);
		
		Integer idPeca = pecaService.cadastrarPeca(peca);
		
		for(String name : list) {
			Defeito defeito = defeitoService.buscaDefeitoNome(name);
			listDefeitos.add(defeito);
		}
		
		pecaService.listaDefeitos(listDefeitos, idPeca);
		

		return "cadastroconcluido"; 
	}
	

	@RequestMapping(value="/checkname", method=RequestMethod.GET)
	@ResponseBody 
	public ResponseEntity<Object> checkPecasName(@RequestParam(required = false) String name) {
		LOGGER.info("Inicio do método @Get checkPecasName");
		
		String pec = name.substring(0, 1).toUpperCase() + name.substring(1);
		
		Peca peca = pecaService.buscaPeca(pec);
		
		if(peca == null) {
	
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
	
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}