package br.com.alura.listas.colecoes.trilha01.atividade;

import br.com.alura.trilha02.screenmatch.aula01.modelo.Filme;

import java.util.ArrayList;

public class Pessoa {
    private int idade;
    private String nome;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome
                + ", idade" + idade;
    }

    public static void executar() {
        int [] idade = new int [2];
        for (int i = 0; i < idade.length; i++) {
            idade [i] = 1 + 1;
        }

        var lista = new Pessoa();
        lista.setNome("Caique");
        lista.setIdade(30);

        var lista2 = new Pessoa();
        lista2.setNome("Italo");
        lista2.setIdade(31);

        ArrayList<Pessoa> listaDePessoas = new ArrayList<>();
        listaDePessoas.add(lista);

        System.out.println("Tamanho da lista de filmes :" + listaDePessoas.size());
        System.out.println("Primeiro filme: " + listaDePessoas.get(0).getNome());
        System.out.println("Segundo filme: " + listaDePessoas.get(1).getNome());
        System.out.println(listaDePessoas);
        System.out.println("Tostring filme: " + listaDePessoas.get(0).toString());

    }
}
