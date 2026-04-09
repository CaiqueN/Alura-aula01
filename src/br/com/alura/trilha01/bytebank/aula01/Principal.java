package br.com.alura.trilha01.bytebank.aula01;

import java.time.LocalDate;

public class Principal {
    public static void main (String[] args) {
        System.out.println("Bem vindo ao bytebank");

        Funcionario caique = new Funcionario("Caique", 01, LocalDate.of(1995,07,28));
        System.out.println(caique);
    }
}