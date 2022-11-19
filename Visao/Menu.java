package Visao;

import java.util.Scanner;

import Controlador.Controlador;
import Fabrica.Fabrica;
import Fabrica.ProdutoFabrica;
import Fabrica.VendaFabrica;
import Persistencia.ProdutoPersistencia;
import Persistencia.VendaPersistencia;

public class Menu {
	
	protected Fabrica fabrica; //fazer os métodos set e get
	protected Controlador controlador; // fazer os metodos set e get
	
	public void setFabrica(Fabrica fab) {
		this.fabrica = fab;
	}
	
	public void setControlador(Controlador cont) {
		this.controlador = cont;
	}	
		
	public void showMenu(Scanner scanner) {
		while (true) {
			int opcao = opcoesMenu(scanner);
			if (opcao == 0) 
				break;
			acoesMenu(opcao, scanner);
		}
	}
	
	public Integer opcoesMenu(Scanner scanner) {
		
		System.out.println("BEM VINDO(A) AO SISTEMA DE GERENCIAMENTO DE PRODUTOS E VENDAS");
		System.out.println("Selecione o que deseja gerenciar:");
		System.out.println("[1] - PRODUTOS");
		System.out.println("[2] - VENDAS");
		System.out.println("[0] - SAIR");
		return Integer.parseInt(scanner.next());
		
	}
	
	public void acoesMenu(Integer opcao, Scanner scanner) {
		Integer opcoes;
		switch (opcao) {
			case 0:
				return;
			case 1:
				//pedir para a fabrica abstrata mandar a fabrica de produto e guardar ela no atributo fabrica
				//pedir para a fabrica de produto o controlador de produto e guardar no atributo controlador
				//pedir oara o controlador pedir para a persistencia carregar a lista com os produtos do arquivo
				//pedir para a fabrica de produto o menu de produto
				//user os métodos set de fabrica e controlador do menu do produto
				//executar o método showMenu do menu de produto
				//pede para o controlador pedir para a persistencia gravar a lsita no arquivo

				setFabrica(Fabrica.getFabrica("produto"));
				setControlador(this.fabrica.getControlador());
				opcoes = ((ProdutoFabrica)this.fabrica).getMenu().opcoesMenu(scanner);
				((ProdutoFabrica)this.fabrica).getMenu().acoesMenu(opcoes,scanner);
				ProdutoPersistencia produtoPersistencia= (ProdutoPersistencia) ((ProdutoFabrica)this.fabrica).getPersistencia();
				produtoPersistencia.criarArquivo();
				break;
			case 2:
				//fazer igual ao anterior só que pra venda

				setFabrica(Fabrica.getFabrica("venda"));
				setControlador(this.fabrica.getControlador());
				opcoes = ((VendaFabrica)this.fabrica).getMenu().opcoesMenu(scanner);
				((VendaFabrica)this.fabrica).getMenu().acoesMenu(opcoes, scanner);
				VendaPersistencia vendaPersistencia= (VendaPersistencia) ((VendaFabrica)this.fabrica).getPersistencia();
				vendaPersistencia.criarArquivo();
				break;	
		}
	}
		
	
	
}
