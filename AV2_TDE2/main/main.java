import controle.PacienteControle;
import dominio.Paciente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PacienteControle controle = new PacienteControle("pacientes.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistema de Gerenciamento de Pacientes ===");
            System.out.println("1. Incluir Paciente");
            System.out.println("2. Alterar Paciente");
            System.out.println("3. Excluir Paciente");
            System.out.println("4. Consultar Pacientes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Número do paciente: ");
                    int numero = scanner.nextInt();
                    System.out.print("Peso do paciente (kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Altura do paciente (m): ");
                    double altura = scanner.nextDouble();
                    controle.incluirPaciente(new Paciente(numero, peso, altura));
                }
                case 2 -> {
                    System.out.print("Número do paciente a alterar: ");
                    int numero = scanner.nextInt();
                    System.out.print("Novo peso (kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Nova altura (m): ");
                    double altura = scanner.nextDouble();
                    controle.alterarPaciente(numero, peso, altura);
                }
                case 3 -> {
                    System.out.print("Número do paciente a excluir: ");
                    int numero = scanner.nextInt();
                    controle.excluirPaciente(numero);
                }
                case 4 -> controle.listarPacientes();
                case 5 -> {
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
