package br.com.alura.listas.colecoes.trilha01.atividade3;

import br.com.alura.listas.colecoes.trilha01.atividade2.Produto;

public class ProdutoPerecivel extends Produto {
    private String dataGarantia;


    public ProdutoPerecivel(String jogo, double preco, int quantidade,String dataGarantia) {
        super(jogo, preco, quantidade);
    }
}
