package br.com.alura.listas.colecoes.trilha01.precomedio;

import java.util.ArrayList;

public class TesteProduto2 {
    public static void executar() {
        Produto produto1 = new Produto("PS5",5000);
        Produto produto2 = new Produto("Xbox Series", 4000);

        ArrayList<Produto> listaDeProdutos = new ArrayList<>();
        listaDeProdutos.add(produto1);
        listaDeProdutos.add(produto2);

        double somaPreco = 0;
        for (Produto produto : listaDeProdutos){
            somaPreco += produto.getPreco();
        }

        double mediaPreco = somaPreco / listaDeProdutos.size();
        System.out.println("Preço médio dos produtos: " + mediaPreco);

    }
}
