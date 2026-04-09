package br.com.alura.trilha02.screenmatch.aula01.desafio.modelo;

public class Aluno {
    String nome;
    String cpf;
    String endereco;
    int idade;
    String escola;

    void exibirFichaAluno(){
        System.out.println("Caique: " + nome);
        System.out.println("Número do documento: " + cpf);
        System.out.println("Av da nações unidas número 3003: " + endereco);
        System.out.println("Idade do aluno: " + idade);
        System.out.println("Uninove: " + escola);
    }
}
