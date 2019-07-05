package com.michael.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estilos")
public class EstiloController {

	@RequestMapping("/novo")
	public String novo() {
		return "estiloCerveja/CadastroEstilo";
	}
	
}
