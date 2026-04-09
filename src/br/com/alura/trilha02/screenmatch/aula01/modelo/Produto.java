package br.com.alura.trilha02.screenmatch.aula01.modelo;

public class Produto {
    String nome;
    double preco;
    double descontoParaPix;

    double pegaPrecoFinal(boolean pagamentoViaPix) {
        double precoFinal;

        if (pagamentoViaPix) {
            precoFinal = preco - descontoParaPix;
        } else {
            precoFinal = preco;
        }

        return precoFinal;
    }

}

