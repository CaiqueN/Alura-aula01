package br.com.alura.listas.colecoes.trilha01.produto;

import java.util.ArrayList;

public class TesteProduto {
    public static void executar() {

        ArrayList<Produto> lista = new ArrayList<>();
        Produto produto1 = new Produto("Resident evil requiem",399.99, 1);
        Produto produto2 = new Produto("Resident evil 4 Remake", 199.99, 1);

        lista.add(produto1);
        lista.add(produto2);

        System.out.println("Tamanho da lista: " + lista.size());
        System.out.println("Produto da lista: " + lista.get(0).getJogo());
        System.out.println("Produto da lista: " + lista.get(1).getJogo());

        ArrayList<Produto> listaProdutos = new ArrayList<>();
        for (Produto produto : listaProdutos){
            System.out.println(produto);
        }

    }

}
