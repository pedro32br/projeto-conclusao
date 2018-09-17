package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.models.Pedidos;

@Controller
public class PedidosServicoController {
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/pedidos")
	public ModelAndView listarPedidos() {
		ModelAndView modelAndView = new ModelAndView("/pedidos");
		String uri = "https://book-payment.herokuapp.com/orders";
		Pedidos[] pedidosPatch = restTemplate.getForObject(uri, Pedidos[].class);
		modelAndView.addObject("pedidos", pedidosPatch);
		
		return modelAndView;
	}
	
}
