package java_trilha_02.aula01;

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

