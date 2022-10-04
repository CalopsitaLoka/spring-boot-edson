package com.fatec.grupo5.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.grupo5.model.Vaga;
import com.fatec.grupo5.services.MantemVaga;

@Controller
@RequestMapping(path = "/vaga")
public class GUIVagaController {
	
	Logger logger = LogManager.getLogger(GUIVagaController.class);
	@Autowired
	MantemVaga servico;
	
	@GetMapping("/cadastro")
	public ModelAndView cadastrarVaga(Vaga vaga) {
		ModelAndView mv = new ModelAndView("cadastrarVaga");
		List<String> lista = Arrays.asList("Em análise", "Disponível", "Pendente", "Trancada");
		mv.addObject("lista", lista);
		mv.addObject("vaga", vaga);
		return mv;
	}
	
	@PostMapping("/cadastro")
	public ModelAndView cadastrarVaga(@Valid Vaga vaga, BindingResult result) {
		ModelAndView mv = new ModelAndView("consultarVaga");
		if (result.hasErrors()) {
			List<String> lista = Arrays.asList("Em análise", "Disponível", "Pendente", "Trancada");
			mv.addObject("lista", lista);
			mv.setViewName("cadastrarVaga");
		} else {
			if (servico.save(vaga).isPresent()) {
				logger.info(">>>>>> controller chamou cadastrar e consultar todos");
				mv.addObject("vagas", servico.consultaTodos());
			} else {
				logger.info(">>>>>> controller cadastrar com dados invalidos");
				mv.setViewName("cadastrarVaga");
				mv.addObject("message", "Dados invalidos");
			}
		}
		return mv;
	}
}
