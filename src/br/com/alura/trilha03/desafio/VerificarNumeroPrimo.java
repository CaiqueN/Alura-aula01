package br.com.alura.trilha03.desafio;

public class VerificarNumeroPrimo extends NumeroPrimo {
    public void verificarNumeroPrimo (int numero) {
        if (verificarPrimalidade(numero)){
            System.out.println("Número " + numero + " é primo");
        }else {
            System.out.println("Número " + numero + " não é primo");
        }
    }
}
