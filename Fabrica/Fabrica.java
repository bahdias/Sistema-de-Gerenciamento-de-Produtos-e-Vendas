package Fabrica;

import Controlador.Controlador;
import Modelo.Entidade;
import Persistencia.Persistencia;
import Visao.Menu;

public abstract class Fabrica {
	
	public static Fabrica getFabrica(String tipoFabrica) {
		if(tipoFabrica.equals("produto")) {
			ProdutoFabrica produtoFabrica = new ProdutoFabrica();
			return produtoFabrica;
		}

		else if(tipoFabrica.equals("venda")) {
			VendaFabrica vendaFabrica = new VendaFabrica();
			return vendaFabrica;
		}
		
		return null;
	}
	
	public abstract Entidade getEntidade();
	public abstract Controlador getControlador();
	public abstract Persistencia getPersistencia();
	public abstract Menu getMenu();
}
