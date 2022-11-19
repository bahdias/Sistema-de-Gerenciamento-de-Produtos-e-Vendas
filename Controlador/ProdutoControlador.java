package Controlador;

import Fabrica.ProdutoFabrica;
import Modelo.Entidade;

public class ProdutoControlador extends Controlador{
	ProdutoFabrica produtoFabrica = ProdutoFabrica.getInstance();
	
	public Integer inserir(Entidade entidade) {
		return produtoFabrica.getPersistencia().inserir(entidade);
	}

	public void excluir(Integer id) {
		produtoFabrica.getPersistencia().excluir(id);
	}

	public void alterar(Entidade entidade, Integer id) {
		produtoFabrica.getPersistencia().alterar(entidade, id);
	}

	public String buscar(Integer id) {
		return produtoFabrica.getPersistencia().buscar(id);
	}

	public String buscar(String nome) {
		return produtoFabrica.getPersistencia().buscar(nome);
	}

}
