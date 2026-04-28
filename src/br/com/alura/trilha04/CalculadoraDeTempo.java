package br.com.alura.trilha04;

import br.com.alura.trilha03.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public void inclui(Titulo titulo) {
        tempoTotal += titulo.getDuracaoEmMinutos();
    }

    public int getTempoTotal() {
        return tempoTotal;
    }
}
