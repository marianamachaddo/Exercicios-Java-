package model;

public class Treinador extends Funcionario implements Treina {
    public Treinador(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public void ensinarTecnologia() {
        System.out.println(getNome() + " está ensinando novas tecnologias.");
    }

    @Override
    public void motivarEquipe() {
        System.out.println(getNome() + " está motivando a equipe.");
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Treinador: " + getNome() + " - Salário: R$" + getSalario());
    }
}
