package Persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Modelo.Entidade;
import Modelo.Venda;

public class VendaPersistencia extends Persistencia{

	/*Classe que persiste as vendas, ou seja, realiza o gerenciamento
	 * e a busca das vendas requisitadas pelo controlador e retorna as 
	 * modificações realizadas para o controlador encaminhar para a visão.*/
	
	//Utilização do Padrão Singleton para a VendaPersistencia
	public static final VendaPersistencia vendaPersistencia = new VendaPersistencia(); 
	protected List<Venda> vendas = new ArrayList<Venda>();

	
	private VendaPersistencia() {}
	
	//Restringe uma única instancia para esta classe
	public static VendaPersistencia getInstance() {
		return vendaPersistencia;
	}

	public Integer inserir(Entidade entidade) {		
		this.vendas.add((Venda)entidade);
		return entidade.getId();
	}

	public void excluir(Integer id) {
		for(int i = 0; i < this.vendas.size(); i++) {
			if(this.vendas.get(i).getId().equals(id)) {
				vendas.remove(i);
			}
		}
	}

	public void alterar(Entidade entidade, Integer id) {
		for(int i = 0; i < this.vendas.size(); i++) {
			if(this.vendas.get(i).getId().equals(id)) {
				this.vendas.set(i, (Venda) entidade);
			}
		}		
	}

	public String buscar(Integer id) {
		for (int i = 0; i < vendas.size(); i++) {
			if (vendas.get(i).getId().equals(id)) {
				return vendas.get(i).toString();	
			}
		}
		return null;
	}

	public String buscar(String data) {
		for (int i = 0; i < vendas.size(); i++) {
			if (vendas.get(i).getData().equals(data)) {
				return vendas.get(i).toString();
			}	
		}
		return null;
	}
	
	public List<Venda> getVenda(){
		return this.vendas;
	}

	public void criarArquivo() {
		File arquivoVendas = new File("arquivoVendas.txt");

		if(arquivoVendas.exists()) {
			arquivoVendas.delete();
		}
		try {
			arquivoVendas.createNewFile();
			FileWriter file = new FileWriter(arquivoVendas);
			PrintWriter print = new PrintWriter(file, true);
			print.println(vendas.get(vendas.size()-1).toString());

			print.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
