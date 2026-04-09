package br.com.alura.trilha01.bytebank.aula02.desafio;

public class PrecoOriginal {
    public static void main(String[] args) {
        double precoOriginal = 250.01;
        double percentualDesconto = 10.0;
        double valorDesconto = (percentualDesconto / 100 ) * precoOriginal;
        double novoValor = valorDesconto - precoOriginal;

        System.out.println("Preço original: R$" + precoOriginal);
        System.out.println("Desconto: R$" + valorDesconto);
        System.out.println("Novo preço com desconto: R$" + novoValor);
    }
}
