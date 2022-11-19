package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Venda extends Entidade{
	private String data;
	private String cliente;
	private Float precoTotal;
	private List<Produto> produtos = new ArrayList<Produto>();

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Float precoTotal) {
		this.precoTotal = precoTotal;
	}

	public List<Produto> getProdutos() {
		if(produtos != null) {
			return produtos;
		}
		return null;
	}

	public Integer inserirProduto(Produto produto) {
		this.produtos.add(produto);
		return produtos.get(produtos.size()-1).getId();
	}
	
	public void excluirProduto() {
			this.produtos.clear();
			setPrecoTotal((float) 0.0);
	}
	

	public String toString() {
		String produtosVendidos = "";
		for(int i = 0; i < produtos.size(); i++) {
			produtosVendidos += produtos.get(i).getNome() + " ";
		}

		return "Data: " + this.getData() +
				"\nIdentificador da venda: " + this.getId() +
				"\nCliente: " + this.getCliente() +
				"\nProdutos: " + produtosVendidos +
				"\nPreço: " + this.getPrecoTotal();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
