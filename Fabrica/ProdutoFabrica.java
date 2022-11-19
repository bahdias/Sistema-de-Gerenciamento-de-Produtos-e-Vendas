package Fabrica;


import java.util.List;

import Controlador.Controlador;
import Controlador.ProdutoControlador;
import Modelo.Entidade;
import Modelo.Produto;
import Persistencia.Persistencia;
import Persistencia.ProdutoPersistencia;
import Visao.Menu;
import Visao.ProdutoMenu;

public class ProdutoFabrica extends Fabrica{
	public static final ProdutoFabrica produtoFabrica = new ProdutoFabrica();
	
	public ProdutoFabrica() {}
	
	public static ProdutoFabrica getInstance() {
		return produtoFabrica;
	}
	
	public Produto getProduto() {
		Produto produto = new Produto();
		return produto;
	}
	
	public List<Produto> getListaProdutos(){
		ProdutoPersistencia produtoPersistencia = ProdutoPersistencia.getInstance();
		return produtoPersistencia.getProduto();		
	}

	public Entidade getEntidade() {
		Produto produto = new Produto();
		return produto;
	}

	public Controlador getControlador() {
		ProdutoControlador produtoControlador = new ProdutoControlador();
		return produtoControlador;
		
	}

	public Persistencia getPersistencia() {
		ProdutoPersistencia persistencia = ProdutoPersistencia.getInstance();
		return persistencia;
		
	}

	public Menu getMenu() {
		ProdutoMenu produtoMenu = new ProdutoMenu();
		return produtoMenu;
	}

}
