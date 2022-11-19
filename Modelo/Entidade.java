package Modelo;

public abstract class Entidade {
	protected Integer id = 0;
	
	public abstract Integer getId();
	public abstract void setId(Integer id);
	public abstract String toString();
}
