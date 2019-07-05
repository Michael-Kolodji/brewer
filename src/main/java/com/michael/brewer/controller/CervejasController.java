package com.michael.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.michael.brewer.model.Cerveja;

@Controller
@RequestMapping("/cervejas")
public class CervejasController {

	@RequestMapping("/novo")
	public String novo(Cerveja cerveja) {
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(cerveja);
		}
		
		attributes.addFlashAttribute("mensagem", "Cerveja Salva com sucesso!");
		System.out.println("=======> sku " + cerveja.getSku());
		System.out.println("=======> nome " + cerveja.getNome());
		return "redirect:/cervejas/novo";
	}
	
}