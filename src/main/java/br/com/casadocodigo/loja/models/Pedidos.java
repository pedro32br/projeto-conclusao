package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Pedidos{
	
	private int id;
	private BigDecimal valor;
	private Calendar data;
	private List<Produto> produtos = new ArrayList<>();
	
	public Pedidos() {
	}
	
	public Pedidos(int id, BigDecimal valor, Calendar data, List<Produto> produtos) {
		super();
		this.id = id;
		this.valor = valor;
		this.data = data;
		this.produtos = produtos;
	}

	public int getId() {
		return id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public Calendar getData() {
		return data;
	}
}
