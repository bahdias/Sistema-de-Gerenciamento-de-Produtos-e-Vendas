package Visao;

import java.util.Scanner;

import Fabrica.Fabrica;
import Fabrica.ProdutoFabrica;
import Fabrica.VendaFabrica;
import Modelo.Venda;

public class VendaMenu extends Menu{
	@Override
	public Integer opcoesMenu(Scanner scanner) { //mudar pra venda menu

		System.out.println("VOCÊ FOI ENCAMINHADO(A) PARA O SISTEMA DE GERENCIAMENTO DE VENDAS");
		System.out.println("Selecione o que deseja realizar:");
		System.out.println("[1] - REALIZAR UMA VENDA");
		System.out.println("[2] - EXCLUIR UMA VENDA REALIZADA");
		System.out.println("[3] - ALTERAR DADOS DE UMA VENDA");
		System.out.println("[4] - BUSCAR UMA VENDA POR ID");
		System.out.println("[5] - BUSCAR UMA VENDA POR DATA");
		System.out.println("[0] - SAIR");
		return scanner.nextInt();
	}
	
	@Override
	public void acoesMenu(Integer opcao, Scanner scanner) {
		Integer id;

		setFabrica(Fabrica.getFabrica("venda"));
		setControlador(this.fabrica.getControlador());
		
		switch (opcao) {
			case 1:
				inserir(scanner);
				return;
			case 2: 
				System.out.println("Informe o identificador da venda: ");
				id = scanner.nextInt();
				excluir(id);
				return;
			case 3:
				System.out.println("Informe o identificador da venda: ");
				id = scanner.nextInt();
				alterar(id, scanner);
				return;
			case 4:
				System.out.println("Informe o identificador da venda: ");
				id = scanner.nextInt();
				buscar(id);
				return;
			case 5: 
				System.out.println("Informe a data da venda: ");
				String data = scanner.next();
				buscar(data);
				return;
			case 0:
				return;
			default:
				System.out.println("Opção incorreta! Tente novamente.");
				return;
		}
	}
	
	
	public void inserir(Scanner scanner) {
		Venda venda = ((VendaFabrica)this.fabrica).getVenda();
		ProdutoFabrica produto = (ProdutoFabrica) Fabrica.getFabrica("produto");
		
		System.out.println("Informe abaixo as seguintes informações: Data da venda, o Cliente e o Identificador: \n"
				+ "(Seguindo a ordem especificada e separado por espaço) ");
		
		venda.setData(scanner.next());
		venda.setCliente(scanner.next());
		venda.setId(scanner.nextInt());
		
		Integer condicaoParada = 0;
		Float precoTotal = (float) 0.0;
		while(!condicaoParada.equals(-1)) {			
			System.out.println("Informe o identificador do produto que foi vendido: (Para parar digite '-1')");			
			condicaoParada = scanner.nextInt();
			
			if(condicaoParada != -1) {
				venda.inserirProduto(produto.getListaProdutos().get(condicaoParada));
				precoTotal += produto.getListaProdutos().get(condicaoParada).getPreco();
			}
			
		}

		venda.setPrecoTotal(precoTotal);
		System.out.println("Venda inserida com sucesso! Id gerado: " + this.controlador.inserir(venda));
	}
	
	public void excluir(Integer id) {
		this.controlador.excluir(id);
		System.out.println("Venda excluida com sucesso!");
	}
	
	public void alterar(Integer id, Scanner scanner) {
		Venda venda = ((VendaFabrica)this.fabrica).getVenda();
		ProdutoFabrica produto = (ProdutoFabrica) Fabrica.getFabrica("produto");
		
		System.out.println("Informe abaixo as seguintes informações: Data da venda e Cliente: \n"
				+ "(Seguindo a ordem especificada e separado por espaço) ");

		venda.setData(scanner.next());
		venda.setCliente(scanner.next());
		venda.setId(id);
		
		Integer condicaoParada = 0;
		Float precoTotal = (float) 0.0;
		
		while(!condicaoParada.equals(-1)) {
			
			System.out.println("Informe o identificador do produto que foi vendido: (Para parar digite '-1')");			
			condicaoParada = scanner.nextInt();
			
			if(condicaoParada != -1) {
				venda.inserirProduto(produto.getListaProdutos().get(condicaoParada));
				precoTotal += produto.getListaProdutos().get(condicaoParada).getPreco();
			}
			
		}
		
		venda.setPrecoTotal(precoTotal);
		
		this.controlador.alterar(venda, id);
		System.out.println("Venda alterada com sucesso!");
	}
	
	public void buscar(Integer id) {
		System.out.println(this.controlador.buscar(id));	
	}

	public void buscar(String data) {
		System.out.println("Informe o nome do produto que deseja buscar: ");
		System.out.println(this.controlador.buscar(data));		
	}

}