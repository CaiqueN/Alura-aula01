package br.com.alura.trilha04.desafio;

public class TabuadaMultiplicacao implements Tabuada{
    @Override
    public void exibirTabuada(int numero) {
        System.out.println("Tabuada de multiplicação " + numero +  ":" );
        for (int i = 1; i < 10 ; i++) {
            int resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }
    }
}
