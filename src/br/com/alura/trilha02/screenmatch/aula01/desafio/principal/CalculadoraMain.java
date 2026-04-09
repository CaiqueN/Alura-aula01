package br.com.alura.trilha02.screenmatch.aula01.desafio.principal;

import br.com.alura.trilha02.screenmatch.aula01.desafio.modelo.Calculadora;

public class CalculadoraMain {
    public static void executar() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.dobroNumero(7);
        System.out.println(resultado);
    }
}
