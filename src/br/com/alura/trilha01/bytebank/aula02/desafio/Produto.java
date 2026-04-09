package br.com.alura.trilha01.bytebank.aula02.desafio;

public class Produto {
    public static void main(String[] args) {
        double precoDouble = 31.99;
        int quantidade = 3;

        double total = precoDouble * quantidade;
        String mensagem = "O valor total da compra é R$" + total;

        System.out.println(mensagem);
    }
}
