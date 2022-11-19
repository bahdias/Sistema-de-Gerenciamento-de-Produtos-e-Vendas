package Fabrica;

import java.util.List;

import Controlador.Controlador;
import Controlador.VendaControlador;
import Modelo.Entidade;
import Modelo.Venda;
import Persistencia.Persistencia;
import Persistencia.VendaPersistencia;
import Visao.Menu;
import Visao.VendaMenu;

public class VendaFabrica extends Fabrica{
	public static final VendaFabrica vendaFabrica = new VendaFabrica();
	
	public VendaFabrica() {}
	
	public static VendaFabrica getInstance() {
		return vendaFabrica;
	}
	
	public Venda getVenda(){
		Venda venda = new Venda();
		return venda;
	}

	public List<Venda> getListaVendas(){
		VendaPersistencia vendaPersistencia = VendaPersistencia.getInstance();
		return vendaPersistencia.getVenda();
	}
	
	public Entidade getEntidade() {
		Venda venda = new Venda();
		return venda;
	}

	public Controlador getControlador() {
		VendaControlador vendaControlador = new VendaControlador();
		return vendaControlador;
	}

	public Persistencia getPersistencia() {
		VendaPersistencia vendaPersistencia = VendaPersistencia.getInstance();
		return vendaPersistencia;
	}

	public Menu getMenu() {
		VendaMenu vendaMenu = new VendaMenu();
		return vendaMenu;
	}

}
