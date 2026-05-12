package br.com.alura.listas.colecoes.trilha01.desafio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InterfaceArrayList {
    public static void executar () {
        List<String> listaArrayList = new ArrayList<>();
        listaArrayList.add("Elemento 1");
        listaArrayList.add("Elemento 2");

        List<String> listaLinkedList = new LinkedList<>();
        listaLinkedList.add("Elemento A");
        listaLinkedList.add("Elemento B");

        System.out.println("ArrayList: " + listaArrayList);
        System.out.println("LinkedList: " + listaLinkedList);
    }
}
