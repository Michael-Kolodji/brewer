package com.michael.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.michael.brewer.model.Estilo;
import com.michael.brewer.service.CadastroEstiloService;
import com.michael.brewer.service.exception.NomeEstiloJaCadastroException;

@Controller
@RequestMapping("/estilos")
public class EstilosController {

	@Autowired
	CadastroEstiloService estiloService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Estilo estilo) {
		return new ModelAndView("estilo/CadastroEstilo");
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(estilo);
		}
		
		try {
			estiloService.salvar(estilo);
		} catch (NomeEstiloJaCadastroException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(estilo);
		}
		
		attributes.addFlashAttribute("mensagem", "Estilo salvo com sucesso!");
		
		return new ModelAndView("redirect:/estilos/novo");
		
	}
	
}
