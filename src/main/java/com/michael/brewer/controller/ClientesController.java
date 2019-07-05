package com.michael.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michael.brewer.model.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@RequestMapping("/novo")
	public String novo(Cliente cliente) {
		return "clientes/CadastroCliente";
	}
}
