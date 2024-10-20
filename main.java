package controle2;
import java.util.Scanner; 

public class main {
	public static void main(String[] args) {
		
		// criar um objeto Scanner p/ ler a entrada do usuario 
		Scanner scanner = new Scanner(System.in); 
		
		//criar um objeto produto 
		controle2.Produto produto = new Produto(); 
		
		//Solicitar o nome do produto 
		System.out.print("Nome do produto: "); 
		produto.setNome(scanner.nextLine()); 
		
		//Solicita a quantidade comprada 
		System.out.print("Quantidade: "); 
		produto.setQuantidade(scanner.nextInt()); 
		
		//Solicita o valor 
		System.out.print("Valor do produto: ");
		produto.setPrecoUnitario(scanner.nextDouble()); 
		
		//calcula o total 
		
		double valorTotal = produto.calcularTotal(); 
		
		System.out.println("Produto comprado: " + produto.getNome() + "\n" + "Quantidade total: " + produto.getQuantidade()); 
		System.out.printf("\n\nValor total da compra: R$ %.2f%n", valorTotal); 
		
		scanner.close(); 
	}
}
