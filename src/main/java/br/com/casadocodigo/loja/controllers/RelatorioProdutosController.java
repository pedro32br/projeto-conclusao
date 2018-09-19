package br.com.casadocodigo.loja.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;

@Controller
public class RelatorioProdutosController {
	
	@Autowired
	private ProdutoDAO dao;
	
	@GetMapping(value="/relatorio-produtos", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView relatorio(@RequestParam(value="data", required=false) @DateTimeFormat(pattern="dd/MM/yyyy") Calendar data) {
		ModelAndView modelAndView = new ModelAndView("relatorioProduto");
		if(data == null) {
			List<Produto> produtos = dao.listar();
			int quantidade = produtos.size();
			modelAndView.addObject("quantidade", quantidade);
			modelAndView.addObject("produto", produtos);
		} else {
			List<Produto> produtosData = dao.dataLancamento(data);
			int quantidade = produtosData.size();
			modelAndView.addObject("quantidade", quantidade);
			modelAndView.addObject("produto", produtosData);
		}
		Calendar cal = Calendar.getInstance();
		modelAndView.addObject("dataGeracao" ,cal);
		
		return modelAndView;
	}

}
