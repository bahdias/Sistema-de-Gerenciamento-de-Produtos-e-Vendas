package Testes;

import org.junit.jupiter.api.Test;

import Controlador.VendaControlador;

import org.junit.jupiter.api.Assertions;

import Modelo.Produto;
import Modelo.Venda;

public class VendaTeste {
	@Test
	void testInserir() {
		Produto produto = new Produto();
		produto.setNome("Sabonete");
		produto.setMarca("Saboneteria");
		produto.setFabricante("Lux");
		produto.setPreco((float) 1.99);
		produto.setId(0);
		
		Venda venda = new Venda();
		venda.setCliente("Bárbara");
		venda.setData("07/12/2022");
		venda.setId(0);
		venda.inserirProduto(produto);
		
		VendaControlador vendaControlador = new VendaControlador();
		vendaControlador.inserir(venda);
		
		Assertions.assertEquals(true, venda.getProdutos().get(0).equals(produto));
	}
}
