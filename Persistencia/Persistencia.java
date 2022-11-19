package Persistencia;

import Modelo.Entidade;

public abstract class Persistencia {
	/*Classe que persiste os dados, ou seja, manipula os dados 
	 * requisitados pelo controlador e retorna as modifica��es
	 * feitas para o controlador encaminhar para a vis�o.*/
	
	public abstract Integer inserir(Entidade entidade);
	public abstract void excluir(Integer id);
	public abstract void alterar(Entidade entidade, Integer id);
	public abstract String buscar(Integer id);
	public abstract String buscar(String id);
	
}
