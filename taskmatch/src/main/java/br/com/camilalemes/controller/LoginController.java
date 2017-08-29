package br.com.camilalemes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@GetMapping("/login")
	public ModelAndView init() {
		return new ModelAndView("/login");
	}
	
	@GetMapping("/redefinir-senha")
	public ModelAndView redefinirSenha() {
		return new ModelAndView("/redefinir-senha");
	}
}
