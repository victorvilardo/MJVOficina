package br.com.mjvOficina.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



	
	@Controller
	@RequestMapping("/")
	public class HomeController {

		@RequestMapping(method = RequestMethod.GET)
		public String iniciarHome() {
			return "home";
		}
		
	}
