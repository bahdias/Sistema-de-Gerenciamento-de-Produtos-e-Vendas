package Modelo;

public class Produto extends Entidade{
	private String nome;
	private String marca;
	private String fabricante;
	private Float preco;

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public Float getPreco() {
		return preco;
	}
	
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	
	public String toString() {
		return "Produto: " + this.getNome() +
				"\nIdentificador do produto: " + this.getId() +
				"\nMarca: " + this.getMarca() +
				"\nFabricante: " + this.getFabricante() +
				"\nPreço: " + this.getPreco();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
