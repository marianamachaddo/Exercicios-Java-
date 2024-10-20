package controle2;
import java.io.Serializable;

public class Produto implements Serializable {
	private String nome; 
	private int quantidade; 
	private double precoUnitario; 
	
	// construtor padrao
	public Produto() {} 
	
	public String getNome() {
		return nome; 
		
	}
	
	public void setNome(String nome) {
		this.nome = nome; 
		
	}
	
	public int getQuantidade() {
		return quantidade; 
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade; 
	}
	
	public double getprecoUnitario() {
		return precoUnitario; 
	}
	
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario; 
	}
	
	//metodo para calcular o valor da compra 
	
	public double calcularTotal() {
		return this.quantidade * this.precoUnitario; 
	}
}
