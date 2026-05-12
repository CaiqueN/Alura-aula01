package br.com.alura.listas.colecoes.trilha01.arraylist;

import java.util.ArrayList;

public class TesteArrayListStrings {
    public static void executar() {
        ArrayList<String> listaStrings = new ArrayList<>();
        listaStrings.add("Naruto");
        listaStrings.add("Kakashi");
        listaStrings.add("Sasuke");

        for (String elemento : listaStrings) {
            System.out.println(elemento);
        }
    }
}
