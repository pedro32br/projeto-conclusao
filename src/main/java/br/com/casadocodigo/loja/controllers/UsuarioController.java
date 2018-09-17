package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.RoleDAO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Autowired
	private RoleDAO roleDao;
	
	@InitBinder("usuario")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation());
	}
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("usuarios/lista");
		List<Usuario> usuarios = usuarioDao.listar();
		modelAndView.addObject("usuarios", usuarios);
		
		return modelAndView;
	}
	
	@GetMapping("/form")
	public String form(Usuario usuario) {
		return "usuarios/form";
	}
	
	@PostMapping
	public ModelAndView gravar(@Valid Usuario usuario, BindingResult result, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("usuarios/form");
		
		if(result.hasErrors()) {
			return modelAndView;
		}
		Usuario checarUsuario = usuarioDao.gravar(usuario);
		
		if(!usuario.getEmail().equals(checarUsuario.getEmail())) {
			redirectAttributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso");
			return new ModelAndView("redirect:/usuarios");
		} else {
			redirectAttributes.addFlashAttribute("falha", "Email já cadastrado, tente outro email");
			return new ModelAndView("redirect:/usuarios/form");
		}
		
	}
	
	@RequestMapping("/alterar-permissao")
	public ModelAndView setRole(String email, Role role) {
		ModelAndView modelAndView = new ModelAndView("usuarios/alteraRole");
		Usuario usuarioEmail = usuarioDao.find(email);
		List<Role> roles = roleDao.listaRole();
		modelAndView.addObject("usuario", usuarioEmail);
		modelAndView.addObject("roles", roles);
		
		return modelAndView;
	}
	
	@PostMapping("/alterar-permissao")
	public ModelAndView alterar(Usuario usuario, BindingResult result, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("usuarios/lista");
		
		if(result.hasErrors()) {
			return modelAndView;
		}
		
		usuarioDao.setRole(usuario);
		redirectAttributes.addFlashAttribute("sucesso", "Permissões alteradas com sucesso");
		return new ModelAndView("redirect:/usuarios");
	}
	
}
