package Controlador;

import Fabrica.VendaFabrica;
import Modelo.Entidade;

public class VendaControlador extends Controlador{
	VendaFabrica vendaFabrica = VendaFabrica.getInstance();

	public Integer inserir(Entidade entidade) {
		return vendaFabrica.getPersistencia().inserir(entidade);		
	}

	public void excluir(Integer id) {
		vendaFabrica.getPersistencia().excluir(id);
	}

	public void alterar(Entidade entidade, Integer id) {
		vendaFabrica.getPersistencia().alterar(entidade, id);
	}

	public String buscar(Integer id) {
		return vendaFabrica.getPersistencia().buscar(id);
	}

	public String buscar(String data) {
		return vendaFabrica.getPersistencia().buscar(data);
	}

}
