package br.com.alura.trilha02.screenmatch.aula01.desafio.principal;

import br.com.alura.trilha02.screenmatch.aula01.desafio.modelo.Carro;

public class CarroMain {
    public static void executar() {
        Carro meuCarro = new Carro();
        meuCarro.modelo = "Gol";
        meuCarro.ano = 2023;
        meuCarro.cor = "Preto";

        meuCarro.exibeFichaTecnica();

        System.out.println("Idade do carro: " + meuCarro.calculaIdade() + " anos");
    }
}
