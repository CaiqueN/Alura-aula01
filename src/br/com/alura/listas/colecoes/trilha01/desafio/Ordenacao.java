package br.com.alura.listas.colecoes.trilha01.desafio;

import java.util.ArrayList;
import java.util.Collections;

public class Ordenacao {
    public static void executar() {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(6);
        numeros.add(3);
        numeros.add(4);
        numeros.add(2);
        numeros.add(5);
        numeros.add(1);

        Collections.sort(numeros);

        System.out.println("Lista ordenada: " + numeros);

    }
}
