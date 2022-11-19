package Controlador;

import Modelo.Entidade;
public abstract class Controlador{
	
	public abstract Integer inserir(Entidade entidade);
	public abstract void excluir(Integer id);
	public abstract void alterar(Entidade entidade, Integer id);
	public abstract String buscar(Integer id);
	public abstract String buscar(String id);
}
