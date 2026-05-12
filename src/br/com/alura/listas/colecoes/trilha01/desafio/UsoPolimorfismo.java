package br.com.alura.listas.colecoes.trilha01.desafio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UsoPolimorfismo {
    public static void executar() {
        List <String> listaPolimorfismo;

        listaPolimorfismo = new ArrayList<>();
        listaPolimorfismo.add("Letra B");
        listaPolimorfismo.add("Letra A");
        System.out.println("ArrayList: " + listaPolimorfismo);

        Collections.sort(listaPolimorfismo);
        System.out.println("Lista ordenada " + listaPolimorfismo);

        listaPolimorfismo = new LinkedList<>();
        listaPolimorfismo.add("Letra C");
        listaPolimorfismo.add("Letra D");

        System.out.println("LinkedList: " + listaPolimorfismo);

    }
}
