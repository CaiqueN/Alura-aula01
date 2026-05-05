package br.com.alura.listas.colecoes.trilha01.atividade8;

import java.util.ArrayList;

public class TestarForma {
    public static void executar() {
        Circulo circulo = new Circulo();
        circulo.raio = 7;

        Quadrado quadrado = new Quadrado();
        quadrado.lado = 6;

        ArrayList<Forma> listaDeFormas = new ArrayList<>();
        listaDeFormas.add(circulo);
        listaDeFormas.add(quadrado);

        for (Forma forma : listaDeFormas){
            System.out.println("Area: " + forma.calcularArea());
        }
    }
}
