package Visao;

import java.util.Scanner;

import Fabrica.Fabrica;
import Fabrica.ProdutoFabrica;
import Modelo.Produto;

public class ProdutoMenu extends Menu{	

	@Override
	public Integer opcoesMenu(Scanner scanner) {

		System.out.println("VOCÊ FOI ENCAMINHADO(A) PARA O SISTEMA DE GERENCIAMENTO DE PRODUTOS");
		System.out.println("Selecione o que deseja realizar:");
		System.out.println("[1] - INSERIR UM NOVO PRODUTO");
		System.out.println("[2] - EXCLUIR UM PRODUTO");
		System.out.println("[3] - ALTERAR DADOS DE UM PRODUTO");
		System.out.println("[4] - BUSCAR UM PRODUTO POR ID");
		System.out.println("[5] - BUSCAR UM PRODUTO POR NOME");
		System.out.println("[0] - SAIR");
		return Integer.parseInt(scanner.next());
	}
	
	@Override
	public void acoesMenu(Integer opcao, Scanner scanner) {
		Integer id;

		setFabrica(Fabrica.getFabrica("produto"));
		setControlador(this.fabrica.getControlador());
		
		switch (opcao) {
			case 1:
				inserir(scanner);
				break;
			case 2:
				System.out.println("Informe o identificador do produto: ");
				id = scanner.nextInt();
				excluir(id);
				break;
			case 3:
				System.out.println("Informe o identificador do produto: ");
				id = scanner.nextInt();
				alterar(id, scanner);
				break;
			case 4:
				System.out.println("Informe o identificador do produto: ");
				id = scanner.nextInt();
				buscar(id);
				break;
			case 5:
				System.out.println("Informe o nome do produto: ");
				String data = scanner.next();
				buscar(data);
				break;
			case 0:
				break;
			default:
				System.out.println("Opção incorreta! Tente novamente.");
				break;	
		}
		return;
	}
	
	
	
	public void inserir(Scanner scanner) {
		
		Produto produto = ((ProdutoFabrica)this.fabrica).getProduto();//pede para a fabrica de produto (atributo fabrica) o Produto
		
		System.out.println("Informe abaixo as seguintes informações: Nome do Produto, a Marca, o Fabricante, o Preço e o Identificador: \n"
				+ "(Seguindo a ordem especificada e separado por espaço) ");

		produto.setNome(scanner.next());
		produto.setMarca(scanner.next());
		produto.setFabricante(scanner.next());
		produto.setPreco(Float.parseFloat(scanner.next()));
		produto.setId(scanner.nextInt());
		
		this.controlador.inserir(produto);
		
		System.out.println("Produto inserido com sucesso! Id gerado: " + this.controlador.inserir(produto));
	}
	
	public void excluir(Integer id) {
		this.fabrica.getControlador().excluir(id);
		System.out.println("Produto excluido com sucesso!");
	}
	
	public void alterar(Integer id, Scanner scanner) {
		System.out.println("Informe abaixo as informações alteradas: Nome do Produto, Marca do Produto, o Fabricante e o Preço: \n"
				+ "(Seguindo a ordem especificada e separado por espaço) ");
		
		Produto produto = ((ProdutoFabrica)this.fabrica).getProduto();

		produto.setNome(scanner.next());
		produto.setMarca(scanner.next());
		produto.setFabricante(scanner.next());
		produto.setPreco(Float.parseFloat(scanner.next()));
		produto.setId(id);
		
		this.controlador.alterar(produto, id);
		System.out.println("Produto alterado com sucesso!");
	}
	
	public void buscar(Integer id) {
		System.out.println(this.controlador.buscar(id));	
	}

	public void buscar(String nome) {
		System.out.println(this.controlador.buscar(nome));		
	}

}
