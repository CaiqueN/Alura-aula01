package br.com.alura.trilha04.aula;

public class ServidoDois extends Item {
    private int quantidadeHors;

    public double calculaImposto() {
        //serviço tem 12% de imposto:
        return getPreco() * 0.12;
   }
}
