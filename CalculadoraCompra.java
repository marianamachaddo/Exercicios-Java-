package controle;
import java.util.Scanner;

public class CalculadoraCompra {
	public static void main(String[] args) {
		// cria um objeto Scanner para ler a entrada do usuario 
		Scanner scanner = new Scanner(System.in); 
		
		//Solicita o nome do produto 
		System.out.println("Digite o nome do produto: "); 
		String nomeProduto = scanner.nextLine(); 
		
		// Solicita a quantidade comprada 
		System.out.println("Quantidade comprada"); 
		int quantidade = scanner.nextInt();  
		
		//Solicita o preco unitario do produto
		System.out.println("Preco unitario do produto: ");
		double precoUnitario = scanner.nextDouble(); 
		
		// calculando o valor total 
		double valorTotal = quantidade * precoUnitario; 
		
		//Exibe a mensagem com o nome do produto e o valor total da compra 
		System.out.println("Voce comprou " + quantidade + " unidades de:  " + nomeProduto); 
		System.out.println("O valor da compra é de R$: " + valorTotal); 
		
		scanner.close(); 
	}

}
