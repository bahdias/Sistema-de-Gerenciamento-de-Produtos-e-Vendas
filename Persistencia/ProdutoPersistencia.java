package Persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Modelo.Entidade;
import Modelo.Produto;

public class ProdutoPersistencia extends Persistencia{
	public static final ProdutoPersistencia produtoPersistencia = new ProdutoPersistencia();
	protected List<Produto> produtos = new ArrayList<Produto>();
	public ProdutoPersistencia() {}
	
	public static ProdutoPersistencia getInstance() {
		return produtoPersistencia;
	}
	
	public Integer inserir(Entidade entidade) {		
		this.produtos.add((Produto) entidade);
		return entidade.getId();
	}

	public void excluir(Integer id) {
		for(int i = 0; i < this.produtos.size(); i++) {
			if(this.produtos.get(i).getId().equals(id)) {
				this.produtos.set(i, null);
			}
		}
		
	}

	public void alterar(Entidade entidade, Integer id) {
		for(int i = 0; i < this.produtos.size(); i++) {
			if(this.produtos.get(i).getId().equals(id)) {
				this.produtos.set(i, (Produto) entidade);
			}
		}
		
	}

	public String buscar(Integer id) {
		for (int i = 0; i < this.produtos.size(); i++) {
			if (this.produtos.get(i).getId().equals(id)) {
					return this.produtos.get(i).toString();	
			}
		}
		return null;
	}

	public String buscar(String nome) {
		for (int i = 0; i < this.produtos.size(); i++) {
			if (this.produtos.get(i).getNome().equals(nome)) {
				return this.produtos.get(i).toString();
			}	
		}

		return null;
	}
	
	public List<Produto> getProduto() {
		return this.produtos;
	}
	
	public void criarArquivo() {
		File arquivoProdutos = new File("arquivoProdutos.txt");

		if(arquivoProdutos.exists()) {
			arquivoProdutos.delete();
		}
		try {
			arquivoProdutos.createNewFile();
			FileWriter file = new FileWriter(arquivoProdutos);
			PrintWriter print = new PrintWriter(file, true);
			print.println(produtos.get(produtos.size()-1).toString());

			print.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
