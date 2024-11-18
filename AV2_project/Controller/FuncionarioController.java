package controller;

import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private final String arquivo = "funcionarios.txt";
    private final List<Funcionario> funcionarios = new ArrayList<>();

    public FuncionarioController() {
        carregarDados();
    }

    public int gerarId() {
        int maiorId = 0;
        for (Funcionario f : funcionarios) {
            if (f.getId() > maiorId) {
                maiorId = f.getId();
            }
        }
        return maiorId + 1;
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        salvarDados();
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public void atualizarFuncionario(int id, String nome, double salario) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                f.setNome(nome);
                f.setSalario(salario);
                salvarDados();
                return;
            }
        }
        System.out.println("Funcionário com ID " + id + " não encontrado.");
    }

    public void removerFuncionario(int id) {
        funcionarios.removeIf(f -> f.getId() == id);
        salvarDados();
    }

    private void salvarDados() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Funcionario f : funcionarios) {
                bw.write(f.getId() + ";" + f.getClass().getSimpleName() + ";" + f.getNome() + ";" + f.getSalario());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    private void carregarDados() {
        File file = new File(arquivo);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo: " + e.getMessage());
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                int id = Integer.parseInt(dados[0]);
                String tipo = dados[1];
                String nome = dados[2];
                double salario = Double.parseDouble(dados[3]);

                switch (tipo) {
                    case "Desenvolvedor":
                        funcionarios.add(new Desenvolvedor(id, nome, salario));
                        break;
                    case "Gerente":
                        funcionarios.add(new Gerente(id, nome, salario));
                        break;
                    case "Treinador":
                        funcionarios.add(new Treinador(id, nome, salario));
                        break;
                    case "GerenteDesenvolvedor":
                        funcionarios.add(new GerenteDesenvolvedor(id, nome, salario));
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        }
    }
}
