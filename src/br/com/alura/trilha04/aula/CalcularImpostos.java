package br.com.alura.trilha04.aula;

public class CalcularImpostos {
    private double totalImposto = 0;

    public void calcularImposto (TributavelDois tributavelDois) {
        totalImposto += tributavelDois.calcularImpostos();
    }

}
